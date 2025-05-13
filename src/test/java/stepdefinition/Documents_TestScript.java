package stepdefinition;

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

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Documents_TestScript {
	
	////////////////////////////////////////////
	public static WebDriver driver;
	public static Properties files;
	
	@Given("User Navigate To Application URL")
	public void user_Navigate_To_Application_URL() throws IOException, InterruptedException {
	    
		FileInputStream fis=new FileInputStream("Config.properties");
		files=new Properties();
		files.load(fis);
	    System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_135.exe");
	    driver=new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    driver.get(files.getProperty("Url"));
	    Thread.sleep(1000);
	}

	@When("User Enter UserName and Password by Click on Sign In Button")
	public void user_Enter_UserName_and_Password_by_Click_on_Sign_In_Button() throws IOException {
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(files.getProperty("username"));
		WebElement pwd=driver.findElement(By.xpath("//input[@name='user_password']"));
		
		WebElement Login=driver.findElement(By.xpath("//input[@name='Login']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='admin'", pwd);
		js.executeScript("arguments[0].click()", Login);
		//////////////////////////////////////////////////////////
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshots/docs.png"));
	    
	}

	@Then("User Login SucessFully")
	public void user_Login_SucessFully() {
		
		System.out.println("Login Sucessfully");
	   
	}

	@Then("User Is in home Page")
	public void user_Is_in_home_Page() {
		
		String ActualTitle=driver.getTitle();
		String ExpTitle="admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";
		
		if(ActualTitle.equalsIgnoreCase(ExpTitle)) {
			
			System.out.println("Title Matched");
		}
		else {
			
			System.out.println("Title is not Matched");
		}
	   
	}

	@Then("User has click on marketing Tab")
	public void user_has_click_on_marketing_Tab() {
		
		WebElement MouseHover=driver.findElement(By.xpath("//a[text()='Marketing']"));
		Actions act=new Actions(driver);
		act.moveToElement(MouseHover).build().perform();
		System.out.println("Mosuehover Done");
	    
	}

	@Then("User has click on account Tab")
	public void user_has_click_on_account_Tab() throws InterruptedException {
	   
		WebElement acc=driver.findElement(By.xpath("//div[@id='Marketing_sub']/table/tbody/tr[2]//a"));
		acc.click();
		Thread.sleep(1000);
	}

	@Then("User has click on documents Tab")
	public void user_has_click_on_documents_Tab() throws InterruptedException {
		
		driver.findElement(By.xpath("//table[3]/tbody/tr/td/table/tbody/tr/td[7]/a")).click();
		Thread.sleep(1000);
		System.out.println("User has click on Documents Tab");
	    
	}

}
