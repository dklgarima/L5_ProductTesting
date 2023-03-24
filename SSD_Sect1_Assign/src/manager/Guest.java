package manager;

/**
 * A guest within a hotel {@link Room}.
 * 
 * @author mdixon, Garima Dhakal
 */
public class Guest extends Person {

	/**
	 * The guest's card number.
	 */
	private String cardNo;


	public String getCardNo() { //Gets the guest's card number.
		
		return cardNo; //return the guest's card number.
	}

	/**
	 * Parameterized Constructor
	 * 
	 * @param name the name of the guest
	 * @param cardNo the guest's card number.
	 */
	public Guest(String name, String cardNo) {
		
		super(name);
		
		this.cardNo=cardNo;
	}
}
