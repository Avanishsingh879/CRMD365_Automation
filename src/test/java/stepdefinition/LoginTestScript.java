package stepdefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class LoginTestScript {
	
	public static WebDriver driver;
	
	@Given("I navigate to application Open URL")
	public void i_navigate_to_application_Open_URL() throws IOException, InterruptedException {
		Thread.sleep(5000);
		FileInputStream fis=new FileInputStream("Config.properties");
		Properties prop=new Properties();
		prop.load(fis);
		System.setProperty("webdriver.chrome.driver","Drivers\\chromedriver_106.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.get(prop.getProperty("Url"));
		Thread.sleep(6000);
	}

	@When("User Enter Username and Password by click on Login Button")
	public void user_Enter_Username_and_Password_by_click_on_Login_Button() throws InterruptedException, IOException {
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		 ////////Take Screenshot///////////
		File folder=new File("Screenshots");
		
		if(folder.exists()&& folder.isDirectory() ) {
			
			File newsrc= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(newsrc, new File("./Screenshots/Login.png"));
			
			System.out.println("Take Screenshot in Folder");
			
			Thread.sleep(2000);
		}
	    driver.findElement(By.xpath("//input[@name='Login']")).click();
	    
	    Thread.sleep(2000);
	}


   @Then ("Login Sucessfully")
   
   public void login_Sucessfully() throws InterruptedException {
	   
	   Thread.sleep(2000);
	   
	   System.out.println("Login Sucessfully");
   
   }
   
   @Then("User is in VtigerCRM Home Page")
	public void user_is_in_VtigerCRM_Home_Page() throws InterruptedException {
		
		String ActualTtile=driver.getTitle();
		String expTtile="admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";
		
		if(ActualTtile.equalsIgnoreCase(expTtile)) {
			System.out.println("Title Matched");
		}
		
		else {
			
			System.out.println("Title Not Matched");
		}
	   
		Thread.sleep(2000);
	}
}




