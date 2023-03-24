package manager;
import java.util.ArrayList;
import java.util.List;

/**
 * A person that owns {@link Property} instances.
 * 
 * @author mdixon, Garima Dhakal
 *
 */
public class PropertyOwner extends Person {
	
	//Multiple instances of {@link Property}
	private List<Property> ownedProperties = new ArrayList<Property>();
	
	/**
	 * Adds a property to the set of owned properties.
	 * 
	 * @param prop the property to be added
	 * @return true if the property added, false if already owned.
	 */
	public boolean addProperty(Property prop) {
		
		if(ownedProperties.contains(prop))
		{
			// property is already owned
			return false;
		}
		else {
			// property does not have owner
			ownedProperties.add(prop);
			return true;
		}
	}
	
	/**
	 * Removes a property from the set of owned properties.
	 * 
	 * @param prop the property to be removed
	 * @return true if the property was removed, false if it was not owned
	 */
	public boolean removeProperty(Property prop) {
		
		if(ownedProperties.contains(prop))
		{
			// check if it is owned first
			ownedProperties.remove(prop);
			return true;
		}
		
		return false;
	}
	
	/**
	 * Clears all properties from the set of owned properties.
	 */
	public void clearOwnedProperties() {
		
		if(!ownedProperties.isEmpty())
		{
			ownedProperties.clear();
		}
	}
	
	/**
	 * Gets the number of owned properties
	 * 
	 * @return the number of owned properties
	 */
	public int getPropertyCount() {
		
		return ownedProperties.size();
	}
	
	
	/**
	 * Parameterized Constructor
	 * 
	 * @param name the property owner's name
	 */
	public PropertyOwner(String name) {
		
		super(name);
	}
}
