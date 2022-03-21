package com.ayrotek.dto.response;

import com.ayrotek.repository.entity.TaxRate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GetTaxRateResponseDto {
    private String id;
    private int category;
    private String categoryName;
    private int ratio;

    public GetTaxRateResponseDto(TaxRate taxRate) {
        this.id = taxRate.getId();
        this.category = taxRate.getCategory();
        this.ratio = taxRate.getRatio();
        this.categoryName = taxRate.getCategoryName();
    }
}
