package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PriceBooks_Page {
	
	public WebDriver driver;
	public PriceBooks_Page(WebDriver driver){
		
		this.driver=driver;
		
	}
	
	////////Xapth///////////////////
	
	By login=By.xpath("//input[@name='Login']");
	By Inventory_Btn=By.xpath("//a[text()='Inventory']");
	By priceBook=By.xpath("//table[@class='level2Bg']/tbody/tr/td/table/tbody/tr//td[3]//a");
	
	
	public void Login(WebDriver driver) throws InterruptedException {
		
		Thread.sleep(1000);
		driver.findElement(login).click();
		
	}
	
	public void Inventoy(WebDriver driver) {
		
		driver.findElement(Inventory_Btn).click();
	}
	
	public void pricebook(WebDriver driver) {
		
		driver.findElement(priceBook).click();
	}
	

}
