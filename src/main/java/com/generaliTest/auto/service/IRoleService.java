package com.generaliTest.auto.service;

import java.util.List;

import com.generaliTest.auto.entities.Role;
import com.generaliTest.auto.entities.User;

public interface IRoleService {

	public List<Role> getRoles();

	public Role addRole(Role r);

	public boolean supprimerRole(Long id);

	public Role updateRole(Long id, Role r);
	
}
