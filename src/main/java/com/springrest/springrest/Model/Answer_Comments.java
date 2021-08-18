package com.springrest.springrest.Model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Answer_Comments")
public class Answer_Comments {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id;
	private String comment_text ;
	
	 @ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "answer_id", nullable = false)
	     @OnDelete(action = OnDeleteAction.CASCADE)
		private Answers answers;
	 
	 private Questioncore questioncore; 
	 
	public Answer_Comments(int id, String comment_text, Answers answers) {
		super();
		this.id = id;
		this.comment_text = comment_text;
		this.answers = answers;
	}


	public Answer_Comments() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getComment_text() {
		return comment_text;
	}


	public void setComment_text(String comment_text) {
		this.comment_text = comment_text;
	}

	@JsonIgnore
	public Answers getAnswers() {
		return answers;
	}
	public int getAnswer_id() {
		return answers.getId();
	}

	public void setAnswers(Answers answers) {
		this.answers = answers;
	}

	@JsonIgnore
	public Questioncore getQuestioncore() {
		return questioncore;
	}
	public int getuser_id() {
		return questioncore.getUser_id();
	}

	public void setQuestioncore(Questioncore questioncore) {
		this.questioncore = questioncore;
	}
		

}
