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

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

 
   
public class Quick_Create_TestScript {
	
	
	public static WebDriver driver;
	public static Properties files;
	
	@Given("I navigate to APPlication OPen UrL")
	public void i_navigate_to_APPlication_OPen_UrL() throws IOException, InterruptedException {
		
	   FileInputStream fis=new FileInputStream("Config.properties"); 
	   files=new Properties();
	   files.load(fis);
	   System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_123.exe");
	   driver=new ChromeDriver();
	   driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	   driver.manage().window().maximize();
	   driver.get(files.getProperty("Url"));
	   Thread.sleep(1000);
	   System.out.println("Browser Launch");
	    
		
	    
	}

	@When("user Enter UsernamE and PassworD by clicK On login Button")
	public void user_Enter_UsernamE_and_PassworD_by_clicK_On_login_Button() throws InterruptedException, IOException {
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(files.getProperty("username"));
		Thread.sleep(1000);
		WebElement pwd=driver.findElement(By.xpath("//input[@name='user_password']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='admin'",pwd);
		WebElement wlogin=driver.findElement(By.xpath("//input[@name='Login']"));
		 //js.executeScript("arguments[0].value='admin'", Password_Text);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click()", wlogin);
		Thread.sleep(2000);
        File srcc=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcc, new File("./Screenshots/QuickTest.png"));
        Thread.sleep(2000);
	}

	@Then("Login SUCessfully")
	public void login_SUCessfully() throws InterruptedException {
		
		Thread.sleep(1000);
		String ActualTitle=driver.getTitle();
		String ExceptedTitle="admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";
		Assert.assertEquals(ActualTitle, ExceptedTitle);
		System.out.println("Title Matched");
	   
	}

	@Then("user is in VtigerCRM HOME page")
	public void user_is_in_VtigerCRM_HOME_page() throws InterruptedException {
		
		Thread.sleep(1000);
		//List<WebElement> HomePG_Hover=driver.findElements(By.xpath("//table[@class='hdrTabBg']//td//a"));
		
		//List<WebElement> Sub_Hover=HomePG_Hover.findElements(By.tagName("a"));
		//for(int i=0;i<HomePG_Hover.size();i++) {
		//HomePG_Hover.get(i).click();
		//String txt=ele.getText();
		//ele.click();
		Thread.sleep(2000);
		//System.out.println(txt);
		//Actions action =new Actions(driver);
        //action.moveToElement(ele).build().perform();
        //Thread.sleep(5000);
        //action.click(ele).build().perform();
		//}
	}
	

	@Then("user has click on Quickcreate Page")
	public void user_has_click_on_Quickcreate_Page() throws InterruptedException {
		
		Thread.sleep(2000);
		WebElement dropDownList=driver.findElement(By.xpath("//select[@id='qccombo']"));
		dropDownList.click();
		WebElement selectList=driver.findElement(By.xpath("//select[@id='qccombo']"));
		Select sel=new Select(selectList);
		List <WebElement> op = sel.getOptions();
		int size = op.size();
	      for(int i =0; i<size ; i++){
	         op.get(i).click();
	         Thread.sleep(4000);
	         //System.out.println(options);	
	}
}
	
	@Then("user verify the Quickcreate List in Quickcreate Page")
	public void user_verify_the_Quickcreate_List_in_Quickcreate_Page() throws InterruptedException {
		WebElement dropDownList=driver.findElement(By.xpath("//select[@id='qccombo']"));
		dropDownList.click();
		Thread.sleep(2000);
		String[]str= {"Quick Create...","New Account","New Asset","New To Do","New Campaign","New Comment","New Contact"};
		Select sel=new Select(dropDownList);
		List<WebElement>options=sel.getOptions();
		
		//int size=options.size();
		for(WebElement we:options) {
			
			for(int i=0;i<str.length;i++) {
				
				if(we.getText().equals(str[i])) {
					
					System.out.println("Matched");
					Thread.sleep(2000);
				}
			}
		}
		
		
		
	}
}








