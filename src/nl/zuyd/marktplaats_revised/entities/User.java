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

// TODO: Auto-generated Javadoc
/**
 * The entity that represents a User. Mapped to the database with annotations, by JPA
 * @author rick
 *
 */
@Stateful
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = { "id" }))
public class User {
	
	/** The id. */
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	/** The username. */
	@Id
	@Column(name = "username", nullable = false)
	private String username;

	/** The email. */
	@Column(name = "email_address", nullable = false)
	private String email;

	/** The password. */
	@Column(name = "password", nullable = false)
	private String password;

	/** The groupname. */
	@Column(name = "groupname", nullable = false)
	private String groupname = "USER";

	/** The woonplaats. */
	@Column(name = "woonplaats")
	private String woonplaats;

	/** The advertisements. */
	@OneToMany(targetEntity = Advertisement.class, mappedBy = "advertiser",orphanRemoval=true)
	private List<Advertisement> advertisements;

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the groupname.
	 *
	 * @return the groupname
	 */
	public String getGroupname() {
		return groupname;
	}

	/**
	 * Gets the woonplaats.
	 *
	 * @return the woonplaats
	 */
	public String getWoonplaats() {
		return woonplaats;
	}

	/**
	 * Sets the woonplaats.
	 *
	 * @param woonplaats the new woonplaats
	 */
	public void setWoonplaats(String woonplaats) {
		this.woonplaats = woonplaats;
	}

	/**
	 * Gets the advertisements.
	 *
	 * @return the advertisements
	 */
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
		return equals(obj.toString());
	}

	public int hashCode() {
		return username.toCharArray().hashCode();
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	public boolean equals(String obj) {
		return this.username.equals(obj);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	public boolean equals(User obj) {
		return this.id==obj.id
				&& this.hashCode()==obj.hashCode()
				&& this.username.equals(obj.username);
	}

	public String toString() {
		return username;
	}
}
