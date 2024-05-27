package com.lcwd.serviceRegistry.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Hotel {
	private String hotelId;
	private String hotelName;
	private String hotelDetails;
	private String hotelAddress;
}
