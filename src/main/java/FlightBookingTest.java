import common.Helper;
import pageObjects.ClearTripHome;

import org.testng.annotations.Test;

public class FlightBookingTest {

	Helper helper = new Helper();
	ClearTripHome clearTripPageObject = new ClearTripHome();

	@Test
	public void testThatResultsAppearForAOneWayJourney() {

		clearTripPageObject.openSite("https://www.cleartrip.com/");
		helper.waitFor(2000);

		clearTripPageObject.clickOneWay();

		clearTripPageObject.selectFrom("Bangalore");
		// wait for the auto complete options to appear for the origin
		helper.waitFor(2000);
		clearTripPageObject.clickOriginOption();

		clearTripPageObject.selectTo("Delhi");
		// wait for the auto complete options to appear for the destination
		helper.waitFor(2000);
		// select the first item from the destination auto complete list
		clearTripPageObject.clickDestinationOption();

		clearTripPageObject.clickDate();

		// all fields filled in. Now click on search
		clearTripPageObject.clickSearchBtn();

		helper.waitFor(5000);
		// verify that result appears for the provided journey search
		clearTripPageObject.validateSearchSummaryPresent();

		// close the browser
		clearTripPageObject.quitDriver();

	}
}
