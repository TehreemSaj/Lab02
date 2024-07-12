
public class Pet {
	private String name;
	private String type;
	private String breed;
	private int age;
	private Client owner;
	private CareProfile careProfile;
	
	public Pet(String name, String type, String breed, int age, Client owner, CareProfile careProfile) {
		super();
		this.name = name;
		this.type = type;
		this.breed = breed;
		this.age = age;
		this.owner = owner;
		this.careProfile = careProfile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Client getOwner() {
		return owner;
	}

	public void setOwner(Client owner) {
		this.owner = owner;
	}
	
	public CareProfile getCareProfile() {
		return careProfile;
	}

	public void setCareProfile(CareProfile careProfile) {
		this.careProfile = careProfile;
	}
	

}
