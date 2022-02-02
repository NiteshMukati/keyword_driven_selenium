package gettingKeywordData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.Base;

public class GetExcelData {

	public static WebDriver driver;
	public static Workbook xssfWorkbook = null;
	public static Workbook hssfWorkbook = null;
	public static Properties prop = null;

	public void getKeywords() {

		Base base;
		String fileName = "keywordDrivenFramework.xlsx";
		String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\excelData\\";

		File f = new File(filePath.concat(fileName));
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(f);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		String exe;
		Sheet login = null;
		exe = fileName.substring(fileName.indexOf(".")).trim();

		if (exe.equalsIgnoreCase(".xlsx")) {
			try {
				xssfWorkbook = new XSSFWorkbook(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			login = xssfWorkbook.getSheet("login");
		} else if (exe.equalsIgnoreCase(".xls")) {
			try {
				hssfWorkbook = new HSSFWorkbook(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
			login = hssfWorkbook.getSheet("login");
		}
		String locatorColumn;
		WebElement element = null;
		String locatorName = "";
		String locatorValue = null;

		int k = 0;
		for (int i = 0; i < login.getLastRowNum(); i++) {
			String testStep = login.getRow(i).getCell(k).toString();
			System.out.println(testStep);
			locatorColumn = login.getRow(i + 1).getCell(k + 1).toString();
			if (!locatorColumn.equalsIgnoreCase("NA")) {

				locatorName = locatorColumn.split("=", 2)[0];
//				System.out.println("after split by = in locatorName is --> "+locatorName);
				locatorValue = locatorColumn.split("=", 2)[1];
//				System.out.println("after split by = in locatorvalue is --> "+locatorValue);
			}

			String action = login.getRow(i + 1).getCell(k + 2).toString();
			String value = login.getRow(i + 1).getCell(k + 3).toString();

			if (!(locatorName == null)) {
				switch (locatorName) {

				case "id": {

					element = driver.findElement(By.id(locatorValue));
					if (action.equalsIgnoreCase("sendkeys")) {
						System.out.println("Sending / Entering text through id!");
						element.clear();
						element.sendKeys(value);
					} else if (action.equalsIgnoreCase("click")) {
						System.out.println("Clicking the element through id!");
						element.click();
					} else if (action.equalsIgnoreCase("verify text")) {
						System.out.println("Verifying the text through id!");
						element.getText().equalsIgnoreCase(locatorValue);

					}
					locatorName = null;
					break;
				}

				case "xpath": {
					element = driver.findElement(By.xpath(locatorValue));
					if (action.equalsIgnoreCase("sendkeys")) {
						System.out.println("Sending / Entering text through xpath!");
						element.clear();
						element.sendKeys(value);
					} else if (action.equalsIgnoreCase("click")) {
						System.out.println("Clicking the element through xpath!");
						element.click();
					} else if (action.equalsIgnoreCase("verify text")) {
						System.out.println("Verifying the text through xpath!");
						element.getText().equalsIgnoreCase(locatorValue);
					}
					locatorName = null;
					break;
				}

				case "name": {
					element = driver.findElement(By.name(locatorValue));
					if (action.equalsIgnoreCase("sendkeys")) {
						System.out.println("Sending / Entering text through name!");
						element.clear();
						element.sendKeys(value);
					} else if (action.equalsIgnoreCase("click")) {
						System.out.println("Clicking the element through name!");
						element.click();
					} else if (action.equalsIgnoreCase("verify text")) {
						System.out.println("Verifying the text through name!");
						element.getText().equalsIgnoreCase(locatorValue);
					}
					locatorName = null;
					break;
				}

				case "css": {
					element = driver.findElement(By.cssSelector(locatorValue));
					if (action.equalsIgnoreCase("sendkeys")) {
						System.out.println("Sending / Entering text through css!");
						element.clear();
						element.sendKeys(value);
					} else if (action.equalsIgnoreCase("click")) {
						System.out.println("Clicking the element through css!");
						element.click();
					} else if (action.equalsIgnoreCase("verify text")) {
						System.out.println("Verifying the text through css!");
						element.getText().equalsIgnoreCase(locatorValue);
					}
					locatorName = null;
					break;
				}
				case "classname": {
					element = driver.findElement(By.className(locatorValue));

					if (action.equalsIgnoreCase("sendkeys")) {
						System.out.println("Sending / Entering text through classname!");
						element.clear();
						element.sendKeys(value);
					} else if (action.equalsIgnoreCase("click")) {
						System.out.println("Clicking the element through classname!");
						element.click();
					} else if (action.equalsIgnoreCase("verify text")) {
						System.out.println("Verifying the text through classname!");
						element.getText().equalsIgnoreCase(locatorValue);
					}
					locatorName = null;
					break;
				}
				case "tagname": {
					element = driver.findElement(By.tagName(locatorValue));
					if (action.equalsIgnoreCase("sendkeys")) {
						System.out.println("Sending / Entering text through tagname!");
						element.clear();
						element.sendKeys(value);
					} else if (action.equalsIgnoreCase("click")) {
						System.out.println("Clicking the element through tagname!");
						element.click();
					} else if (action.equalsIgnoreCase("verify text")) {
						System.out.println("Verifying the text through tagname!");
						element.getText().equalsIgnoreCase(locatorValue);
					}
					locatorName = null;
					break;
				}

				case "na": {
					break;
				}
				default:
					break;
				}
			}

			switch (action) {

			case "open browser": {
				System.out.println("Opening the browser!");
				base = new Base();
				if (value.isEmpty() || value.equalsIgnoreCase("NA")) {
					prop = base.getProp();
//					prop.getProperty("browser");
					driver = base.getDriver(prop.getProperty("browser"));
					System.out.println("Iinitialized the driver object through if statement!");
				} else
					System.out.println("Iinitialized the driver object through else statement!");
				driver = base.getDriver(value);
				break;
			}

			case "enter url": {
				System.out.println("Entering the url!");
				driver.get(value);
				break;
			}

			case "quit": {
				System.out.println("Quiting and closing the browser!");
				driver.quit();
				break;

			}

			case "enter username": {

//				driver.findElement(
			}

			default:
				break;

			}

//	if(locatorName ==null) {
//		System.out.println("LocatorName is --> "+locatorName);
//	}	else 	{		

		}

	}
}

//	public static void main(String[] args) {
//
//		GetExcelData.getKeywords();
//	}
