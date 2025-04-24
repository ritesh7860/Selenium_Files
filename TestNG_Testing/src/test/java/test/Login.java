package test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Login {
	@Test(priority =2)
 void LoginUser() {
	 Main_Driver.driver.findElement(By.xpath("//input[@placeholder='EMAIL/USERNAME']")).sendKeys("frontdesk");
 }
}
