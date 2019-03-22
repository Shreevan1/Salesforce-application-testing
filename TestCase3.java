package sftc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCase3 extends TestEntryClass {
	@Test
	@Parameters({"url","Username","Password"})
	public static void testCase3(String url,String Username,String Password) throws InterruptedException {
		// TODO Auto-generated method stub
		InitializeDriver();
		path = "/Users/Naveen/Documents/QAReports/TestCase3.html";
		Launch(url,path);
		
		logger = report.startTest("TC03");
		
		WebElement uname = findElement(By.xpath("//input[@name='username']"),"Username");
		entertext(uname,"Username",Username);
		String SentUN = uname.getText();
		
		WebElement password = findElement(By.xpath("//input[@name='pw']"),"Password");
		entertext(password,"Password",Password);
		
		WebElement remUN = findElement(By.xpath("//input[@name='rememberUn']"),"Remember Username");
		selectCheckBox(remUN , "Remember UN");
		
		
		WebElement login = findElement(By.xpath("//input[@value='Log In']"),"Login");
		buttonClick(login,"Login");
		
		windowHandler(driver);
		
		WebElement userdd = findElement(By.xpath("//div[@id='userNav-arrow']"),"User Dropdown");
		buttonClick(userdd,"User Dropdown");
		
		WebElement logout =findElement(By.xpath("//a[@title='Logout']"),"Logout");
		buttonClick(logout,"Logout");
		
		
		driver.get("https://login.salesforce.com/");
		System.out.println(driver.getCurrentUrl());
		driver.manage().window().maximize();
		
		WebElement uname1 = findElement(By.xpath("//input[@name='username']"),"Saved Username");
		String SavedUN = uname1.getText();
		
		compareStrings(SentUN,SavedUN);
		
		
		
		
	
	
	}

}
