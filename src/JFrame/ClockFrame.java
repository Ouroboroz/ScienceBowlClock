package JFrame;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClockFrame extends JFrame{
	private JPanel overallPanel,clockPanel, overallTimePanel, tossUpTimePanel, bonusTimePanel, buttonPanel;
	private JButton startTimer, stopTimer, startTossUpTimer, stopTossUpTimer, startBonusTimer, stopBonusTimer;
	private ButtonListener buttonListener;
	private JLabel overallTime, tossUpTime, bonusTime;
	private GroupLayout overallGrid, clockGrid;
	String overallTimes, tossUpTimes, bonusTimes;
	GridBagConstraints c;
	public ClockFrame() {
		//Sets up the frame
		setTitle("Science Bowl Clock");
		setSize(800,500);
		setMaximumSize(new Dimension(800,500));
		setMinimumSize(new Dimension(800,500));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		//Creates the panel to hold the times
		clockPanel = new JPanel();
		//Creates the time labels
		overallTime = new JLabel();
		overallTimes = "15:00";
		overallTime.setText(overallTimes);
		overallTimePanel = new JPanel();
		overallTimePanel.setLayout(new GridBagLayout());
		overallTimePanel.add(overallTime);
		overallTimePanel.setBackground(new Color(0,50,50));
		tossUpTime = new JLabel();
		tossUpTimes = "08";
		tossUpTime.setText(tossUpTimes);
		tossUpTimePanel = new JPanel();
		tossUpTimePanel.setLayout(new GridBagLayout());
		tossUpTimePanel.add(tossUpTime);
		tossUpTimePanel.setBackground(new Color(0,100,123));
		bonusTime = new JLabel();
		bonusTimes = "20";
		bonusTime.setText(bonusTimes);
		bonusTimePanel = new JPanel();
		bonusTimePanel.setLayout(new GridBagLayout());
		bonusTimePanel.add(bonusTime);
		bonusTimePanel.setBackground(new Color(0,123,100));
		//Sets up the fonts
		overallTime.setFont(new Font("SansSerif",Font.PLAIN,100));
		tossUpTime.setFont(new Font("SansSerif",Font.PLAIN,50));
		bonusTime.setFont(new Font("SansSerif",Font.PLAIN,50));
		//The grid that holds the times 
		clockGrid = new GroupLayout(clockPanel);
		clockPanel.setLayout(clockGrid);
		clockGrid.setAutoCreateGaps(true);
		clockGrid.setAutoCreateContainerGaps(true);
		//Adds a group within the grid
		//Sets up the horizontal layout
		clockGrid.setHorizontalGroup(clockGrid.createSequentialGroup()
					.addComponent(overallTimePanel)
					.addGroup(clockGrid.createParallelGroup(GroupLayout.Alignment.CENTER)
							.addComponent(tossUpTimePanel)
							.addComponent(bonusTimePanel) )
		);
		//Sets up the vertical layout
		clockGrid.setVerticalGroup(clockGrid.createSequentialGroup()
				.addGroup(clockGrid.createParallelGroup(GroupLayout.Alignment.CENTER)
						.addComponent(overallTimePanel)
						.addGroup(clockGrid.createSequentialGroup()
								.addComponent(tossUpTimePanel)
								.addComponent(bonusTimePanel) ) 
				)	
		);
		buttonPanel = new JPanel();
		//Adds Buttons
		startTimer = new JButton("Start Timer");
		stopTimer = new JButton("Pause Timer");
		startTossUpTimer = new JButton("Start Toss Up");
		stopTossUpTimer = new JButton("Stop Toss Up");
		startBonusTimer = new JButton("Start Bonus");
		stopBonusTimer = new JButton("Stop Bonus");
		buttonPanel.add(startTimer);
		buttonPanel.add(stopTimer);
		buttonPanel.add(startTossUpTimer);
		buttonPanel.add(stopTossUpTimer);
		buttonPanel.add(startBonusTimer);
		buttonPanel.add(stopBonusTimer);
		//Button Listeners
		buttonListener = new ButtonListener();
		startTimer.addActionListener(buttonListener);
		stopTimer.addActionListener(buttonListener);
		startTossUpTimer.addActionListener(buttonListener);
		stopTossUpTimer.addActionListener(buttonListener);
		startBonusTimer.addActionListener(buttonListener);
		stopBonusTimer.addActionListener(buttonListener);
		//The overall interface panel
		overallPanel = new JPanel(new GridBagLayout());
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weighty = 0.6;
		c.gridx = 0;
		c.gridy = 0;
		overallPanel.add(clockPanel, c);
		c.weighty = 0.4;
		c.gridy = 1;
		overallPanel.add(buttonPanel, c);
		add(overallPanel);
	}
	public void updateTimes(int[] timeO, int timeT, int timeB){
		int minute, second, tossUp, bonus;
		minute = timeO[0];
		second = timeO[1];
		tossUp = timeT;
		bonus = timeB;
		overallTimes = String.format("%02d:%02d", minute,second);
		tossUpTimes = String.format("%02d", tossUp);
		bonusTimes = String.format("%02d", bonus);
		overallTime.setText(overallTimes);
		tossUpTime.setText(tossUpTimes);
		bonusTime.setText(bonusTimes);
	}
}
