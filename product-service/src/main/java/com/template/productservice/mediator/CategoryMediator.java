package com.template.productservice.mediator;

import com.template.productservice.entity.CategoryDTO;
import com.template.productservice.exceptions.ObjectExistInDBException;
import com.template.productservice.service.CategoryService;
import com.template.productservice.translator.CategoryToCategoryDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryMediator {
    private final CategoryService categoryService;
    private final CategoryToCategoryDTO categoryToCategoryDTO;

    public CategoryMediator(CategoryService categoryService, CategoryToCategoryDTO categoryToCategoryDTO) {
        this.categoryService = categoryService;
        this.categoryToCategoryDTO = categoryToCategoryDTO;
    }

    public ResponseEntity<List<CategoryDTO>> getCategory() {
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        categoryService.getCategory().forEach(value->{
            categoryDTOS.add(categoryToCategoryDTO.toCategoryDTO(value));
        });
        return ResponseEntity.ok(categoryDTOS);
    }

    public void createCategory(CategoryDTO categoryDTO) throws ObjectExistInDBException {
        categoryService.create(categoryDTO);
    }
}
