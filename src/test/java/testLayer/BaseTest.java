package testLayer;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;




public class BaseTest {

	public AndroidDriver driver;
//	public AppiumDriverLocalService;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void appiumConfig() throws MalformedURLException
	{
		//code to start server
//		
//	    service = new AppiumServiceBuilder()
//	    		.withAppiumJS(new File("C:\\Users\\other\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//	    		.withTimeout(Duration.ofSeconds(300))
//	    		.withIPAddress("127.0.0.1").usingPort(4723).build();
//	    
//				service.start();    //--// Here is one error to start server from code//--//
			

				
		
		
		//AndroidDriver , IOSDriver
		//Appium Code -> Appium Server -> Mobile
		
		UiAutomator2Options options = new UiAutomator2Options();
//		options.setDeviceName("UdayEmulator");
//		options.setCapability("isHeadless", true);
		options.setCapability("avd", "UdayEmulator");
		//options.setApp("C:\\Users\\other\\eclipse-workspace\\project\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		
		options.setApp("C:\\Users\\other\\eclipse-workspace\\project\\src\\test\\java\\resources\\General-Store.apk");
		
		//AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		 driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public Double getFormattedAmount(String amount)
	{
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	//	service.stop();
	}
}
