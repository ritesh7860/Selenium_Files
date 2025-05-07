package IPD_Discharge;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import IPD_Flow_wise.IPD_Admission;
import IPD_Flow_wise.Login;
import IPD_Flow_wise.Logout;

public class Discharge_Driver {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--start-maximized")));
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		Page page = context.newPage();
		String uhid="ECARE_0000004727";
		Login login = new Login();
		Logout out = new Logout();
		
		login.login_method("pakhisingh", "Pakhi@123", page);
		Doctor_Login doc_log = new Doctor_Login();
		doc_log.doctor_login(page, uhid);
//		out.logout(page);
	}

}
