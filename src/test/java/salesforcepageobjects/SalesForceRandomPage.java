package salesforcepageobjects;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import salesforcetestcases.BaseTest;
import salesforceutils.ReadConfigFileutils;
import salesforceutils.WaitUtils;

public class SalesForceRandomPage extends BaseTest{
	
	WebDriver driver;
	
	public  SalesForceRandomPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	 SalesforceHomePage hp;
	 UserMenuSalesforcePage um;
	
	 String abtlastname = null;
	
@FindBy(xpath="//li[@id=\"home_Tab\"]")
public WebElement homepagetab;
@FindBy(xpath="//h1[@class='currentStatusUserName']")
public WebElement homefirstandlastname;
@FindBy(xpath="//span[@id=\"tailBreadcrumbNode\"]")
public WebElement userprofileusername;
@FindBy(xpath="//span[@id=\"tsidLabel\"]")
public WebElement usermenualltab;	
@FindBy(xpath="//img[@class=\"allTabsArrow\"]")
public WebElement usermenupageplustab;
@FindBy(xpath="//input[@value=\"Customize My Tabs\"]")
public WebElement customizebutton;
@FindBy(xpath="//select[@id=\"duel_select_0\"]")
public WebElement customavailabletab;
@FindBy(xpath="//select[@id=\"duel_select_1\"]")
public WebElement customselectedtab;
@FindBy(xpath="//img[@class=\"leftArrowIcon\"]")
public WebElement customremovebutton;
@FindBy(xpath="//input[@class=\"btn primary\"]")
public WebElement savebutton;
@FindBy(xpath="//*[@id=\"ptBody\"]/div/div[2]/span[2]/a")
public WebElement homedate;
@FindBy(xpath="//h1[@class=\"pageType\"]")
public WebElement calendarpage;
@FindBy(xpath="//div[@id=\"p:f:j_id25:j_id61:4:j_id64\"]")
public WebElement homedatetime;
@FindBy(xpath="//img[@class=\"comboboxIcon\"]")
public WebElement neweventsubj_icon;
@FindBy(xpath="//li[@class='listItem4']//a[1]")
public WebElement comboboxother;
@FindBy(xpath="//input[@id=\"EndDateTime_time\"]")
public WebElement endtimedropdown;
@FindBy(xpath="//input[@value=\" Save \"]")
public WebElement timesavebutton;
@FindBy(xpath="//div[@id=\"timePickerItem_42\"]")
public WebElement endtimenine;
//@FindBy(xpath="//div[@id=\"timePickerItem_47\"]")
@FindBy(xpath="//div[@id=\"timePickerItem_47\"]")
public WebElement endtimeeleven;
@FindBy(xpath="//input[@id=\"evt5\"]")
public WebElement subject;
@FindBy(xpath="//a[contains(text(),'4:00')]")
public WebElement time4;
@FindBy(xpath="//div[@id=\"p:f:j_id25:j_id69:20:j_id71:0:j_id72:calendarEvent:i\"]")
public WebElement time4othersdiv;
@FindBy(xpath="//*[@id=\"p:f:j_id25:j_id69:4:j_id71:0:j_id72:calendarEvent:i\"]/div/div")
public WebElement time9othersdiv;

public boolean verifyhomepage(WebDriver driver) throws FileNotFoundException, IOException
{
	String orihomepage=driver.getTitle();
	System.out.println("home page:"+orihomepage);
	String expectedhomepage=ReadConfigFileutils.readfromrandompropertiesfile("home.page");
	if(orihomepage.equals(expectedhomepage))
	{
		return true;
	}
	return false;
	
}



public boolean verifyhome_currentstatususer(WebDriver driver) throws FileNotFoundException, IOException
{
	//String oriuserpro=driver.getTitle();
	System.out.println("inside verify currentstatus");
	WebElement loggedusername1=driver.findElement(By.xpath("//span[@id=\"userNavLabel\"]"));        
	//String actualusername=loggedusername1.getText().replaceFirst("\\.+$", "");
	String actualusername=hp.Usermenu.getText().replaceFirst("\\.+$", "");
	//String actualusername = loggedusername.replaceFirst("\\.+$", "");
	System.out.println("username from usermenu:"+actualusername);
	String oriprofilepage=driver.getCurrentUrl();
	String expecetdprofilepage=ReadConfigFileutils.readfromrandompropertiesfile("userprofilepage.url");
	String oristatususer=this.homefirstandlastname.getText().trim();
	System.out.println("userstatusname 1stpage:"+oristatususer);
	this.homefirstandlastname.click();
	String oriuserprofusername=this.userprofileusername.getText().trim();
	System.out.println("userstatusname 2nd page:"+oriuserprofusername);
	//String expectedstatus_user=ReadConfigFileutils.readfromrandompropertiesfile("userprofile.page");
	if(oriprofilepage.equalsIgnoreCase(expecetdprofilepage))
	{
		boolean isMatch;
		//if(oristatususer.contains(actualusername.toString()))
		if( isMatch = oristatususer.contains(actualusername) && oriuserprofusername.contains(actualusername));
		{
			if(oriuserprofusername.contains(actualusername.toString()))
			{
			return true;
		}
	}
	}
	return false;
	
}
public boolean verifycontacttab(WebDriver driver) throws FileNotFoundException, IOException
{
	
	String contactcolor=um.contactab.getCssValue("background-color");
	//System.out.println("contact color"+contactcolor);
	//String abouttcolor=um.abouttab.getCssValue("background-color");
	//System.out.println("contact color"+abouttcolor);
	Color color = Color.fromString(contactcolor);
	String actualColor = color.asHex();
	System.out.println("contact color in String:"+actualColor);
	String expectedcontactcolor=ReadConfigFileutils.readfromrandompropertiesfile("contactatb.color");
	//Assert.assertEquals(actualColor, expectedColor);
	if(expectedcontactcolor.equals(actualColor))
	{
		return true;
	}
	return false;
	
}
public void aboutlastname(WebDriver driver)
{
	WebElement activeElement = driver.switchTo().activeElement();
	System.out.println("focused:"+activeElement.getAttribute("value"));
	System.out.println("focused:"+activeElement.getAriaRole());
	WebElement lastname=driver.findElement(By.xpath("//input[@id=\"lastName\"]"));
	lastname.clear();
	lastname.sendKeys("Abcd");
//	um.abouttablastname.click();
//	um.abouttablastname.clear();
//	um.abouttablastname.sendKeys("Abcd");
	 abtlastname=lastname.getAttribute("value");
	System.out.println("sent keys value:"+abtlastname);
	driver.findElement(By.xpath("//input[@value=\"Save All\"]")).click();
	//um.savelastname.click();
	driver.switchTo().parentFrame();
}

public boolean verifyaboutlastname(WebDriver driver) throws FileNotFoundException, IOException
{
	String expectedlastname=abtlastname;
	System.out.println("getattri lastname:"+expectedlastname);
	//WebElement prolastname=driver.findElement(By.xpath("//span[@id='tailBreadcrumbNode'and@class='tailNode cxTailNode']"));
	String[] originalastname=this.userprofileusername.getText().split(" ");
	if((expectedlastname.trim()).equalsIgnoreCase(originalastname[1].trim())) 
	{
		return true;
	}
	return false;
}
public boolean verifyalltabpage(WebDriver driver) throws FileNotFoundException, IOException
{
	System.out.println("alltab page:"+driver.getTitle());
	String orialltabpage=driver.getTitle();
	String expectedalltab=ReadConfigFileutils.readfromrandompropertiesfile("alltabs.page");
	if(orialltabpage.equalsIgnoreCase(expectedalltab))
	{
		return true;
	}
	return false;
	
}
public boolean verifycustomizetab(WebDriver driver)
{
	Select avail=new Select(this.customavailabletab);
	Select sel=new Select(this.customselectedtab);
	avail.selectByVisibleText("Assets");
	this.customremovebutton.click();
	this.savebutton.click();
	this.customizebutton.click();
	List<WebElement> selectappdrpdwn=sel.getOptions();
			//this.customselectedtab.findElements(By.xpath("//select[@id=\"duel_select_0\"]"));
	System.out.println("select optiond dropdown"+selectappdrpdwn.toString());
	 String optionToCheck = "Assets";
	 boolean isOptionPresent = false;
    
    for (WebElement option : selectappdrpdwn) {
    	//System.out.println("VerifyAssetstabadded");
       // if (option.getText().contains(optionToCheck)) {
        	 if((option.getText().toString()).contains(optionToCheck))
             {
             	 //isOptionPresent = true;
                  System.out.println("verified Assets tab in HomePage");
                  return true;
             }
            
  			//return isOptionPresent;
                 }
        
        
    
    		return  false;
//break;
  }
public boolean verifycalenderpage(WebDriver driver) throws FileNotFoundException, IOException
{
	//String oricalname=this.calendarpage.getText();
	String oricaltitle=driver.getTitle();
	String expectedtitle=ReadConfigFileutils.readfromrandompropertiesfile("calender.page");
	//System.out.println("the name displayed in calenderpage"+oricalname);
	System.out.println("the title of calendarpage"+oricaltitle);
	if(oricaltitle.equals(expectedtitle))
	{
		return true;
	}
	return false;
	
}
public static String getCurrentDayDateTime() {
	// Change to PST
    LocalDateTime now = LocalDateTime.now();
   //ayOfWeek dayOfWeek = now.getDayOfWeek();
    ZonedDateTime pstDateTime = now.atZone(ZoneId.systemDefault()) // Convert to the system's ZonedDateTime
            .withZoneSameInstant(ZoneId.of("America/Los_Angeles")); 
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE MMMM dd, yyyy");
    return  pstDateTime.format(formatter);
}
public boolean verifydatetime(WebDriver driver)
{
	String oridatetime=this.homedate.getText().trim();
	System.out.println("fromhomepage datetime:"+oridatetime);
	 String currentDayDateTime = getCurrentDayDateTime().trim();
	 System.out.println("current datetime:"+currentDayDateTime);
	//his.homedate.click();
	 if(oridatetime.equals(currentDayDateTime))
	 {
		 return true;   
	 }
	 return false;

}

public boolean verifycomboboxother(WebDriver driver) throws InterruptedException
{
	
	this.neweventsubj_icon.click();
	Set<String> windowHandles = driver.getWindowHandles();
	String currentHandle = driver.getWindowHandle();
	windowHandles.remove(currentHandle);
	String newHandle = windowHandles.iterator().next();
	driver.switchTo().window(newHandle);
	Thread.sleep(1000);
	System.out.println("inside combobox window");
	driver.findElement(By.xpath("//a[@href='javascript:pickValue(4);']")).click();
	driver.switchTo().window(currentHandle);
	 //driver.switchTo().defaultContent();
//}
//	
//	public void subjectandendtime(WebDriver driver)
//	{
	WaitUtils.waitForElement(driver, this.subject);
	this.subject.click();
	String orisub=this.subject.getAttribute("value");
	System.out.println("text in subject:"+orisub);
	String expectedsub="Other";
	if(orisub.equalsIgnoreCase(expectedsub))
	{
		System.out.println("back to parent");
		//WaitUtils.waitForElement(driver, this.endtimedropdown);
		//driver.switchTo().window(currentHandle);
		//this.endtimedropdown.click();
		//driver.switchTo().parentFrame();
		return true;
	}
	return false;
}
public boolean verifyendtime(WebDriver driver)
{
	//driver.findElement(By.xpath("//div[@id=\"timePickerItem_42\"]")).click();
	this.endtimedropdown.click();
	this.endtimenine.click();
	System.out.println("clicked on endtime");
	String orinine=this.endtimenine.getText();
	String orieleven=this.endtimeeleven.getText();
	if(orinine.equals("9:00 PM")&&(orieleven.equals("11:30 PM")))
	{
		return true;
	}
//	
	return false;
	
}
public boolean verifytimeslotsfour(WebDriver driver)
{
//	Actions action=new Actions(driver);
//	action.moveToElement(this.time4othersdiv).build().perform();
	//driver.switchTo().activeElement();
	//System.out.println("switched to window");
	String timeslot=this.time4othersdiv.getText();
	//String timeslot=driver.findElement(By.xpath("//*[@id=\"EventHoverPage_00Uak000001ZHF7_page\"]/div[2]/div/table/tbody/tr[6]/td[2]")).getText();
	System.out.println("4 to 5 pm timeslot:"+timeslot);
	if(timeslot.equals("Other"))
	{
		return true;
	}
	return false;
	//this.time4othersdiv
}
public boolean verifytimeslotsnine(WebDriver driver)
{
//	Actions action=new Actions(driver);
//	action.moveToElement(this.time4othersdiv).build().perform();
	//driver.switchTo().activeElement();
	//System.out.println("switched to window");
	String timeslot=this.time9othersdiv.getText();
	//String timeslot=driver.findElement(By.xpath("//*[@id=\"EventHoverPage_00Uak000001ZHF7_page\"]/div[2]/div/table/tbody/tr[6]/td[2]")).getText();
	System.out.println("8 to 9 pm timeslot:"+timeslot);
	if(timeslot.equals("Other"))
	{
		return true;
	}
	return false;
	//this.time4othersdiv
}


}
