package com.stackroute.keepnote.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/*
 * The class "Note" will be acting as the data model for the Note Table in the database. 
 * Please note that this class is annotated with @Entity annotation. 
 * Hibernate will scan all package for any Java objects annotated with the @Entity annotation. 
 * If it finds any, then it will begin the process of looking through that particular 
 * Java object to recreate it as a table in your database.
 */

@Entity
public class Note {
	/*
	 * This class should have eight fields
	 * (noteId,noteTitle,noteContent,noteStatus,createdAt,
	 * category,reminder,createdBy). Out of these eight fields, the field noteId
	 * should be primary key and auto-generated. This class should also contain the
	 * getters and setters for the fields along with the no-arg , parameterized
	 * constructor and toString method. The value of createdAt should not be
	 * accepted from the user but should be always initialized with the system date.
	 * annotate category and reminder field with @ManyToOne.
	 */
	
	@Id
	private int noteId;
	private String noteTitle;
	private String noteContent;
	private String noteStatus;
	private Date createdAt;
	private String createdBy;
	@ManyToOne
	private Category category;
	@ManyToOne
	private Reminder reminder;
	
	

	public Note() {
		super();
	}

	public Note(int Int, String string, String string1, String string2, Date date, Category category, Reminder reminder,
			String string3) {
		noteId=Int;
		noteTitle=string;
		noteContent=string1;
		noteStatus=string2;
		createdAt=date;
		this.category=category;
		this.reminder=reminder;
		createdBy=string3;
	}


	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int Int) {
		noteId=Int;
	}

	public String getNoteTitle() {
		return noteTitle;
	}

	public void setNoteTitle(String string) {
		noteTitle=string;
	}

	public String getNoteContent() {
		return noteContent;
	}

	public void setNoteContent(String string) {
		noteContent=string;
	}
	
	public String getNoteStatus() {
		return noteStatus;
	}

	public void setNoteStatus(String string) {
		noteStatus=string;
	}
	
	public Date getNoteCreatedAt() {
		return createdAt;
	}

	public void setNoteCreatedAt(Date date) {
		createdAt=date;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}
	
	public void setCreatedBy(String string) {
		createdBy=string;
	}
	
	public Reminder getReminder() {
		return reminder;
	}
	
	public void setReminder(Reminder reminder) {
		this.reminder=reminder;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category=category;
	}
	
	
	@Override
	public String toString() {
		return "Note [noteId=" + noteId + ", noteTitle=" + noteTitle + ", noteContent=" + noteContent + ", noteStatus="
				+ noteStatus + ", createdAt=" + createdAt + ", category=" + category + ", reminder=" + reminder
				+ ", createdBy=" + createdBy + "]";
	}

}
