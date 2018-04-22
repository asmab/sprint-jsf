package edu.esprit.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Reponse
 *
 */
@Entity

public class Reponse implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer idRep;
	private String text_rep;
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="ADMIN_FK")	
	private Admin admin;
	
	
	
	@ManyToOne
	@JoinColumn(name="QUEST_FK")	
	private Question question;
	
	
	public Reponse() {
		super();
	}   
	
	
	public Integer getIdRep() {
		return this.idRep;
	}

	public void setIdRep(Integer idRep) {
		this.idRep = idRep;
	}   
	public String getText_rep() {
		return this.text_rep;
	}

	public void setText_rep(String text_rep) {
		this.text_rep = text_rep;
	}


	public Question getQuestion() {
		return question;
	}


	public void setQuestion(Question question) {
		this.question = question;
	}


	public Admin getAdmin() {
		return admin;
	}


	public void setAdmin(Admin admin) {
		this.admin = admin;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((admin == null) ? 0 : admin.hashCode());
		result = prime * result + ((idRep == null) ? 0 : idRep.hashCode());
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		result = prime * result + ((text_rep == null) ? 0 : text_rep.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reponse other = (Reponse) obj;
		if (admin == null) {
			if (other.admin != null)
				return false;
		} else if (!admin.equals(other.admin))
			return false;
		if (idRep == null) {
			if (other.idRep != null)
				return false;
		} else if (!idRep.equals(other.idRep))
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		if (text_rep == null) {
			if (other.text_rep != null)
				return false;
		} else if (!text_rep.equals(other.text_rep))
			return false;
		return true;
	}


   
}
