/**
 * 
 */
package testcases;

import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import base.Setup;
/**
 * @author nitinthite
 *
 */
public class UATSteps extends Setup {

	// Class constructor to initialising same properties pointing to parent constructor
	public UATSteps() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeGroups("UAT")
	public void beforeAllScenarios() {
		System.out.println("Inside Hooks @Before");
		WebSetUp();
	}

	@AfterSuite
	public void closeDriverInstance() {

		// To close webdriver session
		driver.quit();
	}

	@Test(priority = 1, groups = "UAT")
	public void open_the_game_collection_of_a_user() throws Throwable {

		System.out.println("In Given");
	}
	
	@Test(priority = 2, groups = "UAT")
	public void go_to_the_page_of_one_of_the_games() throws Throwable {

		System.out.println("In When");
	}
	
	@Test(priority = 3, groups = "UAT")
	public void check_the_information_about_the_game() throws Throwable {

		System.out.println("In Then");
	}

	@Test(priority = 4, groups = "UAT")
	public void verify_that_the_most_voted_Language_Dependence_level() throws Throwable {

		System.out.println("In And");
	}

}
