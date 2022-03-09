package juke.com.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import juke.com.dto.CurrencyDto;
import juke.com.entity.CurrencyEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-08T21:45:27+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class ICurrencyMapperImpl implements ICurrencyMapper {

    @Override
    public CurrencyDto mapToDto(CurrencyEntity entity) {
        if ( entity == null ) {
            return null;
        }

        CurrencyDto currencyDto = new CurrencyDto();

        currencyDto.setId( entity.getId() );
        currencyDto.setCode( entity.getCode() );
        currencyDto.setName( entity.getName() );

        return currencyDto;
    }

    @Override
    public CurrencyEntity mapToEntity(CurrencyDto dto) {
        if ( dto == null ) {
            return null;
        }

        CurrencyEntity currencyEntity = new CurrencyEntity();

        currencyEntity.setId( dto.getId() );
        currencyEntity.setCode( dto.getCode() );
        currencyEntity.setName( dto.getName() );

        return currencyEntity;
    }

    @Override
    public List<CurrencyDto> mapToDtoList(List<CurrencyEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<CurrencyDto> list = new ArrayList<CurrencyDto>( entityList.size() );
        for ( CurrencyEntity currencyEntity : entityList ) {
            list.add( mapToDto( currencyEntity ) );
        }

        return list;
    }

    @Override
    public List<CurrencyEntity> mapToEntityList(List<CurrencyDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<CurrencyEntity> list = new ArrayList<CurrencyEntity>( dtoList.size() );
        for ( CurrencyDto currencyDto : dtoList ) {
            list.add( mapToEntity( currencyDto ) );
        }

        return list;
    }
}
