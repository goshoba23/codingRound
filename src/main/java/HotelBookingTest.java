import common.Helper;
import pageObjects.ClearTripHome;

import org.testng.annotations.Test;

public class HotelBookingTest {

	Helper helper = new Helper();
	ClearTripHome clearTripPageObject = new ClearTripHome();

	@Test
	public void shouldBeAbleToSearchForHotels() {
		clearTripPageObject.openSite("https://www.cleartrip.com/");
		helper.waitFor(2000);
		clearTripPageObject.clickHotelLink();
		clearTripPageObject.selectLocality("Indiranagar, Bangalore");
		
		clearTripPageObject.selectRoom("1 room, 2 adults");
		helper.waitFor(2000);
		clearTripPageObject.clickSearchButton();
		clearTripPageObject.quitDriver();
	}
}
