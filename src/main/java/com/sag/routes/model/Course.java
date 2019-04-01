package com.sag.routes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;

@Entity
@Table(name = "COURSE")
public class Course 
{

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseCode;
    @Column
    private String Availbale;
    @Column
    private String CourseMaterial;
    @Column
    private String Description;
    @Column
   private String Discipline;
    @Column
    private String InstructorAssignment;
    @Column
    private String Schedule;
    @Column
    private String StudentEnrollment;
    @Column
    private String Term;
    @Column
    private String courseName;
    @Column
    private String DeliveryMethod;
    @Column
    private String Status;
    
	
	public String getDeliveryMethod() {
		return DeliveryMethod;
	}
	public void setDeliveryMethod(String deliveryMethod) {
		DeliveryMethod = deliveryMethod;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public int getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(int courseCode) {
		this.courseCode = courseCode;
	}
	public String getAvailbale() {
		return Availbale;
	}
	public void setAvailbale(String availbale) {
		Availbale = availbale;
	}
	public String getCourseMaterial() {
		return CourseMaterial;
	}
	public void setCourseMaterial(String courseMaterial) {
		CourseMaterial = courseMaterial;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getDiscipline() {
		return Discipline;
	}
	public void setDiscipline(String discipline) {
		Discipline = discipline;
	}
	public String getInstructorAssignment() {
		return InstructorAssignment;
	}
	public void setInstructorAssignment(String instructorAssignment) {
		InstructorAssignment = instructorAssignment;
	}
	public String getSchedule() {
		return Schedule;
	}
	public void setSchedule(String schedule) {
		Schedule = schedule;
	}
	public String getStudentEnrollment() {
		return StudentEnrollment;
	}
	public void setStudentEnrollment(String studentEnrollment) {
		StudentEnrollment = studentEnrollment;
	}
	public String getTerm() {
		return Term;
	}
	public void setTerm(String term) {
		Term = term;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
    }
