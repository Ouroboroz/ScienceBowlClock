package JFrame;

import java.awt.Dimension;

import javax.swing.JFrame;

import Executable.ScienceBowlClock;

public class ScoreFrame extends JFrame {
	public ScoreFrame(){
		setTitle("Score Board");
		setSize(800,500);
		setMaximumSize(new Dimension(800,500));
		setMinimumSize(new Dimension(800,500));
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		setLocationRelativeTo(ScienceBowlClock.GUI);
	}
}
