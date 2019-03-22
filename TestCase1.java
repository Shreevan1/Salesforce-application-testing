package sftc;

import java.io.IOException;

//import SalesForceTestCaseReports.TestCase1Report;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
//import org.openqa.selenium.chrome.ChromeDriver;

//import SalesForceTestCases.TestEntryClass;

public class TestCase1 extends TestEntryClass {
	
	@Test
	@Parameters({"url","Username","Password"})
	public static void testCase1(String url,String Username,String Password) throws IOException {
		// TODO Auto-generated method stub
	
		path = "/Users/Naveen/Documents/QAReports/TestCase1.html";
		Launch(url,path);
		
		logger = report.startTest("Login Error message 1");
		
		WebElement uname = findElement(By.xpath("//input[@name='username']"),"Username");
		entertext(uname,"Username",Username);
		
		WebElement password = findElement(By.xpath("//input[@name='pw']"),"Password");
		entertext(password,"Password",Password);
		password.clear();
		System.out.println("Password field is clear");
		
		WebElement login = findElement(By.xpath("//input[@value='Log In']"),"Login");
		buttonClick(login,"Login");
		
		WebElement err_msg = driver.findElement(By.id("error"));
		
		String S1 = err_msg.getText();
		String S2 = "Please enter your password.";
		compareStrings(S1,S2);
		
		
		
		
	

	}

}
