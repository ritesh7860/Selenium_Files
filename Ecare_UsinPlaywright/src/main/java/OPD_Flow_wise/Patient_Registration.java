package OPD_Flow_wise;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.nio.file.Paths;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.options.ScreenSize;

public class Patient_Registration {

	public String registration(Page page,String name,String mail,String contact,String id) throws InterruptedException 
	{

		page.click("//*[contains(text(),'New Registration')]");
		Thread.sleep(2000);
		page.reload();
		Thread.sleep(2000);
		//  Title
		page.locator("//*[@id='rc_select_0']").fill("Mrs");
		page.keyboard().press("Enter");
		Thread.sleep(2000);
		// Name
		page.locator("//input[@placeholder='Patient Name']").fill(name);
		Thread.sleep(2000);
		//Email
		page.locator("//input[@placeholder='Email Id']").fill(mail);
		//Contact
		page.locator("//input[@name='contact_number']").fill(contact);
		// Select Date
		page.locator("//*[@placeholder='Select Date']").click();
		page.locator("//*[contains(text(),'2025')]").click();
		page.locator("//button[@aria-label='super-prev-year']").click();
		page.locator("//button[@aria-label='super-prev-year']").click();
		page.locator("//*[contains(text(),'2001')]").click();
		page.locator("//*[contains(text(),'Jul')]").click();
		page.locator("//div[2]/table/tbody/tr[2]/td[3]/div").click();
		//Gender
		page.locator("//*[@id='rc_select_5']").fill("Female");
		page.keyboard().press("Enter");
		page.locator("//*[@id='rc_select_2']").fill("Passport");
		page.keyboard().press("Enter");
		Thread.sleep(2000);
		page.locator("//input[@name='identity_card']").fill(id);
		Thread.sleep(2000);
		page.locator("//*[@id='rc_select_4']").fill("Hindu");
		page.keyboard().press("Enter");
		//Address
		page.locator("//input[@placeholder='Enter Address']").fill("187-Agile Hieght");
		page.locator("//input[@placeholder='Enter Pincode']").fill("226022");

		page.locator("//input[@placeholder='Contact Person Name']").fill("Ritesh Singh");
		page.locator("//*[@id='rc_select_9']").fill("Other Relative/ Friend/ Neighbour");
		page.keyboard().press("Enter");

		page.locator("//input[@name='relative_contact_number']").fill("7380830760");
		Thread.sleep(2000);
		page.click("//*[contains(text(),'Save')]");
		Thread.sleep(2000);
		Locator idLocator = page.locator("//*[contains(text(),'UHID')]");

		// Extract the text
		String idText = idLocator.textContent();
		
		// Split the text to get the UHID
		String uhid = idText.split(": ")[1];

		System.out.println("UHID: " + uhid);

		// Payment
		Thread.sleep(2000);
		page.locator("//*[contains(text(),'Proceed')]").click();

		page.locator("//*[contains(text(),'Generate Invoice')]").click();
		page.locator("//*[contains(text(),'Cancel')]").click();

		return uhid;
	}
}
