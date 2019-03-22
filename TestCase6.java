package sftc;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
//import org.testng.annotations.Test;

//import SalesForceTestCaseReports.TestCase5Report;

public class TestCase6 extends TestEntryClass {
	
	
	@Test
	@Parameters({"url","Username","Password","Firstname","Lastname","Postmsg"})
	public static void testCase6(String url,String Username,String Password, String Firstname, String Lastname, String Postmsg) throws InterruptedException {
		
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		path = "/Users/Naveen/Documents/QAReports/TestCase6.html";
		Launch(url,path);
		
		logger = report.startTest("TC06");
		
		TestEntryClass.LoginSalesForce(Username,Password);
		
		Thread.sleep(2000);
		windowHandler(driver);
		
		Thread.sleep(2000);
		windowHandler(driver);
		
			
		driver = MyProfiles();
		driver = testStep4(Firstname, Lastname);
		driver = testStep5(Postmsg);
		driver = testStep6();
		driver = testStep7();
		
		
		
		
		
	}
	
	public static WebDriver testStep7() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[text()='Moderator']"))).perform();
		
		WebElement addphoto = findElement(By.xpath(".//*[@id='uploadLink']"),"Add photo link");
		buttonClick(addphoto,"Add photo link");
		
		Thread.sleep(5000);
		
		WebElement frame = findElement(By.id("uploadPhotoContentId"),"Frame");
		driver.switchTo().frame(frame);
		Thread.sleep(5000);
		
		WebElement choosepic = findElement(By.xpath(".//*[@id='j_id0:uploadFileForm:uploadInputFile']"),"choose file");
		buttonClick(choosepic,"Choose pic button");
		choosepic.sendKeys("/Users/Naveen/Desktop/panda.jpeg");
		
		WebElement savePhoto = findElement(By.xpath(".//*[@id='j_id0:uploadFileForm:uploadBtn']"),"Save button");
		buttonClick(savePhoto," Save button");
		
		Thread.sleep(5000);
		Actions action1 = new Actions(driver);
		action1.dragAndDropBy(driver.findElement(By.xpath(".//*[@id='j_id0:outer']/div[1]/div/div/div/div[6]")), 100, 20);
		driver.findElement(By.xpath(".//*[@id='j_id0:j_id7:save']")).click(); 
		driver.switchTo().defaultContent();
		
		return driver;
	}

	@Test(dependsOnMethods= {"MyProfiles"},priority = 3)
	public static WebDriver testStep6() throws InterruptedException {
		Thread.sleep(3000);
		WebElement File_link = findElement(By.xpath("//*[@id='publisherAttachContentPost']/span[1]"),"File link");
		buttonClick(File_link, "File Link");
		
		Thread.sleep(5000);
		WebElement upload = findElement(By.xpath("//a[@id='chatterUploadFileAction']"),"upload button");
		buttonClick(upload,"Upload button");
		
		Thread.sleep(5000);
		WebElement Choose = findElement(By.xpath("//input[@id='chatterFile']"),"Choose file");
		buttonClick(Choose,"Choose file");
		Choose.sendKeys("/Users/Naveen/Documents/reverse_list.py");
		
		Thread.sleep(3000);
		WebElement share_btn = findElement(By.xpath("//input[@id='publishersharebutton']"),"Share button");
		buttonClick(share_btn,"Share button");
		
		Thread.sleep(3000);
		
		
		
		return driver;
	}

	@Test(dependsOnMethods= {"MyProfiles"},priority = 2)
	
	public static WebDriver testStep5(String Postmsg) throws InterruptedException {
		// TODO Auto-generated method stub
		WebElement postbtn = findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'Post')]"),"Post Button");
		buttonClick(postbtn,"Post Button");
		
		WebElement post_txtbx_click = findElement(By.xpath("/html[1]/body[1]"),"Post TextBox");
		buttonClick(post_txtbx_click,"post textbox Button");
		
		//WebElement post_txtbx = findElement(By.xpath(""),"Post Textbox");
		driver.switchTo().frame(0);
		WebElement post_txtbx = findElement(By.xpath("/html[1]/body[1]"),"Post textBox");
		post_txtbx.clear();
		entertext(post_txtbx,"Post TextBox",Postmsg);
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		WebElement sharebtn = findElement(By.xpath(".//*[@id='publishersharebutton']"),"Share Button");
		buttonClick(sharebtn,"Share Button");
		return driver;
	}

	@Test
	public static WebDriver MyProfiles() throws InterruptedException {
		
		WebElement userdd = findElement(By.xpath("//div[@id='userNav-arrow']"),"User Dropdown");
		buttonClick(userdd,"User Dropdown");
		
		WebElement my_prfl = findElement(By.xpath("//a[@title='My Profile']"),"My Profile");
		buttonClick(my_prfl,"My Profile");
		
		
		
		
		compareStrings(driver.getCurrentUrl(),("https://na85.salesforce.com/_ui/core/userprofile/UserProfilePage?tab=sfdc.ProfilePlatformFeed")); 
		return driver;
	}
	
	@Test(dependsOnMethods= {"MyProfiles"},enabled=false,priority = 1)
	
	public static WebDriver testStep4(String Firstname,String Lastname) throws InterruptedException {
		

		WebElement edit_contact = findElement(By.xpath(".//*[@id='chatterTab']/div[2]/div[2]/div[1]/h3/div/div/a/img"), "Edit Contact");
		buttonClick(edit_contact,"Edit Contact");
		
		driver.switchTo().frame("contactInfoContentId");
		
		WebElement about_btn = findElement(By.xpath(".//*[@id='aboutTab']/a"),"About button");
		buttonClick(about_btn,"About button");
		String fntextval = Firstname;
		String lntextval = Lastname;
		WebElement fname = findElement(By.xpath("//input[@id='firstName']"),"First name");
		entertext(fname,"First Name",fntextval);
		WebElement lname = findElement(By.xpath("//input[@id='lastName']"),"Last name");
		entertext(lname,"Last name",lntextval);
		String FullName = (fntextval+" "+lntextval);
		System.out.println(FullName);
		WebElement saveall = findElement(By.xpath("//input[@value='Save All']"),"Save all");
		buttonClick(saveall,"Save all");
		
		/*Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		
		WebElement profile_name = driver.findElement(By.id("tailBreadcrumbNode"));
		String s1 = profile_name.getText();
		
		compareStrings(s1,FullName);*/
		
		return driver;
	
	}

}
