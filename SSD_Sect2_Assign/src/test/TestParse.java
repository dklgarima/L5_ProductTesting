package test;
/**
 * 
 * @author Garima Dhakal
 */

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import json.*;

import org.junit.jupiter.api.Test;

class TestParse {
	@Test
	void testParseFile() throws FileNotFoundException, IOException, JSONException {

		JSONValue value = JSONParser.parseFile("example.json");
		assertTrue(value.isObject());

		JSONObject Obj = value.asObject();

		JSONValue jsonValue = Obj.getMember("prop3");
		assertTrue(jsonValue.isNumber());
		float floatValue = jsonValue.asFloat();
		assertEquals(3.142f, floatValue);

		JSONValue jsonValueTwo = Obj.getMember("prop1");
		assertTrue(jsonValue.isNumber());
		String stringValue = jsonValueTwo.asString();
		assertEquals("A string", stringValue);

		JSONValue jsonValueThree = Obj.getMember("prop2");
		assertTrue(jsonValue.isNumber());
		float floatValueTwo = jsonValueThree.asFloat();
		assertEquals(0, floatValueTwo);

		JSONValue jsonValueFour = Obj.getMember("prop4");
		assertTrue(jsonValueFour.isBoolean());
		boolean BoolValue = jsonValueFour.asBoolean();
		assertEquals(true, BoolValue);

		JSONValue jsonValueFive = Obj.getMember("prop5");
		assertTrue(jsonValueFive.isBoolean());
		boolean BoolValueTwo = jsonValueFive.asBoolean();
		assertEquals(false, BoolValueTwo);

		JSONValue jsonValueSix = Obj.getMember("prop6");
		assertTrue(jsonValueSix.isNull());

		JSONObject jsonValueSeven = (JSONObject) Obj.getMember("prop7");
		JSONValue jValue1 = jsonValueSeven.getMember("prop7_A");
		boolean BoolValueThree = jValue1.asBoolean();
		assertEquals(true, BoolValueThree);
		assertTrue(jValue1.isBoolean());

		JSONValue jValue2 = jsonValueSeven.getMember("prop7_B");
		boolean BoolValueFour = jValue2.asBoolean();
		assertEquals(false, BoolValueFour);
		assertTrue(jValue2.isBoolean());

		JSONValue jValue3 = jsonValueSeven.getMember("prop7_C");
		String stringValueOne = jValue3.asString();
		assertEquals("nested string", stringValueOne);
		assertTrue(jValue3.isString());

		JSONArray jsonValueEight = (JSONArray) Obj.getMember("array1");
		assertTrue(jsonValueEight.isArray());
		for (int i = 0; i < jsonValueEight.size(); i++) {

			assertEquals(i, jsonValueEight.get(i).asInteger());
		}

		JSONArray jsonValueNine = (JSONArray) Obj.getMember("array2");
		assertTrue(jsonValueNine.isArray());
		assertEquals("this", jsonValueNine.get(0).asString());
		assertEquals("is", jsonValueNine.get(1).asString());
		assertEquals("an", jsonValueNine.get(2).asString());
		assertEquals("array", jsonValueNine.get(3).asString());

		JSONArray jsonValueTen = (JSONArray) Obj.getMember("array3");
		assertTrue(jsonValueTen.isArray());
		assertEquals("this", jsonValueTen.get(0).asString());
		assertEquals(0, jsonValueTen.get(5).asInteger());
		assertEquals(true, jsonValueTen.get(6).asBoolean());
		assertEquals(false, jsonValueTen.get(7).asBoolean());

		assertTrue(jsonValueTen.get(8).isNull());

		assertEquals(6.232F, jsonValueTen.get(9).asFloat());

		JSONObject objInside = (JSONObject) jsonValueTen.get(10);
		assertTrue(objInside.isObject());

		JSONArray arrayInside = (JSONArray) jsonValueTen.get(11);
		assertTrue(arrayInside.isArray());

		JSONValue jsonValueEleven = Obj.getMember("escape_string");
		assertTrue(jsonValueEleven.isString());

		JSONValue jValueStr1 = JSONParser.parse("{}");
		assertTrue(jValueStr1.isObject());

		assertThrows(JSONException.class, () -> JSONParser.parse("{\"Name\": \"Garima Dhakal\",}"));

		assertThrows(JSONException.class, () -> JSONParser.parse("{\"Name\": \"ABC\","));

		assertThrows(JSONException.class, () -> JSONParser.parse("{\"Name\": \"ABC\""));

		assertThrows(JSONException.class, () -> JSONParser.parse("{\"Name\" \"ABC\""));

// string parse string

		assertThrows(JSONException.class, () -> JSONParser.parse("{\"\\h\" : \"hello\"}"));

		assertThrows(JSONException.class, () -> JSONParser.parse("{\""));

		assertThrows(JSONException.class, () -> JSONParser.parse("{\"Right\" : [1,]}"));
		assertThrows(JSONException.class, () -> JSONParser.parse("{\"Right\" : [1}"));

		assertThrows(JSONException.class, () -> JSONParser.parse("{\"Right\" : [0,"));

		assertThrows(JSONException.class, () -> JSONParser.parse("{\"Error\" :tue}"));

		assertThrows(JSONException.class, () -> JSONParser.parse("{\"Error\" :flse}"));

		assertThrows(JSONException.class, () -> JSONParser.parse("{\"Error\" :nul}"));


		assertThrows(JSONException.class, () -> JSONParser.parse("{\"ErrorUni\" : \"\\u123\"}"));

		assertThrows(JSONException.class, () -> JSONParser.parse("{\"ErrorUni\" : \"\\u\"}"));

		assertThrows(JSONException.class, () -> JSONParser.parseFile("textfileGarima.json"));

		assertThrows(JSONException.class, () -> JSONParser.parse("{\"Error\" :$"));
		assertThrows(JSONException.class, () -> JSONParser.parse("{\"Error\" :-"));
		assertThrows(JSONException.class, () -> JSONParser.parse("{"));

	}
}
