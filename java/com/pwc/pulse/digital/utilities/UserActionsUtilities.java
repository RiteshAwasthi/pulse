package com.pwc.pulse.digital.utilities;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class UserActionsUtilities {
	
public static void safeClick(WebElement element, WebDriver driver) throws InterruptedException, IllegalAccessException {
		
		
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(element));

			if (element.isDisplayed() && element.isEnabled()) {

				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].scrollIntoView()", element);
				
				
				element.click();
				

			}
		} catch (Exception exception) {
			
			
			exception.getStackTrace();
		} 
	}

	public static void safeSendKeys(WebElement element, String inputText, WebDriver driver) {

		
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(element));

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView()", element);

			
			element.clear();
			element.sendKeys(inputText);
		
			
		} catch (Exception exception) {
			exception.getStackTrace();
		}
	}


}
