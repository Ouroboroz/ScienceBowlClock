package JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Clock.Clock;
import Clock.ClockCase;
import Executable.ScienceBowlClock;
import Scoreboard.Scoreboard;
import Scoreboard.Team;

public class ButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String source = e.getActionCommand();
		if(source.equals("Add Toss Up For A")){
				Scoreboard.addDist(1,0,Team.A);
				ScienceBowlClock.ScoreGUI.updateA();
		}
		else if(source.equals("Add Bonus For A")){
				Scoreboard.addDist(0, 1, Team.A);
				ScienceBowlClock.ScoreGUI.updateA();
		}
		else if(source.equals("Add Toss Up For B")){
				Scoreboard.addDist(1, 0, Team.B);
				ScienceBowlClock.ScoreGUI.updateB();
		}
		else if(source.equals("Add Bonus For B")){
				Scoreboard.addDist(0, 1, Team.B);
				ScienceBowlClock.ScoreGUI.updateB();
		}
		else if(source.equals("Subtract Points"))
				new SubtractPointsFrame().setVisible(true);
		else if(source.equals("Reset")){
				Scoreboard.reset();
				ScienceBowlClock.ScoreGUI.updateOverall();
		}
		
	}

}
