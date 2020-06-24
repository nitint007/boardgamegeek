/**
 * 
 */
package pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import base.Setup;

/**
 * @author nitinthite Class contains webElements and respective operations
 *         related to LandingPage page
 */
public class LandingPage extends Setup {

	public LandingPage() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub

		assertLandingPage();
	}

	public void performLogin() {

		signinButton().click();

		Assert.assertTrue(loginPopup().isDisplayed(), "***** Login popup not displayed");

		loginField().clear();
		loginField().sendKeys(properties.getProperty("username"));
		passwordField().sendKeys(properties.getProperty("password"));
		passwordField().submit();
	}

	private void assertLandingPage() {

		Assert.assertTrue(signinButton().isDisplayed(), "***** Landing page not displayed.");
	}

	// **************** WebElements from Landing page to be used in the method/s
	// above *************//

	private WebElement signinButton() {

		return wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(
				"//li[@class='global-header-nav-session global-header-nav-primary-separated ng-scope']//button"))));
	}

	private WebElement loginPopup() {

		return wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//div[@class='modal-dialog modal-md']"))));
	}

	private WebElement loginField() {

		return wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("inputUsername"))));
	}

	private WebElement passwordField() {

		return wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("inputPassword"))));
	}// ul/li[8]/button/span[3]

}
