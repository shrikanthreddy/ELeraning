package com.sag.routes.model;


	
	
	import java.util.Date;
	import java.util.List;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table(name ="Discipline")
	public class Discipline 
	{

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private int ownerOrganization;
		 @Column
	   private String Code;
		 @Column
	   private String Language; 
		 @Column
	   private String Name;
		 @Column
	   private String Description;
		 @Column
	   private String Ordinal;
		 @Column
	   private String Status;
		public int getOwnerOrganization() {
			return ownerOrganization;
		}
		public void setOwnerOrganization(int ownerOrganization) {
			this.ownerOrganization = ownerOrganization;
		}
		public String getCode() {
			return Code;
		}
		public void setCode(String code) {
			Code = code;
		}
		public String getLanguage() {
			return Language;
		}
		public void setLanguage(String language) {
			Language = language;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public String getDescription() {
			return Description;
		}
		public void setDescription(String description) {
			Description = description;
		}
		public String getOrdinal() {
			return Ordinal;
		}
		public void setOrdinal(String ordinal) {
			Ordinal = ordinal;
		}
		public String getStatus() {
			return Status;
		}
		public void setStatus(String status) {
			Status = status;
		}
		 
		 

	

	
}
