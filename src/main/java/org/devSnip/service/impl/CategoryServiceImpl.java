package org.devSnip.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.devSnip.dto.CategoryDto;
import org.devSnip.entity.Category;
import org.devSnip.repository.CategoryRepository;
import org.devSnip.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final ObjectMapper mapper;
    private final CategoryRepository categoryRepository;

    @Override
    @Transactional
    public void addCategory( CategoryDto categoryDto) {
        Category category = mapper.convertValue(categoryDto, Category.class);
        categoryRepository.save(category);
    }

    @Override
    @Transactional
    public Category updateCategory(Integer id, CategoryDto categoryDto) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        if (categoryDto.getName()!=null){
            category.setName(categoryDto.getName());
        }
        return categoryRepository.save(category);
    }

    @Override
    public CategoryDto viewCategory(Integer id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        CategoryDto categoryDto = mapper.convertValue(category, CategoryDto.class);
        return categoryDto;
    }

    @Override
    public List<CategoryDto> viewAllCategory() {
        List <Category> categoryList = categoryRepository.findAll();
        List <CategoryDto> categoryDtoList = new ArrayList<>();

        categoryList.forEach(entity -> {
            CategoryDto categoryDto = mapper.convertValue(entity, CategoryDto.class);
            categoryDtoList.add(categoryDto);
        });
        return categoryDtoList;
    }

    @Override
    @Transactional
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }
}
