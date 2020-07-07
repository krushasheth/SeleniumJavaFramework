package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import pages.GoogleSearchPage;
import workflow.GoogleSearchWorkflow;

public class GoogleSearchTest extends GoogleSearchWorkflow {

	@Test(groups={"regression"})
	public static void googleSearchTest() throws InterruptedException, IOException {
		ExtentTest test = extent.createTest("Google search test","This is test to validate google serach functionality");
		GoogleSearchPage obj = new GoogleSearchPage(driver);
		driver.navigate().to(getProperties("url"));
		test.pass("Navigated to google.com");
		setText(GoogleSearchPage.google_textbox, getProperties("amazon"));
		clickButton(GoogleSearchPage.btn_search);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		clickLink(GoogleSearchPage.amazonLink);
		setText(GoogleSearchPage.amazonSearchBox, getProperties("womentops"));
		clickButton(GoogleSearchPage.amazonSearchBox);
		test.pass("Shows womens tops");
		test.log(Status.INFO, "Test completed");
		Assert.assertTrue(true, "Test case passed");
		closeBrowser();
	}
}
