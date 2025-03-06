package salesforcetestcases;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import listeners.TestListeners;
import salesforcepageobjects.SalesforceHomePage;
import salesforcepageobjects.SDFCSalesforceLoginPage;

import salesforceutils.CommonUtils;
import salesforceutils.WaitUtils;


@Listeners(TestListeners.class)
public class SDFCLoginTestCase extends BaseTest {
	WebDriver driver;
	SDFCSalesforceLoginPage lp;
	//SalesforceHomePage hp;
	//UserMenuSalesforcePage um;
	//public String baseUrl=readconfig.getApplicationURL();
	@Test(priority=1)
	public void LoginErrorMessage_TC01(Method name) throws IOException {
		test=report.createTest(name.getName());
		//calling from Basetest for Threadlocal which is set in Baseclass
		
		  driver=BaseTest.getbrowser();
		//driver=BaseTest.getBrowserDriver("Chrome", false);
		lp=new SDFCSalesforceLoginPage(driver);
		hp=new SalesforceHomePage(driver);
		driver.get(lp.baseurl(driver));
		driver.manage().window().maximize();
		threadtest.get().log(Status.INFO, "Failed To Display Login Page");
		assertTrue(lp.verifyloginpage(driver),"Login Page Is not Displayed");
		lp.invalidlogin(driver);
		WaitUtils.waitForElement(driver, lp.errormsg);
		test.log(Status.INFO, "Failed To Display Login Error Message");
		assertTrue(lp.verifyerrormsg(driver),"Error Msg Not Displayed");
		CommonUtils.capturescreenshots(driver,name.getName());
		}

@Test(priority=2)
public void LoginToSalesForce_TC02(Method name) throws InterruptedException, FileNotFoundException, IOException {
	test=report.createTest(name.getName());
	assertTrue(lp.verifyloginpage(driver),"Login Page Is not Displayed");
	lp.logintosalesforce(driver);
	WaitUtils.waitForElement(driver,hp.Usermenu);
	threadtest.get().log(Status.INFO, "Failed To Display HomePage");
	assertTrue(lp.verifyhomepage(driver),"HomePage not displayed");
	lp=hp.Logoutuser(driver);
	CommonUtils.capturescreenshots(driver,name.getName());
	
	
}
@Test(priority=3)
public void CheckRemeberMe_TC03(Method name) throws InterruptedException, FileNotFoundException, IOException
{
	test=report.createTest(name.getName());
	WaitUtils.waitForElement(driver, lp.username);
	lp.validloginrememberme(driver);
	lp.rememberme.click();
	lp.Loginbutton.click();
	WaitUtils.waitForElement(driver, hp.Usermenu);
	hp.Logoutuser(driver);
	WaitUtils.waitForElement(driver, lp.remembermeusername);
	CommonUtils.capturescreenshots(driver,name.getName());
	
	
	
}
@Test(priority=4)
public void ForgotPassword_TC04A(Method name) throws InterruptedException, FileNotFoundException, IOException 
{
	 
	test=report.createTest(name.getName());
	lp.forgotpasswordlink.click();
	WaitUtils.waitForElement(driver, lp.forgotpassworduser);
	lp.forgotpassworduser.sendKeys(lp.forgotpassuser(driver));
	lp.forgotusercontinuebutton.click();
	WaitUtils.waitForElement(driver, lp.continuemailchk);
	assertTrue(lp.verifychkmailerror(driver),"Check Email Error Not Displayed");
	WaitUtils.waitForElement(driver, lp.returntologinbutton);
	lp.returntologinbutton.click();
	CommonUtils.capturescreenshots(driver,name.getName());
	
}
@Test(priority=5)
public void ForgotPassword_TC04B(Method name) throws InterruptedException, FileNotFoundException, IOException
{
	
	test=report.createTest(name.getName());
	WaitUtils.waitForElement(driver, lp.returnloginuser);
	lp.returnloginuser.click();
	lp.invalidloginforgotpass(driver);
	WaitUtils.waitForElement(driver, lp.errormsg);					
//	//Thread.sleep(1000);
	assertTrue(lp.verifyinvalidlogerror(driver),"InvalidLogin Error Not Displayed");
	CommonUtils.capturescreenshots(driver,name.getName());
	driver.quit();
}

}
