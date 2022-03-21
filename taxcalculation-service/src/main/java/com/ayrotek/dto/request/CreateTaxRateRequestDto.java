package com.ayrotek.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateTaxRateRequestDto {
    private int category;
    private String categoryName;
    private int ratio;
}
