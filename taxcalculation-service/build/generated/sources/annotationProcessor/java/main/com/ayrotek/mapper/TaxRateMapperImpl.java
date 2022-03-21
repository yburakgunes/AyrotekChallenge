package com.ayrotek.mapper;

import com.ayrotek.dto.request.CreateTaxRateRequestDto;
import com.ayrotek.dto.request.UpdateTaxRateRequestDto;
import com.ayrotek.repository.entity.TaxRate;
import com.ayrotek.repository.entity.TaxRate.TaxRateBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-21T10:01:57+0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.1.jar, environment: Java 16.0.2 (Oracle Corporation)"
)
@Component
public class TaxRateMapperImpl implements TaxRateMapper {

    @Override
    public TaxRate fromCreateTaxRate(CreateTaxRateRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        TaxRateBuilder taxRate = TaxRate.builder();

        taxRate.categoryName( dto.getCategoryName() );
        taxRate.category( dto.getCategory() );
        taxRate.ratio( dto.getRatio() );

        return taxRate.build();
    }

    @Override
    public TaxRate fromUpdateTaxRate(UpdateTaxRateRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        TaxRateBuilder taxRate = TaxRate.builder();

        taxRate.id( dto.getId() );
        taxRate.categoryName( dto.getCategoryName() );
        taxRate.category( dto.getCategory() );
        taxRate.ratio( dto.getRatio() );

        return taxRate.build();
    }
}
