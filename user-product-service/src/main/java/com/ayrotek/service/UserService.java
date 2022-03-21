package com.ayrotek.service;

import com.ayrotek.dto.request.CreateProductRequestDto;
import com.ayrotek.dto.request.CreateUserRequestDto;
import com.ayrotek.dto.request.UpdateProductRequestDto;
import com.ayrotek.dto.request.UpdateUserRequestDto;
import com.ayrotek.manager.TaxRateManager;
import com.ayrotek.mapper.ProductMapper;
import com.ayrotek.mapper.UserMapper;
import com.ayrotek.repository.IProductRepository;
import com.ayrotek.repository.IUserRepository;
import com.ayrotek.repository.entity.Product;
import com.ayrotek.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final IUserRepository userRepository;
    private final IProductRepository productRepository;
    private final UserMapper userMapper;
    private final ProductMapper productMapper;
    private final TaxRateManager taxRateManager;


    public User saveUser(CreateUserRequestDto dto){
        User user = userMapper.createToUser(dto);
        return userRepository.save(user);
    }

    public User findUserById(long id){
        Optional<User> dbUser = userRepository.findById(id);
        if(dbUser.isEmpty()){
            throw new EntityNotFoundException("Unable to find user information" + id);
        }
        return dbUser.get();
    }

    public User updateUser(UpdateUserRequestDto dto){
        User user = findUserById(dto.getId());
        user = userMapper.updateToUser(dto);
        user.setCreationDate(new Date(System.currentTimeMillis()));
        return userRepository.save(user);
    }

    public String deleteUser(long id){
        userRepository.delete(findUserById(id));
        return "User information has been deleted successfully";
    }

    public List<User> listAllUsers(){
        return userRepository.findAll();
    }

    public String addNewProduct(long id, CreateProductRequestDto dto){
        User user = findUserById(id);
        Product product = productMapper.createToProduct(dto);
        product.setPriceWithTax(taxRateManager.calculatePriceWithTax(dto).getBody());
        product.setUser(user);
        user.getProductList().add(product);
        productRepository.save(product);
        return "New product has been added successfully";
    }
    public String updateProduct(long id, UpdateProductRequestDto dto){
        User user = findUserById(id);
        Product product = productMapper.updateToProduct(dto);
        product.setPriceWithTax(taxRateManager.updatePriceWithTax(dto).getBody());
        product.setCreationDate(new Date(System.currentTimeMillis()));
        product.setUser(user);
        user.getProductList().add(product);
        productRepository.save(product);
        return "Product has been updated successfully";
    }

    public List<Product> listAllProducts(long id){
        return findUserById(id).getProductList();
    }




}
