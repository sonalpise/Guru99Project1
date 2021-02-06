package org.guru99.Guru99Pages;
import org.guru99.Utility.LoggerClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import ord.guru99.Helper.BaseClass;

public class Day1Page extends BaseClass{

// Verify item in Mobile List Page can be sorted by 'Name'
//Go to Page --> Veirfy the Title Page -> Click on 'MOBILE' menu --> Verify the Title of the page --> In the list of all mobile select 'SORT BY' Dropdwn
// as 'name'
// Verify all product are sorted by 'name'
//1. Text "THIS IS DEMO SITE' Shown in the home page
//2.Title 'MOBILE' is showing on the mobile list page 
//3. All 3 product sorted by 'name'
	
By linkMobileFirstPage  = By.xpath("//a[contains(text(),'Mobile')]");	
By sortDropDown = By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/select[1]");
String expectedPageTitle = "Home page";
String expectedMobilePageTitle ="Mobile";
String demoSiteTitle;

private String baseUrl;
public int scc = 0;

public void goMobileSortName() {
	LoggerClass.log("I", "Navigating to Mobile Page");
	driver.findElement(linkMobileFirstPage).click();
	Select sortMenu = new Select(driver.findElement(sortDropDown));
	sortMenu.selectByVisibleText("Name");
	

    // Step 6. Verify all products are sorted by name
	// this will take a screen shot of the manager's page after a successful login
    /*scc = (scc+1);
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String png = ("C:\\Guru99 eCommerce Live Project\\Day01_TestCase1\\Mobile Products are sorted" + scc + ".png");
	FileUtils.copyFile(scrFile, new File(png));*/
	
	
}//goMobileSortName
	
public boolean validateHomePageTitle(){
	boolean result = false;
	String actualPageTitle = driver.getTitle();
	if(actualPageTitle == expectedPageTitle){
		System.out.println("Passed");
		result = true;
	}
	return result;
} //validateHomePageTitle

public boolean validateMobilePageTitle(){
	boolean result = false;
	String actualMobilePageTitle= driver.getTitle();
	if(actualMobilePageTitle == expectedMobilePageTitle){
		System.out.println("Passed");
		result = true;
	}
	return result;
} //validateHomePageTitle




}  //Day1Page
