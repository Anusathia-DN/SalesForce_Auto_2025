package constants;

import salesforceutils.CommonUtils;

public class FileConstants {
	
	public static final String Root_Path=System.getProperty("user.dir");
	public static final String Login_Properties_File_Path=Root_Path+"/configfiles/configlogin.properties";
	public static final String Home_Properties_File_Path=Root_Path+"/configfiles/confighome.properties";
	public static final String UserMenu_Properties_File_Path=Root_Path+"/configfiles/configusermenu.properties";
	public static final String CreateAccount_Properties_File_Path=Root_Path+"/configfiles/configcreateaccount.properties";
	//public static final String UserMenu_Properties_File_Path="";
	
	public static final String screenshot=Root_Path+"./src/test/resources/reports/"+CommonUtils.getTimeStamp()+".PNG";

	public static final String extendreport=Root_Path+"./src/test/resources/reports/"+CommonUtils.getTimeStamp()+".html";
}
