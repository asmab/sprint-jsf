package edu.asma.mawalni;


import java.util.Date;
import java.util.List;


import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import edu.esprit.entities.Project;
import edu.esprit.entities.User;
import edu.esprit.services.project.ProjectServiceLocal;

@ManagedBean
@SessionScoped

public class ProjectBean {
	
	private Project project = new Project();
	private Project projectDetails;
	private Project projectToUpdate;
	private Project projectToAdd;
	private String console;
	
	
	
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public List<Project> getListProject() {
		return listProject;
	}
	public void setListProject(List<Project> listProject) {
		this.listProject = listProject;
	}
	private List<Project> listProject;
	
	
	@EJB
	private ProjectServiceLocal serviceProject;
	
	
	@PostConstruct
	public void init()
	{ 
		listProject= serviceProject.readAllProject();				
		
	}
	
//show project details
	public String findProj(int id){
		
		String navTo=null;	
						
		setProjectDetails(serviceProject.findProjectById(id));		
		navTo="/pages/descriptionProject?faces-redirect=true";
		
		return navTo;
	}
	
//form project to update
	
	public String findProjToUpdate(int id){
		
		String navTo=null;	
		
		setProjectToUpdate(serviceProject.findProjectById(id));		
		navTo="/pages/editProject?faces-redirect=true";
		
		return navTo;
	}
	
	
//edit a project
	
	public String editProject(){		
		
        String navTo=null;    
		
		if ( serviceProject.updateProject(projectToUpdate))
		{
			listProject.clear();
			listProject= serviceProject.readAllProject();						
			
			navTo="/pages/userHomePage?faces-redirect=true";	
			System.out.println("update success");	
		}
		else
		{
		   System.out.println("erreur update");			   
		}	
				
		return navTo;
		
	}
	
//add a project
	
	
public String addProject(){		
		
        String navTo=null; 
        
        User u=new User();
        u.setIdUser(1);
        
        project.setDateDepot(new Date());
        project.setStatus(true);
        project.setUser(u);
		
		if ( serviceProject.addProject(project))
		{			
			listProject.clear();
			listProject= serviceProject.readAllProject();
			
			navTo="/pages/userHomePage?faces-redirect=true";	
			System.out.println("add project success");	
		}
		else
		{
		   System.out.println("erreur add project");			   
		}	
				
		return navTo;		
	}
	
	
    public String backToDescriptionPage(){		
		
        String navTo=null;  
		navTo="/pages/descriptionProject?faces-redirect=true";
	    return navTo;		
	}
    
 public String backToHomePage(){		
		
        String navTo=null;  
		navTo="/pages/userHomePage?faces-redirect=true";
	    return navTo;		
	}
	
	
	public Project getProjectDetails() {
		return projectDetails;
	}
	public void setProjectDetails(Project projectDetails) {
		this.projectDetails = projectDetails;
	}
	public Project getProjectToUpdate() {
		return projectToUpdate;
	}
	public void setProjectToUpdate(Project projectToUpdate) {
		this.projectToUpdate = projectToUpdate;
	}
	public String getConsole() {
		return console;
	}
	public void setConsole(String console) {
		this.console = console;
	}
	public Project getProjectToAdd() {
		return projectToAdd;
	}
	public void setProjectToAdd(Project projectToAdd) {
		this.projectToAdd = projectToAdd;
	}

}
