package sewa;

import com.microsoft.playwright.Page;

public class Sewa_Logout {
	public void logout(Page page) throws InterruptedException {
		page.click("//div[6]/div/span");
		page.click("//ul/li[4]/span[2]/span");
		
	}
}
