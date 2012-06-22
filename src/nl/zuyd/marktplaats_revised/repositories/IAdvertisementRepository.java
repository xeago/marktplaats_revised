package nl.zuyd.marktplaats_revised.repositories;

import java.util.List;

import javax.ejb.Local;

import nl.zuyd.marktplaats_revised.entities.Advertisement;

@Local
public interface IAdvertisementRepository
{	
	Advertisement getById(int id);
	List<Advertisement> getAll();	
	List<Advertisement> getByTitle(String title);

	void addAdvertisement(Advertisement u);
	void saveAdvertisement(Advertisement advert);
	void deleteAdvertisement(Advertisement a);
}
