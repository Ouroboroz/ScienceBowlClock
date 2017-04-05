package Clock;
import javax.swing.Timer;

import Executable.ScienceBowlClock;

public class Clock {
	public static Timer timer = new Timer(1000, new CountdownPerformer());
	private static final int overallTimeStart = 15, tossUpTimeStart = 8, bonusTimeStart = 20;
	private static int[] overallTime = {15,0}; //[minute, second]
	private static int tossUpTime = 8, bonusTime = 20; //8, 20
	private static ClockCase mode = ClockCase.OVERALL;
	public Clock(){
		mode = ClockCase.OVERALL;
	}
	public static void updateGUI(){
		ScienceBowlClock.GUI.updateTimes(overallTime, tossUpTime, bonusTime);
	}
	public static void setMode(ClockCase mod){
		mode = mod;
	}
	public static void startCountdown(){
		timer.start();
	}
	public static void stopCountdown(){
		timer.stop();
	}
	public static void decreaseOverall(){
		int totSec = overallTime[0]*60+overallTime[1];
		totSec--;
		overallTime[0] = totSec/60;
		overallTime[1] = totSec%60;
		if(totSec == 0){
			stopCountdown();
			mode = ClockCase.OVERALL;
		}
	}
	public static void decreaseTossUp(){
		tossUpTime--;
		if(tossUpTime == 0){
			mode = ClockCase.OVERALL;
			tossUpTime = tossUpTimeStart;
		}
	}
	public static void decreaseBonus(){
		bonusTime--;
		if(bonusTime == 0){
			mode = ClockCase.OVERALL;
			bonusTime = bonusTimeStart;
		}
	}
	public static void resetClock(){
		overallTime[0] = overallTimeStart;
		tossUpTime = tossUpTimeStart;
		bonusTime = bonusTimeStart;
	}
	public static void resetTossUp(){
		tossUpTime = tossUpTimeStart;
	}
	public static void resetBonus(){
		bonusTime = bonusTimeStart;
	}
	public static void incrementTime(int secs, ClockCase mod){
		int totSecs = overallTime[0]*60+overallTime[1];
		switch(mod){
			case OVERALL:
				if(secs < totSecs){
					totSecs += secs;
					overallTime[0] = totSecs/60;
					overallTime[1] = totSecs%60;
				}
				break;
			case TOSSUP:
				if(secs < tossUpTime){
					tossUpTime += secs;
				}
				break;
			case BONUS:
				if(secs < bonusTime){
					bonusTime += secs;
				}
				break;
		}
	}
	
	//Getters
	public static int[] getOverallTime(){
		return overallTime;
	}
	public static int getTossUpTime(){
		return tossUpTime;
	}
	public static int getBonusTime(){
		return bonusTime;
	}
	public static ClockCase getMode(){
		return mode;
	}
}
