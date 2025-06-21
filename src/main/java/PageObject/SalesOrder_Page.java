package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class SalesOrder_Page {
	
	public WebDriver driver;
	
	public SalesOrder_Page(WebDriver driver){
		
		this.driver=driver;
		
	}
	
	By Login_Btn=By.xpath("//input[@name='Login']");
	By Sales_Link=By.xpath("//a[text()='Sales']");
	By SalesOrd_Btn=By.xpath("//div[@id='Sales_sub']/table/tbody/tr[6]/td//a[text()='Sales Order']");
	By createSales_Btn=By.xpath("//img[@alt='Create Sales Order...']");
	By subText=By.xpath("//input[@name='subject']");
	By BillAdd=By.xpath("//textarea[@name='bill_street']");
	By billadd=By.xpath("//textarea[@name='ship_street']");
	By Products_Btn=By.xpath("//img[@title='Products']");
	 By Save=By.xpath("//input[@title='Save [Alt+S]'][@value='  Save  '][1]");
	
	
	
	
	
	
	public void Click_Login(WebDriver driver) {
		
		driver.findElement(Login_Btn).click();
	}
	
	public void MouseHover(WebDriver driver) {
		
		WebElement links=driver.findElement(Sales_Link);
		Actions act=new Actions(driver);
		act.moveToElement(links).build().perform();
		
	}
	
	public void SalesOrder(WebDriver driver) {
		
		driver.findElement(SalesOrd_Btn).click();
		driver.findElement(createSales_Btn).click();
	}
	
	public void ClickProduct(WebDriver driver) {
		
		driver.findElement(Products_Btn).click();
		
	}
	public void createSales(WebDriver driver) {
		
		
		driver.findElement(Save).click();
		
		
	}
	

}











