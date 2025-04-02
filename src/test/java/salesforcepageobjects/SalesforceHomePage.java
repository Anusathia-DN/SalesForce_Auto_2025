package salesforcepageobjects;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import salesforceutils.ReadConfigFileutils;
import salesforceutils.WaitUtils;


/**
 * @author anuradha.../this page contains all the elements in the 
 * home page of the salesforce application
 *
 */
public class SalesforceHomePage {
	
	// WebDriver driver;
	
	
	public  SalesforceHomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	SalesForceRandomPage rp;
	//rp=new SalesForceRandomPage(driver);
	String savedHref=null;
	
	@FindBy(xpath="//div[@id='userNav']")
	public WebElement Usermenu;
	@FindBy(xpath="//*[@id=\"userNav-menuItems\"]/a[5]")
	public WebElement Logout;
	@FindBy(xpath="//*[@id=\"userNav-menuItems\"]/a")
	public List<WebElement> Usermenulist;
	
	
//	public void Logoutuser(String Usermenu,String Logout) {
//		if(this.Usermenu.isDisplayed()) {
//			this.Usermenu.click();
//			this.Logout.click();
//		}
//		else {
//			System.out.println("UserMenu Not Visible");
//		}
//	}
	public boolean verifyusername(WebDriver driver) throws FileNotFoundException, IOException 
	{
		rp=new SalesForceRandomPage(driver);
		String[] expectedusername=ReadConfigFileutils.readfromloginpropertiesfile("usermenu.name").split("");
		String[] originalusernamechk=this.Usermenu.getText().split("");
		//String swappedName = (expectedusername[0]).trim();
		//savedHref=originalusernamechk1;
		//String originalusernamechk=this.Usermenu.getAttribute("href");
		//System.out.println("usermenu name:"+savedHref);
		//rp.homepagetab.click();
		//loggedusername.replaceFirst("\\.+$", "");
		//String expectedusername=rp.homefirstandlastname.getText();
		//System.out.println("homepage name:"+expectedusername.replaceFirst("\\.+$", ""));
		if((expectedusername[0].trim()).contains(originalusernamechk[0].trim()))
		{
			System.out.println("Name Displayed in Usermenu:"+this.Usermenu.getText());
			return true;
	}
			return false;
	}

	public boolean Logoutuser(WebDriver driver) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		WaitUtils.waitForElement(driver, this.Usermenu);
		rp=new SalesForceRandomPage(driver);
		if(this.Usermenu.isDisplayed()) {
		this.Usermenu.click();
		this.Logout.click();
		String orilogoutpage=driver.getCurrentUrl();
		System.out.println("logout title:"+orilogoutpage);
		String expectedlogoutpage=ReadConfigFileutils.readfromloginpropertiesfile("logoutpage.url");
		if(orilogoutpage.equalsIgnoreCase(expectedlogoutpage))
		{
			new SDFCSalesforceLoginPage(driver);
			System.out.println("Login page Displayed");
			return true;
			
		}
		}
		else {
			System.out.println("UserMenu Not Visible");
		}
		new SDFCSalesforceLoginPage(driver);
		return false;
		
	}
	//@SuppressWarnings({ "unused", "unlikely-arg-type" })
	@SuppressWarnings("unused")
	//@SuppressWarnings("unlikely-arg-type")
	public boolean verifyusermenulist(WebDriver driver) throws FileNotFoundException, IOException
	
	{
		
		rp=new SalesForceRandomPage(driver);
		boolean verfyusermenulist=true;
//		if(this.Usermenu.isDisplayed())
//		{
//			this.Usermenu.click();
////		
			//String menulist=((WebElement) this.Usermenulist).getText();
			String[] expectedmenulist=ReadConfigFileutils.readfromhomepropertiesfile("user.menulist").split(",");
			//System.out.println("Menulistfrom properties"+(Arrays.toString(expectedmenulist)+expectedmenulist.length)+"menulist size in site"+this.Usermenulist.size());
			if(expectedmenulist.length==this.Usermenulist.size());
			{
			//return verfyusermenulist=true;
				//return verifyusermenulist 
				for(int i=0;i<expectedmenulist.length;i++)
				{
					String actualmenulist=this.Usermenulist.get(i).getText();
					//System.out.println("actual list"+actualmenulist);
				
					if(!expectedmenulist[i].equals(actualmenulist))
					{
						verfyusermenulist=false;
					}
					
				
									}
				
				return verfyusermenulist;
		}
		//return verfyusermenulist;
		
	}
			//return verfyusermenulist;
		
	}
	
	


