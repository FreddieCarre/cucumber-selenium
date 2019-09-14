package com.google.pages;

import common.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultsPage extends BasePage {

    @FindBy(xpath = "//div[@class='ellip']//ancestor::a")
    private List<WebElement> results;

    public ResultsPage() {
        super();
    }

    public void clickResult(int number) {
        results.get(number - 1).click();
    }

    public String getResultHref(int index) {
        return results.get(index).getAttribute("href");
    }
}
