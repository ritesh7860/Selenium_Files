package IPD_Flow_wise;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class IPD_Pathologist {

	public void ipd_Pathologist(Page page, String uhid) throws InterruptedException 
	{
		page.fill("//div[1]/div/span/input", uhid);
		Thread.sleep(1000);
		page.click("//tr[3]/td[3]/span/span[1]");
		page.click("//tr[2]/td[6]/span");
		Thread.sleep(2000);
		page.click("//button[2]");
		page.locator("//button/span[contains(text(),'Yes')]").click();
	}

}
