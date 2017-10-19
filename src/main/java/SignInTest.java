import common.Helper;
import pageObjects.ClearTripHome;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest {

	Helper helper = new Helper();
	ClearTripHome clearTripPageObject = new ClearTripHome();

	@Test
	public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
		clearTripPageObject.openSite("https://www.cleartrip.com/");
		helper.waitFor(2000);
		clearTripPageObject.clickYourTrips();
		clearTripPageObject.clickSignIn();
		clearTripPageObject.switchtoFrame();
		clearTripPageObject.clickSignInBtn();
		String errors = clearTripPageObject.getTextOfErrors();
		Assert.assertTrue(errors.contains("There were errors in your submission"));
		clearTripPageObject.quitDriver();
	}
}
