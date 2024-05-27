package com.exam.portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.portal.Exception.UserDefineException;
import com.exam.portal.Repository.CategoryReposistory;
import com.exam.portal.entity.Category;
import com.exam.portal.service.CateguryService;

@Service
public class CateguryServiceImpl implements CateguryService {
	
	@Autowired
	CategoryReposistory categoryReposistory;

	@Override
	public Category createCategory(Category category) {
		if(category != null) {
			categoryReposistory.save(category);
			return category;
		}
		return null;
		
	}

	@Override
	public List<Category> getAllCategory() {
		return categoryReposistory.findAll();
	}

	@Override
	public Category getCategoryById(int id) {
		return categoryReposistory.findById(id).orElseThrow(
				() -> new UserDefineException("No User of this id is present"));
	}

	@Override
	public Category updateCategoryById(int id, Category category) {
		categoryReposistory.findById(id).orElseThrow(
				() -> new UserDefineException("No User of this id is present"));
		return categoryReposistory.save(category);
	}

	@Override
	public void deleteCategoryById(int id) {
		categoryReposistory.findById(id).orElseThrow(
				() -> new UserDefineException("No User of this id is present"));
		 categoryReposistory.deleteById(id);
	}


}
