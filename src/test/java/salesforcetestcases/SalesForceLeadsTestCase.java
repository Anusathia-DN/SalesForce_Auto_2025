package salesforcetestcases;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import listeners.TestListeners;
import salesforcepageobjects.SDFCCreateAccountPage;
import salesforcepageobjects.SDFCSalesforceLoginPage;
import salesforcepageobjects.SalesForceCreateOppurtunityPage;
import salesforcepageobjects.SalesForceLeadsPage;
import salesforcepageobjects.SalesforceHomePage;
import salesforcepageobjects.UserMenuSalesforcePage;
import salesforceutils.CommonUtils;
import salesforceutils.ReadConfigFileutils;
import salesforceutils.WaitUtils;


@Listeners(TestListeners.class)
public class SalesForceLeadsTestCase extends BaseTest {
	
	WebDriver driver;
	UserMenuSalesforcePage um;
	SDFCSalesforceLoginPage lp;
	SalesforceHomePage hp;
	SDFCCreateAccountPage ca;
	SalesForceCreateOppurtunityPage copp;
	SalesForceLeadsPage leads;
	
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
		driver.get(lp.baseurl(driver));
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void postcond() throws FileNotFoundException, IOException 
	{
	driver.quit();
	}
	
	@Test(enabled=true,priority=1)
	public void leadsTab_TC20(Method name) throws FileNotFoundException, IOException
	{
		test=report.createTest(name.getName());
		lp.logintosalesforce(driver);
		WaitUtils.waitForElement(driver, hp.Usermenu);
		assertTrue(hp.verifyusername(driver),"user_credential Verified");
		leads.leadstab.click();
		assertTrue(leads.verifyleadshome(driver),"Verified Leads Homepage");
		CommonUtils.capturescreenshots(driver,name.getName());
		//System.out.println("leads page:"+driver.getTitle());
		
	}
	@Test(enabled=true,priority=2)
	public void leadsSelectView_TC21(Method name) throws FileNotFoundException, IOException
	{
		test=report.createTest(name.getName());
		lp.logintosalesforce(driver);
		WaitUtils.waitForElement(driver, hp.Usermenu);
		assertTrue(hp.verifyusername(driver),"user_credential Verified");
		leads.leadstab.click();
		assertTrue(leads.verifyleadshome(driver),"Verified Leads Homepage");
		WaitUtils.waitForElement(driver, leads.leadsdropdown);
		//leads.leadsdropdown.click();
		//assertTrue(leads.verifyleadsdropdown(driver),"verified leads dropdown");
		CommonUtils.capturescreenshots(driver,name.getName());
	}
	@Test(enabled=true,priority=3)
	public void defaultView_TC22(Method name) throws FileNotFoundException, IOException
	{
		test=report.createTest(name.getName());
		lp.logintosalesforce(driver);
		WaitUtils.waitForElement(driver, hp.Usermenu);
		assertTrue(hp.verifyusername(driver),"user_credential Verified");
		leads.leadstab.click();
		WaitUtils.waitForElement(driver, hp.Usermenu);
		assertTrue(leads.verifyleadshome(driver),"Verified Leads Homepage");
		leads.todaysleads(driver);
		leads.leadsgobutton.click();
		WaitUtils.waitForElement(driver, hp.Usermenu);
		assertTrue(hp.Logoutuser(driver),"Login page displayed after logout");
		WaitUtils.waitForElement(driver, lp.username);
		lp.logintosalesforce(driver);
		WaitUtils.waitForElement(driver, hp.Usermenu);
		assertTrue(hp.verifyusername(driver),"user_credential Verified");
		leads.leadstab.click();
		WaitUtils.waitForElement(driver, hp.Usermenu);
		assertTrue(leads.verifyleadshome(driver),"Verified Leads Homepage");
		//leads.todaysleads(driver);
		leads.leadsgobutton.click();
		
		//WaitUtils.waitForElement(driver, hp.Usermenu);
		//assertTrue(leads.verifyleadshome(driver),"Verified Leads Homepage");
		System.out.println("after final go button:"+driver.getCurrentUrl());
		//hp.Logoutuser(driver);
		CommonUtils.capturescreenshots(driver,name.getName());
	}
	@Test(enabled=true,priority=4)
	public void listitemtodayslead_TC23(Method name) throws FileNotFoundException, IOException
	{
		test=report.createTest(name.getName());
		lp.logintosalesforce(driver);
		WaitUtils.waitForElement(driver, hp.Usermenu);
		assertTrue(hp.verifyusername(driver),"user_credential Verified");
		leads.leadstab.click();
		WaitUtils.waitForElement(driver, hp.Usermenu);
		assertTrue(leads.verifyleadshome(driver),"Verified Leads Homepage");
		leads.todaysleads(driver);
		leads.leadsgobutton.click();
		assertTrue(leads.verifytodaysleadtable(driver),"Todays Leads data is displayed");
		CommonUtils.capturescreenshots(driver,name.getName());
	}
	@Test(enabled=true,priority=5)
	public void leadshome_new_TC24(Method name) throws FileNotFoundException, IOException
	{
		test=report.createTest(name.getName());
		lp.logintosalesforce(driver);
		WaitUtils.waitForElement(driver, hp.Usermenu);
		assertTrue(hp.verifyusername(driver),"user_credential Verified");
		leads.leadstab.click();
		WaitUtils.waitForElement(driver, hp.Usermenu);
		assertTrue(leads.verifyleadshome(driver),"Verified Leads Homepage");
		leads.leads_new_button.click();
		leads.leadsnew_lastname.sendKeys(ReadConfigFileutils.readfromleadspropertiesfile("leadsnew.lastname"));
		leads.leadsnew_companyname.sendKeys(ReadConfigFileutils.readfromleadspropertiesfile("leadsnew.comapnyname"));
		leads.leads_save_button.click();
		System.out.println("After Save buttonpage:"+driver.getTitle());
		assertTrue(leads.verifynewleadstabledisplay(driver),"Newly created Leads data is displayed");
		CommonUtils.capturescreenshots(driver,name.getName());
		
	}
	
	

}
