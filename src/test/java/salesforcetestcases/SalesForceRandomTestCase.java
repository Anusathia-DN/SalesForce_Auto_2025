package salesforcetestcases;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import listeners.TestListeners;
import salesforcepageobjects.SDFCCreateAccountPage;
import salesforcepageobjects.SDFCSalesforceLoginPage;
import salesforcepageobjects.SalesForceContactPage;
import salesforcepageobjects.SalesForceCreateOppurtunityPage;
import salesforcepageobjects.SalesForceLeadsPage;
import salesforcepageobjects.SalesForceRandomPage;
import salesforcepageobjects.SalesforceHomePage;
import salesforcepageobjects.UserMenuSalesforcePage;
import salesforceutils.CommonUtils;
import salesforceutils.WaitUtils;



@Listeners(TestListeners.class)
public class SalesForceRandomTestCase extends BaseTest{
	
	
	WebDriver driver;
	UserMenuSalesforcePage um;
	SDFCSalesforceLoginPage lp;
	SalesforceHomePage hp;
	SDFCCreateAccountPage ca;
	SalesForceCreateOppurtunityPage copp;
	SalesForceLeadsPage leads;
	SalesForceContactPage cp;
	SalesForceRandomPage rp;
	
	
	
	@BeforeMethod
	public void precond() throws FileNotFoundException, IOException 
	{
		driver=BaseTest.getBrowserDriver("chrome", false);
		um=new UserMenuSalesforcePage(driver);
		hp=new SalesforceHomePage(driver);
		lp=new SDFCSalesforceLoginPage(driver);
		ca=new SDFCCreateAccountPage(driver);
		copp=new SalesForceCreateOppurtunityPage(driver);
		leads=new SalesForceLeadsPage(driver);
		cp=new SalesForceContactPage(driver);
		rp=new SalesForceRandomPage(driver);
		driver.get(lp.baseurl(driver));
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void postcond() throws FileNotFoundException, IOException 
	{
	driver.quit();
	}
	
	@Test(enabled=true,priority=1)
	public void firstandlastname_loggedinuser_TC33(Method name) throws FileNotFoundException, IOException
	{
		test=report.createTest(name.getName());
		lp.logintosalesforce(driver);
		WaitUtils.waitForElement(driver, hp.Usermenu);
		assertTrue(hp.verifyusername(driver),"user_credential Verification Failed");
		rp.homepagetab.click();
		//assertTrue(rp.verifyhomepage(driver),"Verified HomePage");
		WaitUtils.waitForElement(driver, rp.homefirstandlastname);
		
		//WaitUtils.waitForElement(driver, rp.userprofileusername);
		//System.out.println("user profile nextpage:"+driver.getWindowHandle());
		assertTrue(rp.verifyhome_currentstatususer(driver),"Verified profilepage with First_name and Last_name");
		CommonUtils.capturescreenshots(driver,name.getName());
	}
	@Test(enabled=true,priority=2)
	public void editedlastname_updated_TC34(Method name) throws FileNotFoundException, IOException
	{
		test=report.createTest(name.getName());
		lp.logintosalesforce(driver);
		WaitUtils.waitForElement(driver, hp.Usermenu);
		assertTrue(hp.verifyusername(driver),"user_credential Verified");
		rp.homepagetab.click();
		WaitUtils.waitForElement(driver, rp.homefirstandlastname);
		assertTrue(rp.verifyhomepage(driver),"HomePage is not Displayed");
		//String homepage=driver.getTitle();
		//System.out.println("homepage title:"+homepage);
		//rp.verifyhomepage(driver);
		rp.homefirstandlastname.click();
		WaitUtils.waitForElement(driver, um.myprofile_edit);
		//String profilepage=driver.getTitle();
		//System.out.println("profilepage title:"+profilepage);
		um.myprofile_edit.click();
		driver.switchTo().frame("contactInfoContentId");
		//assertTrue(rp.verifycontacttab(driver),"Contact Tab is Selected by Default");
		WaitUtils.waitForElement(driver, um.abouttab);
		um.abouttab.click();
		rp.aboutlastname(driver);
		//rp.verifyaboutlastname(driver);
		assertTrue(rp.verifyaboutlastname(driver),"The Last Name Failed To Display after Save");
		//assertTrue(um.verifyaboutlastname(driver));
		CommonUtils.capturescreenshots(driver,name.getName());
	}
	@Test(enabled=true,priority=3)
	public void verify_customizationtab_TC35(Method name) throws FileNotFoundException, IOException
	{
		test=report.createTest(name.getName());
		lp.logintosalesforce(driver);
		WaitUtils.waitForElement(driver, hp.Usermenu);
		assertTrue(hp.verifyusername(driver),"user_credential Verified");
		rp.usermenupageplustab.click();
		assertTrue(rp.verifyalltabpage(driver),"All_Tabs page not Dispalyed");
		rp.customizebutton.click();
		System.out.println("customize page"+driver.getTitle());
		assertTrue(rp.verifycustomizetab(driver));
		CommonUtils.capturescreenshots(driver,name.getName());
	}
	
	@Test(enabled=true,priority=4)
	public void blockingeventin_calender_TC36(Method name) throws FileNotFoundException, IOException, InterruptedException
	{
	
		test=report.createTest(name.getName());
		lp.logintosalesforce(driver);
		WaitUtils.waitForElement(driver, hp.Usermenu);
		assertTrue(hp.verifyusername(driver),"user_credential Verified");
		rp.homepagetab.click();
		WaitUtils.waitForElement(driver, rp.homefirstandlastname);
		assertTrue(rp.verifyhomepage(driver),"HomePage is not Displayed");
		WaitUtils.waitForElement(driver, rp.homedate);
		assertTrue(rp.verifydatetime(driver),"Failed to verify datetime");
		rp.homedate.click();
		
		WaitUtils.waitForElement(driver, rp.homedatetime);
		assertTrue(rp.verifycalenderpage(driver),"Failed to verify calender page");
		
		//driver.navigate().forward();
		rp.homedatetime.click();
		
		assertTrue(rp.verifycomboboxother(driver),"subject tab failed");
		//rp.verifycomboboxother(driver);
		WaitUtils.waitForElement(driver, rp.endtimedropdown);
		
		assertTrue(rp.verifyendtime(driver),"The EndTImes 9:00A.M and 11:30P.M are not dispalyed in the dropdown ");
		//,"The EndTImes 9:00A.M and 11:30P.M are not dispalyed in the dropdown");
		rp.timesavebutton.click();
		assertTrue(rp.verifytimeslotsnine(driver));
		CommonUtils.capturescreenshots(driver,name.getName());
	}

	@Test(enabled=true,priority=5)
	public void blockingeventin_weeklyreaccurance_TC37(Method name) throws FileNotFoundException, IOException, InterruptedException
	{

		test=report.createTest(name.getName());
		lp.logintosalesforce(driver);
		WaitUtils.waitForElement(driver, hp.Usermenu);
		assertTrue(hp.verifyusername(driver),"user_credential Verified");
		rp.homepagetab.click();
		WaitUtils.waitForElement(driver, rp.homefirstandlastname);
		assertTrue(rp.verifyhomepage(driver),"HomePage is not Displayed");
		assertTrue(rp.verifydatetime(driver));
		rp.homedate.click();
		assertTrue(rp.verifycalenderpage(driver),"Failed to verify calender page");
		rp.time4.click();
		assertTrue(rp.verifycomboboxother(driver),"subject tab failed");
		WaitUtils.waitForElement(driver, rp.endtimedropdown);
		
		assertTrue(rp.verifyendtime(driver),"The EndTImes 9:00A.M and 11:30P.M are not dispalyed in the dropdown ");
		//,"The EndTImes 9:00A.M and 11:30P.M are not dispalyed in the dropdown");
		rp.timesavebutton.click();
		assertTrue(rp.verifytimeslotsfour(driver));
		CommonUtils.capturescreenshots(driver,name.getName());
	}
	
}
