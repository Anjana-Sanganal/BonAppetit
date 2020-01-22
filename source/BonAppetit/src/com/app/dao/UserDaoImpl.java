package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.User;

@Repository
public class UserDaoImpl implements IUserDao {

	@Autowired
	private SessionFactory sf;
	
	
	@Override
	public User validateUser(String email, String password) {
		String jpql = "select u from User u where u.email=:email and u.password=:password";
		System.out.println("in validate user");
		System.out.println(email);
		System.out.println(password);
		return sf.getCurrentSession().createQuery(jpql, User.class).setParameter("email", email)
				.setParameter("password", password).getSingleResult();
	}
	
	@Override
	public User registerUser(User u) 
	{
		sf.getCurrentSession().persist(u);
		System.out.println("in regiter dao");
		return u;
	}

	@Override
	public List<User> getAllUsers() {
		String jpql = "select u from User u";
		return sf.getCurrentSession().createQuery(jpql, User.class).getResultList();
	}

	
	@Override
	public User getUserById(int id) 
	{
		return sf.getCurrentSession().get(User.class, id);
	}
	
	@Override
	public User updatePassword(int userId,User u) 
	{
		System.out.println("in dao update pwd "+u.getPassword());
		User user = sf.getCurrentSession().get(User.class, userId);
		user.setPassword(u.getPassword());
		sf.getCurrentSession().update(user);
		return user;
	}

	@Override
	public void deleteUser(User u) {
		sf.getCurrentSession().delete(u);		
	}

	@Override
	public User editProfile(int userId,User u) 
	{		
		System.out.println("in dao edit profile "+u.getPassword());
		User user = sf.getCurrentSession().get(User.class, userId);		
		user.setName(u.getName());
		user.setAddress(u.getAddress());
		user.setPhoneNumber(u.getPhoneNumber());
		user.setLocation(u.getLocation());
		sf.getCurrentSession().update(user);
		return user;
	}

	

	
}
