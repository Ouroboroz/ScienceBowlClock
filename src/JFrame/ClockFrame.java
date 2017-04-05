package JFrame;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClockFrame extends JFrame{
	private JPanel clockPanel, overallTimePanel, tossUpTimePanel, bonusTimePanel;
	private JButton startTimer, stopTimer, startTossUpTimer, stopTossUpTimer, startBonusTimer, stopBonusTimer;
	private JLabel overallTime, tossUpTime, bonusTime;
	private GroupLayout clockGrid;
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
		overallTime.setText("00:00");
		overallTimePanel = new JPanel();
		overallTimePanel.setLayout(new GridBagLayout());
		overallTimePanel.add(overallTime);
		overallTimePanel.setBackground(new Color(0,50,50));
		tossUpTime = new JLabel();
		tossUpTime.setText("00");
		tossUpTimePanel = new JPanel();
		tossUpTimePanel.setLayout(new GridBagLayout());
		tossUpTimePanel.add(tossUpTime);
		tossUpTimePanel.setBackground(new Color(0,100,123));
		bonusTime = new JLabel();
		bonusTime.setText("00");
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
		//Adds Buttons
		startTimer = new JButton("Start Timer");
		stopTimer = new JButton("Pause Timer");
		startTossUpTimer = new JButton("Start Toss Up");
		stopTossUpTimer = new JButton("Stop Toss Up");
		startBonusTimer = new JButton("Start Bonus");
		stopBonusTimer = new JButton("Stop Bonus");
		//Add the panel
		add(clockPanel);
	}
}
