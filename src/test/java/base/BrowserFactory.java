package base;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BrowserFactory {
	static WebDriver driver;

	@BeforeClass
	public static WebDriver setUpBrowser(WebDriver driver,String browser,String baseURL) {
		System.setProperty("webdriver.chrome.driver", ".//src//test//resources//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	@AfterClass
	public void tearDownClass() {
		// Close the browser and quit WebDriver after all tests
		if (driver != null) {
			driver.quit();
		}
	}
}


