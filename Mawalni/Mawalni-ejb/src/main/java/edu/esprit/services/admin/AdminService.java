package edu.esprit.services.admin;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.entities.Admin;
import edu.esprit.entities.User;


/**
 * Session Bean implementation class AdminService
 */
@Stateless
@LocalBean
public class AdminService implements AdminServiceRemote, AdminServiceLocal {

	
	@PersistenceContext
	EntityManager em;
	
    public AdminService() {
      
    }

	@Override
	public Boolean saveAdmin(Admin a) {
		try{
			em.persist(a);
			return true;
			}catch(Exception e)
			{
				return false;
			}
	}


	@Override
	public Admin authentificate(String login, String pwd) {
		Query query=em.createQuery("select a from Admin a where a.login=:l and a.pwd=:pw");
		query.setParameter("l",login).setParameter("pw",pwd);
		
		Admin admin=null;
	try{
		admin= (Admin)query.getSingleResult();
		//System.out.println("admin " + admin.getName());
		
	}
	catch(Exception e){
		System.out.println("error"+e.getMessage());		
	}
		return admin;
	}


	@Override
	public List<Admin> findAdmin() {
		
		Query query=em.createQuery("select a from Admin a");		
		return query.getResultList();
	}



	@Override
	public Admin authentificateAdmin(String login, String pwd) {
	
		Query query=em.createQuery("select a from Admin a where a.login=:l and a.pwd=:pw");
		query.setParameter("l",login).setParameter("pw",pwd);
		
		Admin admin=new Admin();
	try{
		admin= (Admin)query.getSingleResult();
		//System.out.println("admin " + admin.getName());
		
	}
	catch(Exception e){
		System.out.println("error"+e.getMessage());		
	}
		return admin;
	}

}
