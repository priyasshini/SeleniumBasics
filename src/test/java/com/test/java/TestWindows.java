package com.test.java;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class TestWindows {
  WebDriver driver;
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Selenium Laterals\\chromedriver_win32\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("http://localhost:8083/TestMeApp");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
  @Test
  public void windowtest() {
	  driver.findElement(By.xpath("//a[text()=' SignIn']")).click();
	  driver.findElement(By.id("userName")).sendKeys("Lalitha");
	  driver.findElement(By.id("password")).sendKeys("Password123");
	  driver.findElement(By.name("Login")).click();
	  Actions mousemovement=new Actions(driver);
	  mousemovement.moveToElement(driver.findElement(By.xpath("//span[text()='AboutUs']"))).perform();
	  mousemovement.moveToElement(driver.findElement(By.xpath("//span[text()='Our Offices']"))).perform();
	  mousemovement.moveToElement(driver.findElement(By.xpath("//span[text()='Chennai']"))).click().build().perform();
	  
	  Set<String> windowids=driver.getWindowHandles();
	  //String parentwindowid=driver.getWindowHandle();
	  for(String windowhandle:windowids)
	  {
		  driver.switchTo().window(windowhandle);
		  System.out.println("All Windows IDs:-"+windowhandle);
	  }
	  //driver.switchTo().window(parentwindowid);
	  System.out.println("Switched to Child Window");
	  
	  
	  
  }
  @AfterTest
  public void afterTest() {
  }

}
