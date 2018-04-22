package edu.esprit.services.news;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.entities.News;

/**
 * Session Bean implementation class NewsService
 */
@Stateless
public class NewsService implements NewsServiceRemote, NewsServiceLocal {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext
	private EntityManager entityManager;
	
    public NewsService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addNews(News news) {
		Boolean b = false;
		try {
			entityManager.persist(news);
			System.out.println("insert news with success");
			b = true;
		} catch (Exception e) {
			System.err.println("insert news error");
		}
		return b;
	}

	@Override
	public Boolean updateNews(News news) {
		Boolean b = false;
		try {
			entityManager.merge(news);	
			System.out.println("update news with success");
			b = true;
		} catch (Exception e) {
			System.err.println("update news error");
		}
		return b;
	}

	@Override
	public Boolean deleteNews(Integer idNews) {
		Boolean b = false;
		try {
			entityManager.remove(entityManager.find(News.class, idNews));
			System.out.println("delete news with success");
			b = true;
		} catch (Exception e) {
			System.err.println("delete news error");
		}
		return b;
	}

	@Override
	public List<News> readAllNews() {
		String jpql = "select n from News n ";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

}
