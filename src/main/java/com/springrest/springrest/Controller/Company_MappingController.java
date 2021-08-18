package com.springrest.springrest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.Model.Answer_Comments;
import com.springrest.springrest.Model.Answers;
import com.springrest.springrest.Model.Company_Mapping;
import com.springrest.springrest.services.Company_MappingServices;

@RestController
public class Company_MappingController {
	
	private static final String HttpStutus = null;
	@Autowired
	private Company_MappingServices company_MappingServices;
	
	
	@GetMapping("/companyMapping")
	public ResponseEntity<List<Company_Mapping>>  getAllCompany_Mapping() {
		List<Company_Mapping> list=company_MappingServices.getAllCompany_Mapping() ;
		if(list.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}

	
	@PostMapping("/{Q_id}/companyMapping")
	 public Company_Mapping addCompany_Mapping(@PathVariable(value = "Q_id") int Q_id, @RequestBody Company_Mapping company_name) throws Exception {
       return company_MappingServices.addCompany_Mapping(Q_id, company_name);
      }
}
