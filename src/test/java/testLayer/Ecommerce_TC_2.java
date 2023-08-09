package testLayer;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class Ecommerce_TC_2 extends BaseTest{
	
	
	@Test
	public void FillForm() throws InterruptedException
	{
			
		WebElement Name =driver.findElement(By.id("com.androidsample.generalstore:id/nameField"));
		Name.clear();
		Name.sendKeys("Demo User");
		driver.hideKeyboard();
		
		WebElement GenderSelect=driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']"));
		GenderSelect.click();
		
		WebElement Dropdown= driver.findElement(By.id("android:id/text1"));
		Dropdown.click();
		
		WebElement Country=driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"));
		//WebElement Country=driver.findElement(By.xpath("//android.widget.TextView[@text='Angola']"));
		Country.click();
		
		WebElement ShopBtn=driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"));
		ShopBtn.click();
		
		
		// Product Catalogue
		WebElement Product=driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"))"));
		Product.click();
		
		int productCount= driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		
		for(int i=0; i<productCount; i++)
		{
			String productName=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if(productName.equalsIgnoreCase("Jordan 6 Rings"))
			{
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			}
		}
		
		WebElement cart=driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart"));
		cart.click();
		//Thread.sleep(10000);
		
		
		
		WebDriverWait wait=new  WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text", "Cart"));
		
		
		
		//My Assertion==
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.androidsample.generalstore:id/productName")));
//	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.androidsample.generalstore:id/toolbar_title")));
		
	  System.out.println("Result1");
		
		// Cart Page
		String lastPageProduct=driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals(lastPageProduct, "Jordan 6 Rings");
	  System.out.println("Result2");
	}

	

}
