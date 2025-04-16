package bike;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ActivaTest {
	@Test
	public void milege() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.bajajmall.in/");
		Reporter.log("Deo milege is 60", true);
		Reporter.log("Deo milege is 60", true);
		Reporter.log("Deo milege is 60", true);
	}
}
