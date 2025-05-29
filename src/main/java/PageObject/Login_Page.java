package PageObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_Page {
	
	
	public static WebDriver driver;
	public static Properties files;
	
	public Login_Page(WebDriver driver) {
		
		this.driver=driver;
	}	
		By Uname=By.xpath("//input[@name='user_name']");
		By Password=By.xpath("//input[@name='user_password']");
		By login=By.xpath("//input[@name='Login']");
			
		
	
	public void ValidLogin(WebDriver driver) throws IOException {
		FileInputStream fis=new FileInputStream("Config.properties");
		files=new Properties();
		files.load(fis);
		driver.findElement(Uname).sendKeys(files.getProperty("username"));
		driver.findElement(Password).sendKeys(files.getProperty("password"));
		driver.findElement(login).click();
		
	}

}
