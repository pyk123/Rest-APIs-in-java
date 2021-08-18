package com.springrest.springrest.Dao;

import org.springframework.data.repository.CrudRepository;


import com.springrest.springrest.Model.Question_Like;

public interface Question_LikeRepository  extends CrudRepository<Question_Like,Integer>{
	public Question_Like findById(int id);
}
