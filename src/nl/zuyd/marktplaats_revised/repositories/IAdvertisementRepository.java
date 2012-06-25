package nl.zuyd.marktplaats_revised.repositories;

import java.util.List;

import javax.ejb.Local;

import nl.zuyd.marktplaats_revised.entities.Advertisement;
import nl.zuyd.marktplaats_revised.entities.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface IAdvertisementRepository.
 */
@Local
public interface IAdvertisementRepository
{	
	
	/**
	 * Gets the by id.
	 *
	 * @param id the id
	 * @return the by id
	 */
	Advertisement getById(int id);
	
	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	List<Advertisement> getAll();	
	
	/**
	 * Gets the by title.
	 *
	 * @param title the title
	 * @return the by title
	 */
	List<Advertisement> getByTitle(String title);
	
	/**
	 * Find by search.
	 *
	 * @param keyword the keyword
	 * @return the list
	 */
	List<Advertisement> findBySearch(String keyword);
	
	/**
	 * Gets the advertisements by user.
	 *
	 * @param user the user
	 * @return the advertisements by user
	 */
	List<Advertisement> getAdvertisementsByUser(User user);
	
	/**
	 * Adds the advertisement.
	 *
	 * @param u the u
	 */
	void addAdvertisement(Advertisement u);
	
	/**
	 * Update advertisement.
	 *
	 * @param advert the advert
	 */
	void updateAdvertisement(Advertisement advert);
	
	/**
	 * Delete advertisement.
	 *
	 * @param a the a
	 */
	void deleteAdvertisement(Advertisement a);
}