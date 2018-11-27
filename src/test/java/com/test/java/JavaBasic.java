package com.test.java;

public class JavaBasic {
	int a=2;
	char ch='A';
	String str="First Java";
	public static void main(String[] args) {
		System.out.println("First Java Program");
		int age = 43;
		int rollno=403;
		if( age >= 60 || rollno>=200 ){
			System.out.println("For senior citizen the interest rate is 11%");
		}else if(age >= 45){
			System.out.println("For the age " + age + " the interest rate is 10%");
		}
		else if(age <=15)
		{
			System.out.println("Age is less than 15");
		}
		else{
			System.out.println("For the age " + age + " the interest rate is 9.5%");	
		
			if(rollno<=15)
			{
				System.out.println("Roll no. is Less than 15");
			}
			else
			{
				System.out.println("Print Roll No,:-"+rollno);
			}
			
			
	}
	}}

