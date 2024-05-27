package com.lcwd.hotelService.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lcwd.hotelService.Entity.Hotel;

@Service
public interface hotelService {
	
     public Hotel createHotel(Hotel hotel);
     
     public List<Hotel> getAllHotels();
     
     public Hotel getHotelById(String hotelId);
     
     public void deleteHotelById(String hotelId);

}
