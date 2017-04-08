package Scoreboard;

import Clock.ClockCase;

public class Scoreboard {
	private static int[] teamADist = {0,0}, teamBDist = {0,0}; //{toss up, bonus}
	private static int teamA = 0, teamB = 0;
	public Scoreboard(){
	}
	public static void addDist(int t, int b, Team team){
		switch(team){
			case A:
				teamADist[0] += t;
				teamADist[1] += b;
				break;
			case B:
				teamBDist[0] += t;
				teamBDist[1] += b;
				break;
		}
		if(teamADist[0] < 0)
			teamADist[0] = 0;
		if(teamADist[1] < 0)
			teamADist[1] = 0;
		if(teamBDist[0] < 0)
			teamBDist[0] = 0;
		if(teamBDist[1] < 0)
			teamBDist[1] = 0;
		updateTotal();
	}
	public static void addDist(int p, Team team, ClockCase kase){
		switch(kase){
			case TOSSUP:
				addDist(-p, 0, team);
				break;
			case BONUS:
				addDist(0, -p, team);
				break;
		}
	}
	public static void updateTotal(){
		teamA = teamADist[0]*4+teamADist[1]*10;
		teamB = teamBDist[0]*4+teamBDist[1]*10;
	}
	public static int getA(){
		return teamA;
	}
	public static int getB(){
		return teamB;
	}
	public static int[] getADist(){
		return teamADist;
	}
	public static int[] getBDist(){
		return teamBDist;
	}
	public static void reset(){
		teamADist[0] = 0;
		teamADist[1] = 0;
		teamBDist[0] = 0;
		teamBDist[1] = 0;
		teamA = 0;
		teamB = 0;
		updateTotal();
	}
}
