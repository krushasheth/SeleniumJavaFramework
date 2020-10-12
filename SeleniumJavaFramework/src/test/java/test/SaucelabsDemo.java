package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import pages.GoogleSearchPage;
import workflow.GoogleSearchWorkflow;

public class SaucelabsDemo extends GoogleSearchWorkflow{
	
	public static final String URL = "https://Krusha18:6aa9efda-2be8-4407-b233-bd6cecc9a968@ondemand.us-west-1.saucelabs.com:443/wd/hub"; 
	@Test(groups={"smoke"})
	public static void sauceLabs() throws IOException, InterruptedException {
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("version", "latest");
		WebDriver driver = new RemoteWebDriver(new java.net.URL(URL),caps);
		GoogleSearchPage obj = new GoogleSearchPage(driver);
		driver.navigate().to("https://www.google.com/");
		System.out.println(driver.getTitle());
	    setText(GoogleSearchPage.google_textbox,getProperties("amazon"));
	    clickButton(GoogleSearchPage.btn_search);
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.quit();
	    System.out.println("Test Completed");
	}

}
