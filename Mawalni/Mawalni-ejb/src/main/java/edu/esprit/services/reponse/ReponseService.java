package edu.esprit.services.reponse;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.entities.Question;
import edu.esprit.entities.Reponse;

/**
 * Session Bean implementation class ReponseService
 */
@Stateless
public class ReponseService implements ReponseServiceRemote, ReponseServiceLocal {

	@PersistenceContext
	private EntityManager entityManager;
	
    public ReponseService() {
    }

	@Override
	public Boolean addReponse(Reponse reponse) {
		Boolean b = false;
		try {
			entityManager.persist(reponse);
			System.out.println("insert reponse with success");
			b = true;
		} catch (Exception e) {
			System.err.println("insert reponse error");
		}
		return b;
	}

	@Override
	public Boolean updateReponse(Reponse reponse) {
		Boolean b = false;
		try {
			entityManager.merge(reponse);	
			System.out.println("update reponse with success");
			b = true;
		} catch (Exception e) {
			System.err.println("update reponse error");
		}
		return b;
	}

	@Override
	public Boolean deleteReponse(Integer idRep) {
		Boolean b = false;
		try {
			entityManager.remove(entityManager.find(Reponse.class, idRep));
			System.out.println("delete reponse with success");
			b = true;
		} catch (Exception e) {
			System.err.println("delete reponse error");
		}
		return b;
	}

	@Override
	public List<Reponse> readAllReponse() {
		String jpql = "select r from Reponse r ";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public Reponse findReponseById(Integer idRep) {
		return entityManager.find(Reponse.class, idRep);
	}

	@Override
	public List<Reponse> readRepByQuestion(Question question) {
		
		return null;	
	}

	@Override
	public List<Reponse> findReponseByQuestion(Integer idQuest) {
		String jpql = "select r from Reponse r where QUEST_FK=:idQuest";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("idQuest",idQuest);
		return query.getResultList();
	}

}
