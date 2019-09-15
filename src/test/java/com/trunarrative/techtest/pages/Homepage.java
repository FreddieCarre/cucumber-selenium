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
        String menuXpath = String.format("//a[text() = '%s']/parent::li", menu);
        WebElement menuItem = driver.findElement(By.xpath(menuXpath));
        WebElement subMenuItems = hover(menuItem)
                .findElement(By.xpath("//li/a"));
        waitForVisibility(subMenuItems);
    }

    public <T> T clickOption(String option, Class<T> targetPageClass) {
        String optionXpath = String.format("//a[text() = '%s']", option);
        WebElement optionEle = driver.findElement(By.xpath(optionXpath));
        waitAndClick(optionEle);

        return PageFactory.initElements(driver, targetPageClass);
    }
}
