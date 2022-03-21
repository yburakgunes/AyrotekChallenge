package com.ayrotek.controller;

import com.ayrotek.dto.request.CreateProductRequestDto;
import com.ayrotek.dto.request.CreateTaxRateRequestDto;
import com.ayrotek.dto.request.UpdateProductRequestDto;
import com.ayrotek.dto.request.UpdateTaxRateRequestDto;
import com.ayrotek.dto.response.GetTaxRateResponseDto;
import com.ayrotek.service.TaxRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/taxRate")
@RequiredArgsConstructor
public class TaxRateController {
    private final TaxRateService service;

    @PostMapping("/save")
    public ResponseEntity<GetTaxRateResponseDto> saveTaxRate(@RequestBody CreateTaxRateRequestDto dto){
        return ResponseEntity.ok(new GetTaxRateResponseDto(service.saveTaxRate(dto)));
    }

    @PutMapping("/update")
    public ResponseEntity<GetTaxRateResponseDto> updateTaxRate(@RequestBody UpdateTaxRateRequestDto dto){
        return ResponseEntity.ok(new GetTaxRateResponseDto(service.updateTaxRate(dto)));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTaxRate(@PathVariable String id){
        return ResponseEntity.ok(service.deleteTaxRate(id));
    }

    @GetMapping("/getTaxRate/{id}")
    public ResponseEntity<GetTaxRateResponseDto> getTaxRateById(@PathVariable String id){
        return ResponseEntity.ok(new GetTaxRateResponseDto(service.findTaxRateById(id)));
    }

    @PostMapping("/calculatePriceWithTax")
    public ResponseEntity<Double> calculatePriceWithTax(@RequestBody CreateProductRequestDto dto){
        return ResponseEntity.ok(service.calculatePriceWithTax(dto));
    }

    @PutMapping("/updatePriceWithTax")
    public ResponseEntity<Double> updatePriceWithTax(@RequestBody UpdateProductRequestDto dto){
        return ResponseEntity.ok(service.updatePriceWithTax(dto));
    }

    @GetMapping("/listAllTaxRates")
    public ResponseEntity<List<GetTaxRateResponseDto>> listAllTaxRate() {
        return ResponseEntity.ok(service.listAllTaxRate().stream().map(GetTaxRateResponseDto::new).collect(Collectors.toList()));
    }
}
