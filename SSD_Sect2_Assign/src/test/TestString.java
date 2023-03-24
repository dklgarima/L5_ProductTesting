package test;
/**
 * 
 * @author Garima Dhakal
 */

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import json.JSONArray;
import json.JSONException;
import json.JSONFactory;
import json.JSONObject;
import json.JSONString;

class TestString {
	private static JSONString string0;
	@Test
	void test() throws Exception {
		JSONString stringA = JSONFactory.createString("Hello"); //creating a string
		JSONString stringB = JSONFactory.createString("");
		
		assertNotEquals(stringA,stringB);
		assertEquals(stringA,stringA);
		assertFalse(stringB == null);
		
		System.out.println(stringA.hashCode()); //returns hashcode value of object
		TestString.string0 = stringA;
		
		assertTrue(stringB.isString()); //true if value is string
		System.out.println("The string B is:"+ stringB.toString());
		System.out.println("The string B is:"+stringB.asString());
		
		JSONString stringValue0 = JSONFactory.createString(null); //creates a immutable string value
		JSONString stringValue1= JSONFactory.createString("\"");
		stringValue1.toString(); //returns a string representation
		JSONString stringValue2= JSONFactory.createString("\\");
		stringValue2.toString();
		JSONString stringValue3= JSONFactory.createString("\\/");
		stringValue3.toString();
		JSONString stringValue4= JSONFactory.createString("\b");
		stringValue4.toString();
		JSONString stringValue5= JSONFactory.createString("\f");
		stringValue5.toString();
		JSONString stringValue6= JSONFactory.createString("\n");
		stringValue6.toString();
		JSONString stringValue7= JSONFactory.createString("\r");
		stringValue7.toString();
		JSONString stringValue8= JSONFactory.createString("\t");
		stringValue8.toString();
		
		assertTrue(stringValue0.equals(JSONFactory.createString(null)));
		Object objectOne = new Object();
		assertFalse(stringValue1.equals(objectOne = JSONFactory.createString(null)));
		assertNotEquals(objectOne, stringValue0.equals(objectOne));
		
		JSONArray firstArray = JSONFactory.createArray(2); //Creates a mutable JSON array value with a specific initial size
		JSONArray secondArray = JSONFactory.createArray(2);
		JSONArray thirdArray = JSONFactory.createArray(2);
		JSONArray fourthArray = JSONFactory.createArray(2);
		JSONArray fifthArray = JSONFactory.createArray(2);
		JSONArray sixthArray = JSONFactory.createArray(2);
		JSONArray seventhArray = JSONFactory.createArray(2);
		JSONArray eigthArray = JSONFactory.createArray(2);
		firstArray.addValue("\\\"");
		secondArray.addValue("\\\\");
		thirdArray.addValue("\\/");
		fourthArray.addValue("\b");
		fifthArray.addValue("\f");
		sixthArray.addValue("\n");
		seventhArray.addValue("\r");
		eigthArray.addValue("\t");
		StringBuilder builder = new StringBuilder();
		builder.append(firstArray);
		builder.append(secondArray);
		builder.append(thirdArray);
		builder.append(fourthArray);
		builder.append(fifthArray);
		builder.append(sixthArray);
		builder.append(seventhArray);
		builder.append(eigthArray);
	}
	
	@AfterAll
	public static void fireAfterAll() {
		Integer i = 20;
		String s = "This \"is\" our \bassignment!\n\r";
		Character c = '\b';
		System.out.println(s);
		System.out.println(c.toString());
		System.out.println("The hashcode is: " + TestString.string0.toString());
		System.out.println(string0.getString());
	}
	
	

}