package com.ayrotek.controller;

import com.ayrotek.dto.request.CreateProductRequestDto;
import com.ayrotek.dto.request.CreateUserRequestDto;
import com.ayrotek.dto.request.UpdateProductRequestDto;
import com.ayrotek.dto.request.UpdateUserRequestDto;
import com.ayrotek.dto.response.GetProductResponseDto;
import com.ayrotek.dto.response.GetUserResponseDto;
import com.ayrotek.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/user")
public class UserController {
    private final UserService service;

    @PostMapping("/save")
    public ResponseEntity<GetUserResponseDto> saveUser(@RequestBody CreateUserRequestDto dto){
        return ResponseEntity.ok(new GetUserResponseDto(service.saveUser(dto)));
    }
    @PutMapping("/update")
    public ResponseEntity<GetUserResponseDto> updateUser(@RequestBody UpdateUserRequestDto dto){
        return ResponseEntity.ok(new GetUserResponseDto(service.updateUser(dto)));
    }
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteUser (@PathVariable long id ){
        return ResponseEntity.ok(service.deleteUser(id));
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<GetUserResponseDto> getUserById(@PathVariable long id){
        return ResponseEntity.ok(new GetUserResponseDto(service.findUserById(id)));
    }

    @PostMapping("/addNewProduct/{id}")
    public ResponseEntity<String> addNewProduct(@PathVariable long id, @RequestBody CreateProductRequestDto dto){
        return ResponseEntity.ok(service.addNewProduct(id,dto));
    }

    @PutMapping("/{id}/updateProduct")
    public ResponseEntity<String> updateProduct(@PathVariable long id, @RequestBody UpdateProductRequestDto dto){
        return ResponseEntity.ok(service.updateProduct(id,dto));
    }

    @GetMapping("/{id}/listAllProducts")
    public ResponseEntity<List<GetProductResponseDto>> listAllProductById(@PathVariable long id){
        return ResponseEntity.ok().body(service.listAllProducts(id).stream().map(GetProductResponseDto::new).collect(Collectors.toList()));

    }






}
