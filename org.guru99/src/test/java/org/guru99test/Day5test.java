package org.guru99test;
import org.junit.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ord.guru99.Helper.HelperClass;

import org.guru99.Guru99Pages.Day5Page;

public class Day5test extends Day5Page{


	private static String appURL = "http://live.demoguru99.com/index.php/";
	HelperClass helperObj;

	@Test(priority = 1)
	public void navigatetoMobile() {
		//***********2.Enter the URL and Login into MMP Website***********/
		helperObj._openAppURL(appURL);
		day5Logic();
		 //Assert.assertEquals(validateHomePageTitle(), true);
		// Assert.assertEquals(validateMobilePageTitle(), true);
	} // navigatetoMobile
	@BeforeClass
	public void beforeTest() {
		// 1.Driver Initiated and Open the Chrome Browser.
		initiateDriver();
		 helperObj = new HelperClass(driver, appURL);
	} // beforeTest


	@AfterClass
	public void afterTest() {
		shutDownDriver();
	} // afterTest
	
	
	// NEW CLASS CREATED 
} //Day5test
