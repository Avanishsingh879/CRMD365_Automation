package stepdefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Invoice_TestScript {
	
	
	public static WebDriver driver;
    public static Properties files;
	
	@Given("User Open the Application")
	public void user_Open_the_Application() throws IOException {
		
		FileInputStream fis=new FileInputStream("Config.properties");
		files=new Properties();
		files.load(fis);
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_137.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(files.getProperty("Url"));
		System.out.println("Browser Launch");
	}

	@When("User login with Username and Password by click on Login Button")
	public void user_login_with_Username_and_Password_by_click_on_Login_Button() throws InterruptedException, IOException {
		
		WebElement Uname=driver.findElement(By.xpath("//input[@name='user_name']"));
		WebElement pass=driver.findElement(By.xpath("//input[@name='user_password']"));
		WebElement login=driver.findElement(By.xpath("//input[@name='Login']"));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='admin'",Uname);
		js.executeScript("arguments[0].value='admin'",pass);
		js.executeScript("arguments[0].click()",login);
		
		////////////////////////////////////////////////////////////////
		Thread.sleep(1000);
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshots.test123.png"));
		//////////////////////////////////////////////////////////////////
	 
		
	}

	@Then("User verify Home Page")
	public void user_verify_Home_Page() throws InterruptedException {
		
		Thread.sleep(1000);
		String actTtile=driver.getTitle();
		String expTitle="admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";
		
		Assert.assertEquals(actTtile, expTitle);
		System.out.println("Title Matched");
		
	    
	}

	@Then("User Verify the Sales Page")
	public void user_Verify_the_Sales_Page() {
		
		WebElement mouseHover=driver.findElement(By.xpath("//a[text()='Sales']"));
		Actions act=new Actions(driver);
		act.moveToElement(mouseHover).build().perform();
		System.out.println("User able to Mouse Hover");
		
	    
	}

	@Then("User verify the Invoice Page")
	public void user_verify_the_Invoice_Page() throws InterruptedException {
	    
		WebElement ele=driver.findElement(By.xpath("//div[@id='Sales_sub']/table/tbody/tr[7]/td//a[text()='Invoice']"));
		ele.click();
		Thread.sleep(1000);
		
	}
	
	@Then("User verify the List of Invoice in Invoice Page")
	public void user_verify_the_List_of_Invoice_in_Invoice_Page() throws InterruptedException {
	   
		Thread.sleep(1000);
		WebElement selData=driver.findElement(By.xpath("//select[@id='bas_searchfield'][1]"));
		Select sel=new Select(selData);
		
		String[]str= {"Invoice No","Subject"};
		List<WebElement>allList=sel.getOptions();
		
		for(WebElement wb:allList) {
			
			for(int i=0;i<str.length;i++) {
				
				if(wb.getText().equals(str[i])) {
					
					System.out.println("Title Matched");
					Thread.sleep(1000);
				}
			}
		}
		
		
		
		
	}

}
