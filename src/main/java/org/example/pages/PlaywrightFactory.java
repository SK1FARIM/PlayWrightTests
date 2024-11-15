package org.example.pages;

import com.microsoft.playwright.*;
import org.testng.annotations.Parameters;

public class PlaywrightFactory {
    Playwright playwright;
    protected Page page;
    Browser browser;
    BrowserContext browserContext;
    @Parameters({"appURL", "browserType"})
    public Page getPage(String appURL, String browserType) {
        playwright = Playwright.create();
        switch (browserType) {
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;
            case "safari":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;
            default:
                break;
        }
        browserContext = browser.newContext();
        page = browserContext.newPage();
        page.navigate(appURL);
        return page;
    }
}
