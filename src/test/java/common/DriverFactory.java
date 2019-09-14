package common;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            setDriver();
        }

        return driver;
    }

    static void setDriver() {

        boolean local;
        local = (System.getProperty("remote") == null);

        if (local) {
            setLocalDriver();
        } else {
            setRemoteDriver();
        }
    }

    private static void setRemoteDriver() {
        String browser = System.getProperty("browser");
        if (browser == null) browser = "chrome";

        DesiredCapabilities capabilities;
        switch (Browsers.valueOf(browser.toUpperCase())) {
            case CHROME:
                capabilities = DesiredCapabilities.chrome();
                capabilities.setBrowserName("chrome");
                capabilities.setPlatform(Platform.LINUX);
                break;
            case FIREFOX:
                capabilities = DesiredCapabilities.firefox();
                capabilities.setBrowserName("firefox");
                capabilities.setPlatform(Platform.LINUX);
                break;
            default:
                capabilities = DesiredCapabilities.chrome();
                capabilities.setBrowserName("chrome");
                capabilities.setPlatform(Platform.LINUX);
                break;
        }
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private static void setLocalDriver() {
        String browser = System.getProperty("browser");

        if (browser == null) browser = "chrome";

        switch (Browsers.valueOf(browser.toUpperCase())) {
            case CHROME:
                driver = createChromeDriver();
                break;
            case FIREFOX:
                driver = createFirefoxDriver();
                break;
            default:
                driver = createChromeDriver();
                break;
        }
    }

    private static ChromeDriver createChromeDriver() {
        return new ChromeDriver();
    }

    private static FirefoxDriver createFirefoxDriver() {
        FirefoxOptions options = new FirefoxOptions()
                .setProfile(new FirefoxProfile());
        return new FirefoxDriver(options);
    }

    private enum Browsers {
        CHROME,
        FIREFOX
    }
}
