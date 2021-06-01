package com.qsspy.TAIbackend;

import com.qsspy.TAIbackend.dtos.category.CategoryDTO;
import com.qsspy.TAIbackend.dtos.product.ProductDTO;
import com.qsspy.TAIbackend.entities.Category;
import com.qsspy.TAIbackend.repositories.CategoryRepository;
import com.qsspy.TAIbackend.services.CategoryService;
import com.qsspy.TAIbackend.services.CategoryServiceImpl;
import com.qsspy.TAIbackend.services.ProductService;
import com.qsspy.TAIbackend.services.ProductServiceImpl;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootApplication
public class TaiBackendApplication {

	public static void main(String[] args) throws IOException {
		ApplicationContext context = SpringApplication.run(TaiBackendApplication.class, args);

		addInitialData(context);
	}

	private static void addInitialData(ApplicationContext context) throws IOException {

		CategoryService categoryService = context.getBean(CategoryServiceImpl.class);
		ProductService productService = context.getBean(ProductServiceImpl.class);

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
			product.setPrice(i*100);
			product.setVat(0.23f);
			product.setName("Gitara ST " + i);
			product.setShortDescription("This is TOP " + (i+1) +  " Stratocaster!");
			product.setLongDescription("This is basic long description!");

			File image = new File("src\\main\\resources\\static\\images\\strat\\strat" + (i+1) + ".jpg");
			product.setImage(Files.readAllBytes(image.toPath()));

			productDTOS.add(product);
		}

		for(int i=0;i<5;i++) {
			Category category = new Category();
			category.setId(2);
			ProductDTO product = new ProductDTO();
			product.setCategory(category);
			product.setDiscountPercent(i/10.0f);
			product.setPrice(i*100);
			product.setVat(0.23f);
			product.setName("Gitara T " + i);
			product.setShortDescription("This is TOP " + (i+1) +  " Telecaster!");
			product.setLongDescription("This is basic long description!");

			File image = new File("src\\main\\resources\\static\\images\\tele\\tele" + (i+1) + ".jpg");
			product.setImage(Files.readAllBytes(image.toPath()));

			productDTOS.add(product);
		}

		for(int i=0;i<5;i++) {
			Category category = new Category();
			category.setId(3);
			ProductDTO product = new ProductDTO();
			product.setCategory(category);
			product.setDiscountPercent(i/10.0f);
			product.setPrice(i*100);
			product.setVat(0.23f);
			product.setName("Gitara HB " + i);
			product.setShortDescription("This is TOP " + (i+1) +  " Hollow Body!");
			product.setLongDescription("This is basic long description!");

			File image = new File("src\\main\\resources\\static\\images\\hollow\\hollow" + (i+1) + ".jpg");
			product.setImage(Files.readAllBytes(image.toPath()));

			productDTOS.add(product);
		}

		for(int i=0;i<5;i++) {
			Category category = new Category();
			category.setId(4);
			ProductDTO product = new ProductDTO();
			product.setCategory(category);
			product.setDiscountPercent(i/10.0f);
			product.setPrice(i*100);
			product.setVat(0.23f);
			product.setName("Gitara SC " + i);
			product.setShortDescription("This is TOP " + (i+1) +  " Single Cut!");
			product.setLongDescription("This is basic long description!");

			File image = new File("src\\main\\resources\\static\\images\\single\\single" + (i+1) + ".jpg");
			product.setImage(Files.readAllBytes(image.toPath()));

			productDTOS.add(product);
		}

		productDTOS.forEach(productService::addProduct);

		log.info("Initialized MySQL Data");
	}
}
