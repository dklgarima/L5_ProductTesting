package test;

/**
 * 
 * @author Garima Dhakal
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import json.JSONArray;
import json.JSONException;
import json.JSONFactory;
import json.JSONNumber;
import json.JSONString;

class TestNumber {

	@Test
	void test() throws JSONException {
		JSONNumber value = JSONFactory.createNumber(10);
		JSONNumber valueOne = JSONFactory.createNumber(0);
		JSONNumber valueTwo = JSONFactory.createNumber(20);
		JSONNumber valueThree = JSONFactory.createNumber(30);
		JSONNumber valueFour = JSONFactory.createNumber(1.2);
		JSONNumber valueFive = JSONFactory.createNumber(0.00);
		StringBuilder builderOne = new StringBuilder();

		assertFalse(value.isNull());
		assertFalse(value.isArray());
		assertFalse(value.isObject());
		assertTrue(value.isNumber());
		assertFalse(value.isString());
		assertFalse(value.isBoolean());

		Integer number = (Integer) valueOne.getNumber();
		assertEquals(0, number);

		number = (Integer) value.getNumber();
		assertEquals(10, number);

		assertEquals(20, valueTwo.hashCode());
		assertEquals("30", valueThree.toString());

		Double numberOne = (Double) valueFour.getNumber();
		assertEquals(1.2, numberOne);

		assertFalse(valueOne.equals(null));
		assertTrue(valueOne.equals(JSONFactory.createNumber(0))); //Creates an immutable JSON number value

		assertFalse(valueThree.getClass() != valueTwo.getClass());

		JSONNumber floatValue = JSONFactory.createNumber(6.123f);
		double numberTwo = floatValue.asDouble();

		JSONNumber floatValue2 = JSONFactory.createNumber(0.00f);

		JSONNumber doubleValue = JSONFactory.createNumber(4343873d);
		double numberThree = doubleValue.asDouble();

		JSONNumber IntegerValue = JSONFactory.createNumber(22);
		double integerOne = IntegerValue.asDouble();

		JSONNumber LongValue = JSONFactory.createNumber(2383943L);
		double longOne = LongValue.asDouble();

		double floatval = floatValue2.asFloat();
		double integerTwo = IntegerValue.asFloat();
		double longTwo = LongValue.asFloat();
		double numberFour = doubleValue.asFloat();

		double integerThree = IntegerValue.asLong();
		double longThree = LongValue.asLong();
		assertThrows(JSONException.class, () -> floatValue2.asLong(), "Number is not a valid long");

		double numberFive = IntegerValue.asInteger();
		assertThrows(JSONException.class, () -> floatValue2.asInteger(), "Number is not a valid integer");

		JSONNumber shortv = JSONFactory.createNumber(1);
		shortv.asShort();
		assertThrows(JSONException.class, () -> floatValue2.asShort(), "Number is not a valid short");

		JSONNumber bytee = JSONFactory.createNumber(3);
		bytee.asByte();
		assertThrows(JSONException.class, () -> floatValue2.asByte(), "Number is not a valid byte");
	}
}