package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Project_Page {
	
	public WebDriver driver;
	public Project_Page(WebDriver driver) {
		
		this.driver=driver;
	}
	
	By Uname=By.xpath("//input[@name='user_name']");
	By Pwd=  By.xpath("//input[@name='user_password']");
	By Login=By.xpath("//input[@name='Login']");
	
	
    public void ValidLogin(WebDriver driver) throws InterruptedException {
    	
    	driver.findElement(Uname).sendKeys("admin");
    	driver.findElement(Pwd).sendKeys("admin");
    	driver.findElement(Login).click();
    	Thread.sleep(1000);
    }

}
