package com.tiaa.serverAutomation;

import io.appium.java_client.service.local.AppiumDriverLocalService;

public class DefaultServerStart {

	public static void main(String[] args)   {
		// TODO Auto-generated method stub
		
		AppiumDriverLocalService service=AppiumDriverLocalService.buildDefaultService();//port 4723// Default settings
		System.out.println(service.isRunning());
		
		service.start();
		
		try {
			
			//Load Desired capabilities and connect to android driver
			System.out.println(service.isRunning());
			System.out.println(service.getUrl());
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
		service.stop();
		}
		System.out.println(service.isRunning());
	}

}
