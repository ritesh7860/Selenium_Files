package IPD_Flow;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class IPD_Pharmaacy {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--start-maximized")));
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		Page page = context.newPage();

		page.navigate("https://devui-ecare.mightcode.com");
		page.locator("//input[@placeholder='EMAIL/USERNAME']").fill("290");
		page.getByPlaceholder("PASSWORD").fill("Test@123");
		page.click("//button[@type='submit']");
		Thread.sleep(1000);
		String uhid = "ECARE_0000000526";
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
		page.locator("//div/button[2]").click();
		Thread.sleep(1000);
		page.locator("//*[contains(text(),'Proceed')]").click();
		page.locator("//*[contains(text(),'Dispatch & Save')]").click();
		
		// logout
		
		Thread.sleep(1000);	
		page.locator("//div[6]/div/span").click();
		page.locator("//ul/li[4]/span[2]/span").click();
		
		//login Nurse and Receive Medicine
		
		page.locator("//input[@placeholder='EMAIL/USERNAME']").fill("sneha@mightcode.com");
		page.getByPlaceholder("PASSWORD").fill("Nurse@123");
		page.click("//button[@type='submit']");
		
		page.fill("input[placeholder='Search Patient Name / UHID']", uhid);
		page.click("//tbody/tr[2]/td[2]/div");
		
        // Click on the Medication and request 
        
        page.click("//div[1]/ul/li[3]");   
        page.click("//tbody/tr[2]/td[11]/div/label/span/input");

	}

}
