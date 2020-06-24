/**
 * 
 */
package testcases;

import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeGroups;
import base.Setup;
import pages.GameCollectionPage;
import pages.GameDetailsPage;
import pages.HomePage;
import pages.LandingPage;
/**
 * @author nitinthite
 *
 */
public class UATSteps extends Setup {
	
	LandingPage landingpage;
	HomePage homepage;
	GameCollectionPage gamecollection;
	GameDetailsPage gamedetails;

	// Class constructor to initialising same properties pointing to parent constructor
	public UATSteps() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	//################# Initialising webdriver before a set of tests ###################
	
	@BeforeGroups("UAT")
	public void beforeGroupAllSteps() throws FileNotFoundException, IOException {
		System.out.println("Inside @Before groups");
		WebSetUp();
		
		landingpage = new LandingPage();
		landingpage.performLogin();
	}
	
	//################# Test steps ###################

	@Test(priority = 1, groups = "UAT")
	public void openGameCollection() throws Throwable {

		System.out.println("In Given");
		
		homepage = new HomePage();
		homepage.goToUserGameCollection();
	}
	
	@Test(priority = 2, groups = "UAT")
	public void gotToGamePage() throws Throwable {

		System.out.println("In When");
		
		gamecollection = new GameCollectionPage();
		gamecollection.selectRandomGame();
	}
	
	@Test(priority = 3, groups = "UAT")
	public void VerifyGameAPI() throws Throwable {

		System.out.println("In Then");
		
//		gamedetails = new GameDetailsPage();
//		gamedetails.lookForPoll();
		
		gamecollection = new GameCollectionPage();
		gamecollection.verifyResponse();
		
//		gamedetails.closePollPanel();
	}

	@Test(priority = 4, groups = "UAT")
	public void verifyLanguageDependencelevel() throws Throwable {

		gamedetails = new GameDetailsPage();
		gamedetails.getGameLanguageDependenceVotes();

		System.out.println("In And");
	}
	
	//################# Closing driver session post suite execution ###################
	
	@AfterSuite
	public void closeDriverInstance() {

		// To close webdriver session
		driver.quit();
	}

}
