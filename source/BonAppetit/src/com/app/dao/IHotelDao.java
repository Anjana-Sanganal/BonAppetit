package com.app.dao;

import java.util.List;

import com.app.pojos.Hotel;

public interface IHotelDao 
{
	List<Hotel> getAllHotels();
	Hotel getHotelByName(String name);
	Hotel getHotelById(int hotel_id);
}
