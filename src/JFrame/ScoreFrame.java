package JFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Executable.ScienceBowlClock;
import Menu.ScoreboardMenu;
import Scoreboard.Scoreboard;

public class ScoreFrame extends JFrame {
	JLabel teamA, teamB, teamATossUp, teamABonus, teamBTossUp, teamBBonus;
	JPanel overallPanel, aPanel, bPanel, aTUPanel, aBPanel, bTUPanel, bBPanel;
	JButton addATossUp, addABonus, addBTossUp, addBBonus, subtract, reset;
	JPanel addAB, addAT, addBT, addBB, sub, resetPanel;
	ButtonListener buttonListener;
	GridBagConstraints c;
	ScoreboardMenu scoreMenu;
	public ScoreFrame(){
		//Sets up the frame itself
		setTitle("Score Board");
		setSize(750,300);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(ScienceBowlClock.GUI);
		scoreMenu = new ScoreboardMenu();
		setJMenuBar(scoreMenu);
		buttonListener = new ButtonListener();
		//Layout constant
		c = new GridBagConstraints();
		//Sets up the labels
		teamA = new JLabel(""+Scoreboard.getA());
			teamA.setFont(new Font("SansSerif",Font.PLAIN,35));
		teamB = new JLabel(""+Scoreboard.getB());
			teamB.setFont(new Font("SansSerif",Font.PLAIN,35));
		teamATossUp = new JLabel(""+Scoreboard.getADist()[0]);
		teamABonus = new JLabel(""+Scoreboard.getADist()[1]);
		teamBTossUp = new JLabel(""+Scoreboard.getBDist()[0]);
		teamBBonus = new JLabel(""+Scoreboard.getBDist()[1]);
		//Sets all the panels to GridBagLayout
		overallPanel = new JPanel();
		aPanel = new JPanel();
			aPanel.setBackground(new Color(0,0,255));
		bPanel = new JPanel();
			bPanel.setBackground(new Color(255,0,0));
		aTUPanel = new JPanel();
		aBPanel = new JPanel();
		bTUPanel = new JPanel();
		bBPanel = new JPanel();
		//Sets up overall Panel
		overallPanel.setLayout(new GridBagLayout());
		//Score Panels
		aPanel.setLayout(new GridBagLayout());
		aPanel.add(teamA);
		bPanel.setLayout(new GridBagLayout());
		bPanel.add(teamB);
		aTUPanel.setLayout(new GridBagLayout());
		aTUPanel.add(teamATossUp);
		aBPanel.setLayout(new GridBagLayout());
		aBPanel.add(teamABonus);
		bTUPanel.setLayout(new GridBagLayout());
		bTUPanel.add(teamBTossUp);
		bBPanel.setLayout(new GridBagLayout());
		bBPanel.add(teamBBonus);
		//Buttons
		addATossUp = new JButton("Add Toss Up For A");
			addATossUp.addActionListener(buttonListener);
		addABonus = new JButton("Add Bonus For A");
			addABonus.addActionListener(buttonListener);
		addBTossUp = new JButton("Add Toss Up For B");
			addBTossUp.addActionListener(buttonListener);
		addBBonus = new JButton("Add Bonus For B");
			addBBonus.addActionListener(buttonListener);
		subtract = new JButton("Subtract Points");
			subtract.addActionListener(buttonListener);
		reset = new JButton("Reset");
			reset.addActionListener(buttonListener);
		//Set up overall panel
		c.fill = GridBagConstraints.BOTH;
		c.gridwidth = 2;
		c.weightx = 0.6;
		c.weighty = 0.1;
		c.gridx = 0;
		c.gridy = 0;
		overallPanel.add(new JLabel("Overall A Score:"), c);
		c.gridx = 2;
		overallPanel.add(new JLabel("Overall B Score:"), c);
		c.gridx = 0;
		c.gridy = 1;
		c.weighty = 0.7;
		overallPanel.add(aPanel, c);
		c.gridx = 2;
		overallPanel.add(bPanel, c);
		c.gridx = 0;
		c.gridy = 2;
		c.weighty = 0.1;
		c.weightx = 0.2;
		c.gridwidth = 1; //CHECK
		overallPanel.add(new JLabel("A Bonus:"), c);
		c.gridx = 1;
		overallPanel.add(new  JLabel("A Toss Up: "), c);
		c.gridx = 2;
		overallPanel.add(new JLabel("B Toss Up:"), c);
		c.gridx = 3;
		overallPanel.add(new JLabel("B Bonus:"), c);
		c.gridx = 0;
		c.gridy = 3;
		c.weighty = 0.3;
		c.gridx = 0;
		overallPanel.add(aBPanel, c);
		c.gridx++;
		overallPanel.add(aTUPanel, c);
		c.gridx++;
		overallPanel.add(bTUPanel, c);
		c.gridx++;
		overallPanel.add(bBPanel, c);
		c.gridx = 0;
		c.gridy++;
		addAB = new JPanel();
			addAB.add(addABonus);
		overallPanel.add(addAB,c);
		c.gridx++;
		addAT = new JPanel();
			addAT.add(addATossUp);
		overallPanel.add(addAT,c);
		addBT = new JPanel();
			addBT.add(addBTossUp);
		c.gridx++;
		overallPanel.add(addBT,c);
		addBB = new JPanel();
			addBB.add(addBBonus);
		c.gridx++;
		overallPanel.add(addBB,c);
		c.gridy++;
		c.gridx = 0;
		sub = new JPanel();
			sub.add(subtract);
		overallPanel.add(sub,c);
		resetPanel = new JPanel();
			resetPanel.add(reset);
		c.gridx = 3;
		overallPanel.add(resetPanel,c);
		add(overallPanel);
	}
	public void updateA(){
		teamA.setText(""+Scoreboard.getA());
		teamATossUp.setText(""+Scoreboard.getADist()[0]);
		teamABonus.setText(""+Scoreboard.getADist()[1]);
	}
	public void updateB(){
		teamB.setText(""+Scoreboard.getB());
		teamBTossUp.setText(""+Scoreboard.getBDist()[0]);
		teamBBonus.setText(""+Scoreboard.getBDist()[1]);
	}
	public void updateOverall(){
		updateA();
		updateB();
	}
}
