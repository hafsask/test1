package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserFactory {
    private static WebDriver driver;

    public static WebDriver getDriver(String configFile) {
        if (driver == null || ((RemoteWebDriver) driver).getSessionId() == null) {
            // Load properties from the specified configuration file
            PropertiesFile.loadProperties(configFile);
            String browser = PropertiesFile.getProperty("browser");

            if (driver == null) {
                switch (browser.toLowerCase()) {
                    case "chrome":
                        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.addArguments("--start-maximized");
                        chromeOptions.addArguments("--incognito");
                        driver = new ChromeDriver(chromeOptions);
                        break;

                    case "firefox":
                        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        firefoxOptions.addArguments("--private");
                        firefoxOptions.addArguments("--start-maximized");
                        firefoxOptions.addArguments("--incognito");
                        driver = new FirefoxDriver(firefoxOptions);
                        break;

                    case "edge":
                        System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe");
                        EdgeOptions edgeOptions = new EdgeOptions();
                        edgeOptions.addArguments("--start-maximized");
                        edgeOptions.addArguments("--incognito");
                        driver = new EdgeDriver(edgeOptions);
                        break;

                    default:
                        throw new IllegalArgumentException("Browser not supported: " + browser);
                }

            }
        }
            return driver;
        }
    }


