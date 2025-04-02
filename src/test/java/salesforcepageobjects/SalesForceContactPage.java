package salesforcepageobjects;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import salesforceutils.ReadConfigFileutils;
import salesforceutils.WaitUtils;

public class SalesForceContactPage {
	
	WebDriver driver;
	
	public  SalesForceContactPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	String capturedUsername = null;
	
@FindBy(xpath="//a[@title=\"Contacts Tab\"]")
public WebElement contactstab;
@FindBy(xpath="//input[@value=\" New \"]")
public WebElement contact_new_button;
@FindBy(xpath="//input[@id=\"name_lastcon2\"]")
public WebElement contact_new_lastname;
@FindBy(xpath="//img[@alt=\"Account Name Lookup (New Window)\"]")
public WebElement contact_acc_name;
@FindBy(xpath="//input[@id=\"con4\"]")
public WebElement accname_textbox;
@FindBy(xpath="//input[@title=\"Save\"]")
public WebElement contact_new_savebutton;
@FindBy(xpath="//*[@id=\"lksrch\"and@type=\"text\"]")
public WebElement contact_lookup_search;
@FindBy(xpath="//*[@id=\"theForm\"]/div/div[2]/input[2]")
public WebElement contact_lookup_searchgo;
@FindBy(xpath="//a[contains(text(),'Create New View')]")
public WebElement contactcreatenewviewtab;
@FindBy(xpath="//div[@class=\"errorMsg\"]")
public WebElement newcontacterror;
@FindBy(xpath="//input[@id=\"fname\"]")
public WebElement contactviewname;
@FindBy(xpath="//input[@id=\"devname\"]")
public WebElement contactunqname;
@FindBy(xpath="//input[@class=\"btn primary\"and@name=\"save\"]")
public WebElement savebutton;
@FindBy(xpath="//input[@value=\"Save & New\"]")
public WebElement saveandnewbutton;
@FindBy(xpath="//*[@id=\"00Bak00000UqyGX_listSelect\"]")
public WebElement createviewdropdwn;
@FindBy(xpath="//select[@id=\"hotlist_mode\"]")
public WebElement recentlycreatedropdwn;
@FindBy(xpath="//select[@id='fcf']")
public WebElement contactshomedropdwn;
@FindBy(xpath="//*[@id=\"bodyCell\"]/div[3]/div[1]/div/div[2]/table/tbody/tr[2]/th/a")
public WebElement firstcontactname;
@FindBy(xpath="//h2[@class=\"pageDescription\"]")
public WebElement firstcontactnamedisplayed;
@FindBy(xpath="//div[contains(text(),'You must enter a value')]")
public WebElement createviewerror;
@FindBy(xpath="//div[@class='pbBottomButtons']//input[@title='Cancel']")
public WebElement createviewcancelbutton;

	public boolean verifycontacthome(WebDriver driver) throws FileNotFoundException, IOException
	{
		String oriconthomepage=driver.getTitle();
		String expectedhomepage=ReadConfigFileutils.readfromcontactpropertiesfile("contact.homepage");
		if(oriconthomepage.equalsIgnoreCase(expectedhomepage))
		{
			return true;
		}
		return false;
		
	}
	public boolean verify_newcontact_page(WebDriver driver) throws FileNotFoundException, IOException
	{
		String oricontnewpage=driver.getTitle();
		String expectednewpage=ReadConfigFileutils.readfromcontactpropertiesfile("contactnew.page");
		if(oricontnewpage.equalsIgnoreCase(expectednewpage))
		{
			return true;
		}
		return false;
		
	}
	public boolean verify_newcontact_table(WebDriver driver) 
	{
		System.out.println("saved new contact page"+driver.getTitle());
		WebElement table=driver.findElement(By.xpath("//table[@class=\"detailList\"]"));
		List <WebElement> rows=table.findElements(By.tagName("td"));
		if (!rows.isEmpty()) {
			
	        System.out.println("The table is populated with data. Number of rows: " + rows.size());
	        return true;
		}
		return false;
	}
	public void accountname_lookup_icon(WebDriver driver) throws FileNotFoundException, IOException
	{
		
		System.out.println("parent window"+driver.getTitle());
		Set<String> windowHandles = driver.getWindowHandles();
		String currentHandle = driver.getWindowHandle();
		windowHandles.remove(currentHandle);
		String newHandle = windowHandles.iterator().next();
		driver.switchTo().window(newHandle);
		//Thread.sleep(1000);
		System.out.println("inside combobox window");
		driver.switchTo().frame("resultsFrame");
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("new window"+driver.getTitle());
		WebElement table=driver.findElement(By.xpath("//*[@id=\"new\"]/div/div[2]/div/div[2]/table/tbody/tr[2]/th/a"));
		table.click();
		System.out.println("pop option clicked");
		driver.switchTo().window(currentHandle);
		//driver.switchTo().activeElement();
//		List <WebElement> rows=table.findElements(By.name(ReadConfigFileutils.readfromcontactpropertiesfile("contactnew.accountname")));
//if (!rows.isEmpty()) {
//			this.contact_lookup_search.sendKeys(ReadConfigFileutils.readfromcontactpropertiesfile("ontactnew.accountname"));
//			this.contact_lookup_searchgo.click();
//			driver.findElement(By.xpath("//*[@id=\"new\"]/div/div[3]/div/div[2]/table/tbody/tr[2]")).click();
//	        System.out.println("The table is populated with data. Number of rows: " + rows.size());
	       // return true;
		
	}
	public void createview(WebDriver driver)
	{
		
		String randomreportname = "Anu"+ new Random().nextInt(1000); // Random username
	    String randomreportunqname = new Random().nextInt(1000) + "example"; 
		this.contactviewname.sendKeys(randomreportname);
		this.contactunqname.sendKeys(randomreportunqname);
		capturedUsername = this.contactviewname.getAttribute("value");
		System.out.println("Captured Username: " + capturedUsername);
		this.savebutton.click();
		
	}
	public boolean verifycreateviewuser(WebDriver driver)
	{
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if (SalesForceContactPage.this.capturedUsername == null) {
//	        System.out.println("Captured username is null. Ensure captureUsername() is executed before this method.");
//	        return false;
//	    }
		Select viewdrpdwn=new Select(this.createviewdropdwn);
		//viewdrpdwn.selectByVisibleText("");
		WebElement selectedOption =viewdrpdwn.getFirstSelectedOption();
		 System.out.println("dropdown option get:"+selectedOption);
	     // Get the visible text of the selected option
	     String selectedText = selectedOption.getText();
	     System.out.println("Selected allOption Text: " + selectedText);
	     System.out.println("reportpage name textbox"+SalesForceContactPage.this.capturedUsername);
	     if(selectedText.equals(SalesForceContactPage.this.capturedUsername))
	     {
	    	 return true;
	     }
		return false;
		
	}
	public boolean verifycreateviewtabledisp(WebDriver driver) 
	{
		WebElement table=driver.findElement(By.xpath("//*[@id=\"ext-gen16\"]/div/table"));
		List <WebElement> rows=table.findElements(By.tagName("td"));
		
		if (!rows.isEmpty()) {
			
	        System.out.println("The table is populated with data. Number of rows: " + rows.size());
	        return true;
		}
		return false;
	}
	public boolean verify_recentlycreated(WebDriver driver) throws FileNotFoundException, IOException
	{
		Select recentdropdwn=new Select(this.recentlycreatedropdwn);
		recentdropdwn.selectByVisibleText("Recently Created");
		WebElement rectablename=driver.findElement(By.xpath("//td[@class=\"pbTitle\"]"));
		String tablename=rectablename.getText();
		String expectedtablename=ReadConfigFileutils.readfromcontactpropertiesfile("recentcontact.page");
		System.out.println("recently created page:"+tablename+"from config:"+expectedtablename);
		
			if(tablename.contains(expectedtablename))
			{
				WebElement table=driver.findElement(By.xpath("//table[@class=\"list\"]"));
				List <WebElement> rows=table.findElements(By.tagName("td"));
				//System.out.println("checking table populated");
				if (!rows.isEmpty()) {
	        System.out.println("The table is populated with data. Number of rows: " + rows.size());
	        return true;
			}
		}
		
		return false;
		
	}
public boolean verifymycontacts(WebDriver driver) throws FileNotFoundException, IOException, InterruptedException
{
	Thread.sleep(1000);
	Select recentdropdwn=new Select(this.contactshomedropdwn);
	recentdropdwn.selectByVisibleText("My Contacts");
//	WaitUtils.waitForElement(driver, this.contactshomedropdwn);
	Select quaterlystatus=new Select(this.contactshomedropdwn);
	 WebElement selectedOption =quaterlystatus.getFirstSelectedOption();

    // Get the visible text of the selected option
    String oriselectedText = selectedOption.getText();
    System.out.println("Selected allOption Text: " + oriselectedText);
    String expectedtext=ReadConfigFileutils.readfromcontactpropertiesfile("mycontact.dropdown");
	WebElement table=driver.findElement(By.xpath("//table[@class=\"list\"]"));
	List <WebElement> rows=table.findElements(By.tagName("td"));
	//System.out.println("checking table populated");
	if(oriselectedText.equalsIgnoreCase(expectedtext))
	{
	if (!rows.isEmpty()) {
	System.out.println("The table is populated with data. Number of rows: " + rows.size());
	return true;
}
	}
	return false;
}
//@SuppressWarnings("unlikely-arg-type")
//@SuppressWarnings("unlikely-arg-type")
public boolean verifycontactnamedisp(WebDriver driver)
{
	String[] contactname=this.firstcontactname.getText().split(",");
	String swappedName = (contactname[1]+" "+ contactname[0]).trim();
	System.out.println("name swap:"+swappedName);
//	List<String> names = Arrays.asList(contactname1);
//	String contactname = names.stream().collect(Collectors.joining(" "));
	System.out.println(contactname); 
	
//	String[] name2Parts = dispcontactname.split(" , ");
//    String normalizedName2 = name2Parts[1] + " " + name2Parts[0];
//
//    // Compare the names
//    System.out.println("Name 1: " + contactname.trim());
//    System.out.println("Normalized Name 2: " + normalizedName2.trim());
//	for(int i=0;i<contactname.length();i++)
//	{
		System.out.println("contact name before click:"+this.firstcontactname.getText());
		this.firstcontactname.click();
		String dispcontactname=this.firstcontactnamedisplayed.getText().trim();
//		StringBuilder sb=new StringBuilder(dispname);
//		sb.reverse();
//		String dispcontactname=sb.toString();
		System.out.println("contact name after click:"+dispcontactname);
	if(swappedName.equalsIgnoreCase(dispcontactname))
	{
		return true;
	}
	//}
	return false;
}
public boolean verifycreatenewviewerror(WebDriver driver) throws FileNotFoundException, IOException
{
	String oricreateviewerror=this.createviewerror.getText();
	System.out.println("create view error"+oricreateviewerror);
	String expectedcreaterror=ReadConfigFileutils.readfromcontactpropertiesfile("createview.error");
	if(oricreateviewerror.equalsIgnoreCase(expectedcreaterror))
	{
		return true;
	}
	return false;
	
}
public boolean verifycreateview_cancelbutton(WebDriver driver) throws FileNotFoundException, IOException
{
	
//	String oripage=driver.getTitle();
//	String expectedpage=ReadConfigFileutils.readfromcontactpropertiesfile("contact.homepage");
	
	//this.contactshomedropdwn;
	Select viewdrpdwn=new Select(this.contactshomedropdwn);
	//viewdrpdwn.selectByVisibleText("");
	WebElement selectedOption =viewdrpdwn.getFirstSelectedOption();
	 System.out.println("dropdown option get:"+selectedOption);
     // Get the visible text of the selected option
     String selectedText = selectedOption.getText();
     if(!selectedText.equals("ABCD"))
     {
    	 this.verifycontacthome(driver);
    	 return true;
     }
	return false;
	
}




}
