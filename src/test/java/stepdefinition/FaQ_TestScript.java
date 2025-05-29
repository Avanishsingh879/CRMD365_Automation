package stepdefinition;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Generic_Method.Utility_Method;
import PageObject.Login_Page;
import PageObject.Support_Page;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FaQ_TestScript extends Utility_Method {
	
	
	public static WebDriver driver;
	public static Properties files;
	
	Login_Page login=new Login_Page(driver);
	Support_Page support=new Support_Page(driver);
	
	@Given("User Navigate to Open URl Application")
	public void user_Navigate_to_Open_URl_Application() throws IOException, InterruptedException {
		
		FileInputStream fis=new FileInputStream("Config.properties");
		files=new Properties();
		files.load(fis);
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_137.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(files.getProperty("Url"));
		System.out.println("Browser Launch");
		Thread.sleep(1000);
		
	   
	}

	@When("User Enter {string} and {string} by click on Login Button")
	public void user_Enter_and_by_click_on_Login_Button(String string, String string2) throws IOException {
		
		login.ValidLogin(driver); 
	   
	}

	@Then("User Login SucessfullY")
	public void user_Login_SucessfullY() {
		
		System.out.println("Login Sucessfully");
	   
	}

	@Then("User is In Home page")
	public void user_is_In_Home_page() {
		
		String Title=driver.getTitle();
		String ExpTitle="admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";
		Assert.assertEquals(Title, ExpTitle);
		System.out.println("Title Matched");
		
	   
	}

	@Then("User able to click on Support tab")
	public void user_able_to_click_on_Support_tab() throws InterruptedException {
	   
		Utility_Method.Hover(driver, support.Support(driver));
		Thread.sleep(1000);
		support.Trtickt(driver);
		Thread.sleep(1000);
	}

	@Then("User able to click on Contacts tab")
	public void user_able_to_click_on_Contacts_tab() throws InterruptedException {
		
		support.Contact(driver);
		Thread.sleep(1000);
	   
	}

	@Then("User able to click FaQ Tab")
	public void user_able_to_click_FaQ_Tab() throws InterruptedException {
		
		support.Faq(driver);
		Thread.sleep(1000);
	   
	}

	@Then("User able to verify List in FAQ List")
	public void user_able_to_verify_List_in_FAQ_List() {
	    
		WebElement sele=driver.findElement(By.xpath("//select[@id='bas_searchfield'][1]"));
		Select sel=new Select(sele);
		
		String[]str= {"Faq No","Question"};
		List<WebElement>AllList=sel.getOptions();
		
		for(WebElement wb:AllList) {
			
			for(int i=0;i<str.length;i++) {
				
				if(wb.getText().equals(str[i])) {
					
					System.out.println("List Item Matched");
				}
			}
		}
		
		
	}

}
