package dummy_testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.Base;

public class genericElementActions {

	public static void main(String[] args) {
		WebDriver driver;
		Base base = new Base();
		driver = base.getDriver("edge");
		driver.get("https://www.google.co.in");
		
		
		WebElement element =null;
		
		element.clear();
		element.sendKeys("");
		
		
		element.click();
		
		element.getText();

		
		
		element.isDisplayed();
		
		element.isEnabled();
		
		
		element.isSelected();
		
		
		
		
		
	}

}
