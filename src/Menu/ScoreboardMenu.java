package Menu;

import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class ScoreboardMenu extends JMenuBar {
	JMenu file, scoreboard;
	JMenuItem hide;
	MenuListener menuLis;
	public ScoreboardMenu(){
		menuLis = new MenuListener();
		file = new JMenu("File");
		scoreboard = new JMenu("Scoreboard");
			hide = new JMenuItem("Hide Scoreboard");
			hide.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
			hide.addActionListener(menuLis);
		add(file);
		add(scoreboard);
		scoreboard.add(hide);
	}
}
