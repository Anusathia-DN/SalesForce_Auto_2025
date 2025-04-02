package salesforcepageobjects;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import salesforcetestcases.BaseTest;
import salesforceutils.ReadConfigFileutils;
import salesforceutils.WaitUtils;

public class SalesForceLeadsPage {
	
	WebDriver driver;
	public  SalesForceLeadsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
@FindBy(xpath="//a[@title=\"Leads Tab\"]")
public WebElement leadstab;
@FindBy(xpath="//select[@id=\"fcf\"]")
public WebElement leadsdropdown;
@FindBy(xpath="//input[@name=\"go\"and@value=\" Go! \"]")
public WebElement leadsgobutton;
@FindBy(xpath="//input[@value=\" New \"]")
public WebElement leads_new_button;
@FindBy(xpath="//input[@id=\"name_lastlea2\"]")
public WebElement leadsnew_lastname;
@FindBy(xpath="//input[@id=\"lea3\"]")
public WebElement leadsnew_companyname;
@FindBy(xpath="//input[@value=\" Save \"]")
public WebElement leads_save_button;


public boolean verifyleadshome(WebDriver driver) throws FileNotFoundException, IOException
{
	//WaitUtils.waitForElement(driver, );
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String orileadshome=driver.getTitle();
	String expectedleadshome=ReadConfigFileutils.readfromleadspropertiesfile("leadshome.page");
	if(orileadshome.equalsIgnoreCase(expectedleadshome))
	{
		return true;
	}
	return false;
}
@SuppressWarnings("unlikely-arg-type")
public boolean verifyleadsdropdown(WebDriver driver) throws FileNotFoundException, IOException 
{

	//WebElement oppdropdown = driver.findElement(By.xpath("//select[@id=\"fcf\"]"));
	//oppdropdown.click();
	 
	Select leadsdropdown_options = new Select(leadsdropdown);
	List<WebElement> oppoptions = leadsdropdown_options.getOptions();
	 for (int j = 0; j < oppoptions.size(); j++) {
		 String[] expectedleadsdroplist=ReadConfigFileutils.readfromleadspropertiesfile("leadshome.dropdown").split(",");
		 System.out.println("from config"+expectedleadsdroplist);
		 String actualleadsdroplist=oppoptions.get(j).getText();
	        System.out.println(oppoptions.get(j).getText());
	        if(actualleadsdroplist.equals(expectedleadsdroplist))
			{
				return true;
			}
	       }
	 return false;
}
public void todaysleads(WebDriver driver)
{
	Select leadsdropdown_options = new Select(this.leadsdropdown);
	leadsdropdown_options.selectByVisibleText("Today's Leads");
	String aftergobuttonpage=driver.getTitle();
	System.out.println("aftergo button page:"+aftergobuttonpage);
	//this.leadsgobutton.click();
}
public boolean verifytodaysleadtable(WebDriver driver) 
{
	WebElement table=driver.findElement(By.xpath("//table[@class=\"x-grid3-row-table\"]"));
	List <WebElement> rows=table.findElements(By.tagName("td"));
	if (!rows.isEmpty()) {
		
        System.out.println("The table is populated with data. Number of rows: " + rows.size());
        return true;
	}
	return false;
}
public boolean verifynewleadstabledisplay(WebDriver driver)
{
	WebElement table=driver.findElement(By.xpath("//table[@class=\"detailList\"]"));
	List <WebElement> rows=table.findElements(By.tagName("td"));
	if (!rows.isEmpty()) {
		
        System.out.println("The table is populated with data. Number of rows: " + rows.size());
        return true;
	}
	return false;
	
}

}
