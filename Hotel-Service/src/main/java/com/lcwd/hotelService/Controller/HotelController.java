package com.lcwd.hotelService.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.hotelService.Entity.Hotel;
import com.lcwd.hotelService.ServiceImpl.HotelServiceImpl;

@RestController
@RequestMapping(value="/hotel")
public class HotelController {
	
	@Autowired
	HotelServiceImpl hotelService;

	@PostMapping(value="/createHotel")
	public Hotel createUser(@RequestBody Hotel hotel) {
		//String hotelId=UUID.randomUUID().toString();
		//hotel.setHotelName(hotelId);
		return hotelService.createHotel(hotel);
	}
	
	@GetMapping(value="/getHotelList")
	public List<Hotel> getHotelList(){
		return hotelService.getAllHotels();
	}
	
	@GetMapping(value="/{hotelId}")
	public Hotel getHotelById(@PathVariable String hotelId) {
		return hotelService.getHotelById(hotelId);
	}
	
	
	
}
