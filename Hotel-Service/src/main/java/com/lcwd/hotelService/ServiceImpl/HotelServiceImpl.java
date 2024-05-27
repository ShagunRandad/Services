package com.lcwd.hotelService.ServiceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.hotelService.Entity.Hotel;
import com.lcwd.hotelService.Exception.ResourceNotFoundException;
import com.lcwd.hotelService.Repositry.HotelReposistry;
import com.lcwd.hotelService.Service.hotelService;

@Service
public class HotelServiceImpl implements hotelService {

	@Autowired
	HotelReposistry hotelReposistry;
	
	@Override
	public Hotel createHotel(Hotel hotel) {
		return hotelReposistry.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {
		return hotelReposistry.findAll();
	}

	@Override
	public Hotel getHotelById(String hotelId) {
		return hotelReposistry.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel Not Found Exception"));
	}

	@Override
	public void deleteHotelById(String hotelId) {
		 hotelReposistry.deleteById(hotelId);
	}
	
	
	
	

}
