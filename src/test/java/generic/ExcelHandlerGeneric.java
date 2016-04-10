package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHandlerGeneric {
	XSSFWorkbook wb = null;
	
	public ExcelHandlerGeneric(String filename)
	{
		FileInputStream fis = null;
		
		
		try {
			 fis = new FileInputStream(filename);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			 wb = new XSSFWorkbook(fis);
			 fis.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		if(wb!=null)
		{
			System.out.println("Excel connection successfull");
		}
		
	}
	
	public int getrowcount(String sheetname)
	{
		int rowcount = wb.getSheet(sheetname).getLastRowNum();
		return rowcount;
	}
	
	public int getcolcount(String sheetname)
	{
		int colcount = wb.getSheet(sheetname).getRow(0).getLastCellNum();
		return colcount;
	}
	
	public String getXLcellvalue(String sheetname, int rowindex, int colindex)
	{
		String celltext = null;
		XSSFCell cell = wb.getSheet(sheetname).getRow(rowindex).getCell(colindex);
		if(cell.getCellType()==Cell.CELL_TYPE_STRING)
		{
			 celltext = cell.getStringCellValue();
		}
		else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC)
		{
			double numericCellValue = cell.getNumericCellValue();
			 celltext = String.valueOf(numericCellValue);
		}
		
		return celltext;
		//System.out.println(celltext);
	}
	
	public void writeXlcellvalue(String sheetname, int rowindex, int colindex, String value)
	{
		XSSFRow row = wb.getSheet(sheetname).getRow(rowindex);
		if(row==null)
		{
			row =wb.getSheet(sheetname).createRow(rowindex);
		}
		XSSFCell cell = wb.getSheet(sheetname).getRow(rowindex).getCell(colindex);
		if(cell==null)
		{
			cell =wb.getSheet(sheetname).getRow(rowindex).createCell(colindex);
		}
		cell.setCellValue(value);
	}
	
	public void saveXlfile(String filename)
	{
		FileOutputStream fout = null;
		try {
			 fout = new FileOutputStream(filename);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			wb.write(fout);
			fout.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Excel has been saved and closed");
	}

}
