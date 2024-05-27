package com.exam.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exam.portal.entity.Category;
import com.exam.portal.service.CateguryService;
import com.exam.portal.util.ApiResponse;

@RestController
@RequestMapping(value = "/api/version2")
public class CataguryController {
	
	@Autowired
	CateguryService categuryService;
	
	@GetMapping(value="getAllCatagurys")
	public List<Category> getAllCatagurys(){
		return categuryService.getAllCategory();
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
		categuryService.deleteCategoryById(id);
		return ResponseEntity.ok("Categury Deleted Succesfully");
	}
	
	@PostMapping(value="/createCategury")
	public Category createCategury(@RequestBody Category category){
		return categuryService.createCategory(category);
	}

}
