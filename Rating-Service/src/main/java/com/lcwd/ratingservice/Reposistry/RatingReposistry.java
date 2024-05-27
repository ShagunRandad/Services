package com.lcwd.ratingservice.Reposistry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lcwd.ratingservice.Entity.Rating;
@Repository
public interface RatingReposistry extends JpaRepository<Rating, String> {

	
	List<Rating> findByUserId(String userId);
	
	List<Rating> findByHotelId(String hotelId);
} 
