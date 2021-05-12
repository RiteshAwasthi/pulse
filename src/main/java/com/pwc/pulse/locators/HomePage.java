package com.pwc.pulse.locators;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pwc.pulse.utilities.UserActionsUtilities;

/*
 * @author - Ritesh Awasthi
 * @date - 12-May-2021
 * @purpose - Purpose of this class is to keep all the locators of Homepage in one location, so that if there is any change in the locators then we don't need to
 * change the entire script. We just need to change location in this class only.
 */
public class HomePage {

	WebDriver driver;

	@FindBy(xpath = "//button[@id='js-cookie-button']")
	WebElement i_Understand_btn;

	@FindBy(xpath = "(//button[@class='subscribe-modal__close btr bt-times'])[1]")
	WebElement popup_X_btn;

	@FindBy(xpath = "//li[@class='flex flex-active-slide']//child::div/div")
	List<WebElement> total_count_of_articles;

	@FindBy(xpath = "//a[@class='flex-next']")
	WebElement next_arrow_btn;

	@FindBy(xpath = "//a[@class='flex-prev']")
	WebElement previous_arrow_btn;

	@FindBy(xpath = "(//span[@class='article-type']//following::h2)[4]")
	WebElement firstArticleText;

	@FindBy(xpath = "(//span[@class='article-type']//following::h2)[5]")
	WebElement secondArticleText;

	@FindBy(xpath = "(//span[@class='article-type']//following::h2)[6]")
	WebElement thirdArticleText;

	/*
	 * This initElements method will create all WebElements
	 */
	public HomePage(WebDriver driver) {
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
	 * @Purpose - Purpose of this method is to click "I Understand" button on the
	 * popup of homepage
	 */
	public void clickOnIUnderstandButton() throws IllegalAccessException, InterruptedException {

		UserActionsUtilities.safeClick(i_Understand_btn, driver);

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
	 * @Purpose - Purpose of this method is to click "X" button on the popup of
	 * homepage
	 */
	public void clickontheXIcon() throws IllegalAccessException, InterruptedException {

		UserActionsUtilities.safeClick(popup_X_btn, driver);

	}

	/*
	 * @author - Ritesh Awasthi
	 * 
	 * @param - No parameter
	 * 
	 * @date - 12-May-2021
	 * 
	 * @return - int value
	 * 
	 * @Purpose - Purpose of this method is to get the count Articles on the
	 * homepage
	 */
	public int getTheCountOfArticles() {

		return total_count_of_articles.size();
	}

	/*
	 * @author - Ritesh Awasthi
	 * 
	 * @param - No parameter
	 * 
	 * @date - 12-May-2021
	 * 
	 * @return - void type
	 * 
	 * @purpose - Purpose of this method is to click on Next arrow icon on the
	 * homepage
	 */
	public void clickOnTheNextArrowIcon() throws IllegalAccessException, InterruptedException {

		UserActionsUtilities.safeClick(next_arrow_btn, driver);

	}

	/*
	 * @author - Ritesh Awasthi
	 * 
	 * @param - No parameter
	 * 
	 * @date - 12-May-2021
	 * 
	 * @return - void type
	 * 
	 * @purpose - Purpose of this method is to click on Previous arrow icon
	 */
	public void clickOnThePrevArrowIcon() throws IllegalAccessException, InterruptedException {

		UserActionsUtilities.safeClick(previous_arrow_btn, driver);

	}

	/*
	 * @author - Ritesh Awasthi
	 * 
	 * @param - No parameter
	 * 
	 * @date - 12-May-2021
	 * 
	 * @return - String type
	 * 
	 * @purpose - Purpose of this method is to get the text on the first card of
	 * homepage
	 */
	public String getTextOfFirstArticles() throws InterruptedException {

		// We are using dynamic wait
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(firstArticleText));

		String firstArticalTextValue = firstArticleText.getText();
		System.out.println("First value is -> " + firstArticalTextValue);

		return firstArticalTextValue;
	}

	/*
	 * @author - Ritesh Awasthi
	 * 
	 * @param - No parameter
	 * 
	 * @date - 12-May-2021
	 * 
	 * @return - String type
	 * 
	 * @purpose - Purpose of this method is to get the text on the second card of
	 * homepage
	 */
	public String getTextOfSecondArticles() {
		
		String secondArticalTextValue = secondArticleText.getText();
		return secondArticalTextValue;
	}

	/*
	 * @author - Ritesh Awasthi
	 * 
	 * @param - No parameter
	 * 
	 * @date - 12-May-2021
	 * 
	 * @return - String type
	 * 
	 * @purpose - Purpose of this method is to get the text on the third card of
	 * homepage
	 */
	public String getTextOfThirdArticles() {
		
		String thirdArticalTextValue = thirdArticleText.getText();
		return thirdArticalTextValue;
	}

}
