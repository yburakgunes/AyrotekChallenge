package com.ayrotek.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UpdateProductRequestDto {
    private long id;
    private String name;
    private String description;
    private int category;
    private double price;
    private double priceWithTax;
}
