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

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Potentials_TestScript {

	
	
    public static WebDriver driver;
    public static  Properties files;
	 
	@Given("User Launch and Open Url")
	public void user_Launch_and_Open_Url() throws IOException {
		
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

	@When("User login with UserName{string} and Passord{string} click on SignIn Button")
	public void user_login_with_UserName_and_Passord_click_on_SignIn_Button(String Uname, String pwd) throws InterruptedException, IOException {
		
		Thread.sleep(1000);;
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(Uname);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(pwd);
		WebElement login_Btn=driver.findElement(By.xpath("//input[@name='Login']"));
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",login_Btn);
		
		Thread.sleep(1000);
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("./Screenshots/NewTest.png"));
		
	    
	}

	@Then("User able to login Sucessfully")
	public void user_able_to_login_Sucessfully() {
		
		System.out.println("User Login Sucessfuly");
	   
	}

	@Then("User verify Vitger Home Page")
	public void user_verify_Vitger_Home_Page() {
		
		String ActualTitle=driver.getTitle();
		String ExpTitle="admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";
		Assert.assertEquals(ActualTitle, ExpTitle);
		System.out.println("Title Matched");
	    
	}

	@Then("User verify Pop message in Potentials page")
	public void user_verify_Pop_message_in_Potentials_page() throws InterruptedException {
		
		WebElement MouseHover=driver.findElement(By.xpath("//a[text()='Sales']"));
		
		Actions act=new Actions(driver);
		act.moveToElement(MouseHover).build().perform();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='Sales_sub']/table/tbody/tr[4]/td//a[text()='Potentials']")).click();
		
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr/td[@class='lvtCol']//input[@type='checkbox']")).click();
		
		driver.findElement(By.xpath("//input[@value='Delete'][1]")).click();
		
		System.out.println("User able to click");
		
		//////////Alert Handle//////////////
		
		Alert alt=driver.switchTo().alert();
		String txt=alt.getText();
		System.out.println(txt);
		
		alt.accept();
		
		System.out.println("User verify the Alert Pop-up Message");
		
	    
	}
}
























