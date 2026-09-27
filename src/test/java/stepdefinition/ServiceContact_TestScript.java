package stepdefinition;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ServiceContact_TestScript {
	
	
public static WebDriver driver;
	
@Given("USER Navigate THE Application UrL")
public void user_Navigate_THE_Application_UrL() {
	
	System.setProperty("webdriver.chrome.drvier", "Drivers\\chromedriver_153.exe");
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("http://localhost:8888/");
	System.out.println("Launch Browser");
	 
	
	
}
 

@When("User Enter usernamE And password by click on sign buttoN")
public void user_Enter_usernamE_And_password_by_click_on_sign_buttoN() {
	
   driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
   driver.findElement(By.xpath("//input[@name='user_paasword']")).sendKeys("admin");
   driver.findElement(By.xpath("//input[@name='Login']")).click();
   
    
}

@Then("Login scuessFully")
public void login_scuessFully() {
	
       String actualresult=driver.getTitle();
       String ExpResult="admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM1";
       Assert.assertEquals(actualresult, ExpResult);
       System.out.println("Title Matched");
	
}



@Then("User Is in Home pagE")
public void user_Is_in_Home_pagE() {


}

}
