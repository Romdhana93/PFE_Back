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

import com.generaliTest.auto.entities.Project;
import com.generaliTest.auto.service.IProjetService;
import com.generaliTest.auto.service.IUserService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth/projet")
public class ProjectRestController {

	
	@Autowired
	IProjetService iprojetService;
	
	@RequestMapping(value="/projets",method=RequestMethod.GET)
	public List<Project> getProjets(){
		
		return iprojetService.getProjets();
		}
	
	@PostMapping("/ajouterProjet")
	@ResponseBody
	public Project ajouterProjet(@RequestBody Project r)
	{
		Project projet = iprojetService.addProjet(r);
		 return projet;
	}
	@RequestMapping(value="/supprimerProjet/{id}",method=RequestMethod.DELETE)
	public boolean supprimerProjet(@PathVariable Long  id){
		
		return iprojetService.supprimerProjet(id);
	}
	
	@RequestMapping(value="/modiferProjet/{id}",method=RequestMethod.PUT)
	public Project updateProjet(@PathVariable Long id ,@RequestBody Project r){
		return iprojetService.updateProjet(id, r);
	}
}
