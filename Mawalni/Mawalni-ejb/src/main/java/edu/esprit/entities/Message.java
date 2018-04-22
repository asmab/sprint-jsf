package edu.esprit.entities;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Message
 *
 */
@Entity
public class Message implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer idMsg;
	private String content;
	private Date dateM;
	private Boolean status;
	private static final long serialVersionUID = 1L;
	
	
	
	public Message() {
		super();
	}   
	
	@ManyToOne
	@JoinColumn(name="USER_FK")
	
	private User user;
	
	
	public Integer getIdMsg() {
		return this.idMsg;
	}

	public void setIdMsg(Integer idMsg) {
		this.idMsg = idMsg;
	}   
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}   
	public Date getDateM() {
		return this.dateM;
	}

	public void setDateM(Date dateM) {
		this.dateM = dateM;
	}   
	public Boolean getStatus() {
		return this.status;
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

	@Override
	public String toString() {
		return "Message [idMsg=" + idMsg + ", content=" + content + ", dateM=" + dateM + ", status=" + status
				+ ", user=" + user + "]";
	}
	
   
}
