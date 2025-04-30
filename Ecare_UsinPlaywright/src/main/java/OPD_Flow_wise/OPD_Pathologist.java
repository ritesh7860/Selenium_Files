package OPD_Flow_wise;
import com.microsoft.playwright.Page;

public class OPD_Pathologist 
{

	public void pathologist(Page page, String uhid) throws InterruptedException 
	{
		
		Thread.sleep(1000);
		page.fill("//div[1]/div/span/input", uhid);
		Thread.sleep(1000);
		page.click("//tr[2]/td[3]/div/span/span[1]");
		page.click("//tr[2]/td[4]/span");
		Thread.sleep(2000);
		page.click("//button[2]");
		page.locator("//button/span[contains(text(),'Yes')]").click();
	}

}
