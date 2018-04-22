package edu.esprit.services.message;

import java.util.List;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.entities.Admin;
import edu.esprit.entities.Message;
import edu.esprit.entities.Notification;
import edu.esprit.entities.User;

/**
 * Session Bean implementation class GestionMessage
 */
@Stateless
@LocalBean
public class MessageService implements MessageServiceRemote {
	
	@PersistenceContext
	EntityManager entityManager;
	
  
	public MessageService() {
	
	}


	@Override
	public Boolean ajouterMessage(Message message) {
		
		Boolean b = false;
		try {
			entityManager.persist(message);
			System.out.println("insert message with success");
			b = true;
		} catch (Exception e) {
			System.err.println("insert message error");
		}
		return b;
	}


	@Override
	public List<Message> readAllMessage() {
		String jpql = "select m from Message m ";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}


	@Override
	public List<Message> readSentMessage() {
		String jpql = "select m from Message m where m.status='1' ";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}


	@Override
	public List<Message> readReceivedMessage() {
		String jpql = "select m from Message m where m.status='0' ";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}


	@Override
	public Boolean deleteMessageById(Integer id) {
		Boolean b = false;
		try {
			entityManager.remove(entityManager.find(Message.class, id));
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}


	@Override
	public List<User> readAllUsers() {
		
		return entityManager.createQuery("select u from User u" , User.class).getResultList();
	}


	@Override
	public List<User> findUserByName(String first_name) {
		
		String jpql = "select u from User u where u.first_name=:first_name";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("first_name",first_name);
		return query.getResultList();
	}


	@Override
	public User findUserByEmail(String email) {
		
		return entityManager.find(User.class, email);
	}


	@Override
	public List<Integer> readAllNotificationsCountMessage() {

		Query query = entityManager.createQuery("Select count(e) from Notification e where e.description=:p");

		query.setParameter("p", "new Message");
	

	   //System.out.println("lol");

		return query.getResultList();
	}


	@Override
	public Boolean ajouterNotification(Notification notification) {
		Boolean b = false;
		try {
			entityManager.persist(notification);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
		
	}


	

}
