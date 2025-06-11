package PageObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Quotes_Page {

	     public WebDriver driver;
	     public Properties files;
	
	    public Quotes_Page(WebDriver driver) {
	    	
	    	this.driver=driver;
	    }
	    
	   By Username= By.xpath("//input[@name='user_name']");
	   By Password=By.xpath("//input[@name='user_password']");
	   By Login=By.xpath("//input[@name='Login']");
	   By Inventory_Link=By.xpath("//a[text()='Inventory']");
	   By Quotes_links= By.xpath("//div[@id='Inventory_sub']/table/tbody/tr[6]/td//a[text()='Quotes']");
	   
	   
	   
	   public void ValidLogin(WebDriver driver) throws IOException, InterruptedException {
		   
		   FileInputStream fis=new FileInputStream("Config.properties");
		   files=new Properties();
		   files.load(fis);
		   driver.findElement(Username).sendKeys(files.getProperty("username"));
		   driver.findElement(Password).sendKeys(files.getProperty("password"));
		   driver.findElement(Login).click();
		   Thread.sleep(1000);
	   }
	   
	   public void VerifyQuotes(WebDriver driver) throws InterruptedException {
		   
		   WebElement hover=driver.findElement(Inventory_Link);
		   Actions act=new Actions(driver);
		   act.moveToElement(hover).build().perform();
		   Thread.sleep(1000);
		   driver.findElement(Quotes_links).click();
		   Thread.sleep(1000);
	   }
}



















