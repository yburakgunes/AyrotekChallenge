package com.ayrotek.dto.response;

import com.ayrotek.repository.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GetProductResponseDto {
    private long id;
    private String name;
    private String description;
    private int category;
    private double price;
    private double priceWithTax;
    private long userId;
    private Date creationDate;

    public GetProductResponseDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.category = product.getCategory();
        this.price = product.getPrice();
        this.priceWithTax = product.getPriceWithTax();
        if(product.getUser()!=null) {
            this.userId=product.getUser().getId();
        }
        this.creationDate = product.getCreationDate();
    }
}
