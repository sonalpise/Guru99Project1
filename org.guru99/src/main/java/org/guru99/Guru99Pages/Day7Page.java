package org.guru99.Guru99Pages;

import static org.testng.Assert.assertEquals;

import org.guru99.Utility.LoggerClass;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ord.guru99.Helper.BaseClass;
import ord.guru99.Helper.HelperClass;


public class Day7Page extends BaseClass {

	 public String firstName = "MARRY";    // These testdata stuff will be placed    
	 public String lastName = "STONE";  // in a TestData EXCEL file at some stage
	  
	By AccountLink  = By.xpath("//a[@class='skip-link skip-account']/span[@class='label' and 2]");
	By Myaccountlink = By.xpath("//div[1]/ul[1]/li[@class='first' and 1]/a[1]");
	
	By AccountEmail = By.xpath("//input[@id='email']");
	By AccountPass = By.xpath("//input[@id='pass']");
	By AccountLoginBtn = By.xpath("//button[@id='send2']");
	String Username = "TesterAu123@gmail.com";
	String Password = "Turbo123";
	
	
	public void day7Logic() throws InterruptedException {
		
		LoggerClass.log("I", "Navigating to ACCOUNT ");
		driver.findElement(AccountLink).click();
		
		LoggerClass.log("I", "Navigating to MY ACCOUNT ");
		driver.findElement(Myaccountlink).click();
		
		driver.findElement(AccountEmail).sendKeys(Username);
		driver.findElement(AccountPass).sendKeys(Password);
		driver.findElement(AccountLoginBtn).click();
		
		LoggerClass.log("I", "Login Done and In Account");
		LoggerClass.log("I", "Click on MY ORDERS");
		
	    
				// Step 5. Click on 'View Order' 
				// note: clicking View Order at this point is not in the sequence, in order to reach step 6, 
			    //		 because immediately after logging in, it goes straight to display of Recent Orders page
				// driver.findElement(By.linkText("View Order")).click();

				
			    //********************************************************************************************************	  
			    // Step 6. Verify the previously created order is displayed in 'RECENT ORDERS' table and status is Pending
			    // note: RECENT ORDERS page is displayed immediately after customer/user has logged in
			    
			    try {
			        assertEquals("RECENT ORDERS", driver.findElement(By.cssSelector("h2")).getText());
			        System.out.println("*** RECENT ORDERS is confirmed as the correct page to be in. ***");
			      } catch (Error e) {
			    	  System.out.println("*** RECENT ORDERS failed to get displayed on the page. ***");
			    	  e.printStackTrace();	
			      }
			    
			    try {
			    	assertEquals("Pending", driver.findElement(By.cssSelector("em")).getText());
			    	System.out.println("*** Status of Pending is correctly displayed for this recent order. ***");
			      } catch (Error e) {
			    	  System.out.println("*** Status of Pending failed to be confirmed for this recent order. ***");
			    	  e.printStackTrace();	
			      }
	    
			    
			    // Step 7. Click on 'Print Order' link
			    driver.findElement(By.linkText("VIEW ORDER")).click();
			    
			    Thread.sleep(2000);  
			    
			    // switching to new window                                                                               
			    for (String handle : driver.getWindowHandles()) {
			    	driver.switchTo().window(handle);
			    	}
			    			    
			    driver.findElement(By.linkText("Print Order")).click();
			    
			    Thread.sleep(2000);  
		  
			    // Step 8. Click 'Change...' link and a popup will be opened as 'Select a destination' , select 'Save as PDF' link.  
			    // note:  There is no "Change...." link 
		
	   
			    // Step 9. Click on 'Save' button and save the file in some location.
			    // note: unable to find this Save button
		  
			    // Step 10.Verify Order is saved as PDF
			    // unable to perform any verification because there is no option to save as PDF
			    
	}//day7Logic

} //BaseClass
