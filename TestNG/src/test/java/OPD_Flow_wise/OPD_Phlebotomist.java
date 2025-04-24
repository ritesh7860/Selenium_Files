package OPD_Flow_wise;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class OPD_Phlebotomist {
	@Test

	public void assignPhlebotomist(Page page, String uhid) throws InterruptedException {

// Search the Patient

		page.fill("//div[1]/div/span/input", uhid);
		Thread.sleep(1000);
		page.click("//tr[2]/td[2]/span/span[1]");

		Thread.sleep(2000);
		Locator checkboxes = page.locator("//input[@type='checkbox']");
		int count = checkboxes.count();
		System.out.println("Number of checkboxes: " + count);

// Click all matching elements
		for (int i = 0; i < count; i++)
			if (!checkboxes.nth(i).isChecked()) {
				checkboxes.nth(i).click();
			}
		Thread.sleep(2000);
		page.locator("//*[contains(text(),'Save')]").click();
		Thread.sleep(2000);

	}

}
