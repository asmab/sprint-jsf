package edu.asma.mawalni;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import edu.esprit.entities.Admin;
import edu.esprit.entities.User;
import edu.esprit.services.admin.AdminServiceLocal;
import edu.esprit.services.user.UserServiceLocal;

@ManagedBean(name="authB")
@SessionScoped

public class AuthentificationBean {
	
	
	private static User user = new User();
	private static Admin admin = new Admin();
	
	public boolean userConnected=false;
	public boolean adminConnected=false;

	//user
	public boolean isUserConnected() {
		return userConnected;
	}
	public void setUserConnected(boolean userConnected) {
		this.userConnected = userConnected;
	}
	
	//admin
	public boolean isAdminConnected() {
		return adminConnected;
	}
	public void setAdminConnected(boolean adminConnected) {
		this.adminConnected = adminConnected;
	}
	
	
   
	@EJB
	private AdminServiceLocal adminl;
	
	@EJB
	private UserServiceLocal userl;
	
	
	
	private boolean loggedin = false;
	public boolean isLoggedin() {
		return loggedin;
	}
	public void setLoggedin(boolean loggedin) {
		this.loggedin = loggedin;
	}
	
	//user
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	//admin
	public static Admin getAdmin() {
		return admin;
	}
	public  void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	
	public String doLogout()
	{
		String navTo = null;
		user = new User();
		loggedin = false;
		userConnected=false;

		navTo = "/welcome?faces-redirect=true";
		return navTo;
	}

	
	
	
	public AdminServiceLocal getAdminl() {
		return adminl;
	}
	public void setAdminl(AdminServiceLocal adminl) {
		this.adminl = adminl;
	}
	public UserServiceLocal getUserl() {
		return userl;
	}
	public void setUserl(UserServiceLocal userl) {
		this.userl = userl;
	}
	
	
	public String doLogin()
	{
		String navTo = null;
	    User founduser = userl.authentificateuser(user.getLogin(), user.getPwd());
	    Admin foundadmin = adminl.authentificateAdmin(admin.getLogin(), admin.getPwd());
        System.out.println(foundadmin.getName());
		if (founduser!= null){              			
				loggedin=true;			
				userConnected=true;
				navTo="/pages/userHomePage?faces-redirect=true";			
		}	
		else {
			
			loggedin=false;			
			userConnected=false;
			navTo="/pages/error?faces-redirect=true";	
			
		}
		
		
		/*
		if (foundadmin!= null){
			loggedin=true;			
			adminConnected=true;		
			navTo="/pages/admin/adminHomePage?faces-redirect=true";

		}
		*/
				
			
		FacesMessage msg = new FacesMessage("Bad credentials");
		FacesContext.getCurrentInstance().addMessage("form_login:form_submit", msg);
		return navTo;	
		}
	


}
