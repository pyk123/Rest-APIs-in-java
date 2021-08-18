package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springrest.springrest.Dao.AnswerRepository;
import com.springrest.springrest.Dao.Answer_CommentsRepository;
import com.springrest.springrest.Model.Answer_Comments;
import com.springrest.springrest.Model.Answers;
import com.springrest.springrest.Model.Questioncore;

@Component
public class Answer_CommentServices {
	
	@Autowired
	private Answer_CommentsRepository answer_CommentsRepository;
	@Autowired
	private AnswerRepository answerRepository;
	
	  public List<Answer_Comments> getAllAnswerComment()
		{
			List<Answer_Comments>list=(List<Answer_Comments>)this.answer_CommentsRepository.findAll();
			return list;
		}

	  
	  
	  
	  public Answer_Comments getAnswerCommentById(int id)
		{
		  Answer_Comments answer_Comments=null;
			try {
				
				
			//question=list.stream().filter(e->e.getId()==id ).findFirst().get();
				answer_Comments=this.answer_CommentsRepository.findById(id);
				
			} 
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return answer_Comments;
		}
	  
	  
	  
	  
	  
	  
	  

		public Answer_Comments addAnswercomment(int answer_id,Answer_Comments  comment_text) throws Exception 
		{
			List<Answer_Comments>answer_comment=new ArrayList<>();
			Answers ans1=new Answers();
			Optional <Answers> byId=answerRepository.findById(answer_id);
			if(!byId.isPresent()) {
				
				
				throw new Exception("question with id " + answer_id + " does not exist");
			}
			Answers answers=byId.get();
			
			((Answer_Comments) comment_text).setAnswers(answers);
			Answer_Comments comment1=answer_CommentsRepository.save(comment_text);
			
			answer_comment.add(comment1);
			ans1.setAnswer_comment(answer_comment);
			return comment1;
		}
		
		
		
		
	/*  public Answer_Comments addAnswerComment(Answer_Comments ac)
		{
		  Answer_Comments result=answer_CommentsRepository.save(ac);
			return result;
		}*/
		
	  public void deleteQuestion(int id)
		{
			//list=list.stream().filter(question-> question.getId()!=qid)
			//	.collect(Collectors.toList());
			
		  answer_CommentsRepository.deleteById(id);
			
			
		}





}
