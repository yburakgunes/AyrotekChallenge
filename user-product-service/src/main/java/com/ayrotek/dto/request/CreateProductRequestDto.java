package com.ayrotek.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateProductRequestDto {
    private String name;
    private String description;
    private int category;
    private double price;
    private double priceWithTax;
}
