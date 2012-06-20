package nl.zuyd.marktplaats_revised;

import java.util.List;

public interface IRepository<T> 
{
	T getById(int id);
	List<T> getAll();
}