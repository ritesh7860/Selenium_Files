package IPD_Flow;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class IPD_Phlebotomist {

	public static void main(String[] args) throws InterruptedException 
	{
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--start-maximized")));
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		Page page = context.newPage();

		page.navigate("https://devui-ecare.mightcode.com");
		page.locator("//input[@placeholder='EMAIL/USERNAME']").fill("504");
		page.getByPlaceholder("PASSWORD").fill("Test@123");
		page.click("//button[@type='submit']");
		Thread.sleep(1000);
		String uhid = "ECARE_0000000526";
		
		page.fill("//div[1]/div/span/input", uhid);
		Thread.sleep(1000);
		page.click("//tr[2]/td[2]/span/span[1]");

		Thread.sleep(2000);
		Locator checkboxes = page.locator("//input[@type='checkbox']");
		int count = checkboxes.count();
		System.out.println("Number of checkboxes: " + count);

// Click all matching elements
		for (int i = 0; i < count; i++)
			if (!checkboxes.nth(i).isChecked()) {
				checkboxes.nth(i).click();
			}
		Thread.sleep(2000);
		page.locator("//*[contains(text(),'Save')]").click();
		Thread.sleep(2000);
	}

}
