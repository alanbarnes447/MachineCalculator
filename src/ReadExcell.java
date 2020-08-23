//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//
//import javax.swing.JOptionPane;
//import java.util.*;
//
//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//
//public class ReadExcell 
//{
//	public static void main(String args[]) throws FileNotFoundException, IOException
//	{
//	HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream("excl.xlsx"));
//	HSSFSheet sheet = workbook.getSheetAt(0);
//	HSSFRow row = sheet.getRow(0);
//	String nString = (row.getCell(0).getStringCellValue());
//	//JOptionPane.showMessageDialog(null, nString);
//	if(row.getCell(0).getCellType() == HSSFCell.CELL_TYPE_STRING)
//	{JOptionPane.showMessageDialog(null, row.getCell(0).getStringCellValue());}
//	if(row.getCell(1).getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
//	{JOptionPane.showMessageDialog(null, row.getCell(1).getDateCellValue());}
//	}
//	
//	
//			
//
//}
