package com.example.demo.client;

import com.example.demo.pageObjects.WebPageObject;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class WebClient {

    @Autowired
    public WebDriver webDriver;

    public <T extends WebPageObject> T goToPage(String url, T page)
    {
        webDriver.get(url);

        return page;
    }
}
