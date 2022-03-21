package com.ayrotek.mapper;

import com.ayrotek.dto.request.CreateProductRequestDto;
import com.ayrotek.dto.request.UpdateProductRequestDto;
import com.ayrotek.repository.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProductMapper {
    Product createToProduct (CreateProductRequestDto dto);
    Product updateToProduct (UpdateProductRequestDto dto);
}
