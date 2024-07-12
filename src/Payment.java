
public class Payment {
	private Billing billing;
	private Client client;
	
	public Payment(Billing billing, Client client) {
		super();
		this.billing = billing;
		this.client = client;
	}

	public Billing getBilling() {
		return billing;
	}

	public void setBilling(Billing billing) {
		this.billing = billing;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
