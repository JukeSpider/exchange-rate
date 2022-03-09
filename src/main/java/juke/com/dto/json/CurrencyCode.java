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
public class CurrencyCode {

  @JsonProperty("ID")
  private String id;

  @JsonProperty("NumCode")
  private String numCode;

  @JsonProperty("CharCode")
  private String charCode;

  @JsonProperty("Nominal")
  private Long nominal;

  @JsonProperty("Name")
  private String name;

  @JsonProperty("Value")
  private Long value;

  @JsonProperty("Previous")
  private String previous;
}