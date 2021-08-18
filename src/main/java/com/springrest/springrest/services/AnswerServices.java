package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springrest.springrest.Dao.AnswerRepository;
import com.springrest.springrest.Dao.QuestionRepository;
import com.springrest.springrest.Model.Answers;
import com.springrest.springrest.Model.Questioncore;


@Component
public class AnswerServices {
	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	  public List<Answers> getAllAnswer()
	{
		List<Answers>list=(List<Answers>)this.answerRepository.findAll();
		return list;
	}
	
	//get indivisual answer by Id
	public Optional<Answers> getAnswerById(int id)
	{
		Optional<Answers> answer=null;
		try {
			
			
		//question=list.stream().filter(e->e.getId()==id ).findFirst().get();
			answer=this.answerRepository.findById(id);
			
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return answer;
	}
	
	//adding Answers
	/*public Answers addAnswer(Answers a) 
	{
		//int question_id,
	//	List<Answers>Answer=new ArrayList<>();
		
		
	//	Questioncore question1=new Questioncore();
	//	Optional <Questioncore> byId=questionRepository.findById(question_id);
		//if(!byId.isPresent()) {
			
			
		//	throw new Exception("question with id " + question_id + " does not exist");
		//}
		//Questioncore questioncore=byId.get();
		
		//a.setQuestioncore(questioncore);
		
		
		//Answers answer1=answerRepository.save(a);
		////Answer.add(answer1);
		//question1.setAnswer(Answer);
		//return answer1;
	Answers result=answerRepository.save(a);
		return result;
	}
	*/
	
	public Answers addAnswer(int Q_id,Answers answer) throws Exception 
	{
		List<Answers>Answer=new ArrayList<>();
		Questioncore question1=new Questioncore();
		Optional <Questioncore> byId=questionRepository.findById(Q_id);
		if(!byId.isPresent()) {
			
			
			throw new Exception("question with id " + Q_id + " does not exist");
		}
		
		Questioncore questioncore=byId.get();
		
		answer.setQuestioncore(questioncore);
		Answers answer1=answerRepository.save(answer);
		
		Answer.add(answer1);
		question1.setAnswer(Answer);
		return answer1;
	}
	
	
	
//deleteanswer
	public void deleteAnswer(int aid)
	{
		
		answerRepository.deleteById(aid);
		
		
	}
	//updateAnswer
	public void UpdateAnswer(Answers answer,int aid)
	{
	
		answer.setId(aid);
			
		answerRepository.save(answer);
		
		}

	
	
	/* public List<Answers> getAllBooks() {
	        return (List<Answers>) answerRepository.findAll();
	    }


	    public Optional<Answers> getBookById(int id) throws Exception {
	        if (!answerRepository.existsById(id)) {
	            throw new Exception("Book with id " + id + " not found");
	        }
	        return answerRepository.findById(id);
	    }


	    
	    public Answers createBook(int questionId,Answers a) throws Exception 
		{
		
		List<Answers>Answer=new ArrayList<>();
			
			
		Questioncore question1=new Questioncore();
			Optional <Questioncore> byId=questionRepository.findById(questionId);
			if(!byId.isPresent()) {
				
				
				throw new Exception("question with id " + questionId + " does not exist");
			}
			Questioncore questioncore=byId.get();
			
			a.setQuestioncore(questioncore);
			
			
			Answers answer1=answerRepository.save(a);
			Answer.add(answer1);
			question1.setAnswer(Answer);
			return answer1;

	    }
	    */
}
