package edu.esprit.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Question
 *
 */
@Entity

public class Question implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer idQuest;
	private String questionText;
	private Boolean status;
	private static final long serialVersionUID = 1L;

	public Question() {
		super();
	}   
	
	@ManyToOne
	@JoinColumn(name="USR_FK")	
	private User user;
	
	
	
	@OneToMany(mappedBy="question",fetch = FetchType.EAGER)
	private List<Reponse> reponse;
	
	public Integer getIdQuest() {
		return this.idQuest;
	}

	public void setIdQuest(Integer idQuest) {
		this.idQuest = idQuest;
	}   
	public String getQuestionText() {
		return this.questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Reponse> getReponse() {
		return reponse;
	}

	public void setReponses(List<Reponse> reponse) {
		this.reponse = reponse;
	}

	@Override
	public String toString() {
		return "Question [idQuest=" + idQuest + ", questionText=" + questionText + ", status=" + status + ", user="
				+ user + ", reponse=" + reponse + "]";
	}
	
	
   
	
}
