package com.lcwd.hotelService.Entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="HotelDetails")
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String hotelId;
	private String hotelName;
	private String hotelDetails;
	private String hotelAddress;
	
}
