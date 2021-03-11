package org.guru99.Guru99Pages;
import ord.guru99.Helper.BaseClass;

import static org.testng.Assert.assertEquals;

import org.guru99.Utility.LoggerClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;


public class Day9Page extends BaseClass{

	 public String firstName = "MARRY";    // These testdata stuff will be placed    
	 public String lastName = "STONE";  // in a TestData EXCEL file at some stage
	  
	By AccountLink  = By.xpath("//a[@class='skip-link skip-account']/span[@class='label' and 2]");
	By Myaccountlink = By.xpath("//div[1]/ul[1]/li[@class='first' and 1]/a[1]");
	
	By AccountEmail = By.xpath("//input[@id='email']");
	By AccountPass = By.xpath("//input[@id='pass']");
	By AccountLoginBtn = By.xpath("//button[@id='send2']");
	String Username = "TesterAu123@gmail.com";
	String Password = "Turbo123";
	
	By Coupencode = By.xpath("//input[@id='coupon_code']");
	By ApplyButton = By.xpath("//div[@class='button-wrapper']/button[@class='button2' and 1]/span[1]/span[1]");
	String CoupenText = "Coupon code GURU50  was applied.";
		
	  public double GURU50 = 0.05;
	
	
public void day9Logic() throws InterruptedException {
	
		LoggerClass.log("I", "Navigating to ACCOUNT ");
		driver.findElement(AccountLink).click();
		
		LoggerClass.log("I", "Navigating to MY ACCOUNT ");
		driver.findElement(Myaccountlink).click();
		
		driver.findElement(AccountEmail).sendKeys(Username);
		driver.findElement(AccountPass).sendKeys(Password);
		driver.findElement(AccountLoginBtn).click();
		
		LoggerClass.log("I", "Login Done and In Account");
	
		 
		 // 2a. Go to Mobile 
		    driver.findElement(By.linkText("MOBILE")).click();
		    
	    // 2b. and add IPHONE to cart
	    driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/div[3]/button")).click();
	    
	    driver.findElement(By.id("coupon_code")).clear();
	    driver.findElement(By.id("coupon_code")).sendKeys("GURU50");
	   
	    
	    driver.findElement(By.xpath("//button[@title='Apply']")).click();
	    
	    // this is the Sub Total amount displayed (e.g. $500.00)
	    String vSubTot = driver.findElement(By.xpath(".//*[@id='shopping-cart-totals-table']/tbody/tr[1]/td[2]/span")).getText().trim(); 
	    
	    // this is the discount amount displayed (e.g. $50.00)
	    String vDiscDisp = driver.findElement(By.xpath(".//*[@id='shopping-cart-totals-table']/tbody/tr[2]/td[2]/span")).getText().trim();
	    
	    // this is the Generated discount amount displayed (e.g. $475.00)
	    String vDiscountedAmtDisplayed = driver.findElement(By.xpath(".//*[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/strong/span")).getText().trim();
	    		    
	    // Remove the $ sign 
	    String sSubTot = vSubTot.replaceAll("\\$", " ");                // e.g. $500.00	        
        String sDiscDisp = vDiscDisp.replaceAll("\\$", " ");            // e.g. $25.00	        
        String sDiscountedAmtDisplayed = vDiscountedAmtDisplayed.replaceAll("\\$", " "); 
        
        // Remove the - negative sign
        String sNegDisc = sDiscDisp.replaceAll("\\-", " ");              // e.g. -25.00
        
        // trim the String variables to get it ready for calculation
        String fSubTot = sSubTot.trim();                                 // e.g. $500.00	        
        String fDiscDisp = sNegDisc.trim();                              // e.g. $25.00	        
        String fDiscountedAmtDisplayed = sDiscountedAmtDisplayed.trim(); // e.g. $475.00
        
	    // ***************************************************************************************************************************
	    // discount amount calculations and comparisons between the derived amount against the discount amount displayed on the page
	    // ***************************************************************************************************************************		    
	    
	    double dSubTot = Double.parseDouble(fSubTot);                                 // e.g.        $500.00
	    double dDiscDisp = Double.parseDouble(fDiscDisp);                             // e.g.         $25.00
	    double dDiscountedAmtDisplayed = Double.parseDouble(fDiscountedAmtDisplayed); // e.g.        $475.00
	    
	    // multiply the dSubTot by the GURU50 discount rate (GURU50 = 5% = 0.05) 
	    double discountedAmt = (dSubTot * GURU50);     // discountedAmt is the calculated discounted amount (e.g. $25.00)	
	    double dDiscPrice = (dSubTot - discountedAmt); // e.g. Discounted Price (e.g. $475) = Sub Total ($500.00) less the 5% discount amount ($25.00)
	    
	    // ************************************************************************************************
	    //   compare & assert that the displayed discount amount is equal to the derived discount amount
	    // ************************************************************************************************
	    // the amount of discount (e.g. $25.00 = $500 * 5%) compared to the amount of discount as displayed on the page (e.g. $25)
	    if (discountedAmt == dDiscDisp){
	    		System.out.println("*** Derived discount amount   = " + discountedAmt);
	    		System.out.println("*** Displayed discount amount = " + dDiscDisp);
	    }else
	      { System.out.println("*** Derived discount amount not equal displayed discount amount ***");
	    }	
	    
	    String string_discountedAmt = Double.toString(discountedAmt);
	    String string_dDiscDisp = Double.toString(dDiscDisp);
	    try {
	        assertEquals(string_discountedAmt, string_dDiscDisp);
	      } catch (Error e) {
	    	  System.out.println("*** Derived discount amount not equal displayed discount amount ***");
	    	  e.printStackTrace();	
	    	  
	      }
	 
	    // **************************************************************************************************************************************
	    // compare & assert that the displayed discounted price is equal to the derived discounted price
	    // derived discounted price (e.g. $475.00 = $500 less $25)) compared to the displayed discounted price ($475.00) as displayed on the page
	    // **************************************************************************************************************************************
	    if (dDiscPrice == dDiscountedAmtDisplayed){
    		System.out.println("*** Derived discounted price   = " + dDiscPrice);
    		System.out.println("*** Displayed discounted price = " + dDiscountedAmtDisplayed);
	    }else
	    	{ System.out.println("*** Derived discounted price not equal displayed discounted price ***");
	    }	
	    
	    String string_dDiscPrice = Double.toString(dDiscPrice);
	    String string_discountedAmtDisplayed = Double.toString(dDiscountedAmtDisplayed);
	    try {
	        assertEquals(string_dDiscPrice, string_discountedAmtDisplayed);
	      } catch (Error e) {
	    	  System.out.println("*** Derived discount amount not equal displayed discount amount ***");
	    	  e.printStackTrace();	
	      }
}
	
} //Day9Page
