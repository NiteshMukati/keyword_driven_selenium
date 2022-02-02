package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	public static WebDriver driver;
	public Properties prop = null;

	public WebDriver getDriver(String browser) {

//		prop = getProp();
		String browserName = browser; // else try this --->  prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",
					System.getProperty("user.dir") + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.firefox.driver",
					System.getProperty("user.dir") + "\\browserDrivers\\firefoxdriver.exe");
			driver = new FirefoxDriver();
		}

		return driver;

	}

	public Properties getProp() {

		Properties prop = null;

		final String filePath = System.getProperty("user.dir")
				+ "\\src\\main\\java\\config\\properties\\config.properties";

		try {
			FileInputStream fis = new FileInputStream(filePath);
			prop = new Properties();
			prop.load(fis);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
