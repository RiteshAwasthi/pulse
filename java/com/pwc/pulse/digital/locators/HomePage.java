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
public class HomePage {

	WebDriver driver;

	@FindBy(xpath = "//button[@id='js-cookie-button']")
	WebElement i_Understand_btn;

	@FindBy(xpath = "(//button[@class='subscribe-modal__close btr bt-times'])[1]")
	WebElement popup_X_btn;

	@FindBy(xpath = "//li[@class='flex flex-active-slide']//child::div/div")
	List<WebElement> total_count_of_articles;

	@FindBy(xpath = "(//a[@class='flex-next']")
	WebElement next_arrow_btn;

	@FindBy(xpath = "(//a[@class='flex-prev']")
	WebElement previous_arrow_btn;

	/*
	 * This initElements method will create all WebElements
	 */
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * Purpose of this method is to click "I Understand" button on the popup
	 */
	public void clickOnIUnderstandButton() throws IllegalAccessException, InterruptedException {

		UserActionsUtilities.safeClick(i_Understand_btn, driver);

	}

	/*
	 * Purpose of this method is to click "X" button on the popup
	 */
	public void clickontheXIcon() throws IllegalAccessException, InterruptedException {

		UserActionsUtilities.safeClick(popup_X_btn, driver);

	}

	/*
	 * Purpose of this method is to get the count Articles
	 */
	public void gettheCountofArticles() {

		total_count_of_articles.size();
	}

	/*
	 * Purpose of this method is to click on Next arrow icon
	 */
	public void clickontheNextArrowIcon() throws IllegalAccessException, InterruptedException {

		UserActionsUtilities.safeClick(next_arrow_btn, driver);

	}

	/*
	 * Purpose of this method is to click on Previous arrow icon
	 */
	public void clickonthePrevArrowIcon() throws IllegalAccessException, InterruptedException {

		UserActionsUtilities.safeClick(previous_arrow_btn, driver);

	}

}
