package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.EncryptDecryptUtility;

//Java Class

public class LoginPage {
	WebDriver driver;
	EncryptDecryptUtility ed = new EncryptDecryptUtility();

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // with PageFactory (PageFactory is used for using @findBy notations),
												// initElements is static mtd of PageFactory.
	}

	@FindBy(xpath = "//input[@name='username']") // declaring username
	WebElement userNameField;
	@FindBy(name = "password") // declaring password
	WebElement passwordField;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signInButton;
	WebElement errorMessage;
	WebElement alert;

	public HomePage login(String userName, String password) throws Exception { // changing return type
		userNameField.sendKeys(userName);
		passwordField.sendKeys(decryptDetails(password));
		signInButton.click();
		return new HomePage(driver); // calling return type here, it is chaining of page
	}

	public String readErrorMessage() {
		return errorMessage.getText();
	}

	public String readAlertMessage() {
		return alert.getText();
	}
	
	public String decryptDetails(String credential) throws Exception {
		return EncryptDecryptUtility.decrypt(credential, "1234567890123456");
		
	}
}
