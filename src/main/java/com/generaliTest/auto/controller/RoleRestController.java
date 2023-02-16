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

import com.generaliTest.auto.entities.Role;
import com.generaliTest.auto.entities.User;
import com.generaliTest.auto.service.IRoleService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class RoleRestController {

	@Autowired
	IRoleService iroleService;
	
	@RequestMapping(value="/roles",method=RequestMethod.GET)
	public List<Role> getRoles(){
		
		return iroleService.getRoles();
		}
	
	@PostMapping("/ajouterRole")
	@ResponseBody
	public Role ajouterUser(@RequestBody Role r)
	{
		 Role role = iroleService.addRole(r);
		 return role;
	}
	@RequestMapping(value="/supprimerRole/{id}",method=RequestMethod.DELETE)
	public boolean supprimerRole(@PathVariable Long  id){
		
		return iroleService.supprimerRole(id);
	}
	
	@RequestMapping(value="/modiferRole/{id}",method=RequestMethod.PUT)
	public Role updateRole(@PathVariable Long id ,@RequestBody Role r){
		return iroleService.updateRole(id, r);
	}
}
