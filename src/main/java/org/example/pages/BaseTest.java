package org.example.pages;

import com.microsoft.playwright.Page;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected Page page;
    protected HomePage hp;
    protected SearchPage search;
    PlaywrightFactory play;
    @BeforeClass
    @Parameters({ "appURL", "browserType" })
    public void setUp(String appURL, String browserType) {
        play = new PlaywrightFactory();
        page = play.getPage(appURL, browserType);
        hp = new HomePage(page);
    }
    @AfterClass
    public void tearDown() {
        page.context().browser().close();
    }
}
