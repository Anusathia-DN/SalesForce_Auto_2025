package salesforcetestcases;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import listeners.TestListeners;
import salesforcepageobjects.SDFCSalesforceLoginPage;
import salesforcepageobjects.SalesforceHomePage;
import salesforcepageobjects.UserMenuSalesforcePage;
import salesforceutils.CommonUtils;
import salesforceutils.ReadConfigFileutils;
import salesforceutils.WaitUtils;

@Listeners(TestListeners.class)
public class SalesForceUserMenuTestCase extends BaseTest {
	
	//WebDriver driver;
//	UserMenuSalesforcePage um;
//	SDFCSalesforceLoginPage lp;
//	SalesforceHomePage hp;
	//static String downloadPath = "C:\\Users\\anura_1ckmn7y\\Downloads";
//	@BeforeMethod()
//	public void precond(Method name) throws FileNotFoundException, IOException 
//	{
//		//BaseTest.setdriver("chrome", false);
//		test=report.createTest(name.getName());
//		threadtest.set(test);
//		//driver=BaseTest.getBrowserDriver("chrome", false);
//		driver=BaseTest.getbrowser();
//		//BaseTest.setdriver("chrome", false);
//		um=new UserMenuSalesforcePage(driver);
//		hp=new SalesforceHomePage(driver);
//		lp=new SDFCSalesforceLoginPage(driver);
//		driver.get(lp.baseurl(driver));
//		driver.manage().window().maximize();
//	}
//	@AfterMethod
//	public void postcond() throws FileNotFoundException, IOException 
//	{
//		threadlocaldriver.remove();
//	driver.quit();
//	
//	}
	@Test(enabled=false,priority=1)
	public void usermenudropdown_TC05(Method name) throws InterruptedException, FileNotFoundException, IOException
	{
		test=report.createTest(name.getName());
		//driver.get(ReadConfigFileutils.readfromloginpropertiesfile("base.url"));
		driver=BaseTest.getbrowser();
		//BaseTest.setdriver("chrome", false);
		um=new UserMenuSalesforcePage(driver);
		hp=new SalesforceHomePage(driver);
		lp=new SDFCSalesforceLoginPage(driver);
		driver.get(lp.baseurl(driver));
		driver.manage().window().maximize();
		
		lp.logintosalesforce(driver);
		WaitUtils.waitForElement(driver, um.usermenu);
		//Thread.sleep(1000);
		um.usermenu.click();
		
		assertTrue(hp.verifyusermenulist(driver),"UserMenu List Not displayed");
		
		CommonUtils.capturescreenshots(driver,name.getName());
		//driver.quit();
			
		}
	@Test(enabled=false,priority=2)
	private void abouttab_TC05(Method name) throws InterruptedException, FileNotFoundException, IOException 
	{
		test=report.createTest(name.getName());
		//driver=BaseTest.getBrowserDriver("chrome", false);
		//driver=BaseTest.getbrowser();
		driver=BaseTest.getbrowser();
		//BaseTest.setdriver("chrome", false);
		um=new UserMenuSalesforcePage(driver);
		hp=new SalesforceHomePage(driver);
		lp=new SDFCSalesforceLoginPage(driver);
		driver.get(lp.baseurl(driver));
		driver.manage().window().maximize();
		
		lp.logintosalesforce(driver);
		WaitUtils.waitForElement(driver, um.usermenu);
		//Thread.sleep(1000);
		um.usermenu.click();
		assertTrue(hp.verifyusermenulist(driver),"UserMenu verified");
		um.myprofile.click();
		assertTrue(um.verifyprofilepage(driver), "Profile Page Verified");
		//System.out.println("profile page title"+driver.getCurrentUrl());
	//Click Edit Button	
		WaitUtils.waitForElement(driver, um.myprofile_edit);
		um.myprofile_edit.click();
		
		
		um.editprofile(driver);
		assertTrue(um.verifytabs(driver),"About And Contact Tabs are Displayed");
		//um.verifyprofilepage(driver);
		//um.verifyprofileditpagetabs(driver);
		assertTrue(um.verifyeditpage(driver),"EditProfile Pop-Up is Displayed");
		assertTrue(um.verifyaboutlastname(driver),"Lastname Is Updated correctly");
		WaitUtils.waitForElement(driver,um.postlink);
		//Thread.sleep(1000);
		um.postlink.click();
		//WebElement postiframe= driver .findElement(By.xpath("//iframe[contains(@title,'Rich Text Editor, publisherRichTextEditor')]"));
		driver.switchTo().frame(um.postiframe);
		System.out.println("Inside PostText Frame");
		um.posttext.click();
		um.posttext.sendKeys(ReadConfigFileutils.readfromusermenupropertiesfile("posttext.send"));;
		driver.switchTo().parentFrame();
		System.out.println("Out Of PostText Iframe");
		um.posttextsharebutton.click();
		WaitUtils.waitForElement(driver, um.uploadfilelink);
		//driver.findElement(By.xpath("//*[@id=\"publishersharebutton\"]")).click();
		Thread.sleep(1000);
	//Uploading a File 
		  //WebElement FileLink = driver.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'File')]"));
		  um.uploadfilelink.click();
		  System.out.println("Clicked on filelink");
		 // WebElement UploadFile = driver.findElement(By.xpath("//a[@id='chatterUploadFileAction']"));
		  um.uploadfilebutton.click();
		  System.out.println("clicked on uploadfile button on computer");
		  WaitUtils.waitForElement(driver, um.choosefile);
		  um.choosefile.sendKeys(ReadConfigFileutils.readfromusermenupropertiesfile("choosefile.profile"));
		  Thread.sleep(1000);
		  WaitUtils.waitForElement(driver, um.uploadphotoonmousehover);
		//  um.uploadphotoonmousehover
		  Actions action=new Actions(driver);
		  action.moveToElement(um.uploadphotoonmousehover).build().perform();
		 // um.uploadphotobutton.click();
		  um.uploadphotobutton.click();
		  System.out.println("uploadphoto button clicked");
		  WebElement photoiframe= driver .findElement(By.xpath("//iframe[@id='uploadPhotoContentId']"));
		  driver.switchTo().frame(photoiframe);//iframe[@id='uploadPhotoContentId'
		  System.out.println("Inside iframe upload photo");
		  um.uploadphotochoosefile.sendKeys("C:\\Users\\anura_1ckmn7y\\OneDrive\\Desktop\\TecharchSeleniumAutomation\\SeleniumAssignments\\TestCasesExcel\\Pink_flower.jpg");
		  um.uploadphotosavebutton.click();
		  WaitUtils.waitForElement(driver, um.cropphotosavebutton);
		  um.cropphotosavebutton.click();
		  System.out.println("Out of iframe photo upload");
		  driver.switchTo().parentFrame();
		  System.out.println("Back to Parent Frame");
		  CommonUtils.capturescreenshots(driver,name.getName());
		
	}
	@Test(enabled=true,priority=3)
	public void mysettingoption_TC07(Method name) throws InterruptedException, FileNotFoundException, IOException
	{
		//driver=BaseTest.getBrowserDriver("chrome", false);
		//driver=BaseTest.getbrowser();
		test=report.createTest(name.getName());
		driver=BaseTest.getbrowser();
		//BaseTest.setdriver("chrome", false);
		um=new UserMenuSalesforcePage(driver);
		hp=new SalesforceHomePage(driver);
		lp=new SDFCSalesforceLoginPage(driver);
		driver.get(lp.baseurl(driver));
		driver.manage().window().maximize();
		lp.logintosalesforce(driver);
		WaitUtils.waitForElement(driver, um.usermenu);
		um.usermenu.click();
		hp.verifyusermenulist(driver);
	//MySetting click
		um.mysettingstab.click();
		assertTrue(um.verifymysettingdisp(driver),"My setting page verified");
	
	//PersonalTab click
		um.personaltab.click();
	//LoginHistory click
		um.loginhistory.click();
		
		//driver.findElement(By.xpath("//*[@id=\"LoginHistory_font\"]")).click();
	//Download History
		//WebElement downloadhist=driver.findElement(By.xpath("//*[@id=\"RelatedUserLoginHistoryList_body\"]/div/a"));
		um.downloadhist.click();
		WaitUtils.waitForElement(driver, um.downloadhist);
		assertTrue(um.verifyloginhistorydwnld(driver),"Downloded Loginhistory verified");
	//Display LayoutTab click
		um.displaylayout.click();
		//driver.findElement(By.id("DisplayAndLayout_font")).click();
		//Thread.sleep(1000);
	//Custom Tab Click
		WaitUtils.waitForElement(driver, um.customtab);
		//driver.findElement(By.id("CustomizeTabs_font")).click();
		um.customtab.click();
	//CustomApp Dropdown
		WaitUtils.waitForElement(driver, um.customappdropdwn);
		//um.customappdropdwn.click();
		//WebElement dropdown=driver.findElement(By.id("p4"));
		//dropdown.click();
		Select customapp=new Select(um.customappdropdwn);
		customapp.selectByVisibleText("Salesforce Chatter");
		System.out.println("Customapp was selected");
	//AvailableTab Dropdown
		//WebElement availabletab=driver.findElement(By.xpath("//*[@id=\"duel_select_0\"]"));
		//um.availabletab.click();
		Select availdropdown = new Select(um.availabletab); 
		availdropdown.selectByVisibleText("Reports");
	//Add Available Tabs and Save	//availdropdown.s
		um.addbutton.click();
		//Thread.sleep(1000);
		um.selectedtabsavebutton.click();
		assertTrue(um.verifyreporttabadded(driver),"Report Tab Is not available SelectDropDown");
		//Thread.sleep(1000);
		//WaitUtils.waitForElement(driver, um.mysettingstoptab);
		assertTrue(um.verifyreoprtabdisplayed(driver),"Report Tab not displayed in selected tab ");
		System.out.println("Report option is selected");
		
		
		WaitUtils.waitForElement(driver, um.homepagebutton);
		um.homepagebutton.click();
		//um.moretabs.click();
		assertTrue(um.verifyreportdisphome(driver),"Reports Tab Present in Homepage");
		assertTrue(um.verifyreportinsalesmarkettab(driver),"Report Tab Present in Sales");
		WaitUtils.waitForElement(driver, um.usermenu);
		um.usermenu.click();
		um.mysettingstab.click();
		um.displaylayout.click();
		um.customtab.click();
		WaitUtils.waitForElement(driver, um.customappdropdwn);
		Select customapp1=new Select(um.customappdropdwn);
		customapp1.selectByVisibleText("Salesforce Chatter");
		um.releasereportselection(driver);
	//Checking Email Setup	
		um.emailbutton.click();
		um.emailsettings.click();
		um.emailsetup(driver);
		assertTrue(um.verifyemailsettext(driver),"Email Setup Saved Text Displayed");
	//Checking Calender Setup
		um.calenderandreminderbutton.click();
		um.calenderactivity.click();
		um.opentestreminder.click();
		//um.calenderopenwindow(driver);
		assertTrue(um.verifycalenderopenwindow(driver),"Verified Calender Popup Window Opened");
		CommonUtils.capturescreenshots(driver,name.getName());
				
		}
	@Test(enabled=false,priority=4)	
	public void developerconsole_TC08(Method name) throws InterruptedException, FileNotFoundException, IOException
	{
		//driver=BaseTest.getBrowserDriver("chrome", false);
		//driver=BaseTest.getbrowser();
		test=report.createTest(name.getName());
		driver=BaseTest.getbrowser();
		//BaseTest.setdriver("chrome", false);
		um=new UserMenuSalesforcePage(driver);
		hp=new SalesforceHomePage(driver);
		lp=new SDFCSalesforceLoginPage(driver);
		driver.get(lp.baseurl(driver));
		driver.manage().window().maximize();
		lp.logintosalesforce(driver);
		WaitUtils.waitForElement(driver, um.usermenu);
		um.usermenu.click();
		hp.verifyusermenulist(driver);
	//DeveloperConsole click
		um.developerconsolebutton.click();
		assertTrue(um.verifydeveloperconsole(driver),"Developer console verified");
		
		CommonUtils.capturescreenshots(driver,name.getName());
	}
	
	@Test(enabled=false,priority=5)	
	public void logout_TC09(Method name) throws InterruptedException, FileNotFoundException, IOException
	{
		//driver=BaseTest.getBrowserDriver("chrome", false);
		//driver=BaseTest.getbrowser();
		test=report.createTest(name.getName());
		driver=BaseTest.getbrowser();
		//BaseTest.setdriver("chrome", false);
		um=new UserMenuSalesforcePage(driver);
		hp=new SalesforceHomePage(driver);
		lp=new SDFCSalesforceLoginPage(driver);
		driver.get(lp.baseurl(driver));
		driver.manage().window().maximize();
		lp.logintosalesforce(driver);
		WaitUtils.waitForElement(driver, um.usermenu);
		um.usermenu.click();
		hp.verifyusermenulist(driver);
		um.logout.click();
		CommonUtils.capturescreenshots(driver,name.getName());
	}
	
		
}
	



