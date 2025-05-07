import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Company_Details {

	public static void main(String[] args) throws InterruptedException 
	{
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		options.addArguments("--disable-blink-features=AutomationControlled");

		WebDriver driver = new ChromeDriver(options);

//		ChromeDriver driver = new ChromeDriver();
		driver.get("https://clutch.co/developers/information-technology-industry?geona_id=40823");
		driver.manage().window().maximize();
		int n=0,a=0;
		while(true) 
		{
			n++;
			String link = String.format("https://clutch.co/developers/information-technology-industry?geona_id=40823&page=%d", n);
			int i=1;
			for(i=1;i<=64;i++) {
				a++;
				 String xpath1 = String.format("(//div/div[1]/h3/a)[%d]", i);
				 String xpath2 = String.format("(//*[contains(@class, 'min-project-size')])[%d]", i);
				 String xpath3 = String.format("(//*[contains(@class, 'hourly-rate')])[%d]", i);
				 String xpath4 = String.format("(//*[contains(@class, 'employees-count')])[%d]", i);
				 String xpath5 = String.format("(//*[contains(@class, 'employees-count')]/following-sibling::div)[%d]", i);
				 String xpath6 = String.format("(//div[@class='provider__services-list'])[%d]", i);
				 String xpath7 = String.format("(//p[contains(@class, 'project-highlight-text')])[%d]", i);
				 String xpath8 = String.format("(//div[@class='provider__cta-container']/a[1])[%d]", i);
//				 String xpath9 = String.format("(//div[@class='provider__cta-container']/a[2])[%d]", i);
				 
	             // Wait for the element to be present and visible
	             WebElement name = driver.findElement(By.xpath(xpath1));
	             WebElement min_Project_Size = driver.findElement(By.xpath(xpath2));
	             WebElement hourly_rate = driver.findElement(By.xpath(xpath3));
	             WebElement employee_count = driver.findElement(By.xpath(xpath4));
	             WebElement location = driver.findElement(By.xpath(xpath5));
	             WebElement service_Provided = driver.findElement(By.xpath(xpath6));
	             WebElement description = driver.findElement(By.xpath(xpath7));
	             WebElement profile = driver.findElement(By.xpath(xpath8));
//	             WebElement website = driver.findElement(By.xpath(xpath9));
	             
	
	             System.out.println("Name " + a + ": " + name.getText());
	             System.out.println("Project Size " + a + ": " + min_Project_Size.getText());
	             System.out.println("Hourly Rate " + a + ": " + hourly_rate.getText());
	             System.out.println("Employee Count " + a + ": " + employee_count.getText());
	             System.out.println("Location " + a + ": " + location.getText());
	             System.out.println("Service provided " + a + ": " + service_Provided.getText());
	             System.out.println("Description " + a + ": " + description.getText());
	             System.out.println("Profile Link " + a + ": " + profile.getAttribute("href"));
//	             System.out.println("Website Link" + a + ": " + website.getAttribute("href"));
	             System.out.println("\n");
	             
			}
			Thread.sleep(2000);
//			driver.findElement(By.xpath("//*[@id='pagination-nav']/div/a[8]")).click();
//			Thread.sleep(60000);
			driver.get(link);
			Thread.sleep(10000);
		}
	}

}
