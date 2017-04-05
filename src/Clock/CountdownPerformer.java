package Clock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CountdownPerformer implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent evt) {
		switch(Clock.getMode()){
		case OVERALL:
			Clock.decreaseOverall();
			break;
		case TOSSUP:
			Clock.decreaseOverall();
			Clock.decreaseTossUp();
			break;
		case BONUS:
			Clock.decreaseOverall();
			Clock.decreaseBonus();
			break;
		}
	}
	
}
