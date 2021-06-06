package com.qsspy.TAIbackend.repositories;

import com.qsspy.TAIbackend.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByCategoryId(int categoryId);
}
