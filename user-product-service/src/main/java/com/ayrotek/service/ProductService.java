package com.ayrotek.service;

import com.ayrotek.repository.IProductRepository;
import com.ayrotek.repository.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final IProductRepository productRepository;

    public String deleteProduct(long id){
        productRepository.delete(findProductById(id));
        return "Product information is deleted";
    }

    public Product findProductById (long id){
        Optional <Product> dbProduct = productRepository.findById(id);
        if(dbProduct.isEmpty()) {
            throw new EntityNotFoundException("Cannot find given product information" + id);
        }
        return dbProduct.get();
    }

    public List<Product> listAllProducts(){
        return productRepository.findAll();
    }


}
