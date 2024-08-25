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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Suport_TestScript {
	
	
	
	public static WebDriver driver;
	public static Properties files;
	
	@Given("I navigate To Application open URl")
	public void i_navigate_To_Application_open_URl() throws IOException, InterruptedException {
		
		FileInputStream fis=new FileInputStream("Config.properties");
		files=new Properties();
		files.load(fis);
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_121.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(files.getProperty("Url"));
		System.out.println("Browser launch");
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshots/LoginPage.png"));
		Thread.sleep(2000);
	
	}

	@When("user Enter Username and Password By click on Login button")
	public void user_Enter_Username_and_Password_By_click_on_Login_button() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(files.getProperty("username"));
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(files.getProperty("password"));
		Thread.sleep(1000);
		WebElement Sign_Link=driver.findElement(By.xpath("//input[@name='Login']"));
		Sign_Link.click();
		Thread.sleep(2000);  
	}

	@Then("User is in VtigercRM home page")
	public void user_is_in_VtigercRM_home_page() {
		
		String actTitle=driver.getTitle();
		String ExcTitle="admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";
		if(actTitle.equalsIgnoreCase(ExcTitle)) {
			
			System.out.println("Title Matched");
		}
		else {
			
			System.out.println("Title is Not Matched");
		}
	   
	}

	@Then("User has click on Support tab")
	public void user_has_click_on_Support_tab() throws InterruptedException {
		
		Thread.sleep(1000);
		WebElement supp=driver.findElement(By.linkText("Support"));
		//supp.click();
	    
	}

	@Then("User has click on Contacts tab")
	public void user_has_click_on_Contacts_tab() throws InterruptedException, IOException {
		
		WebElement Support_MouseHover=driver.findElement(By.xpath("//a[text()='Support']"));
		String text=Support_MouseHover.getText();
		System.out.println(text);
		Actions act=new Actions(driver);
		act.moveToElement(Support_MouseHover).build().perform();
		WebElement contacts=driver.findElement(By.xpath("//div[@id='Support_sub']/table/tbody/tr[4]//a"));
		contacts.click();
		Thread.sleep(1000);
		File scrc=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrc, new File("./Screenshots/Cont.png"));
		System.out.println("User Has Click on Contact Tab");
		
		
	   
	}

	@Then("User verify the Creating Contacts in Support by click on Save button")
	public void user_verify_the_Creating_Contacts_in_Support_by_click_on_Save_button() {
	   
	}
    
	///Date-1-10-2023
	@Then("User has click on Documents tab")
	public void user_has_click_on_Documents_tab() {
	   
	}
     
	///Date-1-10-2023
	@Then("User verify the Creating Documents in Support Tab by click on Save button")
	public void user_verify_the_Creating_Documents_in_Support_Tab_by_click_on_Save_button() {
	    
	}

}
