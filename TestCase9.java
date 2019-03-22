package sftc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCase9 extends TestEntryClass {
	@Test
	@Parameters({"url","Username","Password"})
	public static void testCase9(String url, String Username, String Password) throws InterruptedException {
		path = "/Users/Naveen/Documents/QAReports/TestCase9.html";
		Launch(url,path);
		
		logger = report.startTest("TC09");
		
		driver  = LoginSalesForce(Username,Password);
		
		driver = LogoutSalesForce();
		
		
	
	
	}
	@Test
	public static WebDriver LogoutSalesForce() throws InterruptedException {
		// TODO Auto-generated method stub
			
		
		Thread.sleep(3000);
		WebElement userdd = findElement(By.xpath("//div[@id='userNavButton']"),"User Dropdown");
		buttonClick(userdd,"User Dropdown");
		
		WebElement logout =findElement(By.xpath("//a[@title='Logout']"),"Logout");
		buttonClick(logout,"Logout");
		
		Thread.sleep(2000);
		
		String exp = "https://www.salesforce.com/";
		String act = driver.getCurrentUrl();
		
		compareStrings(exp,act);
		
		
		return driver;
	}
	
	
	
		

}
