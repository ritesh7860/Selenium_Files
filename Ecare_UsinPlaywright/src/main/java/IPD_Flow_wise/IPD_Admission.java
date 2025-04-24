package IPD_Flow_wise;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class IPD_Admission 
{
	public void ipdAdmission(Page page, String uhid) throws InterruptedException 
	{
		
		page.click("//div/ul/li[2]");
		page.fill("input[placeholder='Search Patient Name/UHID']", uhid);
		Thread.sleep(2000);
		page.click("//button");
		Thread.sleep(2000);
		page.locator("//*[@id='rc_select_2']").click();
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

	}

}
