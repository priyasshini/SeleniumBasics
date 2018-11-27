package com.test.java;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class PriorityTest {
  @Test(priority=2,enabled=false)
  public void test1() {
	System.out.println("Inside Test case 1");  
  }
  @Test(priority=1)
  public void test2() {
	  System.out.println("Inside Test case2");
  }
  @Test(priority=3)
  public void test3()
  {
	  System.out.println("Inside Test case 3");
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
