package com.springrest.springrest.Dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.springrest.springrest.Model.Questioncore;

public interface QuestionRepository extends CrudRepository<Questioncore,Integer>{
public Optional<Questioncore> findById(int id);

}
