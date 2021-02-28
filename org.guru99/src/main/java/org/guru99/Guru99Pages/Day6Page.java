package org.guru99.Guru99Pages;

import static org.testng.Assert.assertEquals;

import org.guru99.Utility.LoggerClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import ord.guru99.Helper.BaseClass;

public class Day6Page extends BaseClass {

	//The client wants you to “Verify user is able to purchase product using registered email id"
	//login account
	// click mywishlist
	//click add to cart link
	//click to proceed to checkout 
	//enter shipping info
	//click estimates
	//verify shipping cost generated
	//select shipping cost 
	//update Total
	//Verify shipping cost added to Total
	//click "proceed to checkout"
	//enter billing info
	//click continue
	// check money/order radio button
	// click continue
	//click place order button
	//verify Orderis generated
	//Note the Order no
	
	// Billing page = http://live.demoguru99.com/index.php/checkout/onepage/
	
	 public String firstName = "BERRY";    // These testdata stuff will be placed    
	 public String lastName = "BERRYSEVEN";  // in a TestData EXCEL file at some stage
	  
	By AccountLink  = By.xpath("//a[@class='skip-link skip-account']/span[@class='label' and 2]");
	By Myaccountlink = By.xpath("//div[1]/ul[1]/li[@class='first' and 1]/a[1]");
	
	By AccountEmail = By.xpath("//input[@id='email']");
	By AccountPass = By.xpath("//input[@id='pass']");
	By AccountLoginBtn = By.xpath("//button[@id='send2']");
	String Username = "TesterAu123@gmail.com";
	String Password = "Turbo123";

	
	By Addtocart = By.xpath("//button[@title='Add to Cart']");
	
	By CheckoutBtn = By.xpath("//a[@class='button checkout-button']");
	
	By EstimatesBtn = By.xpath("//div[@class='buttons-set']/button[@class='button2' and 1]/span[1]/span[1]");
	By SelectExtimateCountyDropDown  = By.xpath("//select[@id='country']");
	By SelectEstimateStateDropDown = By.xpath("//select[@id='region_id']");
	By SelectEstimateZip = By.xpath("//input[@id='postcode']");
	By UpdateTotalBtn = By.xpath("//div[@class='buttons-set']/button[@class='button' and 1]/span[1]/span[1]");
	
	By FlatrateRadioButton = By.xpath("//input[@id='s_method_flatrate_flatrate']");
	By ShippingCharge = By.xpath("//tr[2]/td[@class='a-right' and 2]/span[@class='price' and 1]");
	
	By SubTotal = By.xpath("//tr[1]/td[@class='a-right' and 2]/span[@class='price' and 1]");
	By GrandTotal  = By.xpath("//strong/span[@class='price' and 1]");
	
	By ProceedtoCheckoutBtn = By.xpath("//li[@class='method-checkout-cart-methods-onepage-bottom']/button[@class='button btn-proceed-checkout btn-checkout' and 1]/span[1]/span[1]");
	
	By BillingAfterContinueAtn = By.xpath("//div[@id='billing-buttons-container']/button[@class='button' and 1]/span[1]/span[1]");
	
	By ShippingafterContinueBtn = By.xpath("//div[@id='shipping-method-buttons-container']/button[@class='button' and 1]/span[1]/span[1]");
	
	By ContinueAfterFixRateBtn = By.xpath("//div[@id='billing-buttons-container']/button[@class='button' and 1]");
	By  CheckMoneyOrderRadi = By.xpath("//dt[@id='dt_method_checkmo']/label[1]");
	
	By CheckMoneySelectAfterContinueBtn = By.xpath("//div[@id='payment-buttons-container']/button[@class='button' and 1]/span[1]/span[1]");
	
	
	
	By OrderNumber  = By.xpath("//div[@class='col-main']/p[1]/a[1]");
	By OrderPlacedTitle = By.xpath("//div[@class='page-title']/h1[1]");
	String OrderPlaceConfirmTitle  = "YOUR ORDER HAS BEEN RECEIVED.";
	
	By PlaceOrderButton = By.xpath("//button[@class='button btn-checkout']");
	


	/*
	 * 
	 * driver.findElement(By.id("billing:firstname")).clear();
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
        
        Your order # is: 100013634.
	 */

	
	
	public void day6Logic() throws InterruptedException {
		
		
		LoggerClass.log("I", "Navigating to ACCOUNT ");
		driver.findElement(AccountLink).click();
		
		LoggerClass.log("I", "Navigating to MY ACCOUNT ");
		driver.findElement(Myaccountlink).click();
		
		driver.findElement(AccountEmail).sendKeys(Username);
		driver.findElement(AccountPass).sendKeys(Password);
		driver.findElement(AccountLoginBtn).click();
		
		LoggerClass.log("I", "Login Done and In Account");
		LoggerClass.log("I", "Click on Wishlist");
		
		// 4. Click on MY WISHLIST link                                                                              
	    driver.findElement(By.linkText("MY WISHLIST")).click();
	    Thread.sleep(3000);    
		
	    
	 // 5. In next page, Click ADD TO CART link                                                                     
	    driver.findElement(By.xpath("//button[@title='Add to Cart']")).click();
	    Thread.sleep(3000);    
	    
	    
	    // 6. Enter general shipping country, state/province and zip for the shipping cost estimate                
	    new Select(driver.findElement(SelectExtimateCountyDropDown)).selectByIndex(14);
	    driver.findElement(By.id("region")).sendKeys("New South Wales");
	    driver.findElement(SelectEstimateZip).sendKeys("542896");
	    Thread.sleep(3000);    
		
	    // 7. Click Estimate                                                                                                       
	    driver.findElement(EstimatesBtn).click(); // this is the ESTIMATE link
	    
	    // 8. Verify Shipping cost generated                                                                               
	    String sFlatRate = "Flat Rate";
	    String flatRate = driver.findElement(By.xpath(".//*[@id='co-shipping-method-form']/dl/dt")).getText();	
	    try {
	    	System.out.println("sFlatRate = "+sFlatRate);
	    	System.out.println("flatRate = "+flatRate);
	    	assertEquals(sFlatRate, flatRate);
		    } catch (Exception e) {
		    	e.printStackTrace();	    	
		    }	
	    	    
	    String sFlatRatePrice = "Fixed - $5.00";
	    String flatRatePrice = driver.findElement(By.xpath(".//*[@id='co-shipping-method-form']/dl/dd/ul/li/label")).getText();
	    try {	 
	    	System.out.println("sFlatRatePrice = "+sFlatRatePrice);
	    	System.out.println("flatRatePrice = "+flatRatePrice);
	    	assertEquals(sFlatRatePrice, flatRatePrice);
		    } catch (Exception e) {
		    	e.printStackTrace();	    	
		    }	
	    
	    
	    // 9. Select Shipping Cost (already selected as default), Update Total                                              
	    driver.findElement(FlatrateRadioButton).click();	 // RADIO button  -  Fixed - $5.00
	    driver.findElement(UpdateTotalBtn).click();
	    
	    // 10. Verify shipping cost is added to total                                                           
	    String vFlatRatePrice = "$5.00";
	    String shippingCostIncluded = driver.findElement(By.xpath(".//*[@id='shopping-cart-totals-table']/tbody/tr[2]/td[2]/span")).getText();
	    
	    try {
	    	System.out.println("vFlatRatePrice = "+vFlatRatePrice);
	    	System.out.println("shippingCostIncluded = "+shippingCostIncluded);
	    	assertEquals(vFlatRatePrice, shippingCostIncluded);
		    } catch (Exception e) {
		    	e.printStackTrace();	    	
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
		    	System.out.println("No dropdown element present");
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
		    	System.out.println("No dropdown element present");
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
	    System.out.println("*** Your order number for your record = " + orderNum);
	    
	   
		
	}

	
	
} // Day6Page
