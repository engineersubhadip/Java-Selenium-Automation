package Practice;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
1. For a particular test module, if we have (ex:4) participating classes, then @BeforeTest and @AfterTest needs to be present
in those classes.
2. For a particular test module, if we have only @BeforeTest in the  participating classes, then @BeforeTest will execute, before
execution of any of the @Test and @BeforeClass @BeforeMethod
3. For a particular test module, if we have only @AfterTest in the  participating classes, then @AfterTest will execute, only if
all the @Test, @BeforeClass, @BeforeMethod all got executed for that module.

4. If we put Assertion in @BeforeTest and it gets failed, then @BeforeClass, @BeforeMethod, @Test, @AfterMethod, @AfterClass
and @AfterTest all will be SKIPPED.
 */

public class C11 {

	@BeforeTest
	public void bt() {
		System.out.println("Before Test from C11");
		Assert.assertTrue(false);
	}

	@Test
	public void login() {
		System.out.println("Login from C11..");
	}

	@Test
	public void logout() {
		System.out.println("Logout from C11..");
	}
}
