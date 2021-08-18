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
@Table(name="Company_Mapping")
public class Company_Mapping {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id;
	private String company_name;
	
	 
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Q_id", nullable = false)
     @OnDelete(action = OnDeleteAction.CASCADE)
	// private Questioncore questioncore;
	 //@ManyToOne
	 //@JoinColumn(name = "Q_id",referencedColumnName = "question_id")
	 private Questioncore questioncore;
	
	
	public Company_Mapping(int id, String company_name) {
		super();
		this.id = id;
		this.company_name = company_name;
	}
	public Company_Mapping() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompany_name() {
		return company_name;
	}
	
	@JsonIgnore
	public Questioncore getQuestioncore() {
		return questioncore;
	}
	
	public int getQuestioncore_id() {
		return questioncore.getId();
	}
	
	//public int getQuestioncore_user() {
	//	return questioncore.getUser();
	//}

	public void setQuestioncore(Questioncore questioncore) {
		this.questioncore = questioncore;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	
	
	
	

}
