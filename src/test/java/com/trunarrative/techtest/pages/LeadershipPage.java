package com.trunarrative.techtest.pages;

import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LeadershipPage extends BasePage {

    @FindBy(css = "div.stack-img-content")
    private List<WebElement> leadershipMembers;

    public String getRoleForName(String name) {

        String leaderXpath = String.format("//div[@class='stack-img-content'][div[img[@title='%s']]]", name);
        LeaderContainer container = new LeaderContainer(driver.findElement(By.xpath(leaderXpath)));

        if (!container.getName().getText().equals(name)) {
            throw new Error("Name does not match for leadership member: " + name);
        }
        return container.getRole().getText();
    }

    public int getNumberOfMembers() {
        return leadershipMembers.size();
    }

    private class LeaderContainer {

        private WebElement name;
        private WebElement role;

        LeaderContainer(WebElement container) {
            name = container.findElement(By.cssSelector("div.stack-img-content div.content h2"));
            role = container.findElement(By.cssSelector("div.stack-img-content div.content p"));
        }

        WebElement getName() {
            return name;
        }

        WebElement getRole() {
            return role;
        }
    }
}
