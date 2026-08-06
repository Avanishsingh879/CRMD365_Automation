package stepdefinition;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;
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

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.gargoylesoftware.htmlunit.javascript.host.Iterator;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Suport_TestScript {
	
	//Date:26-7-26
	
	public static WebDriver driver;
	public static Properties files;
	
	@Given("User Navigate to Open Url")
	public void user_Navigate_to_Open_Url() throws IOException {
		
		FileInputStream fis=new FileInputStream("Config.properties");
		files=new Properties();
		files.load(fis);
	    System.setProperty("webdriver.chrome.driver","Drivers\\chromedriver_150.exe");
	    driver=new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    driver.get(files.getProperty("Url"));
	    System.out.println("Browser Launch");
	    File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(file, new File("./Screenshots/Support.png"));
	    System.out.println("Screenshot Taken");
	    
		
	}

	@When("User enter {string} and {string} by click on Sign Button")
	public void user_enter_and_by_click_on_Sign_Button(String Username, String Password) {
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(Username);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(Password);
		WebElement login=driver.findElement(By.xpath("//input[@name='Login']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click();", login);
	    
	    
	    
	}

	@Then("User Login SUcessfullY")
	public void user_Login_SUcessfullY() {
		
	   String actTitle=driver.getTitle();
	   String ExpTitle="admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";
	   Assert.assertEquals(actTitle, ExpTitle);
	   System.out.println("Verify Title");
	    
	}

	@Then("User Verify Home Page Functionlity")
	public void user_Verify_Home_Page_Functionlity() {
		
		WebElement txt=driver.findElement(By.xpath("//a[text()='Support']"));
		String tx=txt.getText();
		System.out.println(tx);
	    
	}
	
	@Then("User verify the Support Page")
	public void user_verify_the_Support_Page() {
		
	WebElement support=driver.findElement(By.xpath("//a[text()='Support']"));
	Actions act=new Actions(driver);
	act.moveToElement(support).build().perform();
	System.out.println("Mouse Hover Handled");
	
	
	    
	}

	@Then("User verify and create Account in Support Page")
	public void user_verify_and_create_Account_in_Support_Page() throws IOException {
		
		WebElement acc=driver.findElement(By.xpath("//div[@id='Support_sub']//a[text()='Accounts']"));
		acc.click();
		List<WebElement>allLit=driver.findElements(By.xpath("//input[@name='selected_id']"));
		
		for(int i=0;i<allLit.size();i++) {
			
			allLit.get(i).click();
		}
		
		File file1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file1, new File("./Screenshots/Account.png"));
		
	   
	}
	
	@Then("User verify the EditMass Page Functionlity")
	public void user_verify_the_EditMass_Page_Functionlity() throws InterruptedException {
	    
        driver.findElement(By.xpath("//input[@value='Mass Edit'][1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='tickersymbol']")).sendKeys("Test");
        driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
        Thread.sleep(1000);
	}
	
	@Then("User verify and create SendEmail in Contact Page")
	public void user_verify_and_create_SendEmail_in_Contact_Page() throws IOException, InterruptedException {
	  
	WebElement ele=driver.findElement((By.xpath("//div[@id='Support_sub']//a[text()='Contacts']")));
	ele.click();
	
	File files2=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(files2, new File("./Screenshots/TestNew.png"));
    
    driver.findElement(By.xpath("//input[@name='selected_id']")).click();
    
    System.out.println("Check box checked");
    driver.findElement(By.xpath("//input[@value='Send Mail'][1]")).click();
    
    Thread.sleep(1000);
    
    String mainwindow=driver.getWindowHandle();
    System.out.println(mainwindow);
    Set<String>set=driver.getWindowHandles();
    
    java.util.Iterator<String> itr1=set.iterator();
    while(itr1.hasNext()==true) {
    	
    	String childwindow=itr1.next();
    	System.out.println(childwindow);
    	String Title=driver.switchTo().window(childwindow).getTitle();
    	
    	if(Title.equals("Compose Mail")) {
    		
    		break;
    		
    	} 	
    }
	
    driver.findElement(By.xpath("//input[@id='subject']")).sendKeys("Test");
	} 
	
	       
	
}






