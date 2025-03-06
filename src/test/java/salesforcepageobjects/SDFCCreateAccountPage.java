package salesforcepageobjects;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
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
@FindBy(xpath="//div[@id='stageForm'and@class='pbWizardTitle tertiaryPalette brandTertiaryBgr']")
public WebElement mergeaccstep2;
@FindBy(xpath="//tr[@id='stageForm'and@class='dataRow even first']")
public WebElement mergeaccowner1;
@FindBy(xpath="//tr[@class='dataRow odd']")
public WebElement mergeaccowner2;

public boolean verifyaccountusername(WebDriver driver) throws FileNotFoundException, IOException
{
	//String oriaccountuserdisplay=this.accountusernamedisplay.getText();
	String expectedaccuserdisp=ReadConfigFileutils.readfromcreateaccountpropertiesfile("account.name");
	if(expectedaccuserdisp.contains("Anuradha Sathiamurthy")) 
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
		if(Button1.isSelected())
		{
			 
			 if(Button2.isSelected())
			 {
				 
				   // Radiobutton(Button3, "RadioButton");
				 Button3.click();
			 }
			 else
			 {
				 Button2.click();
				 if(Button3.isSelected())
				 {
					Button3.click(); 
				 }
			 }
		}
		else
		{
			Button1.click();
			//WebElement Button2 = driver.findElement(By.xpath("//input[@id='cid1']"));
			 if(Button2.isSelected())
			 {
				 this.mergeaccnextbutton.click();
			 }
			   // Radiobutton(Button2, "RadioButton");
		}
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
	System.out.println(step2msg);
	String expectedmsg=ReadConfigFileutils.readfromcreateaccountpropertiesfile("merge.step2");
	if(step2msg.equalsIgnoreCase(expectedmsg))
	{
	
		return true;
	}
	return false;
	
}
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
