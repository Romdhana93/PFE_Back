package com.generaliTest.auto.service;


import java.util.List;

import com.generaliTest.auto.entities.User;

public interface IUserService {

	public List<User> getUsers();

	public User addUser(User u);

	public boolean supprimerUser(Long id);

	public User updateUser(Long id, User u);
	
	public User findUserById(Long id);

}
