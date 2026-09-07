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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Service_TestScript {
	
	   
	
	public static WebDriver driver;
	public static Properties files;
	
	@Given("User Navigate Application Url")
	public void user_Navigate_Application_Url() throws IOException {
	    
		FileInputStream fis=new FileInputStream("Config.properties");
		files=new Properties();
		files.load(fis);
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_151.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(files.getProperty("Url"));
		System.out.println("Browser Launch");
	}

	@When("User enter{string} and password {string} by click on Sign button")
	public void user_enter_and_password_by_click_on_Sign_button(String Uname, String Pwd) throws InterruptedException, IOException {
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(Uname);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(Pwd);
		driver.findElement(By.xpath("//input[@name='Login']")).click();
		Thread.sleep(1000);
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshots/Service.png"));
		
	}

	@Then("User Login Sucessfully Page")
	public void user_Login_Sucessfully_Page() {
		
		System.out.println("Login Sucessfully");
	    
	}

	@Then("User verify Home Page title")
	public void user_verify_Home_Page_title() {
		
		String Actualtitle=driver.getTitle();
		String ExpTitle="admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";
		Assert.assertEquals(Actualtitle, ExpTitle);
		System.out.println("Title Verifyed");
	    
	}
	
	@Then("User able to create a new Service Page")
	public void user_able_to_create_a_new_Service_Page() throws InterruptedException {
	   
		WebElement Hover=driver.findElement(By.xpath("//a[text()='Inventory']"));
		Actions act=new Actions(driver);
		act.moveToElement(Hover).build().perform();
		WebElement ele=driver.findElement(By.xpath("//div[@id='Inventory_sub']//a[text()='Services']"));
		ele.click();
		//WebDriverWait wait=new WebDriverWait(driver,10);
		driver.findElement(By.xpath("//img[@title='Create Service...']")).click();
		System.out.println("Service Created");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='servicename']")).sendKeys("Test");
		driver.findElement(By.xpath("//input[@value='  Save  '][1]")).click();
		Thread.sleep(1000);
		
	}
}





