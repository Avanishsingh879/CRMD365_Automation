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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class docuemts_TestScript {
	
	public static WebDriver driver;
	public static Properties files;
	
	@Given("User open the Application URL")
	public void user_open_the_Application_URL() throws IOException {
		
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

	@When("User enter Uname{string} and Paaswrd {string} by click on Login Button")
	public void user_enter_Uname_and_Paaswrd_by_click_on_Login_Button(String UserName, String Password) {
		
    driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(UserName);
    driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(Password);
    driver.findElement(By.xpath("//input[@name='Login']")).click();
    
    System.out.println("Login Sucessfully");
		
		
	    
	}

	@Then("user able to Login Sucessfully")
	public void user_able_to_Login_Sucessfully() {
		
		System.out.println("Login");
	    
	}

	@Then("User able to Verify the Home page Functionlity")
	public void user_able_to_Verify_the_Home_page_Functionlity() {
		
		String ActualTitle=driver.getTitle();
		String ExpTitle="admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";
		Assert.assertEquals(ActualTitle, ExpTitle);
		
		System.out.println("Title Matched");
	    
	}

	@Then("User able to click on Documemts Tab")
	public void user_able_to_click_on_Documemts_Tab() throws InterruptedException, IOException {
		
		WebElement MouseHover=driver.findElement(By.xpath("//a[text()='Tools']"));
		
		Actions act=new Actions(driver);
		act.moveToElement(MouseHover).build().perform();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[@id='Tools_sub']/table/tbody/tr[3]/td/a[text()='Documents']")).click();
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("./Screenshots/NewTest.png"));
		
		System.out.println("User able to click on Documents Tab");
		
	   
	}
	
	@Then("User verify the Documets List in ListData")
	public void user_verify_the_Documets_List_in_ListData() {
	    
		WebElement AllList=driver.findElement(By.xpath("//select[@name='search_field'][1]"));
		
		Select sel=new Select(AllList);
		String[]str= {"Document No","Title"};
		List<WebElement>al=sel.getOptions();
		
		for(WebElement wb:al) {
			
			for(int i=0;i<str.length;i++) {
				
				if(wb.getText().equals(str[i])) {
					
					System.out.println("Title Matched");
				}
			}
			System.out.println("Documets Verifyed");
		}
		
		
	}

}
















