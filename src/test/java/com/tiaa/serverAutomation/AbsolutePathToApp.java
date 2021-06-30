package com.tiaa.serverAutomation;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AbsolutePathToApp {

	

		public static void main(String[] args) throws MalformedURLException {
			// TODO Auto-generated method stub
			File file1=new File("src/test/resources/App/Khan Academy_v6.3.0_apkpure.com.apk");
			String apkPath=file1.getAbsolutePath();
			
			//DesiredCapabilities
					DesiredCapabilities cap= new DesiredCapabilities();
					cap.setCapability("deviceName", "redmi");
					cap.setCapability("platformName", "Android");
					
					cap.setCapability("app", apkPath);
					
					AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);
					driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		

}

}
