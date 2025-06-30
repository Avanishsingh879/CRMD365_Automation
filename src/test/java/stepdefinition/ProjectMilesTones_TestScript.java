package stepdefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProjectMilesTones_TestScript {
	
	public static WebDriver driver;
	public static Properties files;
	
	@Given("User open and Navigate the Application Url")
	public void user_open_and_Navigate_the_Application_Url() throws IOException {
	
		FileInputStream fis=new FileInputStream("Config.properties");
		files=new Properties();
		files.load(fis);
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_137.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(files.getProperty("Url"));
		
		System.out.println("Browser Launch");
		
	    
	}

	@When("User login with usernme{string} and password{string} by click on Login Page")
	public void user_login_with_usernme_and_password_by_click_on_Login_Page(String Username, String Pwd) {
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(Username);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(Pwd);
		driver.findElement(By.xpath("//input[@name='Login']")).click();
	   
	}

	@Then("User able to Login sucesfully")
	public void user_able_to_Login_sucesfully() {
		
		System.out.println("Login Sucessfully");
	    
	}

	@Then("User able to verify the Home page deatils")
	public void user_able_to_verify_the_Home_page_deatils() {
	    
		String ActTitle=driver.getTitle();
		String ExpTitle="admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";
		Assert.assertEquals(ActTitle, ExpTitle);
		System.out.println("Title Matched");
	}

	@Then("User able to click on PrpjectMilesTones Tab")
	public void user_able_to_click_on_PrpjectMilesTones_Tab() throws InterruptedException {
		
		WebElement MouseHover=driver.findElement(By.xpath("//a[text()='Support']"));
		Actions act=new Actions(driver);
		act.moveToElement(MouseHover).build().perform();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='Support_sub']/table/tbody/tr[9]/td//a[text()='Project Milestones']")).click();
		Thread.sleep(1000);
		
	    
	}
	

    @Then("User verify the List of projectMilesTone in List")
    public void user_verify_the_List_of_projectMilesTone_in_List() {
    
    	WebElement seletData=driver.findElement(By.xpath("//select[@id='bas_searchfield'][1]"));
    	Select sel=new Select(seletData);
    	
    	String[]str= {"Milestone Name","Milestone Date"};
    	
    	List<WebElement>ListData=sel.getOptions();
    	
    	for(WebElement wb:ListData) {
    		
    		for(int i=0;i<str.length;i++) {
    			
    			if(wb.getText().equals(str[i])) {
    				
    				System.out.println("Title Matched");
    			}
    		}
    		
    		
    	}
    	System.out.println("Title Verifyed");
}

}








