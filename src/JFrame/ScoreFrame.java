package JFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import Executable.ScienceBowlClock;
import FileWriter.CSVWriter;
import Menu.ScoreboardMenu;
import Scoreboard.Scoreboard;

public class ScoreFrame extends JFrame {
	 TableModel dataModel = new AbstractTableModel() {
		 private String[] columnNames = Scoreboard.getColumnNames();
		 private String[][] data = Scoreboard.getScoreList();
		 private boolean[][] editable = Scoreboard.getEditable();
         public String getColumnName(int col) { return columnNames[col]; }
		 public int getColumnCount() { return columnNames.length; }
         public int getRowCount() { return data.length;}
         public Object getValueAt(int row, int col) { return data[row][col]; }
     	 public void  setValueAt(Object value, int row, int col) {
            data[row][col] = (String) value;
            editable[Scoreboard.binarizeRow(5-row)][col] = ((String) value).equals("   ");
            team1.setText(new Integer(Scoreboard.getA()).toString());
            //System.out.println(Scoreboard.getA());
            team2.setText(new Integer(Scoreboard.getB()).toString());
            fireTableCellUpdated(row, col); }
     	 public boolean isCellEditable(int row, int col){
     		 //System.out.println(row+":"+col+":"+editable[Scoreboard.binarizeRow(row)][col]);
     		 return editable[Scoreboard.binarizeRow(row)][col] || (!data[row][col].equals("   ") && col != 0) || scoreMenu.isFullEdit();
     		 //return true;
     	 }
     };
    private JTable rowHeader = new JTable(
    		new AbstractTableModel(){
    			private String[] columnNames = Scoreboard.getColumnList();
    			private String[][] data = Scoreboard.getHeadingList();
    			 public String getColumnName(int col) { return columnNames[col]; }
    			 public int getColumnCount() { return 1; }
    	         public int getRowCount() { return 6;}
    	         public Object getValueAt(int row, int col) { return data[row][col]; }
    	     	 public void  setValueAt(Object value, int row, int col) {
    	            data[row][col] = (String) value;
    	        
    	            fireTableCellUpdated(row, col); }
    	     	 public boolean isCellEditable(int row, int col){
    	     		 return false;
    	     	 }
    		}
    		);
    
    private ScoreboardMenu scoreMenu;
    private JPanel test = new JPanel();
	private JTable scoreTable = new JTable(dataModel);
	private JScrollPane breakdownPane = new JScrollPane(scoreTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	private JComboBox playerChoice;
	private GridBagConstraints c = new GridBagConstraints();
	private JLabel team1 = new JLabel(), team2 = new JLabel();
	private JPanel t1Panel = new JPanel(), t2Panel = new JPanel();
	public ScoreFrame(){
		//Sets up the frame itself
		setTitle("Score Board");
		setSize(500,500);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		//setResizable(false);
		setLocationRelativeTo(ScienceBowlClock.GUI);
		scoreMenu = new ScoreboardMenu();
		setJMenuBar(scoreMenu);
		playerChoice = new JComboBox();
			playerChoice.addItem("   ");
			playerChoice.addItem(" 1 ");
			playerChoice.addItem(" 2 ");
			playerChoice.addItem(" 3 ");
			playerChoice.addItem(" 4 ");
		scoreTable.setDefaultEditor(Object.class, new DefaultCellEditor(playerChoice));
		scoreTable.setPreferredScrollableViewportSize(new Dimension(750,300));
		scoreTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scoreTable.setRowSelectionAllowed(false);
		scoreTable.setShowVerticalLines(true);
		scoreTable.setShowHorizontalLines(true);
		scoreTable.setGridColor(new Color(0,0,0));
		setColumnWidths(scoreTable);
		scoreTable.setRowHeight(52);
		scoreTable.setFillsViewportHeight(true);
		Dimension d = rowHeader.getPreferredScrollableViewportSize();
		d.width = rowHeader.getPreferredSize().width;
		rowHeader.setPreferredScrollableViewportSize(d);

		rowHeader.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		rowHeader.setRowSelectionAllowed(false);
		rowHeader.setShowVerticalLines(true);
		rowHeader.setShowHorizontalLines(true);
		rowHeader.setGridColor(new Color(0,0,0));
		rowHeader.getColumnModel().getColumn(0).sizeWidthToFit();
		rowHeader.setRowHeight(52);
		breakdownPane.setRowHeaderView(rowHeader);
		test.setLayout(new GridBagLayout());
		setLayout(new GridBagLayout());
		c.fill = c.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 8;
		add(breakdownPane,c);
		team1.setText(new Integer(Scoreboard.getA()).toString());
			team1.setFont(new Font("SansSerif",Font.PLAIN,20));
		t1Panel.setLayout(new GridBagLayout());
		t1Panel.add(team1);
		t1Panel.setBackground(Color.BLUE);
        team2.setText(new Integer(Scoreboard.getB()).toString());
        	team2.setFont(new Font("SansSerif",Font.PLAIN,20));
        t2Panel.setLayout(new GridBagLayout());
        t2Panel.add(team2);
        t2Panel.setBackground(Color.RED);
		c.fill = c.BOTH;
        test.add(t1Panel,c);
		c.gridx = 1;
		test.add(t2Panel,c);
		c.gridx = 0;
		c.gridy = 1;
		c.weighty = 2;
		add(test,c);
	}
	private void setColumnWidths(JTable table) {
	    TableColumnModel columnModel = table.getColumnModel();
	    for (int i = 0; i < columnModel.getColumnCount(); i++) {
	    		columnModel.getColumn(i).setMinWidth(50);
	    		columnModel.getColumn(i).setPreferredWidth(50);
	        	columnModel.getColumn(i).setMaxWidth(50);
	    }
	}
	public void reset(){
		Scoreboard.reset();
		AbstractTableModel tModel = (AbstractTableModel) scoreTable.getModel();
		tModel.fireTableDataChanged();
	}
	
}
