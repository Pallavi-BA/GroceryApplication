package testCase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.ExcelUtilities;
import utilities.ScreenShotCapture;

public class BaseClass {
	WebDriver driver;
	ScreenShotCapture sc;	
	public static Properties pro;

	public static void testBasic() throws IOException {

		pro = new Properties();
		FileInputStream fp = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\config.properties");
		pro.load(fp);
	}

	public static String groceryLogin(int row, int column) throws IOException {
		String data = ExcelUtilities.readExcelData(row, column,
				("user.dir") + "\\src\\main\\resources\\Excel\\GroceryApplication.xlsx", "Sheet1");
		return data;

	}
	
	@BeforeMethod
	public void beforeMethod() throws IOException {
		testBasic();
		driver = new ChromeDriver();
		//driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.get(pro.getProperty("Baseurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Polymorphism

	}

	@AfterMethod(alwaysRun = true)
	public void afterMethode(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {       //iTestResult is a listener class
			sc = new ScreenShotCapture();
			sc.captureFailureScreenShot(driver, iTestResult.getName());
		}

		driver.quit();
	}
}






/*
 * import java.time.Duration;
 * 
 * import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.chrome.ChromeDriver; import
 * org.openqa.selenium.edge.EdgeDriver; import
 * org.testng.annotations.AfterMethod; import
 * org.testng.annotations.BeforeMethod; import
 * org.testng.annotations.Parameters;
 * 
 * import utilities.ExcelUtilities;
 * 
 * public class BaseClass { WebDriver driver; // create as instance variable;
 * before mtd and after mtd same variable il call cheyan public static String
 * groceryLogin(int row, int column) { String data =
 * ExcelUtilities.readStringData(row, column, System.getProperty("user.dir")+
 * "\\src\\main\\resources\\Excel\\GroceryApplication.xlsx", "Sheet1"); return
 * data; }
 * 
 * 
 * @BeforeMethod(alwaysRun=true)
 * 
 * @Parameters("browser") public void beforeMethod(String browserName) {
 * if(browserName.equals("Chrome")) { //crossbrowser test driver = new
 * ChromeDriver(); } else if(browserName.equals("Edge")) { //crossbrowser test
 * driver = new EdgeDriver(); }
 * driver.get("https://groceryapp.uniqassosiates.com/admin/login");
 * driver.manage().window().maximize();
 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); }
 * 
 * @AfterMethod(alwaysRun=true) public void afterMethod() { //driver.quit(); } }
 */
