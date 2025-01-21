package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.SubCategoryPage;

public class SubCategoryPageTest extends BaseClass {
	LoginPage lp; // used aggregation
	HomePage hp; // used aggregation
	SubCategoryPage scp;

	@Test
	public void createNewSubCategory() throws Exception {
		lp = new LoginPage(driver); // calling constructor from LoginPage java class
		// hp = new HomePage(driver); //constructor need to be called first
		// scp = new SubCategoryPage(driver);
		hp = lp.login("admin", "admin"); // chaining of page
		scp = hp.clickOnSubCategoryMenu();
		scp.addSubCategory();
		boolean alertStatus = scp.getAlertMessage().contains("Sub Category Created Successfully");
		Assert.assertEquals(alertStatus, true, "Sub Category Created Successfully, Message not as expected");
	}

	@Test
	public void deleteSubCategory() throws Exception {
		lp = new LoginPage(driver);
		// hp = new HomePage(driver);
		// scp = new SubCategoryPage(driver);
		hp = lp.login("admin", "admin");
		scp = hp.clickOnSubCategoryMenu();
		scp.deleteSubCategory();
		boolean deletealertStatus = scp.getAlertMessage().contains(" RESULT NOT FOUND ");
		Assert.assertEquals(deletealertStatus, true, "Delete alert message not as expected");
	}

	@Test
	public void deleteSelectedSubCategory() throws Exception {
		lp = new LoginPage(driver);
		// hp = new HomePage(driver);
		// scp = new SubCategoryPage(driver);
		hp = lp.login("admin", "admin");
		scp = hp.clickOnSubCategoryMenu();
		scp.deleteanySubCategoryItem();
	 boolean deletealertStatus = scp.deleteMessage().contains(" RESULT NOT FOUND");
		Assert.assertEquals(deletealertStatus, true, "Delete alert message not as expected");
	}
}