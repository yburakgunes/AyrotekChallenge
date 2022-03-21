package com.ayrotek.repository;

import com.ayrotek.repository.entity.TaxRate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ITaxRateRepository extends MongoRepository<TaxRate,String> {
    TaxRate findTaxRatesByCategory(int category);
}
