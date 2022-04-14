package com.stackroute.keepnote.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.keepnote.exception.UserNotFoundException;
import com.stackroute.keepnote.model.User;

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
public class UserDaoImpl implements UserDAO {

	/*
	 * Autowiring should be implemented for the SessionFactory.(Use
	 * constructor-based autowiring.
	 */
	
	@Autowired
	SessionFactory sessionFactory;


	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		}

		private Session getSession() {
			return sessionFactory.getCurrentSession();
		}

	/*
	 * Create a new user
	 */

	public boolean registerUser(User user) {
		getSession().save(user);
		return Boolean.TRUE;
	}

	/*
	 * Update an existing user
	 */

	public boolean updateUser(User user) {
		getSession().update(user);
		return Boolean.TRUE;
	}

	/*
	 * Retrieve details of a specific user
	 */
	public User getUserById(String userId){
		return getSession().get(User.class, userId);
	}

	/*
	 * validate an user
	 */
	
	public boolean validateUser(String userId, String password) throws UserNotFoundException {
		User user =getUserById(userId);
		if(user==null) {
			throw new UserNotFoundException("UserNotFoundException");
		}else {
			if(!password.equals(user.getUserPassword())){
			return false;	
			}
		}	
		return true;		
	}

	/*
	 * Remove an existing user
	 */
	public boolean deleteUser(String userId) {
		User user=getUserById(userId);
		if(user!=null) {
		getSession().delete(getUserById(userId));
		return Boolean.TRUE;
		}else {
			return Boolean.FALSE;
		}
	}

}