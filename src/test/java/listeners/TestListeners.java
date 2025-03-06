package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import salesforcetestcases.BaseTest;

public class TestListeners implements ITestListener {
	
	
	public void onTestSuccess(ITestResult result)
	{
		BaseTest.test.pass(result.getTestName()+"PASSED");
			}
	public void onTestFailure(ITestResult result, String testname)
	{
		BaseTest.test.fail(result.getTestName()+"FAILED");
		BaseTest.test.addScreenCaptureFromPath(salesforceutils.CommonUtils.capturescreenshots(BaseTest.threadlocaldriver.get(),testname));
	}
	
	public void onTestStart(ITestResult result)
	{
		BaseTest.report.createTest(result.getName()+"Started");
	}

}
