package com.app.dao;

import java.util.List;

import com.app.pojos.User;

public interface IUserDao 
{
	User validateUser(String email,String password);
	User registerUser(User u);
	List<User> getAllUsers();
	User getUserById(int id);
	User updatePassword(int userId, User u);
	void deleteUser(User u);
	User editProfile(int userId,User u);
}
