package IPD_Flow_wise;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Bed_Allotment 
{

	public void bed_Allotment(Page page, String uhid) throws InterruptedException 
	{
		Thread.sleep(4000);
		page.fill("input[placeholder='Search Patient Name/UHID/Adm. No/Contact No.']", uhid);
		Thread.sleep(1000);
		page.locator("//tbody/tr[2]/td[14]/div/span[2]").click();
		Thread.sleep(1000);
		page.click("//div[2]/div/div/span[2]");
		page.click("//div[@class='rc-virtual-list']/div/div/div/div");	//Room No.
		page.click("//div[3]/div/div/span[2]");
		page.click("(//div[@class='rc-virtual-list']/div/div/div)[2]");  //Bed No.
		page.click("//div[2]/button[2]");
	}

}
