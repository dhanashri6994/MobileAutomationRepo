package com.tiaa.webapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class NativeApp_OpenExistingApp {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setCapability("deviceName", "redmi");
		cap.setCapability("platformName", "Android");
		/*
		 * //can get from appium server inspector 
		 * cap.setCapability("appPackage","org.khanacademy.android"); 
		 * //Use apkAnalyzer app to get activity
		 * cap.setCapability("appActivity", "org.khanacademy.android.ui.library.MainActivity");
		 */

		/*
		 * //can get from appium server inspector cap.setCapability("appPackage",
		 * "com.aranah.healthkart.plus"); //Use apkAnalyzer app to get activity
		 * cap.setCapability("appActivity", "com.aranah.healthkart.home.HomeActivity");
		 */
		
		cap.setCapability("appPackage", "com.aranah.healthkart.plus"); //Use apkAnalyzer app to get activity
		cap.setCapability("appActivity", "com.aranah.healthkart.home.HomeActivity");
		//To stop reseting aap
		cap.setCapability("noReset", true);

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElementByXPath("//*[@text='Health Products']").click();
		
	}

}
