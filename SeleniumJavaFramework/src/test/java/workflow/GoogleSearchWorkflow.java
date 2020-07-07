package workflow;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchWorkflow {

	protected static WebDriver driver = null;
	static Properties testdata = new Properties();
	static String property = System.getProperty("user.dir");
	static ExtentHtmlReporter htmlReporter;
	protected static ExtentReports extent;

		@Parameters("browserName")
		public static void browsers(String browserName) throws MalformedURLException {
		htmlReporter = new ExtentHtmlReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		System.out.println("browser name is: " + browserName);
		if (browserName.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", property + "\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
	}

	@BeforeTest(alwaysRun = true)
	public static void launchBrowser() {
		try {
			browsers(getProperties("browsername"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.manage().window().maximize();
	}
	public static void setText(WebElement textbox_search, String text) {
		WebElement txtElement = textbox_search;
		txtElement.sendKeys(text);
	}

	public static void clickButton(WebElement btnClick) {
		WebElement btn = btnClick;
		btn.submit();
	}

	public static void clickLink(WebElement btnClick) {
		WebElement btn = btnClick;
		btn.click();
	}

	public static String getProperties(String value) throws IOException {
		FileInputStream input = new FileInputStream(property + "\\src\\test\\resources\\testdata\\testdata.properties");
		testdata.load(input);
		String data = testdata.getProperty(value);
		return data;
	}

	public static void setProperties(String key, String value) throws IOException {
		OutputStream output = new FileOutputStream(property + "\\src\\test\\java\\testdata\\testdata.properties");
		testdata.setProperty(key, value);
		testdata.store(output, null);
	}

	public static void closeBrowser() {
		driver.quit();
	}

	@AfterSuite
	public static void flush() {
		extent.flush();
	}
}
