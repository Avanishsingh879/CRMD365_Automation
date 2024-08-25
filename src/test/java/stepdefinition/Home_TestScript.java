package stepdefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Home_TestScript {
	
	
	public static WebDriver driver;
	public static Properties files;
	
	@Given("I navigate to applicatIon open UrL")
	public void i_navigate_to_applicatIon_open_UrL() throws IOException, InterruptedException {
		
	FileInputStream fis=new FileInputStream("Config.properties");
	files=new Properties();
	files.load(fis);
	System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_119.exe");
	driver=new ChromeDriver();
	driver.get(files.getProperty("Url"));
	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	System.out.println("Browser Launch Sucessfully");
	Thread.sleep(2000);
	   
	}

	@When("user Enter {string} and {string} by click on login Button")
	public void user_Enter_and_by_click_on_login_Button(String Username, String Password) throws InterruptedException {
		
		WebElement Uname=driver.findElement(By.xpath("//input[@name='user_name']"));
		Uname.sendKeys(Username);
		Thread.sleep(1000);
		WebElement Pwd=driver.findElement(By.xpath("//input[@name='user_password']"));
		Pwd.sendKeys(Password);
		Thread.sleep(2000);
		WebElement SignIN=driver.findElement(By.xpath("//input[@name='Login']"));
		SignIN.click();
		Thread.sleep(2000);
		
		
	    
	}

	@Then("User login sucessfully")
	public void user_login_sucessfully() {
		
		
	    
	}

}
