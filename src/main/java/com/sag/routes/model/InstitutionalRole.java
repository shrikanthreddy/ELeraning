package com.sag.routes.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "InstitutionalRole")
public class InstitutionalRole 
{
	 @Id
	    @GeneratedValue(strategy= GenerationType.AUTO)
	    private int id;
	    @Column
	    private String language;
	    @Column
	    private String lms;
	    @Column
	    private String code;
	    @Column
	    private String name;
	    @Column
	    private Date effectiveDate;
	    @Column
	    private Date endDate;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getLanguage() {
			return language;
		}
		public void setLanguage(String language) {
			this.language = language;
		}
		public String getLms() {
			return lms;
		}
		public void setLms(String lms) {
			this.lms = lms;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		public void setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate;
		}
		public Date getEndDate() {
			return endDate;
		}
		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}
		
	    
}
