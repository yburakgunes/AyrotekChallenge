package com.ayrotek.manager;

import com.ayrotek.dto.request.CreateProductRequestDto;
import com.ayrotek.dto.request.UpdateProductRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "localhost:8081/v1/taxRate", name = "profileFeignClient", decode404 = true)
public interface TaxRateManager {

    @PostMapping("/calculatePriceWithTax")
    public ResponseEntity<Double> calculatePriceWithTax(@RequestBody CreateProductRequestDto dto);

    @PutMapping("/updatePriceWithTax")
    public ResponseEntity<Double> updatePriceWithTax(@RequestBody UpdateProductRequestDto dto);


}
