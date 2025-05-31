package stepdefinition;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import PageObject.PriceBooks_Page;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PriceBooks_TestScript {
	
	public WebDriver driver;
	public static Properties files;
	
	PriceBooks_Page pricebook=new PriceBooks_Page(driver);
	
	@Given("User Navigate to Application URLL")
	public void user_Navigate_to_Application_URLL() throws IOException {
		
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
		
		FileUtils.copyFile(src, new File("./Screenshots/price.png"));
		
		System.out.println("Takes Screenshot");
		
		
	    
	}

	@When("User enter {string} and {string} by click on SignIN Button")
	public void user_enter_and_by_click_on_SignIN_Button(String UserName, String Password) throws InterruptedException {
	   
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(UserName);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(Password);
		pricebook.Login(driver);
		
	}

	@Then("User SigIN Sucessfully")
	public void user_SigIN_Sucessfully() {
	   
		System.out.println("Login Sucessfully");
	}

	@Then("User verify the HomePage Title")
	public void user_verify_the_HomePage_Title() {
		
		String ActualTitle=driver.getTitle();
		String ExpTitle="admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";
		
		Assert.assertEquals(ActualTitle, ExpTitle);
		
		System.out.println("Title Matched");
	    
	}

	@Then("User Able to click on Inventory Tab")
	public void user_Able_to_click_on_Inventory_Tab() {
		
		pricebook.Inventoy(driver);
		System.out.println("User able to click Inventoy");
	    
	}

	@Then("User Able to click on priceBook")
	public void user_Able_to_click_on_priceBook() {
		
		pricebook.pricebook(driver);
		System.out.println("User able to click on PriceBook");
	   
	}
	
	@Then("User verify and creating New{string} PriceBook")
	public void user_verify_and_creating_New_PriceBook(String PriceBook) throws InterruptedException {
		
		driver.findElement(By.xpath("//img[@title='Create Price Book...']")).click();
		System.out.println("User able to click on New Price book links");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@name='bookname']")).sendKeys(PriceBook);
		
		driver.findElement(By.xpath("//input[@value='  Save  '][1]")).click();
		
		Thread.sleep(1000);
		
	    
	}
	
	@Then("User verify the PriceList in PriceBook")
	public void user_verify_the_PriceList_in_PriceBook() {
	    
		WebElement ele=driver.findElement(By.xpath("//select[@id='bas_searchfield'][1]"));
		
		Select sel=new Select(ele);
		String[]str= {"PriceBook No","Price Book Name","Active","Currency"};
		
		List<WebElement>AllPrice=sel.getOptions();
		
		for(WebElement wb:AllPrice) {
			
			for(int i=0;i<str.length;i++) {
				
				if(wb.getText().equals(str[i])) {
					
					System.out.println("All List Item Matched");
				}
			}
		}
		
	}


}
