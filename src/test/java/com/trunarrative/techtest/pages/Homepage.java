package com.trunarrative.techtest.pages;

import common.BasePage;
import common.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends BasePage {

    @FindBy(css = "h4.bigger")
    private WebElement strapline;

    public Homepage() {
        super();
    }

    public static Homepage isOpen() {
        WebDriver driver = DriverFactory.getDriver();
        return PageFactory.initElements(driver, Homepage.class);
    }

    public String straplineIsDisplayed() {
        return strapline.getText();
    }

    public void clickMenu(String menu) {
        String menuXpath = String.format("//a[text() = '%s']", menu);
        WebElement menuItem = driver.findElement(By.xpath(menuXpath));
        waitAndClick(menuItem);
    }

    public <T> T clickOption(String option, Class<T> targetPageClass) {
        String optionXpath = String.format("//a[text() = '%s']", option);
        driver.findElement(By.xpath(optionXpath)).click();

        return PageFactory.initElements(driver, targetPageClass);
    }
}
