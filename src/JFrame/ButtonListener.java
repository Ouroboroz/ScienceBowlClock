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
		else if(source.equals("Stop Toss Up")){
				Clock.setMode(ClockCase.OVERALL);
				Clock.resetTossUp();}
		else if(source.equals("Start Bonus"))
				Clock.setMode(ClockCase.BONUS);
		else if(source.equals("Stop Bonus")){
				Clock.setMode(ClockCase.OVERALL);
				Clock.resetBonus();}
		
	}

}
