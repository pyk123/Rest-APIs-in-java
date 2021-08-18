package com.springrest.springrest.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springrest.springrest.Dao.QuestionRepository;
import com.springrest.springrest.Model.Questioncore;

@Component
public class Services {
	@Autowired
	private QuestionRepository questionRepository;
	
	//private static  List<Questioncore> list=new ArrayList<>();
	
	//static {
	//	list.add(new Questioncore(12,"amazon","TELL MI ABOUTE YOUR SELF","XYZ","HI I AM PRAFULLA ","NICE qq",12,"amazon","aed","sdkfjs","sefsdf","me") );
		//list.add(new Questioncore(23,"flipcart","how are you","XYZ","HI I AM ykj ","sedf qq",2,"flipcart","sdfsd","abc","xyz","you") );
		//list.add(new Questioncore(42,"tata","byr","XYZ","HI I AM skd ","NICE qq",62,"tataazon","aed","sdkfjs","sefsdf","me") );
	//}
	

	//get all question
	
	
	
	
	public List<Questioncore> getAllQuestions()
	{
		List<Questioncore>list=(List<Questioncore>)this.questionRepository.findAll();
		return list;
	}
	
	//get indivisual question by Id
	public Optional<Questioncore> getQuestionById(int id)
	{
		Optional<Questioncore> question=null;
		try {
			
			
		//question=list.stream().filter(e->e.getId()==id ).findFirst().get();
			question=this.questionRepository.findById(id);
			
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return question;
	}
	//adding Questioncore
	public Questioncore addQuestion(Questioncore q)
	{
		Questioncore result=questionRepository.save(q);
		return result;
	}
	
//deleteQuestion
	public void deleteQuestion(int qid)
	{
		//list=list.stream().filter(question-> question.getId()!=qid)
		//	.collect(Collectors.toList());
		
		questionRepository.deleteById(qid);
		
		
	}
	//updateQuestion
	public void UpdateQuestion(Questioncore question,int qid)
	{
		//list=list.stream().map(q->{
			
			
		//	if(q.getId()==qid)
				
		//	{
		//		q.setQuestion_text(question.getQuestion_text());
		//		q.setAnswer(question.getAnswer());
		//	}
		//	return q;
	//}).collect(Collectors.toList());
		question.setId(qid);
			
		questionRepository.save(question);
		
		}

	
	/* public List<Questioncore> getAuthors() {
	        return (List<Questioncore>) questionRepository.findAll();
	    }

	    public Questioncore createAuthor(Questioncore author) {
	        return questionRepository.save(author);
	    }
	*/
	
}
