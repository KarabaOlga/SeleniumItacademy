package by.htp.itacademy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends Page {

	private static final String URL = "http://www.it-academy.by/";
	private static final String MAIN_MENU_ELEMENTS_XPATH = "//*[@id='main-menu']/div[1]/ul/li[2]/ul/li/a | //*[@id='main-menu']/div[1]/ul/li[2]/ul/li/ul/li/a";
	private static final String ATTRIBUTE_TEXT = "text";
	private static final String MARKETING_XPATH = "//a[contains(text(), 'Маркетинг')]";

	public MainPage(WebDriver driver) {
		super(driver);
	}

	public void open() {
		getDriver().get(URL);
	}

	public void printElementMainMenu() {
		List<WebElement> elementsMenu = driver.findElements(By.xpath(MAIN_MENU_ELEMENTS_XPATH));
		for (WebElement webElement : elementsMenu) {
			System.out.println(webElement.getAttribute(ATTRIBUTE_TEXT));
		}
	}

	public void goToMarketing() {
		List<WebElement> elementsMenu = driver.findElements(By.xpath(MARKETING_XPATH));
		elementsMenu.get(1).click();
	}

}