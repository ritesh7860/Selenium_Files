package sewa;

import com.microsoft.playwright.Page;

public class Sewa_Login {
	public void login(String id, String pass, Page page) throws InterruptedException {
		page.navigate("https://devsewa.mightcode.com");
		page.locator("//input[@placeholder='EMAIL/USERNAME']").fill(id);
		page.getByPlaceholder("PASSWORD").fill(pass);
		page.click("//button[@type='submit']");
		Thread.sleep(2000);
		
	}

}
