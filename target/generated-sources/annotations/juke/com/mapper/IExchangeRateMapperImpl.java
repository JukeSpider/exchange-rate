package juke.com.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import juke.com.dto.CurrencyDto;
import juke.com.dto.ExchangeRateDto;
import juke.com.dto.ExchangeRateDto.ExchangeRateDtoBuilder;
import juke.com.entity.CurrencyEntity;
import juke.com.entity.ExchangeRateEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-08T21:45:27+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class IExchangeRateMapperImpl implements IExchangeRateMapper {

    @Override
    public ExchangeRateDto mapToDto(ExchangeRateEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ExchangeRateDtoBuilder exchangeRateDto = ExchangeRateDto.builder();

        exchangeRateDto.id( entity.getId() );
        exchangeRateDto.currency1( currencyEntityToCurrencyDto( entity.getCurrency1() ) );
        exchangeRateDto.currency2( currencyEntityToCurrencyDto( entity.getCurrency2() ) );
        exchangeRateDto.rate( entity.getRate() );
        exchangeRateDto.date( entity.getDate() );

        return exchangeRateDto.build();
    }

    @Override
    public ExchangeRateEntity mapToEntity(ExchangeRateDto dto) {
        if ( dto == null ) {
            return null;
        }

        ExchangeRateEntity exchangeRateEntity = new ExchangeRateEntity();

        exchangeRateEntity.setId( dto.getId() );
        exchangeRateEntity.setCurrency1( currencyDtoToCurrencyEntity( dto.getCurrency1() ) );
        exchangeRateEntity.setCurrency2( currencyDtoToCurrencyEntity( dto.getCurrency2() ) );
        exchangeRateEntity.setRate( dto.getRate() );
        exchangeRateEntity.setDate( dto.getDate() );

        return exchangeRateEntity;
    }

    @Override
    public List<ExchangeRateDto> mapToDtoList(List<ExchangeRateEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ExchangeRateDto> list = new ArrayList<ExchangeRateDto>( entityList.size() );
        for ( ExchangeRateEntity exchangeRateEntity : entityList ) {
            list.add( mapToDto( exchangeRateEntity ) );
        }

        return list;
    }

    @Override
    public List<ExchangeRateEntity> mapToEntityList(List<ExchangeRateDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<ExchangeRateEntity> list = new ArrayList<ExchangeRateEntity>( dtoList.size() );
        for ( ExchangeRateDto exchangeRateDto : dtoList ) {
            list.add( mapToEntity( exchangeRateDto ) );
        }

        return list;
    }

    protected CurrencyDto currencyEntityToCurrencyDto(CurrencyEntity currencyEntity) {
        if ( currencyEntity == null ) {
            return null;
        }

        CurrencyDto currencyDto = new CurrencyDto();

        currencyDto.setId( currencyEntity.getId() );
        currencyDto.setCode( currencyEntity.getCode() );
        currencyDto.setName( currencyEntity.getName() );

        return currencyDto;
    }

    protected CurrencyEntity currencyDtoToCurrencyEntity(CurrencyDto currencyDto) {
        if ( currencyDto == null ) {
            return null;
        }

        CurrencyEntity currencyEntity = new CurrencyEntity();

        currencyEntity.setId( currencyDto.getId() );
        currencyEntity.setCode( currencyDto.getCode() );
        currencyEntity.setName( currencyDto.getName() );

        return currencyEntity;
    }
}
