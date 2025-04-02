package salesforcepageobjects;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import salesforceutils.ReadConfigFileutils;

public class SalesForceCreateOppurtunityPage {
	WebDriver driver;
	
	public  SalesForceCreateOppurtunityPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
@FindBy(xpath="//a[@title='Opportunities Tab']")
public WebElement oppurtunitytab;
@FindBy(xpath="//select[@id=\"fcf\"]")
public WebElement oppdropdown;
@FindBy(xpath="//input[@title='New']")
public WebElement oppnewbutton;
@FindBy(xpath="//input[@id=\"opp3\"]")
public WebElement oppname;
@FindBy(xpath="//input[@id=\"opp4\"]")
public WebElement accountname;
@FindBy(xpath="//input[@id=\"opp9\"]")
public WebElement closedate;
@FindBy(xpath="//select[@id=\"opp11\"]")
public WebElement stage;
@FindBy(xpath="//*[@id=\"opp12\"]")
public WebElement probability;
@FindBy(xpath="//select[@id=\"opp6\"]")
public WebElement leadsource;
@FindBy(xpath="//input[@id=\"opp17\"]")
public WebElement pricampsource;
@FindBy(xpath="//input[@value=\" Save \"and@name=\"save\"]")
public WebElement savebutton;
@FindBy(xpath="//a[contains(text(),'Stuck Opportunities')]")
public WebElement stuckopptab;
@FindBy(xpath="//select[@id=\"quarter_q\"]")
public WebElement quaterlyinterval;
@FindBy(xpath="//select[@id=\"open\"]")
public WebElement quaterlyinclude;
@FindBy(xpath="//input[@value='Run Report']")
public WebElement runreportbutton;
@FindBy(xpath="//select[@id=\"open\"and@name=\"open\"]")
public WebElement oppstatus;
@FindBy(xpath="//a[contains(text(),'Opportunity Pipeline')]")
public WebElement opp_pipeline;
public boolean verifyopppagetitle(WebDriver driver) throws FileNotFoundException, IOException
{
	String oriopppage=driver.getTitle();
	System.out.println("opp Page title:"+oriopppage);
	
	String expectedopptitle=ReadConfigFileutils.readfromcreateoppurtunitypropertiesfile("opppage.title");
	if(oriopppage.equalsIgnoreCase(expectedopptitle))
	{
		return true;
	}
	
	return false;
}
public boolean verifyoppeditpage(WebDriver driver) throws FileNotFoundException, IOException
{
	String orieditpage=driver.getTitle();
	System.out.println("opp EditPage title:"+orieditpage);
	String expectedoppedit=ReadConfigFileutils.readfromcreateoppurtunitypropertiesfile("oppedit.page");
	if(orieditpage.equalsIgnoreCase(expectedoppedit))
	{
		return true;
	}
	
	return false;
}

//@SuppressWarnings("unlikely-arg-type")
@SuppressWarnings("unlikely-arg-type")
public boolean verifyoppdrop(WebDriver driver) throws FileNotFoundException, IOException
{
	//String[] expectedoppdroplist=ReadConfigFileutils.readfromcreateoppurtunitypropertiesfile("opppage.dropdown").split(",");
	WebElement oppdropdown = driver.findElement(By.xpath("//select[@id=\"fcf\"]"));
	//oppdropdown.click();
	Select dropdown_options = new Select(oppdropdown);
	List<WebElement> oppoptions = dropdown_options.getOptions();
	 for (int j = 0; j < oppoptions.size(); j++) {
		 String[] expectedoppdroplist=ReadConfigFileutils.readfromcreateoppurtunitypropertiesfile("opppage.dropdown").split(",");
		 String actualoppdroplist=oppoptions.get(j).getText();
	        System.out.println(oppoptions.get(j).getText());
	        if(actualoppdroplist.equals(expectedoppdroplist))
			{
				return true;
			}

	    }
	return false;
	 
	//return false;
	
}
public boolean verifyfinalopppage(WebDriver driver) throws FileNotFoundException, IOException
{
	String orioppfinslpage=driver.getTitle();
	
	System.out.println("final opppage"+orioppfinslpage);
	String expectedfinalpage=ReadConfigFileutils.readfromcreateoppurtunitypropertiesfile("oppfinal.page");
	//WebElement oppfinalpage=driver.findElement(By.xpath("//h2[contains(text(),'Opportunity Detail')]"));
	if(orioppfinslpage.equalsIgnoreCase(expectedfinalpage))
	{
		return true;
	}
	return false;
	
}
public boolean verifyopp_pipelinepage(WebDriver driver) throws FileNotFoundException, IOException
{	
	String oriopp_pipe=driver.getTitle();
	System.out.println("opp_pipeline page:"+oriopp_pipe);
	String expected_pipepage=ReadConfigFileutils.readfromcreateoppurtunitypropertiesfile("opp_pipe.page");
	if(oriopp_pipe.equalsIgnoreCase(expected_pipepage))
	{
	return true;	
	}
	return false;
	//return false;
	
}
public boolean verifystuckopppage(WebDriver driver) throws FileNotFoundException, IOException
{
	//WebElement stuckopp=driver.findElement(By.xpath("//h1[@class='noSecondHeader pageType']"));
	String stuckopptitle=driver.getTitle();
	String expectedstucktitle=ReadConfigFileutils.readfromcreateoppurtunitypropertiesfile("stuckopp.page");
	if(stuckopptitle.equalsIgnoreCase(expectedstucktitle))
	{
	return true;	
	}
	return false;
}
public boolean verifyallquaterlysummary(WebDriver driver) throws FileNotFoundException, IOException
{
	Select quaterlyinter=new Select(this.quaterlyinterval);
	quaterlyinter.selectByVisibleText("Current and Next FQ");
	Select quaterlyinclude=new Select(this.quaterlyinclude);
	quaterlyinclude.selectByVisibleText("All Opportunities");
	this.runreportbutton.click();
	//System.out.println("allopp page title:"+driver.getTitle());
	//System.out.println("allopp page url:"+driver.getCurrentUrl());
	Select quaterlystatus=new Select(this.oppstatus);
	 WebElement selectedOption =quaterlystatus.getFirstSelectedOption();

     // Get the visible text of the selected option
     String selectedText = selectedOption.getText();
     System.out.println("Selected allOption Text: " + selectedText);

     // Get the value attribute of the selected option (if needed)
	 String oriselectedvalue=ReadConfigFileutils.readfromcreateoppurtunitypropertiesfile("allopp.status");
     String selectedValue = selectedOption.getAttribute("value");
     System.out.println("Selected_all_quaterly Option Value: " + selectedValue);
     if(oriselectedvalue.equalsIgnoreCase(selectedText))
     {
    	 this.oppurtunitytab.click();
    	 return true; 
    	
     }
	//boolean oriallquat=this.oppstatus.isSelected();
	//System.out.println("allopp status"+oriallquat);
     return false;
	
}
public boolean verifyopenquaterlysummary(WebDriver driver) throws InterruptedException, FileNotFoundException, IOException
{
	Select quaterlyinter=new Select(this.quaterlyinterval);
	quaterlyinter.selectByVisibleText("Current and Next FQ");
	Select quaterlyinclude=new Select(this.quaterlyinclude);
	quaterlyinclude.selectByVisibleText("Open Opportunities");
	this.runreportbutton.click();
	//System.out.println("openopp page title:"+driver.getTitle());
	//System.out.println("openopp page url:"+driver.getCurrentUrl());
	//Thread.sleep(1000);
	Select quaterlystatus=new Select(this.oppstatus);
	WebElement selectedOption = quaterlystatus.getFirstSelectedOption();

    // Get the visible text of the selected option
    String selectedText = selectedOption.getText();
    System.out.println("Selected openOption Text: " + selectedText);

    // Get the value attribute of the selected option (if needed)
	String oriselectedvalue=ReadConfigFileutils.readfromcreateoppurtunitypropertiesfile("openapp.status");
    String selectedValue = selectedOption.getAttribute("value");
    System.out.println("Selected_open_quaterly Option Value: " + selectedValue);
    if(oriselectedvalue.equalsIgnoreCase(selectedText))
    {
   	 this.oppurtunitytab.click();
   	 return true; 
   	
    }
	//String oriopenquat=this.oppstatus.getText();
	//System.out.println("openopp status"+oriopenquat);
	//this.oppurtunitytab.click();
    return false;
	
}
public boolean verifyclosedquaterlysummary(WebDriver driver) throws InterruptedException, FileNotFoundException, IOException
{
	Select quaterlyinter=new Select(this.quaterlyinterval);
	quaterlyinter.selectByVisibleText("Current and Next FQ");
	Select quaterlyinclude=new Select(this.quaterlyinclude);
	quaterlyinclude.selectByVisibleText("Closed Opportunities");
	this.runreportbutton.click();
	//System.out.println("closedopp page title:"+driver.getTitle());
	//System.out.println("closedopp page url:"+driver.getCurrentUrl());
	//Thread.sleep(1000);
	//String oriclosedquat=this.oppstatus.getText();
	//System.out.println("closedopp status"+oriclosedquat);
	Select quaterlystatus=new Select(this.oppstatus);
	WebElement selectedOption = quaterlystatus.getFirstSelectedOption();

    // Get the visible text of the selected option
    String selectedText = selectedOption.getText();
    System.out.println("Selected closedOption Text: " + selectedText);

    // Get the value attribute of the selected option (if needed)
	String oriselectedvalue=ReadConfigFileutils.readfromcreateoppurtunitypropertiesfile("closedopp.status");
    String selectedValue = selectedOption.getAttribute("value");
    System.out.println("Selected_closed_quaterly Option Value: " + selectedValue);
    if(oriselectedvalue.equalsIgnoreCase(selectedText))
    {
   	 this.oppurtunitytab.click();
   	 return true; 
   	
    }
    return false;
}
public void closedate(WebDriver driver)
{
	this.closedate.clear();
	LocalDate today = LocalDate.now();
	System.out.println("today startdate"+today);
	
    String formattedDate = today.format(DateTimeFormatter.ofPattern("d"));
    this.closedate.sendKeys(LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
}
public void oppstagedropdown(WebDriver driver)
{
	Select stage=new Select(this.stage);
	stage.selectByVisibleText("Prospecting");
}
public void leadsourcedropdown(WebDriver driver)
{
	Select leadsourcedropdown=new Select(this.leadsource);
	leadsourcedropdown.selectByVisibleText("Purchased List");
}


}
