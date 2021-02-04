package org.guru99.Guru99Pages;
import java.util.Iterator;
import java.util.Set;

import org.guru99.Utility.LoggerClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ord.guru99.Helper.BaseClass;


public class Day4Page  extends BaseClass{
	
	//Click on MOBILE
	//Click on ADD to Compare for first mobile and save name to string1
	//Click on Add to Compare for Second Mobile  and save name to string2
	//Click on COMAPARE 
	//Switch to Comaparison Window
	//Verify Popup window 
	//Get first Mobile name 
	//Get second Mobile name 
	//Compare names with earlier saved names 
	//Close the Pop window
	//Close the Main Parent Window
	
	By linkMobileFirstPage  = By.xpath("//a[contains(text(),'Mobile')]");	
	
	By firstMobileLink = By.xpath("//li[1]/div[@class='product-info' and 1]/div[@class='actions' and 3]/ul[@class='add-to-links' and 1]/li[2]/a[@class='link-compare' and 1]");
	By secondMobileLink = By.xpath("//li[2]/div[@class='product-info' and 1]/div[@class='actions' and 3]/ul[@class='add-to-links' and 1]/li[2]/a[@class='link-compare' and 1]");
	By comapareButton  = By.xpath("//div[1]/button[@class='button' and 1]/span[1]/span[1]");
	
	By popupMobile1 = By.xpath("//a[normalize-space()='Sony Xperia']");
	By popupMobile2 = By.xpath("//a[normalize-space()='IPhone']");
	
	String firstMobile;
	String secondMobile;
	
	String ppoupMobileName1;
	String popupMobileName2;
	
	
	public void day4Logic() {
		LoggerClass.log("I", "Navigating to Mobile Page");
		driver.findElement(linkMobileFirstPage).click();
		
		LoggerClass.log("I", "Click First Mobile Add to compare" );
		firstMobile  = driver.findElement(By.xpath("//li[1]/div[@class='product-info' and 1]/h2[@class='product-name' and 1]/a[1]")).getText();
		driver.findElement(firstMobileLink).click();
		
		LoggerClass.log("I", "Click Seocnd  Mobile Add to compare" );
		secondMobile = driver.findElement(By.xpath("//li[2]/div[@class='product-info' and 1]/h2[@class='product-name' and 1]/a[1]")).getText();
		driver.findElement(secondMobileLink).click();
		
		LoggerClass.log("I", "Click COMPARE and switch to POP up window" );
		driver.findElement(comapareButton).click();
		
        String mainwindow = driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        
        while (i1.hasNext()) {
            String ChildWindow = i1.next();
                if (!mainwindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                ppoupMobileName1 = driver.findElement(popupMobile1).getText();
                popupMobileName2 = driver.findElement(popupMobile2).getText();
                driver.close();
                System.out.println("Child window closed");
            }
        }    
        //  Switch back to the main window which is the parent window.
        driver.switchTo().window(mainwindow);
        driver.quit();
        
        LoggerClass.log("I", "Comparing  FIRST Mobile Details on POPUP window PASSED " );
        LoggerClass.log("I", firstMobile);
        LoggerClass.log("I", ppoupMobileName1);
        Assert.assertEquals(firstMobile ,ppoupMobileName1);
	
        LoggerClass.log("I", "Comparing  SECOND  Mobile Details on POPUP window PASSED " );
        LoggerClass.log("I", secondMobile);
        LoggerClass.log("I", popupMobileName2);
        Assert.assertEquals(secondMobile ,popupMobileName2);
		
	}//day4Logic
	
	
	
	
	
	
} //Day4Page
