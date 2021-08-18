package com.springrest.springrest.Model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Aswers")
public class Answers implements Serializable  {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id;
	
	 @Column(length=500)
	private String answer;
	 
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Q_id", nullable = false)
    //@JoinColumn(name = "user_id", nullable = false)
     @OnDelete(action = OnDeleteAction.CASCADE)
	// private Questioncore questioncore;
	 //@ManyToOne
	 //@JoinColumn(name = "Q_id",referencedColumnName = "question_id")
	 private Questioncore questioncore;
    

    
    @OneToMany(mappedBy = "answers", fetch = FetchType.LAZY)
    private List<Answer_Comments>answer_comment=new ArrayList<>();
    
    
    @OneToMany(mappedBy = "answers", fetch = FetchType.LAZY)
     private  List<Answer_Like>answer_like=new ArrayList<>();

	 
	public Answers(int id, String answer, Questioncore questioncore, List<Answer_Comments> answer_comment,
			List<Answer_Like> answer_like) {
		super();
		this.id = id;
		this.answer = answer;
		this.questioncore = questioncore;
		this.answer_comment = answer_comment;
		this.answer_like = answer_like;
	}


	public Answers(int id, String answer) {
		super();
		this.id = id;
		this.answer = answer;
	}

	public Answers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	

	public List<Answer_Comments> getAnswer_comment() {
		return answer_comment;
	}

	public void setAnswer_comment(List<Answer_Comments> answer_comment) {
		this.answer_comment = answer_comment;
	}
	
	

	public List<Answer_Like> getAnswer_like() {
		return answer_like;
	}

	public void setAnswer_like(List<Answer_Like> answer_like) {
		this.answer_like = answer_like;
	}

	@JsonIgnore
	public Questioncore getQuestioncore() {
		return questioncore;
	}
	
	public int getQuestioncore_id() {
		return questioncore.getId();
	}
	
	public int getuser_id() {
		return questioncore.getUser_id();
	}
	

	public void setQuestioncore(Questioncore questioncore) {
		this.questioncore = questioncore;
	}

	@Override
	public String toString() {
		return "Answers [id=" + id + ", answer=" + answer + "]";
	}



	
	// @ManyToOne(cascade = CascadeType.ALL)
	  //  @JoinColumn(name = "question_id")
//	private Questioncore Questioncore;
	 

	
	

	
}
