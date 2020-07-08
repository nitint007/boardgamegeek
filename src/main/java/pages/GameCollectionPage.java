/**
 * 
 */
package pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Random;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import api.restapi.SendRequest;
import base.Setup;

/**
 * @author nitinthite
 *
 */
public class GameCollectionPage extends Setup {
	
	String URI, baseURL = properties.getProperty("url");
	
	public GameCollectionPage() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
		
		assertGameCollectionPage();
	}
	
	public void selectRandomGame() {
		
		getNumberOfGames();
		goToRandomGame();
	}
	
	// Utilised REST Assured framework to verify API response
	public void verifyResponse() {
		
		SendRequest request = new SendRequest();
		try {
			System.out.println("API response :" +request.getResponse(driver.getCurrentUrl()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String goToRandomGame() {
		
		Random rand = new Random();
		int x = rand.nextInt(getNumberOfGames());
		System.out.println("Random row : " +x);
		
		if (x == 1) {
			x = x+1;
			System.out.println("Updated Random row : " +x);
			
			URI = baseURL+desiredGameURL(x).getText();
			System.out.println("URI : " +URI);

			desiredGame(x).click();
		}
		else {
			URI = baseURL+desiredGameURL(x).getText();
			System.out.println("URI : " +URI);

			desiredGame(x).click();
		}
		
		return URI;
	}
	
	private int getNumberOfGames() {
		
		//No.of rows 
		List  rows = driver.findElements(By.xpath("//table[@id='collectionitems']//tr"));
        System.out.println("No of rows are : " +rows.size());
		return rows.size(); 
	}
	
	private void assertGameCollectionPage() {

		Assert.assertTrue(collectionDiv().isDisplayed(), "***** Collection page not displayed.");
		System.out.println("User on Game collections page.");
	}
	
	// **************** WebElements from User Collection page to be used in the method/s above *************//
		private WebElement collectionDiv() {

			return wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(
					"//ul/li[8]/button/span[3]"))));
		}
		
		// To be used when needed
		private WebElement collectiontable() {

			return wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(
					"collectionitems"))));
		}
		
		private WebElement desiredGame(int gameNumber) {

			return wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(
					"//*[@id='collectionitems']//tbody/tr["+gameNumber+"]/td[1]/div[2]/a"))));
		}
		
		private WebElement desiredGameURL(int gameNumber) {

			return wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(
					"//*[@id='collectionitems']//tbody/tr["+gameNumber+"]/td[1]/div[2]/a"))));
		}

}
