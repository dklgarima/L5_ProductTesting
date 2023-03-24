package test;

import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.jupiter.api.*;
import java.util.Iterator;
import json.*;

/**
 * 
 * @author Garima Dhakal
 */

public class TestArray {
	
	private static JSONArray ArrayTesting;
	
	TestArray(){
		JSONArray array1 = JSONFactory.createArray(10);
		array1.addValue(false);
		array1.addValue(true);
		array1.addValue(6.6);
		array1.addValue(2.55f);
		array1.addValue(JSONFactory.createArray());
		array1.addValue(JSONFactory.createObject());
		array1.addValue(214759631);
		array1.addValue("Good Morning");
		array1.addValue();
		TestArray.ArrayTesting = array1;
	}


	@AfterAll
	public static void RunLast() {
		System.out.println("The array is: "+ TestArray.ArrayTesting.toString());
	}
	
	@DisplayName("Test of all array initializers")
	@Test
	public void IntitialArray() {
		JSONArray ArrayOne = JSONFactory.createArray();
		JSONArray ArrayTwo = JSONFactory.createArray(10);
		ArrayTwo.addValue(false);
		
		JSONArray ArrayThree = JSONFactory.createArray(ArrayTwo);
		
		assertTrue(ArrayOne instanceof JSONArray);
		assertTrue(ArrayOne.isArray());
		assertTrue(ArrayTwo instanceof JSONArray);
		assertEquals(ArrayTwo.size(),1);
		assertEquals(ArrayTwo.get(0),JSONBoolean.JSON_FALSE);
		
		assertTrue(ArrayThree instanceof JSONArray);
		assertEquals(ArrayThree, ArrayTwo);
		
	}
	
	@DisplayName("Test of all array methods")
	@RepeatedTest(5)
	public void ArrayMethod() {
		JSONArray ArrayOne = JSONFactory.createArray();
		JSONArray ArrayDub = ArrayOne.copy();
		JSONArray ArrayThree =JSONFactory.createArray();
		ArrayThree.addValue(false);
		
		assertTrue(ArrayOne.isArray());
		assertEquals(ArrayOne, ArrayDub);
		assertTrue(ArrayOne.equals(ArrayDub));
		assertEquals(ArrayOne.hashCode(), ArrayDub.hashCode());
		
		assertEquals(ArrayOne.toString(), "[]");
		assertEquals(ArrayThree.toString(),"[false]");
		
	}
	
	@RepeatedTest(3)
	public void ArrayHashCode() {
		
		JSONArray ja = JSONFactory.createArray();
		ja.addValue(false);
		assertTrue(ja.hashCode() == 1268);
		
	}
	
	@Test
	public void TestValues() {
		JSONArray a = JSONFactory.createArray();
		
		try {
			JSONValue val = JSONParser.parse("10");
			a.addValue(val);
			
			assertTrue(a.get(0).asInteger() == 10);
			
		}catch (IOException e) {
			e.printStackTrace();
		}catch (JSONException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void ArrayIterator() {
		int iteratorCount = 0;
		Iterator<JSONValue> values = ArrayTesting.iterator();
		
		while(values.hasNext()) {
			assertEquals(values.next(),ArrayTesting.get(iteratorCount));
			iteratorCount++;
		}
	}
	
	@DisplayName("Test of adding values into arrays")
	@Test
	public void testMethodValues() {
		for(int index= 0; index <ArrayTesting.size(); index++) {
			
			try {
				JSONValue value = ArrayTesting.get(index);
				
				if(value.isNull()) {
					assertTrue(value instanceof JSONNull);
				}
				
				if(value.isObject()) {
					assertTrue(value instanceof JSONObject);
					assertEquals(value.asObject(), ArrayTesting.get(index).asObject());
				}
				if(value.isArray()) {
					assertTrue(value instanceof JSONArray);
					assertEquals(value.asArray(), ArrayTesting.get(index).asArray());
				}
				if(value.isBoolean()) {
					assertTrue(value instanceof JSONBoolean);
					assertEquals(value.asBoolean(), ArrayTesting.get(index).asBoolean());
				}
				
				if(value.isNumber()) {
					assertTrue(value instanceof JSONNumber);
				}
				if(value.isString()) {
					assertTrue(value instanceof JSONString);
					assertEquals(value.asString(), ArrayTesting.get(index).asString());
				}
			}catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}

}
