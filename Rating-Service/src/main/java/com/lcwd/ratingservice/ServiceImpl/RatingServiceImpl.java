package com.lcwd.ratingservice.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.ratingservice.Entity.Rating;
import com.lcwd.ratingservice.Reposistry.RatingReposistry;
import com.lcwd.ratingservice.Service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	RatingReposistry ratingReposistry;

	@Override
	public List<Rating> getAllRatings() {
		return ratingReposistry.findAll();
	}

	@Override
	public Rating getRatingById(String ratingId) {
		return ratingReposistry.findById(ratingId).get();
	}

	@Override
	public Rating createRating(Rating rating) {
		return ratingReposistry.save(rating);
	}

	@Override
	public void deleteRatingById(String ratingId) {
	 ratingReposistry.deleteById(ratingId);
	}

	@Override
	public List<Rating> findRatingByUserId(String userId) {
		return ratingReposistry.findByUserId(userId);
	}

	@Override
	public List<Rating>  findRatingByHotelId(String hotelId) {
		return ratingReposistry.findByHotelId(hotelId);
	}

}
