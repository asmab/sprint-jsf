package edu.esprit.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Admin
 *
 */
@Entity

public class Admin implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer id_admin;
	private String name;
	private String login;
	private String pwd;
	private static final long serialVersionUID = 1L;

	public Admin() {
		super();
	}   

@OneToMany(mappedBy="admin")
private List<Reponse> reponses;
	
	
	public Integer getId_admin() {
		return this.id_admin;
	}

	public void setId_admin(Integer id_admin) {
		this.id_admin = id_admin;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}   
	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
   
}
