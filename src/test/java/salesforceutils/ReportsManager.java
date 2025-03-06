package salesforceutils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import constants.FileConstants;

public class ReportsManager {
	public static ExtentReports report;
	
	public static ExtentReports getInstance() {
		
		if(report==null) {
			ReportsManager.createInstance();
		}
		
		return report;
		
	}
	public static ExtentReports createInstance() {
		ExtentSparkReporter sparkreport=new ExtentSparkReporter(FileConstants.extendreport);
		sparkreport.config().setDocumentTitle("SDFC-Reports");
		report=new ExtentReports();
		report.attachReporter(sparkreport);
		return report;
		
	}

}
