package IPD_Flow_wise;

import com.microsoft.playwright.Page;

public class Logout {
	
	public void logout(Page page) throws InterruptedException {
		Thread.sleep(1000);	
		page.locator("//div[6]/div/span").click();
		page.locator("//ul/li[4]/span[2]/span").click();
	}

}
