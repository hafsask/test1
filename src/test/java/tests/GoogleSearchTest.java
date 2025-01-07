package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page_objects.GoogleSearchPage;
import utils.BrowserFactory;


public class GoogleSearchTest {

    public static WebDriver driver;
    static GoogleSearchPage searchWord = new GoogleSearchPage();

    @BeforeClass
    public static void setUp() throws Exception {

        if (driver == null || ((RemoteWebDriver) driver).getSessionId() == null) {

            driver = BrowserFactory.getDriver("configFile.properties");

            PageFactory.initElements(driver, searchWord); // Initialize WebElements

        }
    }

    @Test(priority = 1)
    public void testPageTitle() {

        driver.get("https://google.com");
        driver.manage().window().maximize();
        Assert.assertTrue(driver.getTitle().contains("Google"), "Google homepage title is incorrect.");

    }

    @Test(priority = 2)
    public void testGoogleSearch() {

        searchWord.Search("testNG");
        Assert.assertTrue(driver.getTitle().contains("testNG"), "The results does not contain the keyword wanted");

    }

    @Test(priority = 3)
    public void testPageLoadPerformance() {

        Long startTime = System.currentTimeMillis();
        driver.navigate().refresh();
        Long endTime = System.currentTimeMillis();
        Long LoadTime = endTime - startTime;
        Assert.assertTrue(LoadTime < 5000, "The page Loading time exceeds the acceptable time");
    }

    @AfterClass
    public static void tearDown() throws Exception {
        if (driver != null) {
            driver.quit();
            driver = null;
        }

    }
}
