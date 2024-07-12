
public class Client {
	private String fullName;
	private String phoneNumber;
	private String Address;
	
	public Client(String fullName, String phoneNumber, String address) {
		super();
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		Address = address;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}
	
}
