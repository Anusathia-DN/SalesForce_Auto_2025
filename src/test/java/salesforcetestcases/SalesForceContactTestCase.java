package salesforcetestcases;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Random;

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
import salesforcepageobjects.SalesforceHomePage;
import salesforcepageobjects.UserMenuSalesforcePage;
import salesforceutils.CommonUtils;
import salesforceutils.ReadConfigFileutils;
import salesforceutils.WaitUtils;


@Listeners(TestListeners.class)
public class SalesForceContactTestCase extends BaseTest {
	

	WebDriver driver;
	UserMenuSalesforcePage um;
	SDFCSalesforceLoginPage lp;
	SalesforceHomePage hp;
	SDFCCreateAccountPage ca;
	SalesForceCreateOppurtunityPage copp;
	SalesForceLeadsPage leads;
	SalesForceContactPage cp;
	
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
		driver.get(lp.baseurl(driver));
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void postcond() throws FileNotFoundException, IOException 
	{
	driver.quit();
	}
	
	@Test(enabled=true,priority=1)
	public void create_new_contact_TC25(Method name) throws FileNotFoundException, IOException
	{
		test=report.createTest(name.getName());
		lp.logintosalesforce(driver);
		WaitUtils.waitForElement(driver, hp.Usermenu);
		assertTrue(hp.verifyusername(driver),"user_credential Verified");
		cp.contactstab.click();
		assertTrue(cp.verifycontacthome(driver),"Contact Home page verified");
		//System.out.println("contact homepage:"+driver.getTitle());
		cp.contact_new_button.click();
		assertTrue(cp.verify_newcontact_page(driver),"New Contact Page Verified");
		//System.out.println("new Contactpage:"+driver.getTitle());
		cp.contact_new_lastname.clear();
		//String randomreportname = "Anu"+ new Random().nextInt(1000);
		cp.contact_new_lastname.sendKeys(ReadConfigFileutils.readfromcontactpropertiesfile("contactnew.lastname"));
		cp.contact_acc_name.click();
		cp.accountname_lookup_icon(driver);
		
		//cp.contact_acc_name.sendKeys(ReadConfigFileutils.readfromcontactpropertiesfile("contactnew.accountname"));
		cp.contact_new_savebutton.click();
		assertTrue(cp.verify_newcontact_table(driver));
		//System.out.println("new contactpage:"+driver.getTitle());
		CommonUtils.capturescreenshots(driver,name.getName());
	}

	@Test(enabled=true,priority=2)
	public void create_newview_incontact_TC26(Method name) throws FileNotFoundException, IOException, InterruptedException
	{
		test=report.createTest(name.getName());
		lp.logintosalesforce(driver);
		WaitUtils.waitForElement(driver, hp.Usermenu);
		assertTrue(hp.verifyusername(driver),"user_credential Verified");
		cp.contactstab.click();
		assertTrue(cp.verifycontacthome(driver),"Contact Home page verified");
		cp.contactcreatenewviewtab.click();
		cp.createview(driver);
		
		assertTrue(cp.verifycreateviewtabledisp(driver),"Newly created view details displayed");
		//WaitUtils.waitForElement(driver, cp.createviewdropdwn);
		//Thread.sleep(1000);
		//cp.verifycreateviewuser(driver);
		CommonUtils.capturescreenshots(driver,name.getName());
//		cp.contactviewname.sendKeys();
//		cp.contactunqname.sendKeys();
//		cp.savebutton.click();
	}

	@Test(enabled=true,priority=3)
	public void check_recentlycreated_contact_TC27(Method name) throws FileNotFoundException, IOException, InterruptedException
	{
		test=report.createTest(name.getName());
		lp.logintosalesforce(driver);
		WaitUtils.waitForElement(driver, hp.Usermenu);
		assertTrue(hp.verifyusername(driver),"user_credential Verified");
		cp.contactstab.click();
		assertTrue(cp.verifycontacthome(driver),"Contact Home page verified");
		WaitUtils.waitForElement(driver, cp.recentlycreatedropdwn);
		assertTrue(cp.verify_recentlycreated(driver),"Verified Recently Created");
		CommonUtils.capturescreenshots(driver,name.getName());
	}
	@Test(enabled=true,priority=4)
	public void check_mycontactsview_contact_TC28(Method name) throws FileNotFoundException, IOException, InterruptedException
	{
		test=report.createTest(name.getName());
		lp.logintosalesforce(driver);
		WaitUtils.waitForElement(driver, hp.Usermenu);
		assertTrue(hp.verifyusername(driver),"user_credential Verified");
		cp.contactstab.click();
		assertTrue(cp.verifycontacthome(driver),"Contact Home page verified");
		WaitUtils.waitForElement(driver, cp.contactshomedropdwn);
		assertTrue(cp.verifymycontacts(driver),"verified Dropdown in MyContacts page");
		CommonUtils.capturescreenshots(driver,name.getName());
}
	@Test(enabled=true,priority=5)
	public void mycontactsview_contact_TC29(Method name) throws FileNotFoundException, IOException, InterruptedException
	{
		test=report.createTest(name.getName());
		lp.logintosalesforce(driver);
		WaitUtils.waitForElement(driver, hp.Usermenu);
		assertTrue(hp.verifyusername(driver),"user_credential Verified");
		cp.contactstab.click();
		assertTrue(cp.verifycontacthome(driver),"Contact Home page verified");
		//cp.firstuserdate.click();
		assertTrue(cp.verifycontactnamedisp(driver),"Failed to verify mycontacts details display");
		//,"Verified Mycontacts details dispalyed");
		CommonUtils.capturescreenshots(driver,name.getName());
	}
	@Test(enabled=true,priority=6)
	public void errorin_contactsview_TC30(Method name) throws FileNotFoundException, IOException, InterruptedException
	{
		
		test=report.createTest(name.getName());
		lp.logintosalesforce(driver);
		WaitUtils.waitForElement(driver, hp.Usermenu);
		assertTrue(hp.verifyusername(driver),"user_credential Verified");
		cp.contactstab.click();
		assertTrue(cp.verifycontacthome(driver),"Contact Home page verified");
		cp.contactcreatenewviewtab.click();
		cp.contactunqname.sendKeys("EFGH");
		cp.savebutton.click();
		assertTrue(cp.verifycreatenewviewerror(driver));
		CommonUtils.capturescreenshots(driver,name.getName());
	}
	@Test(enabled=true,priority=7)
	public void check_cancelbutton_createview_TC31(Method name) throws FileNotFoundException, IOException, InterruptedException
	{
		test=report.createTest(name.getName());
		lp.logintosalesforce(driver);
		WaitUtils.waitForElement(driver, hp.Usermenu);
		assertTrue(hp.verifyusername(driver),"user_credential Verified");
		cp.contactstab.click();
		assertTrue(cp.verifycontacthome(driver),"Contact Home page verified");
		cp.contactcreatenewviewtab.click();
		cp.contactviewname.sendKeys("ABCD");
		cp.contactunqname.sendKeys("EFGH");
		cp.createviewcancelbutton.click();
		//System.out.println("after cancel page title:"+driver.getTitle());
		assertTrue(cp.verifycreateview_cancelbutton(driver));
		CommonUtils.capturescreenshots(driver,name.getName());
	}
	@Test(enabled=true,priority=8)
	public void check_saveandnewbutton_newcontact_TC32(Method name) throws FileNotFoundException, IOException, InterruptedException
	{
		test=report.createTest(name.getName());
		lp.logintosalesforce(driver);
		WaitUtils.waitForElement(driver, hp.Usermenu);
		assertTrue(hp.verifyusername(driver),"user_credential Verified");
		cp.contactstab.click();
		assertTrue(cp.verifycontacthome(driver),"Contact Home page verified");
		cp.contact_new_button.click();
		cp.contact_new_lastname.sendKeys("Indian");
		cp.accname_textbox.sendKeys("Global Medi");
		cp.saveandnewbutton.click();
		System.out.println("after saveand new click:"+driver.getTitle());
		assertTrue(cp.verify_newcontact_page(driver),"no new contact page");
		assertTrue(cp.verify_newcontact_table(driver),"no new data displayed");
		CommonUtils.capturescreenshots(driver,name.getName());
	}
	
}
