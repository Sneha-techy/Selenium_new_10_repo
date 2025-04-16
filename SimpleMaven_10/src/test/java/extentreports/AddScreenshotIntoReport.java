package extentreports;

import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AddScreenshotIntoReport {
@Test
public void addScreenshot() {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://demowebshop.tricentis.com/");
	String time = LocalDateTime.now().toString().replace(":", "-");
	TakesScreenshot ts=(TakesScreenshot) driver;
	String screenshot = ts.getScreenshotAs(OutputType.BASE64);
	
	ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_REPORTS/screenshorReport_"+time+".html");
	ExtentReports expReport=new ExtentReports();
	expReport.attachReporter(spark);
	ExtentTest test = expReport.createTest("addScreenshot");
	test.log(Status.INFO,"adding screenshot");
	test.addScreenCaptureFromBase64String(screenshot);
	expReport.flush();
	
}
}
