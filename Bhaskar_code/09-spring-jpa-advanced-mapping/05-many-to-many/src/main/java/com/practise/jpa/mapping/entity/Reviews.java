package com.practise.jpa.mapping.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "review")
public class Reviews {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "comment")
	private String comment;

	public Reviews() {

	}

	public Reviews(String comment) {
		super();
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Reviews [id=" + id + ", comment=" + comment + "]";
	}

}
