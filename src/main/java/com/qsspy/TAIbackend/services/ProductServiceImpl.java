package com.qsspy.TAIbackend.services;

import com.qsspy.TAIbackend.dtos.product.ProductDTO;
import com.qsspy.TAIbackend.dtos.product.ProductIdentifiedDTO;
import com.qsspy.TAIbackend.entities.Product;
import com.qsspy.TAIbackend.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductDTO getProduct(long id) throws Exception {

        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()) {
            throw new Exception("Product with id " + id + " does not exist.");
        }

        return modelMapper.map(product.get(),ProductDTO.class);
    }

    @Override
    public List<ProductIdentifiedDTO> getProducts(Integer categoryId) {

        Iterable<Product> products;
        if(categoryId != null) {
            products = productRepository.findByCategoryId(categoryId);
        } else {
            products = productRepository.findAll();
        }

        return StreamSupport.stream(products.spliterator(),false)
                .map(product -> modelMapper.map(product,ProductIdentifiedDTO.class)).collect(Collectors.toList());
    }

    @Override
    public void addProduct(ProductDTO productDTO) {

        Product product = modelMapper.map(productDTO,Product.class);
        productRepository.save(product);
    }

    @Override
    public void editProduct(ProductIdentifiedDTO productDTO) throws Exception {

        Optional<Product> product = productRepository.findById(productDTO.getId());
        if(product.isEmpty()) {
            throw new Exception("User with this id doesn't exist.");
        }

        productRepository.save(modelMapper.map(productDTO,Product.class));
    }

    @Override
    public void deleteProduct(long id) {

        productRepository.deleteById(id);
    }
}
