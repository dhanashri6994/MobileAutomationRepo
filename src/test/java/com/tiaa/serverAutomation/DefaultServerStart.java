package com.tiaa.serverAutomation;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class DefaultServerStart {

	public static void main(String[] args) throws InterruptedException   {
		// TODO Auto-generated method stub

		AppiumDriverLocalService service=null;

		try {

			service=AppiumDriverLocalService.buildDefaultService();//port 4723// Default settings
			System.out.println(service.isRunning());

			service.start();
			
			//Load Desired capabilities and connect to android driver
			System.out.println(service.isRunning());
			System.out.println(service.getUrl());


			//DesiredCapabilities
			DesiredCapabilities cap= new DesiredCapabilities();
			cap.setCapability("deviceName", "redmi");
			cap.setCapability("platformName", "Android");

			AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(service,cap);//Added server details thorough service object
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			Thread.sleep(3000);
		} 
		finally {
			service.stop();
		}
		System.out.println(service.isRunning());
	}

}
