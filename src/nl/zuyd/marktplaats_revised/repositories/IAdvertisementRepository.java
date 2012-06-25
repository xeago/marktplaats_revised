package nl.zuyd.marktplaats_revised.repositories;

import java.util.List;

import javax.ejb.Local;

import nl.zuyd.marktplaats_revised.entities.Advertisement;
import nl.zuyd.marktplaats_revised.entities.User;

@Local
public interface IAdvertisementRepository
{	
	Advertisement getById(int id);
	
	List<Advertisement> getAll();	
	List<Advertisement> getByTitle(String title);
	List<Advertisement> findBySearch(String keyword);
	List<Advertisement> getAdvertisementsByUser(User user);
	
	void addAdvertisement(Advertisement u);
	void updateAdvertisement(Advertisement advert);
	void deleteAdvertisement(Advertisement a);
}