package com.springrest.springrest.Dao;

import org.springframework.data.repository.CrudRepository;


import com.springrest.springrest.Model.Company_Mapping;

public interface Company_MappingRepositpry  extends CrudRepository<Company_Mapping,Integer>{
	public Company_Mapping findById(int id);
}
