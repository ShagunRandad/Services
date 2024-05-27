

package com.lcwd.ratingservice.Entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="rating_master")
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String ratingId;
	private String userId;
	private String hotelId;
	private int rating;
	

}
