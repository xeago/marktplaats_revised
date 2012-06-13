package nl.zuyd.marktplaats_revised;

public class Advertisement {
	private String Title;
	private int Id;
	private String Description;
	private int Status;
	private String Date;
	private String Price;
	private User Advertiser;
	
	
	public User getAdvertiser() {
		return Advertiser;
	}
	public void setAdvertiser(User advertiser) {
		Advertiser = advertiser;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
}
