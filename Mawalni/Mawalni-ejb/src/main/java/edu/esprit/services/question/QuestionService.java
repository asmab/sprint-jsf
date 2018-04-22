package edu.esprit.services.question;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.entities.Project;
import edu.esprit.entities.Question;
import edu.esprit.entities.Reponse;
import edu.esprit.entities.User;

/**
 * Session Bean implementation class QuestionService
 */
@Stateless
public class QuestionService implements QuestionServiceRemote, QuestionServiceLocal {

	@PersistenceContext
	private EntityManager entityManager;
	
    public QuestionService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addQuestion(Question question) {
		Boolean b = false;
		try {
			entityManager.persist(question);
			System.out.println("insert question with success");
			b = true;
		} catch (Exception e) {
			System.err.println("insert question error");
		}
		return b;
	}

	@Override
	public Boolean updateQuestion(Question question) {
		Boolean b = false;
		try {
			entityManager.merge(question);	
			System.out.println("update question with success");
			b = true;
		} catch (Exception e) {
			System.err.println("update question error");
		}
		return b;
	}

	@Override
	public Boolean updateStatusQuestion(Question question) {
		Boolean b = false;
		try {
			String s="true";		
			String jpql = "insert into Question q values(status=:status)";			
			Query query = entityManager.createQuery(jpql);
			query.setParameter("status", s);
			query.executeUpdate();
		
			System.out.println("update question status with success");
			b = true;
		} catch (Exception e) {
			System.err.println("update question status error");
		}
		return b;
	}
	

	@Override
	public Boolean deleteQuestion(Integer idQuest) {
		Boolean b = false;
		try {
			entityManager.remove(entityManager.find(Question.class, idQuest));
			System.out.println("delete question with success");
			b = true;
		} catch (Exception e) {
			System.err.println("delete question error");
		}
		return b;
	}

	@Override
	public List<Question> readAllQuestion() {
		String jpql = "select q from Question q ";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public Question findQuestionById(Integer idQuest) {
		return entityManager.find(Question.class, idQuest);
	}

	@Override
	public List<Question> QuestionInInstance() {
		String jpql = "select q from Question q where q.status ='0' ";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public User findUserByID(Integer idUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reponse> readAllReponseByQuestion(Question question) {
		
		String jpql = "select r from Reponse r where r.question=:1";
		Query query = entityManager.createQuery(jpql);		
		query.setParameter("1", question);
		
		return query.getResultList();
	}

}
