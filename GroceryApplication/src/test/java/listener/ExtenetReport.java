package listener;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

//ExtenetReport: calling at suite,it's a listener class(ie, lessoning starting to ending)
//ExtentSparkReport: creating html page and customise the items we want (theme or items)
//ExtentReports:reports are taken from here, Extent:each individual test are created
//test.log: testcase status (pass or fail)
//configure report: format adding here

public class ExtenetReport implements ITestListener {
	ExtentSparkReporter sparkReporter;
	ExtentReports reports;
	ExtentTest test;

	public void configureReport() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy_hhmmss");
		String strDate = formatter.format(date);

		File reportPath = new File(System.getProperty("user.dir") + "//ExtentReport");

		if (!reportPath.exists()) {
			reportPath.mkdir();
		}
		sparkReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "//ExtentReport//" + "ExtentReport_" + strDate + ".html");
		reports = new ExtentReports();
		reports.attachReporter(sparkReporter);

		reports.setSystemInfo("Project", "Grocery Application");
		reports.setSystemInfo("PC Name", "Pallavi");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("Test Done By", "Pallavi BA");
		sparkReporter.config().setDocumentTitle("Grocery Application Report");
		sparkReporter.config().setReportName("Report Summary");
		sparkReporter.config().setTheme(Theme.STANDARD);
	}

	public void onTestSuccess(ITestResult result) {
		test = reports.createTest(result.getName());
		test.log(Status.PASS,
				MarkupHelper.createLabel("Name of the Passed Test Case is : " + result.getName(), ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult result) {
		test = reports.createTest(result.getName());
		test.log(Status.FAIL,
				MarkupHelper.createLabel("Name of the Failed Test Case is : " + result.getName(), ExtentColor.RED));
	}

	public void onTestSkipped(ITestResult result) {
		test = reports.createTest(result.getName());
		test.log(Status.SKIP,
				MarkupHelper.createLabel("Name of the skipped test case is : " + result.getName(), ExtentColor.YELLOW));
	}

	public void onStart(ITestContext context) {
		configureReport();
	}

	public void onFinish(ITestContext context) {
		reports.flush();
	}

}
