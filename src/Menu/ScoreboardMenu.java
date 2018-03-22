package Menu;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import Executable.ScienceBowlClock;
import FileWriter.CSVWriter;

public class ScoreboardMenu extends JMenuBar {
	JMenu file, scoreboard;
	JMenuItem hide, export, reset;
	MenuListener menuLis;
	public ScoreboardMenu(){
		menuLis = new MenuListener();
		file = new JMenu("File");
			export = new JMenuItem("Export to CSV");
			export.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK));
			export.addActionListener(menuLis);
			scoreboard = new JMenu("Scoreboard");
			hide = new JMenuItem("Hide Scoreboard");
			hide.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
			hide.addActionListener(menuLis);
			reset = new JMenuItem("Reset Scoreboard");
			reset.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK));
			reset.addActionListener(menuLis);
		add(file);
		file.add(export);
		add(scoreboard);
		scoreboard.add(hide);
		scoreboard.add(reset);
	}
}
