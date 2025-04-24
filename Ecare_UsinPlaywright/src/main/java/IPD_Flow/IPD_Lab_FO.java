package IPD_Flow;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class IPD_Lab_FO {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--start-maximized")));
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		Page page = context.newPage();

		page.navigate("https://devui-ecare.mightcode.com");
		page.locator("//input[@placeholder='EMAIL/USERNAME']").fill("502");
		page.getByPlaceholder("PASSWORD").fill("Test@123");
		page.click("//button[@type='submit']");
		Thread.sleep(1000);
		String uhid = "ECARE_0000000526";
		Thread.sleep(1000);Thread.sleep(1000);
		page.fill("//div[1]/div/span/input", uhid);
		Thread.sleep(1000);
		page.click("//*[contains(text(),'Accept')]");
		Thread.sleep(2000);
		page.click("//div[2]/button/span");
		page.click("//div/ul/li[3]/span/label/span/input");
		page.click("//div/div[2]/div/div/button");
		page.click("//div[2]/div/button");
		page.locator("//*[@id='btnvisibility']/button[1]/span").click();
	}

}
