package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	static ExtentReports extent;
	public static ExtentReports getReportInfo()
	{
		String path= System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);//this method is responsible for creating and configuration of report
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		extent=new ExtentReports();//this will create and consolidate all the reports
		extent.attachReporter(reporter);
		extent.setSystemInfo("tester", "Trideepta");
		return extent;
	}

}
