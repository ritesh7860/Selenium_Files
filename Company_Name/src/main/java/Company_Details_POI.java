import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Company_Details_POI {

    public static void main(String[] args) throws InterruptedException, IOException {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.addArguments("--disable-blink-features=AutomationControlled");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://clutch.co/us/developers/information-technology-industry");
        driver.manage().window().maximize();

        // Excel setup
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Company Data");

        // Header row
        Row header = sheet.createRow(0);
        String[] columns = {"Name", "Project Size", "Hourly Rate", "Employee Count", "Location", "Service Provided", "Description", "Profile Link"};
        for (int i = 0; i < columns.length; i++) {
            header.createCell(i).setCellValue(columns[i]);
        }

        int rowCount = 1;
        int page = 1;

        while (true) {

            for (int i = 1; i <= 64; i++) {
                try {
                    String xpath1 = String.format("(//div/div[1]/h3/a)[%d]", i);
                    String xpath2 = String.format("(//*[contains(@class, 'min-project-size')])[%d]", i);
                    String xpath3 = String.format("(//*[contains(@class, 'hourly-rate')])[%d]", i);
                    String xpath4 = String.format("(//*[contains(@class, 'employees-count')])[%d]", i);
                    String xpath5 = String.format("(//*[contains(@class, 'employees-count')]/following-sibling::div)[%d]", i);
                    String xpath6 = String.format("(//div[@class='provider__services-list'])[%d]", i);
                    String xpath7 = String.format("(//p[contains(@class, 'project-highlight-text')])[%d]", i);
                    String xpath8 = String.format("(//div[@class='provider__cta-container']/a[1])[%d]", i);

                    WebElement name = driver.findElement(By.xpath(xpath1));
                    WebElement min_Project_Size = driver.findElement(By.xpath(xpath2));
                    WebElement hourly_rate = driver.findElement(By.xpath(xpath3));
                    WebElement employee_count = driver.findElement(By.xpath(xpath4));
                    WebElement location = driver.findElement(By.xpath(xpath5));
                    WebElement service_Provided = driver.findElement(By.xpath(xpath6));
                    WebElement description = driver.findElement(By.xpath(xpath7));
                    WebElement profile = driver.findElement(By.xpath(xpath8));

                    // Write to Excel
                    Row row = sheet.createRow(rowCount++);
                    row.createCell(0).setCellValue(name.getText());
                    row.createCell(1).setCellValue(min_Project_Size.getText());
                    row.createCell(2).setCellValue(hourly_rate.getText());
                    row.createCell(3).setCellValue(employee_count.getText());
                    row.createCell(4).setCellValue(location.getText());
                    row.createCell(5).setCellValue(service_Provided.getText());
                    row.createCell(6).setCellValue(description.getText());
                    row.createCell(7).setCellValue(profile.getAttribute("href"));

                } catch (Exception e) {
                    // Element might not be found if less than 64 entries
                    break;
                }
            }
            String link = String.format("https://clutch.co/us/developers/information-technology-industry?page=%d", page);
            driver.get(link);
            Thread.sleep(8000);
            page++;
            if (page > 40) break; // Change this to crawl more pages if needed
        }

        // Auto-size columns
        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write to file
        FileOutputStream fileOut = new FileOutputStream("CompanyData.xlsx");
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
        driver.quit();

        System.out.println("Excel file created successfully!");
    }
}
