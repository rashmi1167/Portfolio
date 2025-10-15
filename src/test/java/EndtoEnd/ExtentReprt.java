package EndtoEnd;

import java.time.LocalDate;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.Status;

public class ExtentReprt implements ITestListener
{
	
	
		public ExtentSparkReporter sparkReporter;  // UI of the report
		public ExtentReports extent;  //populate common info on the report
		public ExtentTest test; // creating test case entries in the report and update status of the test methods

		public void onStart(ITestContext context) {
			LocalDate currentDate = LocalDate.now();
			sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"\\src\\test\\resources\\Report\\Report.html"+ "_"+currentDate); //specify location of the report
			
			
			sparkReporter.config().setDocumentTitle("Automation Report"); // TiTle of report
			sparkReporter.config().setReportName("Functional Testing"); // name of the report
			sparkReporter.config().setTheme(Theme.STANDARD);
			
			
			extent=new ExtentReports();
			extent.attachReporter(sparkReporter);
			
			extent.setSystemInfo("Computer Name","Rashmi's Laptop");
			extent.setSystemInfo("Environment","Production");
			//extent.setSystemInfo("Tester Name","Rashmi Mishra");
			extent.setSystemInfo("os","Windows11");
			extent.setSystemInfo("Browser name","Chrome");
			extent.setSystemInfo("Date and time of Testing", "31 July 25 14:30 PM");
			extent.setSystemInfo("Version", "1.2.2");
						
		}


		public void onTestSuccess(ITestResult result) 
		{
			
			test = extent.createTest(result.getName()); // create a new enty in the report
			
			test.log(Status.PASS,  result.getName()+" Test case Pass " );// update status 
			
			
		}

		public void onTestFailure(ITestResult result) {
			
			test = extent.createTest(result.getName());
			test.log(Status.FAIL, result.getName()+"Test case Fail" );
			test.log(Status.FAIL, "Test Case FAILED cause is: " + result.getThrowable()); 
						
		}

		public void onTestSkipped(ITestResult result) {

			test = extent.createTest(result.getName());
			test.log(Status.SKIP, "Test case SKIPPED is:" + result.getName());
			
		}

		
		public void onFinish(ITestContext context) {
			
			extent.flush();
		}
}
