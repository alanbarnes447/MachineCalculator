//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.Date;
//
//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.CellStyle;
//import org.apache.poi.ss.usermodel.DataFormat;
//
//public class writeExercize 
//{
//	public static void main(String args[]) throws IOException
//	{
//		HSSFWorkbook workbook = new HSSFWorkbook();
//		HSSFSheet sheet = workbook.createSheet("My First Sheet");
//		HSSFRow row = sheet.createRow(0);
//		HSSFCell cell = row.createCell(0); 
//		cell.setCellValue("1.Cell");
//		
//		cell = row.createCell(1);
//		DataFormat format = workbook.createDataFormat();
//		CellStyle dateStyle = workbook.createCellStyle();
//		dateStyle.setDataFormat(format.getFormat("dd.mm.yyyy"));
//		cell.setCellValue(new Date());
//		
//		row.createCell(2).setCellValue("3.cell");
//		
//		sheet.autoSizeColumn(1);
//		
//		workbook.write(new FileOutputStream("excl.xlsx"));
//		workbook.close();
//	}
//
//}
