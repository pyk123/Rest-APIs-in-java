package com.springrest.springrest.Dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.springrest.springrest.Model.Answers;


public interface AnswerRepository extends CrudRepository<Answers,Integer> {
	public Optional<Answers> findById(int answer_id);

}
