package org.guru99.Guru99Pages;
import org.guru99.Utility.LoggerClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import ord.guru99.Helper.BaseClass;


public class Day2Page  extends BaseClass{

	By linkMobileFirstPage  = By.xpath("//a[contains(text(),'Mobile')]");	
	//By mobilePrice  = By.xpath("span[contains(text(),'$100.00')]");
	By price = By.xpath("//span[@id='product-price-1']/span[@class='price' and 1]");
	By mobileName  = By.xpath("//span[@class='h1']");
//	String priceSonyExpedia;
	////li[3]/div[@class='product-info' and 1]/h2[@class='product-name' and 1]/a[1]
	By linkMobileNameClick = By.xpath("//a[@title='Sony Xperia']");
	By phoneTitle = By.xpath("//a[@title='Sony Xperia']");
	By phonePriceDetailPage = By.xpath("//span[@class='price']");
	
	public void goMobileSortName() {
		LoggerClass.log("I", "Navigating to Mobile Page");
		driver.findElement(linkMobileFirstPage).click();
		String valueFirstPage ;
		valueFirstPage = driver.findElement(price).getText();
		System.out.println(valueFirstPage);
		driver.findElement(linkMobileNameClick).click();
		String detailPage  =  driver.getTitle();
		String mobilename  = driver.findElement(mobileName).getText();
		LoggerClass.log("I", "Mobile Name is " + mobilename);
		System.out.println(detailPage);
		String priceOnDetail = driver.findElement(phonePriceDetailPage).getText();
		System.out.println(priceOnDetail);
		Assert.assertEquals(valueFirstPage ,priceOnDetail);
	}//goMobileSortName
	
	
}//Day2Page
