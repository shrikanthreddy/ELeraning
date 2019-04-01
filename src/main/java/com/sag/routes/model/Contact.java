package com.sag.routes.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Contact")
public class Contact {

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getUserRequest() {
		return UserRequest;
	}

	public void setUserRequest(String userRequest) {
		UserRequest = userRequest;
	}

	public String getMessageInbox() {
		return MessageInbox;
	}

	public void setMessageInbox(String messageInbox) {
		MessageInbox = messageInbox;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contactId", nullable = false, updatable = false)
	private int contactId;

	@Column(name = "UserRequest", nullable = false, unique = true)
	@Email(message = "Please provide a valid UserRequest")
	@NotEmpty(message = "Please provide an UserRequest")
	private String UserRequest;

	@Column(name = "MessageInbox", nullable = false)
	private String MessageInbox;

	@Column(name = "Description")
	@NotEmpty(message = "Please provide your Description")
	private String Description;

	
}