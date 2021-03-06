package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.pojos.User;

@Service
@Transactional
public class UserServiceImpl implements IUserService 
{
	@Autowired
	private IUserDao dao;
	
	@Override
	public User validateUser(String email, String password) {
		return dao.validateUser(email, password);
	}

	@Override
	public User registerUser(User u) {		
		return dao.registerUser(u);
	}

	@Override
	public List<User> getAllUsers() {		
		return dao.getAllUsers();
	}

	@Override
	public User getUserById(int id) {	
		return dao.getUserById(id);
	}

	@Override
	public User updatePassword(int userId,User u) {	
		return dao.updatePassword(userId,u);
	}

	@Override
	public void deleteUser(int userId) {
		User u = dao.getUserById(userId);
		if( u != null )
			dao.deleteUser(u);	
	}

	@Override
	public User editProfile(int userId,User u) {
		return dao.editProfile(userId, u);
	}

}
