package stepdefinition;

import static org.testng.Assert.assertEquals;

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

public class quotes_TestScript {
	
	
	public static WebDriver driver;
	public static Properties files;
	@Given("user Navigate to Application url")
	public void user_Navigate_to_Application_url() throws IOException {
	    
	FileInputStream fis=new FileInputStream("Config.properties");
	files=new Properties();
	files.load(fis);
	System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_139.exe");
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	driver.get(files.getProperty("Url"));
	System.out.println("Browser");
	
	/////Takes Screenshot/////////////////
	
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("./Screenshots/Test1.png"));
	
	
	
	
	
	}

	@When("User enter UserName{string} and passWord{string} by click on Login Button")
	public void user_enter_UserName_and_passWord_by_click_on_Login_Button(String Uname, String pwd) {
	
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(Uname);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@name='Login']")).click();
	}

	@Then("user able to login Sucessfully")
	public void user_able_to_login_Sucessfully() {
		
		System.out.println("Login Sucessfully");
	    
	}

	@Then("user verify the home page functionlity")
	public void user_verify_the_home_page_functionlity() {
	   
		String ActualTitle=driver.getTitle();
		String ExpTitle="admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";
		Assert.assertEquals(ActualTitle, ExpTitle);
		System.out.println("Title Matched");
	}

	@Then("user able to click quotes tab")
	public void user_able_to_click_quotes_tab() throws InterruptedException {
		
		WebElement MouseHover=driver.findElement(By.xpath("//a[text()='Inventory']"));
		Actions act=new Actions(driver);
		act.moveToElement(MouseHover).build().perform();
		
		Thread.sleep(1000);
		
		WebElement quotestLinks=driver.findElement(By.xpath("//div[@id='Inventory_sub']/table/tbody/tr[6]/td/a[text()='Quotes']"));
		quotestLinks.click();
		
		System.out.println("User Able to click Quotes Tab");
	    
	}


    @Then("user verify the QuotesList in Quotes")
    public void user_verify_the_QuotesList_in_Quotes() {
    
       WebElement searchField=driver.findElement(By.xpath("//select[@id='bas_searchfield'][1]"));
       
       String[]str= {"Quote No","Subject"};
       Select sel=new Select(searchField);
       List<WebElement>AllOptions=sel.getOptions();
       
       for(WebElement wb:AllOptions) {
    	   
    	   for(int i=0;i<str.length;i++) {
    		   
    		   if(wb.getText().equals(str[i])) {
    			   
    			   System.out.println("List Data Matched");
    		   }
    	   }
    	   
    	   
       }
       System.out.println("Matched");
}
}






















