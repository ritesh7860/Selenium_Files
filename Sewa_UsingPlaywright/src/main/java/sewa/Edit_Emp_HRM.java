package sewa;

import java.util.List;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.WaitForSelectorState;

public class Edit_Emp_HRM {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--start-maximized")));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        Page page = context.newPage();

        // Navigate to login page
        page.navigate("https://devui-ecare.mightcode.com/login");

        // Login
        page.fill("//input[@id='basic_email']", "hrm1");
        page.fill("//*[@id=\"basic_password\"]", "Test@123");
        page.click("//button[@type=\"submit\"]");

        // Click on employee at side menu
        page.click("//*[@href=\"/hr/employee-listing\"]");

        // Search employee
        page.fill("//*[@placeholder=\"Search Employee Name/Department/Employee ID\"]", "Suresh Kumar Gupta");
        Thread.sleep(2000);

        // Click on view Button
        page.click("//tr[2]/td[16]/div/div");

        // Click on the edit Button
        page.click("(//button[@type=\"button\"])[1]");

        // Click on Professional Tab
        page.click("//*[contains(text(),'Professional Information')]");

        // Radio button Job Type
        page.waitForSelector("(//*[@type=\"search\"])[15]", new Page.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE));
        page.click("//*[@value=\"Contractual\"]");

        // Selecting the Date of Joining
        page.click("//*[@name=\"join_date\"]"); // Open Calendar
        page.click("//*[@class=\"ant-picker-cell ant-picker-cell-in-view ant-picker-cell-today\"]"); // Select Today's date

        // Probation Check box
        page.click("//*[@name=\"is_probation_period\"]");

        // Click on the probation edit button
        page.click("(//*[@class=\"h-auto flex cursor-pointer\"])[1]");

        // Enter the probation Period in the days
        page.fill("//input[@name=\"probation_period_days\"]", "60");

        // Notice Period Checkbox
        page.click("//input[@name=\"is_notice_period\"]");

        // Click on the notice period pencil
        page.click("(//div[@class=\"h-auto flex cursor-pointer\"])[2]");

        // Enter the number in notice period text box
        page.fill("//input[@name=\"notice_period_days\"]", "60");

        // Department Dropdown
        page.fill("(//input[@type=\"search\"])[9]", "Blood Bank");
        page.keyboard().press("Enter");

        // Role
        page.fill("(//input[@type=\"search\"])[10]", "HR Manager");
        page.keyboard().press("Enter");

        // Designation
        page.waitForTimeout(3000);
        page.fill("(//input[@type=\"search\"])[11]", "HR Manager");
        page.keyboard().press("Enter");

        // Enter mobile number
        page.fill("//*[@name=\"professional_phone\"]", "8799191157");

        // Email
        page.fill("//*[@name=\"professional_email\"]", "suresh@mightcode.com");

        // Experience Years
        page.fill("(//*[@type=\"search\"])[13]", "2");
        page.keyboard().press("Enter");

        // Experience Months
        page.fill("(//*[@type=\"search\"])[14]", "3");
        page.keyboard().press("Enter");

        // Job Type
        page.waitForSelector("(//*[@type=\"search\"])[15]", new Page.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE));
        page.fill("(//*[@type=\"search\"])[15]", "Contract-Full Time");
        page.keyboard().press("Enter");

        // HOD
        page.fill("(//*[@type=\"search\"])[16]", "Vivek Yadav (Front Office)");
        page.keyboard().press("Enter");

        // Credentials
        page.fill("//*[@placeholder=\"Enter Username\"]", "viveky@mightcode.com");

        // Click on Generate
        page.click("//*[contains(text(),'Generate')]");

        // Enter the Qualification
        page.fill("//*[@placeholder=\"Enter Your Qualification\"]", "MCA");

        // Click Qualification (From)
        page.click("(//*[@class=\"ant-picker ant-picker-middle ant-picker-outlined css-1lfmcmr block\"])[3]");

        // Click on the from year button
//        page.waitForSelector("//div[@class=\"ant-picker-header-view\"]/button[@aria-label=\"year panel\"]", new Page.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE));
        page.locator("//div[12]/div/div/div/div/div[1]/div/div[1]/div/button[2]").click();

        // Click on the Previous Year Button
        Thread.sleep(2000);
        page.locator("(//button[@aria-label='super-prev-year'])[2]").click();

        // Select the year 2017
        page.click("//*[@title=\"2017\"]");

        // Select the Month April
        page.click("//*[@title=\"2017-04\"]");

        // Select the day
        page.click("//*[@title=\"2017-04-08\"]");


    }
}