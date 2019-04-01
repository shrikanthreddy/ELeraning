package com.sag.routes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "COURSE")
public class CourseTutorial 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseCode;
    @Column
    private String Course;
    @Column
    private String DeliveryMethod;
    @Column
    private String Discipline;
    @Column
    private String Status;
	public int getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(int courseCode) {
		this.courseCode = courseCode;
	}
	public String getCourse() {
		return Course;
	}
	public void setCourse(String course) {
		Course = course;
	}
	public String getDeliveryMethod() {
		return DeliveryMethod;
	}
	public void setDeliveryMethod(String deliveryMethod) {
		DeliveryMethod = deliveryMethod;
	}
	public String getDiscipline() {
		return Discipline;
	}
	public void setDiscipline(String discipline) {
		Discipline = discipline;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
    
}
