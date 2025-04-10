package stepdefinition;

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
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Marketing_TestScript {
	
	
	public static WebDriver driver;
	public static Properties files;
	
	@Given("User Navigate to Application URL")
	public void user_Navigate_to_Application_URL() throws IOException, InterruptedException {
		
		FileInputStream fis=new FileInputStream("Config.properties");
		files=new Properties();
		files.load(fis);
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_135.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(files.getProperty("Url"));
		Thread.sleep(2000);
		System.out.println("Browser Launch");
	    
		
	}
	

	@When("User Enter UserName and Password by click on Sign In Button")
	public void user_Enter_UserName_and_Password_by_click_on_Sign_In_Button() {
	    
	}

	@Then("User Is in Home Page")
	public void user_Is_in_Home_Page() {
	    
	}
	
	
}
