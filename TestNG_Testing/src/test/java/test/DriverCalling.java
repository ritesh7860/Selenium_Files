package test;
import org.testng.annotations.Test;

public class DriverCalling 
{
	@Test(priority =1)
void driverCalling() {
	
	Main_Driver.driver.get("https://devsewa.mightcode.com/");
}
}