package stepdefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.Alert;
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

public class Marketing_TestScript {
	
	//Date-11-5-25
	public static WebDriver driver;
	public static Properties files;
	
	@Given("User Navigate to Application URL")
	public void user_Navigate_to_Application_URL() throws IOException, InterruptedException {
		
		FileInputStream fis=new FileInputStream("Config.properties");
		files=new Properties();
		files.load(fis);
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_135.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(files.getProperty("Url"));
		Thread.sleep(2000);
		System.out.println("Browser Launch");
		/////////////////////////////////////////////////
		/////////TakeScreenshots/////////////////////////
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshots/Home.png"));
		Thread.sleep(1000);
	    
		
	}
	

	@When("User Enter UserName and Password by click on Sign In Button")
	public void user_Enter_UserName_and_Password_by_click_on_Sign_In_Button() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(files.getProperty("username"));
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(files.getProperty("password"));
		driver.findElement(By.xpath("//input[@name='Login']")).click();
		Thread.sleep(1000);
		
	    
	}

	@Then("User Is in Home Page")
	public void user_Is_in_Home_Page() {
		
		String ActualTitle=driver.getTitle();
		String ExpTitle="";
		
		if(ActualTitle.equalsIgnoreCase(ExpTitle)) {
			
			System.out.println("Title Matched");
		}
		
		else {
			
			System.out.println("Title is not Matched");
		}
	    
	}
	
	@Then("User has click on Marketing Tab")
	public void user_has_click_on_Marketing_Tab() throws IOException {
		
	  WebElement MouseHover=driver.findElement(By.xpath("//a[text()='Marketing']"));
	  String txt= MouseHover.getText();
	  System.out.println(txt);
	  Actions act=new Actions(driver);
	  act.moveToElement(MouseHover).build().perform();
	  File srcc=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(srcc, new File("./Screenshots/Test1.png"));
	    
	}

	@Then("User has click on Account Tab")
	public void user_has_click_on_Account_Tab() throws InterruptedException {
	   
		WebElement acc=driver.findElement(By.xpath("//*[@id='Marketing_sub']/table/tbody/tr[2]//a"));
		acc.click();
		Thread.sleep(1000);
	}
	
	@Then("User verify and select Multiple Check box in Marketing Page")
	public void user_verify_and_select_Multiple_Check_box_in_Marketing_Page() throws InterruptedException {
	    
		List<WebElement> AllChk=driver.findElements(By.xpath("//input[@name='selected_id']"));
		int size=AllChk.size();
		System.out.println(size);
		
		for(int i=0;i<AllChk.size();i++) {
			
			WebElement ele=AllChk.get(i);
			String txt=ele.getText();
			System.out.println(txt);
			ele.click();
			Thread.sleep(1000);
			System.out.println("All Check Box Checked");
		}
		
		
	}
	
	@Then("User verify the Pop up Alert message")
	public void user_verify_the_Pop_up_Alert_message() throws InterruptedException {
		
		WebElement checkbox=driver.findElement(By.xpath("//input[@id='16'][@type='checkbox']"));
		if(checkbox.isEnabled()) {
			
			checkbox.click();
			Thread.sleep(1000);
			
			WebElement DelBtn=driver.findElement(By.xpath("//table[@class='small']//input[@value='Delete']"));
			DelBtn.click();
			Thread.sleep(1000);
			Alert alt=driver.switchTo().alert();
			alt.dismiss();
			System.out.println("Pop up Cancled");
		}
	   
	}
}









