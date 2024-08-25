package Generic_Method;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

import cucumber.api.Scenario;




public class Utility_Method {
	
	
	//public static WebDriver DriverObject;
	///public static Properties file;
    public static JavascriptExecutor Js;
    public static Properties fileObject;
    public static String path="OR.properties ";
    public static WebDriver driver;
    
    // TakeScreenshots
    public static void captureScreenShot(WebDriver driver)
    {
                  try {
                                       File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                                       FileUtils.copyFile(screenshot, new File("./Screenshots/Test.png"));
                           } catch (Exception e)
                             {
                                 System.out.println(e.getMessage());
                                  e.printStackTrace();
                              }
        }
    
    // MouseHover
    
    public static void Hover(WebDriver driver, WebElement element) {
    	Actions action = new Actions(driver);
    	action.moveToElement(element).perform();
    }
    
    //Highlight Elelmemt
    public static void highLightElement(WebDriver driver, WebElement element)
    {
    JavascriptExecutor js=(JavascriptExecutor)driver; 

    js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

    try 
    {
    Thread.sleep(1000);
    } 
    catch (InterruptedException e) {

    System.out.println(e.getMessage());
    } 

    js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 

    }

    /////Propertis File
   
    public static void readPropertiesFile() throws IOException{
    	
    	fileObject= new Properties();
    	FileInputStream fis=new FileInputStream(path);
    	fileObject.load(fis);
    	
    }
    
    public static void Logout() {
    	
    	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
    }
    //////////////Attach SccrenShot/////////////////////
    @AfterMethod
    public static void TakesScreenshotOnFilure(WebDriver driver,Scenario scenario) {
    	
    	if(scenario.isFailed()) {
    		TakesScreenshot ts=(TakesScreenshot)driver;
    		byte[]src=ts.getScreenshotAs(OutputType.BYTES);
    		scenario.embed(src, "image/png");
    	}
    }
    
   
    }

























