package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class SubCategoryPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtilities wu = new WaitUtilities();

	public SubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath = "//select[@id='cat_id']")
	WebElement categoryField;
	@FindBy(xpath = "//input[@id ='subcategory']")
	WebElement subCategoryField;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMessage;
	@FindBy(xpath = "//div[@class='card-body table-responsive p-0']//table//tbody//tr[10]//td[1]")
	WebElement subCategory;
	@FindBy(xpath = "//div[@class='card-body table-responsive p-0']//table//tbody//tr[10]//td[2]")
	WebElement category;
	@FindBy(xpath = "//div[@class='card-body table-responsive p-0']//table//tbody//tr//td[1]")
	List<WebElement> tableSize;

	public void addSubCategory() {
		newButton.click();
		gu.selectDropdownWithVisibleText(categoryField, "phone");
		subCategoryField.sendKeys("iphone" + gu.generateCurrentDateAndTime());
		saveButton.click();
	}

	public String getAlertMessage() {
		return alertMessage.getText();
	}

	public void deleteSubCategory() {
		String subCategoryName = gu.getElementText(subCategory);
		// String categoryName = gu.getElementText(category);
		wu.waitForAlertIsPresent(driver, 10);
		for (int i = 0; i < tableSize.size(); i++) {
			if (tableSize.get(i).getText().equals(subCategoryName)) {
				String path = "//div[@class='card-body table-responsive p-0']//table//tbody//tr[" + (i + 1)
						+ "]//td[5]//a[2]";
				WebElement element = driver.findElement(By.xpath(path));
				element.click();
			}

		}
	}

	public void deleteanySubCategoryItem() {

	}

	public String deleteMessage() {
		// TODO Auto-generated method stub
		return null;
	}
}