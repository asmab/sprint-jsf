package edu.esprit.services.user;

import javax.ejb.Local;

import edu.esprit.entities.User;

@Local
public interface UserServiceLocal {
	public User authentificateuser(String login,String pwd);
}
