package com.core.test.steps;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.core.main.browserutilities.LaunchBrowser;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdvancedSearch {
	
	public static void main(String[] args) {
		
		AdvancedSearch browser = new AdvancedSearch();
		browser.advance_search_page_navigate();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		

		
		//Condition
		String excelCondition = "USED";
		browser.selectVehicleCondition(excelCondition);
		//Style
		String excelStyle = "CONVERT";
		browser.selectVehicleStyle(excelStyle);
		
		String excelStartYear = "2017";
		browser.selectStartYear(excelStartYear);
		
		String excelEndYear = "2020";
		browser.selectEndYear(excelEndYear);
		
		String excelMake = "BMW";
		browser.selectMake(excelMake);
		
	}
	
	public void selectVehicleCondition(String conditiontype)
	{
		List<WebElement> chkCondition = null;
		
		//chkCondition = driver.findElement(By.xpath("//div[@data-qaid='cntr-Condition'] //input[@value='CERTIFIED']"));
		chkCondition = driver.findElements(By.xpath("//div[@data-qaid='cntr-Condition'] //input[@type='checkbox']"));
		
		for(int i=0; i< chkCondition.size(); i++)
		{
			if(chkCondition.get(i).getAttribute("value").equals(conditiontype))
			{
				String javascript = "arguments[0].click()";      
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;        
				jsExecutor.executeScript(javascript, chkCondition.get(i)); 
			}
		} 
	}
	public void selectVehicleStyle(String vehsytle)
	{
		List<WebElement> chkStyle = null;
		
		//chkCondition = driver.findElement(By.xpath("//div[@data-qaid='cntr-Condition'] //input[@value='CERTIFIED']"));
		chkStyle = driver.findElements(By.xpath("//div[@data-qaid='cntr-Style'] //input[@type='checkbox']"));
		
		for(int i=0; i< chkStyle.size(); i++)
		{
			if(chkStyle.get(i).getAttribute("value").equals(vehsytle))
			{
				String javascript = "arguments[0].click()";      
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;        
				jsExecutor.executeScript(javascript, chkStyle.get(i)); 
			}
		} 
	}
	
	public void selectStartYear(String startYear)
	{
		
		Select ddStartYear = new Select(driver.findElement(By.xpath("//select[@data-qaid='selbx-minYear']")));
		ddStartYear.selectByValue(startYear);;

	}
	
	public void selectEndYear(String endYear)
	{
		
		Select ddEndYear = new Select(driver.findElement(By.xpath("//select[@data-qaid='selbx-maxYear']")));
		ddEndYear.selectByValue(endYear);;

	}

	public void selectMake(String make)
	{
		
		Select ddMake = new Select(driver.findElement(By.xpath("//select[@data-qaid='selbx-makeFilter-0']")));
		ddMake.selectByValue(make);;

	}

	
	
	static WebDriver driver = LaunchBrowser.driver;
		
	Scenario scenario;
	
    @Before
	public void initTests(Scenario scenario) {
		this.scenario = scenario;
		scenario.log("Before-hook : scenario");
	}
	
    /*Given User is in Advance Search page
    When user entered valid data in desired fields
    And clicked on Search button
    Then Validate Search results meeting the search criteria or not
    */
	@Given("User is in Advance Search page")
	public void advance_search_page_navigate()
	{
		//driver.get("https://www.autotrader.com");
		driver.get("https://www.autotrader.com/cars-for-sale/advanced-search");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@When("user entered valid data in desired fields")
	public void user_enter_data() throws Exception
	{
		
	}
	@Then("validate desired elements in homepage")
	public void validate_desired_elements_in_homepage1() throws Exception
	{
		//zipcode 30004
		WebElement txtZip = null;
		txtZip = driver.findElement(By.id("zip48577207"));
		txtZip.sendKeys("30004");
		
		/*
		 * Select the ‘Certified’ check box under ‘Condition’
o Select the ‘Convertible’ check box under ‘Style’
o Update the ‘Year’ drop down menus as follows: select 2017 as From year and select 2020 as To year
o Select Make as ‘BMW’ under Make, Model & Trim section
• Click the button ‘Search’ at the bottom of the page
		 * 
		 */

		


	
	}
		
	

	public void takeSnapShot(String fileWithPath, Scenario sc) throws Exception{

        TakesScreenshot scrShot =((TakesScreenshot)driver);

        byte[] SrcFile=scrShot.getScreenshotAs(OutputType.BYTES);
                //File DestFile=new File(fileWithPath);
                //FileUtils.copyFile(SrcFile, DestFile);
                sc.attach(SrcFile, "image/png", "errorimg.png");
    }
	
	
	public void validate_desired_elements_in_homepage2() throws Exception
	{
	
	try {
		//takeSnapShot("C:\\Users\\amare\\eclipse-workspace\\AutoTraderCode\\screenshot\\homepageerror.png", scenario);
		boolean browsebymake = false;
		browsebymake = driver.findElements(By.linkText("Browse by Make")).size()> 0;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Browse by Make"))));
		
		if (browsebymake = true) {
			scenario.log("Browse by Make link displayed: " + browsebymake);
		} else {
			scenario.log("Browse by Make link displayed: " + browsebymake);
		}
		
		boolean browsebystyle = false;
		browsebystyle = driver.findElement(By.linkText("Browse by Style")).isDisplayed();
		if (browsebystyle = true) {
			scenario.log("Browse by Style link displayed: " + browsebystyle);
		} else {
			scenario.log("Browse by Style link displayed: " + browsebystyle);
		}
		
		boolean advancedsearch = false;
		advancedsearch = driver.findElement(By.linkText("Advanced Search")).isDisplayed();
		if (advancedsearch = true) {
			scenario.log("Advanced Search link displayed: " + advancedsearch);
		} else {
			scenario.log("Advanced Search link displayed: " + advancedsearch);
		}
		
		boolean buttonsearch = false;
		buttonsearch = driver.findElement(By.id("search")).isDisplayed();
		if (buttonsearch = true) {
			scenario.log("Search button displayed: " + buttonsearch);
		} else {
			scenario.log("Search button displayed: " + buttonsearch);
		}
		
		boolean ddmake = false;
		ddmake = driver.findElement(By.xpath("//*[@name='makeCode']")).isDisplayed();
		if (ddmake = true) {
			scenario.log("Make dropdown displayed: " + ddmake);
		} else {
			scenario.log("Make dropdown displayed: " + ddmake);
		}
		
		boolean ddmodel = false;
		ddmodel = driver.findElement(By.xpath("//*[@name='ModelCode']")).isDisplayed();
		if (ddmodel = true) {
			scenario.log("Model dropdown displayed: " + ddmodel);
		} else {
			scenario.log("Model dropdown displayed: " + ddmodel);
		}
		
		boolean txtzip = false;
		txtzip = driver.findElement(By.xpath("//*[@name='zipcode']")).isDisplayed();
		if (txtzip = true) {
			scenario.log("ZipCode text box displayed: " + txtzip);
		} else {
			scenario.log("ZipCode text box displayed: " + txtzip);
		}
	}
	catch(NoSuchElementException e)
	{
		takeSnapShot("C:\\Users\\amare\\eclipse-workspace\\AutoTraderCode\\screenshot\\homepage.png", scenario);
		scenario.log("Element Not Found");
		e.printStackTrace();
	}
	
	}

}


