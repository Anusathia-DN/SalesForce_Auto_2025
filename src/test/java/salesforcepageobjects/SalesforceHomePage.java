package salesforcepageobjects;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import salesforceutils.ReadConfigFileutils;


/**
 * @author anuradha.../this page contains all the elements in the 
 * home page of the salesforce application
 *
 */
public class SalesforceHomePage {
	
	public  SalesforceHomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	
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
		String expectedusername=ReadConfigFileutils.readfromloginpropertiesfile("usermenu.name");
	String originalusernamechk=this.Usermenu.getText();
	if(expectedusername.equalsIgnoreCase(originalusernamechk)) {
	System.out.println("Name Displayed in Usermenu"+this.Usermenu.getText());
	return true;
	}
	return false;
	}

	public SDFCSalesforceLoginPage Logoutuser(WebDriver driver) {
		// TODO Auto-generated method stub
		if(this.Usermenu.isDisplayed()) {
		this.Usermenu.click();
		this.Logout.click();
		}
		else {
			System.out.println("UserMenu Not Visible");
		}
		return new SDFCSalesforceLoginPage(driver);
		
	}
	//@SuppressWarnings({ "unused", "unlikely-arg-type" })
	@SuppressWarnings("unused")
	//@SuppressWarnings("unlikely-arg-type")
	public boolean verifyusermenulist(WebDriver driver) throws FileNotFoundException, IOException
	
	{
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
	
	


