package edu.esprit.services.event;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.entities.Event;


@Remote
public interface EventServiceRemote {
	
	public Boolean addEvent(Event event);
	public Boolean updateEvent(Event event);
	public Boolean deleteEvent(Integer idEvent);
	public List <Event> readAllEvent();	


}
