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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class SeleniumFirstProgram {
	WebDriver driver;
  @Test
  @Parameters("testname")
  public void testLogin(String testcasename) {
	  Reporter.log("Launching Test script for :-"+testcasename);
	  WebElement uname=driver.findElement(By.name("userName"));
	  uname.sendKeys("mercury");
	  Reporter.log("Username Entered");
	  WebElement pwd=driver.findElement(By.name("password"));
	  pwd.sendKeys("mercury");
	  WebDriverWait wait= new WebDriverWait(driver, 10);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='login']")));
	  WebElement loginbutton=driver.findElement(By.xpath("//input[@name='login']"));
	  loginbutton.click();
	  WebElement nofPassengers=driver.findElement(By.name("passCount"));
	  Select se=new Select(nofPassengers);
	 // se.selectByVisibleText("4");
	  se.selectByIndex(1);
	  se.selectByValue("3");
	    
  }
 
  @BeforeTest
  @Parameters("browser")
  public void beforeTest(String browserName) {
	 
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
