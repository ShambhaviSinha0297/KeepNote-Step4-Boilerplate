package com.stackroute.keepnote.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.keepnote.exception.NoteNotFoundException;
import com.stackroute.keepnote.exception.UserNotFoundException;
import com.stackroute.keepnote.model.Note;

/*
 * This class is implementing the UserDAO interface. This class has to be annotated with 
 * @Repository annotation.
 * @Repository - is an annotation that marks the specific class as a Data Access Object, 
 * thus clarifying it's role.
 * @Transactional - The transactional annotation itself defines the scope of a single database 
 * 					transaction. The database transaction happens inside the scope of a persistence 
 * 					context.  
 * */

@Repository
@Transactional
public class NoteDAOImpl implements NoteDAO {

	/*
	 * Autowiring should be implemented for the SessionFactory.(Use
	 * constructor-based autowiring.
	 */
	
	@Autowired
	SessionFactory sessionFactory;
	
	public NoteDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	/*
	 * Create a new note
	 */
	
	public boolean createNote(Note note) {
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis); 
		note.setNoteCreatedAt(date);
		Session session=sessionFactory.getCurrentSession();
		session.save(note);
		session.flush();
		return true;

	}

	/*
	 * Remove an existing note
	 */
	
	public boolean deleteNote(int noteId) {
		boolean flag = true;
		
		try {
			if(getNoteById(noteId)==null) {
				flag=false;
			}else {
				Session session=sessionFactory.getCurrentSession();
				session.delete(getNoteById(noteId));
				session.flush();
				}
		}
		catch (HibernateException e) {
			e.printStackTrace();
		}			
		catch (NoteNotFoundException e) {
			e.printStackTrace();
		}		
		return flag;
	}

	/*
	 * Retrieve details of all notes by userId
	 */
	
	public List<Note> getAllNotesByUserId(String userId) {
		String hql = "FROM Note note where createdBy = :userId";
		List<Note> result = sessionFactory.getCurrentSession().createQuery(hql).setParameter("userId", userId).getResultList();
		return result;
	}

	/*
	 * Retrieve details of a specific note
	 */
	
	public Note getNoteById(int noteId) throws NoteNotFoundException {
		Note  note = sessionFactory.getCurrentSession().get(Note.class, noteId);
		
		if(note==null)
			throw new NoteNotFoundException("NoteNotFoundException");
		else {
			sessionFactory.getCurrentSession().flush();
			return note;
		}
	}

	/*
	 * Update an existing note
	 */

	public boolean UpdateNote(Note note) {
		boolean flag=true;
		
		try {
			if(getNoteById(note.getNoteId())==null)
				flag=false;
			else {
				long millis=System.currentTimeMillis();  
				java.sql.Date date=new java.sql.Date(millis); 
				note.setNoteCreatedAt(date);
				sessionFactory.getCurrentSession().clear();
				sessionFactory.getCurrentSession().update(note);
				sessionFactory.getCurrentSession().flush();
			}
		}
		catch (HibernateException e) {
			e.printStackTrace();
		}
		catch (NoteNotFoundException e) {
			e.printStackTrace();
		}
		
		return flag;
	}

}
