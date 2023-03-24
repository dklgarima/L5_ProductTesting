package manager;

/**
 * Represents a Room within a {@link Hotel}.
 * 
 * @author mdixon, Garima Dhakal
 *
 */
public class Room implements SecuredAccess {

	private int roomNum; //The room number within the hotel

	
	private String storedCode="9999"; //Access code to unlock room.
	
	//Current {@link Guest} (occupant)
	private Guest occupant;
	
	@Override
	public void setCode(String code) {

		storedCode=code;
	}

	@Override
	public boolean checkCode(String code) {

		return (code.equals(storedCode));
	}
	
	@Override
	public void resetToDefault() { //resets the value to default

		storedCode="9999";
	}

	@Override
	public boolean isLockedOut() { 

		return false;
	}

	@Override
	public int getIncorrectAttempts() { //sets incorrect attempts to 0

		return 0;
	}
	
	/**
	 * @return the roomNum
	 */
	public int getRoomNum() { //Gets the room number
		
		return roomNum;
	}

	/**
	 * @param roomNum the roomNum to set
	 */
	public void setRoomNum(int roomNum) { //Sets the room Number
		
		this.roomNum=roomNum;
	}

	/**
	 * 
	 * @param guest the guest which is to occupy the room
	 */
	public void setOccupant(Guest guest) { //Sets the occupant of the room.
		
		this.occupant=guest;
	}
	
	/**
	 * Removes any occupant from the room.
	 */
	public void removeOccupant() {
		
		occupant=null;
	}
	
	/**
	 * 
	 * @return true if the room has an occupant
	 */
	public boolean hasOccupant() {
		
		return (occupant!=null);
	}
	
	/**
	 *  Parameterized Constructor.
	 * 
	 * @param roomNum the room number
	 */
	public Room(int roomNum) {

		this.roomNum=roomNum;
	}


}
