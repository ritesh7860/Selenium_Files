package OPD_Flow_wise;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;

import com.microsoft.playwright.*;

public class OPD_Lab {
	public void bookTest(Page page, String uhid) throws InterruptedException {

// Search the Patient
//			String uhid = "ECARE_0000001470";
		page.click("//div/ul/li[3]");
		page.fill("input[placeholder='Search Patient Name/UHID']", uhid);
		Thread.sleep(1000);
		page.click("//*[contains(text(),'Book Test')]");
		Thread.sleep(2000);
		Locator checkboxes = page.locator("//input[@type='checkbox']");

// Get the count of matching elements
		int count = checkboxes.count();
		System.out.println("Number of checkboxes: " + count);

// Click all matching elements
		for (int i = 0; i < count; i++)
			if (!checkboxes.nth(i).isChecked()) {
				checkboxes.nth(i).click();
			}
		page.locator("//*[contains(text(),'Confirm')]").click();

//Payment
		Thread.sleep(2000);
		page.locator("//*[contains(text(),'Proceed')]").click();
		page.locator("//*[contains(text(),'Generate Invoice')]").click();
		page.locator("//*[contains(text(),'Cancel')]").click();

		Thread.sleep(2000);

	}
}
