package OPD_Flow_wise;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class OPD_Pharmacy {
	@Test
	public void opdPharmacy(Page page, String uhid) throws InterruptedException {

//		String uhid = "ECARE_0000001483";
		Thread.sleep(2000);
//		page.locator("//ul[@role='menu']/li[2]").click();
		Thread.sleep(1000);
		page.locator("//input[@placeholder='Search Patient Name/UHID']").fill(uhid);
		page.keyboard().press("Enter");
		Thread.sleep(1000);
		Locator accept = page.locator("//tr/td/article[contains(text(),'Accept')]");
		int count = 0;
		count = accept.count();
		System.out.println(count);
		accept.nth(0).click();
		Thread.sleep(1000);
//		page.locator("//tbody/tr[2]/td[6]").click();  //div[2]/div/button[2]
		page.locator("//div/button[2]").click();
		Thread.sleep(2000);
		page.locator("//*[contains(text(),'Proceed')]").click();
		page.locator("//*[contains(text(),'Proceed')]").click();
		page.locator("//*[contains(text(),'Generate Invoice')]").click();
		page.locator("//*[contains(text(),'Cancel')]").click();
	}

}
