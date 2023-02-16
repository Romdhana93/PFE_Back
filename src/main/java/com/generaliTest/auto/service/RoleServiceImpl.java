package com.generaliTest.auto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generaliTest.auto.entities.Role;
import com.generaliTest.auto.entities.User;
import com.generaliTest.auto.repository.RoleRepository;

@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	RoleRepository roleRep;
	
	@Override
	public List<Role> getRoles() {
		
		return roleRep.findAll();
	}

	@Override
	public Role addRole(Role r) {
		// TODO Auto-generated method stub
		return roleRep.save(r);
		}

	@Override
	public boolean supprimerRole(Long id) {

		roleRep.deleteById(id);
		return false;
	}

	@Override
	public Role updateRole(Long id, Role r) {
		r.setId(id);
		return roleRep.save(r);		
	}


}
