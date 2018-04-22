package edu.esprit.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Service
 *
 */
@Entity

public class Service implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer idService;
	private String category;
	private String subject;
	@Temporal(TemporalType.DATE)
	private Date dateServ;
	private static final long serialVersionUID = 1L;
	
	public Service() {
		super();
	}   
	@ManyToOne
	@JoinColumn(name="USR_FK")
	
	private User user;
		
	public Integer getIdService() {
		return this.idService;
	}

	public void setIdService(Integer idService) {
		this.idService = idService;
	}   
	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}   
	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

   
}
