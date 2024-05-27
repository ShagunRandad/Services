package com.lcwd.hotelService.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/staffs")
public class HotelSatff {
	
	@GetMapping(value="/getAllStaffs")
	  public List<String> getAllStaffs(){
		List<String> staffs=new ArrayList<String>();
		staffs.add("Rohit");
		staffs.add("Rohit");
		staffs.add("Rohit");staffs.add("Rohit");
		staffs.add("Rohit");
		return staffs;
	}

}
