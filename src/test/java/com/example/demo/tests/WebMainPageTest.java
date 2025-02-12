package com.example.demo.tests;

import com.example.demo.client.WebClient;
import com.example.demo.pageObjects.WebCareersPage;
import com.example.demo.pageObjects.WebMainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.demo.enums.URLFactory.BASE_URL;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@SpringBootTest
public class WebMainPageTest extends WebClient {

    private WebMainPage webMainPage;

    @Test
    public void testMainPageLoaded() {
        webMainPage = goToPage(BASE_URL.pageUrl, new WebMainPage(webDriver));

        Assertions.assertAll(
                () -> assertTrue(webMainPage.isDisplayedLoginButton()),
                () -> assertTrue(webMainPage.isDisplayedDemoButton()),
                () -> assertTrue(webMainPage.isDisplayedPlatformTourButton())
        );
    }

    @Test
    public void testDirectToCareersPage() {
        webMainPage = goToPage(BASE_URL.pageUrl, new WebMainPage(webDriver));

        WebCareersPage webCareersPage = webMainPage
                .clickCompanyTab()
                .clickCareersButton();

        Assertions.assertAll(
                () -> assertTrue(webCareersPage.isDisplayedFindJobButton()),
                () -> assertTrue(webCareersPage.isDisplayedFirstLocation()),
                () -> assertTrue(webCareersPage.isDisplayedLifeAtInsiderTitle()),
                () -> assertNotNull(webCareersPage.getTeamsSectionText())
        );
    }
}
