package Clock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CountdownPerformer implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent evt) {
		if(Clock.getMode() == ClockCase.OVERALL && Clock.isOverall() == false)
			Clock.stopCountdown();
		else{
			switch(Clock.getMode()){
			case OVERALL:
				if(Clock.isOverall() && Clock.getOverallTime()[0] + Clock.getOverallTime()[1] != 0)
					Clock.decreaseOverall();
				break;
			case TOSSUP:
				if(Clock.isOverall())
					Clock.decreaseOverall();
				Clock.decreaseTossUp();
				break;
			case BONUS:
				if(Clock.isOverall())
					Clock.decreaseOverall();
				Clock.decreaseBonus();
				break;
			}
			Clock.updateGUI();
		}
	}
	
}
