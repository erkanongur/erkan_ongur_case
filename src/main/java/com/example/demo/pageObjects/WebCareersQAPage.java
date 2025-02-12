package com.example.demo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class WebCareersQAPage extends WebPageObject{

    public WebCareersQAPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(linkText = "See all QA jobs")
    private WebElement seeAllQaJobsButton;

    //Click Methods

    public WebCareersOpenPositionsPage clickSeeAllQaJobsButton() {
        seeAllQaJobsButton.click();

        return new WebCareersOpenPositionsPage(webDriver);
    }
}
