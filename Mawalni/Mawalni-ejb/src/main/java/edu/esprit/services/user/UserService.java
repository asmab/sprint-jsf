package edu.esprit.services.user;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.entities.User;

/**
 * Session Bean implementation class UserService
 */
@Stateless
@LocalBean
public class UserService implements UserServiceRemote, UserServiceLocal {

	
	
	
	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
	 public UserService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public User authentificateuser(String login, String pwd) {
		Query query=em.createQuery("select a from User a where a.login=:l and a.pwd=:pw");
		query.setParameter("l",login).setParameter("pw",pwd);
		
		User user=null;
	try{
		user= (User)query.getSingleResult();
		//System.out.println("user " + admin.getName());
		
	}
	catch(Exception e){
		System.out.println("error"+e.getMessage());		
	}
		return user;
	}

}
