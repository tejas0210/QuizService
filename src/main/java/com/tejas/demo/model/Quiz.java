package com.tejas.demo.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data

@Entity
public class Quiz {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	
	@ElementCollection
	private List<Integer> questionIds;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Integer> getQuestionIds() {
		return questionIds;
	}

	public void setQuestionIds(List<Integer> question) {
		this.questionIds = question;
	}
}
