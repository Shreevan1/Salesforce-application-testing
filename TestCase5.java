package sftc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCase5 extends TestEntryClass{
	@Test
	@Parameters({"url","Username","Password"})
	public static void testCase5(String url,String Username,String Password) throws InterruptedException {
		path = "/Users/Naveen/Documents/QAReports/TestCase5.html";
		Launch(url,path);
		
		logger = report.startTest("TC05");
		
		WebElement uname = findElement(By.xpath("//input[@name='username']"),"Username");
		entertext(uname,"Username",Username);
		
		
		WebElement password = findElement(By.xpath("//input[@name='pw']"),"Password");
		entertext(password,"Password",Password);
		
		
		
		WebElement login = findElement(By.xpath("//input[@value='Log In']"),"Login");
		buttonClick(login,"Login");
		
		Thread.sleep(2000);
		windowHandler(driver);
		
		WebElement userdd = findElement(By.xpath("//div[@id='userNav-arrow']"),"User Dropdown");
		buttonClick(userdd,"User Dropdown");
		
		WebElement my_prfl = findElement(By.xpath("//a[@title='My Profile']"),"My Profile");
		compareStrings(my_prfl.getText(),"My Profile");
		
		WebElement my_stngs = findElement(By.xpath("//a[@title='My Settings']"),"My Settings");
		compareStrings(my_stngs.getText(),"My Settings");
		
		WebElement dev_con = findElement(By.xpath("//a[@title='Developer Console (New Window)']"),"Developer Console");
		compareStrings(dev_con.getText(),"Developer Console");
		
		WebElement stle = findElement(By.xpath("//a[@title='Switch to Lightning Experience']"),"Switch to Lightning Experience");
		compareStrings(stle.getText(),"Switch to Lightning Experience");
		
		WebElement logout = findElement(By.xpath("//a[@title='Logout']"),"Logout");
		compareStrings(logout.getText(),"Logout");
		
		
	
	
	
		}

}
