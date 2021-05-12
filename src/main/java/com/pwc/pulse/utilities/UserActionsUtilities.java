package com.pwc.pulse.utilities;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/*
 * @author - Ritesh Awasthi
 * @date - 12-May-2021
 * @Purpose - Purpose of this class is to create generic methods which can be used in application
 */
public class UserActionsUtilities {

	/*
	 * @author - Ritesh Awasthi
	 * 
	 * @param - WebElement and WebDriver
	 * 
	 * @date - 12-May-2021
	 * 
	 * @return - Not return any value
	 * 
	 * @Purpose - Purpose of this method is to click on any element
	 */
	public static void safeClick(WebElement element, WebDriver driver)
			throws InterruptedException, IllegalAccessException {
		try {
			
			// Using dynamic wait - Once element is clickable then only element will be clicked
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(element));

			if (element.isDisplayed() && element.isEnabled()) {
				
				//Using javascriptexecutor to scroll the element to the center of the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView()", element);

				element.click();
			}
		} catch (Exception exception) {

			exception.getStackTrace();
		}
	}

	/*
	 * @author - Ritesh Awasthi
	 * 
	 * @param - WebElement, String and WebDriver
	 * 
	 * @date - 12-May-2021
	 * 
	 * @return - Not return any value
	 * 
	 * @Purpose - Purpose of this method is to type the value in the element
	 */
	public static void safeSendKeys(WebElement element, String inputText, WebDriver driver) {

		try {
			
			// Using dynamic wait - Once element is visibility then only input text will be entered
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(element));

			//Using javascriptexecutor to scroll the element to the center of the screen

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView()", element);

			// Before entering any text, clearing the existing text
			element.clear();
			element.sendKeys(inputText);

		} catch (Exception exception) {
			exception.getStackTrace();
		}
	}

	/*
	 * @author - Ritesh Awasthi
	 * 
	 * @param - WebDriver
	 * 
	 * @date - 12-May-2021
	 * 
	 * @return - Not return any value
	 * 
	 * @Purpose - Purpose of this method open the new tab
	 */
	public static void openNewTab(WebDriver driver) {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
	}

	/*
	 * @author - Ritesh Awasthi
	 * 
	 * @param - WebDriver, int
	 * 
	 * @date - 12-May-2021
	 * 
	 * @return - Not return any value
	 * 
	 * @Purpose - Purpose of this method is to switch the given tab
	 */
	public static void switchToTab(WebDriver driver, int positionOfTab) {
		
		// Storing all the tabs in array list
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(positionOfTab));
	}

}
