package stepdefinition;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ServiceContact_TestScript {
	
	
	public static WebDriver driver;
	public static Properties files;
	
	@Given("User Navigate to Launch Application")
	public void user_Navigate_to_Launch_Application() throws IOException, InterruptedException {
		
		FileInputStream fis=new FileInputStream("Config.properties");
		files=new Properties();
		files.load(fis);
	    System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_144.exe");
	    driver=new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    driver.get(files.getProperty("Url"));
	    Thread.sleep(1000);
	    
	   
	}

	@When("User enter {string} and {string} by click on Login Page")
	public void user_enter_and_by_click_on_Login_Page(String Uname, String Password) throws InterruptedException, IOException {
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(Uname);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(Password);
		
		WebElement login=driver.findElement(By.xpath("//input[@name='Login']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",login);
		
		Thread.sleep(1000);
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshots/newissue.png"));
	    
	}

	@Then("User verify Login Page")
	public void user_verify_Login_Page() {
		
		System.out.println("Login Sucessfully");
	    
	}

	@Then("User verify the Home Page Functionlity")
	public void user_verify_the_Home_Page_Functionlity() {
	   
		String ActualTitle=driver.getTitle();
		String expTitle="admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";
		
		Assert.assertEquals(ActualTitle, expTitle);
		System.out.println("Ttile Matched");
		
	}

	@Then("User verify and create new ServiceContact{string} Page")
	public void user_verify_and_create_new_ServiceContact_Page(String Subject) throws InterruptedException {
		
		WebElement MuoseHover=driver.findElement(By.xpath("//a[text()='Support']"));
		Actions act=new Actions(driver);
		act.moveToElement(MuoseHover).build().perform();
		
		WebElement trouble=driver.findElement(By.xpath("//div[@id='Support_sub']/table/tbody/tr/td//a[text()='Trouble Tickets']"));
		if(trouble.isEnabled()) {
			
			trouble.click();
		}
		
		WebDriverWait wait=new WebDriverWait(driver,10);
		WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='HelpDesk']")));
		
		boolean status=ele.isDisplayed();
		
		if(status) {
			
			System.out.println("Element is Visiable");
		}
		else {
			
			System.out.println("Element is not visiable");
		}
		driver.findElement(By.xpath("//a[text()='Service Contracts']")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//img[@title='Create Service Contract...']")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@id='subject']")).sendKeys(Subject);
		
		driver.findElement(By.xpath("//input[@value='  Save  '][1]")).click();
		Thread.sleep(1000);
	    
	}

}
