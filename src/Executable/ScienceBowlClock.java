package Executable;

import JFrame.ClockFrame;
import JFrame.ScoreFrame;
import Scoreboard.Scoreboard;
  
public class ScienceBowlClock 
{
	public static ClockFrame GUI;
	public static ScoreFrame ScoreGUI;
	
	public static void main(String[] args) 
	{
		GUI = new ClockFrame();
		GUI.setVisible(true);
		Scoreboard.initScoreboard();
		ScoreGUI = new ScoreFrame();
		ScoreGUI.setLocationRelativeTo(GUI);
	}
}
