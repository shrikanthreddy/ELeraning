package com.sag.routes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FeedBack")
public class FeedBack {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int FeedBackId;
	 public int getFeedBackId() {
		return FeedBackId;
	}
	public void setFeedBackId(int feedBackId) {
		FeedBackId = feedBackId;
	}
	public String getFeedBack() {
		return FeedBack;
	}
	public void setFeedBack(String feedBack) {
		FeedBack = feedBack;
	}
	@Column
	private String FeedBack;
	 
	
	 
}