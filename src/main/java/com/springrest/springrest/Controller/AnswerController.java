package com.springrest.springrest.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.Model.Answers;
import com.springrest.springrest.Model.Questioncore;
import com.springrest.springrest.services.AnswerServices;
import com.springrest.springrest.services.Services;

@RestController
public class AnswerController {
	
	
	private static final String HttpStutus = null;
	@Autowired
	private AnswerServices answerservices;
	
	
	

	@GetMapping("/answers")
	public ResponseEntity<List<Answers>> getAllAnswer() {
		List<Answers> list=answerservices.getAllAnswer() ;
		if(list.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	
	
	@GetMapping("/answers/{id}")
	//public Answers getAnswerById(@PathVariable(value = "id") int id) {
  //      return answerservices.getAnswerById(id);
   // }
	public ResponseEntity<Optional<Answers>> getAnswer(@PathVariable("id")int id)
	{
		Optional<Answers> answer=answerservices.getAnswerById(id);
		if(answer==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(answer)) ;
	}
	
	
	
	
	@PostMapping("/{Q_id}/answer")
	 public Answers addAnswer(@PathVariable(value = "Q_id") int Q_id, @RequestBody Answers answer) throws Exception {
        return answerservices.addAnswer(Q_id, answer);
       }
/*	public ResponseEntity<Answers> addAnswer(int question_id,@RequestBody Answers answer)
	{
		Answers a=null;
		
	try {
		 a= this.answerservices.addAnswer(answer);
		 System.out.println(answer);
	 return ResponseEntity.of(Optional.of(a));
		 
		}catch(Exception e) {
			e.printStackTrace();
	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
		
	}*/
	
	
	
	@DeleteMapping("/answers/{aid}")
	public   ResponseEntity<Object> deleteAnswer(@PathVariable("aid") int aid)
	{
		try {
			this.answerservices.deleteAnswer(aid);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}catch (Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	
		
	}
	
	@PutMapping("/answers/{aid}")
	public ResponseEntity<Answers> UpdateQuestion(@RequestBody Answers answer ,@PathVariable
			("aid") int aid)
	{
		try {
	this.answerservices.UpdateAnswer( answer, aid);
	return ResponseEntity.ok().body(answer);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	
	}

	
	
	/* @RequestMapping(value = "/getAllBooks", method = RequestMethod.GET)
	    public List<Answers> getBooks() {
	        return answerservices.getAllBooks();
	    }


	    //Book
	    @RequestMapping(value = "/{questionId}/book", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	    public Answers createBook(@PathVariable(value = "questionId") int questionId, @RequestBody Answers book) throws Exception {
	        return answerservices.createBook(questionId, book);
	    }

	    @RequestMapping(value = "/book/{Id}", method = RequestMethod.GET)
	    public Optional<Answers> getBookById(@PathVariable(value = "Id") int Id) throws Exception {
	        return answerservices.getBookById(Id);
	    }
*/
}
