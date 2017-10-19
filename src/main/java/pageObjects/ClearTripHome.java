package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import common.WebDriverInitialize;

public class ClearTripHome {

	private WebDriverInitialize driverInitialize;
	private WebDriver driver;

	public ClearTripHome() {
		driverInitialize = new WebDriverInitialize();
		driver = driverInitialize.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(tagName = "h1")
	private WebElement heading;

	@FindBy(linkText = "Your trips")
	private WebElement yourTrips;

	@FindBy(id = "SignIn")
	private WebElement signIn;

	@FindBy(id = "signInButton")
	private WebElement signInButton;

	@FindBy(id = "errors1")
	private WebElement errors;

	@FindBy(id = "OneWay")
	private WebElement oneWay;

	@FindBy(id = "FromTag")
	private WebElement fromTag;

	@FindBy(id = "ToTag")
	private WebElement toTag;

	@FindBy(xpath = "//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[3]/td[7]/a")
	private WebElement date;

	@FindBy(id = "SearchBtn")
	private WebElement searchBtn;

	@FindBy(linkText = "Hotels")
	private WebElement hotelLink;

	@FindBy(id = "Tags")
	private WebElement localityTextBox;

	@FindBy(id = "SearchHotelsButton")
	private WebElement searchButton;

	@FindBy(id = "travellersOnhome")
	private WebElement travellerSelection;

	public void clickHotelLink() {
		hotelLink.click();
	}

	public void selectLocality(String place) {
		localityTextBox.sendKeys(place);
		heading.click();
	}

	public void selectRoom(String room) {
		new Select(travellerSelection).selectByVisibleText(room);
		heading.click();
	}

	public void clickSearchButton() {
		searchButton.click();
	}

	public void clickOneWay() {
		oneWay.click();
	}

	public void selectFrom(String from) {
		fromTag.clear();
		fromTag.sendKeys(from);
	}

	public void clickOriginOption() {
		List<WebElement> originOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
		originOptions.get(0).click();
	}

	public void selectTo(String to) {
		toTag.clear();
		toTag.sendKeys(to);
	}

	public void clickDestinationOption() {
		List<WebElement> destinationOptions = driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
		destinationOptions.get(0).click();
	}

	public void clickDate() {
		date.click();
	}

	public void clickSearchBtn() {
		searchBtn.click();
	}

	public void validateSearchSummaryPresent() {
		Assert.assertTrue(isElementPresent(By.className("searchSummary")));
	}

	public void openSite(String url) {
		driver.get(url);
	}

	public void quitDriver() {
		driver.quit();
	}

	public void clickYourTrips() {
		yourTrips.click();
	}

	public void clickSignIn() {
		signIn.click();
	}

	public void switchtoFrame() {
		driver.switchTo().frame("modal_window");
	}

	public void clickSignInBtn() {
		signInButton.click();
	}

	public String getTextOfErrors() {
		return errors.getText();
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}