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
import salesforcepageobjects.SalesforceHomePage;
import salesforcepageobjects.UserMenuSalesforcePage;
import salesforceutils.CommonUtils;
import salesforceutils.ReadConfigFileutils;
import salesforceutils.WaitUtils;


@Listeners(TestListeners.class)
public class SalesForceCreateOppurtunityTestCase extends BaseTest {
	
	WebDriver driver;
	UserMenuSalesforcePage um;
	SDFCSalesforceLoginPage lp;
	SalesforceHomePage hp;
	SDFCCreateAccountPage ca;
	SalesForceCreateOppurtunityPage copp;
	
	@BeforeMethod
	public void precond() throws FileNotFoundException, IOException 
	{
		driver=BaseTest.getBrowserDriver("chrome", false);
		um=new UserMenuSalesforcePage(driver);
		hp=new SalesforceHomePage(driver);
		lp=new SDFCSalesforceLoginPage(driver);
		ca=new SDFCCreateAccountPage(driver);
		copp=new SalesForceCreateOppurtunityPage(driver);
		driver.get(lp.baseurl(driver));
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void postcond() throws FileNotFoundException, IOException 
	{
	driver.quit();
	}
	@Test(priority=1)
	public void oppurtunityhomepage_TC15(Method name) throws FileNotFoundException, IOException
	{
		test=report.createTest(name.getName());
		lp.logintosalesforce(driver);
		WaitUtils.waitForElement(driver, hp.Usermenu);
		assertTrue(hp.verifyusername(driver),"user_credential Verified");
		WaitUtils.waitForElement(driver, copp.oppurtunitytab);
		copp.oppurtunitytab.click();
		copp.verifyopppagetitle(driver);
		WaitUtils.waitForElement(driver, copp.oppdropdown);
		copp.verifyoppdrop(driver);
		CommonUtils.capturescreenshots(driver,name.getName());
	}
	@Test(priority=2)
	public void createnewoppurtunity_TC16(Method name) throws FileNotFoundException, IOException
	{
		test=report.createTest(name.getName());
		lp.logintosalesforce(driver);
		WaitUtils.waitForElement(driver, hp.Usermenu);
		assertTrue(hp.verifyusername(driver),"user_credential Verified");
		WaitUtils.waitForElement(driver, copp.oppurtunitytab);
		copp.oppurtunitytab.click();
		assertTrue(copp.verifyopppagetitle(driver),"Verified oppurtunity page");
		copp.oppnewbutton.click();
		WaitUtils.waitForElement(driver, copp.oppname);
		assertTrue(copp.verifyoppeditpage(driver),"Verified oppurtunityEdit page");
		copp.oppname.clear();
		copp.oppname.sendKeys(ReadConfigFileutils.readfromcreateoppurtunitypropertiesfile("opportunity.name"));
		copp.accountname.clear();
		//copp.accountname.sendKeys(ReadConfigFileutils.readfromcreateoppurtunitypropertiesfile("account.name"));
		copp.closedate(driver);
		copp.oppstagedropdown(driver);
		copp.probability.sendKeys("0");
		copp.leadsourcedropdown(driver);
		copp.pricampsource.clear();
		copp.pricampsource.sendKeys(" ");
		copp.savebutton.click();
		//WaitUtils.waitForElement(driver, copp.);
		//System.out.println("Final page"+driver.getTitle());
		//assertTrue(copp.verifyfinalopppage(driver));
		//copp.closedate.click();
		CommonUtils.capturescreenshots(driver,name.getName());
		
	}
	@Test(priority=3)
	public void testoppurtunitypipelinereport_TC17(Method name) throws FileNotFoundException, IOException
	{
		test=report.createTest(name.getName());
		lp.logintosalesforce(driver);
		WaitUtils.waitForElement(driver, hp.Usermenu);
		assertTrue(hp.verifyusername(driver),"user_credential Verified");
		WaitUtils.waitForElement(driver, copp.oppurtunitytab);
		copp.oppurtunitytab.click();
		assertTrue(copp.verifyopppagetitle(driver),"Verified oppurtunity page");
		copp.opp_pipeline.click();
		assertTrue(copp.verifyopp_pipelinepage(driver),"verified opp_pipeline page");
		CommonUtils.capturescreenshots(driver,name.getName());
	}
	@Test(priority=4)
	public void stuckoppurtunity_TC18(Method name) throws FileNotFoundException, IOException
	{
		test=report.createTest(name.getName());
		lp.logintosalesforce(driver);
		WaitUtils.waitForElement(driver, hp.Usermenu);
		assertTrue(hp.verifyusername(driver),"user_credential Verified");
		WaitUtils.waitForElement(driver, copp.oppurtunitytab);
		copp.oppurtunitytab.click();
		assertTrue(copp.verifyopppagetitle(driver),"Verified oppurtunity page");
		copp.stuckopptab.click();
		assertTrue(copp.verifystuckopppage(driver));
		CommonUtils.capturescreenshots(driver,name.getName());
		//System.out.println("Stuckopp page"+driver.getTitle());
	}
	@Test(priority=5)
	public void testquaterlyreport_TC19(Method name) throws FileNotFoundException, IOException, InterruptedException
	{
		test=report.createTest(name.getName());
		lp.logintosalesforce(driver);
		WaitUtils.waitForElement(driver, hp.Usermenu);
		assertTrue(hp.verifyusername(driver),"user_credential Verified");
		WaitUtils.waitForElement(driver, copp.oppurtunitytab);
		copp.oppurtunitytab.click();
		assertTrue(copp.verifyopppagetitle(driver),"Verified oppurtunity page");
		assertTrue(copp.verifyallquaterlysummary(driver),"verified all oppurtunity page");
		WaitUtils.waitForElement(driver, copp.quaterlyinclude);
		assertTrue(copp.verifyopenquaterlysummary(driver),"verified open oppurtunity page");
		WaitUtils.waitForElement(driver, copp.quaterlyinclude);
		assertTrue(copp.verifyclosedquaterlysummary(driver),"verified closed oopurtunity page");
		CommonUtils.capturescreenshots(driver,name.getName());
	}
}
