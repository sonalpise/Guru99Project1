package org.guru99.Guru99Pages;
import java.util.Iterator;
import java.util.Set;

import org.guru99.Utility.LoggerClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ord.guru99.Helper.BaseClass;


public class Day5Page extends BaseClass {

	//Click  Account -> My account link
	//Click on Create an account
	//Fillup First name
	//Fillup Middle Name
	//Fillup Last Name
	//Fillup Email Address
	//Fillup Password
	//Fillup Confirm Password
	//Check Fillup Newsletter
	//Click on register
	// Thank you for registering with Main Website Store.
	//Hello, Autotest H Winter!
	// Click on TV link
	//Click Product to ADD to Wishlist
	//CLick Sharewishlist button
	//Fillup Email ID  autotest@gmail.com
	//Fillup Message
	//CLick ShareWishlist
	//Your Wishlist has been shared.
	
	By AccountLink  = By.xpath("//a[@class='skip-link skip-account']/span[@class='label' and 2]");
	By Myaccountlink = By.xpath("//div[1]/ul[1]/li[@class='first' and 1]/a[1]");
	
	By CreateAccount = By.xpath("//a/span[1]/span[1]");
	By Firstname = By.xpath("//input[@id='firstname']");	
	By Middlename = By.xpath("//input[@id='middlename']");
	By Lastname = By.xpath("//input[@id='lastname']");
	By Emailid= By.xpath("//input[@id='email_address']");
	By Password1= By.xpath("//input[@id='password']");
	By PasswordConfirm = By.xpath("//input[@id='confirmation']");
	By CheckboxNews = By.xpath("//input[@id='is_subscribed']");
	
	By RegisterButton = By.xpath("//div[@class='buttons-set']/button[@class='button' and 1]/span[1]/span[1]");
	
	By accountMessage = By.xpath("//li/ul[1]/li[1]/span[1]");
	String accountSuccessMessage  = "Thank you for registering with Main Website Store.";
	
	By Helloname = By.xpath("//p/strong[1]");
	String HelloFirstname;
	String HelloLastname;
	String HelloMiddlename;
	
	
	By TvLink = By.xpath("//li[@class='level0 nav-2 last menu-active']/a[@class='level0 ']");
	By tvlink1 = By.xpath("//a[normalize-space()='TV']");
	By AddtoWishlist = By.xpath("//li[1]/div[@class='product-info' and 1]/div[@class='actions' and 3]/ul[@class='add-to-links' and 1]/li[1]/a[@class='link-wishlist' and 1]");
	By SharewishList = By.xpath("//button[@class='button btn-share']/span[1]/span[1]");
	
	By Emailidtextbox = By.xpath("//textarea[@id='email_address']");
	By Messagetextbox = By.xpath("//textarea[@id='message']");
	
	By SharelinkButton = By.xpath("//div[@class='buttons-set form-buttons']/button[@class='button' and 1]/span[1]/span[1]");
	
	By ConfirmShare = By.xpath("//li/ul[1]/li[1]/span[1]");
	String Confirmtext  = "Your Wishlist has been shared.";
	
	////a[normalize-space()='TV']
	public void day5Logic() {
		LoggerClass.log("I", "Navigating to ACCOUNT ");
		driver.findElement(AccountLink).click();
		
		LoggerClass.log("I", "Navigating to MY ACCOUNT ");
		driver.findElement(Myaccountlink).click();
		
		LoggerClass.log("I", "Start Creating New Account ");
		driver.findElement(CreateAccount).click();
		driver.findElement(Firstname).clear();	
		driver.findElement(Firstname).sendKeys("AuMiracle121");
		driver.findElement(Middlename).clear();
		driver.findElement(Middlename).sendKeys("J");
		driver.findElement(Lastname).clear();
		driver.findElement(Lastname).sendKeys("Sample");
		driver.findElement(Emailid).clear();
		driver.findElement(Emailid).sendKeys("TesterAu121@gmail.com");
		driver.findElement(Password1).clear();
		driver.findElement(Password1).sendKeys("Turbo123");
		driver.findElement(PasswordConfirm).clear();
		driver.findElement(PasswordConfirm).sendKeys("Turbo123");
		driver.findElement(CheckboxNews).click();
		
		driver.findElement(RegisterButton).click();
		String ActualRegisterMessage  = driver.findElement(accountMessage).getText();
	    LoggerClass.log("I", accountSuccessMessage);
	    LoggerClass.log("I", ActualRegisterMessage);
	    
	    String ActualHelloname = driver.findElement(Helloname).getText();
	    
	  //  Hello, AutoMiracle J Sample!
	    String[] arrOfStr = ActualHelloname.split(" ");
	    HelloFirstname = arrOfStr[1];
    	HelloLastname = arrOfStr[arrOfStr.length-1];
	    if(arrOfStr.length<4)
	    	HelloMiddlename = "";
	    else
	    	HelloMiddlename = arrOfStr[arrOfStr.length-2];
	    
	    System.out.println(HelloFirstname + " " + HelloMiddlename + " " + HelloLastname);
       	    
	    Assert.assertEquals(accountSuccessMessage ,ActualRegisterMessage);
		LoggerClass.log("I", "Verifying Register Message : PASSED " );
		
		// Go to TV
		driver.findElement(tvlink1).click();
		
		driver.findElement(AddtoWishlist).click();
		
		driver.findElement(SharewishList).click();
		
		driver.findElement(Emailidtextbox).sendKeys("TesterAu118@gmail.com");
		
		driver.findElement(Messagetextbox).sendKeys("This is Good Product Thought to Share wiht you.");
		
		driver.findElement(SharelinkButton).click();
		
		String ActualWishMessage = driver.findElement(ConfirmShare).getText();

	    LoggerClass.log("I", ActualWishMessage);
	    LoggerClass.log("I", Confirmtext);
	  
	    try {
	    Assert.assertEquals(ActualWishMessage ,Confirmtext);
	 	LoggerClass.log("I", "Verifying Share wishlist  Message : PASSED " );
	    }
	    catch(Exception e)
	    {
	    		e.printStackTrace();
	    }
	    
		
	}
	
} //Day5Page
