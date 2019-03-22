package sftc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCase8 extends TestEntryClass{
	@Test
	@Parameters({"url","Username","Password"})
	public static void testCase8(String url, String Username, String Password) throws InterruptedException {
	path = "/Users/Naveen/Documents/QAReports/TestCase8.html";
	Launch(url,path);
	
	logger = report.startTest("TC08");
	
	driver  = LoginSalesForce(Username,Password);
	
	driver = developerConsole();
	
	
	}
	@Test
	public static WebDriver developerConsole() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(3000);
		
		WebElement userdd = findElement(By.xpath("//div[@id='userNav-arrow']"),"User Dropdown");
		buttonClick(userdd,"User Dropdown");
		
		WebElement dev_console = findElement(By.xpath("//a[@title='Developer Console (New Window)']"),"Developer Console");
		buttonClick(dev_console,"Developer Console");
		
		windowHandler(driver);
		
		Thread.sleep(3000);
		
		String exp = "https://na85.salesforce.com/_ui/common/apex/debug/ApexCSIPage";
		String act = driver.getCurrentUrl();
		
		compareStrings(exp,act);
		
		
		return driver;
	}
	
	

}
