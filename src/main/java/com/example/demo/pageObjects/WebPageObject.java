package com.example.demo.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;
import java.time.Duration;
import java.util.ArrayList;

@Component
public class WebPageObject {

    protected WebDriver webDriver;

    WebPageObject(WebDriver webDriver)
    {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(linkText = "Accept All")
    private WebElement acceptAllButton;


    //Click Methods

    public <T extends WebPageObject> T clickAcceptAllButton(T page)
    {
        acceptAllButton.click();

        return page;
    }

    //Other Metods

    public void waitUntilElementIsVisible(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void scrollDownInPage()
    {
        ((JavascriptExecutor) webDriver).executeScript("window.scrollBy(0, 500);");
    }

    public void hoverOnElement(WebElement element)
    {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(element).perform();
    }

    public void tabChange(int index)
    {
        webDriver.switchTo().window(new ArrayList<>(webDriver.getWindowHandles()).get(index));
    }
}
