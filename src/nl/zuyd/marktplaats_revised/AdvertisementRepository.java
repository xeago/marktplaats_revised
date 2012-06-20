package nl.zuyd.marktplaats_revised;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import nl.zuyd.marktplaats_revised.entities.Advertisement;

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
	
	public List<Advertisement> getByTitle(String title) {
		TypedQuery<Advertisement> q = this.em.createNamedQuery("SELECT c FROM Advertisement c WHERE c.title = " + title, Advertisement.class);
		return q.getResultList();
	}
}