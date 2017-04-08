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
		if(source.equals("Start Timer"))
			Clock.startCountdown();
		else if(source.equals("Pause Timer"))
				Clock.stopCountdown();
		else if(source.equals("Start Toss Up"))
				Clock.setMode(ClockCase.TOSSUP);
		else if(source.equals("Reset Toss Up")){
				Clock.setMode(ClockCase.OVERALL);
				Clock.resetTossUp();}
		else if(source.equals("Start Bonus"))
				Clock.setMode(ClockCase.BONUS);
		else if(source.equals("Reset Bonus")){
				Clock.setMode(ClockCase.OVERALL);
				Clock.resetBonus();}
		else if(source.equals("Reset Timer")){
				Clock.resetClock();
				Clock.updateGUI();
		}
		else if(source.equals("Show Scoreboard")){
			ScienceBowlClock.ScoreGUI.setVisible(true);
			ScienceBowlClock.GUI.isShowScoreButton(false);
		}
		else if(source.equals("Hide Scoreboard")){
			ScienceBowlClock.ScoreGUI.setVisible(false);
			ScienceBowlClock.GUI.isShowScoreButton(true);
		}
		else if(source.equals("Add More Time"))
				new AddTimeFrame().setVisible(true);
		else if(source.equals("Subtract Time"))
				new SubtractTimeFrame().setVisible(true);
		else if(source.equals("Add Toss Up For A")){
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
