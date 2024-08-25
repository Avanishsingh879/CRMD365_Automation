package stepdefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Inventory_TestScript {
	
	public static WebDriver driver;
	public static Properties file;
	
	
	@Given("I navigate to application open UrL")
	public void i_navigate_to_application_open_UrL() throws IOException {
		
		FileInputStream fis=new FileInputStream("Config.properties");
		file=new Properties();
		file.load(fis);
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_119.exe");
		driver=new ChromeDriver();
		driver.get(file.getProperty("Url"));
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		System.out.println("Browser Launch");
	    
	}

	@When("user Enter Username and Password by click on login Button")
	public void user_Enter_Username_and_Password_by_click_on_login_Button() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(file.getProperty("username"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(file.getProperty("password"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='Login']")).click();
		System.out.println("Login Sucessfully");
		Thread.sleep(1000);
		
		
	    
	}

	@Then("login sucessfully")
	public void login_sucessfully() {
		
		System.out.println("Login Successfully");
		
	    
	}

	@Then("user is in VtigerCRM Home page")
	public void user_is_in_VtigerCRM_Home_page() throws InterruptedException {
		
		Thread.sleep(1000);
		String actualTitle=driver.getTitle();
		String expTitle="admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";
		
		Assert.assertEquals(actualTitle, expTitle);
		System.out.println("Title Matched");
		
		
	    
	}

	@Then("User has click on Inventory tab")
	public void user_has_click_on_Inventory_tab() throws InterruptedException {
		
		Thread.sleep(1000);
		WebElement linksBtn=driver.findElement(By.xpath("//a[text()='Inventory']"));
		linksBtn.click();
		System.out.println("Inverntoy Links clickable");
		Thread.sleep(1000);
		
	    
	}
	
	@Then("User verify the Creating Products{string} in Inventory by click on Save button")
	public void user_verify_the_Creating_Products_in_Inventory_by_click_on_Save_button(String ProductName) throws InterruptedException {
		
		Thread.sleep(1000);
		WebElement crepro=driver.findElement(By.xpath("//img[@title='Create Products...']"));
		crepro.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(ProductName);
		Thread.sleep(1000);
		List<WebElement>alllist=driver.findElements(By.xpath("//*[@class='dvtContentSpace']//input[@value='  Save  ']"));
		
		int size=alllist.size();
		for(int i=0;i<alllist.size()-1;i++) {
			
			WebElement list=alllist.get(1);
			list.click();
			break;
			
			
		}
	}
		@Then("User has verify on Inventory tab")
		public void user_has_verify_on_Inventory_tab() throws InterruptedException {
			
			Thread.sleep(1000);
			WebElement gettxt=driver.findElement(By.xpath("//a[text()='Inventory']"));
			String invttext=gettxt.getText();
			System.out.println(invttext);
			System.out.println("User has verify Inventory screen");
		    
		}

		@Then("User has click on Invoice tab")
		public void user_has_click_on_Invoice_tab() throws InterruptedException {
			
			Thread.sleep(1000);
			WebElement MouseHover=driver.findElement(By.xpath("//a[text()='Inventory']"));
			Actions act=new Actions(driver);
			act.moveToElement(MouseHover).build().perform();
			WebElement invoiceBtn=driver.findElement(By.xpath("//div[@id='Inventory_sub']//a[text()='Invoice']"));
			
			if(invoiceBtn.isEnabled()) {
				
				invoiceBtn.click();
			}
			
			System.out.println("User has click Invoice Tab");
			
		    
		}

		@Then("User verify the Creating New Invoice {string},{string} in Inventory by click on Save button")
		public void user_verify_the_Creating_New_Invoice_in_Inventory_by_click_on_Save_button(String Subject, String AccountName) throws InterruptedException {
			
			Thread.sleep(2000);
			WebElement createinvoiceBtn=driver.findElement(By.xpath("//img[@title='Create Invoice...']"));
			createinvoiceBtn.click();
			Thread.sleep(1000);
			WebElement subtext=driver.findElement(By.xpath("//input[@name='subject']"));
			subtext.sendKeys(Subject);
			System.out.println("User has enter Subject Text field");
			driver.findElement(By.xpath("//input[@id='single_accountid']/following-sibling::img")).click();
			Thread.sleep(3000);
			//////////////////////////////////////window Handling///////////
			
			String mainwindow=driver.getWindowHandle();
			System.out.println(mainwindow);
			Set <String> handles =driver.getWindowHandles();
			Iterator<String> it = handles.iterator();
			//iterate through your windows
			while (it.hasNext()){
			String parent = it.next();
			String newwin = it.next();
			driver.switchTo().window(newwin);
			Thread.sleep(2000);
			driver.manage().window().maximize();
			WebElement srchtxt=driver.findElement(By.xpath("//input[@id='search_txt']"));
			srchtxt.sendKeys(AccountName);
			/////////////////////////////////////////
			WebElement IBMbtn=driver.findElement(By.xpath("//a[text()='Genpact']"));
			IBMbtn.click();
			Thread.sleep(2000);
			Alert alertmsg=driver.switchTo().alert();
			String txt=alertmsg.getText();
			System.out.println(txt);
			alertmsg.accept();
			System.out.println("Pop-up Message OK");
			Thread.sleep(2000);
			
		   
		}
		
		
		}	
	   
	}
	
	
	


