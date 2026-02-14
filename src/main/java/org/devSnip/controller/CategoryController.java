package org.devSnip.controller;

import lombok.RequiredArgsConstructor;
import org.devSnip.dto.CategoryDto;
import org.devSnip.entity.Category;
import org.devSnip.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {
        private final CategoryService categoryService;

        @PostMapping("/addCategory")
        public void addCategory(CategoryDto categoryDto){
            categoryService.addCategory(categoryDto);
        }

        @PutMapping("/updateCategory/{id}")
        public void updateCategory(@PathVariable Integer id , CategoryDto categoryDto){
            categoryService.updateCategory(id, categoryDto);
        }

        @GetMapping ("/{id}")
        public CategoryDto viewCategory( @PathVariable Integer id){
            return categoryService.viewCategory(id);
        }

        @GetMapping("/get-all")
        public List<CategoryDto> viewAllCategory(){
            return categoryService.viewAllCategory();
        }

        @DeleteMapping ("/delete/{id}")
        public void deleteUser(@PathVariable Integer id){
            categoryService.deleteCategory(id);
        }
}
