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
import Executable.ScienceBowlClock;
import Scoreboard.Scoreboard;
import Scoreboard.Team;

public class SubtractPointsFrame extends JFrame {
	private JLabel subtractPoints;
	private JTextField inputPoints;
	private JButton submit;
	private JComboBox<Team> dropDownTeam;
	private	Team[] dropDownteamChoices = {Team.A, Team.B};
	private JComboBox<ClockCase> dropDownCase;
	private ClockCase[] dropDownCaseChoices = {ClockCase.TOSSUP, ClockCase.BONUS};
	GridBagConstraints c;
	public SubtractPointsFrame(){
		setTitle("Subtract Points");
		setSize(300,200);
		setMaximumSize(new Dimension(300,200));
		setMinimumSize(new Dimension(300,200));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		submit = new JButton("Apply");
		subtractPoints = new JLabel();
		subtractPoints.setText("Subtract Points");
		inputPoints = new JTextField(10);
		dropDownTeam = new JComboBox<Team>(dropDownteamChoices);
		dropDownTeam.setSelectedIndex(0);
		dropDownCase = new JComboBox<ClockCase>(dropDownCaseChoices);
		dropDownCase.setSelectedIndex(0);
		submit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				try{
					Scoreboard.addDist(Integer.parseInt(inputPoints.getText()), (Team)dropDownTeam.getSelectedItem(), (ClockCase)dropDownCase.getSelectedItem());
				}catch(Exception e){}
				Scoreboard.updateTotal();
				ScienceBowlClock.ScoreGUI.updateOverall();
				dispose();
			}
		});
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.weighty = 0.6;
		c.gridx = 0;
		c.gridy = 0;
		add(subtractPoints,c);
		c.gridy = 1;
		add(inputPoints,c);
		c.gridy = 2;
		add(dropDownTeam, c);
		c.gridy = 3;
		add(dropDownCase,c);
		c.weighty = 0.3;
		c.gridy = 4;
		add(submit,c);
	}
}
