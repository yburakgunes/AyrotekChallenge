package com.ayrotek.mapper;

import com.ayrotek.dto.request.CreateTaxRateRequestDto;
import com.ayrotek.dto.request.UpdateTaxRateRequestDto;
import com.ayrotek.repository.entity.TaxRate;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE , componentModel = "spring")
public interface TaxRateMapper {

    TaxRate fromCreateTaxRate(CreateTaxRateRequestDto dto);
    TaxRate fromUpdateTaxRate(UpdateTaxRateRequestDto dto);

}
