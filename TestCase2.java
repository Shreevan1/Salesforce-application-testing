package sftc;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.LogStatus;

//import SalesForceTestCaseReports.TestCase2Report;

public class TestCase2 extends TestEntryClass{
	
	@Test
	@Parameters({"url","Username","Password"})
	public static void testCase2(String url,String Username,String Password) throws InterruptedException {
		// TODO Auto-generated method stub
		InitializeDriver();
		path = "/Users/Naveen/Documents/QAReports/TestCase2.html";
		Launch(url,path);
		
		logger = report.startTest("TC02");
		
		WebElement uname = findElement(By.xpath("//input[@name='username']"),"Username");
		entertext(uname,"Username",Username);
		
		WebElement password = findElement(By.xpath("//input[@name='pw']"),"Password");
		entertext(password,"Password",Password);
		
		WebElement login = findElement(By.xpath("//input[@value='Log In']"),"Login");
		buttonClick(login,"Login");
		
		Thread.sleep(2000);
		
		String curr_url = driver.getCurrentUrl();
		String exp_url = "https://na85.salesforce.com/setup/forcecomHomepage.apexp?setupid=ForceCom";
		
		compareStrings(curr_url,exp_url);
		
				
	}

}
