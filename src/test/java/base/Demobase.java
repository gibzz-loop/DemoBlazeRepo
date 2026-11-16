package base;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import page.DemoAboutus;
import page.DemoCart;
import page.DemoContact;
import page.DemoHome;
import page.DemoNewtab;
import page.Demopage;

public class Demobase {
	public static WebDriver driver;
	public static Demopage dp;
	public static DemoHome dh;
	public static DemoCart dc;
	public static DemoNewtab dn;
	public static DemoContact dct;
	public static DemoAboutus da;
	public static ExtentSparkReporter reporter;
	public static ExtentReports extend;
	public static ExtentTest test;

	@BeforeTest
	public void reportSetUp() {
		String time = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
		reporter = new ExtentSparkReporter("./Report/DemoblazeReport_" + time + ".html");
		reporter.config().setDocumentTitle("Demoblaze Automation");
		reporter.config().setReportName("Functional testing - Demoblaze Store");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setTimeStampFormat("dd MMM yyyy hh:mm:ss a");

		extend = new ExtentReports();
		extend.attachReporter(reporter);
		extend.setSystemInfo("hostname", "localhost");
		extend.setSystemInfo("os", "windows");
		extend.setSystemInfo("testername", "gibina");
		extend.setSystemInfo("Browser name", "chrome");
		extend.setSystemInfo("URL", "https://www.demoblaze.com/index.html");
	}

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com/index.html");
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void test(Method mthd) {
		dp = new Demopage(driver);
		dh = new DemoHome(driver);
		dc = new DemoCart(driver);
		dn = new DemoNewtab(driver);
		dct = new DemoContact(driver);
		da = new DemoAboutus(driver);

		test = extend.createTest(mthd.getName());
		test.assignCategory("Demoblaze");
		test.info("Test started: " + mthd.getName());
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		String img = screenshot();
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test case failed: " + result.getName());
			if (img.isEmpty()) {
				test.log(Status.FAIL, "Reason: " + result.getThrowable());
			} else {
				test.log(Status.FAIL, "Reason: " + result.getThrowable(),
						MediaEntityBuilder.createScreenCaptureFromBase64String(img).build());
			}
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test case skipped: " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			if (img.isEmpty()) {
				test.log(Status.PASS, "Test case passed: " + result.getName());
			} else {
				test.log(Status.PASS, "Test case passed: " + result.getName(),
						MediaEntityBuilder.createScreenCaptureFromBase64String(img).build());
			}
		}
	}

	public String screenshot() {
		try {
			return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		} catch (Exception e) {
			return "";
		}
	}

	@AfterClass
	public void browserClose() {
		if (driver != null) {
			driver.quit();
		}
	}

	@AfterTest
	public void end() {
		extend.flush();
	}
}