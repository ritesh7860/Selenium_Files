package OPD_Flow_wise;

import com.microsoft.playwright.Page;


public class Login {
	public void login_method(String user, String pass, Page page) throws InterruptedException {
		
		page.navigate("https://devui-ecare.mightcode.com");
		page.locator("//input[@placeholder='EMAIL/USERNAME']").fill(user);
		page.getByPlaceholder("PASSWORD").fill(pass);
		page.click("//button[@type='submit']");
		Thread.sleep(2000);
	}
}
