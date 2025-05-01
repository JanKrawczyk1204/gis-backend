package com.template.productservice.translator;

import com.template.productservice.entity.Category;
import com.template.productservice.entity.CategoryDTO;
import org.springframework.stereotype.Component;

@Component
public class CategoryToCategoryDTO {

    public CategoryDTO toCategoryDTO(Category category) {
        CategoryDTO dto = new CategoryDTO();
        dto.setName(category.getName());
        dto.setShortId(category.getShortId());
        return dto;
    }
}
