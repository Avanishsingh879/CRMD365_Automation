package stepdefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.annotation.concurrent.ThreadSafe;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Generic_Method.Utility_Method;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Asset_TestScript extends Utility_Method {
	
	
	
	public static WebDriver driver;
	public static Properties files;
	
	@Given("User navigate the Application URL")
	public void user_navigate_the_Application_URL() throws IOException {
		
		FileInputStream fis=new FileInputStream("Config.properties");
		files=new Properties();
		files.load(fis);
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_153.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(files.getProperty("Url"));
		System.out.println("Browser Launch");
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshots/TestData.png"));
		System.out.println("Take Scrrnshot");
		captureScreenShot(driver);
		
	    
	}

	@When("User enter userName{string} and password{string} by click on Sign In Button")
	public void user_enter_userName_and_password_by_click_on_Sign_In_Button(String Uname, String Pwd) {
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(Uname);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(Pwd);
		WebElement Login=driver.findElement(By.xpath("//input[@name='Login']"));
		Login.click();
	   
	}

	@Then("User Login the Application")
	public void user_Login_the_Application() {
		
		System.out.println("Login Sucessfully");
	  
	}
	
	@Then("User IS in Home Page")
	public void User_IS_in_Home_Page() {
		
		String ActualTitle=driver.getTitle();
		String ExpTitle="admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";
		Assert.assertEquals(ActualTitle, ExpTitle);
		System.out.println("Title Matched");
	}

	@Then("User create a Assets page")
	public void user_create_a_Assets_page() throws InterruptedException {
		
		WebElement Hover=driver.findElement(By.xpath("//a[text()='Inventory']"));
		Actions act=new Actions(driver);
		act.moveToElement(Hover).build().perform();
		System.out.println("Hover Done");
		driver.findElement(By.xpath("//div[@id='Inventory_sub']//a[text()='Assets']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[@title='Create Asset...']")).click();
	    Thread.sleep(1000);
	    
	    
	}

	
	
  
}











