package learning;

import java.nio.file.Paths;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FirstScript {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
        BrowserContext newContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(3000, 1000));

		Page page = browser.newPage();
		page.navigate("https://playwright.dev/java/docs/intro");
	    page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("Screenshot/example.png")));
		System.out.println(page.title());
		System.out.println(page.url());
        assertThat(page).hasTitle(Pattern.compile("Playwright"));

		page.locator("//a[@href='/java/community/welcome']").click();
	    page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("Screenshot/example2.png")));
		System.out.println(page.url());
	}

}
