package Executable;

import AnswerBoard.AnswerBoard;
import JFrame.ClockFrame;
import JFrame.ScoreFrame;
import QuestionBoard.QuestionBoard;
  
public class ScienceBowlClock {
	public static ClockFrame GUI;
	public static ScoreFrame ScoreGUI;
	public static QuestionBoard QuestionBoard;
	public static AnswerBoard AnswerBoard;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUI = new ClockFrame();
		GUI.setVisible(true);
		ScoreGUI = new ScoreFrame();
		QuestionBoard = new QuestionBoard();
		AnswerBoard = new AnswerBoard();
		
		ScoreGUI.setLocationRelativeTo(GUI);
	}
}