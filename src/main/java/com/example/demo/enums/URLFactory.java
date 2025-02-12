package com.example.demo.enums;

import org.springframework.lang.NonNull;

public enum URLFactory {
    BASE_URL("https://useinsider.com/"),

    CAREERS_URL(BASE_URL,"careers/"),

    CAREERS_QA_URL(CAREERS_URL, "quality-assurance/"),

    CAREERS_OPEN_POSITIONS_URL(CAREERS_URL, "open-positions/");

    public final @NonNull String pageUrl;

    URLFactory(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    URLFactory(URLFactory baseUrl, String pageUrl) {
        this.pageUrl = baseUrl.pageUrl + pageUrl;
    }
}
