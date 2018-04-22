package edu.esprit.services.admin;

import javax.ejb.Local;

import edu.esprit.entities.Admin;
import edu.esprit.entities.User;

@Local
public interface AdminServiceLocal {
	public Admin authentificateAdmin(String login,String pwd);
    
}
