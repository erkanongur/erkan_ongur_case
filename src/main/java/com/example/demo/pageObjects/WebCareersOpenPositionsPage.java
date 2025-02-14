package com.example.demo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class WebCareersOpenPositionsPage extends WebPageObject{

    public WebCareersOpenPositionsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(css = ".istanbul-turkiye")
    private WebElement location;

    @FindBy(css = ".qualityassurance")
    private WebElement department;

    @FindBy(css = ".istanbul-turkiye.qualityassurance")
    private List<WebElement> positionListElements;

    @FindBy(css = ".istanbul-turkiye.qualityassurance")
    private WebElement firstPositionListElement;

    @FindBy(className = "position-title")
    private List<WebElement> positionTitleList;

    @FindBy(className = "position-title")
    private WebElement firstPositionTitle;

    @FindBy(className = "position-department")
    private List<WebElement> positionDepartmentList;

    @FindBy(className = "position-department")
    private WebElement firstPositionDepartment;

    @FindBy(className = "position-location")
    private List<WebElement> positionLocationList;

    @FindBy(className = "position-location")
    private WebElement firstPositionLocation;

    @FindBy(linkText = "View Role")
    private WebElement viewRoleButton;

    @FindBy(className = "position-list-item")
    private WebElement positionListItem;

    //Click Methods

    public void clickViewRoleButton() {
        scrollDownInPage();
        waitUntilElementIsVisible(positionListItem);
        hoverOnElement(positionListItem);
        waitUntilElementIsVisible(viewRoleButton);
        viewRoleButton.click();
    }

    //Select Methods

    public WebCareersOpenPositionsPage clickLocation()
    {
        waitUntilElementIsVisible(location);
        location.click();

        return this;
    }

    public WebCareersOpenPositionsPage clickDepartment()
    {
        waitUntilElementIsVisible(department);
        department.click();

        return this;
    }

    //Get Methods

    public List<String> getPositionListAsString()
    {
        waitUntilElementIsVisible(firstPositionListElement);
        return positionListElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getPositionTitleListAsString()
    {
        waitUntilElementIsVisible(firstPositionTitle);
        return positionTitleList.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getPositionDepartmentListAsString()
    {
        waitUntilElementIsVisible(firstPositionDepartment);
        return positionDepartmentList.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getPositionLocationListAsString()
    {
        waitUntilElementIsVisible(firstPositionLocation);
        return positionLocationList.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
