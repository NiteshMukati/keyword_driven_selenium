package mainmethodclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class initExcelMethods {

	public static void main(String[] args) {

		Workbook wb = null;
		
		System.setProperty("webdriver.edge.driver",
				System.getProperty("user.dir") + "\\browserDrivers\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();

		String fileName = "keywordDrivenFramework.xlsx";
		String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\excelData\\";

		File f = new File(filePath.concat(fileName));
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(f);
			wb = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Sheet login = wb.getSheet("login");
		System.out.println(login.getRow(1).getCell(1).getStringCellValue());
	}

}
