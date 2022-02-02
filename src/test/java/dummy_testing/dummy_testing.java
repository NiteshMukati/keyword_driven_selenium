package dummy_testing;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.Base;

public class dummy_testing {
	
	public WebDriver driver;
	
//	public static void main(String[] args) {
		
		@Test
		public void initDriver() {
		
		
		Base base = new Base();
		
		driver = base.getDriver("edge");
		driver.get("https://www.google.co.in");
		
		driver.quit();
	}

}
