package test;

/**
 * 
 * @author Garima Dhakal
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import json.JSONFactory;
import json.JSONNull;
import json.JSONNumber;
import json.JSONArray;
import json.JSONBoolean;

class TestOne {

	@Test
	void testNull() {
		JSONNull value = JSONFactory.createNull(); // creating null object
		StringBuilder builder1 = new StringBuilder();
		assertTrue(value.isNull());
		assertFalse(value.isArray());
		assertFalse(value.isObject());
		assertFalse(value.isNumber());
		assertFalse(value.isString());
		assertFalse(value.isBoolean());

		assertEquals("null", value.toString());
		// compares the two values null vs the value that it returns.

		assertTrue(value.equals(JSONFactory.createNull()));
		// comparing the null object of the null class and the null object created here.
		assertFalse(value.equals(null));

		assertEquals(953, value.hashCode());
	}

	@Test
	void testBoolean() {

		JSONArray array = JSONFactory.createArray(2);
		array.addValue(false);
		array.addValue(true);

		StringBuilder builder = new StringBuilder();
		builder.append(array);

		JSONBoolean value = JSONFactory.createBoolean(false);
		JSONBoolean value0 = JSONFactory.createBoolean(true);

		assertEquals("false", value.toString());
		assertEquals("true", value0.toString());

		assertEquals(1231, value0.hashCode());
		assertEquals(1237, value.hashCode());
		assertFalse(value.equals(null));
		assertTrue(value.isBoolean());
		assertTrue(value0.asBoolean());

	}

}
