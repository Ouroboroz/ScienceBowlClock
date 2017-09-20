package Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Clock.Clock;
import Clock.ClockCase;
import Executable.ScienceBowlClock;
import JFrame.AddTimeFrame;
import JFrame.SubtractTimeFrame;
public class MenuListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String source = e.getActionCommand();
		if(source.equals("Start Overall Time"))
			Clock.startCountdown();
		else if(source.equals("Stop Overall Time"))
				Clock.stopCountdown();
		else if(source.equals("Start Toss Up Time"))
				Clock.setMode(ClockCase.TOSSUP);
		else if(source.equals("Stop Toss Up Time")){
				Clock.setMode(ClockCase.OVERALL);
				Clock.resetTossUp();}
		else if(source.equals("Start Bonus Time"))
				Clock.setMode(ClockCase.BONUS);
		else if(source.equals("Stop Bonus Time")){
				Clock.setMode(ClockCase.OVERALL);
				Clock.resetBonus();}
		else if(source.equals("Reset Overall Time")){
				Clock.resetClock();
				Clock.updateGUI();
		}
		else if(source.equals("Reset Toss Up Time")){
			Clock.resetTossUp();
			Clock.updateGUI();
		}
		else if(source.equals("Reset Bonus Time")){
			Clock.resetBonus();
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
		else if(source.equals("Add Time"))
				new AddTimeFrame().setVisible(true);
		else if(source.equals("Subtract Time"))
				new SubtractTimeFrame().setVisible(true);
			
	}

}
