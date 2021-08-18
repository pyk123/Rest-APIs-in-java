package com.springrest.springrest.Dao;

import org.springframework.data.repository.CrudRepository;

import com.springrest.springrest.Model.Company_Mapping;
import com.springrest.springrest.Model.Tags;

public interface TagsRepository  extends CrudRepository<Tags,Integer>{
	public Tags findById(int id);
}