package com.springrest.springrest.Dao;

import org.springframework.data.repository.CrudRepository;

import com.springrest.springrest.Model.Question_tag;



public interface Question_tagRepository  extends CrudRepository<Question_tag,Integer>{
	public Question_tag findById(int id);
}