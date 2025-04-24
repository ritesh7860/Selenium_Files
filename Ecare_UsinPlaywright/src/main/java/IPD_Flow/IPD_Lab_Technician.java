package IPD_Flow;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class IPD_Lab_Technician {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--start-maximized")));
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		Page page = context.newPage();

		page.navigate("https://devui-ecare.mightcode.com");
		page.locator("//input[@placeholder='EMAIL/USERNAME']").fill("175");
		page.getByPlaceholder("PASSWORD").fill("Test@123");
		page.click("//button[@type='submit']");
		Thread.sleep(1000);
		String uhid = "ECARE_0000000526";
		page.click("//div/ul/li[2]");
		page.fill("//div[1]/div/span/input", uhid);
		Thread.sleep(1000);
		page.click("//tr[2]/td[3]/div/span");
		Thread.sleep(1000);
		page.click("//tr[2]/td[4]/span");
		Thread.sleep(2000);
		Locator enabledInputs = page.locator("//input[not(@disabled)]");

		// Get the count of matching elements
		int count = enabledInputs.count();
		System.out.println("Number of enabled input elements: " + count);
		Thread.sleep(2000);
		enabledInputs.nth(0).fill("15.6");
		Thread.sleep(2000);
		enabledInputs.nth(1).fill("45.7");
		Thread.sleep(1000);
		enabledInputs.nth(2).fill("87");
		Thread.sleep(1000);
		enabledInputs.nth(3).fill("30");
		Thread.sleep(1000);
		enabledInputs.nth(4).fill("57000");
		Thread.sleep(1000);
		enabledInputs.nth(5).fill("18000");
		Thread.sleep(2000);
		Thread.sleep(2000);
		enabledInputs.nth(6).fill("70");
		Thread.sleep(1000);
		enabledInputs.nth(7).fill("4500");
		Thread.sleep(1000);
		enabledInputs.nth(8).fill("280");
		Thread.sleep(2000);
		page.locator("//button[2]").click();
		Thread.sleep(2000);
		Thread.sleep(1000);
		page.fill("//div[1]/div/span/input", uhid);
		Thread.sleep(1000);
		page.click("//tr[2]/td[3]/div/span");
		Thread.sleep(1000);
		Locator checkboxes = page.locator("//input[@type='checkbox']");

		// Get the count of matching elements
		int count1 = checkboxes.count();
		System.out.println("Number of checkboxes: " + count1);

		// Click all matching elements
		for (int i = 0; i < count1; i++)
			if (!checkboxes.nth(i).isDisabled()) {
				checkboxes.nth(i).click();
			}
		page.locator("//*[contains(text(),'Send')]").click();
		Thread.sleep(1000);
		page.locator("//button/span[contains(text(),'Yes')]").click();
	}

}
