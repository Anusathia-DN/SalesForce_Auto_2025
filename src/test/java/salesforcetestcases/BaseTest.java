package salesforcetestcases;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import salesforcepageobjects.SDFCCreateAccountPage;
import salesforcepageobjects.SDFCSalesforceLoginPage;
import salesforcepageobjects.SalesForceContactPage;
import salesforcepageobjects.SalesForceCreateOppurtunityPage;
import salesforcepageobjects.SalesForceLeadsPage;
import salesforcepageobjects.SalesForceRandomPage;
import salesforcepageobjects.SalesforceHomePage;
import salesforcepageobjects.UserMenuSalesforcePage;
import salesforceutils.ReadConfigFileutils;
import salesforceutils.ReportsManager;

//Base Setup Method
//@BeforeClass
public class BaseTest {
	// WebDriver driver;
	public static  WebDriver driver;
	public static UserMenuSalesforcePage um;
	public static SDFCSalesforceLoginPage lp;
	public static SalesforceHomePage hp;
	public static SDFCCreateAccountPage ca;
	public static SalesForceCreateOppurtunityPage copp;
	public static SalesForceLeadsPage leads;
	public static SalesForceContactPage cp;
	public static SalesForceRandomPage rp;
	public static ExtentTest test;

	public static ExtentReports report;
	public static ThreadLocal<WebDriver> threadlocaldriver=new ThreadLocal<WebDriver>();
	public static ThreadLocal<ExtentTest> threadtest=new ThreadLocal<ExtentTest>();
	ReadConfigFileutils readconfig=new 	ReadConfigFileutils();
//	public String baseUrl=readconfig.getApplicationURL();
//	public String UserName=readconfig.getUserName();
//	public String Password=readconfig.getPasswrd();

	//public static ExtentReports test;
	//SalesforceHomePage hp;
	
	
	@BeforeSuite
	public void SetUp()
	{
		report=ReportsManager.getInstance();
		
	}
	@AfterSuite
	public void teardown()
	{
		report.flush();
		//driver.quit();
	}
	

	public static void setdriver(String bName,boolean headless)
	{
		driver=BaseTest.getBrowserDriver("Chrome", false);
		threadlocaldriver.set(driver);
	}
	public static WebDriver getbrowser()
	{
		return threadlocaldriver.get();
		
	}
	@BeforeMethod
	public  void setupBrowser(Method name) throws FileNotFoundException, IOException
	{
		BaseTest.setdriver("chrome", false);
		test=report.createTest(name.getName());
		threadtest.set(test);
		//driver=BaseTest.getbrowser();
//		um=new UserMenuSalesforcePage(driver);
//		hp=new SalesforceHomePage(driver);
//		lp=new SDFCSalesforceLoginPage(driver);
//		copp=new SalesForceCreateOppurtunityPage(driver) ;
//		leads=new SalesForceLeadsPage(driver) ;
//		cp=new SalesForceContactPage(driver) ;
//		rp=new SalesForceRandomPage(driver) ;
//		driver.get(ReadConfigFileutils.readfromloginpropertiesfile("base.url"));
//		driver.manage().window().maximize();
	}
	@AfterMethod
	public void closeBrowser()
	{
		
		threadlocaldriver.get().quit();
		threadlocaldriver.remove();
		driver.quit();
		
	}

	
	public static WebDriver getBrowserDriver(String br, boolean headless)
	{
		 String bName=br.toLowerCase();
		//WebDriver driver=null;
		switch(bName) {
		case "chrome":
			if(headless) {
				ChromeOptions co=new ChromeOptions();
				co.addArguments("--headless");
				driver=new ChromeDriver(co);
				
			}
			else {
				driver=new ChromeDriver();
				
			}
			
			break;
		case "FireFox":
		
			driver=new FirefoxDriver();
			break;
		case "Edge":
			driver=new EdgeDriver();
			break;
			default:
				System.out.println("Only Supports Chrome,Edge and Firefox Browsers");
		
		}
		//driver.get(baseUrl);
		return driver;
	}
//	@AfterSuite
//	public void tearDown()
//	{	
//		report.flush();
//		//driver.quit();
//	}


}
			
		
		
		
	


