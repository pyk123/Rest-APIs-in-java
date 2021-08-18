package com.springrest.springrest.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springrest.springrest.Model.Answer_Comments;


public interface Answer_CommentsRepository extends CrudRepository<Answer_Comments,Integer>{
	
	
	public Answer_Comments findById(int id);

	

}
