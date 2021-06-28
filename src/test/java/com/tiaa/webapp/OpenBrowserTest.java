package com.tiaa.webapp;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class OpenBrowserTest {

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
			driver.get("https://magento.com");
			
			String title=driver.getTitle();
			System.out.println("Title :" +title);
			driver.findElementByXPath(".//span[text()='Sign in']").click();
			driver.findElementByXPath(".//input[@title='Email']").sendKeys("balaji0017@gmail.com");
			driver.findElementByXPath(".//input[@title='Password']").sendKeys("balaji@12345");
			
			//JavascriptExecutor js = ((JavascriptExecutor) driver);
			//js.executeScript("arguments[0].click();", driver.findElementByXPath(".//span[text()='Continue']"));
		
			//To use all the methods change java compiler version to 15 from properties.
			if(driver.isKeyboardShown())
			{
				driver.hideKeyboard();
			}
			Thread.sleep(5000);
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].click();", driver.findElementByXPath(".//span[text()='Continue']"));
				
			//driver.findElementByXPath(".//span[text()='Continue']").click();
			System.out.println("Logged In....");
			System.out.println("Title :" + driver.getTitle());
			driver.findElementByXPath(".//a[text()='Log Out']").click();	
			System.out.println("Logged Out....");
			Thread.sleep(5000);
			driver.quit();
		}
		
}
