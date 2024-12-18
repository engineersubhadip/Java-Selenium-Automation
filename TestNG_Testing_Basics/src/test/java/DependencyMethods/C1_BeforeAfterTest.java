package DependencyMethods;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
If we put Assertion on BeforeTest for a particular test module
And the Assertion fails, then none of the @Test will be executed
for that Test Module and if @AfterTest is also there in that Module, then
that will also be skipped.
 */

public class C1_BeforeAfterTest {

	@BeforeTest
	public void bt() {
		System.out.println("Before test from C1");
		Assert.assertTrue(false);
	}

	@Test
	public void login() {
		System.out.println("Login from C1");
	}

	@Test
	public void logout() {
		System.out.println("Logout from C1");
	}
}
