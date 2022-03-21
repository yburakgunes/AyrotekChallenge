package com.ayrotek.controller;

import com.ayrotek.dto.response.GetProductResponseDto;
import com.ayrotek.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/product")
public class ProductController {
    private final ProductService service;

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long id){
        return ResponseEntity.ok(service.deleteProduct(id));
    }

    @GetMapping("/listAllProducts")
    public ResponseEntity<List<GetProductResponseDto>> listAllProducts(){
        return ResponseEntity.ok().body(service.listAllProducts().stream().map(GetProductResponseDto::new).collect(Collectors.toList()));
    }

}
