package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IHotelDao;
import com.app.pojos.Hotel;

@Service
@Transactional
public class HotelServiceImpl implements IHotelService 
{
	@Autowired
	private IHotelDao dao;
	@Override
	public List<Hotel> getAllHotels() {
		return dao.getAllHotels();
	}
	@Override
	public Hotel getHotelByName(String name) {
		return dao.getHotelByName(name);
	}
	@Override
	public Hotel getHotelById(int hotel_id) {
		return dao.getHotelById(hotel_id);
	}

}
