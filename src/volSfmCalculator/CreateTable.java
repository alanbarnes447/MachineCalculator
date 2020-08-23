package volSfmCalculator;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.DefaultEditorKit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class CreateTable
{
	
    ///////////////////////////////////////////////////////////////////////////////////////
	//create table method
	//////////////////////////////////////////////////////////////////////////////////////
	
	public static void createToolInfoTable(Object[][] tableModel, Object[] toolTableHeader, JTable newTable, int[] collumnFormat)
	{
				
				newTable.setModel(new DefaultTableModel(tableModel, toolTableHeader));
				

				for(int i = 0; i < newTable.getColumnCount() ; i++)//collumnFormat.length
				{
					newTable.getColumnModel().getColumn(i).setPreferredWidth(collumnFormat[i]);
				}
				
		        for(int i = 0; i < newTable.getRowCount() ; i++)
				{newTable.setRowHeight(i, 25);}
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////
	//Open and save dialog method
	////////////////////////////////////////////////////////////////////////////////////////
	
	public static String openSaveDialog(String extention, int dialogFunc) 
	{
		JFileChooser chooser = new JFileChooser();
		FileFilter txtfilter = new FileNameExtensionFilter("Text Document", "txt");
		FileFilter xlsfilter = new FileNameExtensionFilter("excell file", "xls");
		FileFilter xlsxfilter = new FileNameExtensionFilter("excell file", "xlsx");
		FileFilter javafilter = new FileNameExtensionFilter("Java File", "ser");
		
		if(extention.equalsIgnoreCase("txt"))
		{
			chooser .addChoosableFileFilter(txtfilter);
			chooser.setFileFilter(txtfilter);
		}
		else if(extention.equalsIgnoreCase("xls"))
		{
			chooser .addChoosableFileFilter(xlsfilter);
			chooser.setFileFilter(xlsfilter);
		}
		else if(extention.equalsIgnoreCase("xlsx"))
		{
			chooser .addChoosableFileFilter(xlsxfilter);
			chooser.setFileFilter(xlsxfilter);
		}
		else if(extention.equalsIgnoreCase("ser"))
		{
			chooser .addChoosableFileFilter(javafilter);
			chooser.setFileFilter(javafilter);
		}
	    
		if(dialogFunc == 0)
		{chooser.showSaveDialog(null);}
		else if(dialogFunc == 1)
		{chooser.showOpenDialog(null);}
		
		File f = chooser.getSelectedFile();
		String ff = chooser.getSelectedFile().toString();
		String ex = ff.substring(ff.length() - 4);
	    ex = ex.substring(0,1);
//		JOptionPane.showMessageDialog(null, ex);
		if(extention.equalsIgnoreCase("txt") && dialogFunc == 0 && !ex.equals("."))
		    {f = new File(chooser.getSelectedFile() + ".txt");}
			else if(extention.equalsIgnoreCase("xls") && dialogFunc == 0 && !ex.equals("."))
			{f = new File(chooser.getSelectedFile() + ".xls");}
			else if(extention.equalsIgnoreCase("ser") && dialogFunc == 0 && !ex.equals("."))
			{f = new File(chooser.getSelectedFile() + ".ser");}
		
		String fileName = f.getAbsolutePath();
		return fileName;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	//write to excel method
	////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void writeToExcell(JTable toolTable, JTable HOffsetTable, JTable AllToolInfoTable, Object[] TTheader, Object[] HOheader, Object[] ATheader) throws FileNotFoundException, IOException
	{
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheetTT = workbook.createSheet("Tool Table");
		HSSFSheet sheetHOT = workbook.createSheet("Height Offset Table");
		HSSFSheet sheetATIT = workbook.createSheet("All tool Info Table");
		TableModel TTmodel = toolTable.getModel();
		TableModel HOmodel = HOffsetTable.getModel();
		TableModel ATmodel = AllToolInfoTable.getModel();
		
		////////////////////////////////////////////////////////////////////////
			
			int index = 0;
			int row = 0;
			HSSFRow currentRow = sheetTT.createRow(row);
			for(Object e : TTheader)  //toolTable Header
			{
				HSSFCell Hcell = currentRow.createCell(index);
				Hcell.setCellValue(e.toString());
				index++;
			}
			row++;
			
		for(; row < TTmodel.getRowCount(); row++)  //ToolTable
		{
			currentRow= sheetTT.createRow(row);
			for(int collumn = 0; collumn < TTmodel.getColumnCount(); collumn++)
		        {
				
				HSSFCell ecell = currentRow.createCell(collumn);
				if(TTmodel.getValueAt(row - 1, collumn) != null)
				{
				ecell.setCellValue(TTmodel.getValueAt(row - 1, collumn).toString());
				}
				}
		}
		
		//////////////////////////////////////////////////////////////////////////////
		
			index = 0;
			row = 0;
			HSSFRow currentHRow = sheetHOT.createRow(row);
			for(Object e : HOheader)  //HOffset Header
			{
				HSSFCell Hcell = currentHRow.createCell(index);
				Hcell.setCellValue(e.toString());
				index++;
			}
			
			row++;
		for(; row < HOmodel.getRowCount(); row++)  //HOffset
		{
			HSSFRow erow = sheetHOT.createRow(row);
			for(int collumn = 0; collumn < HOmodel.getColumnCount(); collumn++)
		        {
				
				HSSFCell ecell = erow.createCell(collumn);
				if(HOmodel.getValueAt(row - 1, collumn) != null)
				{
				ecell.setCellValue(HOmodel.getValueAt(row - 1, collumn).toString());
				}
				}
		}
		
		///////////////////////////////////////////////////////////////////////////////
	
			index = 0;
			HSSFRow Hrow = sheetATIT.createRow(0);
			for(Object e : ATheader)  //All Tools  Header
			{
				HSSFCell Hcell = Hrow.createCell(index);
				Hcell.setCellValue(e.toString());
				index++;
			}
		for(row = 1 ; row < ATmodel.getRowCount(); row++) //All Tools
		{
			HSSFRow erow = sheetATIT.createRow(row);
			for(int collumn = 0; collumn < ATmodel.getColumnCount(); collumn++)
		        {
				
				HSSFCell ecell = erow.createCell(collumn);
				if(ATmodel.getValueAt(row - 1, collumn) != null)
				{
				ecell.setCellValue(ATmodel.getValueAt(row - 1, collumn).toString());
				}
				}
		}
		
		////////////////////////////////////////////////////////////////////
		
		String path = CreateTable.openSaveDialog("xls", 0);
		workbook.write(new FileOutputStream(path));
		workbook.close();
	}
	
	////////////////////////////////////////////////////////////////
	//Cut copy paste method
	////////////////////////////////////////////////////////////////
	
	public static void createMenuBar(JMenu mainMenu) 
	{
        JMenuItem menuItem = null;  //add field
//        JMenuBar menuBar = new JMenuBar();
//        JMenu mainMenu = new JMenu("Edit");


        //add this code to the main method
        mainMenu.setMnemonic(KeyEvent.VK_E);

        menuItem = new JMenuItem(new DefaultEditorKit.CutAction());
        menuItem.setText("Cut");
        menuItem.setMnemonic(KeyEvent.VK_T);
        mainMenu.add(menuItem);

        menuItem = new JMenuItem(new DefaultEditorKit.CopyAction());
        menuItem.setText("Copy");
        menuItem.setMnemonic(KeyEvent.VK_C);
        mainMenu.add(menuItem);

        menuItem = new JMenuItem(new DefaultEditorKit.PasteAction());
        menuItem.setText("Paste");
        menuItem.setMnemonic(KeyEvent.VK_P);
        mainMenu.add(menuItem);

//        menuBar.add(mainMenu);
//        return menuBar;
    }
}

/*
try {
    HSSFWorkbook fWorkbook = new HSSFWorkbook();
    HSSFSheet fSheet = fWorkbook.createSheet("new Sheet");
    HSSFFont sheetTitleFont = fWorkbook.createFont();
    File file = new File("/home/kishan/NetBeansProjects/JavaChecking/src/com/verve/SwingChecking/book.xls");
    HSSFCellStyle cellStyle = fWorkbook.createCellStyle();

    sheetTitleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
    //sheetTitleFont.setColor();
    TableModel model = jTable1.getModel();


    for (int i = 0; i < model.getRowCount(); i++) {
        HSSFRow fRow = fSheet.createRow((short) i);
        for (int j = 0; j < model.getColumnCount(); j++) {
            HSSFCell cell = fRow.createCell((short) j);
            cell.setCellValue(model.getValueAt(i, j).toString());
            cell.setCellStyle(cellStyle);

        }

    }
FileOutputStream fileOutputStream;
fileOutputStream = new FileOutputStream(file);
BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream);
fWorkbook.write(bos);
bos.close();
fileOutputStream.close();
}catch(Exception e){

}
*/

/*TableColumnModel tcm = jTable1.getColumnModel();
HSSFRow fRow = fSheet.createRow((short) 0);

for(int j = 0; j < tcm.getColumnCount(); j++) {

   HSSFCell cell = fRow.createCell((short) j);
   cell.setCellValue(tcm.getColumn(j).getHeaderValue().toString());           

}
*/

/*
Object[][] tableModel = new Object[128][5];
int row = 0;
int b = 1;
for(Object[] x : tableModel)
{
	int col = 0;
	int i = 0;
	for(Object a : x)//(int i = 0; i < x.length; i++)
	{
		if(i == 0)
		{tableModel[row][col] = b;}
		else
		{tableModel[row][col] = null;}	
		col++;
		i++;
	}
	row++;
	b++;
}
	//for(int i = 0; i < x.length; i++)
	//{x[0] = i;}
String[] toolTableHeader = new String[] {"T Num", "Diameter", "Tool Length", "Tool Type", "Holder Type"};
int length = 5;
int[] collumnFormat = new int[] {49,60,60,268,320};
AllToolInfoTable.createToolInfoTable(tableModel, toolTableHeader, length, toolTable, collumnFormat);
*/