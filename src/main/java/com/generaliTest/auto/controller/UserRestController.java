package com.generaliTest.auto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.generaliTest.auto.entities.User;
import com.generaliTest.auto.service.IUserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth/user")
public class UserRestController {

	@Autowired
	IUserService iuserService;
	
	@PostMapping("/ajouterUser")
	@ResponseBody
	public User ajouterUser(@RequestBody User u)
	{
		 User user = iuserService.addUser(u);
		 return user;
	}
	
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public List<User> getUserss(){
		
		return iuserService.getUsers();
		}
	
	@RequestMapping(value="/supprimerUser/{id}",method=RequestMethod.DELETE)
	public boolean supprimerUser(@PathVariable Long  id){
		
		return iuserService.supprimerUser(id);
	}
	
	@RequestMapping(value="/modiferUser/{id}",method=RequestMethod.PUT)
	public User updateUser(@PathVariable Long id ,@RequestBody User u){
		return iuserService.updateUser(id, u);
	}
	
	@RequestMapping(value="/userById/{id}",method=RequestMethod.GET)
	public User getUserById(@PathVariable Long  id){
		
		return iuserService.findUserById(id);
		}
	
}
