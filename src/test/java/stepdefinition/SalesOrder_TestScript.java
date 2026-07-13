package stepdefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.gargoylesoftware.htmlunit.javascript.host.Iterator;

import PageObject.SalesOrder_Page;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.*;


public class SalesOrder_TestScript {
	
	public WebDriver driver;
	public static Properties files;
	
	SalesOrder_Page salesPG=new SalesOrder_Page(driver);
	
	@Given("User Open and Navigate to Application Url")
	public void user_Open_and_Navigate_to_Application_Url() throws IOException {
		
		FileInputStream fis=new FileInputStream("Config.properties");
		files=new Properties();
		files.load(fis);
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_144.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get(files.getProperty("Url"));
		System.out.println("Browser Launch");
	    
	}

	@When("User Enter userName{string} and Password{string} by click on Login Button")
	public void user_Enter_userName_and_Password_by_click_on_Login_Button(String userName, String passwd) throws InterruptedException, IOException {
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(passwd);
		salesPG.Click_Login(driver);
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshots/TestData.png"));
		
		
	
	}

	@Then("User able to Login Sucessfully")
	public void user_able_to_Login_Sucessfully() {
		
		System.out.println("Login Sucessfully");
	   
	}

	@Then("User able to Verify Home Page Functionlity")
	public void user_able_to_Verify_Home_Page_Functionlity() {
		
		salesPG.MouseHover(driver);
	}

	@Then("User create and verify SalesOrder in Sales Page")
	public void user_create_and_verify_SalesOrder_in_Sales_Page() {
		
		salesPG.SalesOrder(driver);
		
	}

	@Then("User create and Verify New SalesOrder{string},{string},{string}")
	public void user_create_and_Verify_New_SalesOrder(String Subject, String BillingAddress, String ShippingAddress) throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@name='subject']")).sendKeys(Subject);
		driver.findElement(By.xpath("//textarea[@name='bill_street']")).sendKeys(BillingAddress);
		driver.findElement(By.xpath("//textarea[@name='ship_street']")).sendKeys(ShippingAddress);
		salesPG.ClickProduct(driver);
		Thread.sleep(2000);
		
		String mainWndow=driver.getWindowHandle();
		
		Set<String>set=driver.getWindowHandles();
		
	}
}


















