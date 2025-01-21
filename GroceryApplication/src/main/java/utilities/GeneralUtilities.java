package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {
	public void selectValueFromDropdown(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
	}

	public void switchToFrameByWebElement(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	public String generateCurrentDateAndTime() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyhhmmss"); // general format to print date, year etc
		return formatter.format(date);
	}

	public int randon(int limit) {
		Random random = new Random();
		// int limit = 1000;
		int randomNumber = random.nextInt(limit);
		return randomNumber;
	}

	public String selectDropdownWithVisibleText(WebElement element, String text) {
		Select object = new Select(element);
		object.selectByVisibleText(text);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}

	public void DragAndDrop(WebDriver driver, WebElement sourceElement, WebElement targetElement) {
		Actions actObject = new Actions(driver);
		actObject.dragAndDrop(sourceElement, targetElement).perform();
	}

	public String getTitleOfPage(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentUrlOfPage(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public void sendValueUsingJavaScript(WebDriver driver, WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = '" + value + "'", element);
	}

	public void blurThePlaceHolder(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].blur()", element);
	}

	public String getElementText(WebElement subCategory) {
		// TODO Auto-generated method stub
		return null;
	}

	public void pageScroll(int i, int j, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void alertAcceptFunction(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void scrollTestUsingWindowScrollByFunction(WebDriver driver, int i, int j) {
		// TODO Auto-generated method stub
		
	}

	public void fileUploadUsingSendKeysFunction(WebElement chooseFileButton, String string) {
		// TODO Auto-generated method stub
		
	}

}
