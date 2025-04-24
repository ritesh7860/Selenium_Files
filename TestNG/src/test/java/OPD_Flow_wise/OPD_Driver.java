package OPD_Flow_wise;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class OPD_Driver {

	static Playwright playwright = Playwright.create();
	static Browser browser = playwright.chromium()
			.launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--start-maximized")));
	static BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
	static Page page = context.newPage();

	static String uhid = null;

	String name = "Fazal";
	String mail = "fazal@mightcode.com";
	String contact = "7860167222";
	String id = "Y4170707";

	Login login = new Login();
	Logout out = new Logout();

	@Test(priority = 1)
	public void patientRegLogin() throws InterruptedException {
		login.login_method("105", "Test@123", page);
	}

	@Test(priority = 2)
	public void patientReg() throws InterruptedException {
		Patient_Registration reg = new Patient_Registration();
		uhid = reg.registration(page, name, mail, contact, id);
	}

	@Test(priority = 3)
	public void bookAppointment() throws InterruptedException {
		Book_Appointment book = new Book_Appointment();
		book.bookAppointment(page, uhid);
	}

	@Test(priority = 4)
	public void frontOfficeLogout() throws InterruptedException {
		out.logout(page);
		Thread.sleep(1000);
	}

	@Test(priority = 5)
	public void DoctorLogin() throws InterruptedException {
		login.login_method("pakhisingh", "Pakhi@123", page);
	}

	@Test(priority = 6)
	public void DoctorEMR() throws InterruptedException {
		OPD_EMR emr = new OPD_EMR();
		emr.opd_EMR(page, uhid);
	}

	@Test(priority = 7)
	public void doctorLogout() throws InterruptedException {
		out.logout(page);
		Thread.sleep(1000);
	}

	@Test(priority = 8)
	public void bookTestLogin() throws InterruptedException {
		login.login_method("105", "Test@123", page);
	}

	@Test(priority = 9)
	public void bookLabTest() throws InterruptedException {
		OPD_Lab book_test = new OPD_Lab();
		book_test.bookTest(page, uhid);
	}

	@Test(priority = 10)
	public void bookTestLogout() throws InterruptedException {
		out.logout(page);
		Thread.sleep(1000);
	}

	@Test(priority = 11)
	public void LabFOLogin() throws InterruptedException {
		login.login_method("502", "Test@123", page);
	}

	@Test(priority = 12)
	public void assignPheblotomist() throws InterruptedException {
		LAB_FO lab_fo = new LAB_FO();
		lab_fo.labFO(page, uhid);
	}

	@Test(priority = 13)
	public void labFOLogout() throws InterruptedException {
		out.logout(page);
		Thread.sleep(1000);
	}

	@Test(priority = 14)
	public void phlebotomistLogin() throws InterruptedException {
		login.login_method("504", "Test@123", page);
	}

	@Test(priority = 15)
	public void collectSample() throws InterruptedException {
		OPD_Phlebotomist assign = new OPD_Phlebotomist();
		assign.assignPhlebotomist(page, uhid);
	}

	@Test(priority = 16)
	public void phlebotomistLogout() throws InterruptedException {
		out.logout(page);
		Thread.sleep(1000);
	}

	@Test(priority = 17)
	public void labTechnicianLogin() throws InterruptedException {
		login.login_method("175", "Test@123", page);
	}

	@Test(priority = 18)
	public void labReport() throws InterruptedException {
		OPD_Lab_Technician technician = new OPD_Lab_Technician();
		technician.labTechnician(page, uhid);
	}

	@Test(priority = 19)
	public void labTechnicianLogout() throws InterruptedException {
		out.logout(page);
		Thread.sleep(1000);
	}

	@Test(priority = 20)
	public void labAdminLogin() throws InterruptedException {
		login.login_method("506", "Test@123", page);
	}

	@Test(priority = 21)
	public void approveReport() throws InterruptedException {
		OPD_Pathologist patho = new OPD_Pathologist();
		patho.pathologist(page, uhid);
	}

	@Test(priority = 22)
	public void labAdminLogout() throws InterruptedException {
		out.logout(page);
		Thread.sleep(1000);
	}

	@Test(priority = 23)
	public void PharmacyLogin() throws InterruptedException {
		login.login_method("290", "Test@123", page);
	}

	@Test(priority = 24)
	public void Phamacist() throws InterruptedException {
		OPD_Pharmacy opd_pharmacy = new OPD_Pharmacy();
		opd_pharmacy.opdPharmacy(page, uhid);
	}

	@Test(priority = 25)
	public void PharmacyLogout() throws InterruptedException {
		out.logout(page);
		Thread.sleep(1000);
	}
}
