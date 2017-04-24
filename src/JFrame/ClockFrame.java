package JFrame;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Executable.ScienceBowlClock;

public class ClockFrame extends JFrame{
	private JPanel overallPanel,clockPanel, overallTimePanel, tossUpTimePanel, bonusTimePanel, buttonPanel, auxButtonPanel;
	private JPanel qNa;
	private JButton startTimer, stopTimer, startTossUpTimer, stopTossUpTimer, startBonusTimer, stopBonusTimer, resetTimer, addTime, subtractTime, preferences;
	private JButton showScore;
	private JButton showQuestions, showAnswer;
	private ButtonListener buttonListener;
	private JLabel overallTime, tossUpTime, bonusTime;
	private GroupLayout overallGrid, clockGrid;
	String overallTimes, tossUpTimes, bonusTimes;
	GridBagConstraints c;
	public ClockFrame() {
		//Sets up the frame
		setTitle("Science Bowl Clock");
		setSize(750,500);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
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
		overallTimePanel.setBackground(new Color(255,255,0));
		tossUpTime = new JLabel();
		tossUpTimes = "08";
		tossUpTime.setText(tossUpTimes);
		tossUpTimePanel = new JPanel();
		tossUpTimePanel.setLayout(new GridBagLayout());
		tossUpTimePanel.add(tossUpTime);
		tossUpTimePanel.setBackground(new Color(255,0,0));
		bonusTime = new JLabel();
		bonusTimes = "20";
		bonusTime.setText(bonusTimes);
		bonusTimePanel = new JPanel();
		bonusTimePanel.setLayout(new GridBagLayout());
		bonusTimePanel.add(bonusTime);
		bonusTimePanel.setBackground(new Color(0,0,255));
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
		stopTossUpTimer = new JButton("Reset Toss Up");
		startBonusTimer = new JButton("Start Bonus");
		stopBonusTimer = new JButton("Reset Bonus");
		buttonPanel.add(startTimer);
		buttonPanel.add(stopTimer);
		buttonPanel.add(startTossUpTimer);
		buttonPanel.add(stopTossUpTimer);
		buttonPanel.add(startBonusTimer);
		buttonPanel.add(stopBonusTimer);
		//Second Layer of buttons
		auxButtonPanel = new JPanel();
		resetTimer = new JButton("Reset Timer");
		addTime = new JButton("Add More Time");
		subtractTime = new JButton("Subtract Time");
		showScore = new JButton("Show Scoreboard");
		//Add secondary buttons to panel
		auxButtonPanel.add(resetTimer);
		auxButtonPanel.add(addTime);
		auxButtonPanel.add(subtractTime);
		auxButtonPanel.add(showScore);
		//Button Listeners
		buttonListener = new ButtonListener();
		startTimer.addActionListener(buttonListener);
		stopTimer.addActionListener(buttonListener);
		startTossUpTimer.addActionListener(buttonListener);
		stopTossUpTimer.addActionListener(buttonListener);
		startBonusTimer.addActionListener(buttonListener);
		stopBonusTimer.addActionListener(buttonListener);
		//Second Layer Button Listener
		resetTimer.addActionListener(buttonListener);
		addTime.addActionListener(buttonListener);
		subtractTime.addActionListener(buttonListener);
		showScore.addActionListener(buttonListener);
		//The overall interface panel
		overallPanel = new JPanel(new GridBagLayout());
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weighty = 0.6;
		c.gridx = 0;
		c.gridy = 0;
		overallPanel.add(clockPanel, c);
		c.weighty = 0.3;
		c.gridy = 1;
		buttonPanel.setLayout(new GridBagLayout());
		overallPanel.add(buttonPanel, c);
		c.weighty = 0.1;
		c.gridy = 2;
		overallPanel.add(auxButtonPanel,c);
		c.weighty = 0.05;
		c.gridy = 3;
		qNa = new JPanel(new GridBagLayout());
		showQuestions = new JButton("Show Question Board");
			showQuestions.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if(e.getActionCommand().equals("Hide Question Board")){
						ScienceBowlClock.QuestionBoard.setVisible(false);
						showQuestions.setText("Show Question Board");
					}
					else{
						ScienceBowlClock.QuestionBoard.setVisible(true);
						showQuestions.setText("Hide Question Board");
					}
					
				}
				
			});
			qNa.add(showQuestions);
		showAnswer = new JButton("Show Answer Board");
			showAnswer.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(e.getActionCommand().equals("Hide Answer Board")){
						ScienceBowlClock.AnswerBoard.setVisible(false);
						showAnswer.setText("Show Answer Board");
					}
					else{
						ScienceBowlClock.AnswerBoard.setVisible(true);
						showAnswer.setText("Hide Answer Board");
					}
				}
			});
			qNa.add(showAnswer);
		overallPanel.add(qNa,c);
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
	public void isShowScoreButton(boolean isShow){
		if(isShow){
			showScore.setActionCommand("Show Scoreboard");
			showScore.setText("Show Scoreboard");
		}
		else{
			showScore.setActionCommand("Hide Scoreboard");
			showScore.setText("Hide Scoreboard");
		}
	}
}
