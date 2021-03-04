package org.guru99.Guru99Pages;

import org.guru99.Utility.LoggerClass;
import org.openqa.selenium.By;

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
		
		driver.findElement(ReorderLink).click();
		
		
		
}
	
} //Day8Page
