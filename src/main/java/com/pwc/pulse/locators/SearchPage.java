package com.pwc.pulse.locators;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pwc.pulse.utilities.UserActionsUtilities;

/*
 * @author - Ritesh Awasthi
 * @date - 12-May-2021
 * @purpose - Purpose of this class is to keep all the locators of Search Page in one location, so that if there is any change in the locators then we don't need to
 * change the entire script. We just need to change location in this class only.
 */
public class SearchPage {

	WebDriver driver;

	@FindBy(xpath = "//i[@class='btr bt-search']")
	WebElement searchBtn;

	@FindBy(id = "search-input")
	WebElement searchInputTxt;

	@FindBy(xpath = "(//span)[1]")
	WebElement searchResultHeader;

	@FindBy(xpath = "//h2/a")
	List<WebElement> countOfResult;

	/*
	 * This initElements method will create all WebElements
	 */
	public SearchPage(WebDriver driver) {
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
	 * @Purpose - Purpose of this method is to click "Search Button" button
	 */

	public void clickOnSearchIcon() throws IllegalAccessException, InterruptedException {

		UserActionsUtilities.safeClick(searchBtn, driver);
	}

	/*
	 * @author - Ritesh Awasthi
	 * 
	 * @param - String parameterr
	 * 
	 * @date - 12-May-2021
	 * 
	 * @return - Not return any value
	 * 
	 * @Purpose - Purpose of this method is to accept the input text as string and
	 * entering the text in the input text field
	 */
	public void enterTextInSearchField(String inputText) {

		UserActionsUtilities.safeSendKeys(searchInputTxt, inputText, driver);

	}

	/*
	 * @author - Ritesh Awasthi
	 * 
	 * @param - no parameter
	 * 
	 * @date - 12-May-2021
	 * 
	 * @return - Not return any value
	 * 
	 * @Purpose - Purpose of this method is to press the Enter key
	 */
	public void pressEnterKey() {

		searchInputTxt.sendKeys(Keys.ENTER);
	}

	/*
	 * @author - Ritesh Awasthi
	 * 
	 * @param - no parameter
	 * 
	 * @date - 12-May-2021
	 * 
	 * @return - String value
	 * 
	 * @Purpose - Purpose of this method is to get the header value of the Search
	 * result page
	 */
	public String getSearchResultPageHeader() {
		String searchPageHeader = searchResultHeader.getText();
		return searchPageHeader;

	}

	/*
	 * @author - Ritesh Awasthi
	 * 
	 * @param - no parameter
	 * 
	 * @date - 12-May-2021
	 * 
	 * @return - int value
	 * 
	 * @Purpose - Purpose of this method is to get count of search results
	 */
	public int getCountOfSearchResult() {
		int count = countOfResult.size();
		return count;

	}

}
