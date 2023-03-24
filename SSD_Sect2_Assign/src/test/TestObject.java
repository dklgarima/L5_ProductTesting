package test;

/**
 * 
 * @author Garima Dhakal
 */

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import org.junit.jupiter.api.*;
import json.*;
import java.util.Map.Entry;

public class TestObject {

	private static JSONObject objectOne;
	private static JSONObject objectTwo;
	private static JSONArray firstArray;

	TestObject() throws JSONException {
		// creating an array
		JSONArray subjects = JSONFactory.createArray(10);
		subjects.addValue("Science");
		subjects.addValue("English");
		subjects.addValue("Maths");
		JSONObject object1 = JSONFactory.createObject();

		// Creating a JSONObject object
		object1.addMember("First_Name", "Garima");
		object1.addMember("Last_Name", "Dhakal");
		object1.addMember("suspended", false);
		object1.addMember("Roll no", 001);
		object1.addMember("Percentage", 95.5);
		object1.addMember("Favourite subject", subjects.get(2));
		object1.addMember("Bill", 98.89f);
		object1.addMember("Subjects", subjects);

		// Creating another JSONObject object
		JSONObject object2 = JSONFactory.createObject();
		object2.addMember("First_Name", "Amrit");
		object2.addMember("Last_Name", "Panthi");
		object2.addMember("suspended", true);
		object2.addMember("Roll no", 002);
		object2.addMember("Percentage", 85);
		object2.addMember("Group partner", object1.getMember("First_Name"));
		object2.addMember("Phone number");

		JSONObject object3 = JSONFactory.createObject();
		object3.addMember("First_Name", "Mina");
		object3.addMember("Last_Name", "Lamichhane");
		object3.addMember("Roll no", 002);
		object3.addMember("Percentage", 90.99);
		object3.addMember("Group partner", object1.getMember("First_Name"));
		object3.addMember("Phone number");
		object3.addMember("Students", object1);

		JSONArray students = JSONFactory.createArray(10);
		students.addValue(object1.getMember("First_Name"));
		students.addValue(object2.getMember("First_Name"));
		students.addValue();

		TestObject.objectOne = object1;
		TestObject.objectTwo = object2;
		TestObject.firstArray = students;

		assertTrue(object2.hasBooleanMember("suspended"));
		assertFalse(object3.hasBooleanMember("suspended"));
		assertTrue(object1.hasMember("Bill"));
		assertFalse(object2.hasMember("Bill"));

		assertNotEquals(object1, object2);
		assertEquals(object1, object1);

		JSONObject objectNull = JSONFactory.createObject();
		assertNotEquals(objectNull, null);

		objectNull.asObject();
		// JSONObject objectNull2 = JSONFactory.createObject();
		assertThrows(JSONException.class, () -> firstArray.asObject());
		assertThrows(JSONException.class, () -> objectNull.asArray());
		assertThrows(JSONException.class, () -> firstArray.asString());
		assertThrows(JSONException.class, () -> firstArray.asBoolean());
		assertThrows(JSONException.class, () -> firstArray.asByte());
		assertThrows(JSONException.class, () -> firstArray.asDouble());
		assertThrows(JSONException.class, () -> firstArray.asFloat());
		assertThrows(JSONException.class, () -> firstArray.asInteger());
		assertThrows(JSONException.class, () -> firstArray.asLong());
		assertThrows(JSONException.class, () -> firstArray.asShort());

	}

	@AfterAll
	public static void fireAfterAll() {

		System.out.println("Output" + "\n" + TestObject.objectOne.toString());
		System.out.println("Output" + "\n" + TestObject.objectTwo.toString());
		System.out.println("Students: " + "\n" + TestObject.firstArray.toString());

		System.out.println("The data of Student1 is:" + TestObject.objectOne.members());
		System.out.println("The data of Student1 is:" + TestObject.objectOne.values());
	}

	@DisplayName("Test of all array initializers")
	@Test
	public void testObjectInits() {
		JSONArray firstA = JSONFactory.createArray();
		JSONArray secondA = JSONFactory.createArray(10);
		secondA.addValue(false);

		JSONArray lastA = JSONFactory.createArray(secondA);

		assertTrue(firstA instanceof JSONArray);
		assertTrue(firstA.isArray());
		assertTrue(secondA instanceof JSONArray);
		assertEquals(secondA.size(), 1);
		assertEquals(secondA.get(0), JSONBoolean.JSON_FALSE);

		assertTrue(lastA instanceof JSONArray);
		assertEquals(lastA, secondA);

	}

	@DisplayName("Test of all array menthods")
	@RepeatedTest(5)

	public void testObjectMethods() {
		JSONObject firstA = JSONFactory.createObject();
		JSONObject copyA = firstA.copy();
		JSONObject thirdA = JSONFactory.createObject();

		assertTrue(firstA.isObject());
		assertEquals(firstA, copyA);
		assertTrue(firstA.equals(copyA));
		assertEquals(firstA.hashCode(), copyA.hashCode());
		assertEquals(firstA.size(), copyA.size());

	}
	

	@RepeatedTest(3)
	public void testHashCode() {

		JSONObject ja = JSONFactory.createObject(); // gives address of the value stored appropriately object is created
													// or not//what is Entry= interface inside map interface
		System.out.println("Hashcode:" + (ja.hashCode()));
	}

	@Test
	public void testIterator() {
		int count = 0;

		Iterator<Entry<String, JSONValue>> values = objectOne.iterator();

	}

}