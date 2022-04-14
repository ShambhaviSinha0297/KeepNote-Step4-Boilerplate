package com.stackroute.keepnote.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*
 * The class "Category" will be acting as the data model for the Category Table in the database. 
 * Please note that this class is annotated with @Entity annotation. 
 * Hibernate will scan all package for any Java objects annotated with the @Entity annotation. 
 * If it finds any, then it will begin the process of looking through that particular 
 * Java object to recreate it as a table in your database.
 */

@Entity
public class Category {
	/*
	 * This class should have six fields
	 * (categoryId,categoryName,categoryDescription,
	 * categoryCreatedBy,categoryCreationDate,notes). Out of these six fields, the
	 * field categoryId should be primary key and auto-generated. This class should
	 * also contain the getters and setters for the fields along with the no-arg ,
	 * parameterized constructor and toString method. The value of
	 * categoryCreationDate should not be accepted from the user but should be
	 * always initialized with the system date. annotate notes field with @OneToMany
	 * and @JsonIgnore
	 */
	
	@Id
	private int categoryId;
	private String categoryName;
	private String categoryDescription;
	private Date categoryCreationDate;
	private String categoryCreatedBy;
	
	@OneToMany
	@JsonIgnore
	private List<Note> notes;

	public Category() {
		super();
	}

	public Category(int Int, String string, String string1, Date date, String string2, List<Note> list) {
		categoryId=Int;
		categoryName=string;
		categoryDescription=string1;
		categoryCreatedBy=string2;
		categoryCreationDate=date;
		notes=list;
	}

	public int getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(int Int) {
		categoryId=Int;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String string) {
		categoryName=string;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String string) {
		categoryDescription=string;
	}

	public Date getCategoryCreationDate() {
		return categoryCreationDate;
	}
	
	public void setCategoryCreationDate(Date date) {
		categoryCreationDate=date;
	}

	public String getCategoryCreatedBy() {
		return categoryCreatedBy;
	}

	public void setCategoryCreatedBy(String string) {
		categoryCreatedBy=string;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> list) {
		notes=list;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryDescription="
				+ categoryDescription + ", categoryCreationDate=" + categoryCreationDate + ", categoryCreatedBy="
				+ categoryCreatedBy + ", notes=" + notes + "]";
	}
	
}