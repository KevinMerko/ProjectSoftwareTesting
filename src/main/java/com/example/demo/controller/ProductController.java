package com.example.demo.controller;

import com.example.demo.dto.ProductDto;
import com.example.demo.services.ProductServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {
    private ProductServices productServices;
    @PostMapping("/save")
    public ResponseEntity<ProductDto> save(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(productServices.save(productDto), HttpStatus.CREATED);
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<ProductDto>> findAll(){ return ResponseEntity.ok(productServices.findAll());}

    @GetMapping("/{studentId}")
    public ResponseEntity<ProductDto> findById(@PathVariable("productId")long productId){
        return ResponseEntity.ok(productServices.findById(productId));
    }
}
