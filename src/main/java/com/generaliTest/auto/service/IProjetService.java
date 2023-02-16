package com.generaliTest.auto.service;

import java.util.List;

import com.generaliTest.auto.entities.Project;
import com.generaliTest.auto.entities.Role;

public interface IProjetService {

	
	public List<Project> getProjets();

	public Project addProjet(Project p);

	public boolean supprimerProjet(Long id);

	public Project updateProjet(Long id, Project p);
}
