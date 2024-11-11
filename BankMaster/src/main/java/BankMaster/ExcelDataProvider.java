package BankMaster;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider extends BaseClass {
		public String fetchData_bm(int r, int col) throws IOException {

			String path = "BankMasterDataFetch.xlsx";
			File f = new File(path);
			FileInputStream fi = new FileInputStream(path);
			XSSFWorkbook wb = new XSSFWorkbook(fi);
			sheet = wb.getSheetAt(0);
			XSSFRow row = sheet.getRow(r);
			String data = row.getCell(col).getStringCellValue();
			System.out.println(data);
			int b = sheet.getPhysicalNumberOfRows();
			System.out.println("count " + b);
			wb.close();
			return data;
		}

		public Integer rowCountExcel() {

			int a = sheet.getLastRowNum();

			int b = sheet.getPhysicalNumberOfRows();

//		    System.out.println("count "+b);

			return b;

		}
	}