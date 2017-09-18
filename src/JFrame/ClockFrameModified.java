package JFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import Menu.MainMenu;

public class ClockFrameModified extends JFrame{
	MainMenu mainMenu;
	JLabel overallTime, tossUpTime, bonusTime;
	String overallTimes, tossUpTimes, bonusTimes;
	JPanel overallTimePanel, tossUpTimePanel, bonusTimePanel;
	GroupLayout clockGrid;
	public ClockFrameModified(){
		//Creates name and frame settings
		setTitle("Science Bowl Clock");
		setSize(750, 500);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		//Sets up the menu and adds it on 
		mainMenu = new MainMenu();
		setJMenuBar(mainMenu);
		//Sets the layout version of the frame
		clockGrid = new GroupLayout(clockPanel);
		setLayout(clockGrid);
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
		//Creates the panel for the overall time
		overallTime = new JLabel();
		overallTimes = "15:00";
		overallTime.setText(overallTimes);
		overallTimePanel = new JPanel();
		overallTimePanel.setLayout(new GridBagLayout());
		overallTimePanel.add(overallTime);
		overallTimePanel.setBackground(new Color(255,255,0));
		//Creates the panel for the toss up
		tossUpTime = new JLabel();
		tossUpTimes = "08";
		tossUpTime.setText(tossUpTimes);
		tossUpTimePanel = new JPanel();
		tossUpTimePanel.setLayout(new GridBagLayout());
		tossUpTimePanel.add(tossUpTime);
		tossUpTimePanel.setBackground(new Color(255,0,0));
		//Creates the panel for the bonus
		bonusTime = new JLabel();
		bonusTimes = "20";
		bonusTime.setText(bonusTimes);
		bonusTimePanel = new JPanel();
		bonusTimePanel.setLayout(new GridBagLayout());
		bonusTimePanel.add(bonusTime);
		bonusTimePanel.setBackground(new Color(0,0,255));
		//Sets up fonts
		overallTime.setFont(new Font("SansSerif",Font.PLAIN,100));
		tossUpTime.setFont(new Font("SansSerif",Font.PLAIN,50));
		bonusTime.setFont(new Font("SansSerif",Font.PLAIN,50));
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
