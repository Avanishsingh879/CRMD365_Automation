package stepdefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Project_TestScript {
	
	
	public static WebDriver driver;
	public static Properties files;
	
	@Given("User Navigate to Application Url")
	public void user_Navigate_to_Application_Url() throws IOException, InterruptedException {
		
		FileInputStream fis=new FileInputStream("Config.properties");
		files=new Properties();
		files.load(fis);
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_136.exe");
		driver=new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    driver.get(files.getProperty("Url"));
	    System.out.println("Browser Launch");
	    File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshots/project.png"));
		Thread.sleep(1000);
	    
	}

	@When("User enter Username and Password by click on SignButton")
	public void user_enter_Username_and_Password_by_click_on_SignButton() throws InterruptedException {
		
		WebElement User_Name=driver.findElement(By.xpath("//input[@name='user_name']"));
		WebElement User_Password=driver.findElement(By.xpath("//input[@name='user_password']"));
		WebElement Login=driver.findElement(By.xpath("//input[@name='Login']"));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='admin'",User_Name);
		js.executeScript("arguments[0].value='admin'", User_Password);
		js.executeScript("arguments[0].click()", Login);
		
		Thread.sleep(2000);
	    
	}

	@Then("User is in Home Page")
	public void user_is_in_Home_Page() {
		
		String Actual=driver.getTitle();
		String ExpTitle="admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";
		
		Assert.assertEquals(ExpTitle, Actual);
		System.out.println("Title Matched");
		
	   	}

	@Then("User Has click on Support Tab")
	public void user_Has_click_on_Support_Tab() {
		
		WebElement MouseHover=driver.findElement(By.xpath("//a[text()='Support']"));
		Actions act=new Actions(driver);
		act.moveToElement(MouseHover).build().perform();
		System.out.println("Mouse Hover");
		
	    	}
	

	@Then("User Has click on Trouble Ticktes in Support Page")
	public void user_Has_click_on_Trouble_Ticktes_in_Support_Page() {
		
		WebElement trouble=driver.findElement(By.xpath("//div[@id='Support_sub']/table/tbody/tr/td//a[text()='Trouble Tickets']"));
		trouble.click();
		
		WebDriverWait wait=new WebDriverWait(driver,10);
		WebElement eleBtn=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='HelpDesk']")));
		boolean Status=eleBtn.isDisplayed();
		
		if(Status) {
			System.out.println("Element is visible");
		}
		else {
			
			System.out.println("Element is not Visible");
		}
	}

	@Then("User Has click on Project Tab")
	public void user_Has_click_on_Project_Tab() throws InterruptedException {
		
		driver.findElement(By.xpath("//td[@class='level2UnSelTab']//following-sibling::a[text()='Projects']")).click();
		Thread.sleep(1000);
	    
	}
	
	@Then("User Verify the ListData in Project dropdownList")
	public void user_Verify_the_ListData_in_Project_dropdownList() throws InterruptedException {
		
		Thread.sleep(1000);
		WebElement selectdata=driver.findElement(By.xpath("//select[@id='bas_searchfield'][1]"));
		String[]strr= {"Project Name","Related To","Start Date","Target End Date","Actual End Date","Target budget","Progress","Status","Assigned To"};
		Select sel=new Select(selectdata);
		
		
		List<WebElement>option=sel.getOptions();
		
		for(WebElement wb:option) {
			
			for(int i=0;i<strr.length;i++) {
				
				if(wb.getText().equals(strr[i])) {
					
					System.out.println("List Verifed");
				}
				Thread.sleep(1000);
				System.out.println("Project Sucrssfilly");
			}
		}
		
		
	    
	}

}
