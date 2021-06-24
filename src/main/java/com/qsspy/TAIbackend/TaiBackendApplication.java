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
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@SpringBootApplication
public class TaiBackendApplication {

	public static void main(String[] args){
		SpringApplication.run(TaiBackendApplication.class, args);
	}
}
