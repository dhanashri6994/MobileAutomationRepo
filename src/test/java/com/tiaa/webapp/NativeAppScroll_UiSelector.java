package com.tiaa.webapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class NativeAppScroll_UiSelector {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setCapability("deviceName", "redmi");
		cap.setCapability("platformName", "Android");
		//To install native app
		cap.setCapability("app", "C:\\Users\\Admin\\Downloads\\Khan Academy_v6.3.0_apkpure.com.apk");
		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		//Always paa UiSelector as a string
		driver.findElementByAndroidUIAutomator("UiSelector().text(\"Dismiss\")").click();
		driver.findElementByAndroidUIAutomator("UiSelector().description(\"Profile tab\")").click();
		//driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"org.khanacademy.android:id/tab_bar_button_home\")").click();
		
		driver.findElementByAndroidUIAutomator("UiSelector().text(\"Sign in\")").click();
		driver.findElementByAndroidUIAutomator("UiSelector().text(\"//*[@text='Enter an e-mail address or username']\")").sendKeys("test123");
		driver.findElementByAndroidUIAutomator("UiSelector().text(\"Password\")").sendKeys("test123");
		driver.findElementByAndroidUIAutomator("UiSelector().text(\"Sign in\").index(0)").click();
		driver.findElementByAndroidUIAutomator("UiSelector().textContains(\"Invalid\")");
	}

}
