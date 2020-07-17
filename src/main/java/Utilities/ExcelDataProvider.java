package Utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wrkbook;

	public  ExcelDataProvider() {

		File file = new File(System.getProperty("user.dir")+"/testdata/testdata.xlsx");
		FileInputStream fip;

		try {
			fip = new FileInputStream(file);
			wrkbook=new XSSFWorkbook(fip);
		}
		catch (Exception e) {

			System.out.println("Unable to read Excel file "+e.getMessage());
		}
	}


	public String getStringData(String sheetName, int row, int column){

		return	wrkbook.getSheet(sheetName).getRow(row).getCell(row).getStringCellValue();
	}
	

	public double getNumericData(String sheetName, int row, int column){

		return wrkbook.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();

	}

}
