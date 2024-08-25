package stepdefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
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
import org.testng.annotations.Test;
import Generic_Method.Utility_Method;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Sales_TestScript extends Utility_Method{
	
	public static WebDriver driver;
	public static Properties file;
	public static Properties Locators_file;
	//public SalesProcess_PageObject salesobj=new SalesProcess_PageObject();
	//SalesProcess_PageObject salesobj=new SalesProcess_PageObject();
	

	@Given("I navigate to application open URl")
	public void i_navigate_to_application_open_URl() throws InterruptedException, IOException {
	    
		FileInputStream fis=new FileInputStream("Config.properties");
		file=new Properties();
		file.load(fis);
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_114.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(file.getProperty("Url"));
		System.out.println("Browser launch");
		
	}

	@When("User Enter Username and Password By click on Login button")
	public void user_Enter_Username_and_Password_By_click_on_Login_button() throws InterruptedException, IOException {
	    
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(file.getProperty("username"));
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(file.getProperty("password"));
		Thread.sleep(1000);
		File Folder=new File("Screenshots");
		if(Folder.exists()&& Folder.isDirectory()) {
			
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("./Screenshots/Login.png"));
		}
		
		System.out.println("Taking ScreenShot");
		
		driver.findElement(By.xpath(file.getProperty("Login"))).click();
		System.out.println("Login Page Verify");
		
		Thread.sleep(2000);
	}
	

	@Then("Login sucessfullY")
	public void login_sucessfullY() throws InterruptedException {
		 Thread.sleep(2000);
		   
		   System.out.println("Login Sucessfully");
	}

	@Then("User is in VtigerCRM home page")
	public void user_is_in_VtigerCRM_home_page() throws InterruptedException {
		
		Thread.sleep(2000);
		String ActualValue=driver.getTitle();
		String ExceptedValue="admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";
		
		Assert.assertEquals(ExceptedValue, ActualValue);
		System.out.println("Home Page Verify");
		
		//if(ActualValue.equalsIgnoreCase(ActualValue)) {
			
			//System.out.println("Home Page Title Verify");
		//}
		
		//else {
			
			//System.out.println("Home Page Tile is not Verify");
		//}
		
	}
	
	
	@Then("User has click on Sales tab")
	public void user_has_click_on_Sales_tab() throws InterruptedException {
		
		Thread.sleep(2000);
		WebElement MouseHover=driver.findElement(By.xpath("//a[text()='Sales']"));
		//Actions act=new Actions(driver);
		//act.moveToElement(MouseHover).build().perform();
		//System.out.println("MouseHover Done");
		Utility_Method.Hover(driver, MouseHover);
		Thread.sleep(2000);
	    	
	}
	
	@Then("User has click on Leads tab")
	public void user_has_click_on_Leads_tab() throws InterruptedException {
		
		Thread.sleep(2000);
		WebElement Leads_clk=driver.findElement(By.linkText("Leads"));
		Utility_Method.highLightElement(driver, Leads_clk);
		Thread.sleep(2000);
		Leads_clk.click();
		Thread.sleep(2000);
		Utility_Method.captureScreenShot(driver);
		Thread.sleep(2000);
	}
	
	// Creating Laeds New Campaign
	
	@Then("User verify the Creating Leads in Sales by click on Save button")
	public void user_verify_the_Creating_Leads_in_Sales_by_click_on_Save_button() throws InterruptedException, IOException {
	   
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		Thread.sleep(2000);
		File fold=new File("Screenshots");
		if(fold.exists()&& fold.isDirectory()) {
			
			File srcc=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcc, new File("./Screenshots/Lead_Page.png"));
			System.out.println("Screenshot Taking");
		}
		
		else {
			
			System.out.println("Screenshot not taking");
		}
		
		
	}
	
	@Then("User verify the checked AllCheck List in Sales page")
	public void user_verify_the_checked_AllCheck_List_in_Sales_page() throws InterruptedException {
		
		
		Thread.sleep(3000);
		WebElement Sales=driver.findElement(By.xpath("//a[text()='Sales']"));
		Sales.click();
		Thread.sleep(3000);
		List<WebElement>AllcheckList=driver.findElements(By.xpath("//input[@name='selected_id']"));
		
		int sixe=AllcheckList.size();
		System.out.println(sixe);
		for(int i=0;i<AllcheckList.size();i++) {
			
			AllcheckList.get(i).click();
		}
	   System.out.println("All Check box Checked");
	   Utility_Method.captureScreenShot(driver);
	   Thread.sleep(3000);
	}
	
	
	@Then("User verify and Select checklist in Sales page")
	public void user_verify_and_Select_checklist_in_Sales_page() throws InterruptedException {
		
		Thread.sleep(3000);
		WebElement Sales=driver.findElement(By.xpath("//a[text()='Sales']"));
		Sales.click();
		Thread.sleep(3000);
		Thread.sleep(3000);
		WebElement checklist=driver.findElement(By.xpath("//input[@id='3']"));
		checklist.click();
		Thread.sleep(3000);
		////////////Java Script
		
		//WebElement checkBtn=driver.findElement(By.xpath("//table[@class='small']/tbody/tr//input[1][@value='Delete']"));
		//JavascriptExecutor executor1 = (JavascriptExecutor)driver;
    	//executor1.executeScript("arguments[0].click();", checkBtn);
		System.out.println("check box deleted");
		Utility_Method.captureScreenShot(driver);
		Thread.sleep(2000);	
		
	}
	///Verify Alerts Pop Message
	
	@Then("User verify Alert pop up deleting checklist in Sales page")
	public void user_verify_Alert_pop_up_deleting_checklist_in_Sales_page() throws InterruptedException {
	   
		Thread.sleep(3000);
		WebElement Sales=driver.findElement(By.xpath("//a[text()='Sales']"));
	    Sales.click();
		Thread.sleep(3000);
		//Thread.sleep(3000);
		WebElement checklist1=driver.findElement(By.xpath("//input[@id='4']"));
		checklist1.click();
		Thread.sleep(3000);
		WebElement checkBtn=driver.findElement(By.xpath("//table[@class='small']/tbody/tr//input[1][@value='Delete']"));
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", checkBtn);
		System.out.println("check box deleted");
		Thread.sleep(2000);
		Alert alertsprompt=driver.switchTo().alert();
		String Alertmesage=driver.switchTo().alert().getText();
		System.out.println(Alertmesage);
		Thread.sleep(5000);
		alertsprompt.accept();
		//alert.dismiss();
		System.out.println("dismiss_Alert Verify..");
		Thread.sleep(5000);
		
	
	}
	
	@Then("User has click on Sendmail Tab")
	public void user_has_click_on_Sendmail_Tab() throws InterruptedException {
	    
		Thread.sleep(3000);
		WebElement Sendmail=driver.findElement(By.xpath("//table[@class='small']/tbody/tr/td//input[@value='Send Mail']"));
		Sendmail.click();
		Thread.sleep(5000);
		String mainwindow=driver.getWindowHandle();
		System.out.println(mainwindow);
		Set<String>childwindow=driver.getWindowHandles();
		Iterator<String>itr=childwindow.iterator();
		
		while(itr.hasNext()==true) {
			
			String childlistwindow=itr.next();
			System.out.println(childlistwindow);
			
			String windowTitle=driver.switchTo().window(childlistwindow).getTitle();
			
			if(windowTitle.equalsIgnoreCase("Compose Mail")) {
				
				break;
			}
		}
		
		driver.manage().window().maximize();
		Thread.sleep(3000);
		//driver.switchTo().frame("cke_69_frame");
		//Thread.sleep(3000);
		WebElement SendText=driver.findElement(By.xpath("//table[@class='small mailClient']/tbody/tr[2]/td[2]//input[@name='parent_name']"));
		//SendText.sendKeys("test@abc.com");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value='test@abc.com';", SendText);
		Thread.sleep(3000);
		Utility_Method.captureScreenShot(driver);
		Thread.sleep(3000);
		WebElement Sub=driver.findElement(By.xpath("//input[@name='subject']"));
		Sub.sendKeys("Test");
		Thread.sleep(3000);
		
		WebElement mail_body=driver.findElement(By.xpath("//table[@class='cke_editor']/tbody/tr[2]//td[@id='cke_contents_description']"));
		
		JavascriptExecutor jse1 = (JavascriptExecutor)driver;
		jse1.executeScript("arguments[0].value='Hello Automation Testing';", mail_body);
		Thread.sleep(3000);
	}
	
	// Accounts Tab
	
	@Then("User has click on Accounts tab")
	public void user_has_click_on_Accounts_tab() throws InterruptedException, IOException {
	 
		Thread.sleep(2000);
		//FileInputStream fis1=new FileInputStream("OR.properties");
		//Locators_file=new Properties();
		//Locators_file.load(fis1);
		Utility_Method.readPropertiesFile();
		driver.findElement(By.xpath(fileObject.getProperty("Accounts_Sales"))).click();
		//WebElement Accnts=driver.findElement(By.xpath("//*[@id='Sales_sub']//a[text()='Accounts']"));
		//Accnts.click();
		//Thread.sleep(2000);
		//WebElement oj=salesobj.Accounts_clk;
		
		//oj.click();
		Thread.sleep(2000);
	}
	
	// Creating Accounts in Sales Pages
	
	@Then("User verify the Creating Accounts in Sales by click on Save button")
	public void user_verify_the_Creating_Accounts_in_Sales_by_click_on_Save_button() throws InterruptedException, IOException {
	   
		Thread.sleep(2000);
		WebElement Accunts_Create=driver.findElement(By.xpath("//img[@Title='Create Account...']"));
		Accunts_Create.click();
		Thread.sleep(3000);
		
		File Folder1=new File("Screenshots");
		if(Folder1.exists() && Folder1.isDirectory()) {
			
			File src1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src1, new File("./Screenshots/Accunts.png"));
		}
		
		System.out.println("Accounts Screenshots Completed");
	}
}







