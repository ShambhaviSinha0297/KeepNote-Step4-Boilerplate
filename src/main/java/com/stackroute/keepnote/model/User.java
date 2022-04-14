package com.stackroute.keepnote.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * The class "User" will be acting as the data model for the User Table in the database. 
 * Please note that this class is annotated with @Entity annotation. 
 * Hibernate will scan all package for any Java objects annotated with the @Entity annotation. 
 * If it finds any, then it will begin the process of looking through that particular 
 * Java object to recreate it as a table in your database.
 */

@Entity
public class User {

	/*
	 * This class should have five fields (userId,userName,
	 * userPassword,userMobile,userAddedDate). Out of these five fields, the field
	 * userId should be the primary key. This class should also contain the getters
	 * and setters for the fields, along with the no-arg , parameterized constructor
	 * and toString method.The value of userAddedDate should not be accepted from
	 * the user but should be always initialized with the system date
	 */
	
	@Id
	@Column(length = 50)
	private String userId;
	@Column(length = 50)
	private String userName;
	@Column(length = 50)
	private String userPassword;
	@Column(length = 50)
	private String userMobile;
	@Column(length = 50)
	private Date userAddeDate;
	
	public User() {
		super();
	}

	public User(String string, String string1, String string2, String string3, Date date) {		
		userId=string;
		userName=string1;
		userPassword=string2;
		userMobile=string3;
		userAddeDate=date;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String string) {
		userId=string;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String string) {
		userName=string;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String string) {
		userPassword=string;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String string) {
		userMobile=string;
	}
	
	public Date getUserAddedDate() {
		return userAddeDate;
	}

	public void setUserAddedDate(Date date) {
		userAddeDate=date;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", userMobile="
				+ userMobile + ", userAddeDate=" + userAddeDate + "]";
	}
	
}
