package com.qsspy.TAIbackend.controllers;

import com.qsspy.TAIbackend.dtos.category.CategoryDTO;
import com.qsspy.TAIbackend.dtos.category.CategoryIdentifiedDTO;
import com.qsspy.TAIbackend.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDTO> getProduct(
            @PathVariable int categoryId
    ) throws Exception {
        return new ResponseEntity<>(categoryService.getCategory(categoryId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CategoryIdentifiedDTO>> getCategories() {

        return new ResponseEntity<>(categoryService.getCategories(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addCategory(
            @RequestBody CategoryDTO categoryDTO
    ) {
        categoryService.addCategory(categoryDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> editCategory(
            @RequestBody CategoryIdentifiedDTO categoryIdentifiedDTO
    ) throws Exception {
        categoryService.editCategory(categoryIdentifiedDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<?> deleteCategory(
            @PathVariable int categoryId
    ) {
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
