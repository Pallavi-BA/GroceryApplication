package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // with PageFactory (PageFactory is used for using @findBy notations),
												// initElements is static mtd of PageFactory.
	}

	@FindBy(xpath = "//span[text()='7rmart supermarket']")
	WebElement homePageHeading;
	@FindBy(xpath = "//a//p[text()='Sub Category']")
	WebElement subCategoryMenu;
	
	public String getHomePageHeading() {
		return homePageHeading.getText();
	}

	public SubCategoryPage clickOnSubCategoryMenu() {
		subCategoryMenu.click();
		return new SubCategoryPage(driver);
	}

	@SuppressWarnings("null")
	public CategoryPage clickOnCategoryMenu() {
		WebElement categoryMenu = null;
		categoryMenu.click();
		return new CategoryPage(driver);

		
	}
}








//x-paths- 3 types

//span[text()='7rmart supermarket']
//span[@class='brand-text font-weight-light']
//a[@class='d-block']
