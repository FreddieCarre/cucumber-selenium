package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage() {
        driver = DriverFactory.getDriver();
        wait = new WebDriverWait(driver, 10);
    }

    protected WebElement waitAndClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

        return element;
    }

    protected WebElement findAndType(WebElement element, String text) {
        waitForVisibility(element).sendKeys(text);

        return element;
    }

    protected WebElement waitForVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement hover(WebElement element) {
        new Actions(driver).moveToElement(element)
                .build().perform();

        return element;
    }

    public String getTitle() {
        return driver.getTitle();
    }
}