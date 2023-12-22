package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class CategoryDto {
    private Long id;
    @Size(min = 2, max = 50, message = "category name should be less than 50 characters")
    private String name;
    @NotNull
    private String description;
}
