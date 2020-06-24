/**
 * 
 */
package base;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author nitinthite
 *
 */
public class Setup {

	// Webdriver instance for easy access
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Properties properties;

	// Class constructor for initialising objects
	public Setup() throws FileNotFoundException, IOException {
		BufferedReader reader;
		try {
			String configFilePath = "./src/test/resources/testdataresources/Data.properties";
			reader = new BufferedReader(new FileReader(configFilePath));
			properties = new Properties();
			properties.load(reader);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
			throw new RuntimeException("File Data.properties not found at given path.");
		} catch (IOException ioe) {
			ioe.printStackTrace();
			throw new RuntimeException("Issue on reading file.");
		}
	}

	/*
	 * Method details for configuration for chrome browser
	 */
	public WebDriver WebSetUp() {

		if (driver == null) {

			System.out.println("Setup method call");

			// please uncomment the line below if you are running the suite on Windows OS
			// System.setProperty("Webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");

			// Initialising chrome driver
			driver = new ChromeDriver();
//			driver = new FirefoxDriver();
		}

		// To open the URL in browser window
		driver.get(properties.getProperty("url"));

		// Describing default wait time for each element in tests
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		// To maximise the browser
		driver.manage().window().maximize();

		// Deleting all cookies
		driver.manage().deleteAllCookies();

		// Initialising Explicite wait object
		wait = new WebDriverWait(driver, 30);

		return driver;
	}

}
