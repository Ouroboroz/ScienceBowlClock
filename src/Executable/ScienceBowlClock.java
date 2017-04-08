package Executable;

import JFrame.ClockFrame;
import JFrame.ScoreFrame;

public class ScienceBowlClock {
	public static ClockFrame GUI;
	public static ScoreFrame ScoreGUI;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUI = new ClockFrame();
		GUI.setVisible(true);
		ScoreGUI = new ScoreFrame();
	}
}
