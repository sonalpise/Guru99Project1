package org.guru99test;
import org.guru99.Guru99Pages.Day3Page;
import org.junit.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ord.guru99.Helper.HelperClass;

public class Day3test extends Day3Page {
//Click on MOBILE
//SONY XPEDIA  - CLICK ON ADD TO CART BUTTON
// GO TO QTY  - UPDATE QTY to 1000  PRESS "UPDATE"
// VERIFY ERROR MESSAGE - "The maximum quantity allowed for purchase is 500."
// CLICK on EMPTY CART LINK
//VERIFY MESSAGE "You have no items in your shopping cart."
	
	private static String appURL = "http://live.demoguru99.com/index.php/";
	HelperClass helperObj;

	@Test(priority = 1)
	public void navigatetoMobile() {
		//***********2.Enter the URL and Login into MMP Website***********/
		helperObj._openAppURL(appURL);
		day3Logic();
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

} //Day3test
