package BankMaster;

import java.awt.AWTException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {
	public static Logger logger;
	public static WebDriver driver;
	public static JavascriptExecutor js;
	public static Actions act;
	public static BankMasterWebElements a;
	public static XSSFSheet sheet;
	public static ExcelDataProvider ex;

	// LambdaTest credentials
	public static String username = "preeti.bokade"; // Replace with your LambdaTest username
	public static String accessKey = "ndLW8ygsIAWTRc9YCBxkEOoybKYst3zd8dnUnP6t0MNPMpqVw9"; // Replace with your
																							// LambdaTest access key

	@BeforeTest
	public void start() throws AWTException, InterruptedException, MalformedURLException {
		// Set up desired capabilities for LambdaTest
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platform", "Windows 10");
		capabilities.setCapability("browserName", "chrome");
		capabilities.setCapability("browserVersion", "latest");
		capabilities.setCapability("build", "GTest");
		capabilities.setCapability("project", "D365");
		capabilities.setCapability("name", "SampleTest");
		capabilities.setCapability("visual", true);
		capabilities.setCapability("video", true);
		capabilities.setCapability("w3c", true);

		// LambdaTest grid URL
		String gridURL = "https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub";

		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 10");
		browserOptions.setBrowserVersion("130");
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", "preeti.bokade");
		ltOptions.put("accessKey", "ndLW8ygsIAWTRc9YCBxkEOoybKYst3zd8dnUnP6t0MNPMpqVw9");
		ltOptions.put("visual", true);
		ltOptions.put("video", true);
		ltOptions.put("build", "GTest");
		ltOptions.put("project", "SampleTest");
		ltOptions.put("name", "SampleTest1");
		ltOptions.put("selenium_version", "4.0.0");
		ltOptions.put("w3c", true);
		browserOptions.setCapability("LT:Options", ltOptions);
		// Initialize WebDriver based on LambdaTest capabilities
		driver = new RemoteWebDriver(new java.net.URL(gridURL), capabilities);

		// Set up the WebDriver session
		driver.get("https://csjewellersuat.sandbox.operations.dynamics.com/?cmp=inmf&mi=defaultdashboard");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		a = new BankMasterWebElements();
		Thread.sleep(3000);
		ex = new ExcelDataProvider();
		js = (JavascriptExecutor) driver;
		act = new Actions(driver);
	}

	// @AfterTest
	public void tear_down() {
		if (driver != null) {
			driver.quit();
		}
	}
}
