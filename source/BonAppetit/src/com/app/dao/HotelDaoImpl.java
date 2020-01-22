package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Hotel;

@Repository
public class HotelDaoImpl implements IHotelDao
{
	@Autowired
	private SessionFactory sf;
	
	@Override
	public List<Hotel> getAllHotels() {
		String jpql = "select h from Hotel h";
		return sf.getCurrentSession().createQuery(jpql, Hotel.class).getResultList();
	}

	@Override
	public Hotel getHotelByName(String name) 
	{
		String jpql = "select h from Hotel h where h.name=:name";
		return sf.getCurrentSession().createQuery(jpql, Hotel.class).setParameter("name", name).getSingleResult();
	}

	@Override
	public Hotel getHotelById(int hotel_id) {
		return sf.getCurrentSession().get(Hotel.class, hotel_id);
	}

}
