package edu.esprit.services.question;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.entities.Question;
import edu.esprit.entities.Reponse;
import edu.esprit.entities.User;

@Remote
public interface QuestionServiceRemote {

	
	
public Boolean addQuestion(Question question);
public Boolean updateQuestion(Question question);
public Boolean updateStatusQuestion(Question question);
public Boolean deleteQuestion(Integer idQuest);
public List <Question> readAllQuestion();
public Question findQuestionById(Integer idQuest);
public List<Question> QuestionInInstance();
public User findUserByID(Integer idUser);
	
public List <Reponse> readAllReponseByQuestion(Question question);
}
