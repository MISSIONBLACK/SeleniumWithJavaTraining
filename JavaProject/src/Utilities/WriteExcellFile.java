package Utilities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcellFile {

	public static void main(String[] args) {
		
		// Blank WorkBook
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		// Create Excel Sheet
		XSSFSheet samplesheet = workbook.createSheet("SampleSheet");
		
		// Create the Data
		Map<String, Object[]> dataSet = new TreeMap<String, Object[]>();
		
		dataSet.put("1", new Object[] {"ID", "NAME", "Company"});
		dataSet.put("2", new Object[] {"1", "Akash", "Capgemini"});
		dataSet.put("3", new Object[] {"2", "Harsh", "Fujitsu"});
		dataSet.put("4", new Object[] {"3", "Tanay", "TCS"});
		dataSet.put("5", new Object[] {"4", "Arpan", "CA"});
		dataSet.put("6", new Object[] {"5", "Shambhavi", "ForcePoint"});
		dataSet.put("7", new Object[] {"6", "Faheem", "Oman"});
		
		// Iterate over the data
		Set<String> set = dataSet.keySet();
		int rownum = 0;
		
		for (String key : set) {
			Row row = samplesheet.createRow(rownum++);
			
			Object[] data = dataSet.get(key);
			
			int cellNum = 0;
			
			for (Object value : data) {
				
				Cell cell = row.createCell(cellNum++);
				
				if (value instanceof String)
					cell.setCellValue((String)value);
				else if(value instanceof Integer)
					cell.setCellValue((Integer)value);
			}
		}
		
		// Write Down File on HardDisk
		
		try {
			FileOutputStream writeFile = new FileOutputStream("sampleTest.xlsx");
			workbook.write(writeFile);
			
			writeFile.close();
			System.out.println("Sample Excel File is being created Successfully");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
