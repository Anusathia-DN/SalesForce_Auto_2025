package salesforcepageobjects;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import salesforceutils.ReadConfigFileutils;
import salesforceutils.WaitUtils;

public class SDFCCreateAccountPage {
	
	 
	WebDriver driver;
	
	public  SDFCCreateAccountPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	String capturedUsername = null;
	
@FindBy(xpath="//li[@id='Account_Tab']")
 public WebElement accountbutton;
@FindBy(xpath="//div[@id='mru005ak00000Dfoiv'and@class='mruItem']")
public WebElement accountusername;
@FindBy(xpath="//div[@id='createNewButton'and@class='menuButtonButton']")
public WebElement accountcreatebutton;
@FindBy(xpath="//a[@class='accountMru menuButtonMenuLink']")
public WebElement accountnewbutton;
@FindBy(xpath="//input[@id='acc2'and@name='acc2']")
public WebElement newaccountname;
@FindBy(xpath="//*[@id=\"topButtonRow\"]/input[1]")
public WebElement newaccountsavebutton;
@FindBy(xpath="//*[@id=\"bodyCell\"]/div[1]/div[1]/div[1]/h2")
public WebElement savednewaccountname;
@FindBy(xpath="//span[@id='mru005ak00000Dfoiv'and@class='mruText']")
public WebElement accountusernamedisplay;
@FindBy(xpath="//a[contains(text(),'Create New View')]")
public WebElement accnewviewlink;
@FindBy(xpath="//*[@id=\"filter_element\"]/div/span/span[1]/input")
public WebElement newviewgobutton;
@FindBy(xpath="//input[@id='fname'and@name='fname']")
public WebElement viewname;
@FindBy(xpath="//input[@id='devname'and@name='devname']")
public WebElement viewunqname;
@FindBy(xpath="//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[1]")
public WebElement createviewsavebutton;
@FindBy(className="title")
public WebElement accviewdropdown;
@FindBy(xpath="//*[@id=\"toolsContent\"]/tbody/tr/td[2]/div/div/div/ul/li[4]/span/a")
public WebElement mergeaccountsbutton;
@FindBy(xpath="//input[@id='srch']")
public WebElement mergeaccountsearchbox;
@FindBy(xpath="//input[@class='btn'and@title='Find Accounts']")
public WebElement mergeaccfindaccbutton;
@FindBy(xpath="//table[@class='list']")
public WebElement mergeaccnametable;
@FindBy(xpath="//input[@value=' Next ']")
public WebElement mergeaccnextbutton;
@FindBy(xpath="//*[@id=\"stageForm\"]/div/div[1]/h2")
public WebElement mergeaccstep2;
@FindBy(xpath="//tr[@id='stageForm'and@class='dataRow even first']")
public WebElement mergeaccowner1;
@FindBy(xpath="//tr[@class='dataRow odd']")
public WebElement mergeaccowner2;
@FindBy(xpath="//*[@id=\"stageForm\"]/div/div[2]/div[1]/div/input[2]")
public WebElement mergebutton;
@FindBy(xpath="//*[@id=\"bodyCell\"]/div[3]/div[1]/div/div[2]/table/tbody/tr[2]/th")
public WebElement mergedname;
@FindBy(xpath="//a[contains(text(),'Accounts with last activity > 30 days')]")
public WebElement acclastactivity;
@FindBy(xpath="//h2[@class='pageDescription']")
public WebElement unsavedreport;
@FindBy(xpath="//img[@id=\"ext-gen148\"]")
public WebElement createddate;
@FindBy(xpath="//img[@id=\"ext-gen152\"]")
public WebElement fromdate;
@FindBy(xpath="//img[@id=\"ext-gen154\"]")
public WebElement todate;
@FindBy(xpath="//button[@id=\"ext-gen49\"and@class=\" x-btn-text\"]")
public WebElement reportsavebutton;
@FindBy(xpath="//input[@id=\"saveReportDlg_reportNameField\"and@name=\"reportName\"]")
public WebElement reportname;
@FindBy(xpath="//input[@id='saveReportDlg_DeveloperName'and@name='reportDevName']")
public WebElement reportunqname;
@FindBy(xpath="//table[@id='dlgSaveAndRun']")
public WebElement saveandrunbutton;
@FindBy(xpath="//h2[contains(text(),'Report Generation Status:')]")
public WebElement reportpagedisdetails;
@FindBy(xpath="//div[@id=\"status\"]")
public WebElement reportpagestatus;
@FindBy(xpath="//h1[@class=\"noSecondHeader pageType\"]")
public WebElement reportpagename;
//private String randomname;
public boolean verifyaccountusername(WebDriver driver) throws FileNotFoundException, IOException
{
	String oriaccountuserdisplay=this.accountusernamedisplay.getText();
	String expectedaccuserdisp=ReadConfigFileutils.readfromcreateaccountpropertiesfile("account.name");
	if(oriaccountuserdisplay.equalsIgnoreCase(expectedaccuserdisp)) 
	{
		return true;
	}
	return false;
	
}
public void mergechkboxselect(WebDriver driver)
{
	WebElement table = driver.findElement(By.xpath("//table[@class='list']")); // Replace with the table's ID or appropriate locator
	WebElement Button1 = driver.findElement(By.xpath("//input[@id='cid0']"));
	WebElement Button2 = driver.findElement(By.xpath("//input[@id='cid1']"));
	
	WebElement Button3 = driver.findElement(By.xpath("//input[@id='cid2']"));
	
		if(Button1.isSelected()&& Button2.isSelected()&& Button3.isDisplayed())
		{
			System.out.println("Button172 is selected and Button 3 is displayed");
			 
//			 if(Button2.isSelected()&& Button3.isDisplayed())
//			 {
				 
				   // Radiobutton(Button3, "RadioButton");
				 Button3.click();
				 this.mergeaccnextbutton.click();
			 }
		try {
		if(!Button3.isDisplayed()) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", this.mergeaccnextbutton);
			System.out.println("Button172 is selected and Button 3 is notdisplayed");
			this.mergeaccnextbutton.click();
		}
	
}catch (NoSuchElementException e) {
	this.mergeaccnextbutton.click();
}
//		else {
//		this.mergeaccnextbutton.click();
//		}
//			 else
//			 {
//				 Button2.click();
////				 if(Button3.isDisplayed()&Button3.isSelected())
////				 {
////					Button3.click(); 
////				 }
//			 }
//		}
//		else
//		{
//			Button1.click();
//			//WebElement Button2 = driver.findElement(By.xpath("//input[@id='cid1']"));
//			 if(Button2.isSelected())
//			 {
//				 this.mergeaccnextbutton.click();
//			 }
			   // Radiobutton(Button2, "RadioButton");
		//}
   // Radiobutton(Button1, "RadioButton");
   
    // Locate all checkboxes in a specific row and column
    // Example XPath to get checkboxes in a row and column: Adjust XPath as needed
   // List<WebElement> checkboxes = table.findElements(By.tagName("tr"));
    //System.out.println("Table checkboxes"+checkboxes);
    // Iterate over the first three checkboxes and check them
//    for (WebElement checkbox : checkboxes) {
//        if (checkbox.isSelected()) {
//            checkbox.click(); // Unselect the checkbox if it's already selected
//        }
//    }

    // Step 2: Select the first two checkboxes
  //  for (int i = 0; i < checkboxes.size(); i++) { // Adjust the limit to the first two checkboxes
//    	List<WebElement> clickbox = checkboxes.get(i).findElements(By.tagName("td"));
//    	for(int chk=0;chk<clickbox.size();chk++)
//    	{
//        if (checkboxes.get(i).isSelected()) {
//        	System.out.println(checkboxes.get(i).getText());// Check if not already selected
//            checkboxes.get(i).click(); // Select the checkbox
//        }
//    }
//    }
}
public boolean verifymergestep2(WebDriver driver) throws FileNotFoundException, IOException
{
	String step2msg=this.mergeaccstep2.getText();
	//System.out.println("step 2 msg"+step2msg);
	String expectedmsg=ReadConfigFileutils.readfromcreateaccountpropertiesfile("merge.step2");
	if(step2msg.equalsIgnoreCase(expectedmsg))
	{
	
		return true;
	}
	return false;
	
}
public boolean verifymergepopup(WebDriver driver) throws FileNotFoundException, IOException
{
	//String parentmerge=driver.getWindowHandle();
	//System.out.println("parentMerge Window"+parentmerge);
	driver.switchTo().alert().accept();
	String oriaccpage=driver.getTitle();
	String actualaccpage=ReadConfigFileutils.readfromcreateaccountpropertiesfile("accountpage.title");
	if(oriaccpage.equalsIgnoreCase(actualaccpage))
	{
	return true;
	}
	return false;
	
}
public boolean verifymergedisplay(WebDriver driver) throws FileNotFoundException, IOException
{
	//WebElement table=driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[3]/div[1]/div/div[2]/table"));
	//List <WebElement> rows=table.findElements(By.tagName("th")); 
String orimergedname=this.mergedname.getText();
//System.out.println("mergednamedisplayed"+orimergedname);
String expecmergedname=ReadConfigFileutils.readfromcreateaccountpropertiesfile("mergeaccount.search");
if(orimergedname.equalsIgnoreCase(expecmergedname))
{
	return true;
}
return false;
}
public boolean verifyunsavedreport(WebDriver driver) throws FileNotFoundException, IOException
{
	String oriunsavedrep=this.unsavedreport.getText();
	System.out.println("unsaved report page"+oriunsavedrep);
	String expunsavedrep=ReadConfigFileutils.readfromcreateaccountpropertiesfile("unsaved.report");
	if(oriunsavedrep.equalsIgnoreCase(expunsavedrep))
	{
		return true;
	}
	return false;
	
}
public void selectdate(WebDriver driver)
{
	this.createddate.click();
	WebElement createddate = driver.findElement(By.xpath("//div[contains(text(),'Created Date')]"));
	createddate.click();
	//driver.findElement(By.xpath("//div[contains(text(),'Crea')]")).click();
	//Select cdate=new Select(createddate);
	//cdate.selectByVisibleText("Created Date");
	LocalDate today = LocalDate.now();
	System.out.println("today startdate"+today);
	
    String formattedDate = today.format(DateTimeFormatter.ofPattern("d"));
    System.out.println("formatted date with Month"+formattedDate);
	WebElement startdate =  driver.findElement(By.name("startDate"));
	startdate.clear();
	startdate.sendKeys(LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
	//startdate.sendKeys()
	//startdate.sendKeys();
	//enterText(startdate, "01/04/2019","calenderdata");
	WebElement enddate = driver.findElement(By.name("endDate"));
	enddate.clear();
	enddate.sendKeys(LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
	//enterText(enddate, "03/04/2019", "calenderdata");
	
}
public boolean verifyreportdisp(WebDriver driver) 
{
	WebElement table=driver.findElement(By.xpath("//div[@id=\"ext-gen253\"]"));
	List <WebElement> rows=table.findElements(By.tagName("td"));
	if (!rows.isEmpty()) {
		
        System.out.println("The table is populated with data. Number of rows: " + rows.size());
        return true;
	}
	return false;
}
public void saveandrunreport(WebDriver driver) throws InterruptedException
{
	
	String randomreportname = "Anu"+ new Random().nextInt(1000); // Random username
    String randomreportunqname = new Random().nextInt(1000) + "example"; 
	this.reportname.clear();
	this.reportname.sendKeys(randomreportname);
	this.reportunqname.clear();
	this.reportunqname.sendKeys(randomreportunqname);
	//String randomname=this.reportname.getText();
	//@SuppressWarnings("unused")
	 capturedUsername = this.reportname.getAttribute("value");
	System.out.println("Captured Username: " + capturedUsername);
   
	WaitUtils.waitForElement(driver, this.saveandrunbutton);
	Thread.sleep(2000);
	//this.reportsavebutton.click();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	//WebElement element = driver.findElement(By.id("element_id"));
	js.executeScript("arguments[0].scrollIntoView(true);", this.saveandrunbutton);
	this.saveandrunbutton.click();
	 return;

	//this.reportsavebutton.sendKeys(Keys.ENTER);
}
public boolean verifysavedreport(WebDriver driver) throws FileNotFoundException, IOException
{
	if (capturedUsername == null) {
        System.out.println("Captured username is null. Ensure captureUsername() is executed before this method.");
        return false;
    }
	String savedreportpage=driver.getTitle();
	System.out.println("saved reports page"+savedreportpage);
	WaitUtils.waitForElement(driver, this.reportpagename);
	String reportname=this.reportpagename.getText();
	System.out.println("ori name disp"+reportname);
	//String randomname1=this.randomname;
	//String 
	System.out.println("reportpage name textbox"+SDFCCreateAccountPage.this.capturedUsername);
	//String searchname=ReadConfigFileutils.readfromcreateaccountpropertiesfile("mergeaccount.search");
	if(reportname.equalsIgnoreCase(SDFCCreateAccountPage.this.capturedUsername))
	{
		//System.out.println();
		return true;
	}
	return false;
	
	
}

//	String orireportdetails=this.reportpagedisdetails.getText();
//	String orireportstatus=this.reportpagestatus.getText();
//	System.out.println("original report details"+orireportdetails+orireportstatus);
//	String expectedreportdetails1=ReadConfigFileutils.readfromcreateaccountpropertiesfile("savedreport.detailspage1");
//	String expectedreportdetails2=ReadConfigFileutils.readfromcreateaccountpropertiesfile("savedreport.detailspage2");
//	if(orireportdetails.equalsIgnoreCase(expectedreportdetails1))
//	{
//	return true;	
//	}
//	else
//	{
//	if(orireportdetails.equalsIgnoreCase(expectedreportdetails2))
//	{
//		return true;
//	}
//	}
	//return false;
	



public void viewnames(WebDriver driver)
{
	String randomUsername = "user"+ new Random().nextInt(1000); // Random username
    String randomEmail = "user"+new Random().nextInt(1000) + "example"; // Random email
    this.viewname.clear();
    this.viewname.sendKeys(randomUsername);
    this.viewunqname.clear();
    this.viewunqname.sendKeys(randomEmail);
}
public boolean verifyaccountviewlist(WebDriver driver) throws FileNotFoundException, IOException
{
	//this.accviewdropdown.click();
	//Select newview=new Select(this.accviewdropdown);
	//newview.selectByVisibleText(ReadConfigFileutils.readfromcreateaccountpropertiesfile("view.name"));
//	List<WebElement> listviewdrpdwn=this.accviewdropdown.findElements(By.xpath("//*[@id=\"00Bak00000RYHZx_listSelect\"]"));
//	
//	 String optionToCheck =ReadConfigFileutils.readfromcreateaccountpropertiesfile("view.name");
//	 System.out.println(ReadConfigFileutils.readfromcreateaccountpropertiesfile("view.name"));
//	// boolean isOptionPresent = false;
//	 
//    for (WebElement option : listviewdrpdwn) {
//    	System.out.println("dropdown options"+option.getText());
//    	//System.out.println("Verifynewviewadded");
//        if (option.getText().contains(optionToCheck)) {
//        	
//           return  true;
//            //break;
//        }
//        
//    }
	String value = driver.findElement(By.xpath("//input[@id='fname'and@name='fname']")).getAttribute("value");
	System.out.println(value);
	this.createviewsavebutton.click();
	WebElement dropdown = driver.findElement(By.className("title"));
	dropdown.click();
	Select dropdown_options = new Select(dropdown);
	List<WebElement> options = dropdown_options.getOptions();
	
	for(int i=0; i<options.size(); i++) {
		if(options.get(i).getText().equals(value)) {
			System.out.println("Account name is displayed in the dropdown");
			return true;
		}
//		WebElement dropdown1 = driver.findElement(By.className("title"));
//		dropdown.click();
//		Select dropdown_options1 = new Select(dropdown1);
//		dropdown_options1.selectByVisibleText(value);
//		driver.findElement(By.xpath("//a[contains(text(),'Delete')]")).click();
//		driver.switchTo().alert().accept();
	}
	return false;
}

//public void removeaccname(WebDriver driver) throws FileNotFoundException, IOException
//{
//	//String value = driver.findElement(By.xpath("//input[@id='fname'and@name='fname']")).getAttribute("value");
//	//System.out.println(value);
//	WebElement dropdown = driver.findElement(By.className("title"));
//	dropdown.click();
//	Select dropdown_options = new Select(dropdown);
//	dropdown_options.selectByVisibleText(value);
//	driver.findElement(By.xpath("//a[contains(text(),'Delete')]")).click();
//	driver.switchTo().alert().accept();
//}
//

}

