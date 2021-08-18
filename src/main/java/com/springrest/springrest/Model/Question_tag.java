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
@Table(name="Question_tag")
public class Question_tag {
	
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id;
	
	
	 @Column(length=500)
		private String tags_text;

	 
	 
	 @ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "Q_id", nullable = false)
	    //@JoinColumn(name = "user_id", nullable = false)
	     @OnDelete(action = OnDeleteAction.CASCADE)
		// private Questioncore questioncore;
		 //@ManyToOne
		 //@JoinColumn(name = "Q_id",referencedColumnName = "question_id")
		 private Questioncore questioncore;



	


	public Question_tag(int id, String tags_text, Questioncore questioncore) {
		super();
		this.id = id;
		this.tags_text = tags_text;
		this.questioncore = questioncore;
	}
	
	
	
	

	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public String getTags_text() {
		return tags_text;
	}





	public void setTags_text(String tags_text) {
		this.tags_text = tags_text;
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
	 
	 
	 
	 
}
