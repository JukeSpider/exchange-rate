package juke.com.service.impl;

import java.util.List;
import juke.com.dto.CurrencyDto;
import juke.com.entity.CurrencyEntity;
import juke.com.mapper.ICurrencyMapper;
import juke.com.repository.ICurrencyRepository;
import juke.com.service.ICurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CurrencyServiceImpl implements ICurrencyService {

  private final ICurrencyRepository repository;
  private final ICurrencyMapper mapper;

  @Override
  public CurrencyDto findByCode(String code) {
    CurrencyEntity entity = repository.findByCode(code);
    return mapper.mapToDto(entity);
  }

  @Override
  public List<CurrencyDto> findAll() {
    List<CurrencyEntity> entityList = repository.findAll();
    return mapper.mapToDtoList(entityList);
  }

  @Override
  public CurrencyDto save(CurrencyDto dto) {
    CurrencyEntity entity = mapper.mapToEntity(dto);
    repository.save(entity);
    return mapper.mapToDto(entity);
  }
}