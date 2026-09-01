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
import junit.framework.Assert;

import java.util.*;

    
   
   
public class SalesOrder_TestScript {
	
	public static WebDriver driver;
	public static Properties files;
	
	@Given("User Navigate the Application Url")
	public void user_Navigate_the_Application_Url() throws IOException {
		
		FileInputStream fis=new FileInputStream("Config.properties");
		files=new Properties();
		files.load(fis);
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_150.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(files.getProperty("Url"));
		System.out.println("Browser Launch");
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("./Screenshots/new.png"));
		System.out.println("Screenshot Takes");
		
	   
	}

	@When("User Enter username{string} and Password{string} by click on Sign Button")
	public void user_Enter_username_and_Password_by_click_on_Sign_Button(String Uname, String Pwd) throws InterruptedException {
	  
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(Uname);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(Pwd);
		driver.findElement(By.xpath("//input[@name='Login']")).click();
		Thread.sleep(1000);
		
	}

	@Then("User Login Sucessfully page")
	public void user_Login_Sucessfully_page() {
	 
		System.out.println("Login Sucessfully");
	}

	
	@Then("User Verify Title in Home Page")
	public void user_Verify_Title_in_Home_Page() {
		
		String ActualTitle=driver.getTitle();
		String ExpTitle="admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";
		
		Assert.assertEquals(ActualTitle, ExpTitle);
		System.out.println("Title Matched");
	   
	}
	
	@Then("User Verify and create Sales Order")
	public void user_Verify_and_create_Sales_Order() throws InterruptedException, IOException {
		
		WebElement MouseHover=driver.findElement(By.xpath("//a[text()='Sales']"));
		Actions act=new Actions(driver);
		act.moveToElement(MouseHover).build().perform();
		WebElement SalesOrder=driver.findElement(By.xpath("//div[@id='Sales_sub']//a[text()='Sales Order']"));
		SalesOrder.click();
		Thread.sleep(1000);
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./SalesOrder/newFile.png"));
	}
	
}


















