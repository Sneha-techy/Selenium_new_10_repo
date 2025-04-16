package extentreports;

import java.time.LocalDateTime;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LearnExtentReports {
@Test
public void createReport() {
	String time = LocalDateTime.now().toString().replace(":", "-");
	//step1:Create ExtentSparkReporter object
	ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_REPORTS/ExtentReport_"+time+".html");
	
	//step2:Create ExtentReports object
	ExtentReports extReport=new ExtentReports();
	
	//step3:attach ExtentSparkReporter to ExtentReports
	extReport.attachReporter(spark);
	
	//step4:create EatentTest object
	ExtentTest test =extReport.createTest("createReport");//give method name
	
	//step5:call log (status ,message)
	test.log(Status.PASS, "log message added into report");
	
	//step6:call flush()
	extReport.flush();
	
   }
}
