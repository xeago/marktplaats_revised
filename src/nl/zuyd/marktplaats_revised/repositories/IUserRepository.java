package nl.zuyd.marktplaats_revised.repositories;

import java.util.List;

import javax.ejb.Local;

import nl.zuyd.marktplaats_revised.entities.User; 

@Local
public interface IUserRepository
{
	User getByPK(String id); 
	User getById(int id);
	User getByUsername(String username);
	
	List<User> getAll();
	
	void addUser(User user);
	void deleteUser(User user);
	void saveUser(User user);	
}