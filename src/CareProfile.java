
public class CareProfile {
	private String feedingInstructions;
	private String medicationInstructions;
	private String medicationList;
	
	public CareProfile(String feedingInstructions, String medicationInstructions, String medicationList) {
		super();
		this.feedingInstructions = feedingInstructions;
		this.medicationInstructions = medicationInstructions;
		this.medicationList = medicationList;
	}

	public String getFeedingInstructions() {
		return feedingInstructions;
	}

	public void setFeedingInstructions(String feedingInstructions) {
		this.feedingInstructions = feedingInstructions;
	}

	public String getMedicationInstructions() {
		return medicationInstructions;
	}

	public void setMedicationInstructions(String medicationInstructions) {
		this.medicationInstructions = medicationInstructions;
	}

	public String getMedicationList() {
		return medicationList;
	}

	public void setMedicationList(String medicationList) {
		this.medicationList = medicationList;
	}
	
}
