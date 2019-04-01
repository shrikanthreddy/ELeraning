package com.sag.routes.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Organization")
public class Organization 
{
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	
	private int oId;
	public int getoId() {
		return oId;
	}
	public void setoId(int oId) {
		this.oId = oId;
	}
	@Column
	private String Language;
	@Column
	private String OrganizationCode;
	@Column
	private String OrganizationName;
	@Column
	private Date Effective;
	@Column
	private Date EndDate;
	@Column
	private String Type;
	
	@Column
	private String PrimaryContact;
	@Column
	private String Street;
	@Column
	private String City;
	
	@Column
	private String Country;
	
	@Column
	private String State;
	
	@Column
	private String PostalCode;
	
	public String getLanguage() {
		return Language;
	}
	public void setLanguage(String language) {
		Language = language;
	}
	public String getOrganizationCode() {
		return OrganizationCode;
	}
	public void setOrganizationCode(String organizationCode) {
		OrganizationCode = organizationCode;
	}
	public String getOrganizationName() {
		return OrganizationName;
	}
	public void setOrganizationName(String organizationName) {
		OrganizationName = organizationName;
	}
	public Date getEffective() {
		return Effective;
	}
	public void setEffective(Date effective) {
		Effective = effective;
	}
	public Date getEndDate() {
		return EndDate;
	}
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getPrimaryContact() {
		return PrimaryContact;
	}
	public void setPrimaryContact(String primaryContact) {
		PrimaryContact = primaryContact;
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
	
	
	
	

	
	
	
	
}
