package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_excel extends PageaManager {

	// public static void main(String[] args) {

	public static void main(String[] args) throws IOException {

		Read_excel r = new Read_excel();
		List<String> sheet_vendor = r.read_excel_Uniquedata(0, 4);
		
		for (int i = 0; i <= sheet_vendor.size() - 1; i++) {
			
				//System.out.println(sheet_vendor.get(i));
			}
		
		
	}

	public String read_excel_onecellvalue(int sheetid, int rowid, int columnid) throws IOException {
		File l=new File("C:\\Users\\FQ495BQ\\OneDrive - EY\\Documents\\Automation docs\\Working project\\SCP_QA\\configuration\\New Microsoft Excel Worksheet.xlsx");
		//Latest_Modified_file l = new Latest_Modified_file();
		//String data = l.filepath().getAbsolutePath();
		String data = l.getAbsolutePath();
		System.out.println(data);

		FileInputStream fil = new FileInputStream(data);

		XSSFWorkbook wb = new XSSFWorkbook(fil);
		XSSFSheet sh = wb.getSheetAt(sheetid);

		XSSFCell cell = sh.getRow(rowid).getCell(columnid);
		String s = "";
		if (cell.getCellType() == CellType.NUMERIC) {
			double d = cell.getNumericCellValue();
			System.out.println(d);
			s = Integer.toString((int) Math.round(d));
			System.out.println(s);

			// s = Integer.toString(d);
		} else {

			System.out.println(cell.getStringCellValue());
			s = cell.getStringCellValue();
		}
		return s;
	}

	public String read_excel_withreference(int sheetid, int columnid, String value) throws IOException {
		File l=new File("C:\\Users\\FQ495BQ\\OneDrive - EY\\Documents\\Automation docs\\Working project\\SCP_QA\\configuration\\New Microsoft Excel Worksheet.xlsx");
		//Latest_Modified_file l = new Latest_Modified_file();
		//String data = l.filepath().getAbsolutePath();
		String data = l.getAbsolutePath();
		
		
		FileInputStream fil = new FileInputStream(data);
		XSSFWorkbook wb = new XSSFWorkbook(fil);
		XSSFSheet sh = wb.getSheetAt(sheetid);
		String s = "";
		for (int i = 0; i < sh.getLastRowNum(); i++) {

			XSSFCell cell = sh.getRow(i).getCell(columnid);

			if (cell.getCellType() == CellType.NUMERIC) {
				int d = (int) cell.getNumericCellValue();
				s = Integer.toString(d);
			} else {

				s = cell.getStringCellValue();
			}
			if (s.equalsIgnoreCase(value)) {
				System.out.println(s);
				break;
			} else {

				s = "Error ----------- Match did not found----------------Error";
			}
		}

		return s;

	}

	public List<String> read_excel_Uniquedata(int sheetid, int columnid) throws IOException {
		
		File l=new File("C:\\Users\\FQ495BQ\\OneDrive - EY\\Documents\\Automation docs\\Working project\\SCP_QA\\configuration\\New Microsoft Excel Worksheet.xlsx");
		//Latest_Modified_file l = new Latest_Modified_file();
		//String data = l.filepath().getAbsolutePath();
		String data = l.getAbsolutePath();
		FileInputStream fil = new FileInputStream(data);
		XSSFWorkbook wb = new XSSFWorkbook(fil);
		XSSFSheet sh = wb.getSheetAt(sheetid);

		// if you want print duplicate then enable below list and disble set
		List<String> alldata = new ArrayList<String>();
		// Set <String> alldata =new HashSet<String>();
		String s = "";

		for (int i = 0; i < sh.getLastRowNum(); i++) {

			XSSFRow row = sh.getRow(i);
			XSSFCell cell = row.getCell(columnid);
			if (cell.getCellType() == CellType.NUMERIC) {
				double d = cell.getNumericCellValue();
				long a = (long) d;
				// int a=(int) Math.round(d);
				// s = Integer.toString(a);
				s = Long.toString(a);
			} else {
				s = cell.getStringCellValue();
			}
			alldata.add(s);
		}
		return alldata;
	}

	public void readexcells(int sheetid, int rowid, int columnid, int value) {
		File l=new File("C:\\Users\\FQ495BQ\\OneDrive - EY\\Documents\\Automation docs\\Working project\\SCP_QA\\configuration\\New Microsoft Excel Worksheet.xlsx");
		//Latest_Modified_file l = new Latest_Modified_file();
		//String data = l.filepath().getAbsolutePath();
		String data = l.getAbsolutePath();
		System.out.println(data);

		try {
			FileInputStream file = new FileInputStream(data);

			XSSFWorkbook workbook = new XSSFWorkbook(file);

			XSSFSheet sheet = workbook.getSheetAt(sheetid);
			// System.out.println(sheet.getRow(rowid).getCell(columnid).getNumericCellValue());
			Row r = sheet.getRow(rowid);
			Iterator<Cell> cellIterator = r.cellIterator();

			for (int j = 0; j < r.getLastCellNum(); j++) {

				Cell cell = cellIterator.next();
				int maxCell = r.getLastCellNum();
				// System.out.println(maxCell);
				if (j == columnid) {

					System.out.println("Data come here");
					if (cell.getCellType() == CellType.NUMERIC) {
						System.out.println("iam on 1");

						System.out.println(cell.getNumericCellValue());
					} else {
						System.out.println("iam on 2");

						System.out.println(cell.getStringCellValue());
					}
					System.out.println("iam on 3");

					cell.setCellValue(10);
					System.out.println("iam on 4");

					System.out.println(cell.getNumericCellValue());
				}
				/*
				 * sheet.getRow(rowid).getCell(columnid).setCellValue(value); FileOutputStream
				 * fos=new FileOutputStream(new File(data)); workbook.write(fos);
				 * System.out.println(data);
				 * System.out.println(sheet.getRow(rowid).getCell(columnid).getNumericCellValue(
				 * )); workbook.close();
				 */

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
