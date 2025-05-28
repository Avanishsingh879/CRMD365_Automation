package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Support_Page {
	
	
	public static WebDriver driver;
	
	public Support_Page(WebDriver driver) {
		
		this.driver=driver;
	}
	
	   By Supp=By.xpath("//a[text()='Support']");
	   By TroubleTickets= By.xpath("//div[@id='Support_sub']/table/tbody/tr/td//a[text()='Trouble Tickets']");
	   By Cont= By.xpath("//a[text()='Contacts']");
	   By Faq=By.xpath("//a[text()='FAQ']");
	   
	   public WebElement Support(WebDriver driver) {
		   
		   return driver.findElement(Supp);
		   
	   }
	   
	   public void Trtickt(WebDriver driver) {
		   
		   driver.findElement(TroubleTickets).click();
	   }
	   
	   public void Contact(WebDriver driver) {
		   
		   driver.findElement(Cont).click();
	   }

       public void Faq(WebDriver driver) {
		   
		   driver.findElement(Faq).click();
	   }
}
