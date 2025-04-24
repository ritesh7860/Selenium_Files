package OPD_Flow_wise;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.microsoft.playwright.*;

public class OPD_EMR {
	@Test
	public void opd_EMR(Page page, String uhid) throws InterruptedException {

// Search the Patient
//			String uhid = "ECARE_0000001613";
		page.fill("input[placeholder='Search Patient Name/UHID']", uhid);
		Thread.sleep(1000);
		page.click("//tbody/tr[2]/td[3]");
		page.reload();
//page.wait(3000);
		Thread.sleep(5000);

		String history = "At that time she noticed the abrupt onset (over a few seconds to a minute) of chest pain...";
		String complaints = "Dysphagia, Nausea, Vomiting, Dizziness";
		String diagnosis = "She complains of lower back pain, aching in quality, approximately once every week...";
		String special = "Take proper bed rest";

//Vitals

		page.locator("//input[@name='Heart Rate']").fill("92");
		page.locator("//input[@name='Pulse']").fill("98");
		page.locator("//input[@name='Blood Sugar']").fill("145");
		page.locator("//input[@name='Systolic']").fill("135");
		page.locator("//input[@name='Diastolic']").fill("85");
		page.locator("//input[@name='Temperature']").fill("98");
		page.locator("//input[@name='RR']").fill("18");
		page.locator("//input[@name='SPO2']").fill("99");
		page.locator("//input[@name='Height']").fill("156");
		Thread.sleep(3000);
		page.locator("//input[@name='Weight']").fill("60");
//page.keyboard().press("Backspace");
		Thread.sleep(3000);
		
// EMR
		page.fill("textarea[placeholder='History']", history);
		page.fill("textarea[placeholder='Complaints']", complaints);
		page.click("//input[@id='rc_select_0']");
		page.fill("//input[@id='rc_select_0']", "Heart");
		page.click("div[name='Heart failure, unspecified ( I509 )']");
		page.fill("textarea[placeholder='Diagnosis Notes']", diagnosis);

// Prescription
		page.fill("input[type='search'][id='rc_select_1']", "a");
		page.click("div[name='ADVAIR 100.00 ug/1']");
		page.fill("input[name='dose']", "1");
		page.fill("input[type='search'][id='rc_select_3']", "as");
		page.click("div[title='As directed']");
		page.fill("input[type='search'][id='rc_select_4']", "after");
		page.click("div[title='After Meal']");
		page.fill("input[name='duration']", "1");
		page.click("input[placeholder='Select Date']");
		page.click("td[class='ant-picker-cell ant-picker-cell-in-view ant-picker-cell-today']");
//		page.click("span[aria-label='edit']");
//		page.fill("textarea[class='ant-input css-eq8lji ant-input-outlined']", "Take medicine with warm water");
//		page.click("//div[3]/div/div[3]/button");
		page.click("span[aria-label='plus']");

		page.click("input[type='search'][id='rc_select_6']");
		page.fill("input[type='search'][id='rc_select_6']", "allergy");
		page.click("div[title=' Allergy to peanuts(Z91.010)']");

		page.click("input[type='search'][id='rc_select_5']");
		page.fill("input[type='search'][id='rc_select_5']", "Lipid panel");
		Thread.sleep(1000);
		page.locator("//*[@id='295']/div").click();
		
		page.fill("textarea[placeholder='Special Instructions']", special);
		page.click("//div[1]/div/label/span[1]/input");

// Save button
		Thread.sleep(1000);
		page.locator("//div[7]/div/div/button[2]/span").click();
		Thread.sleep(3000);

// Complete appointment
		page.fill("input[placeholder='Search Patient Name/UHID']", uhid);
		page.click("//tbody/tr[2]/td[7]/div/span[2]");
		page.click("//*[contains(text(), 'Yes')]");
	}
}