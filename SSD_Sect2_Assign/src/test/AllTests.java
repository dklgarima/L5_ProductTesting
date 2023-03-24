package test;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

/**
 * 
 * @author Garima Dhakal
 */

// note: the command below sometimes causes an issue within Eclipse IDE.
// IF the following is displayed "WARNING: Ignoring test class using JUnitPlatform runner:"
// Go to run-configurations and select JUnit4 as the Test runner if this will not execute.
@RunWith(JUnitPlatform.class)
@SelectClasses({ TestOne.class, TestParse.class, TestArray.class, TestNumber.class, TestString.class,
		TestObject.class })
public class AllTests {

}
