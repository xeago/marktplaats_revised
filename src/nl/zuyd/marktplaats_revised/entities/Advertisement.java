package nl.zuyd.marktplaats_revised.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="advertisements")
public class Advertisement
{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@ManyToOne(targetEntity=User.class)
	private User advertiser;
	
	@Column(name="status")
	private int status = 0;
	
	@Column(name="title", nullable=false, length=100)
	private String title;
	
	@Column(name="description",length=8000, nullable=false)
	private String description;
	
	@Column(name="date", nullable=false, length=20)
	private String date;
	
	@Column(name="price", nullable=false, length=40)
	private String price;
	
	public int getId()
	{
		return this.id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public int getStatus()
	{
		return status;
	}
	
	public void setStatus(int status)
	{
		this.status = status;
	}
	
	public String getDate()
	{
		return date;
	}
	
	public void setDate(String date)
	{
		this.date = date;
	}
	
	public String getPrice()
	{
		return price;
	}
	
	public void setPrice(String price)
	{
		this.price = price;
	}
	
	public User getAdvertiser()
	{
		return advertiser;
	}
	
	public void setAdvertiser(User advertiser)
	{
		this.advertiser = advertiser;
	}
}
