package IPD_Discharge;

import com.microsoft.playwright.Page;

public class LogOut {
	public void logout(Page page) throws InterruptedException {
		Thread.sleep(1000);	
		page.locator("//div[6]/div/span").click();
		page.locator("//ul/li[4]/span[2]/span").click();
	}
}
