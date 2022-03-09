package juke.com.service;

import java.util.List;
import juke.com.dto.ExchangeRateDto;

public interface IExchangeRateService {

  List<ExchangeRateDto> findAll();

  ExchangeRateDto findByCurrenciesAndDate(
      String currency1,
      String currency2,
      String date
  );
}