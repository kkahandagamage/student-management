package com.greedycodes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Student {
	
	@Id
	private int id;
	
	private String name;
	private int score;
	
	public Student() {
		
	}
	
	
	@Column(name="id", nullable=false)
	public int getId() {
		return id;
	}
	
	@Column(name="name", nullable=false)
	public String getName() {
		return name;
	}
	
	@Column(name="score", nullable=false)
	public int getScore() {
		return score;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
}
