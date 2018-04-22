package edu.esprit.services.reponse;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.entities.Question;
import edu.esprit.entities.Reponse;

@Remote
public interface ReponseServiceRemote {

	
	
	public Boolean addReponse(Reponse reponse);
	public Boolean updateReponse(Reponse reponse);
	public Boolean deleteReponse(Integer idRep);
	public List <Reponse> readAllReponse();
	public Reponse findReponseById(Integer idRep);
	public List <Reponse> readRepByQuestion(Question question);
	public List <Reponse> findReponseByQuestion(Integer idQuest);
	
	
}
