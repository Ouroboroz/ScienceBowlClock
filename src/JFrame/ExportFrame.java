package JFrame;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Executable.ScienceBowlClock;
import FileWriter.CSVWriter;

public class ExportFrame extends JFrame {
	String[] names = new String[8];
	JTextField p1 = new JTextField(10), p2 = new JTextField(10), p3 = new JTextField(10), p4 = new JTextField(10), p5 = new JTextField(10), p6 = new JTextField(10), p7 = new JTextField(10), p8 = new JTextField(10);
	GridBagConstraints c = new GridBagConstraints();
	JButton export = new JButton("Export to CSV");
	JLabel question = new JLabel("Please Enter Team Names");
	JLabel teamA = new JLabel("Team A:"), teamB = new JLabel("Team B:");
	String modif;
	public ExportFrame(String modif){
		this.modif = modif;
		setTitle("Export to CSV");
		setSize(300,500);
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		setLayout(new GridBagLayout());
		c.fill = c.BOTH;
		c.gridy = 0;
			add(question,c);
		c.gridy = 2;
			add(teamA,c);
		c.gridy = 3;
			add(p1,c);
		c.gridy = 4;
			add(p2,c);
		c.gridy = 5;
			add(p3,c);
		c.gridy = 6;
			add(p4,c);
		c.gridy = 7;
			add(teamB,c);
		c.gridy = 8;
			add(p5,c);
		c.gridy = 9;
			add(p6,c);
		c.gridy = 10;
			add(p7,c);
		c.gridy = 11;
			add(p8,c);
		export.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				names[0] = p1.getText();
				names[1] = p2.getText();
				names[2] = p3.getText();
				names[3] = p4.getText();
				names[4] = p5.getText();
				names[5] = p6.getText();
				names[6] = p7.getText();
				names[7] = p8.getText();
				for(int i = 0; i < names.length; i++)
					if(names[i].equals(""))
						names[i] = "P"+Integer.toString(i+1);
				CSVWriter.setUp(modif,names);
				CSVWriter.createCSV();
				createMessage();
				dispose();
			}
		});
		c.gridy = 12;
			add(export,c);
	}
	public void createMessage(){
		JFrame message = new JFrame();
		GridBagConstraints c = new GridBagConstraints();
		message.setSize(750,100);
		message.setLocationRelativeTo(ScienceBowlClock.ScoreGUI);
		message.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		message.setLayout(new GridBagLayout());
		message.isAlwaysOnTop();
		c.gridy = 0;
		message.add(new JLabel("CSV are outputted to: "+CSVWriter.getPath()),c);
		JButton OK = new JButton("OK");
		OK.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				message.dispose();
			}
		});
		c.gridy = 1;
		message.add(OK,c);
		message.setVisible(true);
	}
}
