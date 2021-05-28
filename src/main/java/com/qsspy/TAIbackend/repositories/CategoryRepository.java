package com.qsspy.TAIbackend.repositories;

import com.qsspy.TAIbackend.entities.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
