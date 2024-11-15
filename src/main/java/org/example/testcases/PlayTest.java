package org.example.testcases;

import org.example.pages.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlayTest extends BaseTest {
    @Test(priority = 1)
    public void verifyTitle() {
        Assert.assertEquals(page.title(), "My Store");
    }
    @Test(priority = 2)
    public void verifySearch() {
        search = hp.search("dress");
        page.keyboard().press("Enter");
        Assert.assertEquals(search.getSearchText().trim().toLowerCase(), "\"dress\"");
        Assert.assertEquals(page.locator("span.lighter").textContent().toLowerCase().trim(), "\"dress\"");
    }
}
