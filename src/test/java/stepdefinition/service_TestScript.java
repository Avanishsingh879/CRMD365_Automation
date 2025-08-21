package stepdefinition;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class service_TestScript {
	
	
	
	
	
	public static WebDriver driver;
	public static Properties files;
	
	@Given("User navigate to open url")
	public void user_navigate_to_open_url() throws IOException {
		
		FileInputStream fis=new FileInputStream("Config.properties");
		files=new Properties();
		files.load(fis);
	      
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_139.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get(files.getProperty("Url"));
		System.out.println("Browser Launch");
		
		
	   
	}

	@When("User able to Enter UserName{string} and Password{string} by click on Login Button")
	public void user_able_to_Enter_UserName_and_Password_by_click_on_Login_Button(String Uname, String Pwd) {
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(Uname);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(Pwd);
		
		WebElement login=driver.findElement(By.xpath("//input[@name='Login']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", login);
		
		System.out.println("Login");
		
	    
	}

	@Then("user Able to Login sucessfully")
	public void user_Able_to_Login_sucessfully() {
		
		System.out.println("Login Sucessfully");
	    
	}

	@Then("User Verify the home page functionliy Data")
	public void user_Verify_the_home_page_functionliy_Data() {
		
		String ActTitle=driver.getTitle();
		String ExpTitle="admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";
		
		Assert.assertEquals(ActTitle, ExpTitle);
		
		System.out.println("Title Matched");
		
		
	   	}

	@Then("User verify and create service tab")
	public void user_verify_and_create_service_tab() throws InterruptedException {
		
		WebElement MouseHover=driver.findElement(By.xpath("//a[text()='Inventory']"));
		Actions act=new Actions(driver);
		
		act.moveToElement(MouseHover).build().perform();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[@id='Inventory_sub']/table/tbody/tr[8]/td/a[text()='Services']")).click();
		
		System.out.println("User able to click Service Tab");
	    
	}

	@Then("User verify the ServiceList data in List")
	public void user_verify_the_ServiceList_data_in_List() {
	    
		List<WebElement>AllList=driver.findElements(By.xpath("//select[@id='bas_searchfield'][1]/option"));
		
		String[]str= {"Service No","Service Name"};
		for(WebElement wb: AllList) {
			
			for(int i=0;i<str.length;i++) {
				
				if(wb.getText().equals(str[i])) {
					
					
					System.out.println("Title Matched");
				}
			}
		}
		System.out.println("Test case Passed");
		
	}
}





