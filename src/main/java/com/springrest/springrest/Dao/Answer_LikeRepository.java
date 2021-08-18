package com.springrest.springrest.Dao;

import org.springframework.data.repository.CrudRepository;

import com.springrest.springrest.Model.Answer_Like;


public interface Answer_LikeRepository extends CrudRepository<Answer_Like,Integer> {
	public Answer_Like findById(int id);
}
