package com.tiaa.webapp;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class HDFC_Login {

	public static void main(String[] args) throws IOException, InterruptedException {
		//Level 1 -  connect to appium server
		//DesiredCapabilities
		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setCapability("deviceName", "redmi");
		cap.setCapability("platformName", "Android");
		cap.setCapability("browserName", "Chrome");
		cap.setCapability("chromedriverExecutable", "C:\\Dhanashri\\chromedriver_win32\\chromedriver.exe");
		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		
		String title=driver.getTitle();
		System.out.println("Title :" +title);
		
		driver.switchTo().frame(0);
		driver.findElementByXPath(".//input[@name='fldLoginUserId']").sendKeys("Test123");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		driver.quit();
	}
	
}

