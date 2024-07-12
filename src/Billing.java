
public class Billing {
	private String billingNumber;
	private Client client;
	private Booking booking;
	private String billingAmount;
	
	public Billing(String billingNumber, Client client, Booking booking, String billingAmount) {
		super();
		this.billingNumber = billingNumber;
		this.client = client;
		this.booking = booking;
		this.billingAmount = billingAmount;
	}

	public String getBillingNumber() {
		return billingNumber;
	}

	public void setBillingNumber(String billingNumber) {
		this.billingNumber = billingNumber;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public String getBillingAmount() {
		return billingAmount;
	}

	public void setBillingAmount(String billingAmount) {
		this.billingAmount = billingAmount;
	}
}
