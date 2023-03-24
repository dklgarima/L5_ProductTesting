package manager;

/**
 * A represent a House type {@link Domicile}.
 * 
 * @author mdixon, Garima Dhakal
 */
public class House extends Domicile {

	private int bathrooms; //Number of bathroom in house.

	private int receptionRooms; //Number of reception rooms.

	private boolean hasGarage; //A flag indicating whether the house has a garage.

	public int getBathrooms() { //Gets the number of bathrooms
		
		return bathrooms; //return the number of bath rooms
	}

	public int getReceptionRooms() { //Gets the number of reception rooms
		
		return receptionRooms; //return the number of reception rooms
	}

	/**
	 * @return true if the house has a garage
	 */
	public boolean hasGarage() { //Checks if house has a garage
		
		return hasGarage;
	}

	/**
	 * Constructor
	 * 
	 * @param addr the address of the house
	 * @param bedrooms the number of bedrooms within the house.
	 * @param bathrooms the number of bathrooms within the house.
	 * @param receptionRooms the number of reception rooms within the house.
	 * @param hasGarage a flag indicating whether the house has a garage.
	 */
	public House(String addr, int bedrooms, int bathrooms, int receptionRooms, boolean hasGarage) {
		
		super(addr, bedrooms);
		
		this.hasGarage = hasGarage;
		
		this.hasGarage = hasGarage;
		this.receptionRooms=receptionRooms;
		this.bathrooms=bathrooms;
	}
}
