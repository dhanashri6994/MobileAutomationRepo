package com.tiaa.webapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class NativeApp_LoginWithEmailID {

	public static void main(String[] args) throws MalformedURLException {//Level 1 -  connect to appium server
		//DesiredCapabilities
		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setCapability("deviceName", "redmi");
		cap.setCapability("platformName", "Android");
		//To install native app
		cap.setCapability("app", "C:\\Users\\Admin\\Downloads\\Khan Academy_v6.3.0_apkpure.com.apk");

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		driver.findElementByXPath("//*[@text='Dismiss']").click();
		driver.findElementByXPath("//*[@text='Profile']").click();

		driver.findElementByXPath("//*[@text='Sign up with email']").click();
		driver.findElementByXPath("//*[@text='First name']").sendKeys("test123");
		driver.findElementByXPath("//*[@content-desc='Last name']").sendKeys("test123");

		driver.findElementByXPath("//*[@text='Birthday']").click();

		int str1=driver.findElementByXPath("(//*[@resource-id='android:id/numberpicker_input'])[1]").getText().length();
		int str2=driver.findElementByXPath("(//*[@resource-id='android:id/numberpicker_input'])[2]").getText().length();
		String dayxpath="", monthXpath="";
		if(str1==2 && str2==3)
		{
			dayxpath="(//*[@resource-id='android:id/numberpicker_input'])[1]";
			monthXpath="(//*[@resource-id='android:id/numberpicker_input'])[2]";
		}
		else {
			dayxpath="(//*[@resource-id='android:id/numberpicker_input'])[2]";
			monthXpath="(//*[@resource-id='android:id/numberpicker_input'])[1]";
		}

		//Keeps on checking till the day is not having value as 08
		while(!driver.findElementByXPath(dayxpath).equals("08"))
		{
			driver.findElementByXPath(dayxpath).click();
			driver.findElementByXPath(dayxpath).clear();
			driver.findElementByXPath(dayxpath).sendKeys("08");
		}

		while(!driver.findElementByXPath(dayxpath).equals("Aug"))
		{
			driver.findElementByXPath(monthXpath).click();
			driver.findElementByXPath(monthXpath).clear();
			driver.findElementByXPath(monthXpath).sendKeys("Aug");
		}
		while(!driver.findElementByXPath("(//*[@resource-id='android:id/numberpicker_input'])[3]").equals("1990"))
		{
			driver.findElementByXPath("(//*[@resource-id='android:id/numberpicker_input'])[3]").click();
			driver.findElementByXPath("(//*[@resource-id='android:id/numberpicker_input'])[3]").clear();
			driver.findElementByXPath("(//*[@resource-id='android:id/numberpicker_input'])[3]").sendKeys("1990");
		}
		driver.findElementByXPath("//*[@text='OK']").click();

		driver.findElementByXPath("//*[@text='Email address']").sendKeys("test123@gmail.com");
		driver.findElementByXPath("//*[@content-desc='Password']").sendKeys("test123");

		driver.closeApp();
	}

}
