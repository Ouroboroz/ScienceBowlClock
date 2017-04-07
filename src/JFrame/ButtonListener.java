package JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Clock.Clock;
import Clock.ClockCase;

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
		else if(source.equals("Add More Time"))
				new AddTimeFrame().setVisible(true);
		else if(source.equals("Subtract Time"))
				new SubtractTimeFrame().setVisible(true);
		
	}

}
