package salesforceutils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import constants.FileConstants;

public class ReadConfigFileutils {
	//public static String Key = null;

	public static String readfromloginpropertiesfile(String Key) throws FileNotFoundException, IOException {
		Properties p=new Properties();
		p.load(new FileReader(FileConstants.Login_Properties_File_Path));
		return p.getProperty(Key);
		
		
	}
	public static String readfromhomepropertiesfile(String Key) throws FileNotFoundException, IOException {
		Properties p=new Properties();
		p.load(new FileReader(FileConstants.Home_Properties_File_Path));
		return p.getProperty(Key);
		
		
	}
	public static String readfromusermenupropertiesfile(String Key) throws FileNotFoundException, IOException {
		Properties p=new Properties();
		p.load(new FileReader(FileConstants.UserMenu_Properties_File_Path));
		return p.getProperty(Key);
		
		
	}
	public static String readfromcreateaccountpropertiesfile(String Key) throws FileNotFoundException, IOException {
		Properties p=new Properties();
		p.load(new FileReader(FileConstants.CreateAccount_Properties_File_Path));
		return p.getProperty(Key);
		
		
	}
//	public static String getApplicationURL()
//	{
//		Properties p=new Properties();
//		String URL=p.getProperty("baseURL");
//		return URL;
//	}
//	public String getUserName()
//	{
//		Properties p=new Properties();
//		String UserName=p.getProperty("UserName");
//		return UserName;
//	}
//	public String getPasswrd()
//	{
//		Properties p=new Properties();
//		String Password=p.getProperty("Password");
//		return Password;
//	}
	
	//private static String Key;
//	Properties pro;
//	public ReadConfigFileutils()
//	{
//		File src=new File("./configfiles/configlogin.properties");
//		System.out.println("Read the Config file");
//	
//	try
//	{
//		FileInputStream fis= new FileInputStream(src);
//		Properties pro=new Properties();
//		pro.load(fis);
//	}
//	catch(Exception e)
//	{
//		System.out.println("The Error Message is"+e.getMessage());
//	}
//	//return Key;
//
//}
//	public String getPageTitle()
//	{
//		String pagetitle=pro.getProperty("page.title");
//		return pagetitle;
//	}
		//public  String getUserName()	{
//		String UserName=pro.getProperty("valid.userName");
//		return UserName;
//	}
//	public String getPasswrd()
//	{
//		String Password=pro.getProperty("valid.password");
//		return Password;
//	}
//	

}
