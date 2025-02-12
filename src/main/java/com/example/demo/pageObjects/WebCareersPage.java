package com.example.demo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class WebCareersPage extends WebPageObject {

    WebCareersPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(css = ".glide__slide--active")
    private WebElement firstLocation;

    @FindBy(linkText = "Find your dream job")
    private WebElement findJobButton;

    @FindBy(id = "career-find-our-calling")
    private WebElement teamsSection;

    @FindBy(xpath = "//h2[text()='Life at Insider']")
    private WebElement lifeAtInsiderTitle;

    //isDisplayed Buttons

    public Boolean isDisplayedFindJobButton() {
        return findJobButton.isDisplayed();
    }

    public Boolean isDisplayedFirstLocation() {
        return firstLocation.isDisplayed();
    }

    public Boolean isDisplayedLifeAtInsiderTitle() {
        return lifeAtInsiderTitle.isDisplayed();
    }

    //Get Text Button

    public String getTeamsSectionText() {
        return teamsSection.getText();
    }
}
