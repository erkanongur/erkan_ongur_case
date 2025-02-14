package com.example.demo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class WebMainPage extends WebPageObject {

    public WebMainPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(linkText = "Company")
    private WebElement companyTab;

    @FindBy(linkText= "Careers")
    private WebElement careersButton;

    @FindBy(linkText= "Login")
    private WebElement loginButton;

    @FindBy(linkText= "Get a Demo")
    private WebElement demoButton;

    @FindBy(linkText= "Platform Tour")
    private WebElement platformTourButton;

    //Click Metods

    public WebMainPage clickCompanyTab() {
        companyTab.click();

        return this;
    }

    public WebCareersPage clickCareersButton() {
        careersButton.click();

        return new WebCareersPage(webDriver);
    }

    //isDisplayed Metods

    public Boolean isDisplayedLoginButton() {
        waitUntilElementIsVisible(loginButton);
        return loginButton.isDisplayed();
    }

    public Boolean isDisplayedDemoButton() {
        waitUntilElementIsVisible(demoButton);
        return demoButton.isDisplayed();
    }

    public Boolean isDisplayedPlatformTourButton() {
        waitUntilElementIsVisible(platformTourButton);
        return platformTourButton.isDisplayed();
    }
}
