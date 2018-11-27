package com.test.java;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class LoginUsingPageObjectModel {
	WebDriver driver;
	LoginPageObjects lp;
  @Test
  @Parameters("testname")
  public void testLogin(String testcasename) {
	  //Test script for Login 
	  lp.enterUsername("mercury");
	  lp.enterPassword("mercury");
	  lp.clickLoginButton();
	    
  }
 
  @BeforeTest
  @Parameters("browser")
  public void beforeTest(String browserName) {
	 
	  lp=PageFactory.initElements(driver, LoginPageObjects.class);
	  System.out.println("Parameter Name:-"+browserName);
	  if(browserName.equalsIgnoreCase("Chrome"))
	  {
	  //to test on chrome browser
	  System.setProperty("webdriver.chrome.driver", "C:\\Selenium Laterals\\chromedriver_win32\\chromedriver.exe");
	  driver=new ChromeDriver();
	  }
	  else
	  {
	//to test on firefox browser
	  System.setProperty("webdriver.gecko.driver", "C:\\Selenium Laterals\\geckodriver-v0.21.0-win64\\geckodriver.exe");
	  driver=new FirefoxDriver();
	  }
	 // driver.manage().window().maximize();
	  driver.get("http://localhost:9090/servlets/com.mercurytours.servlet.WelcomeServlet");
	  //implicit wait
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  String actualtitle=driver.getTitle();
	  System.out.println("Title on Launching website:"+actualtitle);
	  //TestNg Assert for verification of title
	  //Expected result is -> Welcome: Mercury Tours
	  Assert.assertEquals(actualtitle,"Welcome: Mercury Tours");
	    }

  @AfterTest
  public void afterTest() {
	  //driver.quit();
  }

}
