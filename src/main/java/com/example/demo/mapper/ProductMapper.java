package com.example.demo.mapper;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product mapToEntity(ProductDto productDto) {

        Product product = new Product();
        product.setAuthor(productDto.getAuthor());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        return product;
    }


    public ProductDto mapToDto(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setAuthor(product.getAuthor());
        productDto.setId(product.getId());
        productDto.setTitle(product.getTitle());
        productDto.setPrice(product.getPrice());
        productDto.setDescription(product.getDescription());

        return productDto;

    }
}
