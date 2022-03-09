package juke.com.mapper;

import juke.com.dto.CurrencyDto;
import juke.com.entity.CurrencyEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ICurrencyMapper extends IBaseMapper<CurrencyEntity, CurrencyDto> {

}