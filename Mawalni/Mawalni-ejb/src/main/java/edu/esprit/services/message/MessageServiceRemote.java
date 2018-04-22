package edu.esprit.services.message;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.entities.Admin;
import edu.esprit.entities.Message;
import edu.esprit.entities.Notification;
import edu.esprit.entities.User;

@Remote
public interface MessageServiceRemote {

	public Boolean ajouterMessage(Message message);	
	public List<Message> readAllMessage();
	public List<Message> readSentMessage();
	public List<Message> readReceivedMessage();	
	public Boolean deleteMessageById(Integer id);	
	public List<User> readAllUsers();
    public List<User> findUserByName(String first_name);    
    public User findUserByEmail(String email);
    public Boolean ajouterNotification(Notification notification);
 	public List<Integer>  readAllNotificationsCountMessage();

}
