package com.springrest.springrest.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.Dao.Answer_CommentsRepository;
import com.springrest.springrest.Model.Answer_Comments;
import com.springrest.springrest.Model.Answers;
import com.springrest.springrest.services.AnswerServices;
import com.springrest.springrest.services.Answer_CommentServices;

@RestController
public class Answer_CommentController {
	
	
	private static final String HttpStutus = null;
	@Autowired
	private Answer_CommentServices answer_commentServices;
	
	
	
	
	@GetMapping("/answerscomment")
	public ResponseEntity<List<Answer_Comments>> getAllAnswerComment() {
		List<Answer_Comments> list=answer_commentServices.getAllAnswerComment() ;
		if(list.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	
	
	@GetMapping("/answerscomment/{id}")
	//public Answers getAnswerById(@PathVariable(value = "id") int id) {
  //      return answerservices.getAnswerById(id);
   // }
	public ResponseEntity<Answer_Comments> getAnswercomment(@PathVariable("id")int id)
	{
		Answer_Comments answer_Comments=answer_commentServices.getAnswerCommentById(id);
		if(answer_Comments==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(answer_Comments)) ;
	}

	
	
	

	@PostMapping("/{answer_id}/answerscomment")
	 public Answer_Comments addAnswercomment(@PathVariable(value = "answer_id") int answer_id, @RequestBody Answer_Comments comment_text) throws Exception {
        return answer_commentServices.addAnswercomment(answer_id, comment_text);
       }
}
