package nl.zuyd.marktplaats_revised;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Singleton
public class AdvertisementRepository implements IRepository<Advertisement> 
{
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Advertisement getById(int id)
	{
		return this.em.find(Advertisement.class, id);
	}	

	@Override
	public List<Advertisement> getAll()
	{
		TypedQuery<Advertisement> q = this.em.createQuery("SELECT c FROM Advertisement c", Advertisement.class);
		return q.getResultList();
	}
}