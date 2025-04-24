package OPD_Flow;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class OPD_Pathologist 
{

	public static void main(String[] args) throws InterruptedException 
	{
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--start-maximized")));
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		Page page = context.newPage();

		page.navigate("https://devui-ecare.mightcode.com");
		page.locator("//input[@placeholder='EMAIL/USERNAME']").fill("506");
		page.getByPlaceholder("PASSWORD").fill("Test@123");
		page.click("//button[@type='submit']");
		Thread.sleep(1000);
		String uhid = "ECARE_0000001483";
		Thread.sleep(1000);
		page.fill("//div[1]/div/span/input", uhid);
		Thread.sleep(1000);
		page.click("//tr[2]/td[2]/span/span[1]");
		page.click("//tr[2]/td[6]/span");
		Thread.sleep(2000);
		page.click("//button[2]");
		page.locator("//button/span[contains(text(),'Yes')]").click();
	}

}
