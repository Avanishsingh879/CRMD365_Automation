package stepdefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import PageObject.Vendor_Page;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Vendor_TestScript {
	
	/// @ignore
	
	public WebDriver driver;
	public static Properties files;
	
	Vendor_Page VenPage=new Vendor_Page(driver);
	@Given("I Navigate to open Application Url")
	public void i_Navigate_to_open_Application_Url() throws IOException, InterruptedException {
		
		FileInputStream fis=new FileInputStream("Config.properties");
		files=new Properties();
		files.load(fis);
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_138.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(files.getProperty("Url"));
		
		System.out.println("Browser Launch");
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshots/TestNg.png"));
		System.out.println("Takes Screenshot");
		Thread.sleep(1000);
		
		
	    
	}

	@When("User enter username {string} and password {string} by click on Login Button")
	public void user_enter_username_and_password_by_click_on_Login_Button(String Uname, String pwd) throws InterruptedException {
	    
		VenPage.ValidLogin(driver);
		Thread.sleep(1000);
	}

	@Then("User Login")
	public void user_Login() {
	    
		System.out.println("Login Sucessfully");
	}

	@Then("User able to verify Home Page Functionlity")
	public void user_able_to_verify_Home_Page_Functionlity() throws InterruptedException {
		
		Thread.sleep(1000);
		String ActualTitle=driver.getTitle();
		String ExpTitle="admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";
		Assert.assertEquals(ActualTitle, ExpTitle);
		
		System.out.println("Title Matched");
	    
	}

	@Then("User verify the Vendor Tab")
	public void user_verify_the_Vendor_Tab() throws InterruptedException {
		
		Thread.sleep(1000);
		VenPage.MouseHover(driver);
	  
	}
	
	@Then("User verify VendorList in Vendor Page")
	public void user_verify_VendorList_in_Vendor_Page() throws InterruptedException {
		
		Thread.sleep(1000);
		
		WebElement list=driver.findElement(By.xpath("//select[@id='bas_searchfield'][1]"));
		
		String[]str= {"Vendor No","Vendor Name"};
		
		Select sel=new Select(list);
		List<WebElement>allList=sel.getOptions();
		
		for(WebElement wb:allList) {
			
			
			for(int i=0;i<str.length;i++) {
				
				if(wb.getText().equals(str[i])) {
					
					
					System.out.println("Title Matched");
				}
			}
			
		}
		System.out.println("Test Case Passed");
		
	}
	
}

















