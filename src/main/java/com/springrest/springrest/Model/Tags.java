package com.springrest.springrest.Model;

import javax.persistence.Column;
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
@Table(name="Tags")
public class Tags {
	
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id;
	
	 @Column(length=500)
	private String tag;
	 
	 
	 @ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "Q_id", nullable = false)
	    //@JoinColumn(name = "user_id", nullable = false)
	     @OnDelete(action = OnDeleteAction.CASCADE)
		// private Questioncore questioncore;
		 //@ManyToOne
		 //@JoinColumn(name = "Q_id",referencedColumnName = "question_id")
		 private Questioncore questioncore;


	public Tags(int id, String tag, Questioncore questioncore) {
		super();
		this.id = id;
		this.tag = tag;
		this.questioncore = questioncore;
	}


	public Tags() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTag() {
		return tag;
	}


	public void setTag(String tag) {
		this.tag = tag;
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
		return "Tags [id=" + id + ", tag=" + tag + ", questioncore=" + questioncore + "]";
	} 

}
