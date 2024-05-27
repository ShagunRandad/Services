package com.lcwd.serviceRegistry.ExternalServices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lcwd.serviceRegistry.Entity.Hotel;

@FeignClient(name="HOTEL-SERVICE")
public interface HotelService {
	
	@GetMapping(value="/hotel/{id}")
	Hotel getHotel(@PathVariable String id);

}
