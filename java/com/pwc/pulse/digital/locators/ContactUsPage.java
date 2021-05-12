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
public class ContactUsPage {

	WebDriver driver;

	@FindBy(xpath = "//i[@class='btr bt-bars trigger']")
	WebElement humburgMenuLink;

	@FindBy(xpath = "(//a[text()='Contact us'])[1]")
	WebElement humburgMenuContactUsLink;

	@FindBy(xpath = "(//a[text()='Contact'])[1]")
	WebElement digitalServiceLink;

	@FindBy(xpath = "(//a[text()='Contact'])[2]")
	WebElement careerAtPwCLink;

	@FindBy(xpath = "(//a[text()='Contact'])[3]")
	WebElement generalEnquiriesLink;

	/*
	 * This initElements method will create all WebElements
	 */
	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnHumburgMenu() throws IllegalAccessException, InterruptedException {
		UserActionsUtilities.safeClick(humburgMenuLink, driver);
	}
	
	public void selectContactUsFromHumbugMenu() throws IllegalAccessException, InterruptedException {
		UserActionsUtilities.safeClick(humburgMenuContactUsLink, driver);
	}
	
	/*
	 * Purpose of this method is to clicking on contact button on the first card
	 */
	public void clickOnContactButton1() throws IllegalAccessException, InterruptedException {

		UserActionsUtilities.safeClick(digitalServiceLink, driver);

	}

	/*
	 * Purpose of this method is to clicking on contact button on the second card
	 */
	public void clickOnContactButton2() throws IllegalAccessException, InterruptedException {

		UserActionsUtilities.safeClick(careerAtPwCLink, driver);

	}

	/*
	 * Purpose of this method is to clicking on contact button on the third card
	 */
	public void clickOnContactButton3() throws IllegalAccessException, InterruptedException {

		UserActionsUtilities.safeClick(generalEnquiriesLink, driver);

	}

}
