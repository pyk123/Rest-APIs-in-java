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
@Table(name="Question_Like")
public class Question_Like {

	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id;

	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Q_id", nullable = false)
    //@JoinColumn(name = "user_id", nullable = false)
     @OnDelete(action = OnDeleteAction.CASCADE)
	// private Questioncore questioncore;
	 //@ManyToOne
	 //@JoinColumn(name = "Q_id",referencedColumnName = "question_id")
	 private Questioncore questioncore;



	public Question_Like(int id, Questioncore questioncore) {
		super();
		this.id = id;
		this.questioncore = questioncore;
	}



	public Question_Like() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}


	@JsonIgnore
	public Questioncore getQuestioncore() {
		return questioncore;
	}
	
	public int getQuestioncore_id() {
		return questioncore.getId();
	}
	
	
	

	public void setQuestioncore(Questioncore questioncore) {
		this.questioncore = questioncore;
	}


	@Override
	public String toString() {
		return "Question_Like [id=" + id + ", questioncore=" + questioncore + "]";
	}
    
	
	
	
	
}
