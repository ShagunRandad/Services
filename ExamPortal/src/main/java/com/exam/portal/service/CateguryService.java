package com.exam.portal.service;

import java.util.List;

import com.exam.portal.entity.Category;

public interface CateguryService {

	public Category createCategory(Category category);
	
	public List<Category> getAllCategory();
	
	public Category getCategoryById(int id);
	
	public Category updateCategoryById(int id,Category category);
	
	public void deleteCategoryById(int id);
	
}
