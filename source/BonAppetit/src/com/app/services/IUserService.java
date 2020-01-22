package com.app.services;

import java.util.List;

import com.app.pojos.User;

public interface IUserService 
{
	User validateUser(String email,String password);
	User registerUser(User u);
	List<User> getAllUsers();
	User getUserById(int id);
	User updatePassword(int userId,User u);
	void deleteUser(int userId);
	User editProfile(int userId,User u);
}