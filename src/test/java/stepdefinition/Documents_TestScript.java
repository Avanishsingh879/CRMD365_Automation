package stepdefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Documents_TestScript {
	
	////////////////////////////////////////////
	public static WebDriver driver;
	public static Properties files;
	
	@Given("User Navigate To Application URL")
	public void user_Navigate_To_Application_URL() throws IOException, InterruptedException {
	    
		FileInputStream fis=new FileInputStream("Config.properties");
		files=new Properties();
		files.load(fis);
	    System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_135.exe");
	    driver=new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    driver.get(files.getProperty("Url"));
	    Thread.sleep(1000);
	}

	@When("User Enter UserName and Password by Click on Sign In Button")
	public void user_Enter_UserName_and_Password_by_Click_on_Sign_In_Button() throws IOException {
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(files.getProperty("username"));
		WebElement pwd=driver.findElement(By.xpath("//input[@name='user_password']"));
		
		WebElement Login=driver.findElement(By.xpath("//input[@name='Login']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='admin'", pwd);
		js.executeScript("arguments[0].click()", Login);
		//////////////////////////////////////////////////////////
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshots/docs.png"));
	    
	}

	@Then("User Login SucessFully")
	public void user_Login_SucessFully() {
		
		System.out.println("Login Sucessfully");
	   
	}

	@Then("User Is in home Page")
	public void user_Is_in_home_Page() {
		
		String ActualTitle=driver.getTitle();
		String ExpTitle="admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";
		
		if(ActualTitle.equalsIgnoreCase(ExpTitle)) {
			
			System.out.println("Title Matched");
		}
		else {
			
			System.out.println("Title is not Matched");
		}
	   
	}

	@Then("User has click on marketing Tab")
	public void user_has_click_on_marketing_Tab() {
		
		WebElement MouseHover=driver.findElement(By.xpath("//a[text()='Marketing']"));
		Actions act=new Actions(driver);
		act.moveToElement(MouseHover).build().perform();
		System.out.println("Mosuehover Done");
	    
	}

	@Then("User has click on account Tab")
	public void user_has_click_on_account_Tab() throws InterruptedException {
	   
		WebElement acc=driver.findElement(By.xpath("//div[@id='Marketing_sub']/table/tbody/tr[2]//a"));
		acc.click();
		Thread.sleep(1000);
	}

	@Then("User has click on documents Tab")
	public void user_has_click_on_documents_Tab() throws InterruptedException {
		
		driver.findElement(By.xpath("//table[3]/tbody/tr/td/table/tbody/tr/td[7]/a")).click();
		Thread.sleep(1000);
		System.out.println("User has click on Documents Tab");
		
		WebDriverWait wait=new WebDriverWait(driver,10);
		WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Documents'][text()='Test1']")));
		boolean status=ele.isDisplayed();
		
		if(status) {
			
			System.out.println("Element is Visible");
		}
		else {
			
			System.out.println("Element is not Visible");
		}
		Thread.sleep(1000);
	}
	
	@Then("User Move to Folder in Document")
	public void user_Move_to_Folder_in_Document() throws InterruptedException, IOException {
	    
		List<WebElement>AllList=driver.findElements(By.xpath("//input[@name='selected_id1']"));
		
		for(int i=0;i<AllList.size();i++) {
			
			AllList.get(0).click();
			break;
		}
		
		driver.findElement(By.xpath("//input[@name='move']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='movefolderlist']/div/div/table/tbody/tr[3]/td/a")).click();
		
		Alert alt=driver.switchTo().alert();
		String txt=alt.getText();
		System.out.println(txt);
		alt.accept();
		System.out.println("Alert Pop-up Message Clear");
		Thread.sleep(2000);
		
		File srcc=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcc, new File("./Screenshots/Alert.png"));
	    System.out.println("TakeScreenshot alerts");
		
	}
	

   @Then("User Add {string},{string} in Documents Functionlity")
   public void user_Add_in_Documents_Functionlity(String Title, String FileName) throws InterruptedException, IOException {
    
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("//*[@id='basicsearchcolumns_real']")).click();
	   Thread.sleep(1000);
	   WebElement SelectData=driver.findElement(By.xpath("//select[@id='bas_searchfield'][1]"));
	   Select sel=new Select(SelectData);
	   List<WebElement>sb=sel.getOptions();
	   //int size=sb.size();
	   System.out.println(sb);
	   int size = sb.size();
	      for(int i =0; i<size ; i++){
	    	  WebElement ele=sb.get(i);
	    	  //ele
	    	  if(ele.getText().equals("Title")) {
	    		
	    		  ele.click();
	    		  break;
	    		  
	    	  }
	         Thread.sleep(1000);
	   
	       }
	      
	      driver.findElement(By.xpath("//*[@id='searchAcc']/form/table/tbody/tr[1]/td[6]/input")).click();
	      Thread.sleep(1000);
	      
	      File srcc=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	      FileUtils.copyFile(srcc, new File("./Screenshots/drop.png"));
	      
	      driver.findElement(By.xpath("//*[@id=\"FileList_1\"]/table/tbody/tr[2]/td/div/table/tbody/tr[2]/td/a")).click();
	      Thread.sleep(1000);
	      WebElement title=driver.findElement(By.xpath("//input[@name='notes_title']"));
	      title.sendKeys(Title);
	      Thread.sleep(1000);
	      
	      WebElement filename=driver.findElement(By.xpath("//input[@name='filename']"));
	      filename.sendKeys(FileName);
	      
	      Thread.sleep(1000);
   }
   
   @Then("User the Quickcreate List in Quickcreate Page")
   public void user_the_Quickcreate_List_in_Quickcreate_Page() throws InterruptedException {
      
	   Thread.sleep(1000);
	   WebElement selectdtata=driver.findElement(By.xpath("//select[@id='qccombo']"));
	   
	   String[]str= {"Quick Create...","New Account","New Asset","New To Do"};
	   
	   Select sel=new Select(selectdtata);
	   
	   List<WebElement>AllList=sel.getOptions();
	   
	   for(WebElement we:AllList) {
		   
	   for(int i=0;i<str.length;i++) {
		   
		   if(we.getText().equals(str[i])) {
			   
			   System.out.println("Matched");
		   }
		   
		  Thread.sleep(1000);
	   }
	   
	   
	   }   
	     
   }
   /////////////////////////////////////////////////////////////
   ///Verify List
   
   @Then("User Verify the List of Documents in Documents Page")
   public void user_Verify_the_List_of_Documents_in_Documents_Page() throws InterruptedException {
	   
	   Thread.sleep(1000);
	   WebElement ele=driver.findElement(By.xpath("//select[@id='bas_searchfield']"));
	   
	   String[]s1= {"Document No","Title","File Name","Modified Time","Assigned To","Download Type"};
	   
	   Select sel=new Select(ele);
	   
	   List<WebElement>allLists=sel.getOptions();
	   
	   for(WebElement ws:allLists) {
		   
		   for(int i=0;i<s1.length;i++) {
			   
			   if(ws.getText().equals(s1[i])) {
				   
				   System.out.println("Title Matched");
			   }
			   
			  Thread.sleep(1000);
		   }
	   }
	   
	   
       
   }

}




















