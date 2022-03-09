package juke.com;

import juke.com.dto.CurrencyDto;
import juke.com.service.impl.CurrencyServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExchangeRateApplication {

  public static void main(String[] args) {
    SpringApplication.run(ExchangeRateApplication.class, args);
  }

  @Bean
  CommandLineRunner runner(CurrencyServiceImpl service) {
    return args -> {
      service.save(new CurrencyDto("AUD", "Австралийский доллар"));
      service.save(new CurrencyDto("AZN", "Азербайджанский манат"));
      service.save(new CurrencyDto("GBP", "Фунт стерлингов Соединенного королевства"));
      service.save(new CurrencyDto("AMD", "Армянский драм"));
      service.save(new CurrencyDto("BYN", "Белорусский рубль"));
      service.save(new CurrencyDto("BGN", "Болгарский лев"));
      service.save(new CurrencyDto("BRL", "Бразильский реал"));
      service.save(new CurrencyDto("HUF", "Венгерский форинт"));
      service.save(new CurrencyDto("HKD", "Гонконгский доллар"));
      service.save(new CurrencyDto("DKK", "Датская крона"));
      service.save(new CurrencyDto("USD", "Доллар США"));
      service.save(new CurrencyDto("EUR", "Евро"));
      service.save(new CurrencyDto("INR", "Индийских рупий"));
      service.save(new CurrencyDto("KZT", "Казахстанский тенге"));
      service.save(new CurrencyDto("CAD", "Канадский доллар"));
      service.save(new CurrencyDto("KGS", "Киргизский сом"));
      service.save(new CurrencyDto("CNY", "Китайский юань"));
      service.save(new CurrencyDto("MDL", "Молдавский лей"));
      service.save(new CurrencyDto("NOK", "Норвежская крона"));
      service.save(new CurrencyDto("PLN", "Польский злотый"));
      service.save(new CurrencyDto("RON", "Румынский лей"));
      service.save(new CurrencyDto("XDR", "СДР (специальные права заимствования)"));
      service.save(new CurrencyDto("SGD", "Сингапурский доллар"));
      service.save(new CurrencyDto("TJS", "Таджикский сомони"));
      service.save(new CurrencyDto("TRY", "Турецкий лир"));
      service.save(new CurrencyDto("TMT", "Новый туркменский манат"));
      service.save(new CurrencyDto("UZS", "Узбекский сум"));
      service.save(new CurrencyDto("UAH", "Украинская гривна"));
      service.save(new CurrencyDto("CZK", "Чешская крона"));
      service.save(new CurrencyDto("SEK", "Шведская крона"));
      service.save(new CurrencyDto("CHF", "Швейцарский франк"));
      service.save(new CurrencyDto("ZAR", "Южноафриканский рэнд"));
      service.save(new CurrencyDto("KRW", "Вон Республики Корея"));
      service.save(new CurrencyDto("JPY", "Японская йена"));
//      service.save(new CurrencyDto("RUB", "Российский рубль"));
    };
  }
}