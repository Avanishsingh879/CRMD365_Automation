package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;

public class Parallel_Executions {
	
	
	@Given("I open the Browser and Navigate to the URL")
	public void i_open_the_Browser_and_Navigate_to_the_URL() throws InterruptedException {
	    
		
	   System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_136.exe");
	   WebDriver driver=new ChromeDriver();
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   driver.manage().window().maximize();
	   driver.get("http://localhost:8888/");
	   Thread.sleep(1000);
	   
		
	}

}
