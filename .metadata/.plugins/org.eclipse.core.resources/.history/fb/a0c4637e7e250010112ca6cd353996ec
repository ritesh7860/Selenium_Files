package IPD_Flow_wise;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class IPD_Lab_Technician {

	public void ipdlabTechnician(Page page , String uhid) throws InterruptedException 
	{
		page.click("//div/ul/li[2]");
		page.fill("//div[1]/div/span/input", uhid);
		Thread.sleep(1000);
		page.click("//tr[2]/td[4]/div/span");
		Thread.sleep(1000);
		page.click("//tr[2]/td[5]/span");
		Thread.sleep(2000);
		Locator enabledInputs = page.locator("//input[not(@disabled)]");

		// Get the count of matching elements
		int count = enabledInputs.count();
		System.out.println("Number of enabled input elements: " + count);
		Thread.sleep(2000);
		enabledInputs.nth(0).fill("150");
		Thread.sleep(2000);
		enabledInputs.nth(1).fill("40");
		Thread.sleep(1000);
		
		page.locator("//button[2]").click();
		Thread.sleep(2000);
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
