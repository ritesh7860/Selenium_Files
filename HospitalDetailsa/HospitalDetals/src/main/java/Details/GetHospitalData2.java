package Details;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class GetHospitalData2 {

	public static void main(String[] args) throws InterruptedException, IOException, TesseractException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://hospitals.pmjay.gov.in/Search/empnlWorkFlow.htm?actionFlag=ViewRegisteredHosptlsNew");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='select2-searchHospType-container']")).click();
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys("Private");
		driver.findElement(By.xpath("//ul[@id='select2-searchHospType-results']/li[2]")).click();
		boolean flag = true;
		while (flag) {
			WebElement element = driver.findElement(By.xpath("//div[@class='input-group']/div"));

			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			BufferedImage fullImg = ImageIO.read(screenshot);

			// Get the location and size of the element
			org.openqa.selenium.Point point = element.getLocation();
			int elementWidth = element.getSize().getWidth();
			int elementHeight = element.getSize().getHeight();

			// Crop the image to the element's dimensions
			BufferedImage elementScreenshot = fullImg.getSubimage(point.getX(), point.getY(), elementWidth,
					elementHeight);
			ImageIO.write(elementScreenshot, "png", screenshot);

			// Save the cropped image
			File screenshotLocation = new File("Screenshot/captcha.png");
			FileHandler.copy(screenshot, screenshotLocation);

			String path = "Screenshot/captcha.png";
			ITesseract image = new Tesseract();
			String str = image.doOCR(new File(path));
			System.out.println(str);
			Thread.sleep(1000);

			driver.findElement(By.xpath("//input[@id='j_captcha_response_crtacnt']")).sendKeys(str.trim());
			Thread.sleep(3000);
			js.executeScript("arguments[0].scrollIntoView(true);",
					driver.findElement(By.xpath("//button[@class='btn btn-2']")));

			driver.findElement(By.xpath("//button[@class='btn btn-2']")).click();

			Thread.sleep(2000);
			System.out.println(driver.getCurrentUrl());

			if (driver.getCurrentUrl().equals("https://hospitals.pmjay.gov.in/Search/empnlWorkFlow.htm")) {
				flag = false;
				Thread.sleep(1000);
			}

			driver.findElement(By.xpath("//*[@id='empnlHospForm']/div/div[4]/div[1]/div/div[5]/div/div[2]/a")).click();
		}

		FileInputStream file = new FileInputStream(
				"/home/unicode/Downloads/HospitalDetailsa/HospitalDetals/HospitalDetails.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);

		int row = 0;
		int count = 1;

		for (int j = 1; j <= 9; j++) {

			for (int i = 1; i <= 10; i++) {

				System.out.println("---------------" + count + "-------------");
				String name = driver.findElement(
						By.xpath("//table[@class='table table-bordered table-striped table-condensed cf']/tbody/tr[" + i
								+ "]/td[2]"))
						.getText();
				System.out.println("Hospital Name: " + name);

				String address = driver.findElement(
						By.xpath("//table[@class='table table-bordered table-striped table-condensed cf']/tbody/tr[" + i
								+ "]/td[4]"))
						.getText();
				System.out.println("Hospital Address: " + address);

				String email = driver.findElement(
						By.xpath("//table[@class='table table-bordered table-striped table-condensed cf']/tbody/tr[" + i
								+ "]/td[5]"))
						.getText();
				System.out.println("Hospital Email: " + email);

				String number = driver.findElement(
						By.xpath("//table[@class='table table-bordered table-striped table-condensed cf']/tbody/tr[" + i
								+ "]/td[6]"))
						.getText();
				System.out.println("Hospital Number: " + number);

				int rowCount = sheet.getLastRowNum();

				sheet.createRow(rowCount + 1);
				sheet.getRow(row).createCell(0).setCellValue(name);
				sheet.getRow(row).createCell(1).setCellValue(address);
				sheet.getRow(row).createCell(2).setCellValue(email);
				sheet.getRow(row).createCell(3).setCellValue(number);

				FileOutputStream fos = new FileOutputStream(
						"/home/unicode/Downloads/HospitalDetailsa/HospitalDetals/HospitalDetails.xlsx");
				workbook.write(fos);

				if (i == 10) {
					Thread.sleep(3000);
					js.executeScript("arguments[0].scrollIntoView(true);",
							driver.findElement(By.xpath("//div[@id='pageNoDisplay']/a[" + j + "]")));
					driver.findElement(By.xpath("//div[@id='pageNoDisplay']/a[" + j + "]")).click();
				}
				count++;
				row++;
			}
		} // for j
		int k;
		do {
			js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//div[@id='pageNoDisplay']/a[2]")));
			driver.findElement(By.xpath("//div[@id='pageNoDisplay']/a[2]")).click();
			for (k = 1; k <= 10; k++) {

				for (int i = 1; i <= 10; i++) {

					System.out.println("---------------" + count + "-------------");
					String name = driver.findElement(
							By.xpath("//table[@class='table table-bordered table-striped table-condensed cf']/tbody/tr[" + i
									+ "]/td[2]"))
							.getText();
					System.out.println("Hospital Name: " + name);

					String address = driver.findElement(
							By.xpath("//table[@class='table table-bordered table-striped table-condensed cf']/tbody/tr[" + i
									+ "]/td[4]"))
							.getText();
					System.out.println("Hospital Address: " + address);

					String email = driver.findElement(
							By.xpath("//table[@class='table table-bordered table-striped table-condensed cf']/tbody/tr[" + i
									+ "]/td[5]"))
							.getText();
					System.out.println("Hospital Email: " + email);

					String number = driver.findElement(
							By.xpath("//table[@class='table table-bordered table-striped table-condensed cf']/tbody/tr[" + i
									+ "]/td[6]"))
							.getText();
					System.out.println("Hospital Number: " + number);

					int rowCount = sheet.getLastRowNum();

					sheet.createRow(rowCount + 1);
					sheet.getRow(row).createCell(0).setCellValue(name);
					sheet.getRow(row).createCell(1).setCellValue(address);
					sheet.getRow(row).createCell(2).setCellValue(email);
					sheet.getRow(row).createCell(3).setCellValue(number);

					FileOutputStream fos = new FileOutputStream(
							"/home/unicode/Downloads/HospitalDetailsa/HospitalDetals/HospitalDetails.xlsx");
					workbook.write(fos);

					if (i == 10) {
						Thread.sleep(3000);
						js.executeScript("arguments[0].scrollIntoView(true);",
								driver.findElement(By.xpath("//div[@id='pageNoDisplay']/a[" + k + "]")));
						driver.findElement(By.xpath("//div[@id='pageNoDisplay']/a[" + k + "]")).click();
					}
					count++;
					row++;
				}
			} // for k
		}while(driver.findElement(By.xpath("//div[@id='pageNoDisplay']/a["+k+"]")).getText().equals("Next"));
		
	}
}
