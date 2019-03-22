package sftc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestEntryClass {
	static WebDriver driver;
	static ExtentTest logger;
	static ExtentReports report;
	static String path;

	/*@BeforeMethod
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver", "/Users/Naveen/chromedriver");
		//InitializeDriver();
		

		//System.out.println("Executing testcase 1");
		TestCase1.testCase1();
		/*System.out.println("Executing testcase 2");
		TestCase2.testCase2();
		System.out.println("Executing testcase 3");
		TestCase3.testCase3();
		/*System.out.println("Executing testcase 4A");
		TestCase4.testCase4A();
		System.out.println("Executing testcase 4B");
		TestCase4.testCase4B();
		System.out.println("Executing testcase 5");
		TestCase5.testCase5();*/
		//System.out.println("Executing testcase 6");
		//TestCase6.testCase6();
		//TestCase7.testCase7();
		//TestCase8.testCase8();
		//TestCase9.testCase9();
		//TestCase10.testCase10();
//}
	
	/* Name: InitializeDriver()
	 * Description:Initialize chrome driver by setting system properties
	 * Arguments:none
	 * Date of creation:02/26/2019
	 */
	
	@BeforeSuite
	public static void InitializeDriver() throws WebDriverException {
		
		System.setProperty("webdriver.chrome.driver","/Users/Naveen/Documents/chromedriver");
		driver = new ChromeDriver();
		
	}
	/* Name: Launch()
	 * Description:Launching chrome driver with the url, and extent reports With path
	 * Arguments:String url,String path
	 * Date of creation:02/26/2019
	 */
	
	
	public static void Launch(String url,String path) {
		driver.get(url);
		report = new ExtentReports(path);
		
	}
	/* Name: selectCheckBox()
	 * Description:Selecting the check box
	 * Arguments:WebElement obj,String objName
	 * Date of creation:02/26/2019
	 */
	
  public static void selectCheckBox(WebElement obj,String objName ) {
		
		if(obj.isDisplayed()) {
			if(!obj.isSelected()) {
				obj.click();
				System.out.println("Pass: checkbox selected in "+objName+" field");
				logger.log(LogStatus.PASS, ""+ objName +"Checkbox selected");
			}
		else {
			System.out.println("Fail: "+objName+" could not be found");
			logger.log(LogStatus.FAIL, ""+ objName +"Checkbox not selected");
		}
		}
    }
  /* Name: findElement()
	 * Description:To find the specified element is present or not
	 * Arguments:By location,String objName
	 * Date of creation:02/26/2019
	 */
	
    public static WebElement findElement(By location,String objName) {
		WebElement obj = null;
		try {
			obj = driver.findElement(location);
			System.out.println("pass: "+objName+" Found on the page");
			logger.log(LogStatus.PASS, ""+ objName +" Found on the page");
		}
		catch(NoSuchElementException errMessage) {
			System.out.println("Fail: "+objName+" not found on the page");
			logger.log(LogStatus.FAIL, ""+ objName +" not Found on the page");
		
		}
		return obj;
	}
    /* Name: entertext()
	 * Description:To sendkeys to enter the text value in the specified field
	 * Arguments:WebElement obj,String objName ,String textValue
	 * Date of creation:02/26/2019
	 */
	
   
    public static void entertext(WebElement obj,String objName ,String textValue) {
		if(obj.isDisplayed()) {
			obj.clear();
			obj.sendKeys(textValue);
			System.out.println("Pass: "+textValue+" entered in "+objName+" field");
			logger.log(LogStatus.PASS, ""+ textValue +" entered on the page");
		}
		else {
			System.out.println("Fail: "+objName+" could not be found");
			logger.log(LogStatus.FAIL,"Fail: "+objName+" could not be found" );
		}
	}
    /* Name: dropDowmMenu()
	 * Description:To select the value with visible text in a dropdowm menu with <select> tag
	 * Arguments:WebElement obj,String objName,String SelectValue
	 * Date of creation:02/27/2019
	 */
	
   public static void dropDowmMenu(WebElement obj,String objName,String SelectValue) throws InterruptedException {
		if(obj.isDisplayed()) {
			obj.click();
			System.out.println("menu is clicked");
			Select select = new Select(obj);
			select.selectByVisibleText(SelectValue);
			logger.log(LogStatus.PASS, ""+SelectValue+" is selected in "+objName+" tab");
			//System.out.println("Pass: Dropdown menu selected in "+objName+" field and mysettings optinon is selected");
		}
		else {
			System.out.println("Fail: "+objName+" could not be found");
			logger.log(LogStatus.FAIL, ""+SelectValue+" is not selected in "+objName+" tab ");
		}
		
		
	}
   /* Name: buttonClick()
	 * Description:To check if the specified button is present or not and to click on the button
	 * Arguments:WebElement obj,String objName
	 * Date of creation:02/27/2019
	 */
	
     public static void buttonClick(WebElement obj,String objName) {
    	if(obj.isDisplayed()) {
			obj.click();
			System.out.println(objName+ "is clicked");
			logger.log(LogStatus.PASS,objName+ " is clicked" );
		}
		else {
			System.out.println("Fail: "+objName+" could not be found");
			logger.log(LogStatus.FAIL,objName+ " is not clicked" );
		}
		
    }
     /* Name: compareStrings()
 	 * Description:To compare two String a and log pass if both are present 
 	 * Arguments:String S1, String S2
 	 * Date of creation:02/27/2019
 	 */
 	
  
   public static void compareStrings(String S1, String S2) {
	   SoftAssert sassert = new SoftAssert();
	   try {
		  sassert.assertEquals(S1, S2);
		logger.log(LogStatus.PASS, S2+"Messege displayed on the window");
	  }
      catch(AssertionError a) {
    	  logger.log(LogStatus.FAIL, S2+" Messege is not displayed on the window");
      }
	   

	   
    }
   /* Name: windowHandler
	 * Description:To navigate among various windows
	 * Arguments:WebDriver driver2
	 * Date of creation:03/02/2019
	 */
	
    public static void windowHandler(WebDriver driver2) {
    	Set<String> getAllWindows = driver2.getWindowHandles();
		String[] allWindows = getAllWindows.toArray(new String[getAllWindows.size()]);
		driver2.switchTo().window(allWindows[0]);
		System.out.println(driver2.getCurrentUrl());
		
		driver2.manage().window().maximize();
    }
    /* Name: LoginSalesForce
	 * Description:Reusable function to login to the salesforce application
	 * Arguments:String Username,String Password
	 * Date of creation:03/05/2019
	 */
	
    
    @Test
    public static  WebDriver LoginSalesForce(String Username,String Password) {
    	WebElement uname = findElement(By.xpath("//input[@name='username']"),"Username");
		entertext(uname,"Username",Username);
		
		
		WebElement password = findElement(By.xpath("//input[@name='pw']"),"Password");
		entertext(password,"Password",Password);
		
		
		
		WebElement login = findElement(By.xpath("//input[@value='Log In']"),"Login");
		buttonClick(login,"Login");
		
		return driver;
    }
    /* Name: logout()
	 * Description:Reusable function to logout  the salesforce application
	 * Arguments:none
	 * Date of creation:03/05/2019
	 */
	
public static void logout() {
	WebElement userdd = findElement(By.xpath("//div[@id='userNav-arrow']"),"User Dropdown");
	buttonClick(userdd,"User Dropdown");
	
	WebElement logout =findElement(By.xpath("//a[@title='Logout']"),"Logout");
	buttonClick(logout,"Logout");
	

}
/* Name: getResult()
 * Description:Its a testNG aftermethod to update the results after each method, quit driver and end the report logger
 * Arguments:none
 * Date of creation:03/10/2019
 */

@AfterMethod
public void getResult(ITestResult result)
{
    if(result.getStatus()==ITestResult.FAILURE)
    {
        logger.log(LogStatus.FAIL, result.getThrowable());

    }
    driver.quit();
	report.endTest(logger);
	report.flush();
	System.out.println("End");
    
}

/*public static String  readExcelData(String value) throws IOException{
	String dt_path = "/Users/Naveen/Documents/Salesforce.xls";
	File xlfile = new File(dt_path);
	FileInputStream xlDoc = new FileInputStream(xlfile);
	HSSFWorkbook wb = new HSSFWorkbook(xlDoc);
	HSSFSheet sheet = wb.getSheet("sheet1");
	int rowcount = sheet.getLastRowNum();
	//int colcount = sheet.getRow(0).getLastCellNum();
	String uname = "";
	for(int i = 0;i<rowcount;i++) {

		String cellValue = sheet.getRow(0).getCell(0).getStringCellValue();
		if(cellValue.equalsIgnoreCase(value)){
			uname = sheet.getRow(0).getCell(1).getStringCellValue();
			
		}
	
	return uname;
}*/
}
