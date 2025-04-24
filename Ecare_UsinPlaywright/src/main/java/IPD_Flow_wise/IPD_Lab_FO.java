package IPD_Flow_wise;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class IPD_Lab_FO {

	public void ipd_Lab_Fo(Page page, String uhid) throws InterruptedException {

		Thread.sleep(1000);
		page.click("(//ul/li[2])[1]");
		Thread.sleep(1000);
		page.fill("//div[1]/div/span/input", uhid);
		Thread.sleep(1000);
		page.click("//*[contains(text(),'Accept')]");
		Thread.sleep(2000);
		page.locator("//input[@id='rc_select_2']").fill("Sameer");
		page.click("//*[contains(text(), 'Sameer')]");
		page.click("//div[2]/div/button");
		page.locator("//*[@id='btnvisibility']/button[1]/span").click();
	}

}
