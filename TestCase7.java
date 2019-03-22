package sftc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class TestCase7 extends TestEntryClass{
	
	@Test
	@Parameters({"url","Username","Password","Sendername","Senderemail"})
	public static void testCase7(String url, String Username, String Password, String Sendername, String Senderemail) throws InterruptedException {
	
		
		
	path = "/Users/Naveen/Documents/QAReports/TestCase7.html";
	Launch(url,path);
	
	logger = report.startTest("TC07");
	
	driver  = LoginSalesForce(Username,Password);
	
	driver = MySettings();
	driver = testStep2();
	driver = testStep3();
	driver = testStep4(Sendername, Senderemail);
	
		}
	
	@Test(dependsOnMethods = {"MySettings"},priority = 3)
	public static WebDriver testStep4(String Sendername,String Senderemail) {
		// TODO Auto-generated method stub
		WebElement email = findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[4]/div[4]"),"Email tab");
		buttonClick(email,"Email tab");
		
		WebElement Myemlsttgs = findElement(By.xpath("//a[@id='EmailSettings_font']"),"My Email Settings");
		buttonClick(Myemlsttgs,"My Email Settings");
		
		WebElement sndrName = findElement(By.xpath("//input[@id='sender_name']"),"Email name field");
		sndrName.clear();
		entertext(sndrName,"Email name field",Sendername);
		
		WebElement sndrEmail = findElement(By.xpath("//input[@id='sender_email']"),"Email address field");
		sndrEmail.clear();
		entertext(sndrEmail,"Email address field",Senderemail);
		
		WebElement AutoBcc = findElement(By.xpath("//input[@id='auto_bcc1']"),"Auto BCC yes");
		buttonClick(AutoBcc,"Auto BCC yes");
		return driver;
	}

	@Test(dependsOnMethods = {"MySettings"},priority = 2)
public static WebDriver testStep3() throws InterruptedException {
		// TODO Auto-generated method stub
	WebElement Dsply_layout = findElement(By.xpath("//div[@id='DisplayAndLayout']//a[contains(@class,'header setupFolder')]"),"Display and Layout");
	buttonClick(Dsply_layout,"Display and Layout");
	
	WebElement custMyTabs = findElement(By.xpath("//a[@id='CustomizeTabs_font']"),"Customize my tabs");
	buttonClick(custMyTabs,"Customize my tabs");
	
	Thread.sleep(3000);
	String s1 = "https://na85.salesforce.com/p/setup/layout/ConfigureMyTabs?retURL=%2Fui%2Fsetup%2FSetup%3Fsetupid%3DDisplayAndLayout&setupid=CustomizeTabs";
	String s2 = driver.getCurrentUrl();
	compareStrings(s1,s2);
	
	WebElement customApp = findElement(By.xpath("//select[@name='p4']"),"Custome app dropdown");
	dropDowmMenu(customApp,"Custome app dropdown","Salesforce Chatter");
		
	WebElement avilTabs = findElement(By.xpath("//select[@id='duel_select_0']"),"Available Tabs");
	dropDowmMenu(avilTabs,"Available Tabs","Reports");
		
	WebElement add_btn = findElement(By.xpath("//img[contains(@title,'Add')]"),"Add button");
	buttonClick(add_btn, "Add button");
	
	WebElement seleTabs = findElement(By.xpath("//select[@id='duel_select_1']"),"Selected Tabs");
	dropDowmMenu(seleTabs,"Selected Tabs","Reports");
		
	return driver;
	}

	@Test(dependsOnMethods = {"MySettings"},priority = 1)
public static WebDriver testStep2() throws InterruptedException {
		// TODO Auto-generated method stub
	WebElement personal = findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[4]/div[2]/a[1]"),"Personal Button");
	buttonClick(personal,"personal button");
	
	WebElement Login_hsty = findElement(By.xpath("//a[@href='/ui/setup/personal/LoginHistorySetupPage?setupid=LoginHistory&retURL=%2Fui%2Fsetup%2FSetup%3Fsetupid%3DPersonalInfo']"),"Login History");
	buttonClick(Login_hsty,"Login History");
	
	String s2 = driver.getCurrentUrl();
	String s1 = "https://na85.salesforce.com/ui/setup/personal/LoginHistorySetupPage?setupid=LoginHistory&retURL=%2Fui%2Fsetup%2FSetup%3Fsetupid%3DPersonalInfo";
	compareStrings(s1,s2);
	
	WebElement Dwnload_login_hsty = findElement(By.xpath("//a[contains(text(),'Download login history for last six months, includ')]"),"Download login history");
	Thread.sleep(3000);
	//buttonClick(Dwnload_login_hsty,"Download login history");
	System.out.println("Downloaded in .csv format");
		
	return driver;
	}

@Test
public static WebDriver MySettings() throws InterruptedException {
	
		Thread.sleep(3000);
		
		WebElement userdd = findElement(By.xpath("//div[@id='userNav-arrow']"),"User Dropdown");
		buttonClick(userdd,"User Dropdown");
		
		WebElement my_settings = findElement(By.xpath("//a[@title='My Settings']"),"My Settings");
		buttonClick(my_settings,"My Settings");
		
		
		
		
		compareStrings(driver.getCurrentUrl(),("https://na85.salesforce.com/ui/setup/Setup?setupid=PersonalSetup")); 
		return driver;
	}
	
	

}
