package com.qa.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestBase {
	public RemoteWebDriver driver;
	public  void  initialization_chrome()
	{
//		DesiredCapabilities caps= DesiredCapabilities.chrome();
		
		//The old method Capabilities is deprecated. Use ChromeOptions object and passed it to the ChromeDriver() 
//		constructor. Also, you don't need to use options.merge(capabilities); 
//		instead, you can use options.setCapability(params, params)
		
		try {
			ChromeOptions options= new ChromeOptions();
			URL url =new URL("http://localhost:4445/wd/hub");
			 driver = new RemoteWebDriver(url, options);
			 System.out.println("Launch Chrome");
			 System.out.println("chrome:"+java.time.LocalTime.now());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void initialization_firefox()
	{

		try {
			FirefoxOptions options= new FirefoxOptions();
			URL url =new URL("http://localhost:4445/wd/hub");
			 driver = new RemoteWebDriver(url, options);
			 System.out.println("Launch Firefox");
			 System.out.println("firefox:"+java.time.LocalTime.now());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void initialization_edge()
	{

		try {
			EdgeOptions options= new EdgeOptions();
			URL url =new URL("http://localhost:4445/wd/hub");
			 driver = new RemoteWebDriver(url, options);
			 System.out.println("Launch Edge");
			 System.out.println("edge:"+java.time.LocalTime.now());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
