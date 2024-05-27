package com.lcwd.hotelService.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lcwd.hotelService.Entity.Hotel;

@Repository
public interface HotelReposistry extends JpaRepository<Hotel,String> {

}
