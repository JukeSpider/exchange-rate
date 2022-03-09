package juke.com.repository;

import java.time.LocalDate;
import juke.com.entity.CurrencyEntity;
import juke.com.entity.ExchangeRateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExchangeRateRepository extends JpaRepository<ExchangeRateEntity, Long> {

  ExchangeRateEntity findByCurrency1AndCurrency2AndDate(
      CurrencyEntity currency1,
      CurrencyEntity currency2,
      LocalDate date
  );
}