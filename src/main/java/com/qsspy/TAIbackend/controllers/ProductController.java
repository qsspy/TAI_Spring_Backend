package com.qsspy.TAIbackend.controllers;

import com.qsspy.TAIbackend.dtos.product.ProductDTO;
import com.qsspy.TAIbackend.dtos.product.ProductIdentifiedDTO;
import com.qsspy.TAIbackend.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDTO> getProduct(
            @PathVariable int productId
    ) throws Exception {
        return new ResponseEntity<>(productService.getProduct(productId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductIdentifiedDTO>> getProducts(
            @RequestParam(required = false) Integer categoryId
    ) {

        return new ResponseEntity<>(productService.getProducts(categoryId),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addProduct(
            @RequestBody ProductDTO productDTO
    ) {
        productService.addProduct(productDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity editProduct(
            @RequestBody ProductIdentifiedDTO productIdentifiedDTO
    ) throws Exception {
        productService.editProduct(productIdentifiedDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity deleteCategory(
            @PathVariable int productId
    ) {
        productService.deleteProduct(productId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
