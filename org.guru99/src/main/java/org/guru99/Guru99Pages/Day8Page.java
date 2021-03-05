package org.guru99.Guru99Pages;

import org.guru99.Utility.LoggerClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import ord.guru99.Helper.BaseClass;

public class Day8Page  extends BaseClass{

	 public String firstName = "MARRY";    // These testdata stuff will be placed    
	 public String lastName = "STONE";  // in a TestData EXCEL file at some stage
	  
	By AccountLink  = By.xpath("//a[@class='skip-link skip-account']/span[@class='label' and 2]");
	By Myaccountlink = By.xpath("//div[1]/ul[1]/li[@class='first' and 1]/a[1]");
	
	By AccountEmail = By.xpath("//input[@id='email']");
	By AccountPass = By.xpath("//input[@id='pass']");
	By AccountLoginBtn = By.xpath("//button[@id='send2']");
	String Username = "TesterAu123@gmail.com";
	String Password = "Turbo123";
	
	By ReorderLink = By.xpath("//tr[@class='first odd']/td[@class='a-center view last' and 6]/span[@class='nobr' and 1]/a[@class='link-reorder' and 2]")	;
	
	By Qty = By.xpath("//input[@class='input-text qty']");
	
	By UpdateBtn = By.xpath("//button[@class='button btn-update']/span[1]/span[1]");
	
	By Subtotal = By.xpath("//td[@class='product-cart-total']/span[@class='cart-price' and 1]/span[@class='price' and 1]");
	 public String vPrice, sPrice;
	
	
public void day8Logic() throws InterruptedException {
	
		
		LoggerClass.log("I", "Navigating to ACCOUNT ");
		driver.findElement(AccountLink).click();
		
		LoggerClass.log("I", "Navigating to MY ACCOUNT ");
		driver.findElement(Myaccountlink).click();
		
		driver.findElement(AccountEmail).sendKeys(Username);
		driver.findElement(AccountPass).sendKeys(Password);
		driver.findElement(AccountLoginBtn).click();
		
		LoggerClass.log("I", "Login Done and In Account");
		LoggerClass.log("I", "Click on MY ORDERS");
		
		LoggerClass.log("I", "Click on REORDERS");
		
		 // *  Get the Grand Total Price 
	  
	
		driver.findElement(By.linkText("REORDER")).click();
		
		  vPrice = driver.findElement(By.xpath(".//*[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/strong/span")).getText();
		  
		  
		driver.findElement(Qty).clear();
		driver.findElement(Qty).sendKeys("2");
		
		driver.findElement(UpdateBtn).click();
		
		   // this will check the Grand Total price after being updated 			    
	    sPrice = driver.findElement(By.xpath(".//*[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/strong/span")).getText();			    
	    LoggerClass.log("I", "sPrice ="+sPrice);
	    
	    // verify the before and after Grand Total price, to confirm it has changed
	    if (vPrice== sPrice){
	    	LoggerClass.log("I", "*** Grand Total price has not changed. ***");
	    }else{
	    	LoggerClass.log("I", "*** Grand Total price has changed. ***");
		}	
	    			    
	    // 11. Click PROCEED TO CHECKOUT                                                                       
	    driver.findElement(By.xpath("//button[@title='Proceed to Checkout']")).click();
	    Thread.sleep(3000);    
	    
	    //********************************************************************************************************
	    //*
	    //*  BILLING ADDRESS
	    //*
	    //********************************************************************************************************
	    // Check if Select element is present. If not present, it is the first time a customer has logged back in, to process what is in his/her wishlist
	    
	    try {
	    	Select bAddr = new Select(driver.findElement(By.name("billing_address_id")));
	    	int bAddrSize = bAddr.getOptions().size();
	    	bAddr.selectByIndex(bAddrSize-1); 
		    } catch (Exception e) {
		    	//e.printStackTrace();
		    	LoggerClass.log("I", "No dropdown element present");
		    }
	  
	    driver.findElement(By.id("billing:firstname")).clear();
	    driver.findElement(By.id("billing:firstname")).clear();
	    driver.findElement(By.id("billing:firstname")).sendKeys(firstName); 
	    driver.findElement(By.id("billing:lastname")).clear();
	    driver.findElement(By.id("billing:lastname")).sendKeys(lastName); 
	    driver.findElement(By.id("billing:company")).clear(); 
	    
	    driver.findElement(By.id("billing:street1")).clear();
	    driver.findElement(By.id("billing:street1")).sendKeys("148 Crown Street"); 
	    new Select(driver.findElement(By.xpath("//select[@id='billing:country_id']"))).selectByIndex(14);
	    Thread.sleep(5000);	    
	    driver.findElement(By.id("billing:city")).clear();	
	    driver.findElement(By.id("billing:city")).sendKeys("Sydney"); 
	    driver.findElement(By.id("billing:region")).clear();
	    driver.findElement(By.id("billing:region")).sendKeys("New South Wales");
	    driver.findElement(By.id("billing:postcode")).clear();
	    driver.findElement(By.id("billing:postcode")).sendKeys("2000");
	    driver.findElement(By.id("billing:telephone")).clear();
	    driver.findElement(By.id("billing:telephone")).sendKeys("8850 6789"); 
	    
	    // check radio button to "Ship to different address" 
        driver.findElement(By.id("billing:use_for_shipping_no")).click();
	    
        // click the CONTINUE button 
	   
	    // after the click above, it is still on same web page: live.guru99.com/index.php/checkout/onepage/
	    driver.findElement(By.xpath(".//*[@id='billing-buttons-container']/button")).click();
	    
	    Thread.sleep(2000); 
	    
	    //********************************************************************************************************
	    //*
	    //*  SHIPPING ADDRESS
	    //*
	    //********************************************************************************************************
	    // Check if Select element is present or not.  If not present, it is first time user has logged back in to process his/her order
	    
	    try {
	    	Select sAddr = new Select(driver.findElement(By.name("shipping_address_id")));
	    	int sAddrSize = sAddr.getOptions().size();
	    	sAddr.selectByIndex(sAddrSize-1); 
		    } catch (Exception e) {
		    	//e.printStackTrace();
		    	LoggerClass.log("I", "No dropdown element present");
		    }
	    
	  
	    Thread.sleep(3000);   
	   
	    driver.findElement(By.id("shipping:firstname")).clear();
	    driver.findElement(By.id("shipping:firstname")).clear();
	    driver.findElement(By.id("shipping:firstname")).sendKeys(firstName); 
	    driver.findElement(By.id("shipping:lastname")).clear();
	    driver.findElement(By.id("shipping:lastname")).sendKeys(lastName); 
	    driver.findElement(By.id("shipping:company")).clear(); 
	    
	    driver.findElement(By.id("shipping:street1")).clear();
	    driver.findElement(By.id("shipping:street1")).sendKeys("50 Berry Street"); 
	    driver.findElement(By.id("shipping:street2")).clear();
	    // shipping country must be selected first from dropdown
	    new Select(driver.findElement(By.xpath("//select[@id='shipping:country_id']"))).selectByIndex(14); 
	    // once Australia is selected, then the region and city becomes simply a text input, instead of dropdown
	    driver.findElement(By.id("shipping:region")).clear();
	    driver.findElement(By.id("shipping:region")).sendKeys("New Sounth Wales"); 
	    driver.findElement(By.id("shipping:city")).clear();
	    driver.findElement(By.id("shipping:city")).sendKeys("Sydney"); 
	    driver.findElement(By.id("shipping:postcode")).clear();
	    driver.findElement(By.id("shipping:postcode")).sendKeys("2000"); 
	    driver.findElement(By.id("shipping:telephone")).clear();
	    driver.findElement(By.id("shipping:telephone")).sendKeys("8034 1234");
	        
	    Thread.sleep(3000);	    
	    
	    driver.findElement(By.xpath(".//*[@id='shipping-buttons-container']/button")).click(); 
	    
	    // switching to new window                                                                                
	    for (String handle : driver.getWindowHandles()) {  
	    	driver.switchTo().window(handle);
	    	}  
	    Thread.sleep(2000); 
	    
	    // 13. In Shipping Method, Click Continue   
	    driver.findElement(By.xpath(".//*[@id='shipping-method-buttons-container']/button")).click(); 	
	   	 
	    Thread.sleep(2000);
	    
	    // 14. In Payment Information select 'Check/Money Order' radio button. Click Continue
	    driver.findElement(By.xpath("//input[@title='Check / Money order']")).click();
	    
	    Thread.sleep(3000);	    
	    
	    driver.findElement(By.xpath(".//*[@id='payment-buttons-container']/button")).click(); 
	     
	    Thread.sleep(3000);
	    
	    // 15. Click 'PLACE ORDER' button  
	    driver.findElement(By.xpath(".//*[@id='review-buttons-container']/button")).click(); 
	    
	    Thread.sleep(3000);
	    
	    // 16. Verify Oder is generated. Note the order number 
	    String orderNum = driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div/p[1]/a")).getText();	
	    LoggerClass.log("I", "** Your order number for your record = " + orderNum);
}
	
} //Day8Page
