package OPD_Flow_wise;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

public class LAB_FO {
	@Test
	public void labFO(Page page, String uhid) throws InterruptedException {
		page.fill("(//div[1]/div/span/input)[1]", uhid);
		Thread.sleep(1000);
		page.click("//*[contains(text(),'Accept')]");
		Thread.sleep(2000);
		page.locator("//input[@id='rc_select_1']").fill("Sameer");
		page.click("//*[contains(text(), 'Sameer')]");
		page.click("//div[2]/div/button");
	}
}
