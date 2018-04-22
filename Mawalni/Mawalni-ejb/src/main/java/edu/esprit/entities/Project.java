package edu.esprit.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Project
 *
 */
@Entity

public class Project implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer idProj;
	private String Titre;
	private String category;
	private String descrip;
	private Boolean status;
	@Temporal(TemporalType.DATE)
	private Date dateDepot;
	private static final long serialVersionUID = 1L;
	
	public Project() {
		super();
	} 
	
	@ManyToOne
	@JoinColumn(name="USR_FK")
	
	private User user;
	
	
	public Integer getIdProj() {
		return this.idProj;
	}

	public void setIdProj(Integer id_proj) {
		this.idProj = id_proj;
	}   
	public String getTitre() {
		return this.Titre;
	}

	public void setTitre(String Titre) {
		this.Titre = Titre;
	}   
	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}   
	public String getDescrip() {
		return this.descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}


	
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Date getDateDepot() {
		return dateDepot;
	}

	public void setDateDepot(Date dateDepot) {
		this.dateDepot = dateDepot;
	}
   
}
