package playwrite;

import java.io.File;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.options.AriaRole;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class BookAppointment {

	public static void main(String[] args) throws InterruptedException, TesseractException {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();

		page.navigate("https://devui-ecare.mightcode.com");
		Thread.sleep(1000);
		
		Boolean flag = true;
		while(flag) {
			page.locator("//*[@id='canv']").first().screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("Screenshot/captcha.png")));
			page.locator("//input[@placeholder='EMAIL/USERNAME']").fill("105");
			page.getByPlaceholder("PASSWORD").fill("Test@123");
			
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
			if(page.url().equals("https://devui-ecare.mightcode.com/opd-dashboard")) {
				flag = false;
			}
		}
		
		page.locator("//input[@placeholder='Search Patient Name / UHID']").fill("ECARE_2024_0000005950");
		Thread.sleep(2000);
		page.click("//*[@class='ant-table-tbody']/tr[2]/td[5]");

		page.locator("//input[@placeholder='Search By Department']").fill("Cardiology Department");
		Thread.sleep(2000);
		page.locator("//*[@id='scrollableDiv']/div/div/h4").click();
		Thread.sleep(5000);

		page.locator("//input[@placeholder='Search By Doctor']").click();
		page.locator("//*[contains(text(),'Mr Alok')]").click();

		Thread.sleep(2000);
		ElementHandle slot = null;
		
List<ElementHandle>ele=page.querySelectorAll("//button[@class='ant-btn css-do48xg ant-btn-default ant-btn-lg bg-[--primary] text-[--whiteGray]  rounded-lg customBtn border-0 outline-none' and not(@disabled)]"); 
		
		LocalDate currentDate = LocalDate.now();

        // Get the day of the month
        int day = currentDate.getDayOfMonth();
		
		while(ele.size()==0) {
			page.locator("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div/span[2]/span").click();
			Thread.sleep(1500);
			page.locator("//*[@placeholder=\"Select Date\"]").fill((day-1)+" February 2024");
			Thread.sleep(2000);
			page.keyboard().press("Enter");
			Thread.sleep(3000);
			ele=page.querySelectorAll("//button[@class='ant-btn css-do48xg ant-btn-default ant-btn-lg bg-[--primary] text-[--whiteGray]  rounded-lg customBtn border-0 outline-none' and not(@disabled)]");
			System.out.println(ele.size());
			day++;
		}
		ele.get(0).click();
		System.out.println("loop out");
		Thread.sleep(3000);
		List<ElementHandle> slots = page.querySelectorAll(
				"div[class=\"w-[160px] rounded-full mr-4 text-[12px] mb-2 px-3 py-3 bg-green-200 border-solid border-2 border-green-500 text-green-500 cursor-pointer\"]"
				);
		System.out.println(slots.size());
		Thread.sleep(500);
		slots.get(0).click();
		Thread.sleep(1000);
		page.locator("//*[contains(text(),\"Confirm\")]").click();
		Thread.sleep(1000);
		page.locator("//*[contains(text(), \"PROCEED\")]").click();
		Thread.sleep(1000);
		page.locator("//*[contains(text(), \"Generate Invoice\")]").click();
		Thread.sleep(1000);
		page.locator("//*[contains(text(), \"Cancel\")]").click();

	}

}
