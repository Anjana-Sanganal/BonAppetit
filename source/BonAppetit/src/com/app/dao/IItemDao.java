package com.app.dao;

import java.util.List;

import com.app.pojos.Item;

public interface IItemDao 
{
	List<Item> getItemsByHotel(int hotel_id);
	Item getItemById(int itemId);
	Item addItem(Item i);
	Item editPrice(int itemId,Item i);
}
