package testLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Ecommerce_TC_1 extends BaseTest{
	
	@Test(priority =1)
	public void FillFormWithInvalidData() throws InterruptedException
	{
			
		WebElement Name =driver.findElement(By.id("com.androidsample.generalstore:id/nameField"));
		Name.clear();
		Name.sendKeys("    ");
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
		
		//if
		//Error Message Displayed== android.widget.Toast
		
		String toastMessage=driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("Name");
		Assert.assertEquals(toastMessage, "Please enter your name");
		
	}

	
	@Test(priority =2)
	public void FillFormWithValidData() throws InterruptedException
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
	}

}
