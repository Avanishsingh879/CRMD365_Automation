package stepdefinition;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import PageObject.Quotes_Page;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Quotes_TestScript {
	
	public WebDriver driver;
	Quotes_Page Quotes=new Quotes_Page(driver);
	
	@Given("User verify and Open Application")
	public void user_verify_and_Open_Application() throws InterruptedException {
	  
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_137.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		System.out.println("Browser Launch");
		Thread.sleep(1000);
	}

	@When("User enter Uname and pssword by click on SignIn Button")
	public void user_enter_Uname_and_pssword_by_click_on_SignIn_Button() throws IOException, InterruptedException {
	    
		Quotes.ValidLogin(driver);
	}

	@Then("User Login Page")
	public void user_Login_Page() {
		
		System.out.println("Login Sucessfullly");
	    
	}

	@Then("User verify Home page functionlity")
	public void user_verify_Home_page_functionlity() {
		
		String ActualTitle=driver.getTitle();
		String ExpTitle="admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";
		Assert.assertEquals(ActualTitle, ExpTitle);
		System.out.println("Title Matched");
	   
	}

	@Then("User verify and New Create Quotes Page")
	public void user_verify_and_New_Create_Quotes_Page() throws InterruptedException, IOException {
	    
		Quotes.VerifyQuotes(driver);
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshots/testnew.png"));
	}
	
	@Then("User verify the QuotesList in Quotes Page")
	public void user_verify_the_QuotesList_in_Quotes_Page() {
	   
		WebElement selectBtn=driver.findElement(By.xpath("//select[@id='bas_searchfield'][1]"));
		
		Select sel=new Select(selectBtn);
		
		String[]str= {"Quote No","Subject"};
		
		List<WebElement>Optionss=sel.getOptions();
		
		for(WebElement wb:Optionss) {
			
			for(int i=0;i<str.length;i++) {
				
				if(wb.getText().equals(str[i])) {
					
					System.out.println("List Data Matched");
				}
			}
		}
	}
}




















