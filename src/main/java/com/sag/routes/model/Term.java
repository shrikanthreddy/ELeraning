package com.sag.routes.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Term")
public class Term
{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int termId;
	 @Column
		private String TermName;
	 @Column
		private String Duration;
	 @Column
		private Date StartDate;
	 @Column
		private Date EndDate;
	public int getTermId() {
		return termId;
	}
	public void setTermId(int termId) {
		termId = termId;
	}
	public String getTermName() {
		return TermName;
	}
	public void setTermName(String termName) {
		TermName = termName;
	}
	public String getDuration() {
		return Duration;
	}
	public void setDuration(String duration) {
		Duration = duration;
	}
	public Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	public Date getEndDate() {
		return EndDate;
	}
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
	
	
	 
	 
	 
	 
	 
	 
	}
	
