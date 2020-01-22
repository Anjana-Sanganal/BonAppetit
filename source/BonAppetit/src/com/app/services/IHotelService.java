package com.app.services;

import java.util.List;

import com.app.pojos.Hotel;

public interface IHotelService 
{
	List<Hotel> getAllHotels();
	Hotel getHotelByName(String name);
	Hotel getHotelById(int hotel_id);
}
