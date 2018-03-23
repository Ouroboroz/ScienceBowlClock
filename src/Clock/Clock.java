package Clock;
import java.awt.Color;

import javax.swing.Timer;

import Executable.ScienceBowlClock;
import Sound.SoundPlayer;

public class Clock {
	private static Timer timer = new Timer(1000, new CountdownPerformer());
	private static final int overallTimeStart = 8, tossUpTimeStart = 5, bonusTimeStart = 20;
	private static boolean isOverall = false;
	private static int[] overallTime = {8,0}; //[minute, second]
	private static int tossUpTime = 5, bonusTime = 20; //8, 20
	private static ClockCase mode = ClockCase.OVERALL;
	private static SoundPlayer soundPlayer = new SoundPlayer();
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
			isOverall = false;
			soundPlayer.playAudio();
		}
	}
	public static void decreaseHalftime(){
		int totSec = overallTime[0]*60+overallTime[1];
		totSec--;
		overallTime[0] = totSec/60;
		overallTime[1] = totSec%60;
		if(totSec == 0){
			isOverall = false;
			setMode(ClockCase.OVERALL);
			ScienceBowlClock.GUI.setOverallPanelColor(new Color(255,255,0));
			resetClock();
			soundPlayer.playAudio();
		}
	}
	public static void decreaseTossUp(){
		tossUpTime--;
		if(tossUpTime == 0){
			mode = ClockCase.OVERALL;
			tossUpTime = tossUpTimeStart;
			soundPlayer.playAudio();
			ScienceBowlClock.GUI.incrementClick(1);
		}
	}
	public static void decreaseBonus(){
		bonusTime--;
		if(bonusTime == 0){
			mode = ClockCase.OVERALL;
			bonusTime = bonusTimeStart;
			soundPlayer.playAudio();
			ScienceBowlClock.GUI.incrementClick(2);
		}
	}
	public static void resetClock(){
		stopCountdown();
		isOverall = false;
		overallTime[0] = overallTimeStart;
		overallTime[1] = 0;
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
					totSecs += secs;
					overallTime[0] = totSecs/60;
					overallTime[1] = totSecs%60;
				break;
			case TOSSUP:
					tossUpTime += secs;
				break;
			case BONUS:
					bonusTime += secs;
				break;
		}
	}
	//Setters
	public static boolean setIsOverall(boolean isTrue){
		isOverall = isTrue;
		return isOverall;
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
	public static boolean isOverall(){
		return isOverall;
	}
}
