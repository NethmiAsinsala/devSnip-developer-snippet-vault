package org.devSnip.service;

import org.devSnip.dto.CategoryDto;
import org.devSnip.entity.Category;

import java.util.List;

public interface CategoryService {
    void addCategory(CategoryDto categoryDto);
    Category updateCategory(Integer id, CategoryDto categoryDto);
    CategoryDto viewCategory(Integer id);
    List<CategoryDto> viewAllCategory( );
    void deleteCategory(Integer id);
}
