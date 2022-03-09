package juke.com.dto.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DailyExchangeRate {

  @JsonProperty("Date")
  private String date;

  @JsonProperty("PreviousDate")
  private String previousDate;

  @JsonProperty("PreviousURL")
  private String previousURL;

  @JsonProperty("Timestamp")
  private String timestamp;

  @JsonProperty("Valute")
  private ListOfCurrencies currency;
}