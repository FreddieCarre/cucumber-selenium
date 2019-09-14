package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static final WebDriver driver = setDriver();

    public static WebDriver getDriver() {
        if (driver == null) {
            setDriver();
        }

        return driver;
    }

    static WebDriver setDriver() {
        String browser = System.getProperty("browser");

        if (browser == null) browser = "chrome";

        switch (Browsers.valueOf(browser.toUpperCase())) {
            case CHROME:
                return createChromeDriver();
            case FIREFOX:
                return createFirefoxDriver();
            default:
                return createChromeDriver();
        }
    }

    private static ChromeDriver createChromeDriver() {
        return new ChromeDriver();
    }

    private static FirefoxDriver createFirefoxDriver() {
        return new FirefoxDriver();
    }

    private enum Browsers {
        CHROME,
        FIREFOX
    }
}
