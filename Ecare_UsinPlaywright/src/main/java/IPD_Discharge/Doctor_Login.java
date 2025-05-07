package IPD_Discharge;

import com.microsoft.playwright.Page;

public class Doctor_Login {

		public void doctor_login(Page page,String uhid) throws InterruptedException 
		{
			String RFA= "The patient was admitted for acute appendicitis.";
			String HOPI= "The Patient presented with a 24-hour history of acute abdominal pain localized to the right lower quadrant, accompanied by nausea and vomiting. The pain began suddenly and progressively worsened, prompting a visit to the emergency department.";
			String PE= "On examination, the patient was in moderate distress but alert and oriented. Vital signs were as follows:\n"
					+ "- Temperature: 38.2°C\n"
					+ "- Blood Pressure: 130/85 mmHg\n"
					+ "- Heart Rate: 98 bpm\n"
					+ "- Respiratory Rate: 18 breaths per minute\n"
					+ "Abdominal examination revealed tenderness in the right lower quadrant with rebound tenderness and guarding. No palpable masses were noted.";
			String DS= "- *Complete Blood Count (CBC):* Elevated white blood cell count of 15,000/µL, indicating possible infection.\n"
					+ "- *Ultrasound:* Findings consistent with an inflamed appendix.\n"
					+ "- *CT Scan:* Confirmed diagnosis of acute appendicitis with no evidence of perforation.";
			String Prog= "The prognosis for Veer is good, given the successful completion of the appendectomy. Follow-up care and monitoring are essential to ensure complete recovery.";
			String Medi_His= "- *Allergies:* No known drug allergies.\n"
					+ "- *Medications:* None prior to admission.\n"
					+ "- *Past Medical History:* Hypertension, well-controlled.\n"
					+ "- *Past Surgical History:* None.\n"
					+ "- *Family History:* No significant family medical history.";
			String Spe_Ins= "- *Medications:*\n"
					+ "- Amoxicillin 500 mg, three times a day for 7 days.\n"
					+ "- Acetaminophen 500 mg, as needed for pain.\n"
					+ "- *Activity:* Avoid heavy lifting for 2 weeks.\n"
					+ "- *Diet:* Start with a soft diet and gradually return to regular diet as tolerated.\n"
					+ "- *Follow-up Appointments:* Follow-up with the surgeon on June 14, 2024.\n"
					+ "- *Wound Care:* Keep the incision site clean and dry. Remove dressings after 48 hours and leave open to air.\n"
					+ "- *Signs and Symptoms to Monitor:* Watch for signs of infection, such as fever, increased pain, redness, or discharge at the surgical site.";
			String SOHS= "The Patient was admitted on June 1, 2024, with a diagnosis of acute appendicitis. After initial evaluation and diagnostic work-up, a laparoscopic appendectomy was performed on June 1, 2024. The surgery was successful and without complications. Postoperatively, the patient recovered in the general ward and was monitored for 6 days. Pain management was effectively achieved with acetaminophen, and the patient was mobilized on June 2, 2024.\n"
					+ "Upon discharge, Veer was stable and well enough to go home with the above-mentioned instructions. The patient was educated on the importance of adhering to follow-up care and instructions to ensure optimal recovery.";
			
			
			
			page.click("//div/ul/li[2]");
			page.fill("input[placeholder='Search Patient Name/Adm. No/UHID']", uhid);
			Thread.sleep(2000);
			page.click("//tr/td[8]/div/span[5]");
//			page.click("//*[contains(text(),'Yes')]");
			page.locator("(//textarea)[1]").fill(RFA);
			page.locator("(//textarea)[2]").fill(HOPI);
			page.locator("(//textarea)[3]").fill(PE);
			page.locator("(//textarea)[4]").fill(DS);
			page.locator("(//textarea)[5]").fill(Prog);
			page.locator("(//textarea)[6]").fill(Medi_His);
			page.locator("(//textarea)[7]").fill(Spe_Ins);
			page.locator("(//textarea)[8]").fill(SOHS);
			
			// Medicine 
			
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
//			page.click("span[aria-label='edit']");
//			page.fill("textarea[class='ant-input css-eq8lji ant-input-outlined']", "Take medicine with warm water");
//			page.click("//div[3]/div/div[3]/button");
			page.click("span[aria-label='plus']");
			
			
		}

}
