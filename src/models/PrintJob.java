package models;

public class PrintJob {

	private int id;
	private String description;
	private String copies;
	private String state;
	private String quality;
	private String entryDate;
	private String finishDate;
	private String deliveryDate;
	private User user;
	private User handler;//encargado

	
	public PrintJob(int id, String description, String copies, String state, String quality, String entryDate,
			String finishDate, String deliveryDate, User user, User handler) {
		this.id = id;
		this.description = description;
		this.copies = copies;
		this.state = state;
		this.quality = quality;
		this.entryDate = entryDate;
		this.finishDate = finishDate;
		this.deliveryDate = deliveryDate;
		this.user = user;
		this.handler = handler;
	}


	public PrintJob() {
	
	}
	
	
	public String getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}
	public String getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCopies() {
		return copies;
	}
	public void setCopies(String copies) {
		this.copies = copies;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public User getHandler() {
		return handler;
	}


	public void setHandler(User handler) {
		this.handler = handler;
	}

	
	
}
