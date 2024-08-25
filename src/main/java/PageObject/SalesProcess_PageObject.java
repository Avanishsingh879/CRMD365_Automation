package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class SalesProcess_PageObject {
	
		
	@FindBy(name="Leads")
	public WebElement Salads_clka;
	
	@FindBy(linkText="Leads")
	public WebElement Leads_clk;
	
	@FindBy(xpath="//*[@name='Login']")
	public WebElement Login_clk;
	
	@FindBy(xpath="//*[@id='Sales_sub']//a[text()='Accounts']")
	public WebElement Accounts_clk;
     

}
