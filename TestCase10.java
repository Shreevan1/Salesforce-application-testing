package sftc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCase10 extends TestEntryClass {
	
	@Test
	@Parameters({"url","Username","Password"})
	public static void testCase10(String url, String Username, String Password) throws InterruptedException {
		path = "/Users/Naveen/Documents/QAReports/TestCase10.html";
		Launch(url,path);
		
		logger = report.startTest("TC10");
		
		driver  = LoginSalesForce(Username,Password);
		
		Thread.sleep(2000);
		
		driver = Accountslink();
		
		
	}
	@Test
	public static WebDriver Accountslink() throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		WebElement plus = findElement(By.xpath("//a[@href='/home/showAllTabs.jsp']"),"plus botton");
		buttonClick(plus,"Plus button");
		
		WebElement acct_link = findElement(By.xpath("//a[@class='listRelatedObject accountBlock title']"),"Accounts link");
		buttonClick(acct_link , "Accounts link");
		
		Thread.sleep(2000);
		WebElement nw=driver.findElement(By.xpath("//a[@id='tryLexDialogX']"));
		 
		nw.click();
		//Thread.sleep(4000);
		WebElement new_btn = findElement(By.xpath("//input[@title='New']"),"New Button");
		buttonClick(new_btn , "New Button");
		
		Thread.sleep(4000);
		
		WebElement act_Name = findElement(By.xpath("//input[@name='acc2']"),"Account Name");
		act_Name.clear();
		entertext(act_Name,"Account Name","Shree");
		Thread.sleep(4000);
		WebElement save_btn = findElement(By.xpath("//td[@id='bottomButtonRow']//input[@title='Save']"),"Save button");
		buttonClick(save_btn,"Save button");
		
		return driver;
	}

}
