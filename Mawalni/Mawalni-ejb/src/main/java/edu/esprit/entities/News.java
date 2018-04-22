package edu.esprit.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: News
 *
 */
@Entity

public class News implements Serializable {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer idNews;
	private String title;
	private String description;
	private String place;
	private String category;
	private Date dateNews;
	private static final long serialVersionUID = 1L;

	public News() {
		super();
	}   
	public Integer getIdNews() {
		return this.idNews;
	}

	public void setIdNews(Integer idNews) {
		this.idNews = idNews;
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
	public Date getDateNews() {
		return this.dateNews;
	}

	public void setDateNews(Date dateNews) {
		this.dateNews = dateNews;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
   
}
