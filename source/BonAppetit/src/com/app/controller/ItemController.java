package com.app.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.services.*;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/users")
public class ItemController 
{

	@Autowired
	private IItemService service;
	
	@PostConstruct
	public void init()
	{
		System.out.println("in init " + service);
	}
	
}
