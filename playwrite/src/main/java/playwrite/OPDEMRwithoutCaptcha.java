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


public class OPDEMRwithoutCaptcha {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(width, height));
		Page page = context.newPage();

		page.navigate("https://devui-ecare.mightcode.com");
		Thread.sleep(1000);

		page.locator("//input[@placeholder='EMAIL/USERNAME']").fill("alok@mightcode.com");
		page.getByPlaceholder("PASSWORD").fill("Doctor@123");
		page.click("//button[@type='submit']");

	
		String uhid = "ECARE_2024_0000007103";
		page.locator("//input[@placeholder='Search Patient Name / UHID']").fill(uhid + "1");
		Thread.sleep(2000);
		page.keyboard().press("Backspace");
		Thread.sleep(2000);
		page.locator("//tbody[@class='ant-table-tbody']/tr[2]/td[3]").click();
//		page.locator("//*[contains(text(),'Vedika')]").click();
		Thread.sleep(2000);

		page.locator("//textarea[@placeholder='History']").fill("Heart Attack");
		Thread.sleep(2000);
		page.locator("//textarea[@placeholder='Complaints']").fill("Heart Attack");
		page.locator(".ant-select-selection-overflow").first().click();
		Thread.sleep(2000);
		page.getByTitle("Enteroinvasive Escherichia").locator("div").click();
		page.keyboard().press("Escape");
		page.locator("//textarea[@placeholder='Diagnosis Notes']").fill("Heart Attack");
		// Medicine
//	    page.locator("//*[@id='rc_select_1']").fill("d");
//	    Thread.sleep(2000);
//	    page.locator("//div[@class='rc-virtual-list']/div/div/div/div[2]").click();

		// Investigation
		page.locator("#rc_select_6").click();
		page.getByTitle("CBC").locator("div").click();
		page.getByTitle("D-dimer").locator("div").click();
		page.getByText("ESR").click();
		page.keyboard().press("Escape");

		page.locator("//textarea[@placeholder='Special Instructions']").fill("Cardiology Department EMR");

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

		page.locator("#rc_select_7").click();
		page.getByTitle("Allergic Conditions").locator("div").click();
		page.keyboard().press("Escape");

		page.locator("//*[@title='2024-03-28']").click();

		page.locator("//*[@value='IPD Admission']").click();
		page.locator("//*[@class='flex justify-center mt-[25px]']/button[2]").click();
	}

}
