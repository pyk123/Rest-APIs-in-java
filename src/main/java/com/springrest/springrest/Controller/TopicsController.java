package com.springrest.springrest.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.Model.Questioncore;
import com.springrest.springrest.Model.Topics;
import com.springrest.springrest.services.TopicsServices;

@RestController
public class TopicsController {
	
	private static final String HttpStutus = null;
	@Autowired
	private TopicsServices topicsServices;
	

	@GetMapping("/topics")
	public ResponseEntity<List<Topics>> getTopics() {
		List<Topics> list=topicsServices.getAllTopics() ;
		if(list.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	
	@PostMapping("/topics")
	public ResponseEntity<Topics> addTopics(@RequestBody Topics Topic)
	{
		Topics T=null;
		
	
		try {
		 T= this.topicsServices.addTopics(Topic);
		 System.out.println(Topic);
		 return ResponseEntity.of(Optional.of(T));
		 
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
		
	}
	

}
