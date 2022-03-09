package juke.com.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import juke.com.dto.ExchangeRateDto;
import juke.com.dto.json.CurrencyCode;
import juke.com.dto.json.DailyExchangeRate;
import juke.com.dto.json.ListOfCurrencies;
import juke.com.entity.CurrencyEntity;
import juke.com.entity.ExchangeRateEntity;
import juke.com.mapper.ICurrencyMapper;
import juke.com.mapper.IExchangeRateMapper;
import juke.com.repository.ICurrencyRepository;
import juke.com.repository.IExchangeRateRepository;
import juke.com.service.IExchangeRateService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class ExchangeRateServiceImpl implements IExchangeRateService {

  private final ICurrencyRepository currencyRepository;
  private final IExchangeRateRepository exchangeRateRepository;
  private final ICurrencyMapper currencyMapper;
  private final IExchangeRateMapper exchangeRateMapper;
  private final CurrencyServiceImpl currencyService;

  @Override
  public List<ExchangeRateDto> findAll() {
    List<ExchangeRateEntity> entityList = exchangeRateRepository.findAll();
    return exchangeRateMapper.mapToDtoList(entityList);
  }

  @Override
  public ExchangeRateDto findByCurrenciesAndDate(String code1, String code2, String date) {

    LocalDate localDate = LocalDate.parse(date);

    CurrencyEntity currency1 = currencyRepository.findByCode(code1);
    CurrencyEntity currency2 = currencyRepository.findByCode(code2);

    if (currency1 == null) {
      throw new IllegalArgumentException(code1);
    }

    if (currency2 == null) {
      throw new IllegalArgumentException(code2);
    }

    ExchangeRateEntity exchangeRateEntity =
        exchangeRateRepository.findByCurrency1AndCurrency2AndDate(currency1, currency2, localDate);

    if (exchangeRateEntity == null) {
      saveDailyExchangeRate(date);
      exchangeRateEntity = exchangeRateRepository
          .findByCurrency1AndCurrency2AndDate(currency1, currency2, localDate);
    }

    return exchangeRateMapper.mapToDto(exchangeRateEntity);
  }

  private ExchangeRateDto save(ExchangeRateDto dto) {
    ExchangeRateEntity entity = exchangeRateMapper.mapToEntity(dto);
    exchangeRateRepository.save(entity);
    return dto;
  }

  private void saveDailyExchangeRate(String date) {
    LocalDate localDate = LocalDate.parse(date);
    DailyExchangeRate dailyExchangeRate = getDailyExchangeRate(date);
    List<CurrencyCode> codes = getAllCurrencyNominal(dailyExchangeRate);

    for (CurrencyCode code1 : codes) {
      for (CurrencyCode code2 : codes) {

        if (code1.getCharCode().equals(code2.getCharCode())) {
          continue;
        }

        CurrencyEntity currency1 = currencyRepository.findByCode(code1.getCharCode());
        CurrencyEntity currency2 = currencyRepository.findByCode(code2.getCharCode());
        Double rate = (double) (code2.getNominal() * code1.getValue()) / (code1.getNominal()
            * code2.getValue());

        ExchangeRateDto exchangeRateDto = ExchangeRateDto.builder()
            .currency1(currencyMapper.mapToDto(currency1))
            .currency2(currencyMapper.mapToDto(currency2))
            .rate(rate)
            .date(localDate)
            .build();

        save(exchangeRateDto);
      }
    }
  }

  @SneakyThrows
  private DailyExchangeRate getDailyExchangeRate(String date) {
    RestTemplate restTemplate = new RestTemplate();
    ObjectMapper objectMapper = new ObjectMapper();
    String[] localDate = date.split("-");

    String url = String.format("https://www.cbr-xml-daily.ru/archive/%s/%s/%s/daily_json.js",
        localDate[0], localDate[1], localDate[2]);

    String body = restTemplate.getForEntity(url, String.class).getBody();
    return objectMapper.readValue(body, DailyExchangeRate.class);
  }

  @SneakyThrows
  private List<CurrencyCode> getAllCurrencyNominal(DailyExchangeRate dailyExchangeRate) {

    ListOfCurrencies list = dailyExchangeRate.getCurrency();

    Class<ListOfCurrencies> currenciesClass = ListOfCurrencies.class;
    Field[] fields = currenciesClass.getDeclaredFields();
    List<CurrencyCode> codes = new ArrayList<>();

    for (Field field : fields) {
      field.setAccessible(true);
      CurrencyCode currencyCode = (CurrencyCode) field.get(list);
      codes.add(currencyCode);
    }

    return codes;
  }
}