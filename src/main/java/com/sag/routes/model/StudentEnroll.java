package com.sag.routes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


	
	@Entity
	@Table(name ="StudentEnroll")
	public class StudentEnroll
	{

	   @Id
	    @GeneratedValue(strategy= GenerationType.AUTO)
	    @Column
	    private int userid;
	    @Column
	    private String Username;
	    @Column
	    private String Firstname;
	    @Column
	    @JsonIgnore
	    private String Lastname;
	    @Column
	    private String Email;
	    @Column
	    private String PreferredLanguage;
	    @Column
	    private String  Organizations;
	    @Column
	    private String  InstitutionalRole;
	    @Column
	    private String  SystemRole;
	    @Column
	    private String  EffectiveDate;
	    
	    @Column
	    private String  EndDate;
	    @Column
	    private String  Voice;
	    public String getEffectiveDate() {
			return EffectiveDate;
		}
		public void setEffectiveDate(String effectiveDate) {
			EffectiveDate = effectiveDate;
		}
		public String getEndDate() {
			return EndDate;
		}
		public void setEndDate(String endDate) {
			EndDate = endDate;
		}
		public String getVoice() {
			return Voice;
		}
		public void setVoice(String voice) {
			Voice = voice;
		}
		public String getMobile() {
			return Mobile;
		}
		public void setMobile(String mobile) {
			Mobile = mobile;
		}
		public String getFax() {
			return Fax;
		}
		public void setFax(String fax) {
			Fax = fax;
		}
		public String getAffiliation() {
			return Affiliation;
		}
		public void setAffiliation(String affiliation) {
			Affiliation = affiliation;
		}
		public String getStreet() {
			return Street;
		}
		public void setStreet(String street) {
			Street = street;
		}
		public String getCity() {
			return City;
		}
		public void setCity(String city) {
			City = city;
		}
		public String getCountry() {
			return Country;
		}
		public void setCountry(String country) {
			Country = country;
		}
		public String getState() {
			return State;
		}
		public void setState(String state) {
			State = state;
		}
		public String getPostalCode() {
			return PostalCode;
		}
		public void setPostalCode(String postalCode) {
			PostalCode = postalCode;
		}
		@Column
	    private String  Mobile;
	    @Column
	    private String  Fax;
	    @Column
	    private String  Affiliation;
	    @Column
	    private String  Street;
	    @Column
	    private String  City;
	    
	    @Column
	    private String  Country;
	    @Column
	    private String  State;
	    @Column
	    private String  PostalCode;
	    
		public int getUserid() {
			return userid;
		}
		public void setUserid(int userid) {
			this.userid = userid;
		}
		public String getUsername() {
			return Username;
		}
		public void setUsername(String username) {
			Username = username;
		}
		public String getFirstname() {
			return Firstname;
		}
		public void setFirstname(String firstname) {
			Firstname = firstname;
		}
		public String getLastname() {
			return Lastname;
		}
		public void setLastname(String lastname) {
			Lastname = lastname;
		}
		public String getEmail() {
			return Email;
		}
		public void setEmail(String email) {
			Email = email;
		}
		public String getPreferredLanguage() {
			return PreferredLanguage;
		}
		public void setPreferredLanguage(String preferredLanguage) {
			PreferredLanguage = preferredLanguage;
		}
		public String getOrganizations() {
			return Organizations;
		}
		public void setOrganizations(String organizations) {
			Organizations = organizations;
		}
		public String getInstitutionalRole() {
			return InstitutionalRole;
		}
		public void setInstitutionalRole(String institutionalRole) {
			InstitutionalRole = institutionalRole;
		}
		public String getSystemRole() {
			return SystemRole;
		}
		public void setSystemRole(String systemRole) {
			SystemRole = systemRole;
		}
	    
	    
	    
	}
