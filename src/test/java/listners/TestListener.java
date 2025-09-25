package listners;

import base.TestBase;
import util.Testutil;

import java.io.IOException;

import org.testng.*;

public class TestListener extends TestBase implements ITestListener {

	public void onTestStart(ITestResult result) {
		// not implemented
		System.out.println("Test Start");
	}

	public void onTestSuccess(ITestResult result) {
		// not implemented
		System.out.println("Test Success");
	}

	public void onTestFailure(ITestResult result) {
		// not implemented
		System.out.println("Test Failed");
		 System.out.println("Test failed: " + result.getName());

	        Testutil.takeScreenshotAtEndOfTest(driver, result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		// not implemented
		System.out.println("Test Skipped");
	}

	public void onFinish(ITestContext context) {
		// not implemented
		System.out.println("Test Finish");
	}
}
