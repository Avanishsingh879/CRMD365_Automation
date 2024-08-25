package stepdefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import Generic_Method.Utility_Method;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FeedBack_TestScript {
	
	
	public static WebDriver driver;
	public static Properties files;
	//Test case passed Date: 19-7-24
	
	@Given("User navigate the Application Url")
	public void user_navigate_the_Application_Url() throws IOException, InterruptedException {
		
		/*
		 * FileInputStream fis=new FileInputStream("Config.properties"); files=new
		 * Properties(); files.load(fis); System.setProperty("webdriver.chrome.driver",
		 * "Drivers\\chromedriver_126.exe"); driver=new ChromeDriver();
		 * driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		 * driver.manage().window().maximize(); driver.get(files.getProperty("Url"));
		 * System.out.println("Browser Launch"); Thread.sleep(2000); File
		 * src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 * FileUtils.copyFile(src, new File("./Screenshots/test16.png"));
		 */
		
		System.setProperty("webdriver.chrome.driver","Drivers\\chromedriver_126.exe");		
		ChromeOptions options = new ChromeOptions();
		//options.addExtensions(new File("X://extension_3_40_1_0.crx")); 
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(capabilities);
		driver = new ChromeDriver(options);
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		System.out.println("Test case passed Sucessfully Date 8-7-24");
	   
	}

	@When("User enter username and password by click on SingIn Page")
	public void user_enter_username_and_password_by_click_on_SingIn_Page() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		
		Thread.sleep(2000);
		
		WebElement signIN=driver.findElement(By.xpath("//input[@name='Login']"));
		js.executeScript("arguments[0].click()", signIN);
		
	    Thread.sleep(2000);
		
	    
	}

	@Then("User Login Sucessfully")
	public void user_Login_Sucessfully() {
		
		System.out.println("User Login Sucessfully");
		
		 
	}
	@Then("User verify Home Page functionlity")
	public void user_verify_Home_Page_functionlity() {
	  
		String actualTitle=driver.getTitle();
		String ExceptedTitle="admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";
		if(actualTitle.equalsIgnoreCase(ExceptedTitle)) {
			
			System.out.println("Title Matched");
		}
		else {
			
			System.out.println("Title not  Matched");
		}
		
	}
	
	@Then("User verify the Bug DropDown List FeedBack Page")
	public void user_verify_the_Bug_DropDown_List_FeedBack_Page() throws InterruptedException {
		
		WebElement fbd=driver.findElement(By.xpath("//a[text()='Feedback']"));
		fbd.click();
		System.out.println("User Verify Feed backFrom");
		String mainwindow=driver.getWindowHandle();
		System.out.println(mainwindow);
		Set <String> handles =driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		//iterate through your windows
		while (it.hasNext()){
		String parent = it.next();
		String newwin = it.next();
		driver.switchTo().window(newwin);
		Thread.sleep(1000);
		WebElement des=driver.findElement(By.xpath("//*[@name='description']"));
		des.sendKeys("Test");
		Thread.sleep(2000);
	    
	}
	
	}
	
	@Then("User verify the {string},{string}Sugesstion Button in Feedback Form")
	public void user_verify_the_Sugesstion_Button_in_Feedback_Form(String Description, String Email) throws InterruptedException, IOException {
	    
		WebElement fbhform=driver.findElement(By.xpath("//a[text()='Feedback']"));
		fbhform.click();
		Thread.sleep(1000);
		/////////Handle Multiple Window
		String mainwindow=driver.getWindowHandle();
		System.out.println(mainwindow);
		Set<String>set=driver.getWindowHandles();
		Iterator<String>itr=set.iterator();
		while(itr.hasNext()) {
			
			String parent =itr.next();
			String child=itr.next();
			driver.switchTo().window(child);
			Thread.sleep(1000);
			WebElement radiobtn=driver.findElement(By.xpath("//td[@class='dvtCellInfo']//input[@value='suggestion']"));
			
			if(radiobtn.isEnabled()) {
				
				radiobtn.click();
				Thread.sleep(1000);
			}
			
		}
		
		 File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(src, new File("./Screenshots/FeedBack.png"));
		 
		 WebElement des=driver.findElement(By.xpath("//textarea[@name='description']"));
		 des.sendKeys(Description);
		 Thread.sleep(1000);
		 WebElement emaild=driver.findElement(By.xpath("//input[@name='sender-email']"));
		 emaild.sendKeys(Email);
		 Thread.sleep(1000);
		 
		 driver.findElement(By.xpath("//input[@value='Send']")).click();
		 Thread.sleep(1000);
		 System.out.println("Send Sucessfully");
		 
		 //Utility_Method.Logout();
		 
		
	}
}




















