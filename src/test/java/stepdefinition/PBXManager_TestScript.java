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
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PBXManager_TestScript {
	
	public static WebDriver driver;
	public static Properties files;
	@Given("User open the Application Url")
	public void user_open_the_Application_Url() throws IOException {
		
		FileInputStream fis=new FileInputStream("Config.properties");
		files=new Properties();
		files.load(fis);
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_138.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(files.getProperty("Url"));
		System.out.println("Launch Browser");
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshots/Pmx.png"));
		
	   
	}

	@When("User enter ussername{string} and password {string} by click on SignIn Button")
	public void user_enter_ussername_and_password_by_click_on_SignIn_Button(String UserName, String Pwd) throws InterruptedException {
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(UserName);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(Pwd);
		driver.findElement(By.xpath("//input[@name='Login']")).click();
		
		
		
	    
	}

	@Then("User able to Login sucessfilly")
	public void user_able_to_Login_sucessfilly() {
	    
		System.out.println("Login Sucessfully");
	}

	@Then("User Verify the HomePage Data")
	public void user_Verify_the_HomePage_Data() {
		
		String ActualTitle=driver.getTitle();
		String ExpTitle="admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";
		Assert.assertEquals(ActualTitle, ExpTitle);
		System.out.println("Title Matched");
	    
	}

	@Then("User able to click on PBXMager tab")
	public void user_able_to_click_on_PBXMager_tab() throws InterruptedException {
		
		WebElement MouseHover=driver.findElement(By.xpath("//a[text()='Tools']"));
		Actions act=new Actions(driver);
		act.moveToElement(MouseHover).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='Tools_sub']/table/tbody/tr[4]/td/a[text()='PBX Manager']")).click();
		System.out.println("User able to click PXB Manager");
		Thread.sleep(1000);
	    
	}

	@Then("User verify the PBXMager data in PBXMagerList")
	public void user_verify_the_PBXMager_data_in_PBXMagerList() throws InterruptedException {
	    
		Thread.sleep(1000);
	   List<WebElement>Data= driver.findElements(By.xpath("//select[@id='bas_searchfield'][1]/option"));
	   
	   String[]str= {"Call From","Call To"};
	   
	   for(WebElement wb:Data) {
		   
		   for(int i=0;i<str.length;i++) {
			   
			   if(wb.equals(str[i])) {
				   
				   System.out.println("Title Matched");
			   }
		   }
		   
		   System.out.println("Title Vewrifyed");
	   }
	   
	   
	   
		
	}
}
