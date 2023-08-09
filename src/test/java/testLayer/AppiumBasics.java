package testLayer;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import junit.framework.Assert;

public class AppiumBasics extends BaseTest{
	
	@Test
	public void AppiumTest () throws MalformedURLException
	{
		//code to start server
		
//		AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\other\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js.map"))
//		.withIPAddress("127.0.0.1").usingPort(4723).build();
//		service.start();    //--// Here is one error to start server from code//--//
		
		
		//AndroidDriver , IOSDriver
		//Appium Code -> Appium Server -> Mobile
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("UdayEmulator");
		options.setApp("C:\\Users\\other\\eclipse-workspace\\project\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
//		
		//Actual Automation Code --//--
		//{By.===>> use >>Xpath, Id, classname,} {AppiumBy.===>> use>>  accessibilityId,  androidUIAutomator}
		
		//tagname[@attribute="value"]  //tagname
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
		String alertTitle= driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		
		driver.findElement(By.id("android:id/edit")).sendKeys("UdayWifi");
		driver.findElement(By.id("android:id/button1")).click();
		
		//after execution of all code --  we have to close the browser and server;
	//	driver.quit();   //close browser
		//service.stop();  //stop server
	}

}
