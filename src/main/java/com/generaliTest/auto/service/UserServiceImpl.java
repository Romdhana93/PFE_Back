package com.generaliTest.auto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.generaliTest.auto.entities.User;
import com.generaliTest.auto.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRep;

	@Override
	public List<User> getUsers() {
		return userRep.findAll();
	}

	@Override
	public User addUser(User u) {
		return userRep.save(u);
	}

	@Override
	public boolean supprimerUser(Long id) {
		userRep.deleteById(id);
		return true;
	}

	@Override
	public User updateUser(Long id, User u) {

		u.setId(id);
		return userRep.save(u);
	}

	@Override
	public User findUserById(Long id) {
		// TODO Auto-generated method stub
		return userRep.findById(id).get();
	}

}
