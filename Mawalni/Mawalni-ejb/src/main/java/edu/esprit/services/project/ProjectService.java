package edu.esprit.services.project;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.entities.Event;
import edu.esprit.entities.Project;
import edu.esprit.entities.User;

/**
 * Session Bean implementation class ProjectService
 */
@Stateless
@LocalBean
public class ProjectService implements ProjectServiceRemote, ProjectServiceLocal {

	@PersistenceContext
	private EntityManager entityManager;
	
    public ProjectService() {
   
    }

	@Override
	public Boolean addProject(Project project) {
		Boolean b = false;
		try {
			entityManager.persist(project);						
			b = true;
		} catch (Exception e) {
			System.err.println("insert error");
		}
		return b;
	}
	@Override
	public List<Project> findProjectByCategorie(String Categorie) {
		
		Query query= entityManager.createQuery("SELECT c FROM Project c where c.category=:category").setParameter("category", Categorie);		
		return query.getResultList();
	}
	
	
	@Override
	public List<Event> findEventByPlace(String Place) {
		
		Query query= entityManager.createQuery("SELECT c FROM Event c where c.place=:place").setParameter("place", Place);		
		return query.getResultList();
	}
	@Override
	public Boolean updateProject(Project project) {
		Boolean b = false;
		try {
			entityManager.merge(project);					
			b = true;
		} catch (Exception e) {
			System.err.println("update error");
		}
		return b;
	}

	@Override
	public Boolean deleteProject(Integer idProj) {
		Boolean b = false;
		try {
			entityManager.remove(entityManager.find(Project.class, idProj));
			System.out.println("delete with success");
			b = true;
		} catch (Exception e) {
			System.err.println("delete error");
		}
		return b;
	}

	@Override
	public List<Project> readAllProject() {
		Query query= entityManager.createQuery("select e from Project e");
		return query.getResultList();
	}

	@Override
	public Project findProjectById(Integer idProj) {
		return entityManager.find(Project.class, idProj);
	}

	@Override
	public List<Project> ProjectInInstance() {
		String jpql = "select p from Project p where p.status ='0' ";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public User findUserByID(Integer idUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean updateStatusProject(Boolean status) {
		Boolean b = false;
		try {
			String s="true";		
			String jpql = "insert into Project p values(status=:status)";			
			Query query = entityManager.createQuery(jpql);
			query.setParameter("status", s);
			query.executeUpdate();
		
			System.out.println("update status with success");
			b = true;
		} catch (Exception e) {
			System.err.println("update status error");
		}
		return b;
	}

	@Override
	public List<Project> findProjectByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer NombreProjectByCategory(String category) {
		
		String jpql = "select count(idProj) from Project p where p.category =:category ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("category",category);		
		return Integer.parseInt(query.getSingleResult().toString());		
	}

	@Override
	public Integer NombreProjectAccepted() {
		
		String jpql = "select count(idProj) from Project p where p.status ='1' ";
		Query query = entityManager.createQuery(jpql);		
		return Integer.parseInt(query.getSingleResult().toString());
	}

	@Override
	public Integer NombreProjectRefused() {
		// TODO Auto-generated method stub
		return null;
	}
 

}
