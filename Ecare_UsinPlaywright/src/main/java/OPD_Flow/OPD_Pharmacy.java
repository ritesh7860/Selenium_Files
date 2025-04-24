package OPD_Flow;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class OPD_Pharmacy 
{
	public static void main(String[] args) throws InterruptedException 
	{
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--start-maximized")));
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		Page page = context.newPage();

		page.navigate("https://demoui-ecare.mightcode.com");
		page.locator("//input[@placeholder='EMAIL/USERNAME']").fill("290");
		page.getByPlaceholder("PASSWORD").fill("Test@123");
		page.click("//button[@type='submit']");
		Thread.sleep(1000);
		String uhid = "ECARE_0000001483";
		Thread.sleep(2000);
		page.locator("//ul[@role='menu']/li[2]").click();
		Thread.sleep(1000);
		page.locator("//input[@placeholder='Search Patient Name / UHID']").fill(uhid);
		page.keyboard().press("Enter");
		Thread.sleep(1000);
		Locator accept = page.locator("//tr/td/article[contains(text(),'Accept')]");
		int count = 0;
		count = accept.count();
		System.out.println(count);
		accept.nth(0).click();
		Thread.sleep(1000);
//		page.locator("//tbody/tr[2]/td[6]").click();
		page.locator("//div/button[2]").click();
		Thread.sleep(1000);
		page.locator("//button[@class='ant-btn css-eq8lji ant-btn-primary rounded-md  mx-1']").click();
		Thread.sleep(1000);
		page.locator("//*[contains(text(),'Generate Invoice')]").click();
		Thread.sleep(1000);
		page.locator("//div[@id='btnvisibility']/button[1]").click();
	}

}
