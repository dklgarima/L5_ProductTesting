package manager;

/**
 * A type of {@link Property} which acts as a place of residence.
 * 
 * @author mdixon, Garima Dhakal
 */
abstract class Domicile extends Property {

	private int bedrooms; //Number of bedrooms in domicile.
	
	private boolean isFurnished; //flag that is true when the furniture is furnished.


	public int getBedrooms() { //Gets the number of bedroom in domicile
		
		return bedrooms; //return the number of bedrooms
	}
	
	public boolean isFurnished() { //Checks if furniture is furnished
		
		return isFurnished; //return true if furnished
	}
	
	////////////////////////////////
	
	/**
	 * Constructor
	 * 
	 * @param addr the address of the domicile
	 * @param bedrooms the number of bedrooms
	 */
	Domicile(String addr, int bedrooms) {

		super(addr);
		this.bedrooms=bedrooms;
	}

}
