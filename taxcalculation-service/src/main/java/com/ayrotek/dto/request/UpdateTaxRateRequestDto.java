package com.ayrotek.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UpdateTaxRateRequestDto {
    private String id;
    private int category;
    private String categoryName;
    private int ratio;
}
