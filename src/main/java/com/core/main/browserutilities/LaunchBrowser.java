package com.core.main.browserutilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {
	static String browserName;
	public static WebDriver driver = LaunchBrowser.DriverManager("CHROME");

	public static WebDriver DriverManager(String browserName) {
		browserName = browserName.toUpperCase();
		if (browserName.equals("CHROME")) {
			System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		return driver;
	}

	
	
}
