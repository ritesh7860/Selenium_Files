package sewa;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import sewa.Sewa_Login;


public class Sewa_OPD_Driver {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--start-maximized")));
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		Page page = context.newPage();
		
		String name ="Shivam shahu";
		String mail="shivam12@mightcode.com";
		String contact="8078965840";
		String id="S4170707";
		
		Sewa_Login login = new Sewa_Login();
		Sewa_Logout out = new Sewa_Logout();
		
		login.login("frontdesk", "Sewa@123",page);
		out.logout(page);
//		Patient_Registration reg =  new Patient_Registration();
//		String uhid = reg.registration(page, name, mail, contact, id);

	}

}
