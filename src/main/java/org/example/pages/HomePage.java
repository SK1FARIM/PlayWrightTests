package org.example.pages;

import com.microsoft.playwright.Page;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class HomePage {
    Page page;
    private String search="input#search_query_top";
    public HomePage(Page page) {
        this.page=page;
    }
    public SearchPage search(String searchTxt) {
        page.locator(search).fill(searchTxt);
        return new SearchPage(page);
    }
}
