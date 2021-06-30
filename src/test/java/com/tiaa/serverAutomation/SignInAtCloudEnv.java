package com.tiaa.serverAutomation;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SignInAtCloudEnv {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
	      
	      // Set your access credentials
	      caps.setCapability("browserstack.user", "dhanashrimane_6VkUxo");
	      caps.setCapability("browserstack.key", "E6x31LuGLacb2Uw6t4sy");
	      
	      // Set URL of the application under test
	      caps.setCapability("app", "bs://02047ffe427824c2782bc2cac832d2b30a62170e");
	      
	      // Specify device and os_version for testing
	      caps.setCapability("device", "Google Pixel 3");
	      caps.setCapability("os_version", "9.0");
	        
	      // Set other BrowserStack capabilities
	      caps.setCapability("project", "MobileAutomation");
	      caps.setCapability("build", "Java Android");
	      caps.setCapability("name", "Sign In Test");
	        
	      
	      // Initialise the remote Webdriver using BrowserStack remote URL
	      // and desired capabilities defined above
	        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
	            new URL("http://hub.browserstack.com/wd/hub"), caps);//not localhost as device is at some another location
	        

	      /* Write your Custom code here */
	        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	        driver.findElementByXPath("//*[@text='Dismiss']").click();
	        driver.findElementByXPath("//*[@text='Profile']").click();
	        driver.findElementByXPath("//*[@text='Sign up with email']").click();
			driver.findElementByXPath("//*[@text='First name']").sendKeys("test123");
			driver.findElementByXPath("//*[@content-desc='Last name']").sendKeys("test123");
			
			driver.findElementByXPath("//*[@text='Birthday']").click();
			driver.findElementByXPath("(//*[@resource-id='android:id/numberpicker_input'])[1]").click();
			driver.findElementByXPath("(//*[@resource-id='android:id/numberpicker_input'])[1]").clear();
			driver.findElementByXPath("(//*[@resource-id='android:id/numberpicker_input'])[1]").sendKeys("08");
			
			driver.findElementByXPath("(//*[@resource-id='android:id/numberpicker_input'])[2]").click();
			driver.findElementByXPath("(//*[@resource-id='android:id/numberpicker_input'])[2]").clear();
			driver.findElementByXPath("(//*[@resource-id='android:id/numberpicker_input'])[2]").sendKeys("Aug");
			
			driver.findElementByXPath("(//*[@resource-id='android:id/numberpicker_input'])[3]").click();
			driver.findElementByXPath("(//*[@resource-id='android:id/numberpicker_input'])[3]").clear();
			driver.findElementByXPath("(//*[@resource-id='android:id/numberpicker_input'])[3]").sendKeys("1990");
			driver.findElementByXPath("//*[@text='OK']").click();
			
			driver.findElementByXPath("//*[@text='Email address']").sendKeys("test123@gmail.com");
			driver.findElementByXPath("//*[@content-desc='Password']").sendKeys("test123");
	      // Invoke driver.quit() after the test is done to indicate that the test is completed.
	      driver.quit();}

}
