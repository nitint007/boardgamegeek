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
 * @author nitinthite
 *
 */
public class HomePage extends Setup {

	public HomePage() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
		
		assertHomePage();
	}
	
	public void goToUserGameCollection() {
		
		userName().click();
		
		userCollectionOption().click();
	}
	
	private void assertHomePage() {

		Assert.assertTrue(userName().isDisplayed(), "***** Home page not displayed.");
		System.out.println("User on Game Home page.");
	}
	
	// **************** WebElements from Home page to be used in the method/s above *************//
	private WebElement userName() {

		return wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(
				"//ul/li[8]/button/span[3]"))));
	}
	
	// To do if needed
	private WebElement userOptions() {

		return wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(
				"//div[1]/ul/li[8]/div"))));
	}
	
	private WebElement userCollectionOption() {

		return wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(
				"//a[@href='/collection/user/boardgamegk']"))));
	}


}
