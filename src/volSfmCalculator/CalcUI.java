package volSfmCalculator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;

import javax.swing.GroupLayout.Alignment;
import javax.swing.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Canvas;
import java.awt.event.ActionListener;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.file.*;
import java.rmi.server.ObjID;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.*;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.FileChooserUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CalcUI extends JFrame implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu fileMenu = new JMenu("File");
	private JMenu editMenu = new JMenu("Edit");
	private JMenu viewMenu = new JMenu("View");
	
	private JMenu open = new JMenu("open");
	private JMenu save = new JMenu("save");
	private JMenuItem openOption = new JMenuItem("open");
	private JMenuItem saveOption = new JMenuItem("save");
	private JMenuItem savetxtDoc = new JMenuItem("Save text Doc");
	private JMenuItem saveToolTable = new JMenuItem("Save Tool Table");
	private JMenuItem saveSchedule = new JMenuItem("Save Schedule");
	private JMenuItem saveExcellTable = new JMenuItem("Save Table to Excell");
	private JMenuItem openToolTable = new JMenuItem("Open Tool Table");
	private JMenuItem openImportExcelTable = new JMenuItem("OpenExcelTable");
	private JMenuItem openTxtDoc = new JMenuItem("Open Text Doc");
	
	private JMenuItem printOption = new JMenuItem("Print");
//	private JMenuItem openOption = new JMenuItem("Open");
	private JMenuItem mRCalc = new JMenuItem("Calculator");
	private JMenuItem SFMCalc = new JMenuItem("Home");
	private JMenuItem ToolLibrary = new JMenuItem("Tool Library");
	private final JPanel buttonPanel_1 = new JPanel();
	private JPanel HomePanel;
	private JPanel CalcPanel;
	private final JPanel panel = new JPanel();
	private final JPanel SFMpanel = new JPanel();
	private final JPanel RPMpanel = new JPanel();
	private final JPanel FeedRatePanel = new JPanel();
	private final JPanel VRPanel = new JPanel();
	private final JLabel lblStepover = new JLabel("Width of Cut");
	private final JLabel lblDepthOfCut = new JLabel("Depth of Cut");
	private final JLabel lblFeedrate = new JLabel("FeedRate");
	private final JTextField TFStepoverVr = new JTextField();
	private final JTextField TFDocVr = new JTextField();
	private final JTextField TFFrVr = new JTextField();
	private final JLabel lblSfm = new JLabel("SFM");
	private final JLabel lblCutterDiameter = new JLabel("Cutter Dia.");
	private final JTextField TFSfmRpm = new JTextField();
	private final JTextField TFDiaRpm = new JTextField();
	private final JLabel lblSfmSurface = new JLabel("SFM = Surface Feet per Minute");
	private final JLabel lblSfm_1 = new JLabel("RPM = (SFM x 3.82) / Dia");
	private final JLabel lblRpm = new JLabel("RPM");
	private final JLabel lblSfm_2 = new JLabel("FPT");
	private final JLabel lblFeedRpm = new JLabel("Feed = RPM X FPT X T");
	private final JLabel lblFptFeed = new JLabel("FPT = Feed per Tooth");
	private final JLabel lblTNumber = new JLabel("T = Number of teeth in cutter");
	private final JLabel lblT = new JLabel("T");
	private final JTextField TFRpmFr = new JTextField();
	private final JTextField TFFptFr = new JTextField();
	private final JTextField TFTFr = new JTextField();
	private final JLabel lblSfmrpm = new JLabel("SFM = (RPM x D) / 3.82");
	private final JButton FPTButton = new JButton("FPT");
	private final JButton AFPTButton = new JButton("AFPT");
	private final JPanel FPTpanel = new JPanel();
	private JTextField TFIPMfpt;
	private JTextField TFRPMfpt;
	private JTextField TFNumofTeethfpt;
	private JButton btnSFM;
	private JButton btnRPM;
	private JButton btnFeedRate;
	private JButton btnVolumeRemoved;
	private final JTable toolTable = new JTable();
	private JPanel ToolLibraryPanel;
	private final JTextArea textPane = new JTextArea();
	private JScrollPane scrollPane_1;
	private JTable table;
	private JTable[] tableArry = new JTable[128];
	private JScrollPane[] scrollPaneArry = new JScrollPane[128];
	private final JPanel panel_2 = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JPanel ToolNum12H = new JPanel();
	private final JPanel ToolNum13H = new JPanel();
	private JPanel[] panelArry =  new JPanel[128];
	private final JPanel ToolNum43H = new JPanel();
	private final JScrollPane scrollPane_2 = new JScrollPane();
	private final JTable table_1 = new JTable();
	private final JScrollPane scrollPane_3 = new JScrollPane();
	private final JTable table_2 = new JTable();
	private final JScrollPane scrollPane_4 = new JScrollPane();
	private final JTable table_3 = new JTable();
	private JTextField toolNoTF;
	private final JButton btnTHValues = new JButton("T43 H Values");
	private final JButton btnTHValues_1 = new JButton("T13 H values");
	private final JButton btnTHValues_2 = new JButton("T12 H values");
	private final JButton btnAllHValues = new JButton("All H Values");
	private final JPanel AllHValuesPanel = new JPanel();
	private final JScrollPane scrollPane_5 = new JScrollPane();
	private final JTable table_4 = new JTable();
	private final JButton btnToolTable = new JButton("Tool Table");
	private JPanel tablePanel;
	private JPanel tableCardPanel;
	private final JLabel toolNumLbl = new JLabel("None");
	private JButton btnGo;
	private final JButton scheduleBtn = new JButton("Schedule");
	private final JPanel panel_3 = new JPanel();
	private final JPanel panel_6 = new JPanel();
	private final JPanel panel_7 = new JPanel();
	private JLabel toolNumTL = new JLabel("Tool Number: ");
	private JTextField toolNumTF = new JTextField();
	private JLabel toolDiaTL = new JLabel("Diameter: ");
	private JTextField toolDiaTF = new JTextField();
	private JLabel toolTypeTL =  new JLabel("Tool Type: ");
	private JTextField toolTypeTF = new JTextField();
	private JLabel holderTypeTL =  new JLabel("Holder Type: ");
	private JTextField holderTypeTF = new JTextField();
	private JLabel toolHNumTL = new JLabel("H Number: ");
	private JTextField toolHNumTF = new JTextField();
	private JLabel toolDescTL =  new JLabel("tool Description");
	private JTextField toolDescTypeTF = new JTextField();
	private JLabel notesTL = new JLabel("Notes: ");
	private JTextField notesTF = new JTextField();
	private Object[] row = new Object[4];
	private Object[] row2 = new Object[2];
	private DefaultTableModel tableModel = new DefaultTableModel();
	private DefaultTableModel hValueModel = new DefaultTableModel();
	private DefaultTableModel t12Model = new DefaultTableModel();
	private DefaultTableModel t13Model = new DefaultTableModel();
	private DefaultTableModel t43Model = new DefaultTableModel();

	
	
	private JButton btnUpdate;
	private JButton btnAdd;
	private JButton btnDelete;
	private JPanel panel_4;
	private JButton btnInsert;
	private JButton btnCalculate;
	private final JLabel lblRpm_3 = new JLabel("RPM");
	private final JLabel lblDiameter = new JLabel("Diameter");
	private JTextField TFRpmSfm;
	private JTextField TFDiaSfm;
	private JLabel JLSFM;
	private JLabel JLFR;
	private JLabel JLRPM;
	private JLabel JLVR;
	private JLabel JLFpt;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private final JPanel toolTableSortPanel = new JPanel();
	private final JButton btnAllToolInfo = new JButton("All Tool Info");
	private final JPanel panel_10 = new JPanel();
	private JButton dapraBtn;
	private JButton endmillBtn;
	private JButton pipeDrillBtn;
	private JButton pipeTapBtn;
	private JButton ThreadMillBtn;
	private JButton btnDrillAndTap;
	private JButton MinimillBtn;
	private JButton CbreBtn;
	private JButton spadeBtn;
	private JButton specialBtn;
	private JButton FaceMillBtn;
	private JPanel TopCardPanel;
	private JPanel MiddleCardPanel;
	private JPanel BottomCardPanel;
	private final JPanel allToolInfoPanel = new JPanel();
	private JTable allToolInfoTable;
	private JButton btnOddTooling;
	private JLabel tablelbl;
	private JTable tableToSave;
    JTable currentTable = toolTable;
    int tableNum = 2;

	private String ScheduleLink;
	private String alliedLink;
	private String WDOLink;
	private final JButton proceduresbtn = new JButton("Procedures");
	private final JPanel schedulePanel = new JPanel();
	private final JPanel homePanel = new JPanel();
	private final JPanel procedurePanel = new JPanel();
	private final JButton btnNewButton_1 = new JButton("Start Job");
	private final JButton btnNewButton_2 = new JButton("End Job");
	private JTextField textField_6;
	private JTextField textField_7;
	private JTable table_5;
	private final JPanel panel_11 = new JPanel();
	private final JLabel lblNewLabel_4 = new JLabel("Time");
	private final JLabel lblDay = new JLabel("Day");
	private final JLabel lblDate = new JLabel("Date");
	private final JScrollPane scrollPane_8 = new JScrollPane();
	private final JTable table_6 = new JTable();
	private final JPanel panel_12 = new JPanel();
	private final JScrollPane scrollPane_9 = new JScrollPane();
	private final JTable table_7 = new JTable();
	private final JLabel lblSouthMachine = new JLabel("South Machine");
	private final JLabel lblNorthMachine = new JLabel("North Machine");
	private final JButton btnInsert_1 = new JButton("Insert");
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
//	private String 
	private JButton homeButton = new JButton("Home");
	private final JButton btnCloseDatabase = new JButton("Close Database");
	private final JButton btnOpenDatabase = new JButton("Open Database");
	private final JLabel lblProgramming = new JLabel("Programming");
	private final JPanel panel_13 = new JPanel();
	private final JScrollPane scrollPane_10 = new JScrollPane();
	private final JTable table_8 = new JTable();
	private final JPanel ScheduleControlPanel = new JPanel();
	private final JPanel panel_14 = new JPanel();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalcUI frame = new CalcUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CalcUI() {
		panel_12.setLayout(new CardLayout(0, 0));
		
		panel_12.add(scrollPane_9, "name_1225834185283830");
		table_7.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Job Num", "Part Name", "Work To Be done", "Priority"
			}
		));
		table_7.getColumnModel().getColumn(0).setPreferredWidth(20);
		
		scrollPane_9.setViewportView(table_7);
		toolNumLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		TFTFr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		
		TFTFr.setColumns(10);
		TFFptFr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		TFFptFr.setColumns(10);
		TFRpmFr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		TFRpmFr.setColumns(10);
		TFDiaRpm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		TFDiaRpm.setColumns(10);
		TFSfmRpm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		TFSfmRpm.setColumns(10);
		TFFrVr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		TFFrVr.setColumns(10);
		TFDocVr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		TFDocVr.setColumns(10);
		TFStepoverVr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		TFStepoverVr.setColumns(10);
		initComponents();
		createEvents();
		ToolLibraryPanel.setVisible(false);
		HomePanel.setVisible(true);
		CalcPanel.setVisible(false);
		
		
		

	}

	

	private void initComponents() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 786);
		
		menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(viewMenu);
		
		//add cut copy and paste to project
		CreateTable.createMenuBar(editMenu);
		
		fileMenu.add(open);
		fileMenu.add(save);
		open.add(openTxtDoc);
		open.add(openToolTable);
		
		open.add(openImportExcelTable);
		
		save.add(saveOption);
		save.add(saveSchedule);
		save.add(savetxtDoc);
		save.add(saveToolTable);
		save.add(saveExcellTable);
		fileMenu.add(printOption);
		
		viewMenu.add(mRCalc);
		viewMenu.add(SFMCalc);
		viewMenu.add(ToolLibrary);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		HomePanel = new JPanel();
		contentPane.add(HomePanel, "name_174728813737785");
		
		JPanel HomeCardPanel = new JPanel();
		
		
		
		
		JButton btnGetData = new JButton("Get Data");
		
		JButton btnSaveData = new JButton("Save Data");
		GroupLayout gl_HomePanel = new GroupLayout(HomePanel);
		gl_HomePanel.setHorizontalGroup(
			gl_HomePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_HomePanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_HomePanel.createParallelGroup(Alignment.LEADING)
						.addComponent(HomeCardPanel, GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
						.addGroup(gl_HomePanel.createSequentialGroup()
							.addComponent(homeButton)
							.addGap(10)
							.addComponent(scheduleBtn)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(proceduresbtn)
							.addPreferredGap(ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
							.addComponent(btnOpenDatabase)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCloseDatabase)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSaveData)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnGetData)))
					.addContainerGap())
		);
		gl_HomePanel.setVerticalGroup(
			gl_HomePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_HomePanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_HomePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(proceduresbtn)
						.addComponent(scheduleBtn)
						.addComponent(homeButton)
						.addComponent(btnGetData)
						.addComponent(btnSaveData)
						.addComponent(btnCloseDatabase)
						.addComponent(btnOpenDatabase))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(HomeCardPanel, GroupLayout.PREFERRED_SIZE, 645, Short.MAX_VALUE)
					.addContainerGap())
		);
		HomeCardPanel.setLayout(new CardLayout(0, 0));
		
		HomeCardPanel.add(homePanel, "name_1954668806074925");
		
		JPanel calendarPanel = new JPanel();
		
		JPanel calendarButtonPanel = new JPanel();
		GroupLayout gl_homePanel = new GroupLayout(homePanel);
		gl_homePanel.setHorizontalGroup(
			gl_homePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_homePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(calendarPanel, GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
					.addGap(12)
					.addComponent(calendarButtonPanel, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_homePanel.setVerticalGroup(
			gl_homePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_homePanel.createSequentialGroup()
					.addGroup(gl_homePanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_homePanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(calendarPanel, GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE))
						.addGroup(gl_homePanel.createSequentialGroup()
							.addGap(12)
							.addComponent(calendarButtonPanel, GroupLayout.PREFERRED_SIZE, 620, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		GroupLayout gl_calendarPanel = new GroupLayout(calendarPanel);
		gl_calendarPanel.setHorizontalGroup(
			gl_calendarPanel.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 566, Short.MAX_VALUE)
		);
		gl_calendarPanel.setVerticalGroup(
			gl_calendarPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 619, Short.MAX_VALUE)
		);
		calendarPanel.setLayout(gl_calendarPanel);
		homePanel.setLayout(gl_homePanel);
		
		HomeCardPanel.add(schedulePanel, "name_1954632826399810");
		
		JPanel panel_5 = new JPanel();
		
		JRadioButton rdbtnNortMachine = new JRadioButton("North Machine");
		
		JButton btnNewButton_3 = new JButton("Modify");
		
		JButton btnDelete_1 = new JButton("Delete");
		GroupLayout gl_schedulePanel = new GroupLayout(schedulePanel);
		gl_schedulePanel.setHorizontalGroup(
			gl_schedulePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_schedulePanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_schedulePanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_schedulePanel.createSequentialGroup()
							.addComponent(ScheduleControlPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(7))
						.addComponent(btnInsert_1)
						.addGroup(gl_schedulePanel.createSequentialGroup()
							.addComponent(btnNewButton_3)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_schedulePanel.createSequentialGroup()
							.addComponent(btnDelete_1)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_schedulePanel.createSequentialGroup()
							.addComponent(rdbtnNortMachine)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addComponent(panel_14, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_schedulePanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_schedulePanel.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_schedulePanel.createSequentialGroup()
								.addGap(109)
								.addComponent(lblSouthMachine)
								.addPreferredGap(ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
								.addComponent(lblNorthMachine)
								.addGap(139))
							.addGroup(gl_schedulePanel.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_schedulePanel.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_schedulePanel.createSequentialGroup()
										.addGap(5)
										.addComponent(panel_13, GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE))
									.addGroup(gl_schedulePanel.createSequentialGroup()
										.addGap(34)
										.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE))
									.addGroup(gl_schedulePanel.createSequentialGroup()
										.addComponent(panel_12, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(panel_11, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)))
								.addContainerGap()))
						.addGroup(gl_schedulePanel.createSequentialGroup()
							.addGap(295)
							.addComponent(lblProgramming)
							.addContainerGap())))
		);
		gl_schedulePanel.setVerticalGroup(
			gl_schedulePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_schedulePanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_schedulePanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_schedulePanel.createSequentialGroup()
							.addGroup(gl_schedulePanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_schedulePanel.createSequentialGroup()
									.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_schedulePanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblSouthMachine)
										.addComponent(lblNorthMachine))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_schedulePanel.createParallelGroup(Alignment.TRAILING)
										.addComponent(panel_12, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
										.addComponent(panel_11, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblProgramming)
									.addGap(10)
									.addComponent(panel_13, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
								.addGroup(gl_schedulePanel.createSequentialGroup()
									.addComponent(ScheduleControlPanel, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(panel_14, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(rdbtnNortMachine)
									.addGap(12)
									.addComponent(btnInsert_1)
									.addGap(39)
									.addComponent(btnDelete_1)))
							.addGap(33))
						.addGroup(gl_schedulePanel.createSequentialGroup()
							.addComponent(btnNewButton_3)
							.addGap(65))))
		);
		
		JLabel lblJobNum = new JLabel("Job Num");
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		
		JLabel lblPartName_1 = new JLabel("Part Name");
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		
		JLabel lblTypeOfWork = new JLabel("Work Type");
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		
		JLabel lblPriority = new JLabel("Priority");
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"High", "Low"}));
		
		JRadioButton rdbtnSouthMachine = new JRadioButton("South Machine");
		GroupLayout gl_panel_14 = new GroupLayout(panel_14);
		gl_panel_14.setHorizontalGroup(
			gl_panel_14.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_14.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_14.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnSouthMachine)
						.addGroup(gl_panel_14.createSequentialGroup()
							.addComponent(lblJobNum)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_14.createSequentialGroup()
							.addComponent(lblPartName_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_14.createSequentialGroup()
							.addComponent(lblTypeOfWork)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_14.createSequentialGroup()
							.addComponent(lblPriority)
							.addGap(18)
							.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_14.setVerticalGroup(
			gl_panel_14.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_14.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_14.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblJobNum)
						.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_14.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPartName_1)
						.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_14.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTypeOfWork)
						.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_14.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPriority)
						.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnSouthMachine)
					.addContainerGap(24, Short.MAX_VALUE))
		);
		panel_14.setLayout(gl_panel_14);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"South Machine", "North Machine", "Programming"}));
		
		JLabel lblMachine = new JLabel("Machine");
		
		JLabel lblPartName = new JLabel("Part Name");
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		JLabel lblJobNo = new JLabel("Job No.");
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		GroupLayout gl_ScheduleControlPanel = new GroupLayout(ScheduleControlPanel);
		gl_ScheduleControlPanel.setHorizontalGroup(
			gl_ScheduleControlPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_ScheduleControlPanel.createSequentialGroup()
					.addGroup(gl_ScheduleControlPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_ScheduleControlPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_2))
						.addGroup(gl_ScheduleControlPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblJobNo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_ScheduleControlPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblPartName)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_ScheduleControlPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblMachine)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_ScheduleControlPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_4)
					.addContainerGap(164, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_ScheduleControlPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDay)
					.addContainerGap(172, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_ScheduleControlPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDate)
					.addContainerGap(167, Short.MAX_VALUE))
		);
		gl_ScheduleControlPanel.setVerticalGroup(
			gl_ScheduleControlPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_ScheduleControlPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_ScheduleControlPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_ScheduleControlPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblJobNo)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_ScheduleControlPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPartName)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_ScheduleControlPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMachine)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblDay)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblDate)
					.addContainerGap(98, Short.MAX_VALUE))
		);
		ScheduleControlPanel.setLayout(gl_ScheduleControlPanel);
		panel_13.setLayout(new CardLayout(0, 0));
		
		panel_13.add(scrollPane_10, "name_1396899117804753");
		table_8.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, "", null},
				{null, null, null, null},
			},
			new String[] {
				"Job no.", "Part Name", "Work to be done", "Priority"
			}
		));
		table_8.getColumnModel().getColumn(0).setPreferredWidth(20);
		
		scrollPane_10.setViewportView(table_8);
		panel_11.setLayout(new CardLayout(0, 0));
		
		panel_11.add(scrollPane_8, "name_1225513931076504");
		table_6.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Job Num", "Part Name", "Work to be done", "priority"
			}
		));
		table_6.getColumnModel().getColumn(0).setPreferredWidth(20);
		
		scrollPane_8.setViewportView(table_6);
		panel_5.setLayout(new CardLayout(0, 0));
		
		JScrollPane scrollPane_7 = new JScrollPane();
		panel_5.add(scrollPane_7, "name_1050075925063161");
		
		table_5 = new JTable();
		table_5.setModel(new DefaultTableModel(
			new Object[][] {
				{"6:00", null, null, null},
				{"6:30", null, null, null},
				{"7:00", null, null, null},
				{"7:30", null, null, null},
				{"8:00", null, null, null},
				{"8:30", null, null, null},
				{"9:00", null, null, null},
				{"9:30", null, null, null},
				{"10:00", null, null, null},
				{"10:30", null, null, null},
				{"11:00", null, null, null},
				{"11:30", null, null, null},
				{"12:00", null, null, null},
				{"12:30", null, null, null},
				{"1:00", null, null, null},
				{"1:30", null, null, null},
				{"2:00", null, null, null},
				{"2:30", null, null, null},
				{"3:00", null, null, null},
				{"3:30", null, null, null},
				{"4:00", null, null, null},
				{"4:30", null, null, null},
				{"5:00", null, null, null},
				{"5:30", null, null, null},
				{"6:00", null, null, null},
			},
			new String[] {
				"Time", "South Machine", "North Machine", "Programming"
			}
		));
		table_5.getColumnModel().getColumn(0).setResizable(false);
		table_5.getColumnModel().getColumn(0).setPreferredWidth(15);
		table_5.getColumnModel().getColumn(1).setPreferredWidth(100);
		table_5.getColumnModel().getColumn(2).setPreferredWidth(100);
		table_5.getColumnModel().getColumn(3).setPreferredWidth(100);
		scrollPane_7.setViewportView(table_5);
		schedulePanel.setLayout(gl_schedulePanel);
		
		HomeCardPanel.add(procedurePanel, "name_1954687293312806");
		HomePanel.setLayout(gl_HomePanel);
		
		CalcPanel = new JPanel();
		contentPane.add(CalcPanel, "name_174599580931729");
		
		JScrollPane scrollPane = new JScrollPane();
		
		btnCalculate = new JButton("Calculate");
		btnCalculate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GroupLayout gl_CalcPanel = new GroupLayout(CalcPanel);
		gl_CalcPanel.setHorizontalGroup(
			gl_CalcPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_CalcPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_CalcPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonPanel_1, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_CalcPanel.createSequentialGroup()
							.addComponent(btnCalculate, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 164, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_CalcPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_9, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_CalcPanel.setVerticalGroup(
			gl_CalcPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_CalcPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_CalcPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
						.addGroup(gl_CalcPanel.createSequentialGroup()
							.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_9, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 276, Short.MAX_VALUE))
						.addGroup(gl_CalcPanel.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 212, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(buttonPanel_1, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCalculate, GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE)
							.addGap(273)))
					.addGap(0))
		);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"6 Inch Iscar 45 ", "3 Inch Helidoo", "4 Inch Helidoo"}));
		
		JLabel lblToolType = new JLabel("Tool Type");
		lblToolType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_3 = new JLabel("Material");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"P-20", "holderBlock", "H-13", "s-7"}));
		
		JButton btnGetInfo = new JButton("Get Info");
		btnGetInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_panel_9 = new GroupLayout(panel_9);
		gl_panel_9.setHorizontalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_9.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_9.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_9.createSequentialGroup()
							.addGroup(gl_panel_9.createParallelGroup(Alignment.LEADING)
								.addComponent(lblToolType)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel_9.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_3)
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(btnGetInfo))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		gl_panel_9.setVerticalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_9.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_9.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblToolType)
						.addComponent(lblNewLabel_3))
					.addGap(14)
					.addGroup(gl_panel_9.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnGetInfo)
					.addContainerGap(78, Short.MAX_VALUE))
		);
		panel_9.setLayout(gl_panel_9);
		
		JLabel lblToolNum = new JLabel("Tool Num: ");
		lblToolNum.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblToolDia = new JLabel("Tool Dia: ");
		lblToolDia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblRpm_4 = new JLabel("RPM: ");
		lblRpm_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblSfm_4 = new JLabel("SFM: ");
		lblSfm_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblFeedRate_1 = new JLabel("Feed Rate: ");
		lblFeedRate_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblFpt_1 = new JLabel("FPT: ");
		lblFpt_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_5.setColumns(10);
		
		JButton btnUpdate_1 = new JButton("Update");
		btnUpdate_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8.setHorizontalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_8.createParallelGroup(Alignment.LEADING)
						.addComponent(lblToolNum)
						.addGroup(gl_panel_8.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblSfm_4)
							.addComponent(lblFeedRate_1)
							.addComponent(lblRpm_4)
							.addComponent(lblToolDia)
							.addComponent(lblFpt_1)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_8.createParallelGroup(Alignment.LEADING)
						.addComponent(btnUpdate_1)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(61, Short.MAX_VALUE))
		);
		gl_panel_8.setVerticalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_8.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblToolNum)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_8.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblToolDia)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_8.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRpm_4)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_8.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSfm_4)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_8.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFeedRate_1)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_8.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFpt_1)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
					.addComponent(btnUpdate_1)
					.addContainerGap())
		);
		panel_8.setLayout(gl_panel_8);
		buttonPanel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		scrollPane.setViewportView(textPane);
		panel.setLayout(new CardLayout(0, 0));
		SFMpanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		panel.add(SFMpanel, "name_262152854873454");
		
		JLabel lblSfm_3 = new JLabel("SFM");
		lblSfm_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLSFM = new JLabel("=");
		JLSFM.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		TFRpmSfm = new JTextField();
		TFRpmSfm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		TFRpmSfm.setColumns(10);
		
		TFDiaSfm = new JTextField();
		TFDiaSfm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		TFDiaSfm.setColumns(10);
		GroupLayout gl_SFMpanel = new GroupLayout(SFMpanel);
		gl_SFMpanel.setHorizontalGroup(
			gl_SFMpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_SFMpanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_SFMpanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSfmrpm)
						.addGroup(gl_SFMpanel.createSequentialGroup()
							.addComponent(lblSfm_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(JLSFM))
						.addGroup(gl_SFMpanel.createSequentialGroup()
							.addGroup(gl_SFMpanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblRpm_3)
								.addComponent(lblDiameter))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_SFMpanel.createParallelGroup(Alignment.LEADING)
								.addComponent(TFDiaSfm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(TFRpmSfm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(52, Short.MAX_VALUE))
		);
		lblRpm_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDiameter.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSfmrpm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		gl_SFMpanel.setVerticalGroup(
			gl_SFMpanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_SFMpanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_SFMpanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSfm_3)
						.addComponent(JLSFM))
					.addGap(18)
					.addGroup(gl_SFMpanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRpm_3)
						.addComponent(TFRpmSfm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_SFMpanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDiameter)
						.addComponent(TFDiaSfm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
					.addComponent(lblSfmrpm)
					.addContainerGap())
		);
		SFMpanel.setLayout(gl_SFMpanel);
		RPMpanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		panel.add(RPMpanel, "name_262224270356540");
		
		JLabel lblRpm_2 = new JLabel("RPM");
		lblRpm_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLRPM = new JLabel("=");
		JLRPM.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_RPMpanel = new GroupLayout(RPMpanel);
		gl_RPMpanel.setHorizontalGroup(
			gl_RPMpanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_RPMpanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_RPMpanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSfmSurface)
						.addComponent(lblSfm_1)
						.addGroup(gl_RPMpanel.createSequentialGroup()
							.addComponent(lblCutterDiameter)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(TFDiaRpm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(19, Short.MAX_VALUE))
				.addGroup(gl_RPMpanel.createSequentialGroup()
					.addContainerGap(53, Short.MAX_VALUE)
					.addComponent(lblSfm)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(TFSfmRpm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18))
				.addGroup(gl_RPMpanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblRpm_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(JLRPM)
					.addContainerGap(199, Short.MAX_VALUE))
		);
		gl_RPMpanel.setVerticalGroup(
			gl_RPMpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_RPMpanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_RPMpanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRpm_2)
						.addComponent(JLRPM))
					.addGap(24)
					.addGroup(gl_RPMpanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSfm)
						.addComponent(TFSfmRpm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_RPMpanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCutterDiameter)
						.addComponent(TFDiaRpm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addComponent(lblSfmSurface)
					.addGap(10)
					.addComponent(lblSfm_1)
					.addContainerGap())
		);
		lblSfmSurface.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSfm_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSfm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCutterDiameter.setFont(new Font("Tahoma", Font.PLAIN, 16));
		RPMpanel.setLayout(gl_RPMpanel);
		FeedRatePanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		panel.add(FeedRatePanel, "name_262235828952121");
		
		JLabel lblFeedRate = new JLabel("Feed Rate");
		lblFeedRate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLFR = new JLabel("=");
		JLFR.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_FeedRatePanel = new GroupLayout(FeedRatePanel);
		gl_FeedRatePanel.setHorizontalGroup(
			gl_FeedRatePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_FeedRatePanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_FeedRatePanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFeedRpm)
						.addComponent(lblFptFeed)
						.addGroup(gl_FeedRatePanel.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_FeedRatePanel.createSequentialGroup()
								.addGroup(gl_FeedRatePanel.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblSfm_2)
									.addComponent(lblRpm))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_FeedRatePanel.createParallelGroup(Alignment.LEADING)
									.addComponent(TFRpmFr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(TFFptFr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_FeedRatePanel.createSequentialGroup()
								.addComponent(lblT)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(TFTFr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addComponent(lblTNumber))
						.addGroup(gl_FeedRatePanel.createSequentialGroup()
							.addComponent(lblFeedRate)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(JLFR)))
					.addContainerGap(56, Short.MAX_VALUE))
		);
		lblRpm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSfm_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		gl_FeedRatePanel.setVerticalGroup(
			gl_FeedRatePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_FeedRatePanel.createSequentialGroup()
					.addGap(7)
					.addGroup(gl_FeedRatePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFeedRate)
						.addComponent(JLFR))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_FeedRatePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(TFRpmFr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRpm))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_FeedRatePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(TFFptFr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSfm_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_FeedRatePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(TFTFr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblT, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblTNumber)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblFptFeed)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblFeedRpm)
					.addContainerGap())
		);
		FeedRatePanel.setLayout(gl_FeedRatePanel);
		VRPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		panel.add(VRPanel, "name_262583073353773");
		
		JLabel lblVolRemoved = new JLabel("VR Rate");
		lblVolRemoved.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLVR = new JLabel("=");
		JLVR.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1 = new JLabel("DOC X WOC X FeedRate = Cubic In/ Min");
		
		JLabel lblVolumeOfMaterial = new JLabel("Volume of material Removed");
		lblVolumeOfMaterial.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_VRPanel = new GroupLayout(VRPanel);
		gl_VRPanel.setHorizontalGroup(
			gl_VRPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_VRPanel.createSequentialGroup()
					.addGroup(gl_VRPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_VRPanel.createSequentialGroup()
							.addGroup(gl_VRPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_VRPanel.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblStepover))
								.addGroup(gl_VRPanel.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblDepthOfCut))
								.addGroup(gl_VRPanel.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblFeedrate)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_VRPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(TFFrVr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(TFDocVr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(TFStepoverVr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_VRPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblVolRemoved)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(JLVR))
						.addGroup(gl_VRPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblVolumeOfMaterial))
						.addGroup(gl_VRPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_1)))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		gl_VRPanel.setVerticalGroup(
			gl_VRPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_VRPanel.createSequentialGroup()
					.addGap(8)
					.addComponent(lblVolumeOfMaterial)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_VRPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(JLVR)
						.addComponent(lblVolRemoved))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_VRPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(TFStepoverVr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblStepover))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_VRPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(TFDocVr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDepthOfCut))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_VRPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(TFFrVr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFeedrate))
					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1)
					.addContainerGap())
		);
		lblStepover.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDepthOfCut.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFeedrate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		VRPanel.setLayout(gl_VRPanel);
		FPTpanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		panel.add(FPTpanel, "name_264388779947363");
		
		JLabel lblFpt = new JLabel("FPT = IPM/(RPM X T)");
		lblFpt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblFeedPerTooth = new JLabel("Feed Per tooth");
		lblFeedPerTooth.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel = new JLabel("IPM");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblRpm_1 = new JLabel("RPM");
		lblRpm_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNumOfTeeth = new JLabel("Num Teeth");
		lblNumOfTeeth.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		TFIPMfpt = new JTextField();
		TFIPMfpt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		TFIPMfpt.setColumns(10);
		
		TFRPMfpt = new JTextField();
		TFRPMfpt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		TFRPMfpt.setColumns(10);
		
		TFNumofTeethfpt = new JTextField();
		TFNumofTeethfpt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		TFNumofTeethfpt.setColumns(10);
		
		JLFpt = new JLabel("=");
		JLFpt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		GroupLayout gl_FPTpanel = new GroupLayout(FPTpanel);
		gl_FPTpanel.setHorizontalGroup(
			gl_FPTpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_FPTpanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_FPTpanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFpt)
						.addGroup(gl_FPTpanel.createSequentialGroup()
							.addComponent(lblFeedPerTooth)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(JLFpt))
						.addGroup(gl_FPTpanel.createSequentialGroup()
							.addGroup(gl_FPTpanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNumOfTeeth)
								.addComponent(lblRpm_1)
								.addComponent(lblNewLabel))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_FPTpanel.createParallelGroup(Alignment.LEADING)
								.addComponent(TFRPMfpt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(TFNumofTeethfpt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(TFIPMfpt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		gl_FPTpanel.setVerticalGroup(
			gl_FPTpanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_FPTpanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_FPTpanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFeedPerTooth)
						.addComponent(JLFpt))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_FPTpanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(TFIPMfpt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_FPTpanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRpm_1)
						.addComponent(TFRPMfpt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_FPTpanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumOfTeeth)
						.addComponent(TFNumofTeethfpt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
					.addComponent(lblFpt)
					.addContainerGap())
		);
		FPTpanel.setLayout(gl_FPTpanel);
		buttonPanel_1.setLayout(new GridLayout(3, 2, 5, 5));
		
		btnRPM = new JButton("RPM");
		btnRPM.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		buttonPanel_1.add(btnRPM);
		
		btnSFM = new JButton("SFM");
		btnSFM.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		buttonPanel_1.add(btnSFM);
		
		btnFeedRate = new JButton("Feed Rate");
		btnFeedRate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		buttonPanel_1.add(btnFeedRate);
		
		btnVolumeRemoved = new JButton("V-Rem");
		btnVolumeRemoved.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		buttonPanel_1.add(btnVolumeRemoved);
		FPTButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		
		buttonPanel_1.add(FPTButton);
		AFPTButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		
		buttonPanel_1.add(AFPTButton);
//		panel_2.add(comp, constraints);
		
		
		CalcPanel.setLayout(gl_CalcPanel);
		
		contentPane.add(panel_2, "name_819784113625274");
		
		ToolLibraryPanel = new JPanel();
		contentPane.add(ToolLibraryPanel, "name_213501960861817");
		
		tableCardPanel = new JPanel();
		TopCardPanel = new JPanel();
		MiddleCardPanel = new JPanel();
		BottomCardPanel = new JPanel();
		
		tablelbl = new JLabel("Table");
		tablelbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		GroupLayout gl_ToolLibraryPanel = new GroupLayout(ToolLibraryPanel);
		gl_ToolLibraryPanel.setHorizontalGroup(
			gl_ToolLibraryPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ToolLibraryPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_ToolLibraryPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_ToolLibraryPanel.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE)
							.addGap(13)
							.addComponent(tableCardPanel, GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_ToolLibraryPanel.createSequentialGroup()
							.addComponent(tablelbl)
							.addGap(242))))
		);
		gl_ToolLibraryPanel.setVerticalGroup(
			gl_ToolLibraryPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ToolLibraryPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(tablelbl)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_ToolLibraryPanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel_1, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(tableCardPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		
		panel_4 = new JPanel();
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(toolTableSortPanel, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
							.addComponent(panel_7, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addComponent(panel_10, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(11)
					.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(toolTableSortPanel, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
					.addGap(58))
		);
		panel_10.setLayout(new GridLayout(3, 1, 2, 2));
		
		
		panel_10.add(btnToolTable);
		btnToolTable.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_10.add(btnAllHValues);
		btnAllHValues.setFont(new Font("Tahoma", Font.PLAIN, 16));
		toolTableSortPanel.setLayout(new GridLayout(6, 6, 2, 2));
		panel_10.add(btnAllToolInfo);
		btnAllToolInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		
		
		dapraBtn = new JButton("Dapra");
		dapraBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		toolTableSortPanel.add(dapraBtn);
		
		MinimillBtn = new JButton("MiniMill");
		
		MinimillBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		toolTableSortPanel.add(MinimillBtn);
		
		endmillBtn = new JButton("EndMills");
		
		endmillBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		toolTableSortPanel.add(endmillBtn);
		
		CbreBtn = new JButton("CounterBoring");
		
		CbreBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		toolTableSortPanel.add(CbreBtn);
		
		pipeDrillBtn = new JButton("PipeDrills");
		
		pipeDrillBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		toolTableSortPanel.add(pipeDrillBtn);
		
		spadeBtn = new JButton("SpadeDrills");
		
		spadeBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		toolTableSortPanel.add(spadeBtn);
		
		pipeTapBtn = new JButton("PipeTaps");
		
		pipeTapBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		toolTableSortPanel.add(pipeTapBtn);
		
		specialBtn = new JButton("Special");
		
		specialBtn.setFont(new Font("Dialog", Font.PLAIN, 16));
		toolTableSortPanel.add(specialBtn);
		
		ThreadMillBtn = new JButton("ThreadMills");
		
		ThreadMillBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		toolTableSortPanel.add(ThreadMillBtn);
		
		FaceMillBtn = new JButton("FaceMills");
		
		FaceMillBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		toolTableSortPanel.add(FaceMillBtn);
		
		btnDrillAndTap = new JButton("Drill and Tap");
		
		btnDrillAndTap.setFont(new Font("Tahoma", Font.PLAIN, 16));
		toolTableSortPanel.add(btnDrillAndTap);
		
		btnOddTooling = new JButton("Odd Tooling");
		
		btnOddTooling.setFont(new Font("Tahoma", Font.PLAIN, 16));
		toolTableSortPanel.add(btnOddTooling);
		panel_6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_4.setLayout(new GridLayout(4, 2, 5, 5));
		toolNumTL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
//		panel_4.setLayout(new GridLayout(4,2,2,2));
		panel_4.add(toolNumTL);
		toolNumTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_4.add(toolNumTF);
		toolDiaTL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_4.add(toolDiaTL);
		toolDiaTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_4.add(toolDiaTF);
		toolTypeTL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_4.add(toolTypeTL);
		toolTypeTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_4.add(toolTypeTF);
		holderTypeTL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_4.add(holderTypeTL);
		holderTypeTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_4.add(holderTypeTF);
		
		toolHNumTL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		toolHNumTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		toolDiaTL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		toolDiaTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		toolDescTL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		toolDescTypeTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		notesTL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		notesTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		
		JLabel lblToolNumber = new JLabel("Tool Number:");
		lblToolNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_2 = new JLabel("Tool:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		toolNoTF = new JTextField();
		toolNoTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		toolNoTF.setColumns(10);
		
		btnGo = new JButton("Go");
		btnGo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_7.createSequentialGroup()
							.addComponent(lblToolNumber)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(toolNoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addComponent(btnGo))
						.addGroup(gl_panel_7.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(toolNumLbl)))
					.addContainerGap(59, Short.MAX_VALUE))
		);
		gl_panel_7.setVerticalGroup(
			gl_panel_7.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_7.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(toolNumLbl))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblToolNumber)
						.addComponent(toolNoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnGo))
					.addContainerGap(34, Short.MAX_VALUE))
		);
		panel_7.setLayout(gl_panel_7);
		
		btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_6.setLayout(new GridLayout(4, 1, 5, 5));
		panel_6.add(btnAdd);
		
		btnInsert = new JButton("Insert");
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_6.add(btnInsert);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_6.add(btnUpdate);
		panel_6.add(btnDelete);
		panel_3.setLayout(new GridLayout(6, 1, 2, 2));
		btnTHValues_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		panel_3.add(btnTHValues_2);
		btnTHValues_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		panel_3.add(btnTHValues_1);
		btnTHValues.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		panel_3.add(btnTHValues);
		
		JButton btnNewButton_4 = new JButton("New button");
//		panel_3.add(btnNewButton_4);
		
		JButton btnNewButton_6 = new JButton("New button");
//		panel_3.add(btnNewButton_6);
		
		JButton btnNewButton_5 = new JButton("New button");
//		panel_3.add(btnNewButton_5);
		panel_3.setVisible(false);
		panel_1.setLayout(gl_panel_1);
		tableCardPanel.setLayout(new CardLayout(0, 0));
		
		tablePanel = new JPanel();
		tableCardPanel.add(tablePanel, "name_820079075755841");
		tablePanel.setLayout(new CardLayout(0, 0));
		
		scrollPane_1 = new JScrollPane();
		tablePanel.add(scrollPane_1, "name_815954220198215");
		
		
//		toolTable = new JTable();
		toolTable.setFillsViewportHeight(true);
		toolTable.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		toolTable.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		toolTable.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", null, null, null},
				{"2", null, null, null},
				{"3", null, null, null},
				{"4", null, null, null},
				{"5", null, null, null},
				{"6", null, null, null},
				{"7", null, null, null},
				{"8", null, null, null},
				{"9", null, null, null},
				{"10", null, null, null},
				{"11", null, null, null},
				{"12", null, null, null},
				{"13", null, null, null},
				{"14", null, null, null},
				{"15", null, null, null},
				{"16", null, null, null},
				{"17", null, null, null},
				{"18", null, null, null},
				{"19", null, null, null},
				{"20", null, null, null},
				{"21", null, null, null},
				{"22", null, null, null},
				{"23", null, null, null},
				{"24", null, null, null},
				{"25", null, null, null},
				{"26", null, null, null},
				{"27", null, null, null},
				{"28", null, null, null},
				{"29", null, null, null},
				{"30", null, null, null},
				{"31", null, null, null},
				{"32", null, null, null},
				{"33", null, null, null},
				{"34", null, null, null},
				{"35", null, null, null},
				{"36", null, null, null},
				{"37", null, null, null},
				{"38", null, null, null},
				{"39", null, null, null},
				{"40", null, null, null},
				{"41", null, null, null},
				{"42", null, null, null},
				{"43", null, null, null},
				{"44", null, null, null},
				{"45", null, null, null},
				{"46", null, null, null},
				{"47", null, null, null},
				{"48", null, null, null},
				{"49", null, null, null},
				{"50", null, null, null},
				{"51", null, null, null},
				{"52", null, null, null},
				{"53", null, null, null},
				{"54", null, null, null},
				{"55", null, null, null},
				{"56", null, null, null},
				{"57", null, null, null},
				{"58", null, null, null},
				{"59", null, null, null},
				{"60", null, null, null},
				{"61", null, null, null},
				{"62", null, null, null},
				{"63", null, null, null},
				{"64", null, null, null},
				{"65", null, null, null},
				{"66", null, null, null},
				{"67", null, null, null},
				{"68", null, null, null},
				{"69", null, null, null},
				{"70", null, null, null},
				{"71", null, null, null},
				{"72", null, null, null},
				{"73", null, null, null},
				{"74", null, null, null},
				{"75", null, null, null},
				{"76", null, null, null},
				{"77", null, null, null},
				{"78", null, null, null},
				{"79", null, null, null},
				{"80", null, null, null},
				{"81", null, null, null},
				{"82", null, null, null},
				{"83", null, null, null},
				{"84", null, null, null},
				{"85", null, null, null},
				{"86", null, null, null},
				{"87", null, null, null},
				{"88", null, null, null},
				{"89", null, null, null},
				{"90", null, null, null},
				{"91", null, null, null},
				{"92", null, null, null},
				{"93", null, null, null},
				{"94", null, null, null},
				{"95", null, null, null},
				{"96", null, null, null},
				{"97", null, null, null},
				{"98", null, null, null},
				{"99", null, null, null},
				{"100", null, null, null},
				{"101", null, null, null},
				{"102", null, null, null},
				{"103", null, null, null},
				{"104", null, null, null},
				{"105", null, null, null},
				{"106", null, null, null},
				{"107", null, null, null},
				{"108", null, null, null},
				{"109", null, null, null},
				{"110", null, null, null},
				{"111", null, null, null},
				{"112", null, null, null},
				{"113", null, null, null},
				{"114", null, null, null},
				{"115", null, null, null},
				{"116", null, null, null},
				{"117", null, null, null},
				{"118", null, null, null},
				{"119", null, null, null},
				{"120", null, null, null},
				{"121", null, null, null},
				{"122", null, null, null},
				{"123", null, null, null},
				{"124", null, null, null},
				{"125", null, null, null},
				{"126", null, null, null},
				{"127", null, null, null},
				{"128", null, null, null},
			},
			new String[] {
				"T Num", "Diameter", "Tool Type", "Holder Type"
			}
		));
		toolTable.getColumnModel().getColumn(0).setPreferredWidth(49);
		toolTable.getColumnModel().getColumn(1).setPreferredWidth(60);
		toolTable.getColumnModel().getColumn(2).setPreferredWidth(268);
		toolTable.getColumnModel().getColumn(3).setPreferredWidth(320);
		
		
		/////////////////////////////////////////////////////////////
		//Added to make jbutton in table
		/////////////////////////////////////////////////////////
		
//		toolTable.getColumn("H Offsets").setCellRenderer(new ButtonRenderer());
//        toolTable.getColumn("H Offsets").setCellEditor(new ButtonEditor(new JCheckBox()));
        
        ////////////////////////////////////////////////////////
        
        
        scrollPane_1.setViewportView(toolTable);
        
        tableCardPanel.add(ToolNum12H, "name_820229181750463");
        ToolNum12H.setLayout(new CardLayout(0, 0));
        
        ToolNum12H.add(scrollPane_2, "name_821314577735547");
        table_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
        table_1.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null},
        	},
        	new String[] {
        		"H Value", "Tool Description"
        	}
        ));
        table_1.getColumnModel().getColumn(1).setPreferredWidth(300);
        
        scrollPane_2.setViewportView(table_1);
        
        tableCardPanel.add(ToolNum13H, "name_820265477555301");
        ToolNum13H.setLayout(new CardLayout(0, 0));
        
        ToolNum13H.add(scrollPane_3, "name_821340384099740");
        table_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
        table_2.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null},
        	},
        	new String[] {
        		"H Value", "Tool Description"
        	}
        ));
        table_2.getColumnModel().getColumn(1).setPreferredWidth(300);
        
        scrollPane_3.setViewportView(table_2);
        
        tableCardPanel.add(ToolNum43H, "name_820765626121307");
        ToolNum43H.setLayout(new CardLayout(0, 0));
        
        ToolNum43H.add(scrollPane_4, "name_821384505412513");
        table_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
        table_3.setModel(new DefaultTableModel(
        	new Object[][] {{null, null},},
        	new String[] {
        		"H Value", "Tool Description"
        	}
        ));
        table_3.getColumnModel().getColumn(1).setPreferredWidth(300);
        
        scrollPane_4.setViewportView(table_3);
        
        tableCardPanel.add(AllHValuesPanel, "name_903599063592983");
        AllHValuesPanel.setLayout(new CardLayout(0, 0));
        
        AllHValuesPanel.add(scrollPane_5, "name_903849193339344");
        table_4.setFont(new Font("Times New Roman", Font.BOLD, 18));
        table_4.setModel(new DefaultTableModel(
        	new Object[][] {
        		{"128", "", null, null},
        		{"129", null, null, null},
        		{"130", null, null, null},
        		{"131", null, null, null},
        		{"132", null, null, null},
        		{"133", null, null, null},
        		{"134", null, null, null},
        		{"135", null, null, null},
        		{"136", null, null, null},
        		{"137", null, null, null},
        		{"138", null, null, null},
        		{"139", null, null, null},
        		{"140", null, null, null},
        		{"141", null, null, null},
        		{"142", null, null, null},
        		{"143", null, null, null},
        		{"144", null, null, null},
        		{"145", null, null, null},
        		{"146", null, null, null},
        		{"147", null, null, null},
        		{"148", null, null, null},
        		{"149", null, null, null},
        		{"150", null, null, null},
        		{"151", null, null, null},
        		{"152", null, null, null},
        		{"153", null, null, null},
        		{"154", null, null, null},
        		{"155", null, null, null},
        		{"156", null, null, null},
        		{"157", null, null, null},
        		{"158", null, null, null},
        		{"159", null, null, null},
        		{"160", null, null, null},
        		{"161", null, null, null},
        		{"162", null, null, null},
        		{"163", null, null, null},
        		{"164", null, null, null},
        		{"165", null, null, null},
        		{"166", null, null, null},
        		{"167", null, null, null},
        		{"168", null, null, null},
        		{"169", null, null, null},
        		{"170", null, null, null},
        		{"171", null, null, null},
        		{"172", null, null, null},
        		{"173", null, null, null},
        		{"174", null, null, null},
        		{"175", null, null, null},
        		{"176", null, null, null},
        		{"177", null, null, null},
        		{"178", null, null, null},
        		{"179", null, null, null},
        		{"180", null, null, null},
        		{"181", null, null, null},
        		{"182", null, null, null},
        		{"183", null, null, null},
        		{"184", null, null, null},
        		{"185", null, null, null},
        		{"186", null, null, null},
        		{"187", null, null, null},
        		{"188", null, null, null},
        		{"189", null, null, null},
        		{"190", null, null, null},
        		{"191", null, null, null},
        		{"192", null, null, null},
        		{"193", null, null, null},
        		{"194", null, null, null},
        		{"195", null, null, null},
        		{"196", null, null, null},
        		{"197", null, null, null},
        		{"198", null, null, null},
        		{"199", null, null, null},
        		{"200", null, null, null},
        		{"201", null, null, null},
        		{"202", null, null, null},
        		{"203", null, null, null},
        		{"204", null, null, null},
        		{"205", null, null, null},
        		{"206", null, null, null},
        		{"207", null, null, null},
        		{"208", null, null, null},
        		{"209", null, null, null},
        		{"210", null, null, null},
        		{"211", null, null, null},
        		{"212", null, null, null},
        		{"213", null, null, null},
        		{"214", null, null, null},
        		{"215", null, null, null},
        		{"216", null, null, null},
        		{"217", null, null, null},
        		{"218", null, null, null},
        		{"219", null, null, null},
        		{"220", null, null, null},
        		{"221", null, null, null},
        		{"222", null, null, null},
        		{"223", null, null, null},
        		{"224", null, null, null},
        		{"225", null, null, null},
        		{"226", null, null, null},
        		{"227", null, null, null},
        		{"228", null, null, null},
        		{"229", null, null, null},
        		{"230", null, null, null},
        		{"231", null, null, null},
        		{"232", null, null, null},
        		{"233", null, null, null},
        		{"234", null, null, null},
        		{"235", null, null, null},
        		{"236", null, null, null},
        		{"237", null, null, null},
        		{"238", null, null, null},
        		{"239", null, null, null},
        		{"240", null, null, null},
        		{"241", null, null, null},
        		{"242", null, null, null},
        		{"243", null, null, null},
        		{"244", null, null, null},
        		{"245", null, null, null},
        		{"246", null, null, null},
        		{"247", null, null, null},
        		{"248", null, null, null},
        		{"249", null, null, null},
        		{"250", null, null, null},
        	},
        	new String[] {
        		"H Number", "Diameter", "tool Description", "Notes"
        	}
        ));
        table_4.getColumnModel().getColumn(1).setPreferredWidth(49);
        table_4.getColumnModel().getColumn(2).setPreferredWidth(295);
        table_4.getColumnModel().getColumn(3).setPreferredWidth(350);
        
        scrollPane_5.setViewportView(table_4);
        allToolInfoPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        
        tableCardPanel.add(allToolInfoPanel, "name_314167124841850");
        allToolInfoPanel.setLayout(new CardLayout(0, 0));
        
        JScrollPane scrollPane_6 = new JScrollPane();
        scrollPane_6.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane_6.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        allToolInfoPanel.add(scrollPane_6, "name_314356881635340");
        
        allToolInfoTable = new JTable();
        
        allToolInfoTable.setFont(new Font("Times New Roman", Font.BOLD, 18));
        allToolInfoTable.setColumnSelectionAllowed(true);
        allToolInfoTable.setCellSelectionEnabled(true);
        allToolInfoTable.setModel(new DefaultTableModel(
        	new Object[][] {
        		{"", "", "1", null, null, null, null, null, null, null, null, null, "", null, "", null, null, null, null, null, null, "", "", ""},
        		{null, null, "2", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "3", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "4", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "5", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "6", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "7", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "8", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "9", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "10", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "11", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "12", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "13", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "14", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "15", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "16", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "17", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "18", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "19", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "20", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "21", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "22", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "23", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "24", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "25", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "26", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "27", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "28", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "29", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "30", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "31", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "32", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "33", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "34", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "35", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "36", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "37", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "38", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "39", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "40", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "40", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "41", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "42", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "43", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "44", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "45", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "46", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "47", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "48", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "49", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "50", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "51", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "52", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "53", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "54", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "55", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "56", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "57", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "58", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "59", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "60", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "61", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "62", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "63", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "64", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "65", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "66", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "67", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "68", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "69", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "70", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "71", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "72", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "73", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "74", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "75", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "76", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "77", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "78", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "79", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "80", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "81", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "82", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "83", null, "", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "84", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "85", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "86", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "87", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "88", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "89", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "90", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "91", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "92", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "93", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "94", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "95", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "96", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "97", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "98", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "99", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "100", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "101", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "102", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "103", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "104", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "105", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "106", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "107", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "108", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "109", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "110", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "111", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "112", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "113", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "114", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "115", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "116", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "117", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "118", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "119", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "120", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "121", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "122", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "123", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "124", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "125", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "126", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "127", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, "128", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
        	},
        	new String[] {
        		"Tool Description", "ToolObject Identifier", "Tool No", "Tool Dia", "Tool Type", "T Length", "Shank Dia", "Num flutes", "Alum RPM", "4140 RPM", "P20 RPM", "Tsteel RPM", "Alum SFM", "4140 SFM", "P20 SFM", "Tsteel SFM", "Alum IPR", "4140 IPR", "P20 IPR", "TSteel IPR", "FEED", "Tool Part No", "Manufacturer", "Holder"
        	}
        ));
        allToolInfoTable.getColumnModel().getColumn(0).setPreferredWidth(300);
        allToolInfoTable.getColumnModel().getColumn(0).setMinWidth(300);
        allToolInfoTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        allToolInfoTable.getColumnModel().getColumn(1).setMinWidth(200);
        allToolInfoTable.getColumnModel().getColumn(2).setPreferredWidth(55);
        allToolInfoTable.getColumnModel().getColumn(2).setMinWidth(55);
        allToolInfoTable.getColumnModel().getColumn(3).setMinWidth(75);
        allToolInfoTable.getColumnModel().getColumn(4).setMinWidth(75);
        allToolInfoTable.getColumnModel().getColumn(5).setMinWidth(75);
        allToolInfoTable.getColumnModel().getColumn(6).setMinWidth(75);
        allToolInfoTable.getColumnModel().getColumn(7).setMinWidth(75);
        allToolInfoTable.getColumnModel().getColumn(8).setMinWidth(75);
        allToolInfoTable.getColumnModel().getColumn(9).setMinWidth(75);
        allToolInfoTable.getColumnModel().getColumn(10).setMinWidth(75);
        allToolInfoTable.getColumnModel().getColumn(11).setMinWidth(75);
        allToolInfoTable.getColumnModel().getColumn(12).setMinWidth(75);
        allToolInfoTable.getColumnModel().getColumn(13).setMinWidth(75);
        allToolInfoTable.getColumnModel().getColumn(14).setMinWidth(75);
        allToolInfoTable.getColumnModel().getColumn(15).setMinWidth(75);
        allToolInfoTable.getColumnModel().getColumn(16).setMinWidth(75);
        allToolInfoTable.getColumnModel().getColumn(17).setMinWidth(75);
        allToolInfoTable.getColumnModel().getColumn(18).setMinWidth(75);
        allToolInfoTable.getColumnModel().getColumn(19).setMinWidth(75);
        allToolInfoTable.getColumnModel().getColumn(20).setMinWidth(75);
        allToolInfoTable.getColumnModel().getColumn(21).setPreferredWidth(100);
        allToolInfoTable.getColumnModel().getColumn(21).setMinWidth(100);
        allToolInfoTable.getColumnModel().getColumn(22).setPreferredWidth(150);
        allToolInfoTable.getColumnModel().getColumn(22).setMinWidth(150);
        allToolInfoTable.getColumnModel().getColumn(23).setPreferredWidth(300);
        allToolInfoTable.getColumnModel().getColumn(23).setMinWidth(300);
        scrollPane_6.setViewportView(allToolInfoTable);
        allToolInfoTable.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        
		for(int i = 0; i < 128; i++)
		{toolTable.setRowHeight(i, 25);}
		ToolLibraryPanel.setLayout(gl_ToolLibraryPanel);
		
		////////////////////////////////////////////////////////////////////////////////
		//Opens the file from the saved table in the same folder as the software
		///////////////////////////////////////////////////////////////////////////////
		
		/*
		
		String path = "table.ser";
		TableModel dtm = toolTable.getModel();
		int nRow = dtm.getRowCount(), nCol = dtm.getColumnCount();
		Object[][] tableArry = new Object[nRow][nCol];
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
			tableArry = (Object[][]) in.readObject();
			in.close();
//			JOptionPane.showMessageDialog(null, "Done");
		}
		catch(Exception ee)
		{
			JOptionPane.showMessageDialog(null, "The table in this document has not been saved!");
		}
        try
        {
			toolTable.setModel(new DefaultTableModel(tableArry, new String[] {
					"T Num", "Diameter", "Tool Type", "Holder Type", "H Offsets"
			}));
			toolTable.getColumnModel().getColumn(0).setPreferredWidth(49);
			toolTable.getColumnModel().getColumn(1).setPreferredWidth(60);
			toolTable.getColumnModel().getColumn(2).setPreferredWidth(200);
			toolTable.getColumnModel().getColumn(3).setPreferredWidth(200);
			toolTable.getColumnModel().getColumn(4).setPreferredWidth(250);
			
			for(int i = 0; i < 128; i++)
			{toolTable.setRowHeight(i, 25);}

			scrollPane_1.setViewportView(toolTable);
        }
        catch(Exception e)
        {
        	JOptionPane.showMessageDialog(null, "The table in this document has not been saved!");
        }
			
			*/
			//////////////////////////////////////////////////////////////////////////////
			///////////////////////////////////////////////////////////////////////////
			///////////////////////////////////////////////////////////////////////////
		
		
			
	}
	
	
	
	private void createEvents() 
	{
		///////////////////////////////////////////////////////////////////////////////////
		//menu bar events
		//////////////////////////////////////////////////////////////////////////////////
		
		mRCalc.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				CalcPanel.setVisible(true);
				HomePanel.setVisible(false);
				ToolLibraryPanel.setVisible(false);
			}
		});
		
		SFMCalc.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				HomePanel.setVisible(true);
				CalcPanel.setVisible(false);
				ToolLibraryPanel.setVisible(false);
			}
		});
		
		ToolLibrary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				ToolLibraryPanel.setVisible(true);
				HomePanel.setVisible(false);
				CalcPanel.setVisible(false);
			}
		});
		
		///////////////////////////////////////////////////////////////////
		//Open and save functions
		///////////////////////////////////////////////////////////////
		
		saveOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
//				Write tables
					TableModel dtm = toolTable.getModel();
		      	    Object[] dtmHeader = saveTableHeader(toolTable);
					TableModel etm = table_4.getModel();
					Object[] etmHeader = saveTableHeader(table_4);
					TableModel itm = allToolInfoTable.getModel();
					Object[] itmHeader = saveTableHeader(allToolInfoTable);
					Object aDtm[][] = saveTable(dtm);
					Object aEtm[][] = saveTable(etm);
					Object aitm[][] = saveTable(itm);
					ArrayList<Object> tables = new ArrayList<Object>();
					tables.add(aDtm);
					tables.add(dtmHeader);
					tables.add(aEtm);
					tables.add(etmHeader);
					tables.add(aitm);
					tables.add(itmHeader);
					String path = "C:/EclipseData/JavaData/info.ser";
					
					

					try 
					{
				        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
				        out.writeObject(tables);
				        out.flush();
				        out.close();
				    }
				    catch (Exception ex) 
				    {
				        ex.printStackTrace();
				    }
				
//			SaveTextDoc
					path = "C:/EclipseData/JavaData/info.txt";
					Path file = Paths.get(path);
					String s = textPane.getText();
					try
					{
						OutputStream output = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
						BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
						textPane.write(writer);
						writer.close();	
					}
					catch(Exception ee)
					{
						JOptionPane.showMessageDialog(null, e);
					}
				
//				save text variable to see the format of file
//				add auto open in main function
//				find out how to format text file to add titles so paths can change	
				
//				{
//					String path = CreateTable.openSaveDialog("txt", 0);
//					Path file = Paths.get(path);
////					String s = var1 + \n + var1 + \n + var1 + \n + var1;
//					try
//					{
//						OutputStream output = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
//						BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
////						writer.write(s);
//						writer.close();	
//					}
//					catch(Exception ee)
//					{
//						JOptionPane.showMessageDialog(null, ee);
//					}
////					JOptionPane.showMessageDialog(null,  s);
//				}
				
			}
		});
		
		savetxtDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 	
			{
				String path = CreateTable.openSaveDialog("txt", 0);
				Path file = Paths.get(path);
				String s = textPane.getText();
//				byte[] data = s.getBytes();
//				ByteBuffer buffer = ByteBuffer.wrap(data);
				try
				{
					OutputStream output = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
					BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
					textPane.write(writer);
//					writer.write(s);
					writer.close();	
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
//				JOptionPane.showMessageDialog(null,  s);
			}
		});
		
		openTxtDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String path = CreateTable.openSaveDialog("txt", 1);
				Path file = Paths.get(path);
				String s = "";
				try
				{
					InputStream input = new BufferedInputStream(Files.newInputStream(file));
					BufferedReader reader  = new BufferedReader(new InputStreamReader(input));
					s = reader.readLine();
					while(s != null)
					{
						textPane.append(s + "\n");
						s = reader.readLine();
					}
					reader.close();
					
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		
		saveToolTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				TableModel dtm = toolTable.getModel();
	      	    Object[] dtmHeader = saveTableHeader(toolTable);
				TableModel etm = table_4.getModel();
				Object[] etmHeader = saveTableHeader(table_4);
				TableModel itm = allToolInfoTable.getModel();
				Object[] itmHeader = saveTableHeader(allToolInfoTable);
				Object aDtm[][] = saveTable(dtm);
				Object aEtm[][] = saveTable(etm);
				Object aitm[][] = saveTable(itm);
				ArrayList<Object> tables = new ArrayList<Object>();
				tables.add(aDtm);
				tables.add(dtmHeader);
				tables.add(aEtm);
				tables.add(etmHeader);
				tables.add(aitm);
				tables.add(itmHeader);
				String path = CreateTable.openSaveDialog("ser", 0);
				
				

				try 
				{
			        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
			        out.writeObject(tables);
			        out.flush();
			        out.close();
			    }
			    catch (Exception ex) 
			    {
			        ex.printStackTrace();
			    }
			}
		});
		
		saveExcellTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Object[] dtmHeader = saveTableHeader(toolTable);
				Object[] etmHeader = saveTableHeader(table_4);
				Object[] itmHeader = saveTableHeader(allToolInfoTable);
				try 
				{
					CreateTable.writeToExcell(toolTable, table_4, allToolInfoTable, dtmHeader, etmHeader, itmHeader);
				}
				catch (Exception ee) 
				{
					
					JOptionPane.showMessageDialog(null, "Export to Excell Failed");
				}
			}
		});
		
		openImportExcelTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String fileName = CreateTable.openSaveDialog("xls", 1) ;
//				readExcelFile(JTable table, int sheetNo, int[] collumnFormat)
				int[] collumnFormat = new int[] {49,60,268,320};
				ReadExcell.readExcelFile(toolTable, 0, collumnFormat, fileName); 
				int[] collumnFormat5 = new int[] {75,50,300,350};
				ReadExcell.readExcelFile(table_4, 1, collumnFormat5, fileName);
				int[] collumnFormat6 = new int[] {300,200,55,75,75,75,75,75,75,75,75,75,75,75,75,75,75,75,75,75,75,100,150,300};
				ReadExcell.readExcelFile(allToolInfoTable, 2, collumnFormat6, fileName);
			}
		});
		
		openToolTable.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) 
			{
				Object[] toolTableHeader;
				Object[] toolHHeader;
//				Object[] tool12HHeader;
//				Object[] tool13HHeader; 
//				Object[] tool43HHeader; 
				Object[] allToolsHeader; 
				Object[][] tableArry = {{null, null},};
				Object[][] toolHArry = {{null, null},};
//				Object[][] t12HArry = {{null, null},};
//				Object[][] t13HArry = {{null, null},};
//				Object[][] t43HArry = {{null, null},};
				Object[][] allToolsArry = {{null, null},};
				ArrayList<Object> tables = new ArrayList<Object>();
				String path = CreateTable.openSaveDialog("ser", 1);
				
				try
				{
					ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
					tables = (ArrayList<Object>) in.readObject();
					in.close();
				}
				catch(IOException ee)
				{JOptionPane.showMessageDialog(null, ee);}
				catch(ClassNotFoundException ex)
				{JOptionPane.showMessageDialog(null, ex);}
				
				//createToolInfoTable(Object[][] tableModel, String[] toolTableHeader,int length, JTable newTable, int[] collumnFormat)

				tableArry = (Object[][])tables.get(0);
				toolTableHeader = (Object[])tables.get(1);
				
				toolHArry = (Object[][])tables.get(2);
				toolHHeader = (Object[])tables.get(3);
				
//				t12HArry = (Object[][])tables.get(4);
//				tool12HHeader = (Object[])tables.get(5);
//				
//				t13HArry = (Object[][])tables.get(6);
//				tool13HHeader = (Object[])tables.get(7);
//				
//				t43HArry = (Object[][])tables.get(8);
//				tool43HHeader = (Object[])tables.get(9);
				
				allToolsArry = (Object[][])tables.get(4);
				allToolsHeader = (Object[])tables.get(5);
				
				int[] collumnFormat = new int[] {49,60,268,320};
				CreateTable.createToolInfoTable(tableArry, toolTableHeader, toolTable, collumnFormat);
				
//				int[] collumnFormat2 = new int[] {75,300};
//				CreateTable.createToolInfoTable(t12HArry, tool12HHeader, table_1, collumnFormat2);
//				
//				int[] collumnFormat3 = new int[] {75,300};
//				CreateTable.createToolInfoTable(t13HArry, tool13HHeader, table_2, collumnFormat3);
//				
//				int[] collumnFormat4 = new int[] {75,300};
//				CreateTable.createToolInfoTable(t43HArry, tool43HHeader, table_3, collumnFormat4);
				
				int[] collumnFormat5 = new int[] {75,50,300,350};
				CreateTable.createToolInfoTable(toolHArry, toolHHeader, table_4, collumnFormat5);
				
				int[] collumnFormat6 = new int[] {300,200,55,75,75,75,75,75,75,75,75,75,75,75,75,75,75,75,75,75,75,100,150,300};
				CreateTable.createToolInfoTable(allToolsArry, allToolsHeader, allToolInfoTable, collumnFormat6);
				
			}
		});
		
		///////////////////////////////////////////////////////////////////////////
		//Calculator events
		//////////////////////////////////////////////////////////////////////////
		
		btnRPM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				RPMpanel.setVisible(true);
				SFMpanel.setVisible(false);
				FeedRatePanel.setVisible(false);
				VRPanel.setVisible(false);
				FPTpanel.setVisible(false);
			}
		});
		
		btnSFM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				SFMpanel.setVisible(true);
				RPMpanel.setVisible(false);
				FeedRatePanel.setVisible(false);
				VRPanel.setVisible(false);
				FPTpanel.setVisible(false);
			}
		});
		
		btnFeedRate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				FeedRatePanel.setVisible(true);
				RPMpanel.setVisible(false);
				SFMpanel.setVisible(false);
				VRPanel.setVisible(false);
				FPTpanel.setVisible(false);
			}
		});
		
		btnVolumeRemoved.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				VRPanel.setVisible(true);
				RPMpanel.setVisible(false);
				SFMpanel.setVisible(false);
				FeedRatePanel.setVisible(false);
				FPTpanel.setVisible(false);
			}
		});
		
		FPTButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				FPTpanel.setVisible(true);
				RPMpanel.setVisible(false);
				SFMpanel.setVisible(false);
				FeedRatePanel.setVisible(false);
				VRPanel.setVisible(false);
			}
		});
		
		AFPTButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				RPMpanel.setVisible(true);
				SFMpanel.setVisible(false);
				FeedRatePanel.setVisible(false);
				VRPanel.setVisible(false);
				FPTpanel.setVisible(false);
			}
		});
		
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				
				if(SFMpanel.isVisible())
				{
//					TFRpmSfm
//					TFDiaSfm
//					SFM = (RPM x D) / 3.82
//					=JLSFM
					double RPM1 = 0, D1 = 0, product = 0;
					try
					{
						RPM1 = Double.parseDouble(TFRpmSfm.getText());
						D1 = Double.parseDouble(TFDiaSfm.getText());
						product = (RPM1 * D1) / 3.82;
						product = (double) Math.round(product * 100) / 100;
						JLSFM.setText("=" + product);
					}
					catch(Exception e)
					{JOptionPane.showMessageDialog(null, "invalid number");}
				}
				if(RPMpanel.isVisible())
				{
//					TFSfmRpm
//					TFDiaRpm
//					RPM = (SFM x 3.82) / Dia
//					=JLRPM
					double SFM1 = 0, DIA1 = 0, product = 0;
					try
					{
						SFM1 = Double.parseDouble(TFSfmRpm.getText());
						DIA1 = Double.parseDouble(TFDiaRpm.getText());
						product = (SFM1 * 3.82) / DIA1;
						product = (double) Math.round(product * 100) / 100;
						JLRPM.setText("=" + product);
					}
					catch(Exception e)
					{JOptionPane.showMessageDialog(null, "invalid number");}
				}
				if(FeedRatePanel.isVisible())
				{
//					TFRpmFr
//					TFFptFr
//					TFTFr
//					T = Number of teeth in cutter
//					FPT = Feed per Tooth
//					Feed = RPM X FPT X T
//					=JLFR
					double RPM1 = 0, FPT1 = 0, T1 = 0, product = 0;
					try
					{
						RPM1 = Double.parseDouble(TFRpmFr.getText());
						FPT1 = Double.parseDouble(TFFptFr.getText());
						T1 = Double.parseDouble(TFTFr.getText());
						product = RPM1 * FPT1 * T1;
						product = (double) Math.round(product * 100) / 100;
						JLFR.setText("=" + product);
					}
					catch(Exception e)
					{JOptionPane.showMessageDialog(null, "invalid number");}
				}
				if(VRPanel.isVisible())
				{
//					TFStepoverVr
//					TFDocVr
//					TFFrVr
//					=JLVR
					double WOC = 0, DOC = 0, IPM1 = 0, product = 0;
					try
					{
						WOC = Double.parseDouble(TFStepoverVr.getText());
						DOC = Double.parseDouble(TFDocVr.getText());
						IPM1 = Double.parseDouble(TFFrVr.getText());
						product = WOC * DOC * IPM1;
						JLVR.setText("=" + product + " Cub In/ Min");
					}
					catch(Exception e)
					{JOptionPane.showMessageDialog(null, "invalid number");}
				}
				if(FPTpanel.isVisible())
				{
//					TFIPMfpt
//					TFRPMfpt
//					TFNumofTeethfpt
//					FPT = IPM/(RPM X T)
//					=JLFpt
					double IPM1 = 0, RPM1 = 0, T1 = 0, product = 0;
					try
					{
						IPM1 = Double.parseDouble(TFIPMfpt.getText());
						RPM1 = Double.parseDouble(TFRPMfpt.getText());
						T1 = Double.parseDouble(TFNumofTeethfpt.getText());
						product = IPM1 / (RPM1 * T1);
						product = (double) Math.round(product * 100) / 100;
						JLFpt.setText("=" + product);
					}
					catch(Exception e)
					{JOptionPane.showMessageDialog(null, "invalid number");}
				}
				
			}
		});
		
		///////////////////////////////////////////////////////////////////////
		// table events
		///////////////////////////////////////////////////////////////////////
		
		btnAllHValues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				AllHValuesPanel.setVisible(true);
				tablePanel.setVisible(false);
				allToolInfoPanel.setVisible(false);
				ToolNum12H.setVisible(false);
				ToolNum13H.setVisible(false);
				ToolNum43H.setVisible(false);
				panel_4.removeAll();
				panel_4.setLayout(new GridLayout(4, 2, 5, 5));
				panel_4.add(toolHNumTL);
				panel_4.add(toolHNumTF);
				panel_4.add(toolDiaTL);
				panel_4.add(toolDiaTF);
				panel_4.add(toolDescTL);
				panel_4.add(toolDescTypeTF);
				panel_4.add(notesTL);
				panel_4.add(notesTF);
				repaint();
				for(int i = 0; i < table_4.getRowCount(); i++)
				{table_4.setRowHeight(i, 25);}
				currentTable = table_4;
				tableNum = 2;
			}
		});
		
		btnToolTable.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) 
			{
				tablePanel.setVisible(true);
				AllHValuesPanel.setVisible(false);
				allToolInfoPanel.setVisible(false);
				ToolNum12H.setVisible(false);
				ToolNum13H.setVisible(false);
				ToolNum43H.setVisible(false);
				panel_4.removeAll();
				panel_4.setLayout(new GridLayout(4, 2, 5, 5));
				panel_4.add(toolNumTL);
				panel_4.add(toolNumTF);
				panel_4.add(toolDiaTL);
				panel_4.add(toolDiaTF);
				panel_4.add(toolTypeTL);
				panel_4.add(toolTypeTF);
				panel_4.add(holderTypeTL);
				panel_4.add(holderTypeTF);
				repaint();
				for(int i = 0; i < toolTable.getRowCount(); i++)
				{toolTable.setRowHeight(i, 25);}
				currentTable = toolTable;
				tableNum = 2;
				
				
			}
		});
		
		btnTHValues_2.addActionListener(new ActionListener() {
			


			public void actionPerformed(ActionEvent e) 
			{
				ToolNum12H.setVisible(true);
				ToolNum13H.setVisible(false);
				ToolNum43H.setVisible(false);
				tablePanel.setVisible(false);
				AllHValuesPanel.setVisible(false);
				panel_4.removeAll();
				panel_4.setLayout(new GridLayout(4, 2, 5, 5));
				panel_4.add(toolHNumTL);
				panel_4.add(toolHNumTF);
				panel_4.add(toolDescTL);
				panel_4.add(toolDescTypeTF);
				repaint();
			}
		});
		
		btnTHValues_1.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) 
			{
				ToolNum13H.setVisible(true);
				ToolNum43H.setVisible(false);
				ToolNum12H.setVisible(false);
				tablePanel.setVisible(false);
				AllHValuesPanel.setVisible(false);
				panel_4.removeAll();
				panel_4.setLayout(new GridLayout(4, 2, 5, 5));
				panel_4.add(toolHNumTL);
				panel_4.add(toolHNumTF);
				panel_4.add(toolDescTL);
				panel_4.add(toolDescTypeTF);
				repaint();
			}
		});
		
		btnTHValues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ToolNum43H.setVisible(true);
				ToolNum12H.setVisible(false);
				ToolNum13H.setVisible(false);
				tablePanel.setVisible(false);
				AllHValuesPanel.setVisible(false);
				panel_4.removeAll();
				panel_4.setLayout(new GridLayout(4, 2, 5, 5));
				panel_4.add(toolHNumTL);
				panel_4.add(toolHNumTF);
				panel_4.add(toolDescTL);
				panel_4.add(toolDescTypeTF);
				repaint();
			}
		});
		
		btnAllToolInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				allToolInfoPanel.setVisible(true);
				ToolNum12H.setVisible(false);
				ToolNum13H.setVisible(false);
				ToolNum43H.setVisible(false);
				tablePanel.setVisible(false);
				AllHValuesPanel.setVisible(false);
				panel_4.removeAll();
				repaint();
				for(int i = 0; i < allToolInfoTable.getRowCount(); i++)
				{allToolInfoTable.setRowHeight(i, 25);}
				currentTable = allToolInfoTable;
				tableNum = 0;
			}
		});
		
		///////////////////////////////////////////////////////////////////////////
		//table functions
		///////////////////////////////////////////////////////////////////////////
		
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int toolNumInt = 0;
			    String StoolNo = toolNoTF.getText();
				try
				{
					toolNumInt = (Integer.parseInt(StoolNo)) - 1;
					//Hide
					for(int i = 0; i < toolNumInt; i++)  // tool70
					toolTable.setRowHeight(i, 1);
				    for(int i = toolNumInt + 1; i < 128; i++)
					toolTable.setRowHeight(i, 1);
				    //Show
					toolTable.setRowHeight(toolNumInt, 25);
					
					
					toolTable.getSelectionModel().setSelectionInterval(toolNumInt, toolNumInt);
					toolTable.scrollRectToVisible(toolTable.getCellRect(toolNumInt, 0, true));
//					toolTable.setRowSelectionInterval(toolNumInt, toolNumInt);
					toolNumLbl.setText(Integer.toString(toolNumInt + 1));
					
				}
				catch(Exception ee)
				{
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		
		toolTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				int rowNum = toolTable.getSelectedRow();
				TableModel tbl = toolTable.getModel();
				Object toolNum1 = tbl.getValueAt(rowNum, 0);
				toolNumLbl.setText((String) toolNum1);
				if(toolTable.getValueAt(rowNum, 0) != null)
				{toolNumTF.setText(toolTable.getValueAt(rowNum, 0).toString());}
				if(toolTable.getValueAt(rowNum, 1) != null)
				{toolDiaTF.setText(toolTable.getValueAt(rowNum, 1).toString());}
				if(toolTable.getValueAt(rowNum, 2) != null)
				{toolTypeTF.setText(toolTable.getValueAt(rowNum, 2).toString());}
				if(toolTable.getValueAt(rowNum, 3) != null)
				{holderTypeTF.setText(toolTable.getValueAt(rowNum, 3).toString());}
				toolNoTF.setText(toolTable.getValueAt(rowNum, 0).toString());
			}
		});

		
		table_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				int rowNum = table_4.getSelectedRow();
//				toolNumLbl.setText((String) toolNum1);
				if(table_4.getValueAt(rowNum, 0) != null)
				{toolHNumTF.setText(table_4.getValueAt(rowNum, 0).toString());}
				if(table_4.getValueAt(rowNum, 1) != null)
				{toolDiaTF.setText(table_4.getValueAt(rowNum, 1).toString());}
				if(table_4.getValueAt(rowNum, 2) != null)
				{toolDescTypeTF.setText(table_4.getValueAt(rowNum, 2).toString());}
				if(table_4.getValueAt(rowNum, 3) != null)
				{notesTF.setText(table_4.getValueAt(rowNum, 3).toString());}
				toolNumLbl.setText(table_4.getValueAt(rowNum, 0).toString());
				toolNoTF.setText(table_4.getValueAt(rowNum, 0).toString());
				
			}
		});
		
		allToolInfoTable.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) 
        	{
        		int rowNum = allToolInfoTable.getSelectedRow();
				TableModel tbl = allToolInfoTable.getModel();
				toolNoTF.setText(allToolInfoTable.getValueAt(rowNum, 2).toString());
				toolNumLbl.setText(allToolInfoTable.getValueAt(rowNum, 2).toString());
        	}
        });
		
		btnAdd.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) 
			{
				try
				{
				if(tablePanel.isVisible())
				{
					row[0] = toolNumTF.getText();
					row[1] = toolDiaTF.getText();
					row[2] = toolTypeTF.getText();
					row[3] = holderTypeTF.getText();
					DefaultTableModel ntoolTable = (DefaultTableModel)toolTable.getModel();
					ntoolTable.addRow(row);
				}
				else if(AllHValuesPanel.isVisible())
				{
					row[0] = toolHNumTF.getText();
					row[1] = toolDiaTF.getText();
					row[2] = toolDescTypeTF.getText();
					row[3] = notesTF.getText();
					DefaultTableModel ntoolTable = (DefaultTableModel)table_4.getModel();
					ntoolTable.addRow(row);
				}
				else
				{
					DefaultTableModel ntoolTable = (DefaultTableModel)currentTable.getModel();
					ntoolTable.addRow(row);
				}
				}
				catch(Exception ee)
				{JOptionPane.showMessageDialog(null, "Error in row selection");}
			}	
		});
		
        btnInsert.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) 
			{
				try
				{
				if(tablePanel.isVisible())
				{
					row[0] = toolNumTF.getText();
					row[1] = toolDiaTF.getText();
					row[2] = toolTypeTF.getText();
					row[3] = holderTypeTF.getText();
					DefaultTableModel ntoolTable = (DefaultTableModel)toolTable.getModel();
					ntoolTable.insertRow(toolTable.getSelectedRow(), row);
				}
				
				else if(AllHValuesPanel.isVisible())
				{
					row[0] = toolHNumTF.getText();
					row[1] = toolDiaTF.getText();
					row[2] = toolDescTypeTF.getText();
					row[3] = notesTF.getText();
					DefaultTableModel ntoolTable = (DefaultTableModel)table_4.getModel();
					ntoolTable.insertRow(table_4.getSelectedRow(), row);
				}
				else
				{
					DefaultTableModel ntoolTable = (DefaultTableModel)currentTable.getModel();
					ntoolTable.insertRow(currentTable.getSelectedRow(), row2);
				}
				}
				catch(Exception ee)
				{JOptionPane.showMessageDialog(null, "Error in row selection");}
			}	
		});
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
				if(tablePanel.isVisible())
				{
					
					row[0] = toolNumTF.getText();
					row[1] = toolDiaTF.getText();
					row[2] = toolTypeTF.getText();
					row[3] = holderTypeTF.getText();
					int rowNum = toolTable.getSelectedRow();
//					TableModel tbl = table_2.getModel();
					DefaultTableModel ntoolTable = (DefaultTableModel)toolTable.getModel();
					ntoolTable.setValueAt(row[0], rowNum, 0);
					ntoolTable.setValueAt(row[1], rowNum, 1);
					ntoolTable.setValueAt(row[2], rowNum, 2);
					ntoolTable.setValueAt(row[3], rowNum, 3);
				}
				else if(AllHValuesPanel.isVisible())
				{
					row[0] = toolHNumTF.getText();
					row[1] = toolDiaTF.getText();
					row[2] = toolDescTypeTF.getText();
					row[3] = notesTF.getText();
					int rowNum = table_4.getSelectedRow();
					DefaultTableModel ntoolTable = (DefaultTableModel)table_4.getModel();
					ntoolTable.setValueAt(row[0], rowNum, 0);
					ntoolTable.setValueAt(row[1], rowNum, 1);
					ntoolTable.setValueAt(row[2], rowNum, 2);
					ntoolTable.setValueAt(row[3], rowNum, 3);
				}
//				else
//				{
//					int rowNum = table_4.getSelectedRow();
//					DefaultTableModel ntoolTable = (DefaultTableModel)table_4.getModel();
//					ntoolTable.setValueAt(row[0], rowNum, 0);
//					ntoolTable.setValueAt(row[1], rowNum, 1);
//					ntoolTable.setValueAt(row[2], rowNum, 2);
//					ntoolTable.setValueAt(row[3], rowNum, 3);
//				}
				}
				catch(Exception ee)
				{JOptionPane.showMessageDialog(null, "Error in row selection");}
				
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					DefaultTableModel ntoolTable = (DefaultTableModel)currentTable.getModel();
					ntoolTable.removeRow(currentTable.getSelectedRow());
				}
				catch(Exception ee)
				{JOptionPane.showMessageDialog(null, "Error in selected row");}
				
			}
		});
		
		dapraBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				for(int i = 0; i < currentTable.getRowCount(); i++)
				{
					String value = "";
					String partial = "";
					try
					{
					value = (String)currentTable.getModel().getValueAt(i, tableNum);
					partial = value.substring(0, 5);
					}
					catch(Exception ee)
					{partial = "notDapra";}
					if (partial.equalsIgnoreCase("dapra"))
					{currentTable.setRowHeight(i, 25);}
					else
					{currentTable.setRowHeight(i, 1);}
				}
			}
		});
		
		endmillBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				for(int i = 0; i < currentTable.getRowCount(); i++)
				{
					String value = "";
					String partial = "";
					try
					{
					value = (String)currentTable.getModel().getValueAt(i, tableNum);
					partial = value.substring(0, 4);
					}
					catch(Exception ee)
					{partial = "notEndmill";}
					if (partial.equalsIgnoreCase("endm"))
					{currentTable.setRowHeight(i, 25);}
					else
					{currentTable.setRowHeight(i, 1);}
				}
			}
		});
		
		pipeDrillBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				for(int i = 0; i < currentTable.getRowCount(); i++)
				{
					String value = "";
					String partial = "";
					try
					{
					value = (String)currentTable.getModel().getValueAt(i, tableNum);
					partial = value.substring(0, 5);
					}
					catch(Exception ee)
					{partial = "notpipeDrill";}
					if (partial.equalsIgnoreCase("pipeD"))
					{currentTable.setRowHeight(i, 25);}
					else
					{currentTable.setRowHeight(i, 1);}
				}
			}
		});
	
		pipeTapBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				for(int i = 0; i < currentTable.getRowCount(); i++)
				{
					String value = "";
					String partial = "";
					try
					{
					value = (String)currentTable.getModel().getValueAt(i, tableNum);
					partial = value.substring(0, 5);
					}
					catch(Exception ee)
					{partial = "notpipeTap";}
					if (partial.equalsIgnoreCase("pipeT"))
					{currentTable.setRowHeight(i, 25);}
					else
					{currentTable.setRowHeight(i, 1);}
				}
			}
		});
		
		ThreadMillBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				for(int i = 0; i < currentTable.getRowCount(); i++) 
				{
					String value = "";
					String partial = "";
					try
					{
					value = (String)currentTable.getModel().getValueAt(i, tableNum);
					partial = value.substring(0, 6);
					}
					catch(Exception ee)
					{partial = "notThreadMill";}
					if (partial.equalsIgnoreCase("thread"))
					{currentTable.setRowHeight(i, 25);}
					else
					{currentTable.setRowHeight(i, 1);}
				}
			}
		});
		
		btnDrillAndTap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				for(int i = 0; i < currentTable.getRowCount(); i++)
				{
					String value = "";
					String partial = "";
					try
					{
					value = (String)currentTable.getModel().getValueAt(i, tableNum);
					partial = value.substring(0, 4);
					}
					catch(Exception ee)
					{partial = "notDrillAndTap";}
					if (partial.equalsIgnoreCase("dril"))
					{currentTable.setRowHeight(i, 25);}
					else
					{currentTable.setRowHeight(i, 1);}
				}
			}
		});
		
		MinimillBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				for(int i = 0; i < currentTable.getRowCount(); i++)
				{
					String value = "";
					String partial = "";
					try
					{
					value = (String)currentTable.getModel().getValueAt(i, tableNum);
					partial = value.substring(0, 4);
					}
					catch(Exception ee)
					{partial = "notMiniMill";}
					if (partial.equalsIgnoreCase("mini"))
					{currentTable.setRowHeight(i, 25);}
					else
					{currentTable.setRowHeight(i, 1);}
				}
			}
		});
		
		CbreBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				for(int i = 0; i < currentTable.getRowCount(); i++)
				{
					String value = "";
					String partial = "";
					try
					{
					value = (String)currentTable.getModel().getValueAt(i, tableNum);
					partial = value.substring(0, 1);
					}
					catch(Exception ee)
					{partial = "notcounterBore";}
					if (partial.equalsIgnoreCase("c"))
					{currentTable.setRowHeight(i, 25);}
					else
					{currentTable.setRowHeight(i, 1);}
				}
			}
		});
		
		spadeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				for(int i = 0; i < currentTable.getRowCount(); i++)
				{
					String value = "";
					String partial = "";
					try
					{
					value = (String)currentTable.getModel().getValueAt(i, tableNum);
					partial = value.substring(0, 4);
					}
					catch(Exception ee)
					{partial = "notSpade";}
					if (partial.equalsIgnoreCase("spad"))
					{currentTable.setRowHeight(i, 25);}
					else
					{currentTable.setRowHeight(i, 1);}
				}
			}
		});
		
		specialBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				for(int i = 0; i < currentTable.getRowCount(); i++)
				{
					String value = "";
					String partial = "";
					try
					{
					value = (String)currentTable.getModel().getValueAt(i, tableNum);
					partial = value.substring(0, 4);
					}
					catch(Exception ee)
					{partial = "notSpecial";}
					if (partial.equalsIgnoreCase("spec"))
					{currentTable.setRowHeight(i, 25);}
					else
					{currentTable.setRowHeight(i, 1);}
				}
			}
		});
		
		FaceMillBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				for(int i = 0; i < currentTable.getRowCount(); i++)
				{
					String value = "";
					String partial = "";
					try
					{
					value = (String)currentTable.getModel().getValueAt(i, tableNum);
					partial = value.substring(0, 4);
					}
					catch(Exception ee)
					{partial = "notFaceMill";}
					if (partial.equalsIgnoreCase("face"))
					{currentTable.setRowHeight(i, 25);}
					else
					{currentTable.setRowHeight(i, 1);}
				}
			}
		});
		
		btnOddTooling.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				for(int i = 0; i < currentTable.getRowCount(); i++)
				{
					String value = "";
					String partial = "";
					try
					{
					value = (String)currentTable.getModel().getValueAt(i, tableNum);
					partial = value.substring(0, 3);
					}
					catch(Exception ee)
					{partial = "notOdd";}
					if (partial.equalsIgnoreCase("odd"))
					{currentTable.setRowHeight(i, 25);}
					else
					{currentTable.setRowHeight(i, 1);}
				}
			}
		});
		
		
		
		////////////////////////////////////////////////////////////////////////////
		//Homepage methods
		////////////////////////////////////////////////////////////////////////////
		
		scheduleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				schedulePanel.setVisible(true);
				homePanel.setVisible(false);
				procedurePanel.setVisible(false);
			}
		});
		
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				schedulePanel.setVisible(false);
				homePanel.setVisible(true);
				procedurePanel.setVisible(false);
			}
		});
		
		proceduresbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				schedulePanel.setVisible(false);
				homePanel.setVisible(false);
				procedurePanel.setVisible(true);
			}
		});
	}
	
	
	
	
	/////////////////////////////////////////////////////////////
	//End of Method
	////////////////////////////////////////////////////////////
	
	
	
	
	
	
	
	public Object[][] saveTable(TableModel dtm)
    {
    	
	    int nRow = dtm.getRowCount(), nCol = dtm.getColumnCount();
	    Object[][] tableData = new Object[nRow][nCol];
	    for (int i = 0 ; i < nRow ; i++)
	        for (int j = 0 ; j < nCol ; j++)
	            tableData[i][j] = dtm.getValueAt(i,j);
	    return tableData;
		
    }
	
	public Object[] saveTableHeader(JTable table)
	{
		Object[] tableHeader = new Object[table.getColumnCount()];
		for(int i = 0; i < table.getColumnCount(); i++)
		{tableHeader[i] = table.getColumnModel().getColumn(i).getHeaderValue();}
		return tableHeader;
		
	}
	
	public Object[][] openTable(TableModel dtm)
	{
		String path = "table.ser";
		
		int nRow = dtm.getRowCount(), nCol = dtm.getColumnCount();
		Object[][] tableArry = new Object[nRow][nCol];
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
			tableArry = (Object[][]) in.readObject();
			in.close();
//			JOptionPane.showMessageDialog(null, "Done");
		}
		catch(Exception ee)
		{
			JOptionPane.showMessageDialog(null, ee);
		}
		return tableArry;

			
	}
}

//data[jTable1.getSelectedRow()][0] = name;
//data[jTable1.getSelectedRow()][1] = columnNames;
//jTable1.setModel(new DefaultTableModel(data, columnNames)); //adding a row to the table