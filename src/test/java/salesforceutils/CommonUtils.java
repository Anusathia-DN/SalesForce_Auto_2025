package salesforceutils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import constants.FileConstants;

public class CommonUtils {
	

	
	//private static String MMddyyyy;
	public static String capturescreenshots(WebDriver driver, String testname){
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		String path=FileConstants.screenshot+testname;		
		File scsh=screenshot.getScreenshotAs(OutputType.FILE);
		File dest=new File(path);
		scsh.renameTo(dest);
		return path;
		
	}
	public static String getTimeStamp(){
		
	return new SimpleDateFormat("MMddyyyy").format(new Date());
		//return date;
		
		
	}
	
	
}
