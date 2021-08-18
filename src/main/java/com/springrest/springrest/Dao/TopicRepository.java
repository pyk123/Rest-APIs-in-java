package com.springrest.springrest.Dao;

import org.springframework.data.repository.CrudRepository;

import com.springrest.springrest.Model.Tags;
import com.springrest.springrest.Model.Topics;

public interface TopicRepository extends CrudRepository<Topics,Integer>{
	public Topics findById(int id);
}