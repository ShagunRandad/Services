package com.exam.portal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.portal.entity.Category;

public interface CategoryReposistory extends JpaRepository<Category,Integer> {

}
