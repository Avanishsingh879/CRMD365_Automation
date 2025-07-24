package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Vendor_Page {
	
	 WebDriver driver;
	 public Vendor_Page(WebDriver driver) {
		 
		 this.driver=driver;
	 }
	 
	 By uname=By.xpath("//input[@name='user_name']");
	 By Pwd=By.xpath("//input[@name='user_password']");
	 By Login=By.xpath("//input[@name='Login']");
	 
	 
	 By VendorLinks=By.xpath("//div[@id='Inventory_sub']/table/tbody/tr[2]/td/a[text()='Vendors']");
	 
	 
	 
	 public void ValidLogin(WebDriver driver) {
		 
		 
		 driver.findElement(uname).sendKeys("admin");
		 driver.findElement(Pwd).sendKeys("admin");
		 driver.findElement(Login).click();
	 }
	 
	 public void MouseHover(WebDriver driver) throws InterruptedException {
		WebElement InventoryBtn=driver.findElement(By.xpath("//a[text()='Inventory']"));
		Actions act=new Actions(driver);
		act.moveToElement(InventoryBtn).build().perform();
		Thread.sleep(1000);
		driver.findElement(VendorLinks).click();
		
		 
		 
	 }

}
