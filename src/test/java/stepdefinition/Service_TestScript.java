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

public class Service_TestScript {
	
	
	
	public static WebDriver driver;
	public static Properties files;
	
	@Given("User open the Application")
	public void user_open_the_Application() throws IOException, InterruptedException {
		
		FileInputStream fis=new FileInputStream("Config.properties");
		files=new Properties();
		files.load(fis);
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_137.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get(files.getProperty("Url"));
		System.out.println("Browser Launch");
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshots/Testfail.png"));
		Thread.sleep(1000);
		
	   
	}

	@When("user login {string} and {string} by click on login tab")
	public void user_login_and_by_click_on_login_tab(String username, String password) {
	   
	   driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
	   driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
	   
	   JavascriptExecutor js=(JavascriptExecutor)driver;
	   
	   WebElement login= driver.findElement(By.xpath("//input[@name='Login']"));
	   js.executeScript("arguments[0].click()",login);
	   
	   System.out.println("Login Sucessfully");
	}

	@Then("user verify Home Page Item")
	public void user_verify_Home_Page_Item() {
		
		
		String Actual=driver.getTitle();
		String ExpTitle="admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";
		
		Assert.assertEquals(Actual, ExpTitle);
		System.out.println("Title Matched");
	 
		
	}

	@Then("user verify and create new Service page")
	public void user_verify_and_create_new_Service_page() throws InterruptedException {
	  
		WebElement MouseHover=driver.findElement(By.xpath("//a[text()='Inventory']"));
		Actions act=new Actions(driver);
		act.moveToElement(MouseHover).build().perform();
		
		Thread.sleep(1000);
		
		WebElement service_Btn=driver.findElement(By.xpath("//div[@id='Inventory_sub']/table/tbody/tr[8]/td//a[text()='Services']"));
		service_Btn.click();
		
		System.out.println("Service Button Clickable");
	}

	
	@Then("user verify List of Service in ServiceList")
	public void user_verify_List_of_Service_in_ServiceList() {
	    
	 WebElement dropList= driver.findElement(By.xpath("//select[@id='bas_searchfield'][1]"));
	 
	 Select sel=new Select(dropList);
	 
	 String[]str= {"Service No","Service Name"};
	 
	 List<WebElement>listdata=sel.getOptions();
	 
	 for(WebElement wb:listdata) {
		 
		 for(int i=0;i<str.length;i++) {
			 
			 if(wb.getText().equals(str[i])) {
				 
				 System.out.println("Service Title Matched");
			 }
		 }
		 
	 }
	 System.out.println("User verify the List Service");
	}

}


















