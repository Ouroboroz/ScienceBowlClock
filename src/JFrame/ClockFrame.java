package JFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import Clock.Clock;
import Clock.ClockCase;
import Executable.ScienceBowlClock;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Menu.MainMenu;

public class ClockFrame extends JFrame{
	MainMenu mainMenu;
	JLabel overallTime, tossUpTime, bonusTime;
	String overallTimes, tossUpTimes, bonusTimes;
	JPanel clockPanel, overallTimePanel, tossUpTimePanel, bonusTimePanel;
	GroupLayout clockGrid;
	JButton showScore;
	ButtonListener buttonListener;
	GridBagConstraints c;
	int[] clickCount = {0,0,0};
	public ClockFrame(){
		//Creates name and frame settings
		setTitle("Science Bowl Clock");
		setSize(750, 500);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		//Sets up initial Click Counter
		//Sets up the menu and adds it on 
		mainMenu = new MainMenu();
		setJMenuBar(mainMenu);
		//Creates the panel for the overall time
		overallTime = new JLabel();
		overallTimes = "15:00";
		overallTime.setText(overallTimes);
		overallTimePanel = new JPanel();
		overallTimePanel.setLayout(new GridBagLayout());
		overallTimePanel.add(overallTime);
		overallTimePanel.setBackground(new Color(255,255,0));
		overallTimePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				incrementClick(0);
				if(clickCount[0] == 1)
					Clock.startCountdown();
				else
					Clock.stopCountdown();
			}
		});
		//Creates the panel for the toss up
		tossUpTime = new JLabel();
		tossUpTimes = "08";
		tossUpTime.setText(tossUpTimes);
		tossUpTimePanel = new JPanel();
		tossUpTimePanel.setLayout(new GridBagLayout());
		tossUpTimePanel.add(tossUpTime);
		tossUpTimePanel.setBackground(new Color(255,0,0));
		tossUpTimePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				incrementClick(1);
				if(clickCount[1] == 1)
					Clock.setMode(ClockCase.TOSSUP);
				else{
					Clock.setMode(ClockCase.OVERALL);
					Clock.resetTossUp();
				}
			}
		});
		//Creates the panel for the bonus
		bonusTime = new JLabel();
		bonusTimes = "20";
		bonusTime.setText(bonusTimes);
		bonusTimePanel = new JPanel();
		bonusTimePanel.setLayout(new GridBagLayout());
		bonusTimePanel.add(bonusTime);
		bonusTimePanel.setBackground(new Color(0,0,255));
		bonusTimePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				incrementClick(2);
				if(clickCount[2] == 1)
					Clock.setMode(ClockCase.BONUS);
				else{
					Clock.setMode(ClockCase.OVERALL);
					Clock.resetBonus();
				}
			}
		});
		//Sets up fonts
		overallTime.setFont(new Font("SansSerif",Font.PLAIN,100));
		tossUpTime.setFont(new Font("SansSerif",Font.PLAIN,50));
		bonusTime.setFont(new Font("SansSerif",Font.PLAIN,50));
		//Sets up the scoreboard button
		buttonListener = new ButtonListener();
		showScore = new JButton("Show Scoreboard");
		showScore.addActionListener(buttonListener);
		showScore.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  if(e.getActionCommand().equals("Show Scoreboard")){
						ScienceBowlClock.ScoreGUI.setVisible(true);
						isShowScoreButton(false);
					}
					else if(e.getActionCommand().equals("Hide Scoreboard")){
						ScienceBowlClock.ScoreGUI.setVisible(false);
						isShowScoreButton(true);
					}
				  } 
				} );
		//Sets the layout version of the frame
				clockPanel = new JPanel();
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
		//Add panels
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weighty = 0.8;
		c.weightx = 0.8;
		add(clockPanel, c);
		c.gridy = 1;
		c.weighty = 0.2;
		c.weightx = 0.2;
		add(showScore, c);
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
	public void isShowScoreButton(boolean isShow){
		if(isShow){
			showScore.setActionCommand("Show Scoreboard");
			showScore.setText("Show Scoreboard");
			mainMenu.changeShowHide("Show Scoreboard");
		}
		else{
			showScore.setActionCommand("Hide Scoreboard");
			showScore.setText("Hide Scoreboard");
			mainMenu.changeShowHide("Hide Scoreboard");
		}
	}
	public void incrementClick(int type){
		clickCount[type]++;
		if(clickCount[type] >= 2)
			clickCount[type] = 0;
	}
}
