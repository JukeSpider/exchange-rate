package juke.com.service;

import java.util.List;
import juke.com.dto.CurrencyDto;

public interface ICurrencyService {

  CurrencyDto findByCode(String code);

  List<CurrencyDto> findAll();

  CurrencyDto save(CurrencyDto dto);
}