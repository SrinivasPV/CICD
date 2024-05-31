package rahulshettyacademy.resource;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportNG {
	
	public static ExtentReports getReport()
	{
		String property ="./reports/index.html";
	    ExtentSparkReporter reporter = new ExtentSparkReporter(property);
	    reporter.config().setReportName("Web Automation Report");
	    reporter.config().setDocumentTitle("Extend Report");
	    ExtentReports extent = new ExtentReports();
	    extent.attachReporter(reporter);
	    extent.setSystemInfo("Tester", "Srinivas");
	    return extent;
	    
	}

}
