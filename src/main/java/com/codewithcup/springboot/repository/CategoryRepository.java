package com.codewithcup.springboot.repository;

import com.codewithcup.springboot.model.examcontent.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
