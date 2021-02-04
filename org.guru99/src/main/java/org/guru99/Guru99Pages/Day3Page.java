package org.guru99.Guru99Pages;
import org.guru99.Utility.LoggerClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import ord.guru99.Helper.BaseClass;

public class Day3Page extends BaseClass{

	//Click on MOBILE
	//SONY XPEDIA  - CLICK ON ADD TO CART BUTTON
	// GO TO QTY  - UPDATE QTY to 1000  PRESS "UPDATE"
	// VERIFY ERROR MESSAGE - "The maximum quantity allowed for purchase is 500."
	// CLICK on EMPTY CART LINK
	//VERIFY MESSAGE "You have no items in your shopping cart."
	
	
	By linkMobileFirstPage  = By.xpath("//a[contains(text(),'Mobile')]");	
	By addCart = By.xpath("//li[1]/div[@class='product-info' and 1]/div[@class='actions' and 3]/button[@class='button btn-cart' and 1]");
	By addCartIPHONE = By.xpath("//li[2]/div[@class='product-info' and 1]/div[@class='actions' and 3]/button[@class='button btn-cart' and 1]/span[1]");
	By phoneName = By.xpath("//li[1]/div[@class='product-info' and 1]/h2[@class='product-name' and 1]/a[1]");
	By qtyText = By.xpath("//input[@class='input-text qty']");
	By updateButton = By.xpath("//button[@class='button btn-update']/span[1]/span[1]");
	
	By errorMessage = By.xpath("//p[@class='item-msg error']");
	String ExpectedErrorQtyMessage = "* The maximum quantity allowed for purchase is 500.";
	String ActualErrorQtyMessage;
	
	By enptyCartLink = By.xpath("//button[@id='empty_cart_button']/span[1]/span[1]");
	By emptyCartMessage = By.xpath("//div[@class='cart-empty']/p[1]");
	String ExpectedEmptyMsg = "You have no items in your shopping cart.";
	String ActualCartMessage;
	
	
	public void day3Logic() {
		LoggerClass.log("I", "Navigating to Mobile Page");
		driver.findElement(linkMobileFirstPage).click();
		
		LoggerClass.log("I", "Click Add to cart");
		driver.findElement(addCart).click();
		
		driver.findElement(qtyText).clear();
		driver.findElement(qtyText).sendKeys("1000");
		
		driver.findElement(updateButton).click();
		ActualErrorQtyMessage= driver.findElement(errorMessage).getText();
		Assert.assertEquals(ExpectedErrorQtyMessage ,ActualErrorQtyMessage);
		LoggerClass.log("I", "Error Message verified : Quantity entered  more than 1000 ");
		driver.findElement(enptyCartLink).click();
		
		ActualCartMessage = driver.findElement(emptyCartMessage).getText();
		
		Assert.assertEquals(ExpectedEmptyMsg ,ActualCartMessage);
		LoggerClass.log("I", "Cart is empty Verified");
		
	}//day3Logic
	
	
	
	
} //Day3Page
