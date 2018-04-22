package edu.esprit.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class User implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer idUser;
	private String first_name;
	private String last_name;
	private String sex;
	@Temporal(TemporalType.DATE)
	private Date date_b;
	private String tel;
	private String profession;
	private String mail;
	private String login;
	private String pwd;
	private static final long serialVersionUID = 1L;
	
	

	public User() {
		super();
	}   
	
	@OneToMany(mappedBy="user")	
	private List<Project> projects;
	
	@OneToMany(mappedBy="user")
	private List<Service> services;
	
	@OneToMany(mappedBy="user",fetch = FetchType.EAGER)
	private List<Question> questions;
	
	@OneToMany(mappedBy="user",fetch = FetchType.EAGER)	
	private List<Message> messages;
	

	
	public Integer getId_user() {
		return this.idUser;
	}

	public void setId_user(Integer id_user) {
		this.idUser = id_user;
	}   
	public String getFirst_name() {
		return this.first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}   
	public String getLast_name() {
		return this.last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}   
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}   
	public Date getDate_b() {
		return this.date_b;
	}

	public void setDate_b(Date date_b) {
		this.date_b = date_b;
	}   
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}   
	public String getProfession() {
		return this.profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}   
	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
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

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	@Override
	public String toString() {
		return "User [first_name=" + first_name + ", last_name=" + last_name + ", profession=" + profession + ", mail="
				+ mail + "]";
	}

	

   
}
