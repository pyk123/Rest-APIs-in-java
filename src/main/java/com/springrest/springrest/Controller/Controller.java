package com.springrest.springrest.Controller;

import java.awt.PageAttributes.MediaType;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.springrest.springrest.Model.Questioncore;
import com.springrest.springrest.services.Services;

@RestController
public class Controller {
	private static final String HttpStutus = null;
	@Autowired
	private Services services;
	
	
	@GetMapping("/questions")
	public ResponseEntity<List<Questioncore>> getQuestions() {
		List<Questioncore> list=services.getAllQuestions() ;
		if(list.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	
	
	@GetMapping("/questions/{id}")
	public ResponseEntity<Optional<Questioncore>> getQuestion(@PathVariable("id")int id)
	{
		Optional<Questioncore> question=services.getQuestionById((int) id);
		if(question==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(question)) ;
	}
	
	
	
	
	@PostMapping("/questions")
	public ResponseEntity<Questioncore> addQuestion(@RequestBody Questioncore question)
	{
		Questioncore q=null;
		
	
		try {
		 q= this.services.addQuestion(question);
		 System.out.println(question);
		 return ResponseEntity.of(Optional.of(q));
		 
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
		
	}
	
	
	
	@DeleteMapping("/questions/{qid}")
	public   ResponseEntity<Object> deleteQuestion(@PathVariable("qid") int qid)
	{
		try {
			this.services.deleteQuestion(qid);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}catch (Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	
		
	}
	
	@PutMapping("/questions/{qid}")
	public ResponseEntity<Questioncore> UpdateQuestion(@RequestBody Questioncore question ,@PathVariable
			("qid") int qid)
	{
		try {
	this.services.UpdateQuestion( question, qid);
	return ResponseEntity.ok().body(question);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	
	}

	
	/*@RequestMapping(value = "/getAllAuthors", method = RequestMethod.GET)
    public List<Questioncore> getAuthors() {
        return services.getAuthors();
    }


    @RequestMapping(value = "/author", method = RequestMethod.POST)
    public Questioncore createAuthor(@RequestBody Questioncore author) {
        return services.createAuthor(author);
    }
	*/
}
