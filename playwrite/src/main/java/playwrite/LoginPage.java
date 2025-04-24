package playwrite;

import java.io.File;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class LoginPage {

	public static void main(String[] args) throws TesseractException, InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://produi-ecare.mightcode.com");
		page.locator("//input[@placeholder='EMAIL/USERNAME']").fill("105");
		page.getByPlaceholder("PASSWORD").fill("Test@123");
		Thread.sleep(2000);
		
		Boolean flag = true;
		while(flag) {
			page.locator("//*[@id='canv']").first().screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("Screenshot/captcha.png")));
			
			String path = "/home/unicode/Downloads/Playwrite/playwrite/Screenshot/captcha.png";
			ITesseract image = new Tesseract();

			String str = image.doOCR(new File(path));
			System.out.println(str);
			
			page.getByPlaceholder("Enter Captcha").fill(str);
			Thread.sleep(3000);
			page.click("//button[@type='submit']");
			
			if(page.url()=="https://produi-ecare.mightcode.com/opd-dashboard")
				flag = false;
		}
		
		Thread.sleep(2000);
		page.close();

	}

}
