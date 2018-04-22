package edu.esprit.entities;


import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: Notification
 *
 */
@Entity
public class Notification implements Serializable {


	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idNotif;
	private String description;
	private int etat;
	
	
	private static final long serialVersionUID = 1L;
	@OneToOne
	private Message message;
 
   
	public Notification() {
		super();
	}   

	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}

	public int getIdNotif() {
		return this.idNotif;
	}

	public void setIdNotif(int idNotif) {
		this.idNotif = idNotif;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public int getEtat() {
		return this.etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}
   
}
