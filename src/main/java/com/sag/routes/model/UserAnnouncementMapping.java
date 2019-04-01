package com.sag.routes.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

     @Entity
	@Table(name ="UserAnnouncementMapping")
	public class UserAnnouncementMapping 
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

 		public void setAnnouncementname(String announcementname) {
 			Announcementname = announcementname;
 		}

 		@Column
 	    private Date Lastupdate;
 	    
 	    @Column
 	    private String Actions;
 	 
 	    @Column
 	    private String Announcementname;
 	  
 		

 		

         
 	   
 	   
		
}
