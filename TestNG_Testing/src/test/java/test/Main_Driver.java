package test;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Main_Driver {
	
	static WebDriver driver = new ChromeDriver();
	@Test(priority = 0)
	void openBrowser() 
	{
		driver.manage().window().maximize();
	}
	
}
