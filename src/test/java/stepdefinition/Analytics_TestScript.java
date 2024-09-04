package stepdefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import Generic_Method.Utility_Method;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Analytics_TestScript {
	
	public static WebDriver driver;
	public static Properties files;
	
	@Given("I navigate to APPlication open UrL")
	public void i_navigate_to_APPlication_open_UrL() throws IOException, InterruptedException {
		
		FileInputStream fis=new FileInputStream("Config.properties");
		files=new Properties();
		files.load(fis);
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_127.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(files.getProperty("Url"));
		System.out.println("Browser Launch");
		Thread.sleep(2000);;
	    
	}

	@When("User eneter username and password by click on Sign In Page")
	public void user_eneter_username_and_password_by_click_on_Sign_In_Page() throws InterruptedException {
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(files.getProperty("username"));
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(files.getProperty("password"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='Login']")).click();
		Thread.sleep(1000);
	    
	}

	@Then("User verify Home Page Functionlity")
	public void user_verify_Home_Page_Functionlity() {
		
		String ActualTitle=driver.getTitle();
		String ExceptedTitle="admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";
		if(ActualTitle.equalsIgnoreCase(ExceptedTitle)) {
			
		  System.out.println("Title Matched");
		}
		else {
			
			System.out.println("Title is not matched");
		}
	    
	}

	@Then("User able to click Analytics Tab")
	public void user_able_to_click_Analytics_Tab() throws InterruptedException, IOException {
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//table[@class='hdrTabBg']/tbody/tr/td[2]//a[text()='Analytics']")).click();
		Thread.sleep(1000);
		/////////////////////////////////////////////
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshots/Analyiecs.png"));
	    
	}
	
	@Then("User verify Report Page Functionlity")
	public void user_verify_Report_Page_Functionlity() throws InterruptedException {
	    
		WebElement MouseHover=driver.findElement(By.xpath("//table[@class='hdrTabBg']/tbody/tr/td[2]//a[text()='Analytics']"));
		Actions act=new Actions(driver);
		act.moveToElement(MouseHover).build().perform();
		driver.findElement(By.xpath("//div[@id='Analytics_sub']/table/tbody/tr/td//a[text()='Reports']")).click();
		Thread.sleep(2000);
	}

}













