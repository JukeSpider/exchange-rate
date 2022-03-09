package juke.com.controller;

import java.util.List;
import juke.com.dto.ExchangeRateDto;
import juke.com.service.impl.ExchangeRateServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/")
@RestController
public class ExchangeRateController {

  private final ExchangeRateServiceImpl service;

  @GetMapping("/all")
  public ResponseEntity<List<ExchangeRateDto>> findAll() {
    return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
  }

  @GetMapping("/{code1}/{code2}/{date}")
  public ResponseEntity<ExchangeRateDto> findByCurrenciesAndDate(
      @PathVariable String code1,
      @PathVariable String code2,
      @PathVariable String date
      ) {
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(service.findByCurrenciesAndDate(code1, code2, date));
  }
}