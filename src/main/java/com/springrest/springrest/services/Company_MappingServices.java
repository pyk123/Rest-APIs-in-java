package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springrest.springrest.Dao.Company_MappingRepositpry;
import com.springrest.springrest.Dao.QuestionRepository;
import com.springrest.springrest.Model.Answers;
import com.springrest.springrest.Model.Company_Mapping;
import com.springrest.springrest.Model.Questioncore;

@Component
public class Company_MappingServices {
	@Autowired
	private Company_MappingRepositpry company_MappingRepositpry;
	@Autowired
	private QuestionRepository questionRepository;
	
	  public List<Company_Mapping> getAllCompany_Mapping()
		{
			List<Company_Mapping>list=(List<Company_Mapping>)this.company_MappingRepositpry.findAll();
			return list;
		}
		

	  
		public Company_Mapping addCompany_Mapping(int Q_id,Company_Mapping company_name) throws Exception 
		{
			List<Company_Mapping>Question_Company_Mapping=new ArrayList<>();
			Questioncore question1=new Questioncore();
			Optional <Questioncore> byId=questionRepository.findById(Q_id);
			if(!byId.isPresent()) {
				
				
				throw new Exception("question with id " + Q_id + " does not exist");
			}
			
			Questioncore questioncore=byId.get();
			
			company_name.setQuestioncore(questioncore);
			Company_Mapping company1=company_MappingRepositpry.save(company_name);
			
			Question_Company_Mapping.add(company1);
			question1.setQuestion_Company_Mapping(Question_Company_Mapping);
			return company1;
		}
		
		
}
