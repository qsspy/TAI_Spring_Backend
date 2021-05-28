package com.qsspy.TAIbackend.services;

import com.qsspy.TAIbackend.dtos.category.CategoryDTO;
import com.qsspy.TAIbackend.dtos.category.CategoryIdentifiedDTO;

import java.util.List;

public interface CategoryService {

    void addCategory(CategoryDTO category);
    CategoryDTO getCategory(int id) throws Exception;
    List<CategoryIdentifiedDTO> getCategories();
    void editCategory(CategoryIdentifiedDTO category) throws Exception;
    void deleteCategory(int id);
}
