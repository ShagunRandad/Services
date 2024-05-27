package com.lcwd.serviceRegistry.ServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lcwd.serviceRegistry.Entity.Hotel;
import com.lcwd.serviceRegistry.Entity.Rating;
import com.lcwd.serviceRegistry.Entity.User;
import com.lcwd.serviceRegistry.Exception.ResourceNotFoundException;
import com.lcwd.serviceRegistry.ExternalServices.HotelService;
import com.lcwd.serviceRegistry.Reposistry.UserReposistry;
import com.lcwd.serviceRegistry.Service.UserService;
import com.lcwd.serviceRegistry.payload.ApiResponce;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserReposistry userReposistry;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;
	 
	private static final Log log=LogFactory.getLog(UserServiceImpl.class);
	
	@Override
	public User saveUser(User user) {
		return userReposistry.save(user);
	}
	
	
	@Override
	public void deleteUserById(String userId) {
		 userReposistry.deleteById(userId);
	}

	@Override
	public List<User> getAllUsers() {
		return (List<User>) userReposistry.findAll();
		 
	}

	@Override
	public User updateUserById(User user) {
       return userReposistry.save(user);
	}


	@Override
	public User getUserById(String id) {
		User user = userReposistry.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("This Resource Not Found in our Records"));
		Rating[] ratingsUser = restTemplate.getForObject("http://RATING-SERVICE/rating/getRatingByUserId/" + id,
				Rating[].class);
		log.info("{}" + ratingsUser);
		List<Rating> ratingList = Arrays.stream(ratingsUser).toList();
		List<Rating> listRating = ratingList.stream().map(s -> {
			//ResponseEntity<Hotel> a = restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/" + s.getHotelId(),Hotel.class);
			Hotel hotel = hotelService.getHotel(s.getHotelId());
			s.setHotel(hotel);
			return s;
		}).collect(Collectors.toList());

		user.setRatings(listRating);
		return user;
	}

}
