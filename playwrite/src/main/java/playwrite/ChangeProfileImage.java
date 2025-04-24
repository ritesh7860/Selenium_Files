package playwrite;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class ChangeProfileImage {

	public static void main(String[] args) throws InterruptedException {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext newContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(3000, 1000));
		Page page = browser.newPage();
		page.navigate("https://produi-ecare.mightcode.com/dashboard");
		page.locator("//input[@placeholder='EMAIL/USERNAME']").fill("alok@mightcode.com");
		page.getByPlaceholder("PASSWORD").fill("Doctor@123");
		Thread.sleep(15000);
		page.click("//button[@type='submit']");
		page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("down")).click();
		page.locator("//*[contains(text(),'Profile')]").click();
		page.locator("//*[@class='absolute bottom-0 right-7 rounded-full bg-[#CCCCCC]']").click();
		//page.locator("//*[@class='ant-upload']").click();
		FileChooser fileChooser = page.waitForFileChooser(() -> page.locator("//*[@class='ant-upload']").click());
		fileChooser.setFiles(Paths.get("Profile/dr.png"));
		page.locator("//*[contains(text(),'Crop')]").click();
		page.locator("//*[contains(text(),'Save')]").click();
		
		
	}

}
