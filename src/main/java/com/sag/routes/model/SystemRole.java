package com.sag.routes.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Systemrole")
public class SystemRole 
{
		@Id
	    @GeneratedValue(strategy= GenerationType.AUTO)
	    private int systemRoleId;
	    @Column
	    private String language;
	    @Column
	    private String organization;
	    @Column
	    private String roleId;
	    @Column
	    private String roleName;
	    @Column
	    private Date effectiveDate;
	    @Column
	    private Date endDate;
	    
		public int getSystemRole() {
			return systemRoleId;
		}
		public void setSystemRole(int systemRole) {
			this.systemRoleId = systemRoleId;
		}
		public String getLanguage() {
			return language;
		}
		public void setLanguage(String language) {
			this.language = language;
		}
		public String getOrganization() {
			return organization;
		}
		public void setOrganization(String organization) {
			this.organization = organization;
		}
		public String getRoleId() {
			return roleId;
		}
		public void setRoleId(String roleId) {
			this.roleId = roleId;
		}
		public String getRoleName() {
			return roleName;
		}
		public void setRoleName(String roleName) {
			this.roleName = roleName;
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
