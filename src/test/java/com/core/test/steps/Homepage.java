package com.core.test.steps;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.core.main.browserutilities.LaunchBrowser;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Homepage {
	
	
	static WebDriver driver = LaunchBrowser.driver;
	String homepagetitle;
	
	
	Scenario scenario;
	


    @Before
	public void initTests(Scenario scenario) {
		this.scenario = scenario;
		scenario.log("Before-hook : scenario");
	}
	
	@Given("User entered valid url autotrader.com")
	
	public void homepage_elements_validate()
	{
		//driver.get("https://www.autotrader.com");
		driver.get("https://www.autotrader.com/cars-for-sale/advanced-search");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@When("user landed on homepage")
	public void user_landed_on_homepage() throws Exception
	{
		homepagetitle = driver.getTitle();
		takeSnapShot("C:\\Users\\amare\\eclipse-workspace\\AutoTraderCode\\screenshot\\homepage.png", scenario);
	}
	@Then("validate desired elements in homepage")
	public void validate_desired_elements_in_homepage1() throws Exception
	{
		List<WebElement> lMake = null;
		lMake = driver.findElements(By.linkText("Browse by Make"));
		
	
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


