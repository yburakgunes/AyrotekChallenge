package com.ayrotek.service;

import com.ayrotek.dto.request.CreateProductRequestDto;
import com.ayrotek.dto.request.CreateTaxRateRequestDto;
import com.ayrotek.dto.request.UpdateProductRequestDto;
import com.ayrotek.dto.request.UpdateTaxRateRequestDto;
import com.ayrotek.exception.DataNotFoundException;
import com.ayrotek.mapper.TaxRateMapper;
import com.ayrotek.repository.ITaxRateRepository;
import com.ayrotek.repository.entity.TaxRate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaxRateService {

    private final ITaxRateRepository repository;
    private final TaxRateMapper taxRateMapper;


    public TaxRate saveTaxRate(CreateTaxRateRequestDto dto){
        TaxRate taxrate = taxRateMapper.fromCreateTaxRate(dto);
        return repository.save(taxrate);
    }

    public TaxRate findTaxRateById(String id) {
        Optional<TaxRate> dbTaxRate= repository.findById(id);
        if(dbTaxRate.isEmpty()){
            throw new DataNotFoundException("Unable to find given item");
        }
        return dbTaxRate.get();

    }

    public TaxRate updateTaxRate(UpdateTaxRateRequestDto dto){
        TaxRate taxRate = findTaxRateById(dto.getId());
        taxRate=taxRateMapper.fromUpdateTaxRate(dto);
        return repository.save(taxRate);
    }

    public String deleteTaxRate(String id){
        repository.delete(findTaxRateById(id));
        return "Tax rate has been deleted";
    }

    public List<TaxRate> listAllTaxRate(){
        return repository.findAll();
    }

    public double calculatePriceWithTax(CreateProductRequestDto dto){
        TaxRate taxRate = repository.findTaxRatesByCategory(dto.getCategory());
        dto.setPriceWithTax(dto.getPrice() + (taxRate.getRatio()*dto.getPrice())/100);

        return dto.getPriceWithTax();

    }

    public double updatePriceWithTax(UpdateProductRequestDto dto){
        TaxRate taxRate = repository.findTaxRatesByCategory(dto.getCategory());
        dto.setPriceWithTax(dto.getPrice() + (taxRate.getRatio()*dto.getPrice())/100);

        return dto.getPriceWithTax();

    }

}
