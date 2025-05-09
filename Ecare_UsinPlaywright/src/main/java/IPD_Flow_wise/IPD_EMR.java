package IPD_Flow_wise;

import com.microsoft.playwright.Page;
public class IPD_EMR {

	public void ipd_Emr(Page page, String uhid) throws InterruptedException 
	{
		page.click("//div/ul/li[2]");
		page.fill("input[placeholder='Search Patient Name/Adm. No/UHID']", uhid);
		Thread.sleep(1000);
		page.click("//tbody/tr[2]/td[2]/div");
		page.click("(//div[1]/ul/li[3])");
		page.fill("(//input)[1]", "a");
		page.click("div[name='Abiraterone 250.00 mg/1']");
		page.fill("input[name='dose']", "1");
		page.fill("input[type='search'][id='rc_select_2']", "as");
		page.click("div[title='As directed']");
		page.fill("input[type='search'][id='rc_select_3']", "after");
		page.click("div[title='After Meal']");
		page.fill("input[name='duration']", "1");
		page.click("input[placeholder='Select Date']");
		page.click("td[class='ant-picker-cell ant-picker-cell-in-view ant-picker-cell-today']");
//		page.click("span[aria-label='edit']");
//		page.fill("textarea[class='ant-input css-eq8lji ant-input-outlined']", "Take medicine with warm water");
//		page.click("//div[3]/div/div[3]/button");
		page.click("span[aria-label='plus']");
		
		
		page.click("input[type='search'][id='rc_select_4']");
		page.fill("input[type='search'][id='rc_select_4']", "Lipid");
		Thread.sleep(1000);
		page.keyboard().press("Enter");
		// Blood Count id >> 85 on dev and complete blood count id >> 106 on demo
//		page.locator("//*[@id='295']/div").click();
		page.click("//*[contains(text(),'Save')]");
	}

}
