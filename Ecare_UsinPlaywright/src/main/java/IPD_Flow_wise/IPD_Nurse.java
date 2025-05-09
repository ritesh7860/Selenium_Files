package IPD_Flow_wise;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class IPD_Nurse {

	public void nurseFlow(Page page, String uhid) throws InterruptedException 
	{
		page.fill("input[placeholder='Search Patient Name/Adm. No/UHID']", uhid);
		page.click("//tbody/tr[2]/td[2]/div/span[1]");
		
		//Click on Vitals section and fill Vitals
		
		page.click("(//div[1]/ul/li[2])");   
		//(div[1]/ul/li[2])[2]
		Thread.sleep(2000);
		page.locator("//input[@name='Heart Rate']").fill("98");
        page.locator("//input[@name='Pulse']").fill("98");
        page.locator("//input[@name='Blood Sugar']").fill("120");
        page.locator("//input[@name='Systolic']").fill("130");
        page.locator("//input[@name='Diastolic']").fill("85");
        page.locator("//input[@name='Temperature']").fill("98");
        page.locator("//input[@name='RR']").fill("18");
        page.locator("//input[@name='SPO2']").fill("98");
        page.locator("//input[@name='Height']").fill("145");
        page.locator("//input[@name='Weight']").fill("55");
        page.click("//button[2]");
        
        // Click on the Medication and request 
        
        page.click("//div[1]/ul/li[3]");   
        page.click("//span[contains(text(),'Request Medicine')]");
        
        // Click on the Lab and request 
        
        page.click("//div[1]/ul/li[5]"); 
        Thread.sleep(1000);
        page.click("//span[contains(text(),'Request')]");
        
		
	}

}
