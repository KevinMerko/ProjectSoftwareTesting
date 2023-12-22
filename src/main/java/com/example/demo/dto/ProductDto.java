package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class ProductDto {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String author;
}
