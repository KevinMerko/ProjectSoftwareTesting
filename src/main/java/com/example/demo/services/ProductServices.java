package com.example.demo.services;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.repository.ProductRespository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProductServices {
    private ProductRespository productRepository;
    private ProductMapper productMapper;

    public ProductDto save(ProductDto productDto){
        Product savedProduct = productMapper.mapToEntity(productDto);
        Product product = productRepository.save(savedProduct);
        return productMapper.mapToDto(product);
    }

    public List<ProductDto> findAll(){
        List<Product> productList = productRepository.findAll();
        return productList.stream()
                .map(product -> productMapper.mapToDto(product)).collect(Collectors.toList());
    }
    public ProductDto findById(long productId){
        Optional<Product> foundProduct = productRepository.findById(productId);
        if (foundProduct.isPresent()){
            foundProduct.get();
        }else  throw new RuntimeException("Product with id:"+productId+" not found");
        return productMapper.mapToDto(foundProduct.get());
    }
    public ProductDto update(ProductDto productDto, long productId){
        Product foundProduct = productRepository.findById(productId)
                .orElseThrow(()-> new RuntimeException("Product with id"+productId+" not found"));
        foundProduct.setAuthor(productDto.getAuthor());
        foundProduct.setPrice(productDto.getPrice());
        foundProduct.setTitle(productDto.getTitle());
        foundProduct.setId(productDto.getId());
        foundProduct.setDescription(productDto.getDescription());

        Product savedProduct = productRepository.save(foundProduct);
        return productMapper.mapToDto(savedProduct);
    }
}
