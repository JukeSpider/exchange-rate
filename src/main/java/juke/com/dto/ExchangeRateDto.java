package juke.com.dto;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ExchangeRateDto extends LongBaseDto {

  @Builder
  public ExchangeRateDto(Long id, CurrencyDto currency1, CurrencyDto currency2, Double rate,
      LocalDate date) {
    super(id);
    this.currency1 = currency1;
    this.currency2 = currency2;
    this.rate = rate;
    this.date = date;
  }

  private CurrencyDto currency1;

  private CurrencyDto currency2;

  private Double rate;

  private LocalDate date;
}