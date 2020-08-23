package volSfmCalculator;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class Calendar extends JPanel
{
	private JFrame frame1;
	private JTable table1;
	String[][] data = new String[3][3];
	
	public Calendar()
	{
		frame1 = new JFrame();
		frame1.setTitle("Calendar");
//		String[][] data;
		String[] colNames = {"x", "y", "z"};
		table1 = new JTable(data, colNames);
		table1.setBounds(30, 40, 200, 300);
		JScrollPane sPane = new JScrollPane(table1);
		frame1.add(sPane);
		frame1.setSize(500, 200);
		frame1.setVisible(true);
		
	}

	  // Driver method
	  public static void main(String[] args)
	  {
	    new Calendar();
	  }
}
