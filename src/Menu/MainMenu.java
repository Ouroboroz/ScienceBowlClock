package Menu;

import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MainMenu extends JMenuBar{
	private JMenu file, startStop, changeTime, reset;
	//For the file menu
	private JMenuItem about, exit;
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
	public MainMenu(){
		//Instantiate the MenuBar items
		file = new JMenu("File");
		startStop = new JMenu("Start/Stop Time");
		changeTime = new JMenu("Change Time");
		about = new JMenuItem("About");
		exit = new JMenuItem("Exit");
				exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK));
		overallTimeM = new JMenu("Overall Time");
		tossUpTimeM = new JMenu("Toss Up Time");
		bonusTimeM = new JMenu("Bonus Time");
			startOT = new JMenuItem("Start Overall Time");
			stopOT = new JMenuItem("Stop Overall Time");
			startTT = new JMenuItem("Start Toss Up Time");
			stopTT = new JMenuItem("Stop Toss Up TIme");
			startBT = new JMenuItem("Start Bonus Time");
			stopBT = new JMenuItem("Stop Bonus Time");
		addTimeM = new JMenuItem("Add Time");
			addTimeM.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, KeyEvent.CTRL_DOWN_MASK));
		subtractTimeM = new JMenuItem("Subtract Time");
			subtractTimeM.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, KeyEvent.CTRL_DOWN_MASK));
		reset = new JMenu("Reset");
		oReset = new JMenuItem("Reset Overall Time");
		tReset = new JMenuItem("Reset Toss Up Time");
		bReset = new JMenuItem("Reset Bonus Time");
		add(file);
			file.add(about);
			file.add(exit);
		add(startStop);
			startStop.add(overallTimeM);
				overallTimeM.add(startOT);
				overallTimeM.add(stopOT);
			startStop.add(tossUpTimeM);
				bonusTimeM.add(startTT);
				bonusTimeM.add(stopTT);
			startStop.add(bonusTimeM);
				tossUpTimeM.add(startBT);
				tossUpTimeM.add(stopBT);
		add(changeTime);
			changeTime.add(addTimeM);
			changeTime.add(subtractTimeM);
		add(reset);
			reset.add(oReset);
			reset.add(tReset);
			reset.add(bReset);
	}
}
