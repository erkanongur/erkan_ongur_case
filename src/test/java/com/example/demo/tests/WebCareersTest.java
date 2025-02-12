package com.example.demo.tests;

import com.example.demo.client.WebClient;
import com.example.demo.pageObjects.WebCareersOpenPositionsPage;
import com.example.demo.pageObjects.WebCareersQAPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.demo.enums.Constants.WebCareersOpenPositionsPage.*;
import static com.example.demo.enums.URLFactory.CAREERS_OPEN_POSITIONS_URL;
import static com.example.demo.enums.URLFactory.CAREERS_QA_URL;
import static org.junit.Assert.assertTrue;

@SpringBootTest
public class WebCareersTest extends WebClient {

    @Test
    public void testCareersFilterPosition() {
        WebCareersQAPage webCareersQAPage = goToPage(CAREERS_QA_URL.pageUrl, new WebCareersQAPage(webDriver));

        WebCareersOpenPositionsPage webCareersOpenPositionsPage = webCareersQAPage
                .clickAcceptAllButton(webCareersQAPage)
                .clickSeeAllQaJobsButton();

        webCareersOpenPositionsPage
                .clickLocation()
                .clickDepartment();

        Assertions.assertAll(
                () -> assertTrue("List contains empty elements", webCareersOpenPositionsPage.getPositionListAsString().stream().allMatch(position -> !position.trim().isEmpty())),
                () -> assertTrue("List contains empty elements", webCareersOpenPositionsPage.getPositionTitleListAsString().stream().allMatch(positionTitle -> positionTitle.contains(DEPARTMENT_QA))),
                () -> assertTrue("List contains empty elements", webCareersOpenPositionsPage.getPositionDepartmentListAsString().stream().allMatch(department -> department.contains(DEPARTMENT_QA))),
                () -> assertTrue("List contains empty elements", webCareersOpenPositionsPage.getPositionLocationListAsString().stream().allMatch(location -> location.contains(CITY)))
        );
    }

    @Test
    public void testCareersViewPosition() {
        WebCareersOpenPositionsPage webCareersOpenPositionsPage = goToPage(CAREERS_OPEN_POSITIONS_URL.pageUrl, new WebCareersOpenPositionsPage(webDriver));

        webCareersOpenPositionsPage
                .clickAcceptAllButton(webCareersOpenPositionsPage)
                .clickViewRoleButton();

        webCareersOpenPositionsPage.tabChange(1);

        assertTrue(webDriver.getCurrentUrl().contains(JOBS_LEVER_URL));
    }
}
