package nl.zuyd.marktplaats_revised.entities;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Stateful
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = { "id" }))
public class User {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Id
	@Column(name = "username", nullable = false)
	private String username;

	@Column(name = "email_address", nullable = false)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "groupname", nullable = false)
	private String groupname = "USER";

	@Column(name = "woonplaats")
	private String woonplaats;

	@OneToMany(targetEntity = Advertisement.class, mappedBy = "advertiser")
	private List<Advertisement> advertisements;

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGroupname() {
		return groupname;
	}

	public String getWoonplaats() {
		return woonplaats;
	}

	public void setWoonplaats(String woonplaats) {
		this.woonplaats = woonplaats;
	}

	public List<Advertisement> getAdvertisements() {
		return advertisements;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (obj instanceof User)
			return this.equals((User) obj);
		else if (obj instanceof String)
			return this.equals((String) obj);
		return false;
	}

	public int hashCode() {
		return username.toCharArray().hashCode();
	}

	public boolean equals(String obj) {
		return this.username.equals(obj);
	}

	public boolean equals(User obj) {
		// TODO Auto-generated method stub
		return super.equals(null);
	}

	public String toString() {
		return username;
	}
}
