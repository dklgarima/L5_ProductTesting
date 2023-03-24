package manager;

import java.util.ArrayList;
import java.util.List;

/**
 * A Hotel containing many {@link Room} instances.
 * 
 * @author mdixon, Garima Dhakal
 *
 */
public class Hotel extends Property {

	/**
	 * Multiple instances of {@link Room}
	 */
	
	private List<Room> rooms = new ArrayList<Room>();
	
	public int getRooms() { //Gets the number of rooms within the hotel.
		
		return rooms.size(); //return the number of rooms within the hotel.
	}
	
	/**
	 * Set the specified room to be occupied by the given guest.
	 * 
	 * @param roomNo  the room number
	 * @param guest the guest
	 */
	public void occupyRoom(int roomNo, Guest guest) {
		
		rooms.get(roomNo).setOccupant(guest);
		for(Room r: rooms) {
			if(r.getRoomNum()==roomNo)
			{
				r.setOccupant(guest);
			}
		}
	}
	
	/**
	 * Ensures the specified room is unoccupied.
	 * 
	 * @param roomNo the room number
	 */
	public void freeRoom(int roomNo) {
		
		for(Room r: rooms) {
			if(r.getRoomNum()==roomNo)
			{
				if(r.hasOccupant())
				{
					r.removeOccupant();
					break;
				}
			}
		}
	}
	
	/**
	 * Gets the count of number of occupied rooms
	 * 
	 * @return the occupied room count
	 */
	public int getOccupiedRoomCount() {
		
		int count = 0;
		
		for(Room r: rooms)
		{	
			if(r.hasOccupant())
			{
				//check if room is occupied
				count++;
			}
		}
		
		return count;
	}
	
	/**
	 * Constructor
	 * 
	 * @param addr the address of the hotel
	 * @param roomCount the number of rooms in the hotel
	 */
	public Hotel(String addr, int roomCount) {
		
		super(addr);

		for(int i = 0; i < roomCount; i++) {
			rooms.add(new Room(i));
		}	
	}
}
