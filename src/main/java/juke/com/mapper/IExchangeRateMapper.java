package juke.com.mapper;

import juke.com.dto.ExchangeRateDto;
import juke.com.entity.ExchangeRateEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IExchangeRateMapper extends IBaseMapper<ExchangeRateEntity, ExchangeRateDto> {

}