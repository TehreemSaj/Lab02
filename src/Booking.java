
public class Booking {
	private String bookingNumber;
	private String date;
	private Pet pet;
	private String bookingDetails;
	
	public Booking(String bookingNumber, String date, Pet pet, String bookingDetails) {
		super();
		this.bookingNumber = bookingNumber;
		this.date = date;
		this.pet = pet;
		this.bookingDetails = bookingDetails;
	}

	public String getBookingNumber() {
		return bookingNumber;
	}

	public void setBookingNumber(String bookingNumber) {
		this.bookingNumber = bookingNumber;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public String getBookingDetails() {
		return bookingDetails;
	}

	public void setBookingDetails(String bookingDetails) {
		this.bookingDetails = bookingDetails;
	}
	
}
