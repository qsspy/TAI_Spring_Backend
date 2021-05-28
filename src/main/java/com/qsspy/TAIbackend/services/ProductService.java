package com.qsspy.TAIbackend.services;

import com.qsspy.TAIbackend.dtos.product.ProductDTO;
import com.qsspy.TAIbackend.dtos.product.ProductIdentifiedDTO;
import com.qsspy.TAIbackend.entities.Product;

import java.util.List;


public interface ProductService {

    ProductDTO getProduct(long id) throws Exception;
    List<ProductIdentifiedDTO> getProducts();
    void addProduct(ProductDTO product);
    void editProduct(ProductIdentifiedDTO product) throws Exception;
    void deleteProduct(long id);
}
