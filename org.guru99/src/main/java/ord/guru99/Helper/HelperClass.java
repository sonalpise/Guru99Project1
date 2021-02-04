package ord.guru99.Helper;

import org.openqa.selenium.WebDriver;
import org.guru99.Utility.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HelperClass {
WebDriver d;

	public HelperClass(WebDriver driver, String appURL){
		this.d = driver;
		driver.get(appURL);
	} // HelperClass
	
	public void _openAppURL(String appURL) {
		LoggerClass.log("I", "Opening URL " + appURL);
		d.get(appURL);
	} // _openAppURL
	
	public void _closeAppURL() {
		LoggerClass.log("I", "Closing URL");
		d.quit();
	} // _closeAppURL
	
} //HelperClass
