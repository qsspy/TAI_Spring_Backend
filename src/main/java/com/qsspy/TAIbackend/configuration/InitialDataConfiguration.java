package com.qsspy.TAIbackend.configuration;

import com.qsspy.TAIbackend.dtos.category.CategoryDTO;
import com.qsspy.TAIbackend.dtos.product.ProductDTO;
import com.qsspy.TAIbackend.entities.Category;
import com.qsspy.TAIbackend.services.CategoryService;
import com.qsspy.TAIbackend.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@DependsOn({"dataSource"})
public class InitialDataConfiguration {

    private final CategoryService categoryService;
    private final ProductService productService;

    public InitialDataConfiguration(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @PostConstruct
    private void initDatabaseData() throws IOException {

        List<CategoryDTO> categoryDTOS = new ArrayList<>();

        categoryDTOS.add(new CategoryDTO("Stratocaster"));
        categoryDTOS.add(new CategoryDTO("Telecaster"));
        categoryDTOS.add(new CategoryDTO("Hollow Body"));
        categoryDTOS.add(new CategoryDTO("Single Cut"));

        categoryDTOS.forEach(categoryService::addCategory);

        List<ProductDTO> productDTOS = new ArrayList<>();

        for(int i=0;i<5;i++) {
            Category category = new Category();
            category.setId(1);
            ProductDTO product = new ProductDTO();
            product.setCategory(category);
            product.setDiscountPercent(i/10.0f);
            product.setPrice((i+1)*100);
            product.setVat(0.23f);
            product.setName("Gitara ST " + i);
            product.setShortDescription("This is TOP " + (i+1) +  " Stratocaster!");
            product.setLongDescription("This is basic long description!");

            Resource image = new ClassPathResource("/static/images/strat/strat" + (i+1) + ".jpg");
            product.setImage(image.getInputStream().readAllBytes());

            productDTOS.add(product);
        }

        for(int i=0;i<5;i++) {
            Category category = new Category();
            category.setId(2);
            ProductDTO product = new ProductDTO();
            product.setCategory(category);
            product.setDiscountPercent(i/10.0f);
            product.setPrice((i+1)*100);
            product.setVat(0.23f);
            product.setName("Gitara T " + i);
            product.setShortDescription("This is TOP " + (i+1) +  " Telecaster!");
            product.setLongDescription("This is basic long description!");

            Resource image = new ClassPathResource("/static/images/tele/tele" + (i+1) + ".jpg");
            product.setImage(image.getInputStream().readAllBytes());

            productDTOS.add(product);
        }

        for(int i=0;i<5;i++) {
            Category category = new Category();
            category.setId(3);
            ProductDTO product = new ProductDTO();
            product.setCategory(category);
            product.setDiscountPercent(i/10.0f);
            product.setPrice((i+1)*100);
            product.setVat(0.23f);
            product.setName("Gitara HB " + i);
            product.setShortDescription("This is TOP " + (i+1) +  " Hollow Body!");
            product.setLongDescription("This is basic long description!");

            Resource image = new ClassPathResource("/static/images/hollow/hollow" + (i+1) + ".jpg");
            product.setImage(image.getInputStream().readAllBytes());

            productDTOS.add(product);
        }

        for(int i=0;i<5;i++) {
            Category category = new Category();
            category.setId(4);
            ProductDTO product = new ProductDTO();
            product.setCategory(category);
            product.setDiscountPercent(i/10.0f);
            product.setPrice((i+1)*100);
            product.setVat(0.23f);
            product.setName("Gitara SC " + i);
            product.setShortDescription("This is TOP " + (i+1) +  " Single Cut!");
            product.setLongDescription("This is basic long description!");

            Resource image = new ClassPathResource("/static/images/single/single" + (i+1) + ".jpg");
            product.setImage(image.getInputStream().readAllBytes());

            productDTOS.add(product);
        }

        productDTOS.forEach(productService::addProduct);

        log.info("Initialized MySQL Data");
    }
}
