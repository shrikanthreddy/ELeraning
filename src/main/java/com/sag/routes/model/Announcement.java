package com.sag.routes.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

     @Entity
	@Table(name ="Announcement")
	public class Announcement 
	{
		@Id
	    @GeneratedValue(strategy= GenerationType.AUTO)
	    private int announcementId;
		
	      @Column
	    private String Createdby;
	    public int getAnnouncementId() {
			return announcementId;
		}

		public void setAnnouncementId(int announcementId) {
			this.announcementId = announcementId;
		}

		public String getCreatedby() {
			return Createdby;
		}

		public void setCreatedby(String createdby) {
			Createdby = createdby;
		}

		public Date getLastupdate() {
			return Lastupdate;
		}

		public void setLastupdate(Date lastupdate) {
			Lastupdate = lastupdate;
		}

		public String getActions() {
			return Actions;
		}

		public void setActions(String actions) {
			Actions = actions;
		}

		public String getAnnouncementname() {
			return Announcementname;
		}

		public String getSubject() {
			return Subject;
		}

		public void setSubject(String subject) {
			Subject = subject;
		}

		public String getDescription() {
			return Description;
		}

		public void setDescription(String description) {
			Description = description;
		}

		public String getFileComment() {
			return FileComment;
		}

		public void setFileComment(String fileComment) {
			FileComment = fileComment;
		}

		public void setAnnouncementname(String announcementname) {
			Announcementname = announcementname;
		}

		@Column
	    private Date Lastupdate;
	    
	    @Column
	    private String Actions;
	 
	    @Column
	    private String Announcementname;
	  
	    /*public UserEnrollment getUsers() {
			return users;
		}*/

		/*public void setUsers(UserEnrollment users) {
			this.users = users;
		}*/

		@Column
	    private String Subject;
	    @Column
	    private String Description;
	    @Column
	    private String FileComment;
	    
	   /* @Column
	    private UserEnrollment users;
	    */
	    @Column
	    private String FileAttach;
		public String getFileAttach() {
			return FileAttach;
		}

		public void setFileAttach(String fileAttach) {
			FileAttach = fileAttach;
		}
	    
		

		

        
	   
	   
}
