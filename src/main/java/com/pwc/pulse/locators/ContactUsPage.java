package com.pwc.pulse.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pwc.pulse.utilities.UserActionsUtilities;

/*
 * @author - Ritesh Awasthi
 * @date - 12-May-2021
 * @purpose - Purpose of this class is to keep all the locators of Contact Us page in one location, so that if there is any change in the locators then we don't need to
 * change the entire script. We just need to change location in this class only.
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

	/*
	 * @author - Ritesh Awasthi
	 * 
	 * @param - No parameter
	 * 
	 * @date - 12-May-2021
	 * 
	 * @return - Not return any value
	 * 
	 * @Purpose - Click on the Humburg Menu
	 */
	public void clickOnHumburgMenu() throws IllegalAccessException, InterruptedException {
		UserActionsUtilities.safeClick(humburgMenuLink, driver);
	}

	/*
	 * @author - Ritesh Awasthi
	 * 
	 * @param - No parameter
	 * 
	 * @date - 12-May-2021
	 * 
	 * @return - Not return any value
	 * 
	 * @Purpose - Click on Contact Us link from the Humburg menu
	 */
	public void selectContactUsFromHumbugMenu() throws IllegalAccessException, InterruptedException {
		UserActionsUtilities.safeClick(humburgMenuContactUsLink, driver);
	}

	/*
	 * 
	 * @author - Ritesh Awasthi
	 * 
	 * @param - No parameter
	 * 
	 * @date - 12-May-2021
	 * 
	 * @return - Not return any value
	 * 
	 * @Purpose - Purpose of this method is to click on contact button on the first
	 * card
	 */
	public void clickOnDigitalServicesContactBtn() throws IllegalAccessException, InterruptedException {

		UserActionsUtilities.safeClick(digitalServiceLink, driver);

	}

	/*
	 * @author - Ritesh Awasthi
	 * 
	 * @param - No parameter
	 * 
	 * @date - 12-May-2021
	 * 
	 * @return - Not return any value
	 * 
	 * @Purpose - Purpose of this method is to click on contact button on the second
	 * card
	 */
	public void clickOnCareerAtBtn() throws IllegalAccessException, InterruptedException {

		UserActionsUtilities.safeClick(careerAtPwCLink, driver);

	}

	/*
	 * @author - Ritesh Awasthi
	 * 
	 * @param - No parameter
	 * 
	 * @date - 12-May-2021
	 * 
	 * @return - Not return any value
	 * 
	 * @Purpose - Purpose of this method is to clicking on contact button on the
	 * third card
	 */
	public void clickOnGeneralEnquiriesBtn() throws IllegalAccessException, InterruptedException {

		UserActionsUtilities.safeClick(generalEnquiriesLink, driver);

	}

}
