package testLayer;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import junit.framework.Assert;

public class PriceValidation_TC_3 extends BaseTest{
	

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
		System.out.println("Hello1");
		
		
		
		WebElement addToCart1=driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART")).get(0);
		addToCart1.click();
		
		WebElement addToCart2=driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART")).get(0);
		addToCart2.click();
		
		//driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART")).get(0).click();
		System.out.println("Hello2");
		WebElement cart=driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart"));
		cart.click();
		//Thread.sleep(10000);
		
		WebDriverWait wait=new  WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text", "Cart"));
		
		List<WebElement> productPrices=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int count=productPrices.size();

		double totalsum=0;
		for(int i=0; i< count; i++)
		{
			String amountString =productPrices.get(i).getText();
			//$160.07   //ToRemove Doller from amout we use substring method
			Double price=getFormattedAmount(amountString);
			totalsum=totalsum+price;  //160.97 +120.0=280.97
			
		}
		String displaySum= driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		Double displayFormattedSum=getFormattedAmount(displaySum);
		
		Assert.assertEquals(totalsum, displayFormattedSum);
		
		
		//if
		//Error Message Displayed== android.widget.Toast
		
//		String toastMessage=driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("Name");
//		Assert.assertEquals(toastMessage, "Please enter your name");
		
	}


}
