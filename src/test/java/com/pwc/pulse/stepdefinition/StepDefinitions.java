package com.pwc.pulse.stepdefinition;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pwc.pulse.locators.ContactUsPage;
import com.pwc.pulse.locators.HomePage;
import com.pwc.pulse.locators.SearchPage;
import com.pwc.pulse.utilities.ReadData;
import com.pwc.pulse.utilities.UserActionsUtilities;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class StepDefinitions {

	// Creating object of ReadData()
	ReadData loadTestData = new ReadData();

	WebDriver driver;

	/*
	 * @author - Ritesh Awasthi
	 * 
	 * @param - No parameter
	 * 
	 * @date - 12-May-2021
	 * 
	 * @return - Not return any value
	 * 
	 * @Purpose - Purpose of this hook is execute following lines of code before any
	 * scenario
	 */
	@Before
	public void setUp() {

		/*
		 * Using WebDriverManager so that whenever version of browser is updated then we
		 * don't need to manually download the chrome driver. This will automatically
		 * download the driver
		 */
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Maximum 20 seconds it will wait to load the entire page
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		// Maximize the browsers
		driver.manage().window().maximize();
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
	 * @Purpose - Purpose of this hook is execute following lines of code after any
	 * scenario
	 */
	@After
	public void tearDown() {

		driver.quit();
	}
	
	/*
	 * @author - Ritesh Awasthi
	 * 
	 * @param - Scenario
	 * 
	 * @date - 12-May-2021
	 * 
	 * @return - Not return any value
	 * 
	 * @Purpose - Purpose of this method is to capture the screenshot of failure test cases
	 */
	@AfterStep
	public void addScreenshot(Scenario scenario){

		//validate if scenario has failed
		if(scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png", "image");
		}
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
	 * @Purpose - Purpose of this method is getch the URL of application from the
	 * external file and launch application
	 */
	@Given("I navigate to the PwC Digital Pulse website")
	public void i_navigate_to_the_PwC_Digital_Pulse_website() {

		// Fetching the URL from config properties file
		driver.get(loadTestData.readFile("config.properties").getProperty("url"));

	}

	/*
	 * @author - Ritesh Awasthi
	 * 
	 * @param - String
	 * 
	 * @date - 12-May-2021
	 * 
	 * @return - Not return any value
	 * 
	 * @Purpose - This method will validate the Homepage header
	 */
	@When("I am viewing the {string} page")
	public void i_am_viewing_the_page(String string) {

		String actualTitle = driver.getTitle();

		// validate user is on the Home Page.
		assertEquals(actualTitle, loadTestData.readFile("testdata.properties").getProperty("homepageTitle"));

	}

	/*
	 * @author - Ritesh Awasthi
	 * 
	 * @param - int
	 * 
	 * @date - 12-May-2021
	 * 
	 * @return - Not return any value
	 * 
	 * @Purpose - This method will validate the total number of articles
	 */
	@Then("I am presented with a carousel displaying {int} featured articles")
	public void i_am_presented_with_a_carousel_displaying_featured_articles(Integer actualCount)
			throws IllegalAccessException, InterruptedException {

		HomePage locatores = new HomePage(driver);

		// click on I Understand button of the popup
		locatores.clickOnIUnderstandButton();

		// Click on the 'X' Icon of the popup
		locatores.clickontheXIcon();

		// Store the total count of carousel features
		int expectedValues = actualCount.intValue();
		int actualValues = locatores.getTheCountOfArticles();

		// Validate the carousel feature counts
		Assert.assertEquals(actualValues, expectedValues);

	}

	/*
	 * @author - Ritesh Awasthi
	 * 
	 * @param - String and int
	 * 
	 * @date - 12-May-2021
	 * 
	 * @return - Not return any value
	 * 
	 * @Purpose - This method will be clicking on the next button and Validating
	 * next page's carousel is displaying 3 featured articles
	 */
	@Then("Clicking the {string} button on the carousel will load the next {int} featured articles")
	public void clicking_the_button_on_the_carousel_will_load_the_next_featured_articles(String string,
			Integer expectedValue) throws IllegalAccessException, InterruptedException {

		HomePage homepage = new HomePage(driver);
		homepage.clickOnTheNextArrowIcon();

		// Store the total count of carousel features
		int actualValues = homepage.getTheCountOfArticles();
		int expectedValues = expectedValue.intValue();

		// validating the count of next displayed articles
		Assert.assertEquals(expectedValues, actualValues);

	}

	/*
	 * @author - Ritesh Awasthi
	 * 
	 * @param - String and int
	 * 
	 * @date - 12-May-2021
	 * 
	 * @return - Not return any value
	 * 
	 * @Purpose - This method will be clicking on the previous button and Validating
	 * previous page's carousel is displaying
	 */
	@Then("Clicking the {string} button on the carousel will load the previous {int} featured articles")
	public void clicking_the_button_on_the_carousel_will_load_the_previous_featured_articles(String string,
			Integer expectedValue) throws InterruptedException, IllegalAccessException {

		HomePage homepage = new HomePage(driver);
		Thread.sleep(2000);

		// clicking on the Previous Arrow icon
		homepage.clickOnThePrevArrowIcon();

		// Store the total count of carousel features
		int actualValues = homepage.getTheCountOfArticles();
		int expectedValues = expectedValue.intValue();

		// Validating the count of previous articles should be 3
		Assert.assertEquals(actualValues, expectedValues);

		// Fetch and store the text value first articles
		String firstArticalText = homepage.getTextOfFirstArticles();

		// Validating the first feature value.
		Assert.assertEquals(firstArticalText,
				loadTestData.readFile("testdata.properties").getProperty("firstArticleExpMsg"));

		// Fetch and store the text value second articles
		String secondArticalText = homepage.getTextOfSecondArticles();

		// Validating the first feature value.
		Assert.assertEquals(secondArticalText,
				loadTestData.readFile("testdata.properties").getProperty("secondArticleExpMsg"));

		// Fetch and store the text value third articles
		String thirdArticalText = homepage.getTextOfThirdArticles();

		// Validating the first feature value.
		Assert.assertEquals(thirdArticalText,
				loadTestData.readFile("testdata.properties").getProperty("thirdArticleExpMsg"));

	}

	// Second Scenarios
	/*
	 * @author - Ritesh Awasthi
	 * 
	 * @param - String
	 * 
	 * @date - 12-May-2021
	 * 
	 * @return - Not return any value
	 * 
	 * @Purpose - Purpose of this method is to Go to Hamburger menu and click on the
	 * Contact us link
	 */
	@When("I select {string} from the hamburger menu")
	public void i_select_from_the_hamburger_menu(String string) throws IllegalAccessException, InterruptedException {

		HomePage locatores = new HomePage(driver);
		ContactUsPage contactUsPage = new ContactUsPage(driver);

		// click on I Understand button of the popup
		locatores.clickOnIUnderstandButton();

		// Click on the 'X' Icon of the popup
		locatores.clickontheXIcon();

		// clicking on the Hamburger menu
		contactUsPage.clickOnHumburgMenu();

		// Click on the Contact us link from Humburg menu
		contactUsPage.selectContactUsFromHumbugMenu();
	}

	/*
	 * @author - Ritesh Awasthi
	 * 
	 * @param - String
	 * 
	 * @date - 12-May-2021
	 * 
	 * @return - Not return any value
	 * 
	 * @Purpose - Purpose of this method is to validate the header of Contact Us
	 * page
	 */
	@Then("I am taken to the {string} page")
	public void i_am_taken_to_the_page(String string) {

		String actualTitle = driver.getTitle();

		// Validating the header message of the Contact us page
		Assert.assertEquals(actualTitle,
				loadTestData.readFile("testdata.properties").getProperty("contactUsPageTitle"));

	}

	/*
	 * @author - Ritesh Awasthi
	 * 
	 * @param - String and int
	 * 
	 * @date - 12-May-2021
	 * 
	 * @return - Not return any value
	 * 
	 * @Purpose - Purpose of this method is to click on all the four links and
	 * Validate the URL's and Header value of the newly open tabs
	 */
	@And("I am presented with the below options for contacts")
	public void i_am_presented_with_the_below_options_for_contacts()
			throws InterruptedException, IllegalAccessException {

		ContactUsPage contactUsPage = new ContactUsPage(driver);

		contactUsPage.clickOnDigitalServicesContactBtn();

		// Opening new tab
		UserActionsUtilities.openNewTab(driver);

		// Switching to the new tab
		UserActionsUtilities.switchToTab(driver, 1);

		// Fetch the current URL and storing the value
		String url = driver.getCurrentUrl();

		// Validating the newly open tab and fetching the expected value from external
		// file
		Assert.assertEquals(url, loadTestData.readFile("testdata.properties").getProperty("urlOfExperienceCenter"));

		// Switching to the main tab
		UserActionsUtilities.switchToTab(driver, 0);
		contactUsPage.clickOnCareerAtBtn();

		// Switching to the new 2nd tab
		UserActionsUtilities.switchToTab(driver, 2);

		// Fetch the current URL and store in variable
		String careerUrl = driver.getCurrentUrl();

		// Validating the newly open tab and fetching the expected value from external
		// file
		Assert.assertEquals(careerUrl, loadTestData.readFile("testdata.properties").getProperty("urlOfCareers"));

		// Switching to the original tab
		UserActionsUtilities.switchToTab(driver, 0);

		// Switching to the new tab
		UserActionsUtilities.openNewTab(driver);

		// Clicking on the Contact button
		contactUsPage.clickOnGeneralEnquiriesBtn();

		// Switching to the new 3rd tab
		UserActionsUtilities.switchToTab(driver, 3);

		// Fetch the current URL and store in variable
		String enquiryUrl = driver.getCurrentUrl();

		// Validating the newly open tab and fetching the expected value from external
		// file
		Assert.assertEquals(enquiryUrl, loadTestData.readFile("testdata.properties").getProperty("urlOfEnquiries"));

	}

	// Third Scenarios
	/*
	 * @author - Ritesh Awasthi
	 * 
	 * @param - String
	 * 
	 * @date - 12-May-2021
	 * 
	 * @return - Not return any value
	 * 
	 * @Purpose - This method will be closing all the popups and clicking on the
	 * search Icon
	 */
	@When("I click on the {string} icon to perform a search")
	public void i_click_on_the_icon_to_perform_a_search(String string)
			throws IllegalAccessException, InterruptedException {

		// driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		HomePage homePage = new HomePage(driver);
		SearchPage searchPage = new SearchPage(driver);

		// click on I Understand button of the popup
		homePage.clickOnIUnderstandButton();

		// Click on the 'X' Icon button of the popup
		homePage.clickontheXIcon();

		// Click on the search Icon
		searchPage.clickOnSearchIcon();

	}

	/*
	 * @author - Ritesh Awasthi
	 * 
	 * @param - String
	 * 
	 * @date - 12-May-2021
	 * 
	 * @return - Not return any value
	 * 
	 * @Purpose - This method will be entering the accepted parameter as input to
	 * the text field
	 */
	@When("I enter the text {string}")
	public void i_enter_the_text(String inputString) {

		SearchPage searchPage = new SearchPage(driver);
		searchPage.enterTextInSearchField(inputString);

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
	 * @Purpose - This method is using for hitting the the enter key
	 */
	@When("I submit the search")
	public void i_submit_the_search() {
		SearchPage searchPage = new SearchPage(driver);

		// Calling the pressEnterKey()
		searchPage.pressEnterKey();

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
	 * @Purpose - This method will be validating the header of Search result page
	 */
	@Then("I am taken to the search results page")
	public void i_am_taken_to_the_search_results_page() {

		SearchPage searchPage = new SearchPage(driver);
		// Fetch and story the text value third articles
		String serachText = searchPage.getSearchResultPageHeader();

		// Validating the Header value of Search result page
		Assert.assertEquals(serachText,
				loadTestData.readFile("testdata.properties").getProperty("searchResultPageHeader"));

	}

	/*
	 * @author - Ritesh Awasthi
	 * 
	 * @param - int
	 * 
	 * @date - 12-May-2021
	 * 
	 * @return - Not return any value
	 * 
	 * @Purpose - This method will be validating the search result and it will make
	 * sure result is showing at least 1 search result
	 */
	@Then("I am presented with at least {int} search result")
	public void i_am_presented_with_at_least_search_result(Integer expectedCount) {

		SearchPage searchPage = new SearchPage(driver);
		int actualSearchResultCount = searchPage.getCountOfSearchResult();

		int expectedSearchResultCounts = expectedCount.intValue();

		// Validating the search result is showing at least 1 search result
		Assert.assertTrue(actualSearchResultCount >= expectedSearchResultCounts);

	}

}
