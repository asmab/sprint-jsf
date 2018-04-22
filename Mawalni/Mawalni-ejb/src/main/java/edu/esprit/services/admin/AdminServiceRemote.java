package edu.esprit.services.admin;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.entities.Admin;
import edu.esprit.entities.User;


@Remote
public interface AdminServiceRemote {

	public Boolean saveAdmin(Admin a );
	public Admin authentificate(String login,String pwd);
    public  List<Admin> findAdmin();
}
