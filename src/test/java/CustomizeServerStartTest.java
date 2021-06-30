import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class CustomizeServerStartTest {


	public static void main(String[] args) throws InterruptedException   {
		// TODO Auto-generated method stub

		AppiumDriverLocalService service=null;


		try {
			//Custimizing the server details. instead of using default server
			AppiumServiceBuilder builder = new AppiumServiceBuilder()
					.usingPort(1212) //for specific port
					//.usingAnyFreePort() //for any free port
					.withLogFile(new File("Logs/ServiceLog.log"))
					.withArgument(GeneralServerFlag.RELAXED_SECURITY);

			service= AppiumDriverLocalService.buildService(builder);
			if(!service.isRunning())
			{
				service.start();
			}
			
			//DesiredCapabilities
			DesiredCapabilities cap= new DesiredCapabilities();
			cap.setCapability("deviceName", "redmi");
			cap.setCapability("platformName", "Android");

			AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(service,cap);//Added server details thorough service object
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			Thread.sleep(3000);
			System.out.println(service.getUrl());
		}
		finally {
			service.stop();
		}
	}

}
