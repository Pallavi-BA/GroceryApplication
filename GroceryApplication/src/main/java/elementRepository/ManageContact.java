package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class ManageContact {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtilities wu = new WaitUtilities();

	public ManageContact(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//i[@class='fas fa-edit']")
	WebElement editButton;	
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phoneEdit;	
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailEdit;	
	@FindBy(xpath = "//textarea[@placeholder='Enter the Address']")
	WebElement addressEdit;
	@FindBy(xpath = "//textarea[@placeholder='Enter Delivery Time']")
	WebElement deliveryTimeEdit;	
	@FindBy(xpath = "//input[@name='del_limit']")
	WebElement deliveryChargeEdit;	
	@FindBy(xpath = "//button[@name='Update']]")
	WebElement updateButton;
	@FindBy(xpath = "//a[@class='btn btn-default btn-fix']")
	WebElement resetButton;
	
}
