package nl.zuyd.marktplaats_revised.repositories;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import nl.zuyd.marktplaats_revised.entities.Advertisement;
import nl.zuyd.marktplaats_revised.entities.User;

// TODO: Auto-generated Javadoc
/**
 * The Class AdvertisementRepository.
 */
@Singleton
@Local(IAdvertisementRepository.class)
public class AdvertisementRepository implements IAdvertisementRepository
{
	
	/** The em. */
	@PersistenceContext
	private EntityManager em;
	
	/* (non-Javadoc)
	 * @see nl.zuyd.marktplaats_revised.repositories.IAdvertisementRepository#getById(int)
	 */
	@Override
	public Advertisement getById(int id)
	{
		return this.em.find(Advertisement.class, id);
	}
	
	/* (non-Javadoc)
	 * @see nl.zuyd.marktplaats_revised.repositories.IAdvertisementRepository#deleteAdvertisement(nl.zuyd.marktplaats_revised.entities.Advertisement)
	 */
	@Override
	public void deleteAdvertisement(Advertisement a)
	{
		a = this.em.merge(a);
		this.em.remove(a);
		this.em.flush();
	}
	
	/* (non-Javadoc)
	 * @see nl.zuyd.marktplaats_revised.repositories.IAdvertisementRepository#getAll()
	 */
	@Override
	public List<Advertisement> getAll()
	{
		TypedQuery<Advertisement> q = this.em.createQuery(
				"SELECT c FROM Advertisement c", Advertisement.class);
		return q.getResultList();
	}
	
	/**
	 * Find all advertisements where a certain title is matched.
	 *
	 * @param title String
	 * @return the by title
	 */
	@Override
	public List<Advertisement> getByTitle(String title)
	{
		TypedQuery<Advertisement> q = this.em.createQuery(
				"SELECT c FROM Advertisement c WHERE c.title = " + title,
				Advertisement.class);
		return q.getResultList();
	}
	
	/* (non-Javadoc)
	 * @see nl.zuyd.marktplaats_revised.repositories.IAdvertisementRepository#addAdvertisement(nl.zuyd.marktplaats_revised.entities.Advertisement)
	 */
	@Override
	public void addAdvertisement(Advertisement add)
	{
		em.persist(add);
		this.em.flush();
	}
	
	/* (non-Javadoc)
	 * @see nl.zuyd.marktplaats_revised.repositories.IAdvertisementRepository#updateAdvertisement(nl.zuyd.marktplaats_revised.entities.Advertisement)
	 */
	@Override
	public void updateAdvertisement(Advertisement advert)
	{
		advert = this.em.merge(advert);
		this.em.flush();
	}
	
	/* (non-Javadoc)
	 * @see nl.zuyd.marktplaats_revised.repositories.IAdvertisementRepository#findBySearch(java.lang.String)
	 */
	@Override
	public List<Advertisement> findBySearch(String keyword)
	{
		TypedQuery<Advertisement> q = this.em
				.createQuery(
						"SELECT c FROM Advertisement c WHERE UPPER(c.title) LIKE UPPER( :keyword ) OR UPPER(c.description) LIKE UPPER( :keyword )",
						Advertisement.class);
		q.setParameter("keyword", "%" + keyword + "%");
		
		System.out.print("ophalen...");
		
		List<Advertisement> result = q.getResultList();
		
		System.out.print("opgehaald: " + result.size());
		
		return result;
	}
	
	/* (non-Javadoc)
	 * @see nl.zuyd.marktplaats_revised.repositories.IAdvertisementRepository#getAdvertisementsByUser(nl.zuyd.marktplaats_revised.entities.User)
	 */
	@Override
	public List<Advertisement> getAdvertisementsByUser(User user)
	{
		TypedQuery<Advertisement> q = this.em
				.createQuery(
						""
								+ "SELECT c FROM Advertisement c JOIN c.advertiser adverteerder WHERE adverteerder.username = '"
								+ user.getUsername() + "'", Advertisement.class);
		return q.getResultList();
	}
}