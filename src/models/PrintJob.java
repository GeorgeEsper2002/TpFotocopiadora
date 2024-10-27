package models;

public class PrintJob {

	private int id;
	private String description;
	private int copies;
	private String state;
	private String quality;
	private String entryDate;
	private String finishDate;
	private String deliveryDate;
	

	public PrintJob() {
	
	}
	
	public PrintJob(int id, String description, int copies, String state, String quality, String entryDate,
			String finishDate, String deliveryDate) {
		this.id = id;
		this.description = description;
		this.copies = copies;
		this.state = state;
		this.quality = quality;
		this.entryDate = entryDate;
		this.finishDate = finishDate;
		this.deliveryDate = deliveryDate;
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
	public int getCopies() {
		return copies;
	}
	public void setCopies(int copies) {
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

	
}
