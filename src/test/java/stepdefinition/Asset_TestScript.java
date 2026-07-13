package stepdefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.annotation.concurrent.ThreadSafe;

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

public class Asset_TestScript {
	
	
    public static WebDriver driver;
    public static Properties files;
	@Given("User open and Navigate Application Url")
	public void user_open_and_Navigate_Application_Url() throws IOException {
		
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
		FileUtils.copyFile(src, new File("./Screenshots/Test.png"));
		System.out.println("ScreenShot Taken");///
	    
	}

	@When("User enter UserName{string} and Password{string} by click on SignIn Page")
	public void user_enter_UserName_and_Password_by_click_on_SignIn_Page(String Uname, String Pwd) throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(Uname);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(Pwd);
	    WebElement login=driver.findElement(By.xpath("//input[@name='Login']"));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",login);
		Thread.sleep(1000);
	  
	}

	@Then("User Verify Page Title")
	public void user_Verify_Page_Title() {
		
		String ActualTitle=driver.getTitle();
		String ExpTitle="admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";
		Assert.assertEquals(ActualTitle, ExpTitle);
		System.out.println("Tilte Matched");
		
	    
	}

	@Then("User verify and Create Asstes")
	public void user_verify_and_Create_Asstes() throws InterruptedException {
		
		WebElement MouseHover=driver.findElement(By.xpath("//a[text()='Inventory']"));
		
		Actions act=new Actions(driver);
		act.moveToElement(MouseHover).build().perform();
		
		WebElement assBtn=driver.findElement(By.xpath("//div[@id='Inventory_sub']/table/tbody/tr[9]/td//a[text()='Assets']"));
		assBtn.click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//img[@alt='Create Asset...']")).click();
		
		System.out.println("User able to click on Create Asstes Tab");
	    
	}
	
	@Then("User verify All Asstes in AsstesList Page")
	public void user_verify_All_Asstes_in_AsstesList_Page() throws InterruptedException {
		
WebElement MouseHover=driver.findElement(By.xpath("//a[text()='Inventory']"));
		
		Actions act=new Actions(driver);
		act.moveToElement(MouseHover).build().perform();
		
		WebElement assBtn=driver.findElement(By.xpath("//div[@id='Inventory_sub']/table/tbody/tr[9]/td//a[text()='Assets']"));
		assBtn.click();
		Thread.sleep(1000);
	    
		Thread.sleep(1000);
		WebElement searchBtn=driver.findElement(By.xpath("//select[@id='bas_searchfield'][1]"));
		
		Select sel=new Select(searchBtn);
		String[]str= {"Asset No","Asset Name","Customer Name","Product Name"};
		
		List<WebElement>AllList=sel.getOptions();
		
		for(WebElement wb:AllList) {
			
			for(int i=0;i<str.length;i++) {
				
				if(wb.getText().equals(str[i])) {
					
					System.out.println("Title Matched");
				}
			}
		}
		System.out.println("Test case Verifyed");
		
		
	}

}











