package edu.esprit.services.event;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.entities.Event;

/**
 * Session Bean implementation class EventService
 */
@Stateless
public class EventService implements EventServiceRemote, EventServiceLocal {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext
	private EntityManager entityManager;
	
    public EventService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addEvent(Event event) {
		Boolean b = false;
		try {
			entityManager.persist(event);
			System.out.println("inserteventwith success");
			b = true;
		} catch (Exception e) {
			System.err.println("insert event error");
		}
		return b;
	}

	@Override
	public Boolean updateEvent(Event event) {
		Boolean b = false;
		try {
			entityManager.merge(event);	
			System.out.println("update event with success");
			b = true;
		} catch (Exception e) {
			System.err.println("update event error");
		}
		return b;
	}

	@Override
	public Boolean deleteEvent(Integer idEvent) {
		Boolean b = false;
		try {
			entityManager.remove(entityManager.find(Event.class, idEvent));
			System.out.println("delete event with success");
			b = true;
		} catch (Exception e) {
			System.err.println("delete event error");
		}
		return b;
	}

	@Override
	public List<Event> readAllEvent() {
		String jpql = "select e from Event e ";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

    
    
}
