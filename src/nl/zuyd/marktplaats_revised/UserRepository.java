package nl.zuyd.marktplaats_revised;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import nl.zuyd.marktplaats_revised.entities.User;


@Singleton
public class UserRepository implements IRepository<User> 
{
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public User getById(int id)
	{
		return this.em.find(User.class, id);
	}

	@Override
	public List<User> getAll()
	{
		TypedQuery<User> q = this.em.createQuery("SELECT c FROM User c", User.class);
		return q.getResultList();
	}
	
	/**
	 * Find instances of User differentiated by username
	 * @param username String
	 * @return
	 */
	public User getByUsername(String username) {
		TypedQuery<User> q = this.em.createQuery("SELECT c FROM USER c WHERE c.username = " + username, User.class);
		return q.getSingleResult();
	}
}