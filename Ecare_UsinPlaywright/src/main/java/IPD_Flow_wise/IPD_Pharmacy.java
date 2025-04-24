package IPD_Flow_wise;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class IPD_Pharmacy {

	public void ipdPharmacy(Page page, String uhid) throws InterruptedException 
	{
		page.click("(//div/ul/li[2])[1]");
		page.locator("//input[@placeholder='Search Patient Name/UHID/Adm. No.']").fill(uhid);
		page.keyboard().press("Enter");
		Thread.sleep(1000);
		Locator accept = page.locator("//tr/td/article[contains(text(),'Accept')]");
		int count = 0;
		count = accept.count();
		System.out.println(count);
		accept.nth(0).click();
		Thread.sleep(1000);
		page.locator("//div/button[2]").click();
//		Thread.sleep(1000);
//		page.locator("//*[contains(text(),'Proceed')]").click();
		Thread.sleep(1000);
		page.locator("//*[contains(text(),'Dispatch & Save')]").click();
		
		// logout
		
		Thread.sleep(1000);	
		page.locator("//div[6]/div/span").click();
		page.locator("//ul/li[4]/span[2]/span").click();
		
		//login Nurse and Receive Medicine
		
		page.locator("//input[@placeholder='EMAIL/USERNAME']").fill("sneha@mightcode.com");
		page.getByPlaceholder("PASSWORD").fill("Nurse@123");
		page.click("//button[@type='submit']");
		
		page.fill("input[placeholder='Search Patient Name/Adm. No/UHID']", uhid);
		page.click("//tbody/tr[2]/td[3]/div");
		
        // Click on the Medication and request 
        
        page.click("//div[1]/ul/li[3]");   
        page.click("//tbody/tr[2]/td[11]/div/label/span/input");

	}

}
