package playwrite;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class OPD_EMR {

	public static void main(String[] args) throws InterruptedException, TesseractException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(width, height));
		Page page = context.newPage();

		page.navigate("https://devui-ecare.mightcode.com");
		Thread.sleep(1000);

		Boolean flag = true;
		while (flag) {
			page.locator("//*[@id='canv']").first()
					.screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("Screenshot/captcha.png")));
			page.locator("//input[@placeholder='EMAIL/USERNAME']").fill("alok@mightcode.com");
			page.getByPlaceholder("PASSWORD").fill("Doctor@123");

			String path = "/home/unicode/Downloads/Playwrite/playwrite/Screenshot/captcha.png";
			ITesseract image = new Tesseract();
			String str = image.doOCR(new File(path));
			str = str.replaceAll("\\s", "");
			System.out.println(str);
			page.getByPlaceholder("Enter Captcha").fill(str);
			Thread.sleep(4000);
			page.click("//button[@type='submit']");
			Thread.sleep(2000);
			page.reload();
			if (page.url().equals("https://devui-ecare.mightcode.com/opd-doctor-patient")) {
				flag = false;
			}
		}
		String uhid = "ECARE_2024_0000007103";
		page.locator("//input[@placeholder='Search Patient Name / UHID']").fill(uhid + "1");
		Thread.sleep(2000);
		page.keyboard().press("Backspace");
		Thread.sleep(2000);
		page.locator("//*[contains(text(),'Vedika')]").click();

		page.locator("//textarea[@placeholder='History']").fill("Fever");
		page.locator("//textarea[@placeholder='Complaints']").fill("Fever");
		page.locator(".ant-select-selection-overflow").first().click();
		Thread.sleep(2000);
		page.getByTitle("Enteroinvasive Escherichia").locator("div").click();
		page.keyboard().press("Escape");
		page.locator("//textarea[@placeholder='Diagnosis Notes']").fill("Fever");
		// Medicine
//	    page.locator("//*[@id='rc_select_1']").fill("d");
//	    Thread.sleep(2000);
//	    page.locator("//div[@class='rc-virtual-list']/div/div/div/div[2]").click();

		// Investigation
		page.locator("#rc_select_4").click();
		page.getByTitle("CBC").locator("div").click();
		page.getByTitle("D-dimer").locator("div").click();
		page.getByText("ESR").click();
		page.keyboard().press("Escape");

		page.locator("//textarea[@placeholder='Special Instructions']").fill("Take proper bed rest");

		page.locator(
				"//span[@class='ant-typography css-do48xg' and contains(text(),'Pulse(/min)')]//following-sibling::input[@type='text']")
				.fill("92");
		page.locator(
				"//span[@class='ant-typography css-do48xg' and contains(text(),'Temperature(F)')]//following-sibling::input[@type='text']")
				.fill("98");
		page.locator(
				"//span[@class='ant-typography css-do48xg' and contains(text(),'Height(cm)')]//following-sibling::input[@type='text']")
				.fill("145");
		page.locator(
				"//span[@class='ant-typography css-do48xg' and contains(text(),'Weight(Kg)')]//following-sibling::input[@type='text']")
				.fill("58");
		page.locator(
				"//span[@class='ant-typography css-do48xg' and contains(text(),'SPO2(%)')]//following-sibling::input[@type='text']")
				.fill("98");
		page.locator(
				"//span[@class='ant-typography css-do48xg' and contains(text(),'Systolic(Mm/Hg)')]//following-sibling::input[@type='text']")
				.fill("98");
		page.locator(
				"//span[@class='ant-typography css-do48xg' and contains(text(),'Diastolic(Mm/Hg)')]//following-sibling::input[@type='text']")
				.fill("98");
		page.locator(
				"//span[@class='ant-typography css-do48xg' and contains(text(),'RR(/min)')]//following-sibling::input[@type='text']")
				.fill("98");

		page.locator("#rc_select_5").click();
		page.getByTitle("Allergic Conditions").locator("div").click();
		page.keyboard().press("Escape");

		page.locator("//*[@title='2024-02-25']").click();

		page.locator("//*[@value='IPD Admission']").click();
		//page.locator("//*[@class='flex justify-center mt-[25px]']/button[2]").click();
	}

}
