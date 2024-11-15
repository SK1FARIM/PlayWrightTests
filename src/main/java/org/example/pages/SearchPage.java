package org.example.pages;

import com.microsoft.playwright.Page;

public class SearchPage {
    Page page;

    SearchPage(Page page) {
        this.page=page;
    }

    private String searchTxt="span.lighter";

    public String getSearchText() {
        return page.locator(searchTxt).textContent().toLowerCase().trim();
    }
}
