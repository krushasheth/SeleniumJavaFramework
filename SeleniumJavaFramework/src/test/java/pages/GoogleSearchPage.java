package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {
	
	 public WebDriver driver = null;
	  
	@FindBy(name ="q")
	public static WebElement google_textbox;
	 
	@FindBy(xpath="//input[@name='btnK']")
	public static WebElement btn_search;
	
	@FindBy(xpath="//span[contains(text(),'Amazon.com: Online Shopping for Electronics, Appar')]")
	public static WebElement amazonLink;
	
	@FindBy(xpath ="//input[@id='twotabsearchtextbox']")
	public static WebElement amazonSearchBox;
	
	public GoogleSearchPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
}
