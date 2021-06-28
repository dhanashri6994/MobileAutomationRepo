package com.tiaa.webapp;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class OpenBrowserTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Level 1 -  connect to appium server
		//DesiredCapabilities
		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setCapability("deviceName", "redmi");
		cap.setCapability("platformName", "Android");
		cap.setCapability("browserName", "Chrome");
		cap.setCapability("chromedriverExecutable", "C:\\Dhanashri\\chromedriver_win32\\chromedriver.exe");
		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);
		
		driver.get("https://google.com");
		String title=driver.getTitle();
		System.out.println("Title :" +title);
	}
	

}
