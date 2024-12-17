package BeforeAfterTestAnnotation;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
 * To use beforeTest and AfterTest we  need to have 2 Classes at least
 * Before Test will be executed before execution of any of the Test Cases in a test module
 * After Test will be executed after execution of all of the Test Cases in a test module
 * 
 * Main Point :-
 * 
 * To ensure @BeforeTest and @AfterTest will be executed for a particular test module
 * Whichever test classes are participating in a particular Test module,
 * BeforeTest and After Test can be put in any one of them.
 * 
 * If in the participating classes, there is only one of either @BeforeTest or @AfterTest
 * Then only that will be executed for that test module
 */

public class C1 {
	@Test
	public void abc() {
		System.out.println("This is abc from C1");
	}
	
	@BeforeTest
	public void bt() {
		System.out.println("This is Before Test from C1");
	}
}
