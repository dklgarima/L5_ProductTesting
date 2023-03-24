package manager;

/**
 *  A type of {@link Property} that represents a secured office
 *  
 * @author mdixon, Garima Dhakal
 *
 */

public class Office extends Property implements SecuredAccess {

	/**
	 * The stored security code.
	 */
	
	private String storedCode = "1234";	
	/**
	 * Number of incorrect attempt in entering code.
	 */
	private int incorrectAttempts;
	
	@Override
	public void setCode(String code) {
		
		storedCode=code;
		incorrectAttempts=0; 
	}

	@Override
	public boolean checkCode(String code) {

		if (isLockedOut() || !code.equals(storedCode)) {
			// is locked out, or codes do not match
			incorrectAttempts++;
			return false;
		}
		else {
			// not locked, and codes match
			incorrectAttempts=0; //reset
			return true; 
		}
	}

	@Override
	public void resetToDefault() {

		storedCode="1234";
		incorrectAttempts=0; //resets incorrect number of attempts in entering code
	}

	@Override
	public boolean isLockedOut() {
		
		//locked out if incorrect attempts increases 5 tries
		return (incorrectAttempts>5);
	}

	@Override
	public int getIncorrectAttempts() {

		return incorrectAttempts;
	}

	public Office(String address) {

		super(address);
	}
	
	
}
