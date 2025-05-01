package com.template.productservice.facade;


import com.template.productservice.entity.CategoryDTO;
import com.template.productservice.entity.Response;
import com.template.productservice.exceptions.ObjectExistInDBException;
import com.template.productservice.mediator.CategoryMediator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/category")
public class CategoryController {
    private final CategoryMediator categoryMediator;

    public CategoryController(CategoryMediator categoryMediator) {
        this.categoryMediator = categoryMediator;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getCategory() {
        return categoryMediator.getCategory();
    }

    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO) {
        try {
            categoryMediator.createCategory(categoryDTO);
        } catch (ObjectExistInDBException e) {
            return ResponseEntity.status(400).body(new Response("Object exists in DB"));
        }
        return ResponseEntity.ok(new Response("Operation end Success"));
    }
}

