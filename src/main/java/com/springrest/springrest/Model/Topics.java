package com.springrest.springrest.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Topic")
public class Topics {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
private int topcid;
	private String topic;
	private String subtopic;
	
	
	@OneToOne(mappedBy="Topic")
	@JsonBackReference
	private Questioncore question;
	
	

	public Topics(int topcid, String topic, String subtopic) {
		super();
		this.topcid = topcid;
		this.topic = topic;
		this.subtopic = subtopic;
		
	}
	public Topics() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getTopcid() {
		return topcid;
	}
	public void setTopcid(int topcid) {
		this.topcid = topcid;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getSubtopic() {
		return subtopic;
	}
	public void setSubtopic(String subtopic) {
		this.subtopic = subtopic;
	}
	public Questioncore getQuestion() {
		return question;
	}
	public void setQuestion(Questioncore question) {
		this.question = question;
	}
	
	@Override
	public String toString() {
		return "Topics [topcid=" + topcid + ", topic=" + topic + ", subtopic=" + subtopic + "]";
	}


}
