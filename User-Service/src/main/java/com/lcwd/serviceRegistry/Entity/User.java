package com.lcwd.serviceRegistry.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="User_details")
public class User {
	@Id
	private String userId;
	private String name;
	private String email;
	private String about;
	
	@Transient
   private  List<Rating> ratings=new ArrayList<Rating>();
	
	

}
