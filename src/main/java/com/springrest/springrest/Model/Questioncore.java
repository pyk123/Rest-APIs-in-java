package com.springrest.springrest.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name="Questioncore")
//change

public class Questioncore implements Serializable  {


	@Id
   @GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name="question_id")
	private int id;
	private String question_text;
	private String Company;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JsonManagedReference
	private Topics Topic;
	
 @OneToMany(mappedBy = "questioncore", fetch = FetchType.LAZY)
 private List<Answers>Answer=new ArrayList<>();
	
	
   @OneToMany(mappedBy = "questioncore", fetch = FetchType.LAZY)
   private  List<Question_Like>question_Like=new ArrayList<>();
	
	
	@OneToMany(mappedBy = "questioncore", fetch = FetchType.LAZY)
	private List<Company_Mapping>Question_Company_Mapping=new ArrayList<>();
	//private String Question_Company_Mapping;
	
	
	@OneToMany(mappedBy = "questioncore", fetch = FetchType.LAZY)
	private List<Tags>tags=new ArrayList<>();
     
	
	@OneToMany(mappedBy = "questioncore", fetch = FetchType.LAZY)
	private List<Question_tag> question_tags=new ArrayList<>();;
	
	//@Id
	//@GeneratedValue(strategy =GenerationType.AUTO)
	private int User_id;

	public Questioncore(int id, String question_text, String company, Topics topic, List<Answers> answer,
			List<Question_Like> question_Like, List<Company_Mapping> question_Company_Mapping, List<Tags> tags,
			List<Question_tag> question_tags, int user_id) {
		super();
		this.id = id;
		this.question_text = question_text;
		Company = company;
		Topic = topic;
		Answer = answer;
		this.question_Like = question_Like;
		Question_Company_Mapping = question_Company_Mapping;
		this.tags = tags;
		this.question_tags = question_tags;
		User_id = user_id;
	}

	public Questioncore() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion_text() {
		return question_text;
	}

	public void setQuestion_text(String question_text) {
		this.question_text = question_text;
	}

	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}

	public Topics getTopic() {
		return Topic;
	}

	public void setTopic(Topics topic) {
		Topic = topic;
	}

	public List<Answers> getAnswer() {
		return Answer;
	}

	public void setAnswer(List<Answers> answer) {
		Answer = answer;
	}

	public List<Question_Like> getQuestion_Like() {
		return question_Like;
	}

	public void setQuestion_Like(List<Question_Like> question_Like) {
		this.question_Like = question_Like;
	}

	public List<Company_Mapping> getQuestion_Company_Mapping() {
		return Question_Company_Mapping;
	}

	public void setQuestion_Company_Mapping(List<Company_Mapping> question_Company_Mapping) {
		Question_Company_Mapping = question_Company_Mapping;
	}

	public List<Tags> getTags() {
		return tags;
	}

	public void setTags(List<Tags> tags) {
		this.tags = tags;
	}

	public List<Question_tag> getQuestion_tags() {
		return question_tags;
	}

	public void setQuestion_tags(List<Question_tag> question_tags) {
		this.question_tags = question_tags;
	}

	public int getUser_id() {
		return User_id;
	}

	public void setUser_id(int user_id) {
		User_id = user_id;
	}

	
	

	
	
	
	
	
}
