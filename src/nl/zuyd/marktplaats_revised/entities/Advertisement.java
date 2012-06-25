package nl.zuyd.marktplaats_revised.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The entity that represents an Advertisement. Mapped to the database with annotations, by JPA
 * @author rick
 *
 */
@Entity
@Table(name="advertisements")
public class Advertisement
{
	
	/** The id. */
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	/** The advertiser. */
	@ManyToOne(targetEntity=User.class)
	private User advertiser;
	
	/** The status. */
	@Column(name="status")
	private int status = 0;
	
	/** The title. */
	@Column(name="title", nullable=false, length=100)
	private String title;
	
	/** The description. */
	@Column(name="description",length=8000, nullable=false)
	private String description;
	
	/** The date. */
	@Column(name="date", nullable=false, length=20)
	private String date;
	
	/** The price. */
	@Column(name="price", nullable=false, length=40)
	private String price;

	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId()
	{
		return this.id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id)
	{
		this.id = id;
	}
	
	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle()
	{
		return title;
	}
	
	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription()
	{
		return description;
	}
	
	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public int getStatus()
	{
		return status;
	}
	
	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(int status)
	{
		this.status = status;
	}
	
	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public String getDate()
	{
		return date;
	}
	
	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(String date)
	{
		this.date = date;
	}
	
	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public String getPrice()
	{
		return price;
	}
	
	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(String price)
	{
		this.price = price;
	}
	
	/**
	 * Gets the advertiser.
	 *
	 * @return the advertiser
	 */
	public User getAdvertiser()
	{
		return advertiser;
	}
	
	/**
	 * Sets the advertiser.
	 *
	 * @param advertiser the new advertiser
	 */
	public void setAdvertiser(User advertiser)
	{
		this.advertiser = advertiser;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (obj instanceof Advertisement) return equals((Advertisement)obj);
		return false;
	}

	public int hashCode() {
		return id;
	}
	
	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	public boolean equals(Advertisement obj) {
		return this.id==obj.id
				&& this.advertiser.equals(obj.advertiser);
	}

	public String toString() {
		return title + " = " + price;
	}
	
}
