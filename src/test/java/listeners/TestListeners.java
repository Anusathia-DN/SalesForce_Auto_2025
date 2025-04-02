package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import salesforcetestcases.BaseTest;

public class TestListeners implements ITestListener {
	
	
	public void onTestSuccess(ITestResult result)
	{
		BaseTest.threadtest.get().pass(result.getTestName()+"PASSED");
			}
	public void onTestFailure(ITestResult result, String testname)
	{
		BaseTest.threadtest.get().fail(result.getTestName()+"FAILED");
		BaseTest.threadtest.get().addScreenCaptureFromPath(salesforceutils.CommonUtils.capturescreenshots(BaseTest.threadlocaldriver.get(),testname));
	}
	
	public void onTestStart(ITestResult result)
	{
		BaseTest.report.createTest(result.getName()+"STARTED");
	}
	public void onTestSkipped(ITestResult result)
	{
		BaseTest.report.createTest(result.getName()+"SKIPPED");
	}

}
