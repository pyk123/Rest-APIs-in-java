package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springrest.springrest.Dao.TopicRepository;
import com.springrest.springrest.Model.Answers;
import com.springrest.springrest.Model.Questioncore;
import com.springrest.springrest.Model.Topics;

@Component
public class TopicsServices {
	@Autowired
	private TopicRepository topicRepository;
	
	
	  public List<Topics> getAllTopics()
		{
			List<Topics>list=(List<Topics>)this.topicRepository.findAll();
			return list;
		}
		
	  
	  public Topics addTopics(Topics T)
		{
		  Topics result=topicRepository.save(T);
			return result;
		}
	  
	  
	
}
