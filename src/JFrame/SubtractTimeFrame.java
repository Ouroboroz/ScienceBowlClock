package JFrame;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import Clock.Clock;
import Clock.ClockCase;
public class SubtractTimeFrame extends JFrame {
	private JLabel addTime;
	private JTextField inputTime;
	private JButton submit;
	private JComboBox<ClockCase> dropDown;
	private	ClockCase[] dropDownChoices = {ClockCase.OVERALL, ClockCase.TOSSUP, ClockCase.BONUS};
	GridBagConstraints c;
	public SubtractTimeFrame(){
		setTitle("Add Time");
		setSize(300,200);
		setMaximumSize(new Dimension(300,200));
		setMinimumSize(new Dimension(300,200));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		submit = new JButton("Apply");
		addTime = new JLabel();
		addTime.setText("Remove Time");
		inputTime = new JTextField(20);
		dropDown = new JComboBox<ClockCase>(dropDownChoices);
		dropDown.setSelectedIndex(0);
		submit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				try{
					Clock.incrementTime(-Integer.parseInt(inputTime.getText()), dropDownChoices[dropDown.getSelectedIndex()]);
				}catch(Exception e){}
				Clock.updateGUI();
				dispose();
			}
		});
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.weighty = 0.6;
		c.gridx = 0;
		c.gridy = 0;
		add(addTime,c);
		c.gridy = 1;
		add(inputTime,c);
		c.gridy = 2;
		add(dropDown, c);
		c.weighty = 0.3;
		c.gridy = 3;
		add(submit,c);
	}
}
