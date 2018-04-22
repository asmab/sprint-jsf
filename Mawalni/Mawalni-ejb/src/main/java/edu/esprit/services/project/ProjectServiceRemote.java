package edu.esprit.services.project;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.entities.Project;
import edu.esprit.entities.User;

@Remote
public interface ProjectServiceRemote {
	
public Boolean addProject(Project project);
public Boolean updateProject(Project project);
public Boolean updateStatusProject(Boolean status);
public Boolean deleteProject(Integer idProj);
public List <Project> readAllProject();
public Project findProjectById(Integer idProj);
public List<Project> ProjectInInstance();
public User findUserByID(Integer idUser);
public List<Project> findProjectByCategory(String category);
public Integer NombreProjectByCategory(String category);
public Integer NombreProjectAccepted();
public Integer NombreProjectRefused();

}
