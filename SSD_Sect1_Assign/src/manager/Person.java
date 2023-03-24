package manager;

/**
 * Abstract class to represent a person.
 * 
 * @author mdixon, Garima Dhakal
 *
 */
abstract class Person {

	private String name;
	private String addr;
	private String phone;
	private String email;

	/**
	 * @return the home address of the person
	 */
	public String getAddr() { //Gets the home address of the person

		return addr;
	}

	/**
	 * @param addr the home address of the person
	 */
	public void setAddr(String addr) { //Sets the home address of the person

		this.addr=addr;
	}

	/**
	 * @return the phone number of the person
	 */
	public String getPhone() { //Gets the phone number of the person

		return phone;
	}

	/**
	 * @param phone the phone number of the person
	 */
	public void setPhone(String phone) { //Sets the phone number of the person

		this.phone=phone;
	}

	/**
	 * @return the email addr of the person
	 */
	public String getEmail() { //Gets the email id of the person

		return email;
	}

	/**
	 * @param email the email addr of the person
	 */
	public void setEmail(String email) { //Sets the email id of the person

		this.email=email;
	}

	/**
	 * @return the name of the person
	 */
	public String getName() { //Gets the name of the person

		return name;
	}

	/**
	 * @param the new name of the person
	 */
	public void setName(String name) { //Sets the name of the person

		this.name=name;
	}

	/**
	 * Parameterized Constructor
	 * 
	 * @param name the name of the person
	 */
	Person(String name) {

		this.name=name;
	}
}
