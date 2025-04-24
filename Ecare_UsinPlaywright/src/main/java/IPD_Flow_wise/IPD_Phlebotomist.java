package IPD_Flow_wise;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class IPD_Phlebotomist {

	public void ipdPhlebotomist(Page page, String uhid) throws InterruptedException 
	{
		page.click("(//ul/li[2])[1]");
		Thread.sleep(1000);
		page.fill("//div[1]/div/span/input", uhid);
		Thread.sleep(1000);
		page.click("//tr[2]/td[3]/span/span[1]");

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
