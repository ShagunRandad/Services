package com.lcwd.ratingservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.ratingservice.Entity.Rating;
import com.lcwd.ratingservice.ServiceImpl.RatingServiceImpl;

@RestController
@RequestMapping(value="rating")
public class RatingController {
	
	@Autowired
	RatingServiceImpl ratingServiceImpl;
	
	@PostMapping(value="/creterating")
	public Rating crateRating(@RequestBody Rating rating) {
		//String ratingId=UUID.randomUUID().toString();
		//rating.setRatingId(ratingId);
		return ratingServiceImpl.createRating(rating);
	}
	
	@GetMapping(value="/getallratings")
	public List<Rating> getAllRating() {
		return ratingServiceImpl.getAllRatings();
	}
	
	@GetMapping(value="/{id}")
	public Rating getRatingById(@PathVariable String ratingId) {
		return ratingServiceImpl.getRatingById(ratingId);
	}
	
	@DeleteMapping(value="/{id}")
	public void deleteRatingById(@PathVariable String ratingId) {
		 ratingServiceImpl.deleteRatingById(ratingId);
	}
	
	
	@GetMapping(value="/getRatingByUserId/{ratingId}")
	public List<Rating> getRatingByUserId(@PathVariable String ratingId){
		return ratingServiceImpl.findRatingByUserId(ratingId);
	}
	
	
	@GetMapping(value="/getRatingByHotelId/{hotelId}")
	public List<Rating> getRatingByHotelId(@PathVariable String hotelId){
		return ratingServiceImpl.findRatingByHotelId(hotelId);
	}
	
	
	

}
