package ord.guru99.Helper;
import java.util.concurrent.TimeUnit;
import org.guru99.Utility.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public  WebDriver driver;

	public void initiateDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		LoggerClass.log("I", "Webdriver initiated");
	} // initiateDriver

	/**
	 * 
	 **/
	public void shutDownDriver() {
		driver.quit();
		LoggerClass.log("I", "Webdriver shut down");
	} // shutDownDriver
	

} //BaseClass
