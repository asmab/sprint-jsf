package edu.esprit.services.news;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.entities.News;


@Remote
public interface NewsServiceRemote {

	
	public Boolean addNews(News news);
	public Boolean updateNews(News news);
	public Boolean deleteNews(Integer idNews);
	public List <News> readAllNews();
	
	
}
