package org.example;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitUntilState;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class App {
    private Playwright playwright;
    private Browser browser;
    private Page page;

    @BeforeClass
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
    }

    @Test
    public void testChromium() {
        page.navigate("https://playwright.dev", new Page.NavigateOptions().setWaitUntil(WaitUntilState.NETWORKIDLE));
        System.out.println(page.title()); // Print the title of the page
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));

        assertThat(page).hasTitle(Pattern.compile("Playwright"));

        Locator getStarted = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Get Started"));
        getStarted.click();
        assertThat(getStarted).hasAttribute("href", "/docs/intro");

        assertThat(page.getByRole(AriaRole.HEADING,
                new Page.GetByRoleOptions().setName("Installation"))).isVisible();

    }

    @Test
    public void testFireFox() {
        page.navigate("https://playwright.dev", new Page.NavigateOptions().setWaitUntil(WaitUntilState.NETWORKIDLE));
        System.out.println(page.title()); // Print the title of the page
    }

    @AfterClass
    public void tearDown() {
        browser.close();
        playwright.close();
    }

//    @Test
//    public void main(String[] args) {
////        Playwright playwright = Playwright.create();
//////            playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
////            Browser browser = playwright.chromium().launch();
////            BrowserContext browserContext = browser.newContext();
////            Page page = browserContext.newPage();
//
//        Page page = Playwright.create().chromium().launch().newPage();
//            page.navigate("http://playwright.dev");
//            System.out.println(page.title());
//
//    }
}
