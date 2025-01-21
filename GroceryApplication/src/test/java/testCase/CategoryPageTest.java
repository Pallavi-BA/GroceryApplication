package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.CategoryPage;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import utilities.EncryptDecryptUtility;
import utilities.GeneralUtilities;

public class CategoryPageTest extends BaseClass {
	LoginPage lp;
	HomePage hp;
	CategoryPage cp;
	GeneralUtilities gu;
	EncryptDecryptUtility eu = new EncryptDecryptUtility();

	@Test(priority = 1,enabled=true,groups = "Smoke")
	public void addNewCategoryAndVerifySuccessAlert() throws Exception {
		lp = new LoginPage(driver);
		String password = EncryptDecryptUtility.decrypt(groceryLogin(10,0), "1234567890123456");
		hp = lp.login(super.groceryLogin(1, 0), password);
		cp = hp.clickOnCategoryMenu();
		//cp.createNewCategory(groceryLogin(7, 0));
		boolean alertStatus = cp.getSuccessAlertMessage().contains("Category Created Successfully");
		Assert.assertEquals(alertStatus, true, Constant.cp_addNewCategoryAndVerifySuccessAlert);
	}

	@Test(priority=2, enabled=true,groups = "Smoke")
  public void createDuplicateCategoryAndVerifyCategoryAlreadyExistAlertMessage() throws Exception {
	  lp = new LoginPage(driver);
		String password = EncryptDecryptUtility.decrypt(groceryLogin(10,0), "1234567890123456");
		hp = lp.login(super.groceryLogin(1, 0), password);
		cp = hp.clickOnCategoryMenu();
		//cp.createNewCategory(groceryLogin(7,0));
		boolean alertStatus = cp.getDangerAlertMessage().contains("Category already exists");
		Assert.assertEquals(alertStatus, true, Constant.cp_createDuplicateCategoryAndVerifyCategoryAlreadyExistAlertMessage);
		
  }

	@Test(priority=3, enabled=true,groups = "Smoke")
  public void searchingCreatedCategoryAndVerifyListCategory() throws Exception {
    lp = new LoginPage(driver);
	String password = EncryptDecryptUtility.decrypt(groceryLogin(10,0), "1234567890123456");
	hp = lp.login(super.groceryLogin(1, 0), password);
	cp = hp.clickOnCategoryMenu();
	cp.searchCreatedCategory(groceryLogin(7,0));
	boolean listCategoryNameStatus = cp.getListCategoryText().contains(groceryLogin(7,0));
	Assert.assertEquals(listCategoryNameStatus, true, Constant.cp_addNewCategoryAndVerifySuccessAlert);	
	}
	
	@Test(priority=4, enabled=true,groups = "Smoke")
	  public void deletingCreatedCategoryAndVerifyDeleteAlertMessage() throws Exception {
	    lp = new LoginPage(driver);
		String password = EncryptDecryptUtility.decrypt(groceryLogin(10,0), "1234567890123456");
		hp = lp.login(super.groceryLogin(1, 0), password);
		cp = hp.clickOnCategoryMenu();
		cp.deleteCreatedCategory();
		boolean alertStatus = cp.getSuccessAlertMessage().contains("Category Deleted Successfully");
		Assert.assertEquals(alertStatus,true,Constant.cp_addNewCategoryAndVerifySuccessAlert);
	}
	
	@Test(priority=5, enabled=true,groups = "Smoke")
	  public void editingCreatedCategoryAndVerifyUpdatedSuccessfullyAlert() throws Exception {
		lp = new LoginPage(driver);
		String password = EncryptDecryptUtility.decrypt(groceryLogin(10,0), "1234567890123456");
		hp = lp.login(super.groceryLogin(1, 0), password);
		cp = hp.clickOnCategoryMenu();
		//cp.createNewCategory(groceryLogin(7,0));
		hp.clickOnCategoryMenu();
		cp.editCreatedCategory();
		boolean alertStatus = cp.getSuccessAlertMessage().contains("Category Updated Successfully");
		Assert.assertEquals(alertStatus,true,Constant.cp_addNewCategoryAndVerifySuccessAlert);
		
	}

}




















/*public class CategoryPageTest extends BaseClass {
	LoginPage lp;
	HomePage hp;
	CategoryPage cp;
	
	@Test
	public void editCategory() throws Exception {
		lp = new LoginPage(driver); 
		hp = new HomePage(driver);
		cp = new CategoryPage(driver);
		
		lp.login("admin", "admin");
		hp.clickOnCategoryMenu();
		cp.editCategory();
		boolean editAlertStatus = cp.editCategoryName().contains("Category updated successfully");
		Assert.assertEquals(editAlertStatus, true, "Edit Alert Message not as expected");
	}
}*/