package salesforcepageobjects;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import salesforceutils.ReadConfigFileutils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class SDFCSalesforceLoginPage {
	//WebDriver driver;
	//public static Logger logger;
	public SDFCSalesforceLoginPage(WebDriver driver) {
		Properties p;
	PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//*[@id='username'and@name='username']")
	public WebElement username;
	
	@FindBy(id="password")
	public WebElement password;
	@FindBy(id="Login")
	public WebElement Loginbutton;
	@FindBy(xpath="//*[@id=\"un\"]")
	public WebElement forgotpassworduser;
	@FindBy(id="rememberUn")
	public WebElement rememberme;
	//@FindBy(xpath="//*[@id=\"userNavLabel\"]")
	//public WebElement usermenu;
//	@FindBy(xpath="//*[@id=\"userNav-menuItems\"]/a[5]")
//	public WebElement logout;
	@FindBy(xpath="//*[@id=\"hint_back_chooser\"]")
	public WebElement remembermeusername;
	@FindBy(xpath="//a[@id=\"forgot_password_link\"]")
	public WebElement forgotpasswordlink;
	@FindBy(id="continue")
	public WebElement forgotusercontinuebutton;
	@FindBy(xpath="//*[@id=\"hint_back_chooser\"]")
	public WebElement usernamesaved;
	@FindBy(name="continue")
	public WebElement continuebutton;
	@FindBy(xpath="//*[@id=\"header\"]")
	public WebElement continuemailchk;
	@FindBy(xpath=".//a[contains(text(),'Return to Login')]")
	public WebElement returntologinbutton;
	@FindBy(xpath=".//*[@id='clear_link'and@class='clearlink']/img")
	public WebElement returnloginuser;
	//@FindBy(Xpath=)
	@FindBy(id="error")
	public WebElement errormsg;
	
//	public String enterusername(String username) throws FileNotFoundException, IOException{
//		this.username.clear();
//		this.username.sendKeys(ReadConfigFileutils.readfromloginpropertiesfile("valid.userName"));
//		return username;
//	}
	public String enterpassword(String password) throws FileNotFoundException, IOException {
		this.password.clear();
		this.password.sendKeys(ReadConfigFileutils.readfromloginpropertiesfile("valid.password"));
		return password;
		
		
	}
	public void clickloginbutton() {
		this.Loginbutton.click();
	}
	public  void logintosalesforce(WebDriver driver) throws FileNotFoundException, IOException
	{
		
		this.username.clear();
		this.username.sendKeys(ReadConfigFileutils.readfromloginpropertiesfile("valid.userName"));
		String pass=this.enterpassword(ReadConfigFileutils.readfromloginpropertiesfile("valid.password"));
		this.enterpassword(pass);
		this.clickloginbutton();
		//return new SalesforceHomePage(driver);
	}
//	private void username(String readfromloginpropertiesfile) {
//		// TODO Auto-generated method stub
//		
//	}
	public void validloginrememberme(WebDriver driver) throws FileNotFoundException, IOException
	{
		
		this.username.clear();
		this.username.sendKeys(ReadConfigFileutils.readfromloginpropertiesfile("valid.userName"));
		String pass=this.enterpassword(ReadConfigFileutils.readfromloginpropertiesfile("valid.password"));
		this.enterpassword(pass);
		//this.clickloginbutton();
		//return new SalesforceHomePage(driver);
	}
	public void invalidloginforgotpass(WebDriver driver) 
	{
		
		this.username.sendKeys("123");;
		String pass="22131";
		this.password.sendKeys(pass);
		this.clickloginbutton();
		//return new SalesforceHomePage(driver);
	}
	
	public void invalidlogin(WebDriver driver) throws FileNotFoundException, IOException {
		
		this.username.clear();
		this.username.sendKeys(ReadConfigFileutils.readfromloginpropertiesfile("valid.userName"));
		this.password.clear();
	
		this.clickloginbutton();
		//return new SDFCSalesforceLoginPage(driver);
		
	}
	
	//@SuppressWarnings("null")
	public boolean  verifyloginpage(WebDriver driver) throws IOException,FileNotFoundException {
		String loginpagetitle=driver.getTitle();
		System.out.println("home"+"  "+loginpagetitle);
		String expectedtitle=ReadConfigFileutils.readfromloginpropertiesfile("login.title");
		//return false;
		return loginpagetitle.equalsIgnoreCase(expectedtitle);
		
	}
	
	public boolean  verifyerrormsg(WebDriver driver) throws FileNotFoundException, IOException {
		String invaliderror=this.errormsg.getText();
		//System.out.println("error in page"+"  "+invaliderror);
		String expectederror=ReadConfigFileutils.readfromloginpropertiesfile("error.text");
		//return false;
		return invaliderror.equalsIgnoreCase(expectederror);
	}
	public boolean  verifyhomepage(WebDriver driver) throws FileNotFoundException, IOException {
		String homepagetitle=driver.getTitle();
		//System.out.println("error in page"+"  "+invaliderror);
		String expectedhometitle=ReadConfigFileutils.readfromloginpropertiesfile("homepage.title");
		//return false;
		return homepagetitle.equalsIgnoreCase(expectedhometitle);
	}
	public boolean  verifyrememberuser(WebDriver driver) throws FileNotFoundException, IOException {
		String remuser=remembermeusername.getText();
		System.out.println(remuser);
		String expectedremuser=ReadConfigFileutils.readfromloginpropertiesfile("remember.text");
		return remuser.equalsIgnoreCase(expectedremuser);
	}
	public String forgotpassuser(WebDriver driver) throws FileNotFoundException, IOException
	{
		//String actualforgotpassuser=forgotpassworduser.getText();
		String forgotpassuser=ReadConfigFileutils.readfromloginpropertiesfile("valid.userName");
		return forgotpassuser;
	}
	public boolean verifychkmailerror(WebDriver driver) throws FileNotFoundException, IOException {
		
		String chkmail=this.continuemailchk.getText();
		//System.out.println(chkmail);
		String orichkmailerror=ReadConfigFileutils.readfromloginpropertiesfile("continue.mailchkerror");
		return chkmail.equalsIgnoreCase(orichkmailerror);
	}
	public boolean verifyinvalidlogerror(WebDriver driver) throws FileNotFoundException, IOException {
		String logerror=this.errormsg.getText();
		String orierror=ReadConfigFileutils.readfromloginpropertiesfile("invalidlog.error");
		return logerror.equalsIgnoreCase(orierror);
			}
	public void errormsg()
	{
	this.errormsg.isDisplayed();	
	}
	public String baseurl(WebDriver driver) throws FileNotFoundException, IOException
	{
		String url=ReadConfigFileutils.readfromloginpropertiesfile("base.url");
		return url ;
	}
	
}
