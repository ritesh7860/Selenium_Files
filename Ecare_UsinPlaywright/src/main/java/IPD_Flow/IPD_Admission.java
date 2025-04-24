package IPD_Flow;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class IPD_Admission 
{
	public static void main(String[] args) throws InterruptedException 
	{
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--start-maximized")));
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		Page page = context.newPage();
		page.navigate("https://devui-ecare.mightcode.com");
		page.locator("//input[@placeholder='EMAIL/USERNAME']").fill("105");
		page.getByPlaceholder("PASSWORD").fill("Test@123");
		page.click("//button[@type='submit']");

		
		String uhid = "ECARE_0000000526";
		page.click("//div/ul/li[3]");
		page.fill("input[placeholder='Search Patient Name / UHID']", uhid);
		Thread.sleep(2000);
		page.click("//button");
		Thread.sleep(2000);
		page.locator("//*[@id='rc_select_3']").click();
		Thread.sleep(2000);
		page.locator("//div[contains(text(),'General Ward')]").click();
		Thread.sleep(2000);
		page.locator("//div[3]/button[2]").click();

		//Payement
		Thread.sleep(2000);
		page.locator("//*[contains(text(),'Proceed')]").click();
		page.locator("//*[contains(text(),'Generate Invoice')]").click();
		page.locator("//*[contains(text(),'Cancel')]").click();

		Thread.sleep(2000);
		//Logout
		page.locator("//div[6]/div/span").click();
		page.locator("//ul/li[4]/span[2]/span").click();


	}

}
