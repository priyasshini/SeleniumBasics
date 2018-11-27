package com.test.java;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

public class LoginPageObjects {
	@FindBy(how=How.NAME,using="userName")
	WebElement uname;
	
	@FindBy(name="password")
	WebElement pwd;
	
	@FindBy(xpath="//input[@name='login']")
	WebElement loginbutton;
	
	
	public void enterUsername(String unamevalue)
	{
		uname.sendKeys(unamevalue);
	}
	 public void enterPassword(String pwrd)
	 {
		 pwd.sendKeys(pwrd);
	 }
	
	 public void clickLoginButton()
	 {
		 loginbutton.click();
	 }
	 
	
	

}
