package com.qsspy.TAIbackend.services;

import com.qsspy.TAIbackend.dtos.category.CategoryDTO;
import com.qsspy.TAIbackend.dtos.category.CategoryIdentifiedDTO;
import com.qsspy.TAIbackend.entities.Category;
import com.qsspy.TAIbackend.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void addCategory(CategoryDTO categoryDTO) {
        Category category = modelMapper.map(categoryDTO, Category.class);
        categoryRepository.save(category);
    }

    @Override
    public CategoryDTO getCategory(int id) {
        Optional<Category> category = categoryRepository.findById(id);

        category.orElseThrow(() -> new RuntimeException("Category with id " + id + " not found."));

        return modelMapper.map(category.get(), CategoryDTO.class);
    }

    @Override
    public List<CategoryIdentifiedDTO> getCategories() {

        return StreamSupport.stream(categoryRepository.findAll().spliterator(), false)
                .map(dto -> modelMapper.map(dto, CategoryIdentifiedDTO.class)).collect(Collectors.toList());
    }

    @Override
    public void editCategory(CategoryIdentifiedDTO categoryDTO) {
        Optional<Category> category = categoryRepository.findById(categoryDTO.getId());

        category.orElseThrow(() -> new RuntimeException("User with this id doesn't exist."));

        categoryRepository.save(modelMapper.map(categoryDTO, Category.class));
    }

    @Override
    public void deleteCategory(int id) {

        categoryRepository.deleteById(id);
    }
}
