package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitUtils;

import static modules.Hooks.driver;

public class GoogleSearchPage {

    @FindBy(id = "L2AGLb")
    private static WebElement googleAlert;

	@FindBy(xpath = "//textarea[@id='APjFqb']")
	private static WebElement searchBar;

    @FindBy(name = "btnK")
    private static WebElement searchButton;

 public static void Search (String keyword) {
     try {

             WaitUtils.waitForElementToBeClickable(driver, googleAlert, 10);
             googleAlert.click();

     } catch (Exception e) {

     }
     WaitUtils.createWait(driver,30);
     searchBar.clear();
     WaitUtils.waitForVisibility (driver,searchBar,30);
     WaitUtils.waitForElementToBeClickable(driver,searchBar,30);
     searchBar.sendKeys(keyword);
     WaitUtils.waitForElementToBeClickable(driver,searchButton,30);
     WaitUtils.createWait(driver,30);
     searchButton.click();
     WaitUtils.createWait(driver,100);
 }

}
