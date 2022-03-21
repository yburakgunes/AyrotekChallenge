package com.ayrotek.mapper;

import com.ayrotek.dto.request.CreateProductRequestDto;
import com.ayrotek.dto.request.UpdateProductRequestDto;
import com.ayrotek.repository.entity.Product;
import com.ayrotek.repository.entity.Product.ProductBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-21T10:02:17+0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.1.jar, environment: Java 16.0.2 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product createToProduct(CreateProductRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        ProductBuilder product = Product.builder();

        product.name( dto.getName() );
        product.description( dto.getDescription() );
        product.category( dto.getCategory() );
        product.price( dto.getPrice() );
        product.priceWithTax( dto.getPriceWithTax() );

        return product.build();
    }

    @Override
    public Product updateToProduct(UpdateProductRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        ProductBuilder product = Product.builder();

        product.id( dto.getId() );
        product.name( dto.getName() );
        product.description( dto.getDescription() );
        product.category( dto.getCategory() );
        product.price( dto.getPrice() );
        product.priceWithTax( dto.getPriceWithTax() );

        return product.build();
    }
}
