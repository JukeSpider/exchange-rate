package juke.com.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "exchange_rate")
@Entity
public class ExchangeRateEntity extends LongBaseEntity {

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "currency_1", nullable = false)
  private CurrencyEntity currency1;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "currency_2", nullable = false)
  private CurrencyEntity currency2;

  @Column(name = "rate", nullable = false)
  private Double rate;

  @Column(name = "date", nullable = false)
  private LocalDate date;
}