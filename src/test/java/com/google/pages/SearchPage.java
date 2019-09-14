package com.google.pages;

import common.BasePage;
import common.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BasePage {

    @FindBy(css = "input[title='Search']")
    private WebElement searchInput;

    @FindBy(css = "input[value = 'Google Search']")
    private WebElement searchButton;

    public SearchPage() {
        super();
        driver.get(System.getProperty("googleUrl"));
    }

    public static SearchPage open() {
        WebDriver driver = DriverFactory.getDriver();

        return PageFactory.initElements(driver, SearchPage.class);
    }

    public ResultsPage searchFor(String searchText) {
        findAndType(searchInput, searchText)
                .submit();

        return PageFactory.initElements(driver, ResultsPage.class);
    }
}
