package com.example.demo.controller;

import com.example.demo.dto.CategoryDto;
import com.example.demo.entity.Category;
import com.example.demo.services.CategoryServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private CategoryServices categoryServices;
    @PostMapping("/save")
    public ResponseEntity<CategoryDto> save(@RequestBody CategoryDto categoryDto){
        return new ResponseEntity<>(categoryServices.save(categoryDto), HttpStatus.CREATED);
    }
    @GetMapping("/findALl")
    public ResponseEntity<List<CategoryDto>> findAll(){
        return new ResponseEntity<>(categoryServices.findAll(),HttpStatus.OK);
    }
    @GetMapping("/findById/{categoryId}")
    public ResponseEntity<CategoryDto>findById(@PathVariable("categoryId") Long categoryId){
        return ResponseEntity.ok(categoryServices.finById(categoryId));
    }
    @PutMapping("/update/{categoryId}")
    public ResponseEntity<CategoryDto> update(@PathVariable("categoryId")Long categoryId,@RequestBody CategoryDto categoryDto){
        return ResponseEntity.ok(categoryServices.update(categoryId,categoryDto));
    }
    @DeleteMapping("delete/{categoryId}")
    public ResponseEntity<String> delete(@PathVariable("categoryId")Long categoryId){
        categoryServices.delete(categoryId);

        return ResponseEntity.ok("Category with id; " +categoryId+" was successfully deleted");
    }
}
