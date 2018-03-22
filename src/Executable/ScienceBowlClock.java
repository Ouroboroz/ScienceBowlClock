package Executable;

import JFrame.ClockFrame;
import JFrame.ScoreFrame;
import Scoreboard.Scoreboard;
  
public class ScienceBowlClock {
	public static ClockFrame GUI;
	public static ScoreFrame ScoreGUI;
	//public static ClockFrameOld newGUI;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUI = new ClockFrame();
		GUI.setVisible(true);
		//newGUI = new ClockFrameOld();
		//newGUI.setVisible(true);
		Scoreboard.initScoreboard();
		ScoreGUI = new ScoreFrame();
		ScoreGUI.setLocationRelativeTo(GUI);
	}
}