package nl.zuyd.marktplaats_revised.repositories;

import java.util.List;

import javax.ejb.Local;

import nl.zuyd.marktplaats_revised.entities.User; 

// TODO: Auto-generated Javadoc
/**
 * The Interface IUserRepository.
 */
@Local
public interface IUserRepository
{
	
	/**
	 * Gets the user by pk.
	 *
	 * @param id the id
	 * @return User
	 */
	User getByPK(String id); 
	
	/**
	 * Gets the by id.
	 *
	 * @param id the id
	 * @return the by id
	 */
	User getById(int id);
	
	/**
	 * Gets the User by username.
	 *
	 * @param username the username
	 * @return the User by username
	 */
	User getByUsername(String username);
	
	/**
	 * Gets all the User instances from the DB
	 *
	 * @return all the Users
	 */
	List<User> getAll();
	
	/**
	 * Adds the user to the DB
	 *
	 * @param User The user
	 */
	void addUser(User user);
	
	/**
	 * Delete a user from the DB
	 *
	 * @param user the user
	 */
	void deleteUser(User user);
	
	/**
	 * Save user.
	 *
	 * @param user the user
	 */
	void saveUser(User user);	
}