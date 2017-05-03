package by.htp.itacademy;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SmokeTest {

	private static final String DRIVER_NAME = "webdriver.gecko.driver";
	private static final String DRIVER_LOCATION = "/home/dummy/selenium/geckodriver";

	private WebDriver driver;

	@Before
	public void initBrowser() {
		System.setProperty(DRIVER_NAME, DRIVER_LOCATION);
		driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}

	@Test
	public void testItAcademy() {
		// Open main page
		MainPage mainPage = new MainPage(driver);
		mainPage.open();
		// print menu
		mainPage.printElementMainMenu();
		// go to marketing page
		mainPage.goToMarketing();
		// Check page title
		Assert.assertTrue(driver.getTitle().startsWith("Маркетинг"));
	}

	@After
	public void destroyBrowser() {
		driver.quit();
	}
}