package utilities;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class ExcelReader {
	public static int totalRow;

	//method to find the excel path and get the sheet name
	/*The getData method takes the file path of the Excel file (excelfilepath) and 
	 the name of the sheet within the Excel file (sheetName) as input parameters.
	  It opens the Excel file using Apache POI's WorkbookFactory, 
	 gets the specified sheet, and then calls the readSheet method to read the data from the sheet.*/
	public List<Map<String,String>> getData(String excelfilepath, String sheetName) throws InvalidFormatException, IOException{
		
		
		Workbook workbook = WorkbookFactory.create(new File(excelfilepath));
		LoggerLoad.info("File Path : " + excelfilepath);
		Sheet sheet = workbook.getSheet(sheetName);
		LoggerLoad.info(" Sheet Name : " + sheetName);
		workbook.close();
		return readSheet(sheet);
		
	}
	
		public List<Map<String,String>> readSheet(Sheet sheet){
			
			Row row;
			Cell cell;
			LoggerLoad.info("Read Sheet data");
			//get the total row of the sheet
			int totalRow = sheet.getLastRowNum();
			LoggerLoad.info("Total Row : " + totalRow);
			
			List<Map<String, String>> excelRows = new ArrayList<Map<String, String>>();

			for (int currentRow = 1; currentRow <= totalRow; currentRow++) {

				row = sheet.getRow(currentRow);
				LoggerLoad.info("Row : " + row);
				
				int totalColumn = row.getLastCellNum();
				LoggerLoad.info("Total Column : " + totalColumn);

				LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<String, String>();

				for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {

					cell = row.getCell(currentColumn);
					LoggerLoad.info("Cell : " + cell);
					
					String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn)
							.getStringCellValue();
					LoggerLoad.info("Column Header Name : " + columnHeaderName);

					columnMapdata.put(columnHeaderName, cell.getStringCellValue());
				}

				excelRows.add(columnMapdata);
			}

			return excelRows;
		}
			
}

