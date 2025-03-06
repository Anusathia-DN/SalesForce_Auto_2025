package salesforcetestcases;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import salesforcepageobjects.SDFCCreateAccountPage;
import salesforcepageobjects.SDFCSalesforceLoginPage;
import salesforcepageobjects.SalesforceHomePage;
import salesforcepageobjects.UserMenuSalesforcePage;
import salesforceutils.CommonUtils;
import salesforceutils.ReadConfigFileutils;
import salesforceutils.WaitUtils;

public class SDFCCreateAccountTestcase extends BaseTest{
	
	
	WebDriver driver;
	UserMenuSalesforcePage um;
	SDFCSalesforceLoginPage lp;
	SalesforceHomePage hp;
	SDFCCreateAccountPage ca;
	
	@BeforeMethod
	public void precond() throws FileNotFoundException, IOException 
	{
		driver=BaseTest.getBrowserDriver("chrome", false);
		um=new UserMenuSalesforcePage(driver);
		hp=new SalesforceHomePage(driver);
		lp=new SDFCSalesforceLoginPage(driver);
		ca=new SDFCCreateAccountPage(driver);
		driver.get(lp.baseurl(driver));
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void postcond() throws FileNotFoundException, IOException 
	{
	//driver.quit();
	}
	@Test(enabled=false)
	public void createaccount_TC10(Method name) throws FileNotFoundException, IOException
	{
		test=report.createTest(name.getName());
		lp.logintosalesforce(driver);
		//assertTrue(lp.verifyloginpage(driver),"LoginPage Verified");
		WaitUtils.waitForElement(driver, hp.Usermenu);
		//System.out.println("Name Displayed in Usermenu"+hp.Usermenu.getText());
		assertTrue(hp.verifyusername(driver),"Username is displayed correct");
		WaitUtils.waitForElement(driver, ca.accountbutton);
		ca.accountbutton.click();
		assertTrue(ca.verifyaccountusername(driver),"Account username Verified");

		//		ca.accnewviewlink.click();
//		Select newview=new Select(ca.accnewviewlink);
//		newview.selectByValue("00Bak00000RSORH");
		
		ca.accountcreatebutton.click();
		ca.accountnewbutton.click();
		ca.newaccountname.sendKeys(ReadConfigFileutils.readfromcreateaccountpropertiesfile("new.accountname"));
		ca.newaccountsavebutton.click();
		CommonUtils.capturescreenshots(driver,name.getName());
	}
	@Test(enabled=false)
	public void createnewview_TC11(Method name) throws FileNotFoundException, IOException
	{
		test=report.createTest(name.getName());
		lp.logintosalesforce(driver);
		WaitUtils.waitForElement(driver, ca.accountbutton);
		ca.accountbutton.click();
		assertTrue(hp.verifyusername(driver),"Username is displayed correct");
		//ca.accviewdropdown.click();
		ca.accnewviewlink.click();
		ca.viewnames(driver);
//		ca.viewname.clear();
//		ca.viewname.sendKeys(ReadConfigFileutils.readfromcreateaccountpropertiesfile("view.name"));
//		ca.viewunqname.clear();
//		ca.viewunqname.sendKeys(ReadConfigFileutils.readfromcreateaccountpropertiesfile("viewunique.name"));
//		String value = driver.findElement(By.xpath("//input[@id='fname'and@name='fname']")).getAttribute("value");
//		System.out.println(value);
//		ca.createviewsavebutton.click();
		
		//WaitUtils.waitForElement(driver, ca.accviewdropdown);
		//ca.accviewdropdown.click();
		assertTrue(ca.verifyaccountviewlist(driver),"Verified Name Added To View List");
		//ca.removeaccname(driver);
//		ca.accnewviewlink.click();
//		Select newview=new Select(ca.accnewviewlink);
//		newview.selectByContainsVisibleText(ReadConfigFileutils.readfromcreateaccountpropertiesfile("view.name"));
		//CommonUtils.capturescreenshots(driver,name.getName());
	}
	@Test(enabled=true)
	public void mergeaccounts_TC13(Method name) throws FileNotFoundException, IOException
	{
		test=report.createTest(name.getName());
		lp.logintosalesforce(driver);
		WaitUtils.waitForElement(driver, ca.accountbutton);
		ca.accountbutton.click();
		assertTrue(hp.verifyusername(driver),"Username is displayed correct");
		ca.mergeaccountsbutton.click();
		ca.mergeaccountsearchbox.clear();
		ca.mergeaccountsearchbox.sendKeys(ReadConfigFileutils.readfromcreateaccountpropertiesfile("mergeaccount.search"));
		ca.mergeaccfindaccbutton.click();
		ca.mergechkboxselect(driver);
		ca.mergeaccnextbutton.click();
		
	}

}
