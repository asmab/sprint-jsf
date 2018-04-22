package edu.esprit.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Event
 *
 */
@Entity
public class Event implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer idEvent;
	private String title;
	private String description;
	private String place;
	private Date dateEv;
	private static final long serialVersionUID = 1L;

	public Event() {
		super();
	}   
	public Integer getIdEvent() {
		return this.idEvent;
	}

	public void setIdEvent(Integer idEvent) {
		this.idEvent = idEvent;
	}   
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}   
	public Date getDateEv() {
		return this.dateEv;
	}

	public void setDateEv(Date dateEv) {
		this.dateEv = dateEv;
	}
   
}
