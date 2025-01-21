package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class SettingsMenu {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtilities wu = new WaitUtilities();

	public SettingsMenu(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//i[@class='nav-icon sidebar-item-icon fa fa-cog']")
	WebElement changePasswordButton;
	@FindBy(xpath = "//p[text()='Manage Menu']") 
	WebElement manageMenuButton;
	@FindBy(xpath = "//p[text()='Logout']") 
	WebElement logOutButton;

	public void logOut() {
		logOutButton.click();
	}
}

