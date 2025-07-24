package stepdefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObject.Project_Page;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Product_TestScript {
	
	public WebDriver driver;
	public static Properties files;
	
	Project_Page probObj=new Project_Page(driver);
	
	@Given("User able to Navigate to Open Browser")
	public void user_able_to_Navigate_to_Open_Browser() throws IOException {
	   
	  FileInputStream fis=new FileInputStream("Config.properties");	
	  files=new Properties();
	  files.load(fis);
	  System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_138.exe");
	  driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get(files.getProperty("Url"));
	  
	  System.out.println("Browser Launch");
	  
	  
	}

	@When("User Login with UserName{string} and Password{string} by click on Login Button")
	public void user_Login_with_UserName_and_Password_by_click_on_Login_Button(String string, String string2) throws InterruptedException {
      
		Thread.sleep(1000);
		probObj.ValidLogin(driver);
		System.out.println("Login Sucessfully");
	}

	@Then("User login Application Sucessfully")
	public void user_login_Application_Sucessfully() {
	    
	}

	@Then("User Verify the Home Page deatils Functionlity")
	public void user_Verify_the_Home_Page_deatils_Functionlity() {
	    
	}

	@Then("User Verify the Inventroy Tab")
	public void user_Verify_the_Inventroy_Tab() {
	    
	}

	@Then("User Verify the Product Tab")
	public void user_Verify_the_Product_Tab() {
	    
	}


}
