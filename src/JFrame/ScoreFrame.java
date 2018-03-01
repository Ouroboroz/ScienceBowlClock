package JFrame;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class ScoreFrame extends JFrame {
	private int[][] scoreList = new int[25][8];
	JFrame breakdownFrame = new JFrame();
	JScrollPane breakdownPane = new JScrollPane(breakdownFrame);
	public ScoreFrame(){
		
	}
}
