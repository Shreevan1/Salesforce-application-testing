package sftc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class TestCase4 extends TestEntryClass {
	
	@Test
	@Parameters({"url","Username"})

	public static void testCase4A(String url,String Username) {
		// TODO Auto-generated method stub
		InitializeDriver();
		path = "/Users/Naveen/Documents/QAReports/TestCase4a.html";
		Launch(url,path);
		
		logger = report.startTest("TC04A");
		
		WebElement forgotpasswd = findElement(By.id("forgot_password_link"),"Forgot Password");
		buttonClick(forgotpasswd,"Forgot Password");
		
		String curr_url = driver.getCurrentUrl();
		String expurl = "https://login.salesforce.com/secur/forgotpassword.jsp?locale=us";
		if(curr_url.equals(expurl)) {
			
			logger.log(LogStatus.PASS, "Forgot password page displayed");
			
			String textValue = Username;
			WebElement Uname = findElement(By.xpath("//input[@name='un']"),"Username");
			entertext(Uname,"Username",textValue);
			
			WebElement Continue_bt = findElement(By.xpath("//input[@id='continue']"),"Continue Button");
			buttonClick(Continue_bt,"Continue Button");
			
			curr_url = driver.getCurrentUrl();
			expurl = "https://login.salesforce.com/secur/forgotpassword.jsp";
			
			if(curr_url.equals(expurl)) {
				logger.log(LogStatus.PASS, "New password sent to Username "+textValue);
			}
			else {
				logger.log(LogStatus.FAIL,"New password not sent to Username "+textValue);
			}
			
		}
		else {
			logger.log(LogStatus.FAIL, "Forgot password page not displayed");
		}
		
	}
	@Test
	@Parameters({"url","Username","Password1"})
	public static void testCase4B(String url,String Username,String Password1) {
		// TODO Auto-generated method stub
		//Initialize driver else we will get no such session exception, since we are trying to use driver after quit() in TC04a
		InitializeDriver();
		
		path = "/Users/Naveen/Documents/QAReports/TestCase4b.html";
		Launch(url,path);
		
		logger = report.startTest("TC04B");
		
		WebElement uname = findElement(By.xpath("//input[@name='username']"),"Username");
		entertext(uname,"Username",Username);
		
		WebElement password = findElement(By.xpath("//input[@name='pw']"),"Password");
		entertext(password,"Password",Password1);
		
		WebElement login = findElement(By.xpath("//input[@value='Log In']"),"Login");
		buttonClick(login,"Login");
		
		
		
		
		WebElement err_msg = findElement(By.id("error"),"Error message");
		
		
		String S1 = err_msg.getText();
		String S2 = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		
		
		compareStrings(S1,S2);
		
		
		
		
		
	}
	

}
