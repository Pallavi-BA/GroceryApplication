package testCase;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage; //TestNG Class
import utilities.EncryptDecryptUtility;


public class LoginPageTest extends BaseClass {
	LoginPage lp;
	HomePage hp;
	EncryptDecryptUtility ed = new EncryptDecryptUtility();

	@Test(enabled = false)
	public void loginWithValidCredential() throws Exception {
		lp = new LoginPage(driver); // driver is called from LoginPage(previous class)
		// hp = new HomePage(driver); //constructor need to be called first
		//String password = EncryptDecryptUtility.decrypt(groceryLogin(10,0), "1234567890123456");
		hp = lp.login("admin", "admin");
		String actual = hp.getHomePageHeading();
		System.out.println(actual);
		String expected = "7rmart supermarket"; // this is exception and that was actual, if it become equal the test
												// case is running.
		Assert.assertEquals(actual, expected, Constant.lp_loginWithValidCredential); // if test case fails, it print
																							// like this.
		// assertion 2 types 1.hard assertion:above is eg. after this assertion the test
		// case stops there 2. soft assertion
	}

	@Test(enabled = true, dataProvider = "data-provider")
	public void loginWithInValidCredential(String userName, String password) throws Exception {
		lp = new LoginPage(driver); // driver is called from LoginPage(previous class)
		lp.login("userName", "password");
		String actual = lp.readErrorMessage();
		System.out.println(actual);
		String alert = lp.readAlertMessage();
		System.out.println(alert);
		String expected = "Alert1";
		Assert.assertEquals(actual, expected, "::Verify login page with invalid credentials");
	}

	@DataProvider(name = "data-provider")
	public Object[][] dpMethod() {
		return new Object[][] { { "admin", "abcd" }, { "pqrs", "admin" }, { "abcd", "pqrs" } };
	}

}
