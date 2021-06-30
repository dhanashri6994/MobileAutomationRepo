import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class HybridAppTest {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		

		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setCapability("deviceName", "redmi");
		cap.setCapability("platformName", "Android");
		
		  //can get from appium server inspector 
		  cap.setCapability("appPackage","com.ltts.myts"); 
		  //Use apkAnalyzer app to get activity
		  cap.setCapability("appActivity", "android.support.customtabs.trusted.LauncherActivity");
		  cap.setCapability("chromedriverExecutable", "C:\\Dhanashri\\chromedriver_win32\\chromedriver.exe");
		  
		  AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 
		  String currentContext=driver.getContext();
		  System.out.println("Current Context :"+currentContext);
		  System.out.println("------------------------------------");

			Set<String> contexts= driver.getContextHandles();
			
			for(String context : contexts)
			{
				System.out.println(context);
				
				driver.context(context);// to switch to context
				
				if(driver.findElementsByXPath("//*[@id='txtPassword']").size()>0)
				{
					break;
				}
			}
			
			//it will try to point to the context where //*[@id='txtPassword'] is available
			driver.findElementByXPath("//*[@id='txtUsername']").sendKeys("123");
			driver.findElementByXPath("//*[@id='txtPassword']").sendKeys("hello123");
			
			driver.findElementByXPath("//*[@id='submit']").click();

			driver.closeApp();
	}

}
