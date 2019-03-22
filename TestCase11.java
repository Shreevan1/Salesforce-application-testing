package sftc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCase11 extends TestEntryClass {
	@Test
	@Parameters({"url","Username","Password","Firstname","ViewUniquename"})
	public static void testCase1(String url,String Username,String Password, String Firstname, String ViewUniquename) throws InterruptedException {
		// TODO Auto-generated method stub
	
		path = "/Users/Naveen/Documents/QAReports/TestCase11.html";
		Launch(url,path);
		
		logger = report.startTest("TC11");
        driver  = LoginSalesForce(Username,Password);
		
		Thread.sleep(2000);
		
		driver = AccountslinkViewTest(Firstname,ViewUniquename);
	}
	
	@Test
	public static WebDriver AccountslinkViewTest(String Firstname,String ViewUniquename) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		WebElement plus = findElement(By.xpath("//a[@href='/home/showAllTabs.jsp']"),"plus botton");
		buttonClick(plus,"Plus button");
		
		WebElement acct_link = findElement(By.xpath("//a[@class='listRelatedObject accountBlock title']"),"Accounts link");
		buttonClick(acct_link , "Accounts link");
		
		WebElement nw=driver.findElement(By.xpath("//a[@id='tryLexDialogX']"));
		nw.click();
		
		WebElement crt_new_view = findElement(By.xpath("//a[contains(text(),'Create New View')]"),"Create new view");
		buttonClick(crt_new_view,"Create new view");
		
		WebElement view_name = findElement(By.xpath("//input[@name='fname']"),"View name");
		entertext(view_name,"View name","nn");
		
		WebElement view_unique_name = findElement(By.xpath("//input[@id='devname']"),"View unique name");
		entertext(view_unique_name,"View name","ss");
		
		WebElement Save_bttn =findElement(By.xpath("//div[@class='pbHeader']//input[@title='Save']"),"Save button");
		buttonClick(Save_bttn,"Save button");
		
		Thread.sleep(5000);
		/*driver.switchTo().window("https://na85.salesforce.com/001?fcf=00B1U00000BCLLY");*/
		
		WebElement View_dd = findElement(By.xpath("//select[@title='View:']"),"View dropdown");
		dropDowmMenu(View_dd,"View dropdown",Firstname);
		
		return driver;
		
		
	}
	
		
		
}
