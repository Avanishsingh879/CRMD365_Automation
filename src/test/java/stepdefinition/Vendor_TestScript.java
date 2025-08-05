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

public class Vendor_TestScript {
	
	public static WebDriver driver;
	public static Properties files;
	
	@Given("User open the Appplication")
	public void user_open_the_Appplication() throws IOException {
		
	FileInputStream fis=new FileInputStream("Config.properties");
    files=new Properties();
    files.load(fis);
    System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_138.exe");
    driver=new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get(files.getProperty("Url"));
    System.out.println("Browser Launch");
    
    File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(src, new File("./Screenshots/test.png"));
    
	    
	}

	@When("User login application with UserName{string} and Password {string} by click on Login Button")
	public void user_login_application_with_UserName_and_Password_by_click_on_Login_Button(String Uname, String Pwd) {
		
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(Uname);
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(Pwd);
	driver.findElement(By.xpath("//input[@name='Login']")).click();
		
	    
	}

	@Then("user able to login sucessfully")
	public void user_able_to_login_sucessfully() {
		
		System.out.println("Login Sucessgully");
	    
	}

	@Then("User verify home Page Functinlity")
	public void user_verify_home_Page_Functinlity() {
		
		String ActTitle=driver.getTitle();
		String ExpTitle="admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";
		Assert.assertEquals(ActTitle, ExpTitle);
		System.out.println("Title Verifyed");
	    
	}

	@Then("User Able to click on Vendor Tab")
	public void user_Able_to_click_on_Vendor_Tab() throws InterruptedException {
		
		WebElement Ven=driver.findElement(By.xpath("//a[text()='Inventory']"));
		
		Actions act=new Actions(driver);
		act.moveToElement(Ven).build().perform();
		
		Thread.sleep(1000);
		WebElement VendorLinks=driver.findElement(By.xpath("//div[@id='Inventory_sub']/table/tbody/tr[2]/td/a[text()='Vendors']"));
		String txt=VendorLinks.getText();
		System.out.println(txt);
		VendorLinks.click();
		
		System.out.println("User able to click VendorLinks");
	    
	}
	
	@Then("User able to verify Vendor List in List")
	public void user_able_to_verify_Vendor_List_in_List() {
		
		List<WebElement>AList=driver.findElements(By.xpath("//select[@id='bas_searchfield'][1]/option"));
		
		String[]str= {"Vendor No","Vendor Name"};
		
		for(WebElement wb:AList) {
			
			for(int i=0;i<str.length;i++) {
				
				if(wb.getText().equals(str[i])) {
					
					System.out.println("Title Matched");
				}
			}
			
			System.out.println("Title Verifyed");
		}
		
	}

}















