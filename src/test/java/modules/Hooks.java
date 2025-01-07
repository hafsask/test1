package modules;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import page_objects.GoogleSearchPage;
import utils.BrowserFactory;
import utils.ScreenshotUtil;

public class Hooks {
    public static WebDriver driver;
    static GoogleSearchPage searchWord = new GoogleSearchPage();

    @BeforeAll
    public static void setUp() throws Exception {
        if (driver == null || ((RemoteWebDriver) driver).getSessionId() == null) {

            driver = BrowserFactory.getDriver("configFile.properties");

            PageFactory.initElements(driver, searchWord); // Initialize WebElements

        }

    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenshotUtil.takeScreenshot(driver, scenario.getName());
        }
    }

    @AfterAll
    public static void tearDown() throws Exception {
        if (driver != null) {
            driver.quit();
            driver = null;
        }

    }
}