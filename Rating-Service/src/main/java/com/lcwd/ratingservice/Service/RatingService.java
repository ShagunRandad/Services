package com.lcwd.ratingservice.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lcwd.ratingservice.Entity.Rating;

@Service
public interface RatingService {
	
	public List<Rating> getAllRatings();
	
	public Rating getRatingById(String ratingId);
	
	public Rating createRating(Rating rating);
	
	public void deleteRatingById(String ratingId);
	
	public List<Rating> findRatingByUserId(String userId);
	
	public List<Rating> findRatingByHotelId(String hotelId);
	
	

}
