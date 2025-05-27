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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Contacts_TestScript {
	
	
	public static WebDriver driver;
	public static Properties files;
	
	@Given("User Navigate to Aplication Url")
	public void user_Navigate_to_Aplication_Url() throws IOException, InterruptedException {
	    
		FileInputStream fis=new FileInputStream("Config.properties");
		files=new Properties();
		files.load(fis);
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_136.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(files.getProperty("Url"));
		System.out.println("Berowser Launch");
		Thread.sleep(1000);
	}

	@When("User enter Username and Password by click on Login Button")
	public void user_enter_Username_and_Password_by_click_on_Login_Button() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(files.getProperty("username"));
		WebElement password=driver.findElement(By.xpath("//input[@name='user_password']"));
		WebElement login=driver.findElement(By.xpath("//input[@name='Login']"));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='admin'",password);
		js.executeScript("arguments[0].click()",login);
		
		Thread.sleep(1000);
	    
	}

	@Then("User has click on Support Tab")
	public void user_has_click_on_Support_Tab() throws InterruptedException {
		
		
		WebElement MouseHover=driver.findElement(By.xpath("//a[text()='Support']"));
		
		Actions act=new Actions(driver);
		act.moveToElement(MouseHover).build().perform();
		
		driver.findElement(By.xpath("//div[@id='Support_sub']/table/tbody/tr/td//a[text()='Trouble Tickets']")).click();
		
		Thread.sleep(1000);
		
		WebDriverWait wait=new WebDriverWait(driver,10);
		WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='HelpDesk']")));
		boolean status=ele.isDisplayed();
		
		if(status) {
			
			System.out.println("Element is visible");
		}
		else {
			
			System.out.println("Elemnt is not Vidble");
		}
	    
	}

	@Then("User has click Contacts tab")
	public void user_has_click_Contacts_tab() {
	    
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
	    WebElement list=driver.findElement(By.xpath("//select[@id='bas_searchfield'][1]"));
	    Select sel=new Select(list);
	    
	   String[]str= {"Contact Id","First Name","Last Name"};
	   List<WebElement>AllList=sel.getOptions();
	   
	   for(WebElement wb:AllList) {
		   
		   for(int i=0;i<str.length;i++) {
			   
			   if(wb.getText().equals(str[i])) {
				   
				   System.out.println("List Matched");
			   }
		   }
	   }
	   
		
		
	}

}
