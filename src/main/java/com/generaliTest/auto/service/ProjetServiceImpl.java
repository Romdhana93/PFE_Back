package com.generaliTest.auto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generaliTest.auto.entities.Project;
import com.generaliTest.auto.entities.Role;
import com.generaliTest.auto.repository.ProjetRepository;

@Service
public class ProjetServiceImpl implements IProjetService {

	@Autowired
	ProjetRepository projetRep;
	
	@Override
	public List<Project> getProjets() {
		return projetRep.findAll();
	}

	@Override
	public Project addProjet(Project p) {
		return projetRep.save(p);
	}

	@Override
	public boolean supprimerProjet(Long id) {

		projetRep.deleteById(id);
		return false;
	}

	@Override
	public Project updateProjet(Long id, Project p) {
		p.setId(id);
		return projetRep.save(p);	}

}
