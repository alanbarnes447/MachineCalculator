package volSfmCalculator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ReadExcell 
{
	public static void readExcelFile(JTable table, int sheetNo, int[] collumnFormat, String fileName)
	{
//		File excel = new File("FileLocation.xls");
		try
		{
		//String excel = CreateTable.openSaveDialog("xls", 1) ;
		String excel = fileName;
		FileInputStream fis = new FileInputStream(excel);
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet ws = wb.getSheetAt(sheetNo);
//		HSSFSheet ws = wb.getSheet("Input");
//		Object[][] tableModel;
//    	Object[] header;
		
		int rowNum = ws.getLastRowNum() + 1;  //add 1 to the last row num because it starts with 0
		int colNum = ws.getRow(0).getLastCellNum(); //collumns start with 1
		Object[][] tableModel = new Object[rowNum][colNum];  
		Object[] header = new Object[colNum];
		int i = 0;
		
//		for(; i < 1; i++)
//		{
			HSSFRow row = ws.getRow(i);   //header row = 0
			    for(int j = 0; j < colNum; j++)
			    {
			    	HSSFCell cell = row.getCell(j);
			    	String value = cellToString(cell);
			    	header[j] = value;         //initialize header value
			    	
			    }
			i++; //i = 1
//		}
//		JOptionPane.showMessageDialog(null, "Header Finished");
		for(; i < rowNum; i++)
		{
//			JOptionPane.showMessageDialog(null, i + ", " + rowNum);
			row = ws.getRow(i);
			    for(int j = 0; j < colNum; j++)
			    {
			    	HSSFCell cell = row.getCell(j);
			    	String value = cellToString(cell);
//			    	JOptionPane.showMessageDialog(null, value);
			    	if(value.equals("0.0") || value.equals("nullValue"))
			    	{tableModel[i-1][j] = null;}
			    	else
			    	{tableModel[i-1][j] = value;}
			    	
			    }
			
		}
		JOptionPane.showMessageDialog(null, "Finished");
		wb.close();
		fis.close();
		CreateTable.createToolInfoTable(tableModel, header, table, collumnFormat);
		
		}
		catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
			
	}
	
	public static String cellToString(HSSFCell cell)
    {
        int type;
        Object result;
        try
        {type = cell.getCellType();}
        catch(Exception e)
        {type = 3;}
//        JOptionPane.showMessageDialog(null, type);
        
        switch(type)
        {
        case 0 : //numeric value in Excel
        	result = cell.getNumericCellValue();
        	break;
        case 1 : //String value in Excel
        	result = cell.getStringCellValue();
        	break;
        case 3 : //empty cell
        	result = "nullValue";
        	break;
        default :
        	result = "nullValue";
//        	throw new RuntimeException("There are no support for this type of cell");
        }
//        if(type = 0 && result = 0)
//        {result = null};
//        
        return result.toString();
        
    }
	
        
}
	


