package nl.zuyd.marktplaats_revised;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;

@Singleton
public class Context {

	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	private List<Advertisement> advertenties;

	public List<Advertisement> getAdvertisements() {
		return advertenties;
	}

	public Context() {
		users = new ArrayList<User>();
		advertenties = new ArrayList<Advertisement>();
		
		User u1 = new User();
		u1.setId(1);
		u1.setEmail("test@test.nl");
		u1.setPassword("banaan");

		User u2 = new User();
		u2.setId(2);
		u2.setEmail("user2@test.nl");
		u2.setPassword("appel");

		users.add(u1);
		users.add(u2);

		Advertisement a1 = new Advertisement();
		a1.setId(1);
		a1.setTitle("2e hands Kia Rio");
		a1.setDescription("een 2e hands Kia rio met maar bla bla bla bla");
		a1.setDate("13-6-2012");
		a1.setStatus(1);
		a1.setAdvertiser(u1);

		Advertisement a2 = new Advertisement();
		a2.setId(2);
		a2.setTitle("auto van de buren");
		a2.setDescription("blaat");
		a2.setDate("11-6-2012");
		a2.setStatus(1);
		a2.setAdvertiser(u2);

		Advertisement a3 = new Advertisement();
		a3.setId(2);
		a3.setTitle("tuinslang");
		a3.setDescription("blaat nog meer bla");
		a3.setDate("6-3-2009");
		a3.setStatus(2);
		a3.setAdvertiser(u2);

		advertenties.add(a1);
		advertenties.add(a2);
		advertenties.add(a3);
	}

}
