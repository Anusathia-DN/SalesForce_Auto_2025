package salesforcepageobjects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import salesforceutils.ReadConfigFileutils;
import salesforceutils.WaitUtils;

public class UserMenuSalesforcePage {
	
	//WebDriver driver;
	public  UserMenuSalesforcePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	 String downloadPath = "C:\\Users\\anura_1ckmn7y\\Downloads";
	
	@FindBy(id="username")
	public WebElement username;
	
	@FindBy(id="password")
	public WebElement password;
	@FindBy(id="Login")
	public WebElement loginbutton;
	@FindBy(id="userNav")
	public WebElement usermenu;
	@FindBy(xpath="//*[@id=\"userNavMenu\"]")
	public WebElement usermenulist;
	@FindBy(xpath="//*[@class='menuButtonMenuLink firstMenuItem'and@title='My Profile']")
	public WebElement myprofile;
	@FindBy(xpath="//*[@id=\"chatterTab\"]/div[2]/div[2]/div[1]/h3/div/div/a/img")
	public WebElement myprofile_edit;
	@FindBy(id="aboutTab")
	public WebElement abouttab;
	@FindBy(xpath="//input[@id=\"lastName\"]")
	public WebElement abouttablastname;
	@FindBy(xpath="//input[@onclick='javascript: validateAndSave();']")
	public WebElement savelastname;
	@FindBy(xpath="//*[@id=\"TabPanel\"]/div/div[2]/form/div/input[1]")
	public WebElement saveallbutton;
	@FindBy(xpath="//*[@id=\"userNav-menuItems\"]/a[5]")
	public WebElement logout;
	@FindBy(xpath="//a[@id='publisherAttachTextPost'and@title='Post']")
	public WebElement postlink;
	@FindBy(xpath="//iframe[contains(@title,'Rich Text Editor, publisherRichTextEditor')]")
	public WebElement postiframe;
	@FindBy(xpath="//html[1]/body[1]")
	public WebElement posttext;
	@FindBy(xpath="//*[@id=\"publishersharebutton\"]")
	public WebElement posttextsharebutton;
	@FindBy(xpath="//a[@id=\"publisherAttachContentPost\"]/span[1]")
	public WebElement uploadfilelink;
	@FindBy(xpath="//td[@id='chatterUploadFileActionPanel']")
	public WebElement uploadfilebutton;
	@FindBy(xpath="//input[@id='chatterFile'and@name='chatterFile']")
	public WebElement choosefile;
	@FindBy(xpath="//input[@id='publishersharebutton'and@value='Share']")
	public WebElement uploadsharebutton;
	@FindBy(xpath="//*[@id=\"userNav-menuItems\"]/a[2]")
	public WebElement mysettingstab;
	@FindBy(xpath="//*[@id='PersonalInfo_font'and@class='folderText']")
	public WebElement personaltab;
	@FindBy(xpath="//*[@id='LoginHistory_font'and@class='leafText']")
	public WebElement loginhistory;
	@FindBy(xpath="//*[@id='RelatedUserLoginHistoryList_body']/div")
	public WebElement downloadhist;
	@FindBy(xpath="//*[@id='DisplayAndLayout_font'and@class='folderText']")
	public WebElement displaylayout;
	@FindBy(xpath="//*[@id='CustomizeTabs_font'and@class='leafText']")
	public WebElement customtab;
	@FindBy(xpath="//*[@id='p4'and@name='p4']")
	public WebElement customappdropdwn;
	@FindBy(xpath="//*[@id='duel_select_0'and@name='duel_select_0']")
	public WebElement availabletab;
	@FindBy(xpath="//*[@id=\'duel_select_0_right']/img")
	public WebElement addbutton;
	@FindBy(xpath="//select[@id='duel_select_1'and@name='duel_select_1']")
	public WebElement selectedtabdrpdwn;
	@FindBy(xpath="//*[@id=\"bottomButtonRow\"]/input[1]")
	public WebElement selectedtabsavebutton;
	@FindBy(xpath="//div[@id=\"photoSection\"]")
	public WebElement uploadphotoonmousehover;
	@FindBy(xpath="//*[@id=\"uploadLink\"]")
	public WebElement uploadphotobutton;
	@FindBy(xpath="//*[@id='j_id0:uploadFileForm:uploadInputFile'and@class='fileInput']")
	public WebElement uploadphotochoosefile;
	@FindBy(xpath="//input[@id='j_id0:uploadFileForm:uploadBtn'and@name='j_id0:uploadFileForm:uploadBtn']")
	public WebElement uploadphotosavebutton;
	@FindBy(xpath="//input[@id='j_id0:j_id7:save'and@class='btn saveButton']")
	public WebElement cropphotosavebutton;
	@FindBy(xpath="//*[@id=\"contactInfoTitle\"]")
	public WebElement profileditpage;
	@FindBy(xpath="//li[@id='contactTab'and@class='zen-current']")
	public WebElement contactab;
	@FindBy(xpath="//span[@id='tailBreadcrumbNode'and@class='tailNode cxTailNode']")
	public WebElement profilelastname;
	@FindBy(xpath="//*[@id=\"duel_select_0_left\"]/img")
	public WebElement removebutton;
	@FindBy(xpath="//div[@id='tabContainer'and@class='brdPalette zen-headerBottom zen-hasTabOrganizer']")
	public WebElement mysettingstoptab;
	@FindBy(xpath="//li[@id='home_Tab'and@class='zen-firstItem']")
	public WebElement homepagebutton;
	@FindBy(xpath="//span[@id='tsidLabel'and@class='menuButtonLabel']")
	public WebElement appswitchbutton;
	@FindBy(xpath="//*[@id=\"tsid-menuItems\"]/a[1]")
	public WebElement salestab;
	@FindBy(xpath="//*[@id=\"tsid-menuItems\"]/a[6]")
	public WebElement saleschattertab;
	@FindBy(xpath="//span[@id='EmailSetup_font'and@class='folderText']")
	public WebElement emailbutton;
	@FindBy(xpath="//a[@id='EmailSettings_font']")
	public WebElement emailsettings;
	@FindBy(xpath="//div[@id='meSaveCompleteMessage'and@class='message confirmM4']")
	public WebElement emailsettingserrordis;
	@FindBy(xpath="//span[@id='CalendarAndReminders_font'and@class='folderText']")
	public WebElement calenderandreminderbutton;
	@FindBy(xpath="//a[@id='Reminders_font']")
	public WebElement calenderactivity;
	@FindBy(xpath="//input[@id='testbtn']")
	public WebElement opentestreminder;
	@FindBy(xpath="//input[@id='sender_name'and@name='sender_name']")
	public WebElement emailname;
	@FindBy(xpath="//input[@id='sender_email'and@name='sender_email']")
	public WebElement emailaddress;
	@FindBy(xpath="//input[@id='auto_bcc1'and@name='auto_bcc']")
	public WebElement emailbccradiobutton;
	@FindBy(xpath="//*[@id='bottomButtonRow']/input[1]")
	public WebElement emailsavebutton;
	@FindBy(xpath="//a[contains(text(),'Developer Console')]")
	public WebElement developerconsolebutton;
//	@FindBy(xpath="//iframe[contains(@title,'Rich Text Editor, publisherRichTextEditor')]")
//	public WebElement postiframe;
	
	
//	public void enterusername(String username){
//		this.username.clear();
//		this.username.sendKeys(username);
//		
//	}
//	public void enterpassword(String password) {
//		this.password.clear();
//		this.password.sendKeys(password);
//		
//	}
//	public void clickloginbutton() {
//		this.loginbutton.click();
//	}
//	
//	public void logintosalesforce(WebDriver driver)
//	{
//		this.enterusername(ReadConfigFileutils.readfromloginpropertiesfile(""));
//		this.enterpassword(password);
//		this.clickloginbutton();
//	}
	public boolean verifymysettingdisp(WebDriver driver) throws FileNotFoundException, IOException
	{
		String expectedmysettingpage=ReadConfigFileutils.readfromusermenupropertiesfile("mysettings.pageurl");
		String actualsettingpage=driver.getCurrentUrl();
		return expectedmysettingpage.equalsIgnoreCase(actualsettingpage);
		
	}
	public boolean verifyloginhistorydwnld(WebDriver driver)
	{
		File getLatestFile = this.getLatestFilefromDir("downloadPath");
		String fileName = getLatestFile.getName();
		if(this.isFileDownloaded_Extension("downloadPath", ".csv", fileName) == true) {
			System.out.println("file is downloded");
			return true;
		}
		
			System.out.println("file is not downloded");
			return false;
		
		
		
	}
	public boolean verifyreporttabadded(WebDriver driver)
	{
		this.displaylayout.click();
		this.customtab.click();
		Select customapp=new Select(this.customappdropdwn);
		customapp.selectByVisibleText("Salesforce Chatter");
//		for(int i=0;i<expectedmenulist.length;i++)
//		{
		//this.selectedtabdrpdwn.click();
		//Select selectdropdown = new Select(this.selectedtabdrpdwn);
		List<WebElement> selectappdrpdwn=this.selectedtabdrpdwn.findElements(By.xpath("//*[@id=\"duel_select_1\"]"));
		//System.out.println(selectappdrpdwn);
		 String optionToCheck = "Reports";
		 boolean isOptionPresent = false;
        
        for (WebElement option : selectappdrpdwn) {
        	System.out.println("Verifyreporttabadded");
            if (option.getText().contains(optionToCheck)) {
            	isOptionPresent = true;
               return  true;
                //break;
            }
            
        }
        
        if (isOptionPresent=true) {
            System.out.println("The option '" + optionToCheck + "' is present in the Selectappdropdown.");
            //isOptionPresent;
        } else {
            System.out.println("The option '" + optionToCheck + "' is not present in the Selectappdropdown.");
       // return isOptionPresent;
        }
//		for(int i=0;i<selectdrpdwn;i++)
//		{
//			String[] selectedtab=this.selectedtabdrpdwn;
//		}
		//return false;
		return false;
			}
	public boolean verifyreoprtabdisplayed(WebDriver driver)
	{
		//driver.navigate().refresh();
		List<WebElement> tabsdisp=this.mysettingstoptab.findElements(By.xpath("//ul[@id='tabBar'and@class='zen-inlineList zen-tabMenu']"));
		 for (WebElement option : tabsdisp) {
	            //System.out.println(option.getText());
	        
		String dispchk="Reports";
		boolean isOptionPresent1 = false;
		for (WebElement option1 : tabsdisp) {
        	//System.out.println("topsetting tabs:"+" "+option1.getText());
            if (option1.getText().contains(dispchk)) {
            	
                isOptionPresent1 = true;
                System.out.println("verified report tab on top menu"+"verifyreoprtabdisplayed");
                return true;
//                this.homepagebutton.click();
//                for (WebElement option2 : tabsdisp) {
//                	System.out.println("topsetting tabs"+option2.getText());
//                    if (option2.getText().contains(dispchk)) {
//                if(option2.getText().contains(dispchk))
//                {
//                	 isOptionPresent1 = true;
//                     System.out.println("verified report tab in HomePage");
//                }
            }
           
            	//[
           //return isOptionPresent1 ; 
		}
		 }
           //return isOptionPresent1;
		//return isOptionPresent1;
		//this.homepagebutton.click();	
		return false;
        }
		public boolean verifyreportdisphome(WebDriver driver)
		{
			
 			//this.homepagebutton.click();
 			List<WebElement> hometabsdisp=this.mysettingstoptab.findElements(By.xpath("//ul[@id='tabBar'and@class='zen-inlineList zen-tabMenu']"));
//			 for (WebElement option : hometabsdisp);
//			 {
//		            System.out.println(option.getText());
//		        }
			String optionToCheck="Reports";
			boolean isOptionPresent = false;
           for (WebElement option : hometabsdisp) {
           	System.out.println("homepage tabs:");
               if (option.getText().contains(optionToCheck)) {
           if(option.getText().contains(optionToCheck))
           {
           	 isOptionPresent = true;
                System.out.println("verified report tab in HomePage");
                return true;
           }
          
			//return isOptionPresent;
               }
           }
		//return isOptionPresent;
		return false;
			
		}
		public boolean verifyreportinsalesmarkettab(WebDriver driver)
		{
			this.appswitchbutton.click();
			this.salestab.click();
			//driver.findElement(By.xpath("//*[@id=\"tsid-menuItems\"]/a[1]")).click();
			List<WebElement> salestabsdisp=this.mysettingstoptab.findElements(By.xpath("//ul[@id='tabBar']"));
//			 for (WebElement option : hometabsdisp);
//			 {
//		            System.out.println(option.getText());
//		        }
			String optionToCheck="Reports";
			boolean isOptionPresentchatter = false;
          for (WebElement option : salestabsdisp) {
          	System.out.println("Salespage tabs");
              if (option.getText().contains(optionToCheck)) {
          if(option.getText().contains(optionToCheck))
          {
        	  isOptionPresentchatter = true;
               System.out.println("verified report tab in SalesPage");
               this.appswitchbutton.click();
               this.saleschattertab.click();
               //driver.findElement(By.xpath("//*[@id=\"tsid-menuItems\"]/a[6]"));
               List<WebElement> saleschatter=this.mysettingstoptab.findElements(By.xpath("//ul[@id='tabBar']"));
//  			 for (WebElement option : hometabsdisp);
//  			 {
//  		            System.out.println(option.getText());
//  		        }
  			String optionToCheckchatter="Reports";
  			boolean chatterisOptionPresent = false;
            for (WebElement optionchatter : saleschatter) {
            	System.out.println("Saleschatterpage tabs");
                if (optionchatter.getText().contains(optionToCheckchatter)) {
            if(optionchatter.getText().contains(optionToCheckchatter))
            {
            	isOptionPresentchatter = true;
                System.out.println("verified report tab in SaleschatterPage");
                return true;
//                this.usermenu.click();
//        		this.mysettingstab.click();
//        		this.displaylayout.click();
//        		this.customtab.click();
//        		Select customapp1=new Select(this.customappdropdwn);
//        		customapp1.selectByVisibleText("Salesforce Chatter");
            }
          }	
              }
          }
          
         // return false;
              
              }
          }
		return false;
		}
	

	
		//System.out.println("topsetting tabs"+tabsdisp);
		//return tabsdisp;
		
	
	public void releasereportselection(WebDriver driver)
	{
		List<WebElement> selectappdrpdwn=this.selectedtabdrpdwn.findElements(By.xpath("//*[@id=\"duel_select_1\"]"));
		//System.out.println(selectappdrpdwn);
		 String optionToCheck = "Reports";
		 boolean isOptionPresent = false;
        
        for (WebElement option : selectappdrpdwn) {
        	//System.out.println(option.getText());
            if (option.getText().equalsIgnoreCase(optionToCheck)) {
            	
                isOptionPresent = true;
                //break;
            }
        }
        
        if (isOptionPresent=true) {
          
            this.selectedtabdrpdwn.click();
            Select selectdropdown = new Select(this.selectedtabdrpdwn); 
            selectdropdown.selectByContainsVisibleText("Report");
            this.removebutton.click();
            this.selectedtabsavebutton.click();
            System.out.println("Removed Report from Selectappdropdown.");
        } 
	}
	public void emailsetup(WebDriver driver) throws FileNotFoundException, IOException
	{
		this.emailname.clear();
		this.emailname.sendKeys(ReadConfigFileutils.readfromusermenupropertiesfile("email.name"));
		this.emailaddress.clear();
		this.emailaddress.sendKeys(ReadConfigFileutils.readfromusermenupropertiesfile("email.address"));
		this.emailbccradiobutton.click();
		this.emailsavebutton.click();
	}
	public boolean verifyemailsettext(WebDriver driver) throws FileNotFoundException, IOException
	{
		String expectedEmailtext=ReadConfigFileutils.readfromusermenupropertiesfile("email.text");
		String originalemailtext=this.emailsettingserrordis.getText();
		if(expectedEmailtext.equalsIgnoreCase(originalemailtext)) {
			System.out.println(this.emailsettingserrordis.getText());
			return true;
		}
		return false;
		
	}
	public boolean verifycalenderopenwindow(WebDriver driver) throws FileNotFoundException, IOException
	{
		driver.navigate().forward();
		//String newpage=driver.getTitle();
		
		String expectedcalpagetitle=ReadConfigFileutils.readfromusermenupropertiesfile("calender.popup");;
		String oricalpagetitle=driver.getTitle();
		System.out.println("newpage title"+oricalpagetitle);
		if(expectedcalpagetitle.equalsIgnoreCase(oricalpagetitle))
		{
		driver.switchTo().parentFrame();
		return true;
		}
		return false;
	}
	public boolean verifydeveloperconsole(WebDriver driver)
	{
		String parentWindowHandle = driver.getWindowHandle();
	System.out.println("parent window"+driver.getWindowHandle());
	// Step 3: Get all window handles
	Set<String> allWindowHandles = driver.getWindowHandles();

	for (String windowHandle : allWindowHandles) {
	    if (!windowHandle.equals(parentWindowHandle)) {
	        // Step 4: Switch to the new window
	        driver.switchTo().window(windowHandle);
	        System.out.println("New Window"+""+driver.getWindowHandle());
	        
	        driver.switchTo().parentFrame();
	        return true;
	       // break;
	    }
	    
	}

	// Step 5: Perform actions on the new window
	System.out.println("New Window Title: " + driver.getTitle()); 
	return false;
		
	}
	public String baseurl(WebDriver driver) throws FileNotFoundException, IOException
	{
		String url=ReadConfigFileutils.readfromloginpropertiesfile("base.url");
		return url ;
	}
//	public boolean verifyeditprofilepage() throws FileNotFoundException, IOException
//	{
//		System.out.println("profileditpage text  :"+this.profileditpage.getText());
//		
//		return false;
//		
//	}
	public boolean verifyeditpage(WebDriver driver) throws FileNotFoundException, IOException
	{
		WaitUtils.waitForElement(driver, this.profileditpage);
		String expectededitpage=ReadConfigFileutils.readfromusermenupropertiesfile("editprofile.page");
		String orieditpage=this.profileditpage.getText();
		return expectededitpage.equalsIgnoreCase(orieditpage);
	}
	public boolean verifytabs(WebDriver driver) throws FileNotFoundException, IOException
	{
		WaitUtils.waitForElement(driver, this.contactab);
		String expectcontactverify=ReadConfigFileutils.readfromusermenupropertiesfile("contact.tab");
		String oricontact=this.contactab.getText();
		String expectabouttabverify=ReadConfigFileutils.readfromusermenupropertiesfile("about.tab");
		String oriabouttab=this.abouttab.getText();
		return expectabouttabverify.equalsIgnoreCase(oriabouttab)&&(expectcontactverify.equalsIgnoreCase(oricontact));
	}
	
	public void editprofile(WebDriver driver) throws FileNotFoundException, IOException 
	{
		
		//this.myprofile_edit.click();
		
//		if(expectededitpage.equalsIgnoreCase(orieditpage))
//		{
	
		driver.switchTo().frame("contactInfoContentId");
		System.out.println("Inside  editclick Iframe");
//		String expectcontactverify=ReadConfigFileutils.readfromusermenupropertiesfile("contact.tab");
//		String oricontact=this.contactab.getText();
//		String expectabouttabverify=ReadConfigFileutils.readfromusermenupropertiesfile("about.tab");
//		String oriabouttab=this.abouttab.getText();
//		if(expectabouttabverify.equalsIgnoreCase(oriabouttab)&&(expectcontactverify.equalsIgnoreCase(oricontact)))
//		{
		System.out.println("Abouttabcolour beforeclick :"+this.abouttab.getCssValue("background-color"));
		this.abouttab.click();
		System.out.println("Abouttabcolour afterclick :"+this.abouttab.getCssValue("background-color"));
		this.abouttablastname.clear();
		this.abouttablastname.sendKeys(ReadConfigFileutils.readfromusermenupropertiesfile("lastname.change"));
		this.savelastname.click();
		driver.switchTo().parentFrame();
		System.out.println("Back to parent frame");
	
	}
	public boolean verifyaboutlastname(WebDriver driver) throws FileNotFoundException, IOException
	{
		String expectedlastname=ReadConfigFileutils.readfromusermenupropertiesfile("lastname.change");
		String[] originalastname=this.profilelastname.getText().split(" ");
		return expectedlastname.equalsIgnoreCase(originalastname[1]) ;
	}
	public void postclickprofilepage(WebDriver driver) throws FileNotFoundException, IOException
	{
		//driver.switchTo().frame("//iframe[contains(@title,'Rich Text Editor, publisherRichTextEditor')]");	
		//System.out.println("Inside PostText Frame");
		this.posttext.sendKeys(ReadConfigFileutils.readfromusermenupropertiesfile("posttext.send"));
		
		driver.switchTo().parentFrame();
		System.out.println("Out Of PostText Iframe");
		this.posttextsharebutton.click();
	}
	public boolean verifyprofilepage(WebDriver driver) throws FileNotFoundException, IOException
	{
		String expectedprofiletitle=ReadConfigFileutils.readfromusermenupropertiesfile("profile.pageurl");
		String actualprofile=driver.getCurrentUrl();
		return expectedprofiletitle.equalsIgnoreCase(actualprofile) ;
		
	}
//	public boolean verifydownldloginhist(WebDriver driver)
//	{
//		File getLatestFile = this.getLatestFilefromDir("downloadPath");
//		String fileName = getLatestFile.getName();
//		if(this.isFileDownloaded_Extension("downloadPath", ".csv", fileName) == true) {
//			System.out.println("file is downloded");
//			return true;
//		}
//		
//			System.out.println("file is not downloded");
//			return false;
//		
//	}
//	public void uploadfilelinkbutton(WebDriver driver) throws FileNotFoundException, IOException
//	{
//		//this.uploadfilelink.click();
//		//System.out.println("Clicked on filelink");
//		 this.uploadfilebutton.click();
//		 System.out.println("clicked on uploadfile button on computer");
//		 WaitUtils.waitForElement(driver, this.choosefile);
//		 this.choosefile.click();
//		 System.out.println("Choosefile button clicked");
//		 this.choosefile.sendKeys(ReadConfigFileutils.readfromusermenupropertiesfile("choosefile.profile"));
//		 System.out.println("choosefile option is selected");
//		 this.uploadsharebutton.click();
//	}
//	public String verifyusermenulist(WebDriver driver) throws FileNotFoundException, IOException
//	{
//		String menulist=this.usermenulist.getText();
//		String expectedmenulist=ReadConfigFileutils.readfromloginpropertiesfile("");
//		return expectedmenulist ;
//		
//	}
	public File getLatestFilefromDir(String dirPath) {
		File dir = new File(downloadPath);
		File[] files = dir.listFiles();
		if(files == null || files.length==0) {
			return null;
		}
		File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	           lastModifiedFile = files[i];
	       }
	    }
	    return lastModifiedFile;
	}
	public boolean isFileDownloaded_Extension(String dirPath, String extension, String downloadPath) {
		boolean flag = false;
		File dir = new File(this.downloadPath);
		File[] files = dir.listFiles();
		if(files == null || files.length==0) {
			flag = false;
		}
		for(int i=1; i<files.length; i++) {
			if(files[i].getName().contains(extension)) {
				flag = true;
			}
		}
		return flag;
	}
	public boolean isFileDownloaded(String downloadPath, String fileName) {
		boolean flag = false;
		File dir = new File(this.downloadPath);
		File[] dir_contents = dir.listFiles();
	
			for(int i=0; i<dir_contents.length; i++) {
				if(dir_contents[i].getName().equalsIgnoreCase(fileName)) {
				return flag = true;
			}
		}
		return flag;
	}
//	public void postclickprofilepage(WebDriver driver2) {
//		// TODO Auto-generated method stub
//		
//	}
//	
}
