package com.tiaa.webapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class NativeAppAutomation {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		//Level 1 -  connect to appium server
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
		//or
		//driver.findElementByXPath("//*[@content-desc='Profile Tab']").click();
		//driver.findElementById("//*[@resource-id='org.khanacademy.android:id/tab_bar_button_profile']").click();
	
		driver.findElementByXPath("//*[@text='Sign in']").click();
		driver.findElementByXPath("//*[@text='Enter an e-mail address or username']").sendKeys("test123");
		driver.findElementByXPath("//*[@content-desc='Password']").sendKeys("test123");
		driver.findElementByXPath("(//*[@text='Sign in'])[2]").click();
		//driver.findElementByXPath("//*[@text='Not now']").click();
		String msg=driver.findElementByXPath("//*[@text='Invalid password']").getText();
		System.out.println("msg :"+msg);
		
	}

}
