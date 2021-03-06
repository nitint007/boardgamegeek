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
public class GameDetailsPage extends Setup {

	public GameDetailsPage() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void getGameLanguageDependenceVotes() {
		
		if (gameLanguageDependence().isDisplayed()) {
			
			String level = gameLanguageDependence().getText();
			System.out.println("Game Language Dependence Level is :"+level);
		}
		
		Assert.assertTrue(false, gameLanguageDependence().getText());
	}
	
	public void lookForPoll() {
		
		gameLanguageDependence().click();
	}
	
	public void closePollPanel(){
		
		closePollPanelButton().click();
	}

	// **************** WebElements from User Collection page to be used in the
	// method/s above *************//
	private WebElement gameLanguageDependence() {

		return driver.findElement(By.xpath(
				"//div[2]/ng-include/div//ui-view//div/overview-module/description-module//div[2]//div[3]/div[2]/div[1]/div/ul/li/div[2]//span"));
	}
	
	private WebElement closePollPanelButton() {

		return wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(
				"//div[2]//div[2]/button[2]"))));
	}

}
