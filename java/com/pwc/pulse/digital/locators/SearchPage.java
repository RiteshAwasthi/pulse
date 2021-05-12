package com.pwc.pulse.digital.locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.pwc.pulse.digital.utilities.UserActionsUtilities;

/*
 * @author - Ritesh Awasthi
 * @param - No parameter
 * @return - 
 * Purpose of this class is to keep all the locators in one location so if there is any change in the locators we don't need to
 * change entire script. We just need to change location in this class only.
 */
public class SearchPage {

	WebDriver driver;

	@FindBy(xpath = "//i[@class='btr bt-search']")
	WebElement searchBtn;

	@FindBy(id = "search-input")
	WebElement searchInputTxt;

	/*
	 * This initElements method will create all WebElements
	 */
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * Purpose of this method is to click on search Icon
	 */
	public void clickOnSearchIcon() throws IllegalAccessException, InterruptedException {

		UserActionsUtilities.safeClick(searchBtn, driver);
	}

	/*
	 * Purpose of this method is to accept the input text as string and entering the
	 * text in the input text field
	 */
	public void enterTextInSearchField(String inputText) {

		UserActionsUtilities.safeSendKeys(searchInputTxt, inputText, driver);

	}

	/*
	 * Purpose of this method is to press the Enter key
	 */
	public void pressEnterKey() {

		searchInputTxt.sendKeys(Keys.ENTER);
	}

}
