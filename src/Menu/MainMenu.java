package Menu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

import Clock.Clock;
import Clock.ClockCase;
import Executable.ScienceBowlClock;

public class MainMenu extends JMenuBar{
	private JMenu file, startStop, changeTime, reset;
	//For the file menu
	private JMenuItem about;
	//For the starting and stopping
	private JMenu overallTimeM, tossUpTimeM, bonusTimeM;
		//For overallTime
		private JMenuItem startOT, stopOT;
		//For tossUpTime
		private JMenuItem startTT, stopTT;
		//For bonusTime
		private JMenuItem startBT, stopBT;
	//For the changeTime
	private JMenuItem addTimeM, subtractTimeM;
	//For the reset
	private JMenuItem oReset, tReset, bReset;
	private JMenu scoreboard;
		private JMenuItem showHide;
	private JToolBar toolbar;
	private JButton halftime;
	MenuListener menuLis;
	public MainMenu(){
		//Instantiate the MenuBar items
		menuLis = new MenuListener();
		file = new JMenu("File");
		startStop = new JMenu("Start/Stop Time");
		changeTime = new JMenu("Change Time");
		about = new JMenuItem("About");
			about.addActionListener(menuLis);
		overallTimeM = new JMenu("Overall Time");
		tossUpTimeM = new JMenu("Toss Up Time");
		bonusTimeM = new JMenu("Bonus Time");
			startOT = new JMenuItem("Start Overall Time");
				startOT.addActionListener(menuLis);
			stopOT = new JMenuItem("Stop Overall Time");
				stopOT.addActionListener(menuLis);
			startTT = new JMenuItem("Start Toss Up Time");
				startTT.addActionListener(menuLis);
			stopTT = new JMenuItem("Stop Toss Up Time");
				stopTT.addActionListener(menuLis);
			startBT = new JMenuItem("Start Bonus Time");
				startBT.addActionListener(menuLis);
			stopBT = new JMenuItem("Stop Bonus Time");
				stopBT.addActionListener(menuLis);
		addTimeM = new JMenuItem("Add Time");
			addTimeM.addActionListener(menuLis);
			addTimeM.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, KeyEvent.CTRL_DOWN_MASK));
		subtractTimeM = new JMenuItem("Subtract Time");
			subtractTimeM.addActionListener(menuLis);
			subtractTimeM.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, KeyEvent.CTRL_DOWN_MASK));
		reset = new JMenu("Reset");
		oReset = new JMenuItem("Reset Overall Time");
			oReset.addActionListener(menuLis);
		tReset = new JMenuItem("Reset Toss Up Time");
			tReset.addActionListener(menuLis);
		bReset = new JMenuItem("Reset Bonus Time");
			bReset.addActionListener(menuLis);
		scoreboard = new JMenu("Scoreboard");
			showHide = new JMenuItem("Show Scoreboard");
				showHide.addActionListener(menuLis);
			showHide.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
			toolbar = new JToolBar();
			toolbar.setFloatable(false);
		halftime = new JButton("Start Halftime");
			halftime.setBackground(new Color(0,126,0));
			halftime.setOpaque(false);
		halftime.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if("Start Halftime".equals(e.getActionCommand())){
					halftime.setText("Stop Halftime");
					halftime.setBackground(new Color(126,0,0));
					Clock.setMode(ClockCase.HALFTIME);
					ScienceBowlClock.GUI.setOverallPanelColor(new Color(0,255,255));
					Clock.resetClock();
					Clock.incrementTime(-360, ClockCase.OVERALL);
					Clock.updateGUI();
					Clock.startCountdown();
				}
				else{
					halftime.setText("Start Halftime");
					halftime.setBackground(new Color(0,126,0));
					Clock.setMode(ClockCase.OVERALL);
					Clock.stopCountdown();
					Clock.resetClock();
					Clock.updateGUI();
					ScienceBowlClock.GUI.setOverallPanelColor(new Color(255,255,0));
				}
			}
		});
		add(file);
			file.add(about);
		add(startStop);
			startStop.add(overallTimeM);
				overallTimeM.add(startOT);
				overallTimeM.add(stopOT);
			startStop.add(tossUpTimeM);
				bonusTimeM.add(startBT);
				bonusTimeM.add(stopBT);
			startStop.add(bonusTimeM);
				tossUpTimeM.add(startTT);
				tossUpTimeM.add(stopTT);
		add(changeTime);
			changeTime.add(addTimeM);
			changeTime.add(subtractTimeM);
		add(reset);
			reset.add(oReset);
			reset.add(tReset);
			reset.add(bReset);
		add(scoreboard);
			scoreboard.add(showHide);
		add(toolbar);
			toolbar.add(halftime);
	}
	public void changeShowHide(String text){
		showHide.setText(text);
	}
}
