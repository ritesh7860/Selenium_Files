package IPD_Flow_wise;

import com.microsoft.playwright.Page;

public class Bed_Allotment 
{

	public void bed_Allotment(Page page, String uhid) throws InterruptedException 
	{
		Thread.sleep(6000);
		page.fill("input[placeholder='Search Patient Name/UHID/Adm. No/Contact No.']", uhid);
		Thread.sleep(6000);
		page.locator("//tbody/tr[2]/td[14]/div/span[2]").click();
		Thread.sleep(3000);
		page.click("//div[3]/div/div[2]/div[1]/div/div[2]/div");
		page.click("//div[3]/div/div/div[2]/div/div/div/div[1]/div");	//Room No.
		page.click("(//input)[4]");
		page.click("(//*[contains(text() , 'Bed -')])[1]");  //Bed No.
		page.click("//div[2]/button[2]");
	}

}
