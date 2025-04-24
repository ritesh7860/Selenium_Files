package OPD_Flow_wise;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import com.microsoft.playwright.Page;

public class Book_Appointment {
	
	public void bookAppointment(Page page, String uhid) throws InterruptedException{
		Thread.sleep(2000);
		page.locator("(//input[@placeholder='Search Patient Name/UHID'])[1]").fill(uhid);
		//div[1]/div/span/input
		Thread.sleep(2000);
		page.click("//*[contains(text(),'Book Appointment')]");

		Thread.sleep(2000);
		page.locator("//span[contains(text(),'Search By Department')]//preceding::input[1]").fill("Critical Care & Anesthesia");
		Thread.sleep(1000);
		page.keyboard().press("Enter");
		Thread.sleep(2000);

		page.locator("//span[contains(text(),'Search By Doctor')]//preceding::input[1]").fill("Pakhi");
		page.locator("//*[contains(text(),'Dr. Pakhi Shah')]").click();
		Thread.sleep(2000);

		page.click("//div[@class='px-2 mb-3 w-full border']/div/div/div[2]/button[not(@disabled)]");
		Thread.sleep(1000);
		page.click(
				"//div[@class='w-[160px] rounded-md mr-4 text-[12px] mb-2 px-3 py-3 bg-[#FFFFFF] customhoverBg border-solid border-2 border-[--primary] cursor-pointer text-[--primary]']");
		Thread.sleep(1000);
		page.locator("//*[contains(text(),'Confirm')]").click();

		// Payment
		Thread.sleep(2000);
		page.locator("//*[contains(text(),'Proceed')]").click();
		page.locator("//*[contains(text(),'Generate Invoice')]").click();
		page.locator("//*[contains(text(),'Cancel')]").click();

	}

}
