package edu.esprit.services.project;

import java.util.List;

import javax.ejb.Local;

import edu.esprit.entities.Event;
import edu.esprit.entities.Project;

@Local
public interface ProjectServiceLocal {
	public List<Project> findProjectByCategorie(String Categorie);
	public List<Event> findEventByPlace(String place);

	public List <Project> readAllProject();
	public Project findProjectById(Integer idProj);
	public Boolean updateProject(Project project);
	public Boolean addProject(Project project);

}
