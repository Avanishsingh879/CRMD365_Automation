package stepdefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Tools_TestScript{
	///
	public static WebDriver driver;
	public static Properties files;
	
	@Given("I navigate to application Open URl")
	public void i_navigate_to_application_Open_URl() throws IOException, InterruptedException {
		
		FileInputStream fis=new FileInputStream("Config.properties");
		files=new Properties();
		files.load(fis);
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_119.exe");
		driver=new ChromeDriver();
		driver.get(files.getProperty("Url"));
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		System.out.println("Browser Launch");
		Thread.sleep(2000);
		
		//File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(src, new File("./Screenshots/test.png"));
		
		
	}

	@When("User Enter Username and Password by click On login Button")
	public void user_Enter_Username_and_Password_by_click_On_login_Button() throws InterruptedException, IOException {
		
		Thread.sleep(2000);
		WebElement Login_Btn=driver.findElement(By.xpath("//input[@name='Login']"));
	    driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(files.getProperty("username"));
	    Thread.sleep(2000);
	    WebElement PassText=driver.findElement(By.xpath("//input[@name='user_password']"));
	    //////////JavaScriptExcutor/////////////////////////////////
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("arguments[0].value='admin';",PassText);
	    Thread.sleep(2000);
	    js.executeScript("arguments[0].click();",Login_Btn);
	    Thread.sleep(2000);
	    System.out.println("Login Sucrssfully");
	    //////////TakeScreenshot//////////////////////////
	    //File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    //FileUtils.copyFile(src, new File("./Screenshots/Test.png"));
	    
		
	}

	@Then("Login SucessfullY")
	public void login_SucessfullY() throws InterruptedException {
		
		System.out.println("Login Sucessfully");
		Thread.sleep(2000);
	    
		
	}

	@Then("User is in vtigerCRM Home page")
	public void user_is_in_vtigerCRM_Home_page() throws InterruptedException {
		
		String actualTitle=driver.getTitle();
		String ExpectedTitle="admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";
		Assert.assertEquals(actualTitle, ExpectedTitle);
		System.out.println("Home Page Title Matched");
	   
		
	}

	@Then("User has click on Tools tab")
	public void user_has_click_on_Tools_tab() throws InterruptedException {
		
	    Thread.sleep(2000);
	    WebElement ToolsLink=driver.findElement(By.linkText("Tools"));
	    //ToolsLink.click();
	    System.out.println("User Verify Tools Link");
		
	}
	
	@Then("User verify the OurSites in Tools Page")
	public void user_verify_the_OurSites_in_Tools_Page() throws InterruptedException, IOException {
	 
		Thread.sleep(2000);
		WebElement ToolsLink=driver.findElement(By.linkText("Tools"));
		Actions act=new Actions(driver);
		act.moveToElement(ToolsLink).build().perform();
		Thread.sleep(3000);
		WebElement OurSitesLinks=driver.findElement(By.xpath("//div[@id='Tools_sub']/table/tbody/tr[2]//a"));
		OurSitesLinks.click();
		Thread.sleep(2000);
		File srcc=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcc, new File("./Screenshots/OurSites.png"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Manage Sites']")).click();
		Thread.sleep(2000);
		WebElement BookMarkLinks=driver.findElement(By.xpath("//input[@name='bookmark']"));
		//JavascriptExecutor js1=(JavascriptExecutor)driver;
		JavascriptExecutor js1=(JavascriptExecutor)driver;
	    js1.executeScript("arguments[0].click();",BookMarkLinks);
	    Thread.sleep(1000);
	    WebElement portUrlText=driver.findElement(By.xpath("//input[@name='portalurl']"));
	    js1.executeScript("arguments[0].value='www.flipcart.com';",portUrlText);
	    Thread.sleep(2000);
	    WebElement Portname=driver.findElement(By.xpath("//input[@name='portalname']"));
	    js1.executeScript("arguments[0].value='Testting';",Portname);
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//input[@name='save']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//table[@class='listTable bgwhite']/tbody/tr[4]/td[3]//a[text()='Delete']")).click();
	    Thread.sleep(4000);
	    //////Alerts/////////////////
	    Alert alt=driver.switchTo().alert();
	    String txtMesage=alt.getText();
	    System.out.println(txtMesage);
	    alt.dismiss();
	    System.out.println("Pop-up Message Dismiss");	
	}
	
	@Then("User verify the Documents in Tools Page")
	public void user_verify_the_Documents_in_Tools_Page() throws InterruptedException, IOException {
		
		Thread.sleep(2000);
		WebElement ToolsHover=driver.findElement(By.xpath("//a[text()='Tools']"));
		Actions act=new Actions(driver);
		act.moveToElement(ToolsHover).build().perform();
		WebElement Docs=driver.findElement(By.xpath("//div[@id='Tools_sub']/table/tbody/tr[3]//a"));
		Docs.click();
		Thread.sleep(2000);
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshots/docs.png"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@title='Create Document...']")).click();
		Thread.sleep(2000);
		WebElement notesTitle=driver.findElement(By.xpath("//input[@name='notes_title']"));
		JavascriptExecutor jsscript=(JavascriptExecutor)driver;
		jsscript.executeScript("arguments[0].value='TestDocs';", notesTitle);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='basicTab']//tbody/tr[2]/td/table/tbody/tr[1]/td/div/input[1]")).click();
		Thread.sleep(2000);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	    
	}

}
