package stepdefinition;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Suport_TestScript {
	
	
	public static WebDriver driver;
	public static Properties files;
	
	
	@Given("User Navigate the Open URL")
	public void user_Navigate_the_Open_URL() throws IOException {
		
		FileInputStream fis=new FileInputStream("Config.properties");
		files=new Properties();
		files.load(fis);
		
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_150.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(files.getProperty("Url"));
		System.out.println("Browser launch");
		
		
	}

	@When("User Enter username and password by click on SignIN Button")
	public void user_Enter_username_and_password_by_click_on_SignIN_Button() throws InterruptedException {
	
	Thread.sleep(1000);
	WebElement Uname=driver.findElement(By.xpath("//input[@name='user_name']"));
	Uname.sendKeys(files.getProperty("username"));
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(files.getProperty("password"));
	driver.findElement(By.xpath("//input[@name='Login']")).click();
	   
	}
	
	@Then("User Login Sucessfully Page")
	public void user_Login_Sucessfully_Page() {
	   
	String actualTitle=driver.getTitle();
	String ExpTitle="admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";
	Assert.assertEquals(actualTitle, ExpTitle);
	System.out.println("Title Matched");
	
	
	}

	@Then("User Verify the HomePage Functionlity")
	public void user_Verify_the_HomePage_Functionlity() {
		
		System.out.println("Login Sucessfully");
	   
	}
	
	@Then("User Able to click on Support Tab")
	public void user_able_to_click_on_Support_Tab() {
	
	driver.findElement(By.xpath("//a[text()='Support']")).click();
	System.out.println("User able to click on Support tab");
		
	}
	
	@Then("User Able to click on Account Tab")
	public void user_Able_to_click_on_Account_Tab() throws InterruptedException {
		
		Thread.sleep(1000);
		WebElement hover=driver.findElement(By.xpath("//a[text()='Support']"));
		Actions act=new Actions(driver);
		act.moveToElement(hover).build().perform();
		WebElement ele=driver.findElement(By.xpath("//a[text()='Accounts']"));
		ele.click();
		
	   
	}
}






