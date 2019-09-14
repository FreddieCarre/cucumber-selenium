package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        driver = DriverFactory.getDriver();
        wait = new WebDriverWait(driver, 10);
    }

    protected WebElement waitAndClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

        return element;
    }

    protected WebElement findAndType(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);

        return element;
    }

    public String getTitle() {
        return driver.getTitle();
    }
}