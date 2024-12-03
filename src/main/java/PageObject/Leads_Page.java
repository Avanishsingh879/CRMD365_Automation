package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class Leads_Page {
	
	public static WebDriver driver;	
	
	public Leads_Page(WebDriver driver) {
		this.driver=driver;
	}
	@FindBy(name="Leads")
	public WebElement Salads_clka;
	
	By LoginBtn = By.xpath("//div[@id='Sales_sub']//a[text()='Leads']");
	//By.xpath("//div[@class=\"main-header\"]");
	//@FindBy(xpath="//div[@id='Sales_sub']//a[text()='Leads']")
	//public WebElement Leads_clk;
	
	@FindBy(xpath="//*[@name='Login']")
	public WebElement Login_clk;
	
	@FindBy(xpath="//*[@id='Sales_sub']//a[text()='Accounts']")
	public WebElement Accounts_clk;

	public void Leads(WebDriver driver) {
		// TODO Auto-generated method stub
		driver.findElement(LoginBtn).click();
	}
     

}
