package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import crmbase.Cmrbaseclass;

public class Testutil extends Cmrbaseclass{

	static Workbook book;
	static Sheet sheet;

	public static long PAGE_LOAD_TIME_OUT = 20;
	public static long IMPLICT_WAIT_TIME_OUT = 20;




	public static Object[][] getTestData(String sheetName){
		FileInputStream file=null;
		String Test_data_path=	System.getProperty("user.dir");

		try {
			file = new FileInputStream( Test_data_path+"/exceldata/CrmTestData.xlsx");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		try {
			Workbook wb = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;


	}


	public static String takeScreenshotAtEndOfTest() {




		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String ScreenShotpath = System.getProperty("user.dir")+"/Screenshots/FreeCRM_"+getcurrentDateTime1()+".png";
		try{
			FileHandler.copy(src, new File(ScreenShotpath));

			System.out.println("screentshot captured ");
		}catch(Exception e){
			System.out.println("Unable to take screenshot");
		}
		return ScreenShotpath;

	}


	public static String getcurrentDateTime1(){


		DateFormat customformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentdate = new Date();
		return customformat.format(currentdate);
	}











}
