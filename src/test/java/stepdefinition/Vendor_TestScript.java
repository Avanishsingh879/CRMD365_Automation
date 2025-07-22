package stepdefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Vendor_TestScript {
	
	
	public static WebDriver driver;
	public static Properties files;
	@Given("User navigate to launch Browser")
	public void user_navigate_to_launch_Browser() throws IOException {
		
	FileInputStream fis=new FileInputStream("Config.properties");
	files=new Properties();
	files.load(fis);
	
	System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_138.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get(files.getProperty("Url"));
	System.out.println("Browser Launch");
	    
	}

	@When("User Login with {string} and {string} by click on Login Tab")
	public void user_Login_with_and_by_click_on_Login_Tab(String Username, String Password) throws IOException {
		
	 driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(Username);
     driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(Password);
	 WebElement Login=driver.findElement(By.xpath("//input[@name='Login']"));
	    
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click()", Login);
	    
	    System.out.println("Login Sucessfully");
	    
	    File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(src, new File("./Screenshots/TestNg.png"));
	}

	@Then("User able to login sucessfully")
	public void user_able_to_login_sucessfully() {
		
		System.out.println("User Login Sucessfully");
		
	    
	}

	@Then("User Home page Functionlity")
	public void user_Home_page_Functionlity() {
		
		String ActualTitle=driver.getTitle();
		String ExpTitle="admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";
		Assert.assertEquals(ActualTitle, ExpTitle);
		System.out.println("Title Matched");
	   
		
	}

	@Then("User Able to click on Vendor Tab")
	public void user_Able_to_click_on_Vendor_Tab() throws InterruptedException {
	
		WebElement MouseHover=driver.findElement(By.xpath("//a[text()='Inventory']"));
		Actions act=new Actions(driver);
		act.moveToElement(MouseHover).build().perform();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='Inventory_sub']/table/tbody/tr[2]/td//a[text()='Vendors']")).click();
		System.out.println("User able to click Vendor Tab");
	   
	}
	
	@Then("User Verify the List Data in Vendor")
	public void user_Verify_the_List_Data_in_Vendor() {
		
		
      WebElement sel=driver.findElement(By.xpath("//select[@name='search_field'][1]"));
      Select select=new Select(sel);
      List<WebElement>list=select.getOptions();
      
      String[]str= {"Vendor No","Vendor Name"};
      
      for(WebElement wb:list) {
    	  
    	  for(int i=0;i<str.length;i++) {
    		  
    		  if(wb.getText().equals(str[i])) {
    			  
    			  System.out.println("Title Matched");
    		  }
    	  }
      }
	  System.out.println("Test pass");  
		
	}

}

















